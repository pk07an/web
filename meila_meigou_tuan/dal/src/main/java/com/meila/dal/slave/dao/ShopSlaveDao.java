package com.meila.dal.slave.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Shop;

public interface ShopSlaveDao {


    Shop selectByPrimaryKey(String id);


    Shop selectByCode(@Param(value="code") String code);
    
    List<Shop> selectByIdList(@Param(value="ids") Set<String> shopIds);
}
