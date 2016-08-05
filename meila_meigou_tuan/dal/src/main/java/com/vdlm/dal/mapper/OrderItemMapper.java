package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.OrderItem;

public interface OrderItemMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(OrderItem record);

    OrderItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

	List<OrderItem> selectByOrderId(String orderId);

    List<OrderItem> selectByOrderIdList(@Param("ids") List<String> orderIds);
	
}