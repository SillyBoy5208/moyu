package com.demo.service;

import com.demo.entity.BB;

public interface BBService {
    BB findByIdAndIdMaster(Integer id,Integer idMaster);
    BB findByBBNameAndIdMaster(String bbName, Integer idMaster);
    BB save(BB bb);
}
