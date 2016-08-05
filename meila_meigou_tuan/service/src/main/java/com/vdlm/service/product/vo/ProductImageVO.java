package com.vdlm.service.product.vo;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vdlm.dal.util.json.JsonResourceUrlSerializer;

/**
 * 商品图片展示
 * 
 * @author huxaya
 *
 */
public class ProductImageVO implements Serializable {
	private String img;

	private Integer width;

	private Integer height;

	@JsonSerialize(using = JsonResourceUrlSerializer.class)
	private String imgUrl;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

}
