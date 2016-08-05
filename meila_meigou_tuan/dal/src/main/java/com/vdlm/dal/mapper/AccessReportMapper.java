package com.vdlm.dal.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.AccessReport;

public interface AccessReportMapper {
	int insert(AccessReport record);

	AccessReport selectByPrimaryKey(String id);

	AccessReport selectByShopAndDate(@Param("shopId") String shopId, @Param("date") Date date);
	
	Long countReportByDate(@Param("date") Date date);

}