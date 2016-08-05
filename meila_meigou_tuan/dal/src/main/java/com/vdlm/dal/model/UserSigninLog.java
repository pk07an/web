package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class UserSigninLog extends BaseEntityImpl{
	
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String ip;
	private String client;
	private String browser;
	private String os;
	private String partner;
//	private String deviceSN; //设备号  seker 20150202  先注释掉,后面完善功能再打开 2015-02-03 ladon

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

// 添加设备号功能先注释掉, 后期再完善功能
//	public String getDeviceSN() {
//		return this.deviceSN;
//	}
//
//	public void setDeviceSN(String deviceSN) {
//		this.deviceSN = deviceSN;
//	}
}
