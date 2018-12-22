package com.demo.service;

import com.demo.entity.User;

public interface UserService {
    User getUserById(int userId);

    boolean addUser(User record);
}
