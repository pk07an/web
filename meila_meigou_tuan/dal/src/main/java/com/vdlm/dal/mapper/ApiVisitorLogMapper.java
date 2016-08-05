package com.vdlm.dal.mapper;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.ApiVisitorLog;

public interface ApiVisitorLogMapper {

	int insert(@Param("userId") String userId, @Param("url") String url);

	int visit(String id);

	ApiVisitorLog findByUserAndUrl(@Param("userId") String userId, @Param("url") String url);
}
