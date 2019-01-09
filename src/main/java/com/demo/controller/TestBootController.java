package com.demo.controller;

import com.common.ResponseVO;
import com.demo.dto.PageDTO;
import com.demo.entity.User;
import com.demo.form.QueryUserForm;
import com.demo.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/testboot")
public class TestBootController {
    @Resource
    UserService userService;

    @RequestMapping("/getuser")
    public User getUser(){
        System.out.println(">>>>>>>>>>");
        User user = new User();
        user.setUserName("test");
        return user;
    }

    @RequestMapping("/getUserById")
    public User getUserById(Integer userId){
        System.out.println("111111111111");
        return userService.getUserById(userId);
    }
    @RequestMapping("/addUser")
    public ResponseVO<User> addUser(User user){
        userService.addUser(user);
        ResponseVO<User> responseVO = new ResponseVO<>();
        responseVO.setSuccess(true);
        return responseVO;
    }
    @ResponseBody
    @RequestMapping("/getAllUsers")
    public List<User> getAllUser(){
        List<User> list = userService.findAll();
       return list;
    }

}
