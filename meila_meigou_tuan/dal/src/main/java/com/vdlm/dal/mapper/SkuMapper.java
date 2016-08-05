package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Sku;

public interface SkuMapper {
    
	int insert(Sku record);

	Sku selectByPrimaryKey(String id);
	
	Sku selectOriginalById(String id);
	
	Sku selectByCode(String code);
	
	Sku select(String productId,String skuId);
	
    int updateForArchive(String id);

    int updateByPrimaryKeySelective(Sku record);
    
    int updateAmount(String id, Integer amount);
    
    List<Sku> selectByProductId(String id);

    
//	void deductAmountByOrderId(String orderId);

//	void restoreAmountByOrderId(String orderId);

	int updatePriceDiscountByShop(@Param("shopId") String shopId, @Param("discount") Float discount);

    int updatePriceDiscount(@Param("productId") String productId, @Param("discount") Float discount);

    int updatePriceReduction(@Param("productId") String productId, @Param("reduction") Float reduction);

    int updatePriceFromMarketPriceByShop(@Param("shopId") String shopId);

    int updatePriceFromMarketPrice(@Param("productId") String productId);

	List<Sku> selectByIds(String... ids);
	
	List<Sku> selectByIdList(@Param("ids")List<String> ids);
    
	int addCode(@Param("id")String id);

    int updateSaleBySkuId(@Param("skuId") String skuId, @Param("sale")Integer sale);
}