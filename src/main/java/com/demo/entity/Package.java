package com.demo.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "package")
@DynamicInsert
@DynamicUpdate
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
    @Column(name = "experience_orb")
    int experienceOrb;
}
