package com.demo.service;

import com.demo.dto.PageDTO;
import com.demo.dto.PageQueryDTO;
import com.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService  {
    User getUserById(int userId);

    boolean addUser(User record);
    Page<User> queryUsers(PageQueryDTO pageDTO);
    PageDTO<User> queryUsers2(PageQueryDTO pageQueryDTO);
    List<User> getAll();
}
