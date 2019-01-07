package com.demo.service;

import com.demo.dao.PackageDao;
import com.demo.entity.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageServiceImpl implements PackageService{
    @Autowired
    PackageDao packageDao;
    public void  save(Package p){
        packageDao.save(p);
    }
    public Package findById(Integer userId){
       return packageDao.findPackageById(userId);
    }
}
