package com.demo.boss.LeiMing;

import com.demo.boss.BaseBoss;

public class JuJieShi extends BaseBoss {
    public JuJieShi(){
        this(10000L,"巨杰士BOSS",1200l,600l,5,"良品",1);
        this.imgUrl = "http://images.17173.com/moyu/images/monster/lei/2s.jpg";
        this.totalBlood = 10000L;
    }
    public JuJieShi(Long blood, String name, Long attack, Long defense, Integer level, String quality,Integer state) {
        this.blood = blood;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
        this.quality = quality;
        this.state =state;
    }
}
