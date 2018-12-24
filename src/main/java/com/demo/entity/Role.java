package com.demo.entity;

public abstract class Role {
    Long id;
    String name;
    Long HP;
    Integer level;
    Integer magicDefense;

    public Integer getMagicDefense() {
        return magicDefense;
    }

    public void setMagicDefense(Integer magicDefense) {
        this.magicDefense = magicDefense;
    }

    public Integer getPhysicalDefense() {
        return physicalDefense;
    }

    public void setPhysicalDefense(Integer physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    Integer physicalDefense;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    Integer state;
    Integer physicalAttacks;
    Integer magicAttacks;

    public Integer getMagicAttacks() {
        return magicAttacks;
    }

    public void setMagicAttacks(Integer magicAttacks) {
        this.magicAttacks = magicAttacks;
    }

    public abstract boolean attack(BaseBoss boss);
}
