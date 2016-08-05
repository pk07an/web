package com.vdlm.dal.mapper;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.AppVersion;
import com.vdlm.dal.type.OSType;

public interface AppVersionMapper {
	AppVersion findCurrentVersion(@Param("clientVersion") int userVersion, @Param("os")OSType osType);
}