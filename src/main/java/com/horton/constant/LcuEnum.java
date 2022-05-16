package com.horton.constant;

/**
 * lcu = last change user
 */
public enum LcuEnum {

    hamster("hamster", "本系统"),
    dataChange("data-change", "人为数据修改");

    private String lcu;
    private String intro;

    LcuEnum(String lcu, String intro) {
        this.lcu = lcu;
        this.intro = intro;
    }

    public String getLcu() {
        return lcu;
    }

    public void setLcu(String lcu) {
        this.lcu = lcu;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
