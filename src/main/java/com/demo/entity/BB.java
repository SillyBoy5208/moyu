package com.demo.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "bb")
@DynamicInsert
@DynamicUpdate
public class BB {
    public int getIdMaster() {
        return idMaster;
    }

    @Override
    public String toString() {
        return "BB{" +
                "idMaster=" + idMaster +
                ", id=" + id +
                ", bbName=" + bbName +
                ", bbBlood=" + bbBlood +
                ", bbAttack=" + bbAttack +
                ", bbDefence=" + bbDefence +
                ", bbStart=" + bbStart +
                ", bbScore=" + bbScore +
                '}';
    }

    public void setIdMaster(int idMaster) {
        this.idMaster = idMaster;
    }

    int idMaster;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bbName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBbName() {
        return bbName;
    }

    public void setBbName(String bbName) {
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

    @Column(name = "bbAttack")
    int bbAttack;

    int bbDefence;
    int bbStart;
    int bbScore;
}
