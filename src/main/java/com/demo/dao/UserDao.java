package com.demo.dao;

import com.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Repository
public interface UserDao {

    @Select("SELECT * FROM user limit #{arg0},#{arg1}")
    List<User> find(int index,int length);

    List<User> findAll();
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
