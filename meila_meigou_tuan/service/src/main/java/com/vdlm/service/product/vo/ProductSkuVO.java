package com.vdlm.service.product.vo;

import org.springframework.beans.BeanUtils;

import com.vdlm.dal.model.Product;
import com.vdlm.dal.model.Sku;

/**
 * 用于展现商品的单个SKU信息
 * 
 * @author odin
 */
public class ProductSkuVO extends Product {

	private static final long serialVersionUID = 1L;
	
	private Integer amount;

	private Sku sku;
	
	public ProductSkuVO(Product product) {
		BeanUtils.copyProperties(product, this);
	}

	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}
	
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	
}
