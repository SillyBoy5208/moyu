package com.demo.dao;

import com.demo.MoyuApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= MoyuApplication.class)
public class EquipageDaoTest {
    @Autowired
    EquipageDao equipageDao;
        @Test
        public void test(){
            System.out.println(equipageDao.findEquipageByUserNameAndEName("刘德华","武器"));
        }
}