package com.demo.game;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game_user")
@DynamicInsert
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Long totalBlood;
    Long currentBlood;
    Long totalAttack;

    public User(Integer id, String name, Long totalBlood, Long totalAttack, Long totalDefense) {
        this.id = id;
        this.name = name;
        this.totalBlood = totalBlood;
        this.currentBlood = totalBlood;
        this.totalAttack = totalAttack;
        this.currentAttack = totalAttack;
        this.totalDefense = totalDefense;
        this.currentDefense = totalDefense;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalBlood() {
        return totalBlood;
    }

    public void setTotalBlood(Long totalBlood) {
        this.totalBlood = totalBlood;
    }

    public Long getCurrentBlood() {
        return currentBlood;
    }

    public void setCurrentBlood(Long currentBlood) {
        this.currentBlood = currentBlood;
    }

    public Long getTotalAttack() {
        return totalAttack;
    }

    public void setTotalAttack(Long totalAttack) {
        this.totalAttack = totalAttack;
    }

    public Long getCurrentAttack() {
        return currentAttack;
    }

    public void setCurrentAttack(Long currentAttack) {
        this.currentAttack = currentAttack;
    }

    public Long getTotalDefense() {
        return totalDefense;
    }

    public void setTotalDefense(Long totalDefense) {
        this.totalDefense = totalDefense;
    }

    public Long getCurrentDefense() {
        return currentDefense;
    }

    public void setCurrentDefense(Long currentDefense) {
        this.currentDefense = currentDefense;
    }

    Long currentAttack;
    Long totalDefense;
    Long currentDefense;

}
