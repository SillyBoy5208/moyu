package com.demo.game;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Magicians implements Person{
   static ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
    public Magicians(long blood, long attack, long defense) {
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
    @Override
    public String PK(Monster monster) {
        if (monster instanceof Boss){
            Boss boss = (Boss) monster;
            if (boss.getBlood()<=0){
                return "BOSS还未刷新";
            }
            long bossBlood = this.attack - boss.getDefense();
            long myBlood = boss.getAttack() - this.defense;
            if (myBlood>0){
                this.blood = this.blood - myBlood;
            }
            if (bossBlood > 0){
                boss.setBlood(boss.getBlood() - bossBlood);
            }
            if (boss.getBlood()<=0){
                new Thread(()->{
                    try {
                        Thread.sleep(1000*10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    boss.setBlood(100000);
                    System.out.println("boss刷新");
                }).start();
                return "恭喜你打败了沼泽招魂使BOSS，获得魔石*100000000，25星XO*100000000，特级经验球*10000000";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("您的血量：").append(this.blood).append(" ").append("Boss的血量:").append(boss.getBlood());
            return sb.toString();
        }else {
            return "未知的怪兽";
        }
    }
}