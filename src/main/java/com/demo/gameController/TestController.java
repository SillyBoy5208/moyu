package com.demo.gameController;

import com.common.ResponseVO;
import com.demo.boss.BossUtil;
import com.demo.entity.BB;
import com.demo.entity.Package;
import com.demo.form.PKResponseForm;
import com.demo.game.Boss;
import com.game.GameUtil;
import com.demo.game.Magicians;
import com.demo.service.BBService;
import com.demo.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@RestController
@RequestMapping("game")
public class TestController extends BaseController{
    @Autowired
    PackageService packageService;
    @Autowired
    BBService bbService;
    ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
    static Boss boss = new Boss(100000,1000,1000);
    static Magicians magicians = new Magicians(1000000000,10000,100);

    @RequestMapping(value = "/PK",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public PKResponseForm attack(String bossName){
        int userId = getUserId();
        System.out.println("pk一次");
       return magicians.PK(packageService,userId, BossUtil.bossMap_lm.get(bossName));
    }
    @RequestMapping("/upBB")
    public ResponseVO<BB> upBB(String bbName){
        int userId = getUserId();
        Package pp = packageService.findById(userId);
        int xo = pp.getXo();
        int expOrb = pp.getExperienceOrb();
        ResponseVO responseVO = new ResponseVO();
        if (xo<=100 || expOrb<=100){
            responseVO.setMsg("xo兽或特球不足");
            return responseVO;
        }
        BB bb = bbService.findByBBNameAndIdMaster(bbName,userId);
        bb.setBbBlood(bb.getBbBlood()+(int)(100*GameUtil.getPer()));
        bb.setBbAttack(bb.getBbAttack()+(int)(50*GameUtil.getPer()));
        bb.setBbDefence(bb.getBbDefence()+(int)(25*GameUtil.getPer()));
        bb.setBbScore(bb.getBbScore()+(int)(10* GameUtil.getPer()));
        bb.setBbStart(bb.getBbScore()/100);
        bbService.save(bb);
        pp.setXo(pp.getXo()-100);
        pp.setExperienceOrb(pp.getExperienceOrb()-100);
        packageService.save(pp);
        responseVO.setT(bb);
        return responseVO;
    }

}
