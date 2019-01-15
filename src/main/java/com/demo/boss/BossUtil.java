package com.demo.boss;

import com.demo.boss.LeiMing.DiJing;
import com.demo.boss.LeiMing.JuJieShi;
import com.demo.boss.LeiMing.LieShaShou;
import com.demo.boss.LeiMing.LongGuai;
import com.demo.boss.LeiMing.LuJiaoShou;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class BossUtil {
    public static final String BOSS_NOT_REFRESH = "BOSS还未刷新";
    public static ConcurrentHashMap<String,BaseBoss>  bossMap_lm = new ConcurrentHashMap<>();
    private static LuJiaoShou ljs = new LuJiaoShou();
    private static JuJieShi jjs = new JuJieShi();
    private static LieShaShou lss = new LieShaShou();
    private static DiJing dj = new DiJing();
    private static LongGuai lg = new LongGuai();
    static {
        bossMap_lm.put("鹿角兽BOSS",ljs);
        bossMap_lm.put("巨杰士BOSS",jjs);
        bossMap_lm.put("猎杀兽BOSS",lss);
        bossMap_lm.put("地精BOSS",dj);
        bossMap_lm.put("龙怪BOSS",lg);
    }
    static {
        new Thread(()->{
            while (true){
                bossMap_lm.forEach((K,V)->{
                    if (V.getState()==0 && System.currentTimeMillis() - V.getLastTime()  >= 1000 *60){
                        V.setState(1);
                        V.setBlood(V.getTotalBlood());
                        System.out.println(K+"刷新");
                    }

                });
                try {
                    Thread.sleep(5*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
