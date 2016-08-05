package com.vdlm.dal.vo;

import com.vdlm.dal.status.OrderStatus;

/**
 * 
 ************************************************************
 * @类名 : OrderQuantityVO.java
 *
 * @DESCRIPTION : 统计各状态下的订单数量VO
 * @AUTHOR :  meila-x Jacky
 * @DATE :  2015年12月30日
 ************************************************************
 */
public class OrderQuantityVO {
    
    /**
     * 数量
     */
    private Long orderQuantity;
    
    /**
     * 状态
     */
    private OrderStatus orderStatus;

    public Long getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Long orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    
}
