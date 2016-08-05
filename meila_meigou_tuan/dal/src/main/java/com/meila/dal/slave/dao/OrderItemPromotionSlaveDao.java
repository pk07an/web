package com.meila.dal.slave.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface OrderItemPromotionSlaveDao {
	List<Map<String, Object>> selectDiscountFeeMapByOrderItemIds(@Param("orderItemIds")Set<String> orderItemIds);
}
