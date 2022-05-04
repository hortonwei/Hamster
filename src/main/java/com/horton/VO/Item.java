package com.horton.VO;

import java.util.Date;

public class Item {

    private long id;
    private String type;
    private int idx;
    private String title;
    private String intro;
    private String img;
    private Date fcd;
    private Date lcd;
    private String lcu;

    public Item() {
    }

    public Item(long id, String type, int idx, String title, String intro, String img, Date fcd, Date lcd, String lcu) {
        this.id = id;
        this.type = type;
        this.idx = idx;
        this.title = title;
        this.intro = intro;
        this.img = img;
        this.fcd = fcd;
        this.lcd = lcd;
        this.lcu = lcu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getFcd() {
        return fcd;
    }

    public void setFcd(Date fcd) {
        this.fcd = fcd;
    }

    public Date getLcd() {
        return lcd;
    }

    public void setLcd(Date lcd) {
        this.lcd = lcd;
    }

    public String getLcu() {
        return lcu;
    }

    public void setLcu(String lcu) {
        this.lcu = lcu;
    }

}
