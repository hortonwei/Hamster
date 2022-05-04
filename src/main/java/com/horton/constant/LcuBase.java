package com.horton.constant;

/**
 * lcu = last change user
 */
public enum LcuBase {

    hamster("hamster"), // 本系统
    dataChange("data-change"); //人为数据修改

    private String user;

    LcuBase(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
