package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.FeedbackStatus;

public class Feedback extends BaseEntityImpl {
	
	private static final long serialVersionUID = 1L;
	
	private String userId;
	
	private String name;
	
	private String content;

    private String contact;
    
    private FeedbackStatus status;
    
    private String replay;
    
    private FeedbackType type;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public FeedbackStatus getStatus() {
		return status;
	}

	public void setStatus(FeedbackStatus status) {
		this.status = status;
	}

	public String getReplay() {
		return replay;
	}

	public void setReplay(String replay) {
		this.replay = replay;
	}

	public FeedbackType getType() {
		return type;
	}

	public void setType(FeedbackType type) {
		this.type = type;
	}
    
}
