package com.demo.service;

import com.demo.dao.BBDao;
import com.demo.entity.BB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BBServiceImpl implements BBService{
    @Autowired
    BBDao bbDao;

    @Override
    public BB findByIdAndIdMaster(Integer id, Integer idMaster) {
        return bbDao.findBBByIdAndIdMaster(id,idMaster);
    }

    @Override
    public BB findByBBNameAndIdMaster(String bbName, Integer idMaster) {
        return bbDao.findBBByBbNameAndIdMaster(bbName,idMaster);
    }

    @Override
    public BB save(BB bb) {
        return bbDao.save(bb);
    }
}
