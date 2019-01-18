package com.demo.gameController;

import com.demo.boss.BaseBoss;
import com.demo.boss.BossUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/boss")
public class BossController {
    @RequestMapping("/testtestest")
    public String test(HttpServletRequest request){
        return null;
    }
    @RequestMapping("/getBossDetails")
    public BaseBoss getBossDetails(String bossName){
        return BossUtil.bossMap_lm.get(bossName);
    }
    @RequestMapping("/getBossList")
    public ArrayList<BaseBoss> getBossList(){
        ArrayList<BaseBoss> list = new ArrayList<>();
        ConcurrentHashMap<String, BaseBoss> map = BossUtil.bossMap_lm;
        map.forEach((K,V)->{
            if (V.getState()==1){
                list.add(V);
                Collections.sort(list,(o1,o2)->{
                    return o1.getLevel() - o2.getLevel();
                });
            }
        });
        return list;
    }
}
