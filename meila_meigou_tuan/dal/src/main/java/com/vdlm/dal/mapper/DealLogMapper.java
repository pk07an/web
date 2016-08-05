package com.vdlm.dal.mapper;

import java.util.List;

import com.vdlm.dal.model.Deal;
import com.vdlm.dal.model.DealLog;

public interface DealLogMapper {

	int insert(DealLog record);
	
	Deal selectByPrimaryKey(String id);
	
	List<DealLog> selectByDealId(String dealId);
	
}
