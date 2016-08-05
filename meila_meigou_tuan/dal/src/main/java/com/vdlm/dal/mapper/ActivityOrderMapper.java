package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.ActivityOrder;

public interface ActivityOrderMapper {

	int insertRandom(@Param("activityId") String activityId, @Param("partnerType") String partnerType);
	
	int insertDirectByOrderNo(@Param("activityId") String activityId, @Param("orderNo") String orderNo);
	
	int updateStatusConfirmed(@Param("id") String id);
	
	int updateStatusFinish(@Param("id") String id);
	
	int updateStatusCancel(@Param("id") String id);
	
	List<ActivityOrder> listByAdmin(@Param(value="params")Map<String, Object> params, @Param(value="page") Pageable page);
	
	int countByAdmin(@Param(value="params")Map<String, Object> params);
	
	ActivityOrder selectByPrimaryKey(@Param("id") String id);
}
