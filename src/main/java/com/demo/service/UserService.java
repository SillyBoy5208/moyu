package com.demo.service;

import com.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService  {
    User getUserById(int userId);

    boolean addUser(User record);

    List<User> getAll();
}
