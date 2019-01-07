package com.demo.gameController;

import com.common.ResponseVO;
import com.demo.entity.BB;
import com.demo.entity.Package;
import com.demo.game.Boss;
import com.demo.game.Magicians;
import com.demo.service.BBService;
import com.demo.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@RestController
@EnableAutoConfiguration
@RequestMapping("game")
public class TestController extends BaseController{
    @Autowired
    PackageService packageService;
    @Autowired
    BBService bbService;
    ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
    static Boss boss = new Boss(100000,1000,1000);
    static Magicians magicians = new Magicians(1000000000,10000,100);
    @RequestMapping("/PK")
    public String attack(){
        int userId = getUserId();
        System.out.println("pk一次");
       return magicians.PK(packageService,userId,boss);
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
            return new ResponseVO<>();
        }
        BB bb = bbService.findByBBNameAndIdMaster(bbName,userId);
        bb.setBbBlood(bb.getBbBlood()+100);
        bb.setBbAttack(bb.getBbAttack()+50);
        bb.setBbDefence(bb.getBbDefence()+25);
        bb.setBbScore(bb.getBbScore()+10);
        bb.setBbStart(bb.getBbScore()/100);
        bbService.save(bb);
        pp.setXo(pp.getXo()-100);
        pp.setExperienceOrb(pp.getExperienceOrb()-100);
        packageService.save(pp);
        responseVO.setT(bb);
        return responseVO;
    }
}
