package com.demo.dao;

import com.demo.MoyuApplication;
import com.demo.entity.User;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= MoyuApplication.class)
public class UserDaoTest {
    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Autowired
    UserRepository userRepository;

    @Test
    public void test(){
        System.out.println(userDao.getMaxId());
    }
    @Test
    public void test2(){
//        User user = userRepository.findUserById(1);
//        System.out.println(user);
    }
    @Test
    public void test3(){
        List<User> all = userDao.findAll();
        all.forEach(e -> System.out.println(e.toString()));
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