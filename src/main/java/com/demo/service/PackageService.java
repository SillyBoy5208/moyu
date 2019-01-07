package com.demo.service;

import com.demo.dao.PackageDao;
import com.demo.entity.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface PackageService {
    public void  save(Package p);
    public Package findById(Integer userId);
}
