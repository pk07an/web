package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.MessageStatus;
import com.vdlm.dal.type.MessageType;

public class Message extends BaseEntityImpl {
	
	private static final long serialVersionUID = 5299720757613494127L;

	private String title;
	
	private String content;
	
	private MessageType type;
	
	private String url;
	
	private MessageStatus status;
	
	private String sessId;
	
	private String replyTo;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MessageStatus getStatus() {
		return status;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}

	public String getSessId() {
		return sessId;
	}

	public void setSessId(String sessId) {
		this.sessId = sessId;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}
	
	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
