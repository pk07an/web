package com.meila.dal.slave.dao;

import com.vdlm.dal.model.User;

public interface UserSlaveDao {

    User selectByPrimaryKey(String id);
    
    User loadByCode(String code);
}
