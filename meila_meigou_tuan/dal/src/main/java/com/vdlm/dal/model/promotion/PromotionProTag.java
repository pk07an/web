package com.vdlm.dal.model.promotion;
import com.vdlm.dal.BaseEntityImpl;
/**
 * 营销活动标记
 * @author zhuyin
 *
 */
public class PromotionProTag extends BaseEntityImpl{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  shopId;
	private String  productId;
	private String  tagId;
	private String  type;
	private Boolean archive;
	
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

}
