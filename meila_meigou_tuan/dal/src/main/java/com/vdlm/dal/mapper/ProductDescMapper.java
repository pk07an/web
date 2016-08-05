package com.vdlm.dal.mapper;

import com.vdlm.dal.model.ProductDesc;


public interface ProductDescMapper {
    int insert(ProductDesc productDesc);

    ProductDesc selectByPrimaryKey(String productId);

    int update(ProductDesc productDesc);

}
