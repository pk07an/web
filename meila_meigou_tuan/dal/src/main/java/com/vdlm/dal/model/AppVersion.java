package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.type.OSType;

public class AppVersion extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;

	private String name;

	private String msg;

	private int clientVersion; //客户端版本，如快快开店版本
	 
	private int fileSize;
	
	private String md5;
	
	private String url;
	
	private boolean forceUpdate;

	private OSType os;
	
	private String osMinVer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(int clientVersion) {
		this.clientVersion = clientVersion;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isForceUpdate() {
		return forceUpdate;
	}

	public void setForceUpdate(boolean forceUpdate) {
		this.forceUpdate = forceUpdate;
	}

	public OSType getOs() {
		return os;
	}

	public void setOs(OSType os) {
		this.os = os;
	}

	public String getOsMinVer() {
		return osMinVer;
	}

	public void setOsMinVer(String osMinVer) {
		this.osMinVer = osMinVer;
	}
}
