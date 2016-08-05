package com.vdlm.dal.mapper;

import java.util.List;

import com.vdlm.dal.model.CartItem;

public interface CartItemMapper {
	
	int deleteByPrimaryKey(String id);

	int undeleteByPrimaryKey(String id);

	int deleteByUserId(String userId);
	
    int deleteBySku(String skuId);

    int insert(CartItem record);

	CartItem selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(CartItem record);

	int updateByPrimaryKey(CartItem record);

	List<CartItem> selectByUserId(String userId);

	CartItem selectByUserIdAndSku(String userId, String skuId);

	List<CartItem> selectByUserIdAndShopId(String userId, String shopId);

	int deleteByUserIdAndSkuId(String userId, String skuId);

    int deleteByUserIdAndShopId(String id, String shopId);

    Integer selectCount(String userId);
}