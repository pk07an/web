package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.SmsSendStatus;

/**
 * 短信发送记录
 * @author taiyi
 *
 */
public class SmsSendRecord extends BaseEntityImpl {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String appId;
	
	private String mobile;
	
	private String content;
	
	private SmsSendStatus status;
	

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public SmsSendStatus getStatus() {
		return status;
	}

	public void setStatus(SmsSendStatus status) {
		this.status = status;
	}
	
	
	

}
