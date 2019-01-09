package com.demo.dao;

import com.demo.entity.Equipage;
import com.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EquipageDao extends JpaSpecificationExecutor<Equipage>, JpaRepository<Equipage,Integer> {
    Equipage findEquipageByUserNameAndEName(String userName,String eName);
}
