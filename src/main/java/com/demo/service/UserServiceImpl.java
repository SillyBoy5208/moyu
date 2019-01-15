package com.demo.service;

import com.demo.dao.UserDao;
import com.demo.dto.PageDTO;
import com.demo.dto.PageQueryDTO;
import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import org.hibernate.annotations.Cache;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    UserDao userDao;

    @Override
    @CachePut(value ="com.demo.entity.User",key = "'com.demo.entity.User'+#user.id")
    public User update(User user) {
        return userDao.save(user);
    }

    @Override
    public String register(User user) {
        if (user==null){
            return "注册失败";
        }
        if (user.getUserName().trim()==null || user.getPassword().trim()==null){
            return "注册失败，用户名或密码不能为空";
        }
        int count = userDao.getCount();
        if (count>1000){
            return "注册用户超过上限";
        }
        User u = userDao.getUserByUserName(user.getUserName());
        if (u!=null){
            return "该用户已经存在";
        }

        userDao.save(user);
        return "注册成功！";
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Cacheable(value = "com.demo.entity.User",key = "'com.demo.entity.User'+#id")
    public User getUserById(int userId) {
        System.out.println("从数据库读取");
        return userDao.findUserById(userId);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Autowired
    UserMapper userMapper;
    @Override
    public boolean addUser(User record) {
        return true;
    }

    @Override
    public Page<User> queryUsers(PageQueryDTO pageDTO) {
        PageRequest request = PageRequest.of((int)pageDTO.getPageNo(),(int)pageDTO.getPageSize());
        Page<User> page = userDao.findAll(request);
        return page;
    }

    @Override
    public PageDTO<User> queryUsers2(PageQueryDTO pageDTO) {
        Page<User> page = userDao.findAll((root,query,builder)-> {

            return builder.and(new Predicate[]{});}
        ,PageRequest.of((int)pageDTO.getPageNo(),(int)pageDTO.getPageSize()));

        PageDTO<User>  pageDTO1 = PageDTO.of(page,dao->{
            User user = new User();
            BeanUtils.copyProperties(dao,user);
            return user;
        });
        return pageDTO1;
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> queryStudentsBySql(int currentPage, int pageSize) {
        int currentIndex = (currentPage -1) *pageSize ;
        HashMap<String,Object> data = new HashMap<>();
        data.put("currentIndex",currentIndex);
        data.put("pageSize",pageSize);
        return userMapper.queryUserBySql(data);
    }
}
