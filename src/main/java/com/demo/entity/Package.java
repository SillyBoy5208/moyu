package com.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getXo() {
        return xo;
    }

    public void setXo(int xo) {
        this.xo = xo;
    }

    public int getExperienceOrb() {
        return experienceOrb;
    }

    public void setExperienceOrb(int experienceOrb) {
        this.experienceOrb = experienceOrb;
    }

    long money;
    int xo;
    int experienceOrb;
}
