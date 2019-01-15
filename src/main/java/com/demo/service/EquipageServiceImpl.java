package com.demo.service;

import com.demo.dao.EquipageDao;
import com.demo.entity.Equipage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipageServiceImpl implements EquipageService{
    @Autowired
    EquipageDao equipageDao;
    @Override
    public Equipage findEquipage(String userName, String equipageName) {
        return equipageDao.findEquipageByUserNameAndEName(userName,equipageName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Equipage save(Equipage equipage) {
        return equipageDao.save(equipage);
    }

    @Override
    public Equipage strengthen(Equipage equipage) {
        int mohunLevel = equipage.getMohunLevel();
        if (mohunLevel>=12){

        }
        return null;
    }

    @Override
    public Equipage upgradeEquipage(Equipage equipage) {
        return null;
    }
}
