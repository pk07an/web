package com.meila.dal.slave.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Sku;
import com.vdlm.dal.type.SkuDisplayEnum;


public interface SkuSlaveDao {

    List<Sku> selectByProductId(String id);

    /**
     * 根据显示状态查询
     * @param id
     * @param show
     * @return
     */
    List<Sku> selectByProductIdAndDisplay(@Param("id") String id, @Param("isDisplay") SkuDisplayEnum isDisplay);

    /**
     * 根据productId查询sku的库存
     * @param prodcutId
     * @return
     */
    List<Sku> selectSkuAmountByProductId(String prodcutId);

    
    
}
