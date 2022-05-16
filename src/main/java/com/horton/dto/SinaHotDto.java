package com.horton.dto;

public class SinaHotDto {

    private long mid;
    private String category;
    private long rowHot;
    private String word;
    private String funWord;
    private String channelType;
    private String starName;
    private String lcu;

    public String getLcu() {
        return lcu;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public void setLcu(String lcu) {
        this.lcu = lcu;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getRowHot() {
        return rowHot;
    }

    public void setRowHot(long rowHot) {
        this.rowHot = rowHot;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getFunWord() {
        return funWord;
    }

    public void setFunWord(String funWord) {
        this.funWord = funWord;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    @Override
    public String toString() {
        return "SinaHotDto{" +
                "mid=" + mid +
                ", category='" + category + '\'' +
                ", rowHot=" + rowHot +
                ", word='" + word + '\'' +
                ", funWord='" + funWord + '\'' +
                ", channelType='" + channelType + '\'' +
                ", starName='" + starName + '\'' +
                ", lcu='" + lcu + '\'' +
                '}';
    }
}
