package com.meila.dal.slave.dao;

import com.vdlm.dal.vo.CategoryVO;

public interface CategorySlaveDao {

    CategoryVO loadCategoryByProductId(String productId);


    
    
}
