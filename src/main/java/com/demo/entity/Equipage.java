package com.demo.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipage")
@DynamicInsert
@DynamicUpdate
public class Equipage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Override
    public String toString() {
        return "Equipage{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", eName='" + eName + '\'' +
                ", eLevel=" + eLevel +
                ", mohunLevel=" + mohunLevel +
                ", pinzhiLevel=" + pinzhiLevel +
                '}';
    }

    String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public int geteLevel() {
        return eLevel;
    }

    public void seteLevel(int eLevel) {
        this.eLevel = eLevel;
    }

    public int getMohunLevel() {
        return mohunLevel;
    }

    public void setMohunLevel(int mohunLevel) {
        this.mohunLevel = mohunLevel;
    }

    public int getPinzhiLevel() {
        return pinzhiLevel;
    }

    public void setPinzhiLevel(int pinzhiLevel) {
        this.pinzhiLevel = pinzhiLevel;
    }

    String eName;
    int eLevel;
    int mohunLevel;
    int pinzhiLevel;

}
