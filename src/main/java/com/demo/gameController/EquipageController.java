package com.demo.gameController;

import com.demo.entity.Equipage;
import com.demo.service.EquipageService;
import com.demo.util.EquipageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("equipage")
public class EquipageController extends BaseController{
    @Autowired
    EquipageService service;
    @RequestMapping("/strengthen")
    public String strengthen(String equipageName){
        String userName = getUserName();
        System.out.println("userName:"+userName);
       Equipage equipage = service.findEquipage(userName,equipageName);
       if (equipage==null){
           return "没有此装备";
       }
       int level = equipage.geteLevel();
       Equipage equipage1 = EquipageUtil.upEquipage(equipage);
       if (level==125){
           return "已经达到最高等级";
       }
       if (equipage1==null ||level==equipage1.geteLevel()){
           return "强化失败";
       }
       if (equipage1.geteLevel()-level>0){
           service.save(equipage1);
           return "强化成功";
       }
       return null;
    }
}
