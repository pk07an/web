package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.type.FileBelong;

public class Image extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;

	private String key;
	
	private String name; // 文件名
	
	private Integer size;
	
	private Integer width;
	
	private Integer height;
	
	private String suffix;
	
	private String imageAve;//图片主色调
	
	private Boolean archive;

	private FileBelong belong;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public FileBelong getBelong() {
		return belong;
	}

	public void setBelong(FileBelong belong) {
		this.belong = belong;
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
