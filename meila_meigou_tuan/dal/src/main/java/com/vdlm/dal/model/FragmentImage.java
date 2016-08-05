package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

public class FragmentImage extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	
	private String fragmentId;
	private String img;
	private Integer imgWidth;
	private Integer imgHeight;
	private Integer idx;

	public String getFragmentId() {
		return fragmentId;
	}

	public void setFragmentId(String fragmentId) {
		this.fragmentId = fragmentId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Integer getImgWidth() {
		return imgWidth;
	}

	public void setImgWidth(Integer imgWidth) {
		this.imgWidth = imgWidth;
	}

	public Integer getImgHeight() {
		return imgHeight;
	}

	public void setImgHeight(Integer imgHeight) {
		this.imgHeight = imgHeight;
	}

}
