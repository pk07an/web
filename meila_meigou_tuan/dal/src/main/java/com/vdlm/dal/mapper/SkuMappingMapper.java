package com.vdlm.dal.mapper;

import java.util.List;

import com.vdlm.dal.model.SkuMapping;

public interface SkuMappingMapper {
    int deleteByPrimaryKey(String id);
    
    int deleteByProductId(String id);

    int insert(SkuMapping record);

    SkuMapping selectByPrimaryKey(String id);
    
    List<SkuMapping> selectByProductId(String productId);

    int updateByPrimaryKeySelective(SkuMapping record);
    
    int updateForArchive(String id);
}
