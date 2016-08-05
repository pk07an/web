package com.vdlm.dal.mapper;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.OrderRefundApply;
import com.vdlm.dal.status.RefundStatus;

public interface OrderRefundApplyMapper {
	//插入退款数据
	int insertOrderRefundApply(OrderRefundApply orderRefundApply);
	/**
	 * 买家取消退款，更新退款状态以及时间
	 * @param id
	 * @param refundStatus
	 * @return
	 */
	int updateOrderRefundStatusById(@Param("id") String id,@Param("refundStatus") RefundStatus refundStatus);
	
	/**
	 * 用于卖家退款操作
	 * @param id
	 * @param remark
	 * @param refundStatus
	 * @return
	 */
	int updateOrderRefundById(@Param("id") String id,@Param("sellerId") String sellerId,@Param("remark") String remark,@Param("refundStatus") RefundStatus refundStatus);
}
