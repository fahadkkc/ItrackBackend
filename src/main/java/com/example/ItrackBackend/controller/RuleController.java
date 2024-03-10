package com.example.ItrackBackend.controller;

import com.example.ItrackBackend.enums.ComparisonTypes;
import com.example.ItrackBackend.model.*;
import com.example.ItrackBackend.model.dtos.*;
import com.example.ItrackBackend.model.dtos.SingleRuleDto;
import com.example.ItrackBackend.model.dynamicParams.InwardTransactionsDynamicParams;
import com.example.ItrackBackend.service.*;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    boolean processInwardTransaction(@RequestBody InwardTransactionDto inwardTransactionDto) {
        if (inwardTransactionDto == null) {
            throw new RuntimeException();
        }
        Long accountNo = inwardTransactionDto.getAccountNo();
        return ruleService.fireRules(accountNo);
    }



}
