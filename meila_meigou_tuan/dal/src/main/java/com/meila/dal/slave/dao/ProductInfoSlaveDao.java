package com.meila.dal.slave.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.ProductInfo;


public interface ProductInfoSlaveDao {

    ProductInfo selectByProductId(long productId);
    List<ProductInfo> selectProductInfoByProductIds(@Param("productIds") Set<Long> productIds);
    
    List<ProductInfo> selectProductInfoJoinOrderItemByOrderIds(@Param("orderIds") Set<String> orderIds);
}
