package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.PostAgeSet;

public interface PostAgeSetMapper {

	PostAgeSet selectByPrimaryKey(String id);
	
	List<PostAgeSet> selectByShopId(@Param("shopId") String shopId);
	
	Long insert(PostAgeSet record);
	
	Long update(PostAgeSet record);
	
	int deleteByPrimaryKey(String id);

}