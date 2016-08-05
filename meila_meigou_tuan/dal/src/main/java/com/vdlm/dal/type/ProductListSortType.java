package com.vdlm.dal.type;

public enum ProductListSortType {
    // HOT("热门"),    // 热门排序
    // SALE("热销"),   // 销量排序
    COMMISSION("分成"),   // 分成 
    FORWARD("转发");       // 转发
    
    // PRICE("价格"); // 价格排序
    
    private ProductListSortType(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    private String name;
}