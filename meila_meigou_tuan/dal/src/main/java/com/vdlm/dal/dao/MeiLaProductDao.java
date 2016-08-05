package com.vdlm.dal.dao;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Product;

public interface MeiLaProductDao {
    public Product selectById(@Param("id") String id);
    /**
     * 功能描述：返库存使用
     * @param id
     * @return
     */
    public int refundAmountAndSales(@Param("id") String id,@Param("amount") int amount);
}
