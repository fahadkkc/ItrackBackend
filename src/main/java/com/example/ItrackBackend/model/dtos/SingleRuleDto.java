package com.example.ItrackBackend.model.dtos;

import com.example.ItrackBackend.enums.ComparisonTypes;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@AllArgsConstructor
@Data

public class SingleRuleDto {
    String ruleName;
    @NotBlank
    String collectionName;
    @NotBlank
    String paramName;
    @NotBlank
    List<String> value;
    @NotBlank
    ComparisonTypes comparisonType;
    //Should be either boolean to tell flag transactions or set a json string to update the users data.
    @NotBlank
    String ruleAction;
}
