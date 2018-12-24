package com.demo.entity;

public class BaseBoss {
    Long id;
    String name;
    Long HP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    Integer level;
    Integer state;
    Integer physicalAttacks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHP() {
        return HP;
    }

    public void setHP(Long HP) {
        this.HP = HP;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPhysicalAttacks() {
        return physicalAttacks;
    }

    public void setPhysicalAttacks(Integer physicalAttacks) {
        this.physicalAttacks = physicalAttacks;
    }

    public Integer getMagicAttacks() {
        return magicAttacks;
    }

    public void setMagicAttacks(Integer magicAttacks) {
        this.magicAttacks = magicAttacks;
    }

    public Integer getPhysicalDefense() {
        return physicalDefense;
    }

    public void setPhysicalDefense(Integer physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    public Integer getMagicDefense() {
        return magicDefense;
    }

    public void setMagicDefense(Integer magicDefense) {
        this.magicDefense = magicDefense;
    }

    Integer magicAttacks;
    Integer physicalDefense;
    Integer magicDefense;
}
