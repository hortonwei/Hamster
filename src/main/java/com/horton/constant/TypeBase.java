package com.horton.constant;

public enum TypeBase {

    all("all", "全部"),
    mov("mov", "电影"),
    tv("tv", "电视");

    private String type;
    private String intro;

    TypeBase(String type, String intro) {
        this.type = type;
        this.intro = intro;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
