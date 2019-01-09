package com.demo.dao;

import com.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Repository
public interface UserDao extends JpaSpecificationExecutor<User>,JpaRepository<User,Integer> {
    User findUserByUserName(String name);
    List<User> findAll();
    User getUserByUserName(String userName);
    @Query(value = "SELECT MAX (id) FROM User ")
    int getMaxId();
    @Query(value = "SELECT COUNT(id) FROM User")
    int getCount();
}
