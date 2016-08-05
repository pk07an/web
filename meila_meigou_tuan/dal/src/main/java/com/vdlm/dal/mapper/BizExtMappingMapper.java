package com.vdlm.dal.mapper;

import com.vdlm.dal.model.BizExtMapping;


public interface BizExtMappingMapper {
	
    BizExtMapping selectByPrimaryKey(String id);

    BizExtMapping selectByProductId(String productId);
    
    int insert(BizExtMapping record);

    int updateByPrimaryKeySelective(BizExtMapping record);
    
	
}
