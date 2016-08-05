package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.ShopStatus;

public class Shop extends BaseEntityImpl implements Archivable {
	
	private static final long serialVersionUID = 1L;

	private String ownerId; // 店铺拥有者

	private String img; // 店铺主图

	private String name;// 店铺名称

	private String bulletin; // 店铺公告
	
	private Date bulletinAt; //公告日期

	private String description;// 店铺说明

	private String wechat; // 微信号

	private String banner;// 店铺招牌
	
	private Boolean danbao; //是否开能担保交易，默认为不开通

	private ShopStatus status; // 状态
	
	private BigDecimal commisionRate; // 佣金比例

	private Boolean archive;
	
	private Long provinceId;		// 店铺所在省份
	
	private Long cityId;				// 店铺所在城市
	
	private Boolean postageStatus;	// 是否设置了邮费
	
	private String freeZone;		// 免邮地区
	
	private Long freeZoneId;
	
	private BigDecimal postage;	// 邮费
	
	private Boolean fragmentStatus; //是否使用片段，true:使用、false:不使用，默认false
	
	private String code;

	public Long getFreeZoneId() {
		return freeZoneId;
	}

	public void setFreeZoneId(Long freeZoneId) {
		this.freeZoneId = freeZoneId;
	}
	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBulletin() {
		return bulletin;
	}

	public void setBulletin(String bulletin) {
		this.bulletin = bulletin;
	}
	
	public Date getBulletinAt() {
		return bulletinAt;
	}

	public void setBulletinAt(Date bulletinAt) {
		this.bulletinAt = bulletinAt;
	}

	public ShopStatus getStatus() {
		return status;
	}

	public void setStatus(ShopStatus status) {
		this.status = status;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}
	
	public BigDecimal getCommisionRate() {
		return commisionRate;
	}
	
	public void setCommisionRate(BigDecimal commisionRate) {
		this.commisionRate = commisionRate;
	}

	public Boolean getDanbao() {
		return danbao;
	}

	public void setDanbao(Boolean danbao) {
		this.danbao = danbao;
	}
	
	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Boolean getPostageStatus() {
		return postageStatus;
	}

	public void setPostageStatus(Boolean postageStatus) {
		this.postageStatus = postageStatus;
	}

	public String getFreeZone() {
		return freeZone;
	}

	public void setFreeZone(String freeZone) {
		this.freeZone = freeZone;
	}

	public BigDecimal getPostage() {
		return postage;
	}

	public void setPostage(BigDecimal postage) {
		this.postage = postage;
	}

	public Boolean getFragmentStatus() {
		return fragmentStatus;
	}

	public void setFragmentStatus(Boolean fragmentStatus) {
		this.fragmentStatus = fragmentStatus;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Shop other = (Shop) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}