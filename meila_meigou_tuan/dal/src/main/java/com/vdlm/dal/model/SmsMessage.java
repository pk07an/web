package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.SmsMessageStatus;
import com.vdlm.dal.type.SmsMessageType;

/**
 * 发送短消息失败的重试机制
 * @author odin
 *
 */
public class SmsMessage extends BaseEntityImpl {
	
	private static final long serialVersionUID = 1L;

	private String phone;

	private String content;
	
	private SmsMessageType type;
	
	private SmsMessageStatus status;
	
	private Integer count;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public SmsMessageType getType() {
		return type;
	}

	public void setType(SmsMessageType type) {
		this.type = type;
	}

	public SmsMessageStatus getStatus() {
		return status;
	}

	public void setStatus(SmsMessageStatus status) {
		this.status = status;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
