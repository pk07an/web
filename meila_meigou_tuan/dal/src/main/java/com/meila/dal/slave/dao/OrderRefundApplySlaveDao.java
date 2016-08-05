package com.meila.dal.slave.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.OrderRefundApplyVO;

public interface OrderRefundApplySlaveDao {
	List<OrderRefundApplyVO> selectRefundApplyByOrderNo(@Param("orderNo") String orderNo,@Param("buyerId") String buyerId);
}
