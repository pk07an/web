package com.vdlm.service.product;

import com.vdlm.dal.model.Product;
import com.vdlm.service.product.vo.ProductSkuVO;

/**
 * @类名： MeiLaProductService.java 
 * @描述：商品接口
 * @作者： Toney
 * @修改日期： 2015年7月14日
 */
public interface MeiLaProductService {

    ProductSkuVO loadById(String productId, String skuId);

    /**
     * 功能描述：同时处理商品的销量
     * @param sale
     */
    void deductionSale(String productId, String skuId, Integer sale);

    Product selectByProductCode(String productCode);

}
