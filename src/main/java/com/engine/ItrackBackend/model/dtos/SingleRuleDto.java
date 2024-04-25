package com.engine.ItrackBackend.model.dtos;

import com.engine.ItrackBackend.enums.ComparisonTypes;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

    String severity;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
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
