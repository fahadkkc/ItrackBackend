package com.engine.ItrackBackend.model.dtos;

import com.engine.ItrackBackend.enums.Severity;

public class RuleResponseDto {
    private Severity level;
    private Boolean isTransactionFlagged;

    public Severity getLevel() {
        return level;
    }

    public void setLevel(Severity level) {
        this.level = level;
    }

    public Boolean getTransactionFlagged() {
        return isTransactionFlagged;
    }

    public void setTransactionFlagged(Boolean transactionFlagged) {
        isTransactionFlagged = transactionFlagged;
    }
}
