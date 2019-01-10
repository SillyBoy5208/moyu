package com.demo.service;

import com.demo.entity.RoleDetails;

public interface RoleDetailsService {
    RoleDetails getRoleDetailsById(int id);
    RoleDetails getRoleDetailsByName(String name);
}
