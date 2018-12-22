package com.demo.service;

import com.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Test
    public void addUserTest(){
        for (int i = 0 ; i < 100;i++){
            User user = new User();
            user.setId(i);
            user.setAge(10+i);
            user.setUserName("test"+i);
            user.setPassword("pass:"+i);
            userService.addUser(user);
        }
    }

}