package com.demo.controller;

import com.demo.boss.BaseBoss;
import com.demo.boss.BossUtil;
import com.demo.boss.LeiMing.DiJing;
import com.demo.boss.LeiMing.JuJieShi;
import com.demo.boss.LeiMing.LieShaShou;
import com.demo.boss.LeiMing.LongGuai;
import com.demo.boss.LeiMing.LuJiaoShou;
import com.demo.form.PKResponseForm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lm")
public class LeiMing {

    @RequestMapping("/ljs")
    public PKResponseForm ljs(){
        PKResponseForm form = new PKResponseForm();
        BaseBoss boss = BossUtil.bossMap_lm.get("鹿角兽");
        if (boss.getState()==0){
            form.setMessage(BossUtil.BOSS_NOT_REFRESH);
            return form;
        }
        return null;
    }
    @RequestMapping("/jjs")
    public PKResponseForm jjs(){
        return null;
    }
    @RequestMapping("/lss")
    public PKResponseForm lss(){
        return null;
    }
    @RequestMapping("/dj")
    public PKResponseForm dj(){
        return null;
    }
    @RequestMapping("/lg")
    public PKResponseForm lg(){
        return null;
    }
}
