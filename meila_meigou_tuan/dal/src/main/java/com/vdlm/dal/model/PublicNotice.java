package com.vdlm.dal.model;

import java.util.Date;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.NoticeType;

public class PublicNotice extends BaseEntityImpl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title; //描述
	private NoticeType noticeType; //类型
	private String imagePath; //图标地址
	private String jumpUrl;//跳转地址
	private String content;//文本内容
	private Date startTime;//开始时间
	private Date endTime;//结束时间
	private Boolean archive;//有效标志 

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public NoticeType getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(NoticeType noticeType) {
		this.noticeType = noticeType;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getJumpUrl() {
		return jumpUrl;
	}

	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

}
