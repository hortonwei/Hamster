package com.horton.vo;

import java.util.Arrays;

public class SinaHotSearchVo {

    private String mid;
    private String word;
    private long rawHot;
    private String category;
    private int rank;
    private int funWord;
    private String channelType;
    private String[] starName;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public long getRawHot() {
        return rawHot;
    }

    public void setRawHot(long rawHot) {
        this.rawHot = rawHot;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getFunWord() {
        return funWord;
    }

    public void setFunWord(int funWord) {
        this.funWord = funWord;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String[] getStarName() {
        return starName;
    }

    public void setStarName(String[] starName) {
        this.starName = starName;
    }

    @Override
    public String toString() {
        return "SinaHotSearchVo{" +
                "mid='" + mid + '\'' +
                ", word='" + word + '\'' +
                ", rawHot=" + rawHot +
                ", category='" + category + '\'' +
                ", rank=" + rank +
                ", funWord=" + funWord +
                ", channelType='" + channelType + '\'' +
                ", starName=" + Arrays.toString(starName) +
                '}';
    }
}
