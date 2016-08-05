package com.vdlm.biz.vo;

import com.vdlm.dal.BaseEntity;

public class UpLoadFileVO implements BaseEntity {

	private static final long serialVersionUID = 1L;
	private String id;
	private String url;
	private String name;
	private String key;
	private Integer size;
	private Integer width;
	private Integer height;
	private String suffix;
	private String imageAve;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getImageAve() {
		return imageAve;
	}

	public void setImageAve(String imageAve) {
		this.imageAve = imageAve;
	}
	
	
}
