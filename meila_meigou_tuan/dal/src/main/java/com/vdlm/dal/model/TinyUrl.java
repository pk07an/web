package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

/**
 * 短地址
 * @author znu991
 *
 */
public class TinyUrl extends BaseEntityImpl {
	private static final long serialVersionUID = 1L;
	private String key;
	private String url;
	private String md5;

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

}
