package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.OrderAddress;

public interface OrderAddressMapper {
	
    int insert(OrderAddress record);

    OrderAddress selectByPrimaryKey(String id);
    
    OrderAddress selectByOrderId(String orderId);
    
    int updateForArchive(String addressId);

	void update(OrderAddress oa);

	/**
	 * 查询订单的完整收货地址
	 * @param orderIds
	 * @return
	 */
	List<OrderAddress> selectfullAddressByOrderId(@Param(value="orderIds") List<String> orderIds);
    
}