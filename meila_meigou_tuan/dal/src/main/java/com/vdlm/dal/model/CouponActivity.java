package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.vdlm.dal.type.CouponGrantRule;

public class CouponActivity {
    
    private String id;
    
    private String actCode;
    
    private String title;
    
    private String details;
    
    // add by luojy 20150703
    private CouponGrantRule grantRule;
    
    /**
     * 最低消费
     */
    private BigDecimal minPrice;
    
    /**
     * 优惠额度
     */
    private BigDecimal discount;
    
    /**
     * 当前是否有效
     */
    private boolean valid;  // default true
    
    private boolean autoUse; // default false
    
    private Date validFrom;
    
    private Date validTo;
    
    private Date createdAt;
    
    private Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActCode() {
		return actCode;
	}

	public void setActCode(String actCode) {
		this.actCode = actCode;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isAutoUse() {
        return autoUse;
    }

    public void setAutoUse(boolean autoUse) {
        this.autoUse = autoUse;
    }
    

    // add by luojy 20150703
    public CouponGrantRule getGrantRule() {
		return grantRule;
	}

	public void setGrantRule(CouponGrantRule grantRule) {
		this.grantRule = grantRule;
	}
}
