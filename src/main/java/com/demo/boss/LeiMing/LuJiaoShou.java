package com.demo.boss.LeiMing;

import com.demo.boss.BaseBoss;

public class LuJiaoShou extends BaseBoss {
    public LuJiaoShou(){
        this(10000L,"鹿角兽BOSS",1000L,1000L,1,"极品",1);
        this.imgUrl="http://images.17173.com/moyu/images/monster/lei/1s.jpg";
        this.totalBlood = 10000L;
    }

    public LuJiaoShou(Long blood, String name, Long attack, Long defense, Integer level, String quality,Integer state) {
        this.blood = blood;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
        this.quality = quality;
        this.state =state;
    }

    private Long blood;
    private String name;

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

    private Long attack;
    private Long defense;
    private Integer level;
    private String quality;
}
