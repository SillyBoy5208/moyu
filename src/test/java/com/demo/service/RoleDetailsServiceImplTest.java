package com.demo.service;

import com.demo.MoyuApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= MoyuApplication.class)
public class RoleDetailsServiceImplTest {
    @Autowired
    RoleDetailsService roleDetailsService;
    @Test
    public void getRoleDetailsById() {
        System.out.println(roleDetailsService.getRoleDetailsById(1));
    }

    @Test
    public void getRoleDetailsByName() {
        System.out.println(roleDetailsService.getRoleDetailsByName("刘德华"));
    }
}