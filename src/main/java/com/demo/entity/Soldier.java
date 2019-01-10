package com.demo.entity;

public class Soldier extends Role {
    public boolean attack(BaseBoss boss) {
        Long myHP = this.getHP();
        Integer myPhysicalAttacks = this.getPhysicalAttacks();
        Integer myMagicAttacks = this.getMagicAttacks();
        Integer myPhysicalDefense = this.getPhysicalDefense();
        Integer myMagicDefense = this.getMagicDefense();

        Long bossHP = boss.getHP();
        Integer bossPhysicalAttacks = boss.getPhysicalAttacks();
        Integer bossMagicAttacks = boss.getMagicAttacks();
        Integer bossPhysicalDefense = boss.getPhysicalDefense();
        Integer bossMagicDefense = boss.getMagicDefense();
        int myAttack = myMagicAttacks-bossMagicDefense + myPhysicalAttacks - bossPhysicalDefense;
        if (myAttack>0){
            bossHP-=myAttack;
            boss.setHP(bossHP);
        }
        int bossAttack = bossMagicAttacks-myMagicDefense + bossPhysicalAttacks - myPhysicalDefense;
        if (bossAttack>0){
            myHP-=bossHP;
            this.setHP(myHP);
        }
        return false;
    }
}
