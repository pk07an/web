package com.vdlm.dal.mapper;

import java.util.List;

import com.vdlm.dal.model.PushMessage;

public interface PushMessageMapper {
	
	int insert(PushMessage record);

	PushMessage selectByPrimaryKey(String id);
	
	int update(PushMessage message);
	
	List<PushMessage> selectFail();

}
