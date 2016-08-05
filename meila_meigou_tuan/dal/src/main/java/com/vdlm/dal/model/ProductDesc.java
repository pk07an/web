package com.vdlm.dal.model;


import java.util.Date;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;

/**
 * 商品model类
 * 其中price为sku中最低的价格
 * amount为sku中总的库存
 * price和amout为冗余字段，为方便前端显示
 * descImg：存放商品描述的图片， 包含img的值，以逗号相隔
 * @author huxaya
 *
 */

public class ProductDesc extends BaseEntityImpl implements Archivable {

	private static final long serialVersionUID = 6833261783789389122L;
	private String productId;
	private String description;
	private Boolean archive;
	 
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
 
}