package com.example.ItrackBackend.model.dtos;

import com.example.ItrackBackend.enums.ComparisonTypes;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@AllArgsConstructor
@Data
public class MultiRuleDto {
    String ruleName;
    @NotBlank
    String secondaryCollectionName;
    @NotBlank
    String secondaryDynamicParam;
    @NotBlank
    String primaryCollectionName;
    @NotBlank
    String primaryDynamicParam;
    @NotBlank
    ComparisonTypes comparisonType;
    //Should be either boolean to tell flag transactions or set a json string to update the users data.
    @NotBlank
    String ruleAction;


}
