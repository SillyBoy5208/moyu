package com.demo.boss.LeiMing;

import com.demo.boss.BaseBoss;

public class LieShaShou extends BaseBoss {
    public LieShaShou(){
        this(100000L,"猎杀兽BOSS",1000l,1000l,10,"普通",1);
        this.imgUrl = "http://images.17173.com/moyu/images/monster/lei/4s_1.jpg";
        this.totalBlood = 100000l;
    }
    public LieShaShou(Long blood, String name, Long attack, Long defense, Integer level, String quality,Integer state) {
        this.blood = blood;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
        this.quality = quality;
        this.state=state;

    }
}
