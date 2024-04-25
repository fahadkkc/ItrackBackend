package com.engine.ItrackBackend.model.dtos;

import com.engine.ItrackBackend.enums.ComparisonTypes;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;


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

    String severity;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getSecondaryCollectionName() {
        return secondaryCollectionName;
    }

    public void setSecondaryCollectionName(String secondaryCollectionName) {
        this.secondaryCollectionName = secondaryCollectionName;
    }

    public String getSecondaryDynamicParam() {
        return secondaryDynamicParam;
    }

    public void setSecondaryDynamicParam(String secondaryDynamicParam) {
        this.secondaryDynamicParam = secondaryDynamicParam;
    }

    public String getPrimaryCollectionName() {
        return primaryCollectionName;
    }

    public void setPrimaryCollectionName(String primaryCollectionName) {
        this.primaryCollectionName = primaryCollectionName;
    }

    public String getPrimaryDynamicParam() {
        return primaryDynamicParam;
    }

    public void setPrimaryDynamicParam(String primaryDynamicParam) {
        this.primaryDynamicParam = primaryDynamicParam;
    }

    public ComparisonTypes getComparisonType() {
        return comparisonType;
    }

    public void setComparisonType(ComparisonTypes comparisonType) {
        this.comparisonType = comparisonType;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
