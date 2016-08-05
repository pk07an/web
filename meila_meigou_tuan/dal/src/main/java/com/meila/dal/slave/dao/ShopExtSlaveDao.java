package com.meila.dal.slave.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.ShopExt;
import com.vdlm.dal.model.ShopExtExample;

public interface ShopExtSlaveDao {

    List<ShopExt> selectByExample(ShopExtExample example);

    List<ShopExt> selectByShopIds(@Param("shopIds") List<String> shopIds);
}
