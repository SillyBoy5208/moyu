package com.demo.boss.LeiMing;

import com.demo.boss.BaseBoss;

public class DiJing extends BaseBoss {
    public DiJing(){
        this(1000L,"地精",111l,455l,5,"普通",1);
        this.imgUrl = "http://images.17173.com/moyu/images/monster/lei/4s.jpg";
    }
    public DiJing(Long blood, String name, Long attack, Long defense, Integer level, String quality,Integer state) {
        this.blood = blood;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
        this.quality = quality;
        this.state =state;
    }

}
