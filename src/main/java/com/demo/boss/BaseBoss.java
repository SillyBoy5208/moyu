package com.demo.boss;

public abstract class BaseBoss {
    public Long blood;
    public String name;
    public Long lastTime;

    public Long getTotalBlood() {
        return totalBlood;
    }

    public void setTotalBlood(Long totalBlood) {
        this.totalBlood = totalBlood;
    }

    public Long totalBlood;
    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }

    public Long getBlood() {
        return blood;
    }

    public void setBlood(Long blood) {
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAttack() {
        return attack;
    }

    public void setAttack(Long attack) {
        this.attack = attack;
    }

    public Long getDefense() {
        return defense;
    }

    public void setDefense(Long defense) {
        this.defense = defense;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long attack;
    public Long defense;
    public Integer level;
    public String quality;
    public Integer state;
    public String imgUrl;
}
