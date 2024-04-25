package com.engine.ItrackBackend.service;

import com.engine.ItrackBackend.enums.ComparisonTypes;
import com.engine.ItrackBackend.enums.Severity;
import com.engine.ItrackBackend.model.*;
import com.engine.ItrackBackend.model.dtos.MultiRuleDto;
import com.engine.ItrackBackend.model.dtos.RuleResponseDto;
import com.engine.ItrackBackend.model.dtos.SingleRuleDto;
import com.engine.ItrackBackend.model.dynamicParams.InwardTransactionsDynamicParams;
import com.engine.ItrackBackend.utils.Constants;

import lombok.RequiredArgsConstructor;
import org.bson.json.JsonObject;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class RuleService {
    @Autowired
    AccountService accountService;
    @Autowired
    BlacklistedProfileService blacklistedProfileService;
    @Autowired
    InwardProfileService inwardProfileService;
    @Autowired
    OutwardProfileService outwardProfileService;
    @Autowired
    WatchlistProfileService watchlistProfileService;
    @Autowired
    InwardTransactionService inwardTransactionService;

    @Autowired
    private final KieSession kieSession;




    public Map<String, Object> getTransactionFirstNonNullParameter(InwardTransactionsDynamicParams params) {
        Map<String, Object> parameterMap = new HashMap<>();

        for (Field field : InwardTransactionsDynamicParams.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(params);
                if (value != null) {
                    parameterMap.put(field.getName(), value);
                    return parameterMap;
                }
            } catch (IllegalAccessException e) {
                // Handle the exception according to your needs
                e.printStackTrace();
            }
        }

        // Handle the case where none of the parameters are non-null
        throw new IllegalArgumentException("At least one parameter must be non-null.");
    }
    public String createSingleRule(SingleRuleDto ruleDto){
        try {
            Severity level = Severity.valueOf(ruleDto.getSeverity());
            String generatedRule = null;
            String ruleName = (ruleDto.getRuleName() != null) ? ruleDto.getRuleName() : "Default";

            generatedRule = this.generateSingleRule(ruleName, ruleDto.getCollectionName(), ruleDto.getParamName(),ruleDto.getValue(),ruleDto.getComparisonType().getSymbol(),level);

            this.appendRuleToFile(Constants.DRL_FILE_PATH, generatedRule);
            return generatedRule;
        }catch (Exception e){
            throw new InternalError("Could not create Rule.",e.getCause());
        }
    }
    public String createMultiRule(MultiRuleDto multiRuleDto){
        try{
            Boolean ruleAction = null;
            JsonObject ruleActionJson = null;
            String generatedRule = null;
            Severity level = Severity.valueOf(multiRuleDto.getSeverity());

            String ruleName = (multiRuleDto.getRuleName() != null) ? multiRuleDto.getRuleName() : "Default";

            generatedRule = this.generateMultiRule(ruleName, multiRuleDto.getPrimaryCollectionName(), multiRuleDto.getPrimaryDynamicParam(),multiRuleDto.getSecondaryCollectionName(),multiRuleDto.getSecondaryDynamicParam(),multiRuleDto.getComparisonType().getSymbol(),level);

            this.appendRuleToFile(Constants.DRL_FILE_PATH, generatedRule);
            return generatedRule;

        }catch (Exception e){
            throw new InternalError("Couldn't create multi rule",e.getCause());
        }
    }
    public String generateSingleRule(String ruleName, String collectionName, String dynamicParam,List<String> values, String condition, Severity level) {
        StringBuilder ruleBuilder = new StringBuilder();
        ruleName = (ruleName != null) ? ruleName : "Default";

        ruleBuilder.append("rule \"").append(ruleName).append("\"\n");
        ruleBuilder.append("when\n");
        if(condition.equalsIgnoreCase(ComparisonTypes.MEMBER_OF.getSymbol())){
            ruleBuilder.append(collectionName).append(" : ").append(collectionName)
                    .append("(").append(dynamicParam).append(condition).append("[");

            // Append values from the list
            for (int i = 0; i < values.size(); i++) {
                ruleBuilder.append("\"").append(values.get(i)).append("\"");
                if (i < values.size() - 1) {
                    ruleBuilder.append(", ");
                }
            }

            ruleBuilder.append("])\n");
        }else {
            ruleBuilder.append(collectionName).append(" : ").append(collectionName).append("(dynamicParams.").append(dynamicParam).append(condition).append(values.get(0)).append(")\n");
        }
        ruleBuilder.append("flagFact : FlagFact();\n");
        ruleBuilder.append("then\n");
        ruleBuilder.append("     flagFact.setFlag(true);\n");
        ruleBuilder.append("     flagFact.setLevel(\"").append(level.getSeverity().toString()).append("\");\n");
        ruleBuilder.append("    update(flagFact);\n");
        ruleBuilder.append("end");
        ruleBuilder.append("\n\n");

        return ruleBuilder.toString();
    }
    public String generateMultiRule(String ruleName, String primaryCollection, String primaryParam, String secondaryCollection, String secondaryParam, String condition, Severity level) {
        StringBuilder ruleBuilder = new StringBuilder();
        ruleName = (ruleName != null) ? ruleName : "Default";

        ruleBuilder.append("rule \"").append(ruleName).append("\"\n");
        ruleBuilder.append("when\n");
        ruleBuilder.append("$").append(primaryCollection).append(" : ").append(primaryCollection).append("($").append(primaryParam).append(" : ").append("dynamicParams.").append(primaryParam).append(")\n");
        ruleBuilder.append("$").append(secondaryCollection).append(" : ").append(secondaryCollection).append("($").append(secondaryParam).append(" : ").append("dynamicParams.").append(secondaryParam).append(")\n");
        ruleBuilder.append("eval(").append("$").append(secondaryParam).append(condition).append(primaryParam).append(")\n");
        ruleBuilder.append("flagFact : FlagFact();\n");
        ruleBuilder.append("then\n");
        ruleBuilder.append("     flagFact.setFlag(true);\n");
        ruleBuilder.append("     flagFact.setLevel(").append(level.getSeverity()).append(");\n");
        ruleBuilder.append("end");
        ruleBuilder.append("\n\n");
        return ruleBuilder.toString();
    }
    public void appendRuleToFile(String filePath, String ruleToAdd) {
        try {
            // Read existing content from the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            reader.close();

            // Append the new rule
            fileContent.append(ruleToAdd).append("\n");

            // Write the updated content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(fileContent.toString());
            writer.close();

            System.out.println("Rule appended successfully to file: " + filePath);

        } catch (IOException e) {
            System.err.println("Error appending rule to file: " + e.getMessage());
        }
    }
