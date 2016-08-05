package com.vdlm.dal.model;

import java.util.Date;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.type.ActivityChannel;
import com.vdlm.dal.type.ActivityStatus;
import com.vdlm.dal.type.ActivityType;

public class Activity extends BaseEntityImpl implements Archivable {
   
	private static final long serialVersionUID = 1L;
	
	// 活动名称
	private String name;
	
	// 头像
	private String img;

	// 活动banner
    private String banner;
    
    // 活动类型
    private ActivityType type;
    
	// 活动开始时间
    private Date startTime;
 
    // 活动结束时间
    private Date endTime;
    
    // 活动状态
    private ActivityStatus status;

    // 提醒
    private Boolean remind;
    
    // 活动简述
    private String summary;
    
    // 活动描述
    private String details;
    
    // 持续活动，还是一次性活动
//    private Boolean repeatable;
    
    // 创建用户
    private String creatorId;
    
    private Date actDate;
    
    private Boolean archive;

    private Date closedAt;
    
    private Date applyStartTime;
    private Date applyEndTime;
    private String url;
    private ActivityChannel channel;
    private String tagImage;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getRemind() {
        return remind;
    }

    public void setRemind(Boolean remind) {
        this.remind = remind;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getActDate() {
        return actDate;
    }

    public void setActDate(Date actDate) {
        this.actDate = actDate;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

//    public Boolean getRepeatable() {
//        return repeatable;
//    }
//
//    public void setRepeatable(Boolean repeatable) {
//        this.repeatable = repeatable;
//    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public ActivityStatus getStatus() {
        return status;
    }

    public void setStatus(ActivityStatus status) {
        this.status = status;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

	public Date getApplyStartTime() {
		return applyStartTime;
	}

	public void setApplyStartTime(Date applyStartTime) {
		this.applyStartTime = applyStartTime;
	}

	public Date getApplyEndTime() {
		return applyEndTime;
	}

	public void setApplyEndTime(Date applyEndTime) {
		this.applyEndTime = applyEndTime;
	}
	
	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public ActivityChannel getChannel() {
		return channel;
	}

	public void setChannel(ActivityChannel channel) {
		this.channel = channel;
	}

	public String getTagImage() {
		return tagImage;
	}

	public void setTagImage(String tagImage) {
		this.tagImage = tagImage;
	}
}