package com.vdlm.dal.model.promotion;
import com.vdlm.dal.BaseEntityImpl;
public class PromotionTag  extends BaseEntityImpl{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String desc;
	
	private String proId;
	private String iconText;
	private String iconType;
	private String jumpUrl;
	
	public String getIconText() {
        return iconText;
    }

    public void setIconText(String iconText) {
        this.iconText = iconText;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	
}
