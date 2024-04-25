package com.engine.ItrackBackend.controller;

import com.engine.ItrackBackend.model.dtos.InwardTransactionDto;
import com.engine.ItrackBackend.model.dtos.MultiRuleDto;
import com.engine.ItrackBackend.model.dtos.RuleResponseDto;
import com.engine.ItrackBackend.model.dtos.SingleRuleDto;
import com.engine.ItrackBackend.service.RuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
public class RuleController {

    @Autowired
    RuleService ruleService;

    @PostMapping("/global")
    String globalRule(@RequestBody SingleRuleDto ruleEntity) {
        return ruleService.createSingleRule(ruleEntity);
    }

    @PostMapping("/user-level")
    String userLevelRule(@RequestBody MultiRuleDto multiRule) {
        return ruleService.createMultiRule(multiRule);
    }

    @PostMapping("/process-transaction")
    RuleResponseDto processInwardTransaction(@RequestBody InwardTransactionDto inwardTransactionDto) {
        if (inwardTransactionDto == null) {
            throw new RuntimeException();
        }
        Long accountNo = inwardTransactionDto.getAccountNo();
        return ruleService.fireRules(accountNo);
    }



}
