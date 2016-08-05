package com.meila.dal.slave.dao;

import java.util.List;

import com.vdlm.dal.model.Tag;

public interface TagSlaveDao {

    List<Tag> selectByProductId(String id);


    
    
}
