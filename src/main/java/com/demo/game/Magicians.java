package com.demo.game;

import com.demo.entity.Package;
import com.demo.service.PackageService;
import com.demo.service.PackageServiceImpl;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
@Component
public class Magicians implements Person{
    @Autowired
    UserService userService;
   long lastTime = System.currentTimeMillis();

    public Magicians(long blood, long attack, long defense) {
        this.lastTime = lastTime;
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
    public synchronized String PK(Monster monster) {
//        if (System.currentTimeMillis() - lastTime <1000){
//            return "一秒内不允许多次攻击";
//        }
//        if (monster instanceof Boss){
//            Boss boss = (Boss) monster;
//            if (boss.getBlood()<=0){
//                return "BOSS还未刷新";
//            }
//            long bossBlood = this.attack - boss.getDefense();
//            long myBlood = boss.getAttack() - this.defense;
//            if (myBlood>0){
//                this.blood = this.blood - myBlood;
//            }
//            if (bossBlood > 0){
//                boss.setBlood(boss.getBlood() - bossBlood);
//            }
//            lastTime = System.currentTimeMillis();
//            if (boss.getBlood()<=0){
//                new Thread(()->{
//                    try {
//                        Thread.sleep(1000*10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    boss.setBlood(100000);
//                    System.out.println("boss刷新");
//                }).start();
//                return "恭喜你打败了沼泽招魂使BOSS，获得魔石*100000000，25星XO*100000000，特级经验球*10000000";
//            }
//            StringBuilder sb = new StringBuilder();
//            sb.append("您的血量：").append(this.blood).append(" ").append("Boss的血量:").append(boss.getBlood());
//            return sb.toString();
//        }else {
//            return "未知的怪兽";
//        }
        return null;
    }

    @Override
    public synchronized String PK(int userId, Monster monster) {
//        if (System.currentTimeMillis() - lastTime <1000){
//            return "一秒内不允许多次攻击";
//        }
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
            lastTime = System.currentTimeMillis();
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
                PackageService packageService = new PackageServiceImpl();
               Package p = packageService.findById(userId);
               p.setMoney(p.getMoney()+10000);
               p.setXo(p.getXo()+100);
               p.setExperienceOrb(p.getExperienceOrb()+100);
               packageService.save(p);
                return "恭喜你打败了沼泽招魂使BOSS，获得魔石*10000，25星XO*100，特级经验球*100";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("您的血量：").append(this.blood).append(" ").append("Boss的血量:").append(boss.getBlood());
            return sb.toString();
        }else {
            return "未知的怪兽";
        }
    }
}
