package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.ProductInfo;
import com.vdlm.dal.vo.ProductAdmin;
import com.vdlm.dal.vo.ProductExtAdmin;

public interface ProductInfoMapper {
	
    ProductInfo selectByPrimaryKey(String id);

    ProductInfo selectByProductId(long productId);
    
    int insert(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
    
    int updateByProductId(ProductInfo record);
	
    List<ProductExtAdmin> listProductsByAdmin(@Param(value="params") Map<String, Object> params, @Param(value="page") Pageable page);

    Long countProductsByAdmin(@Param(value="params") Map<String, Object> params);
    
    int deleteByAdmin(@Param("ids")String[] ids);
}
