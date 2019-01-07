package com.demo.dao;

import com.demo.entity.BB;
import com.demo.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BBDao extends JpaSpecificationExecutor<BB>, JpaRepository<BB,Integer> {
    BB findBBByIdAndIdMaster(Integer id, Integer idMaster);
    BB findBBByBbNameAndIdMaster(String name,Integer idMaster);
}
