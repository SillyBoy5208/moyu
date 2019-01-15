package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testuser")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/getUserDetails")
    public User getUser(){
        return userService.getUserById(2);
    }
    @RequestMapping("/update")
    public User updateUser(){
        User user = userService.getUserById(2);
        user.setAge((int)(Math.random()*100));
        return userService.update(user);
    }

}
