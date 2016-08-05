package com.vdlm.dal.model;

import java.math.BigDecimal;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.type.SkuDisplayEnum;
import com.vdlm.dal.type.SkuTypeEnum;

public class Sku extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;

	private String productId;

	private String spec;
	
	private String spec1;
	
	private String spec2;
	
	private String spec3;
	
	private String spec4;
	
	private String spec5;

	private BigDecimal marketPrice;
	
	private BigDecimal price;

	private Integer amount;
	
	private Integer order;
	
	private String skuUrl;

	private Integer sales;
	
	private String code;

    private SkuTypeEnum skuType;

    private SkuDisplayEnum isDisplay;
    
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getSpec1() {
		return spec1;
	}

	public void setSpec1(String spec1) {
		this.spec1 = spec1;
	}

	public String getSpec2() {
		return spec2;
	}

	public void setSpec2(String spec2) {
		this.spec2 = spec2;
	}

	public String getSpec3() {
		return spec3;
	}

	public void setSpec3(String spec3) {
		this.spec3 = spec3;
	}

	public String getSpec4() {
		return spec4;
	}

	public void setSpec4(String spec4) {
		this.spec4 = spec4;
	}

	public String getSpec5() {
		return spec5;
	}

	public void setSpec5(String spec5) {
		this.spec5 = spec5;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getSkuUrl() {
		return skuUrl;
	}

	public void setSkuUrl(String skuUrl) {
		this.skuUrl = skuUrl;
	}

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

    public SkuTypeEnum getSkuType() {
        return skuType;
    }

    public void setSkuType(SkuTypeEnum skuType) {
        this.skuType = skuType;
    }

    public SkuDisplayEnum getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(SkuDisplayEnum isDisplay) {
        this.isDisplay = isDisplay;
    }
}