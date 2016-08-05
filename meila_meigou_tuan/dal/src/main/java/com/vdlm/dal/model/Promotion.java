package com.vdlm.dal.model;

import java.math.BigDecimal;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.type.PromotionScope;

/**
 * 
 * @author ahlon
 *
 */
public class Promotion extends BaseEntityImpl {

    private static final long serialVersionUID = 4485622304685973150L;

    /**
     * 优惠活动标题
     */
    private String title;
    
    /**
     * 优惠活动详情
     */
    private String details;
    
    /**
     * 优惠活动生效范围
     */
    private PromotionScope scope;
    
    /**
     * 折扣
     */
    private BigDecimal discount;
    
    /**
     * 补贴的用户id
     */
    private String allowanceUserId;
    
    private Boolean archive;

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

    public PromotionScope getScope() {
        return scope;
    }

    public void setScope(PromotionScope scope) {
        this.scope = scope;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getAllowanceUserId() {
        return allowanceUserId;
    }

    public void setAllowanceUserId(String allowanceUserId) {
        this.allowanceUserId = allowanceUserId;
    }
        
}
