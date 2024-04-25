package com.engine.ItrackBackend.enums;
public enum ComparisonTypes{
    EQUALS("=="),
    NOT_EQUALS("!="),
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL("<="),
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUAL(">="),
    MEMBER_OF("memberOf"),
    MATCHES("matches"),
    AFTER("after"),
    BEFORE("before");

    private final String symbol;

    ComparisonTypes(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
