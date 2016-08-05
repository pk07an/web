package com.vdlm.dal.vo;

import com.vdlm.dal.model.Product;
import com.vdlm.dal.mybatis.IdTypeHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * bos系统用到的vo
 * @author huxaya
 *
 */
public class ProductAdmin extends Product {
	
	private static final long serialVersionUID = 1L;
	
	private String shopName;
	
	private String phone;

	private String img;
	
	private String imgUrl;

	private String decode_id;//数据库中的id 通过idTypeHandlder解码后的值 add by reese

    public String getDecode_id() {
        if (StringUtils.isBlank(this.getId())) {
            return "";
        } else {
            return String.valueOf(IdTypeHandler.decode(this.getId()));
        }
    }

    public void setDecode_id(String decode_id) {
        this.decode_id = decode_id;
    }

    public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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
}
