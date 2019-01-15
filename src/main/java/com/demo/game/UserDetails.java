package com.demo.game;

public class UserDetails {
    Integer id;
    String name;
    Long totalBlood;
    Long currentBlood;

    public UserDetails(Integer id, String name, Long totalBlood, Long totalAttack, Long totalDefense) {
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

    Long totalAttack;
    Long currentAttack;
    Long totalDefense;
    Long currentDefense;
}
