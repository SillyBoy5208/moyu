package com.demo.service;

import com.demo.entity.Equipage;

public interface EquipageService {
    Equipage findEquipage(String userName,String equipageName);
    Equipage save(Equipage equipage);
}
