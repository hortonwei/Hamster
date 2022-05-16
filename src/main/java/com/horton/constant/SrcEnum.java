package com.horton.constant;

/**
 * src = source来源
 */
public enum SrcEnum {

    bd("bd", "百度"),
    sina("sina", "新浪");

    private String src;
    private String intro;

    SrcEnum(String src, String intro) {
        this.src = src;
        this.intro = intro;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
