package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LogController.class);
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public String login( User user, HttpServletRequest request, HttpServletResponse response){
        String userName = user.getUserName();
        String password = user.getPassword();
        if (password==null) {
            return "密码为空，登陆失败";
        }
        User tmpUser = userService.getUserByUserName(userName);
        if (tmpUser==null){
            logger.debug("用户名或密码错误");
            return "用户名或密码错误";
        }
        System.out.println(tmpUser);
        if (password.equals(tmpUser.getPassword())){
            Cookie cookie = new Cookie("loginName",userName);
            cookie.setMaxAge(60*60);
            cookie.setPath("/");
            response.addCookie(cookie);
            System.out.println("登陆成功");
            return "success";
        }else {
            return "用户名或密码错误";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpServletResponse response,HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies==null){
            return "注销成功";
        }
        for (Cookie cookie : cookies){
            if(cookie.getName().equals("loginName")){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return "注销成功";
    }

}
