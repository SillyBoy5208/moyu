package com.demo.service;

import com.demo.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int userId);

    boolean addUser(User record);

    List<User> getAll();
}
