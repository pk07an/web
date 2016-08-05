package com.vdlm.dal.mapper;

import java.util.List;

import com.vdlm.dal.model.ProductTag;

public interface ProductTagMapper {
	
    int updateForArchive(String id);
    
    int updateForUnArchive(String id);

    int insert(ProductTag record);

    ProductTag selectByPrimaryKey(String id);
    
    /**
     * 根据商品ID获取所有的Tag列表
     * @param productId
     * @return
     */
	List<ProductTag> selectByProductId(String productId);
	
	/**
     * 根据店铺ID获取所有的Tag列表
     * @param productId
     * @return
     */
	List<ProductTag> selectByShopId(String shopId);
	
}