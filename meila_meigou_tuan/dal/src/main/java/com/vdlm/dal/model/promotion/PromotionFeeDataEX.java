package com.vdlm.dal.model.promotion;

import java.math.BigDecimal;
import java.util.List;

public class PromotionFeeDataEX {

	private List<PromotionFeeData> skuDatas;

	private BigDecimal totalDiscount;

	private BigDecimal totalFee;//暂时不用

	public List<PromotionFeeData> getSkuDatas() {
		return skuDatas;
	}

	public void setSkuDatas(List<PromotionFeeData> skuDatas) {
		this.skuDatas = skuDatas;
	}

	public BigDecimal getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(BigDecimal totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

}
