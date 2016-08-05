package com.vdlm.dal.model;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;

public class ProductImage extends BaseEntityImpl implements Archivable {
	
    private static final long serialVersionUID = 1L;

    private String productId;

    private String img;
    
    private Integer imgWidth;
    
    private Integer imgHeight;
    
    private Boolean archive;
    
    private int imgOrder;

    private Integer type;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public Boolean getArchive() {
		return archive;
	}

	@Override
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public int getImgOrder() {
		return imgOrder;
	}

	public void setImgOrder(int imgOrder) {
		this.imgOrder = imgOrder;
	}

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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