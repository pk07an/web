package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.type.PurchaseSourceEnum;

public class ProductInfo extends BaseEntityImpl  {
    
	private static final long serialVersionUID = 1L;
	
	private Long product_id;
	private Integer property;//商品属性  1.一般商品   2.秒杀商品'
	private BigDecimal ms_price; //秒杀价
	private Date start_time;//秒杀-开始时间		
	private Date end_time; //秒杀-结束时间	
	private Integer buy_limit_count; //限购数量
	private Date created_at; 
	private Date updated_at; 
	
	
	private String share_img;
	private Integer share_img_width;
	private Integer share_img_height;
	
	private String shortIntro; //短描述
	private String shortName; //简短名称
	//private Integer total_count; //库存总量
	//private Integer comment_count; //点评数
	//private String presale_text; //明日预告文案
    //private String presale_jump_label; //明日预告跳转类型
    // private String presale_jump_data; //明日预告跳转数据
	//private String badges; //荣耀徽标	
	//private Integer verify; //审核状态  0, 待审核  9,审核失败  5,被举报  2,可疑，仅发表者可见  1,审核通过',
	//private Boolean need_mcode; //是否需要M码
	//private String mcode_tip; //输入M码上面的提示文本 
	//private Integer vtalk_id; //绑定的话题id
	//private Integer appraisal_vtalk_id; //小编鉴定话题
	//private String appraisal_text; //小编鉴定显示文本
	//private Integer coin_limit; //买一件能够兑换的美币数量
	//private Integer distrib_status; //分销状态  1,自营  2,分销'
	//private Integer post_mode; //发货模式: 1.卖家自发  2.美啦代发',	

    private String purchaseSource;

    private String storageType;

    private Integer productPrepareDays;

    private Integer logisticsInternaDays;
    
    private long timeStatus;
    
    private String deliveryType;
    
    private String wareHouse;
	
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public Integer getProperty() {
		return property;
	}
	public void setProperty(Integer property) {
		this.property = property;
	}
	public BigDecimal getMs_price() {
		return ms_price;
	}
	public void setMs_price(BigDecimal ms_price) {
		this.ms_price = ms_price;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Integer getBuy_limit_count() {
		return buy_limit_count;
	}
	public void setBuy_limit_count(Integer buy_limit_count) {
		this.buy_limit_count = buy_limit_count;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public String getShare_img() {
		return share_img;
	}
	public void setShare_img(String share_img) {
		this.share_img = share_img;
	}
	public Integer getShare_img_width() {
		return share_img_width;
	}
	public void setShare_img_width(Integer share_img_width) {
		this.share_img_width = share_img_width;
	}
	public Integer getShare_img_height() {
		return share_img_height;
	}
	public void setShare_img_height(Integer share_img_height) {
		this.share_img_height = share_img_height;
	}
	public String getShortIntro() {
		return shortIntro;
	}
	public void setShortIntro(String shortIntro) {
		this.shortIntro = shortIntro;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getPurchaseSource() {
		return purchaseSource;
	}
	public void setPurchaseSource(String purchaseSource) {
		this.purchaseSource = purchaseSource;
	}
	public String getStorageType() {
		return storageType;
	}
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
    public Integer getProductPrepareDays() {
        return productPrepareDays;
    }
    public void setProductPrepareDays(Integer productPrepareDays) {
        this.productPrepareDays = productPrepareDays;
    }
    public Integer getLogisticsInternaDays() {
        return logisticsInternaDays;
    }
    public void setLogisticsInternaDays(Integer logisticsInternaDays) {
        this.logisticsInternaDays = logisticsInternaDays;
    }
	public long getTimeStatus() {
		return timeStatus;
	}
	public void setTimeStatus(long timeStatus) {
		this.timeStatus = timeStatus;
	}
    public String getDeliveryType() {
        return deliveryType;
    }
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
    public String getWareHouse() {
        return wareHouse;
    }
    public void setWareHouse(String wareHouse) {
        this.wareHouse = wareHouse;
    }
 
}