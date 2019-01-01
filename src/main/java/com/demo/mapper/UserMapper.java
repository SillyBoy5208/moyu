package com.demo.mapper;

import com.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    List<User> findAll();
    List<User> queryUserBySql(Map<String,Object> data);
}
