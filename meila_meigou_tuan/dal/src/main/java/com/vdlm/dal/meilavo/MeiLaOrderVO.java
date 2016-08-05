package com.vdlm.dal.meilavo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.vdlm.dal.vo.OrderVO;

/**
 * @类名： MeiLaOrderVO.java
 * @描述：考虑子母订单的情况
 * @作者： Toney
 * @修改日期： 2015年6月25日
 */
public class MeiLaOrderVO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8519379124154876729L;
    private String payNo;

    private BigDecimal logisticsFeeTotal=BigDecimal.ZERO; // 总邮费
    private BigDecimal priceTotal=BigDecimal.ZERO; // 总价格
    private BigDecimal discountFee=BigDecimal.ZERO;

    private List<OrderVO> orderVOs;
    private int totalCoin;
    private BigDecimal totalCoinPrice=BigDecimal.ZERO.setScale(2);
    private String orderStatus;
    private String orderNos;
    //key productId,value 是否已点评
    private Map<String,Boolean> isComments;
    // 是否所有商品都已经点评
    private boolean isAllComments;

	public boolean isAllComments() {
		return isAllComments;
	}

	public void setAllComments(boolean isAllComments) {
        this.isAllComments = isAllComments;
    }

    public Map<String, Boolean> getIsComments() {
        return isComments;
    }

    public void setIsComments(Map<String, Boolean> isComments) {
        this.isComments = isComments;
    }

    public String getOrderNos() {
        return orderNos;
    }

    public void setOrderNos(String orderNos) {
        this.orderNos = orderNos;
    }

    public int getTotalCoin() {
        return totalCoin;
    }

    public void setTotalCoin(int totalCoin) {
        this.totalCoin = totalCoin;
    }

    public BigDecimal getTotalCoinPrice() {
        return totalCoinPrice;
    }

    public void setTotalCoinPrice(BigDecimal totalCoinPrice) {
        this.totalCoinPrice = totalCoinPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public List<OrderVO> getOrderVOs() {
        return orderVOs;
    }

    public void setOrderVOs(List<OrderVO> orderVOs) {
        this.orderVOs = orderVOs;
    }

    public BigDecimal getLogisticsFeeTotal() {
        return logisticsFeeTotal;
    }

    public void setLogisticsFeeTotal(BigDecimal logisticsFeeTotal) {
        this.logisticsFeeTotal = logisticsFeeTotal;
    }

    public BigDecimal getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(BigDecimal priceTotal) {
        this.priceTotal = priceTotal;
    }

}
