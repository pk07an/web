package com.vdlm.dal.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @类名： MeiLaSkuMapper.java 
 * @描述：SKU 的相关数据库操作
 * @作者： Toney
 * @修改日期： 2015年7月16日
 */
public interface MeiLaSkuDao {
    public int refundSkuAmount(@Param("skuId") String skuId,@Param("amount") int amount);
}
