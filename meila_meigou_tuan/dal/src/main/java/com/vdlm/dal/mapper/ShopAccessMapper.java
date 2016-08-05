package com.vdlm.dal.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.ShopAccess;
import com.vdlm.dal.vo.ShopAccessEx;

public interface ShopAccessMapper {
    
    int insert(ShopAccess record);
    
    List<ShopAccess> selectShopAccessByShopId(@Param(value="shopId") String shopId, @Param(value="date") Date date);
    
    int updatePvByPrimaryKey(ShopAccess record);
    
    List<ShopAccessEx> selectAccessUvByShopId(@Param(value="shopId") String shopId, @Param(value="date") Date date);
    
    int countByShopId(@Param(value="shopId") String shopId, @Param(value="date") Date date);
    
}