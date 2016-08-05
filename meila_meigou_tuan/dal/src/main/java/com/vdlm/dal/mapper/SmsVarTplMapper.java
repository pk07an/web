package com.vdlm.dal.mapper;

import java.util.List;

import com.vdlm.dal.model.SmsVarTpl;

public interface SmsVarTplMapper {
	
	SmsVarTpl load(String id);
	
	List<SmsVarTpl> loadAll();
}
