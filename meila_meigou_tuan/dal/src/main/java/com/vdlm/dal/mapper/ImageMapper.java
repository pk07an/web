package com.vdlm.dal.mapper;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Image;

public interface ImageMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(Image file);

    Image selectByPrimaryKey(String id);
    
    Image selectByImgKey(@Param(value="imgKey") String imgKey);
}
