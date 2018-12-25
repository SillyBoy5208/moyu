package com.demo.mapper;

import com.demo.MoyuApplication;
import com.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= MoyuApplication.class)
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test1(){
        List<User> list = userMapper.findAll();
        list.forEach(o-> System.out.println(o));
    }

}