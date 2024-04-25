package com.engine.ItrackBackend.model;

import com.engine.ItrackBackend.enums.Severity;

public class FlagFact {
    private boolean flag;
    private String level;

    public FlagFact(boolean flag) {
        this.flag = flag;

    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
