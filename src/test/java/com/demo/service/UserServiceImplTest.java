package com.demo.service;

import com.demo.MoyuApplication;
import com.demo.dto.PageDTO;
import com.demo.dto.PageQueryDTO;
import com.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= MoyuApplication.class)
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Test
    public void getAll() {
        PageQueryDTO dto = new PageQueryDTO();
        dto.setPageNo(2);
        dto.setPageSize(5);
        Page<User> page = userService.queryUsers(dto);
        List<User> list = page.getContent();
        list.forEach((o)-> System.out.println(o));
    }
    @Test
    public void getAll2(){
        PageQueryDTO dto = new PageQueryDTO();
        dto.setPageNo(2);
        dto.setPageSize(5);
        PageDTO<User> pageDTO = userService.queryUsers2(dto);
        pageDTO.getList().forEach(o->{
            System.out.println(o);
        });
    }
    @Test
    public void getAll3(){
        userService.queryStudentsBySql(1,10).forEach(o->{
            System.out.println(o);
        });
    }
}