package com.meila.dal.slave.dao;

import java.util.List;

import com.vdlm.dal.model.ProductImage;


public interface ProductImageSlaveDao {

    List<ProductImage> selectByProductId(String id);


    
    
}
