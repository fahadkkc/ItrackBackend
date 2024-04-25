package com.engine.ItrackBackend.enums;

public enum Severity {
    LevelOne("One"),
    LevelTwo("Two"),
    LevelThree("Three");

    private String level;


    Severity(String level) {
        this.level=level;
    }
    public String getSeverity(){
        return this.level;
    }
}
