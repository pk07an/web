package com.vdlm.dal.model;

import java.math.BigDecimal;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.CommissionStatus;

/**
 * 佣金
 * 
 * @author ahlon
 */
public class Commission extends BaseEntityImpl {

	private static final long serialVersionUID = -6408188940728651337L;

	private String orderItemId;

	private String skuId;

	private BigDecimal price;
	/**
	 * 分佣比例
	 */
	private double rate;

	private Integer amount;
	/**
	 * 分拥金额
	 */
	private BigDecimal fee;
	/**
	 * 分佣用户
	 */
	private String userId;
	
	private Boolean withdrawn;
	
	private CommissionStatus status;

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public CommissionStatus getStatus() {
		return status;
	}

	public void setStatus(CommissionStatus status) {
		this.status = status;
	}

	public Boolean getWithdrawn() {
		return withdrawn;
	}

	public void setWithdrawn(Boolean withdrawn) {
		this.withdrawn = withdrawn;
	}
	
}
