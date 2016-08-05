package com.meila.dal.slave.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.Product;

public interface ProductSlaveDao {

    Product selectByCode(String code);

    Map<String, Object> loadExt(String productId);
    
    long countProductListByUserID(@Param("userId") String userId);

    List<Product> selectSimilarProduct(@Param("shopId")String shopId, @Param("excludeCode")String excludeCode, @Param("page")Pageable page);

    List<Product> selectProductListByUserID(@Param("userId") String userId, @Param(value="page") Pageable page);
    
    String selectWareIdByCode(@Param("code") String code);
    
    /**
     * 查询商品库存
     * @param code
     * @return
     */
    Integer selectProductAmountByCode(@Param("code") String code);
    
    /**
     * 
     *
     * 功能描述：通过skuid获取对应的商品code
     * 
     * @param skuId
     * @return String
     *
     */
    String selectProductCodeBySkuId(@Param("skuId") String skuId);
    
    List<Product> selectCollectionProductByProductIds(@Param("productIds") List<String> productIds);
}
