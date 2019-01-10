package com.demo.dao;

import com.demo.entity.RoleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleDetailsDao extends JpaSpecificationExecutor<RoleDetails>, JpaRepository<RoleDetails,Integer> {
    RoleDetails findById(int id);
    RoleDetails findByName(String name);
    RoleDetails findByIdAndName(int id,String name);
}
