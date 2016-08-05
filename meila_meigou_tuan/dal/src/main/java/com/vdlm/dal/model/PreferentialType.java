package com.vdlm.dal.model;

public interface PreferentialType {
    
    public static int SHOP_DISCOUNT = 1;
    public static int ACTIVITY_PRODUCT_DISCOUNT = 2;
    public static int PRODUCT_REDUCTION_PRICE = 3;
    
    /*
    SHOP_DISCOUNT(1), // 全店折扣
    ACTIVITY_PRODUCT_DISCOUNT(2), // 活动商品折扣
    PRODUCT_REDUCTION_PRICE(3); // 商品减价
    
    private PreferentialType(int value) {
        this.value = value;
    }
    
    private int value;
    
    public String toString() {
        return String.valueOf(this.value);
    }
    */
}
