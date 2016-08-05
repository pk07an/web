package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.UserMessageStatus;

public class UserMessage extends BaseEntityImpl {

	private static final long serialVersionUID = 3565732833808136066L;

	private String fromUserId;
	
	private String toUserId;
	
	private String msgId;
	
	private UserMessageStatus status;

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public UserMessageStatus getStatus() {
		return status;
	}

	public void setStatus(UserMessageStatus status) {
		this.status = status;
	}

}
