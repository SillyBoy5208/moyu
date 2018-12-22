package com.demo.dao;

import com.demo.MoyuApplication;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= MoyuApplication.class)
public class UserDaoTest {
    @Autowired
    UserService userService;
    @Test
    public void test(){
       List<User> list =  userService.getAll();
        System.out.println("list:"+list.size());
       for(User user:list)
           System.out.println(user);
    }
    @Test
    public void insert(){
        //test
        for(int i = 0 ; i < 100;i++){
            User user = new User();
            user.setId(i+10);
            user.setUserName("test"+i);
            user.setAge(i);
            user.setPassword("pass"+i);
            userService.addUser(user);
        }
    }
}