package com.demo.game;

public class Boss implements Monster {
    public Boss(long blood, long attack, long defense) {
        this.blood = blood;
        this.attack = attack;
        this.defense = defense;
    }

    private long blood;

    public long getBlood() {
        return blood;
    }

    public void setBlood(long blood) {
        this.blood = blood;
    }

    public long getAttack() {
        return attack;
    }

    public void setAttack(long attack) {
        this.attack = attack;
    }

    public long getDefense() {
        return defense;
    }

    public void setDefense(long defense) {
        this.defense = defense;
    }

    private long attack;
    private long defense;
}
