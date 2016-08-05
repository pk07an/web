package com.meila.dal.slave.dao;

import java.util.List;

import com.vdlm.dal.model.SkuMapping;

public interface SkuMappingSlaveDao {

    List<SkuMapping> selectByProductId(String productId);
    
}
