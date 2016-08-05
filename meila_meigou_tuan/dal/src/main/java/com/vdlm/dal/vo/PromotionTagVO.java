package com.vdlm.dal.vo;

import com.vdlm.dal.model.promotion.PromotionTag;

public class PromotionTagVO extends PromotionTag {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String productId;
    private String shopId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

}
