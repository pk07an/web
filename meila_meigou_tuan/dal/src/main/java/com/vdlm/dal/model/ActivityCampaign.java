package com.vdlm.dal.model;

import com.vdlm.dal.status.ActivityCampaignStatus;

/**
 * 报名活动
 * 
 * @author tonghu
 */
public class ActivityCampaign {
    // 活动id
    private String activityId;
    // 报名店铺id
    private String shopId;
    // 申请状态
    private ActivityCampaignStatus status;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public ActivityCampaignStatus getStatus() {
        return status;
    }

    public void setStatus(ActivityCampaignStatus status) {
        this.status = status;
    }
}
