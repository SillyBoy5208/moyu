package com.mybatis.mapper;

import com.demo.MoyuApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= MoyuApplication.class)
public class StudentMapperTest {
    @Autowired
    StudentMapper mapper;
    @Test
    public void getAll() {
        mapper.getAll().forEach(o->{
            System.out.println(o);
        });
    }
}