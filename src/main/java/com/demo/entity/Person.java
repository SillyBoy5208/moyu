package com.demo.entity;

import com.demo.boss.BaseBoss;
import com.demo.boss.BossUtil;
import com.demo.entity.Package;
import com.demo.form.PKResponseForm;
import com.demo.game.GameUtil;
import com.demo.service.PackageService;
import com.demo.service.PackageServiceImpl;
import com.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Person{
    private static Logger logger = LoggerFactory.getLogger(Person.class);
    long lastTime = System.currentTimeMillis();

    public Person(long blood, long attack, long defense) {
        this.lastTime = System.currentTimeMillis();
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
    public synchronized PKResponseForm PK(PackageService packageService , int userId, BaseBoss boss){
        PKResponseForm form = new PKResponseForm();
        if (boss==null || boss.getBlood()<=0){
            form.setMessage("BOSS还未刷新");
            form.setMyBlood((int)this.getBlood());
            return form;
        }
            if (System.currentTimeMillis() - lastTime <1000){
                form.setMessage("BOSS还未刷新");
                return form;
            }
        form.setBossName(boss.getName());
        long myBloodReduce = boss.getAttack() - this.getAttack();
        long bossBloodReduce = this.getAttack() - boss.getDefense();
        if (myBloodReduce>0){
            myBloodReduce = (int)(myBloodReduce* GameUtil.getPrecent());
            this.setBlood(this.getBlood()-myBloodReduce);
            form.setMyBloodReduce((int)(myBloodReduce));
        }
        if (bossBloodReduce>0){
            bossBloodReduce = (int)(bossBloodReduce* GameUtil.getPrecent());
            boss.setBlood(boss.getBlood() - bossBloodReduce);
            form.setBossBloodReduce((int)(bossBloodReduce));
        }
        form.setBossBlood(boss.getBlood()<0?0: boss.getBlood().intValue());
        form.setMyBlood(this.getBlood()<0?0:(int)this.getBlood());
        lastTime = System.currentTimeMillis();
        if (boss.getBlood()<=0){
            BossUtil.bossMap_lm.remove(boss.getName(),boss);
            new Thread(()->{
                try {
                    Thread.sleep(10000*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    BossUtil.bossMap_lm.put(boss.getName(),boss.getClass().newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                System.out.println("boss刷新");
            }).start();
            Package p = packageService.findById(userId);
            p.setMoney(p.getMoney()+10000);
            p.setXo(p.getXo()+100);
            p.setExperienceOrb(p.getExperienceOrb()+100);
            packageService.save(p);
            form.setMessage("恭喜你获得了魔石*1000，XO兽*100,特球*100");
        }
        return form;
    }
}
