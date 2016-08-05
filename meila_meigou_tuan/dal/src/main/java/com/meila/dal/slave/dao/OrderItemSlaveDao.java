package com.meila.dal.slave.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.OrderItem;

public interface OrderItemSlaveDao {

	OrderItem selectByPrimaryKey(String id);

	List<OrderItem> selectOrderItemsByOrderNoAndBuyerId(@Param("orderNo") String orderNo,@Param("buyerId") String buyerId);
}
