package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.util.json.JsonResourceUrlSerializer;
import com.vdlm.dal.vo.OrderItemCommentVO;

public class OrderItem extends BaseEntityImpl {
	
	private static final long serialVersionUID = 1L;
	private String orderId; // 所属订单
	private String productId; // 商品
	private String skuId;
	private String productName;
	private String skuStr;
	private String productImg;
	private Integer ProductImgWidth;
	private Integer ProductImgHeight;
	private BigDecimal price;
	private BigDecimal marketPrice;
	private Integer amount;
	private Boolean special;
    private Boolean freeCost; //是否为免费赠送
    private String storageType;
    private Integer productPrepareDays;
    private Integer logisticsInternaDays;
    @JsonSerialize(using = JsonResourceUrlSerializer.class)
    private String productImgUrl;
    
	public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

	public Integer getProductPrepareDays() {
        return productPrepareDays;
    }

    public void setProductPrepareDays(Integer productPrepareDays) {
        this.productPrepareDays = productPrepareDays;
    }

    public Integer getLogisticsInternaDays() {
        return logisticsInternaDays;
    }

    public void setLogisticsInternaDays(Integer logisticsInternaDays) {
        this.logisticsInternaDays = logisticsInternaDays;
    }


    private List<OrderItemCommentVO> comments;
	
	private String productCode;
	
	private boolean isShowLookBtn;  //是否显示查看点评按钮

	public boolean isShowLookBtn() {
		return isShowLookBtn;
	}

	public void setShowLookBtn(boolean isShowLookBtn) {
		this.isShowLookBtn = isShowLookBtn;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSkuStr() {
		return skuStr;
	}

	public void setSkuStr(String skuStr) {
		this.skuStr = skuStr;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}
	
	public String getTitle() {
		return "无".equals(this.skuStr) ? this.productName : this.productName + "[" + this.skuStr + "]";
	}

    public Boolean getSpecial() {
        return special;
    }

    public void setSpecial(Boolean special) {
        this.special = special;
    }

	public Boolean getFreeCost() {
		return freeCost;
	}

	public void setFreeCost(Boolean freeCost) {
		this.freeCost = freeCost;
	}

	public List<OrderItemCommentVO> getComments() {
		return comments;
	}

	public void setComments(List<OrderItemCommentVO> comments) {
		this.comments = comments;
	}

	public Integer getProductImgWidth() {
		return ProductImgWidth;
	}

	public void setProductImgWidth(Integer productImgWidth) {
		ProductImgWidth = productImgWidth;
	}

	public Integer getProductImgHeight() {
		return ProductImgHeight;
	}

	public void setProductImgHeight(Integer productImgHeight) {
		ProductImgHeight = productImgHeight;
	}

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}