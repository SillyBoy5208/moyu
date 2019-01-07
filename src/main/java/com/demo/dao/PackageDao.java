package com.demo.dao;

import com.demo.entity.Package;
import com.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageDao extends JpaSpecificationExecutor<Package>, JpaRepository<Package,Integer> {
    Package findPackageById(int id);
}
