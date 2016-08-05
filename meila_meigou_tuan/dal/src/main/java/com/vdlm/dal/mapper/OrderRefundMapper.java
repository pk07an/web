package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.OrderRefund;
import com.vdlm.dal.vo.OrderRefundVO;

public interface OrderRefundMapper {
	
	List<OrderRefundVO> list(@Param("sellerId")String sellerId, @Param("page")Pageable pageable );
	
    int deleteByPrimaryKey(Long id);

    int insert(OrderRefund record);

    OrderRefund selectByPrimaryKey(String id);
    
    OrderRefundVO selectVOByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderRefund record);
    
    int updateByModifyRequest(OrderRefund record);
    
    List<OrderRefund> listByOrderId(@Param("orderId")String orderId);
    
    int confirmSellerByAdmin(@Param("id")String id, @Param("adminStatus")String adminStatus, @Param("adminRemark")String adminRemark);
    
	int reject(OrderRefund orderRefund);
	
	int rejectSign(OrderRefund orderRefund);

	int confirm(OrderRefund orderRefund);
	
	int success(OrderRefund orderRefund);

	int ship(OrderRefund orderRefund);

	int cancel(OrderRefund orderRefund);

	int sign(OrderRefund orderRefund);
	
	List<OrderRefundVO> listOrderRefundByAdmin(@Param(value="params") Map<String, Object> params, @Param(value="page") Pageable page);
	
	Long countOrderRefundByAdmin(@Param(value="params") Map<String, Object> params);
}