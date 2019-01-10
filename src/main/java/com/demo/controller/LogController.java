package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Controller
@RequestMapping("/log")
public class LogController {
    @RequestMapping("/hello")
    public String helloHtml(HashMap<String, Object> map) {
        map.put("hello", "欢迎进入HTML页面");
        return "/index";
    }
    @RequestMapping("/testhello")
    public String hello11(){
        return "hello";
    }
    @RequestMapping("/loginPage")
    public String mobile(){
        return "/login";
    }
    @RequestMapping("/gongju")
    public String gongju(){
        return "/gongju";
    }
    @RequestMapping("/success")
    public String success(){
        return "/success";
    }
    @RequestMapping("/errorPage")
    public String error(){
        return "error";
    }
    @RequestMapping("/testFrame")
    public String testFrame(){
        return "/testFrame";
    }
    @RequestMapping("/pk")
    public String pk(){
        return "/pk";
    }
}
