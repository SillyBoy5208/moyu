package com.demo.gameController;

import com.demo.game.Boss;
import com.demo.game.Magicians;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@RestController
@EnableAutoConfiguration
@RequestMapping("game")
public class TestController {
    ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
    static Boss boss = new Boss(100000,1000,1000);
    static Magicians magicians = new Magicians(1000000000,10000,100);
    @RequestMapping("/PK")
    public String attack(){
        System.out.println("pk一次");
       return magicians.PK(boss);
    }
}
