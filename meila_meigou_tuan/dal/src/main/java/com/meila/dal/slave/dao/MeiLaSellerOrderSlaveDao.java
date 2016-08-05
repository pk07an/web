package com.meila.dal.slave.dao;

import com.vdlm.dal.vo.OrderQuantityVO;
import com.vdlm.dal.vo.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MeiLaSellerOrderSlaveDao {
	List<OrderVO> selectOrderBySeller(@Param("status") String status, @Param("sellerId") String sellerId, @Param("pager") Pageable pageable);
	
	 /** 
     * 获取各个状态下的订单数量
     * @param shopId 店铺Id
     * @return Map 键值对
     * @exception {说明在某情况下,将发生什么异常}
     */
	List<OrderQuantityVO> getOrderQuantity(@Param(value = "shopId") String shopId);

	OrderVO queryByOrderNo(@Param(value = "orderNo") String orderNo, @Param(value = "sellerId") String sellerId);
	
	Long countBySellerIdAndStatus(@Param(value = "sellerId") String sellerId, @Param(value = "status") String status);
}