//    public boolean fireRules(Long accountNo){
//        //kieSession.setGlobal("isTransactionFlagged", null);
//          // List of Inward Transactions
//        List<InwardTransaction> inwardTransactionList = inwardTransactionService.listInwardTransactionsByAccountNo(accountNo);
//        if (inwardTransactionList != null) {
//            for (InwardTransaction inwardTransaction : inwardTransactionList) {
//                if (inwardTransaction != null) {
//                    kieSession.insert(inwardTransaction);
//                }
//            }
//        }
//
////
////// List of Blacklisted Profiles
////        List<BlacklistedProfile> blacklistedProfiles = blacklistedProfileService.listBlacklistProfileByAccountNo(accountNo);
////        if (blacklistedProfiles != null) {
////            for (BlacklistedProfile blacklistedProfile : blacklistedProfiles) {
////                if (blacklistedProfile != null) {
////                    kieSession.insert(blacklistedProfile);
////                }
////            }
////        }
////
////// List of Watchlist Profiles
////        List<WatchlistProfile> watchlistProfiles = watchlistProfileService.listWatchlistProfileByAccountNo(accountNo);
////        if (watchlistProfiles != null) {
////            for (WatchlistProfile watchlistProfile : watchlistProfiles) {
////                if (watchlistProfile != null) {
////                    kieSession.insert(watchlistProfile);
////                }
////            }
////        }
////
////// List of Inward Profiles
////        List<InwardProfile> inwardProfiles = inwardProfileService.listInwardProfileByAccountNo(accountNo);
////        if (inwardProfiles != null) {
////            for (InwardProfile inwardProfile : inwardProfiles) {
////                if (inwardProfile != null) {
////                    kieSession.insert(inwardProfile);
////                }
////            }
////        }
////
////// List of Accounts
////        List<Account> accounts = accountService.listAccountByAccountNo(accountNo);
////        if (accounts != null) {
////            for (Account account : accounts) {
////                if (account != null) {
////                    kieSession.insert(account);
////                }
////            }
////        }
////
////// List of Outward Profiles
////        List<OutwardProfile> outwardProfiles = outwardProfileService.listOutwardProfileByAccountNo(accountNo);
////        if (outwardProfiles != null) {
////            for (OutwardProfile outwardProfile : outwardProfiles) {
////                if (outwardProfile != null) {
////                    kieSession.insert(outwardProfile);
////                }
////            }
////        }
//
//        System.out.println("Before firing rules - Updated facts in working memory:");
//        for (FactHandle factHandle : kieSession.getFactHandles()) {
//            Object fact = kieSession.getObject(factHandle);
//            System.out.println("Updated Fact: " + fact);
//        }
//        kieSession.fireAllRules();
//        System.out.println("After firing rules - Updated facts in working memory:");
//        for (FactHandle factHandle : kieSession.getFactHandles()) {
//            Object fact = kieSession.getObject(factHandle);
//            System.out.println("Updated Fact: " + fact);
//        }
//        Boolean isTransactionFlagged = (Boolean) kieSession.getGlobal("isTransactionFlagged");
//        return isTransactionFlagged;
//
//    }

    public RuleResponseDto fireRules(Long accountNo){
        RuleResponseDto ruleResponseDto = new RuleResponseDto();
        FlagFact isTransactionFlagged = new FlagFact(false);
        kieSession.insert(isTransactionFlagged); // Insert the FlagFact instance into the session

        List<InwardTransaction> inwardTransactionList = inwardTransactionService.listInwardTransactionsByAccountNo(accountNo);
        if (inwardTransactionList != null) {
            for (InwardTransaction inwardTransaction : inwardTransactionList) {
                if (inwardTransaction != null) {
                    inwardTransaction.getDynamicParams().setAmount(65555L);
                    kieSession.insert(inwardTransaction);
                }
            }
        }
        // List of Blacklisted Profiles
        List<BlacklistedProfile> blacklistedProfiles = blacklistedProfileService.listBlacklistProfileByAccountNo(accountNo);
        if (blacklistedProfiles != null) {
            for (BlacklistedProfile blacklistedProfile : blacklistedProfiles) {
                if (blacklistedProfile != null) {
                    kieSession.insert(blacklistedProfile);
                }
            }
        }

        // List of Watchlist Profiles
        List<WatchlistProfile> watchlistProfiles = watchlistProfileService.listWatchlistProfileByAccountNo(accountNo);
        if (watchlistProfiles != null) {
            for (WatchlistProfile watchlistProfile : watchlistProfiles) {
                if (watchlistProfile != null) {
                    kieSession.insert(watchlistProfile);
                }
            }
        }

        // List of Inward Profiles
        List<InwardProfile> inwardProfiles = inwardProfileService.listInwardProfileByAccountNo(accountNo);
        if (inwardProfiles != null) {
            for (InwardProfile inwardProfile : inwardProfiles) {
                if (inwardProfile != null) {
                    kieSession.insert(inwardProfile);
                }
            }
        }

        // List of Accounts
        List<Account> accounts = accountService.listAccountByAccountNo(accountNo);
        if (accounts != null) {
            for (Account account : accounts) {
                if (account != null) {
                    kieSession.insert(account);
                }
            }
        }

        // List of Outward Profiles
        List<OutwardProfile> outwardProfiles = outwardProfileService.listOutwardProfileByAccountNo(accountNo);
        if (outwardProfiles != null) {
            for (OutwardProfile outwardProfile : outwardProfiles) {
                if (outwardProfile != null) {
                    kieSession.insert(outwardProfile);
                }
            }
        }
        kieSession.fireAllRules();

        ruleResponseDto.setTransactionFlagged(isTransactionFlagged.isFlag());
        ruleResponseDto.setLevel(Severity.valueOf(isTransactionFlagged.getLevel()));
        return ruleResponseDto;

    }




}
