package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.ProductImage;

public interface ProductImageMapper {
	
    int updateForArchive(String id);
    
    int updateForUnArchive(String id);
    
    int insert(ProductImage record);
    
    /**
     * 根据商品ID获取所有的Image列表
     * @param productId
     * @return
     */
	List<ProductImage> selectByProductId(String productId);

	int updateImgOrder(ProductImage img);
	
	List<ProductImage> getProductImgs(@Param("productId")String productId,@Param("type")String type);
	
	ProductImage selectByImg(@Param("img")String img);
	
}