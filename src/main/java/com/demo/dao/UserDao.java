package com.demo.dao;

import com.demo.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
