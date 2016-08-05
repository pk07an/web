package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.SmsTpl;

public interface SmsTplMapper {
	
	SmsTpl load(String id);
	
	List<SmsTpl> loadAll();
	
	List<SmsTpl>selectByParam(@Param(value="params") Map<String, String> params);
	
	int insert(SmsTpl e);

	int delete(String id);
}