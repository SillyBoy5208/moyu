package com.demo.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BB")
@DynamicInsert
@DynamicUpdate
public class BB {
    public int getMaster() {
        return master;
    }

    public void setMaster(int master) {
        this.master = master;
    }

    int master;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int bbName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBbName() {
        return bbName;
    }

    public void setBbName(int bbName) {
        this.bbName = bbName;
    }

    public int getBbBlood() {
        return bbBlood;
    }

    public void setBbBlood(int bbBlood) {
        this.bbBlood = bbBlood;
    }

    public int getBbAttack() {
        return bbAttack;
    }

    public void setBbAttack(int bbAttack) {
        this.bbAttack = bbAttack;
    }

    public int getBbDefence() {
        return bbDefence;
    }

    public void setBbDefence(int bbDefence) {
        this.bbDefence = bbDefence;
    }

    public int getBbStart() {
        return bbStart;
    }

    public void setBbStart(int bbStart) {
        this.bbStart = bbStart;
    }

    public int getBbScore() {
        return bbScore;
    }

    public void setBbScore(int bbScore) {
        this.bbScore = bbScore;
    }

    int bbBlood;
    int bbAttack;
    int bbDefence;
    int bbStart;
    int bbScore;
}