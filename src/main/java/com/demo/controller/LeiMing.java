package com.demo.controller;

import com.demo.boss.BossUtil;
import com.demo.boss.LeiMing.JuJieShi;
import com.demo.boss.LeiMing.LieShaShou;
import com.demo.boss.LeiMing.LuJiaoShou;
import com.demo.form.PKResponseForm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lm")
public class LeiMing {
    private static LuJiaoShou ljs = new LuJiaoShou();
    private static JuJieShi jjs = new JuJieShi();
    private static LieShaShou lss = new LieShaShou();
    static {
        BossUtil.bossMap_lm.put("鹿角兽",ljs);
        BossUtil.bossMap_lm.put("巨杰士",jjs);
        BossUtil.bossMap_lm.put("猎杀兽",lss);

    }
    @RequestMapping("/ljs")
    public PKResponseForm ljs(){
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
