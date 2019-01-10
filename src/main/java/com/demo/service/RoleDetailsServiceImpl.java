package com.demo.service;

import com.demo.dao.RoleDetailsDao;
import com.demo.entity.RoleDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleDetailsServiceImpl implements RoleDetailsService{
    @Autowired
    RoleDetailsDao roleDetailsDao;
    @Override
    public RoleDetails getRoleDetailsById(int id) {
        RoleDetails roleDetails = roleDetailsDao.findById(id);
        return roleDetails;
    }

    @Override
    public RoleDetails getRoleDetailsByName(String name) {
        return roleDetailsDao.findByName(name);
    }
}
