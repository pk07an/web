package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.Commission;
import com.vdlm.dal.status.CommissionStatus;
import com.vdlm.dal.vo.CommissionVO;

public interface CommissionMapper {

	int insert(Commission record);

	void updateStatus(@Param("orderId") String orderId, @Param("status") CommissionStatus status);

	Commission selectByOrderItem(String id);

	List<Commission> listByOrderId(String orderId);

	List<Commission> listCanWithdraw(@Param("day") Integer day);
	
	Long countCommissionsByAdmin(@Param(value="params")Map<String, Object> params);
	
	List<CommissionVO> listCommissionsByAdmin(@Param(value="params")Map<String, Object> params, @Param(value="page") Pageable page);
	
	void cleanCommissionByOrderId(@Param("orderId") String orderId);
}
