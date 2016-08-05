package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class CampaignProduct extends BaseEntityImpl  {

    private static final long serialVersionUID = 8459673242355841783L;
    
    // 参加活动的ticket
    private String ticketId;
    
    // 活动id
    private String activityId;
    
    // 商品id
    private String productId;
    
    // 折扣，多少的折扣off
    private Float discount;
    
    // 优惠，减多少钱
    private Float reduction;
    
    // 活动库存
    private Integer activityAmount;
    
    private Boolean archive; 
    
    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getReduction() {
        return reduction;
    }

    public void setReduction(Float reduction) {
        this.reduction = reduction;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getActivityAmount() {
        return activityAmount;
    }

    public void setActivityAmount(Integer activityAmount) {
        this.activityAmount = activityAmount;
    }
    
    public Boolean getArchive(){
    	return archive;
    }
    public void setArchive(Boolean archive){
    	this.archive = archive;
    }

}
