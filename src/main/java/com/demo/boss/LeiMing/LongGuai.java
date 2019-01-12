package com.demo.boss.LeiMing;

import com.demo.boss.BaseBoss;

public class LongGuai extends BaseBoss {
    public LongGuai(){
        this(12345L,"龙怪",333l,444l,13,"极品",1);
        this.imgUrl="http://images.17173.com/moyu/images/monster/lei/9s.jpg";
    }
    public LongGuai(Long blood, String name, Long attack, Long defense, Integer level, String quality,Integer state) {
        this.blood = blood;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
        this.quality = quality;
        this.state =state;
    }
}
