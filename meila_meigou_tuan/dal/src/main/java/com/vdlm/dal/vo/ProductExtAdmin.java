package com.vdlm.dal.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.vdlm.dal.model.Product;

/**
 * bos系统用到的vo
 * @author huxaya
 *
 */
public class ProductExtAdmin extends ProductAdmin {
	
	private static final long serialVersionUID = 1L;
	
	private Long product_id;
	private Integer property;//商品属性  1.一般商品   2.秒杀商品'
	private BigDecimal ms_price; //秒杀价
	private Date start_time;//秒杀-开始时间		
	private Date end_time; //秒杀-结束时间	
	private Integer buy_limit_count; //限购数量
	private Date created_at; 
	private Date updated_at;
	
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
}
