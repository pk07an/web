package com.vdlm.dal.mapper;

import java.util.List;

import com.vdlm.dal.model.SmsMessage;

public interface SmsMessageMapper {
	
	int insert(SmsMessage record);
	
	int update(SmsMessage message);
	
	List<SmsMessage> selectFail();

}
