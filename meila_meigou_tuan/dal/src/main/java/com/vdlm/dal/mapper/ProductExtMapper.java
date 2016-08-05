package com.vdlm.dal.mapper;

import com.vdlm.dal.model.ProductExt;

public interface ProductExtMapper {
	
    ProductExt selectByPrimaryKey(String id);

    ProductExt selectByProductId(String productId);
    
    int insert(ProductExt record);

    int updateByPrimaryKeySelective(ProductExt record);
    
	
}
