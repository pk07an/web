package com.vdlm.service.product.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vdlm.dal.model.Product;
import com.vdlm.dal.model.ProductInfo;
import com.vdlm.dal.model.Sku;
import com.vdlm.dal.model.Tag;
import com.vdlm.dal.util.json.JsonResourceUrlSerializer;
import com.vdlm.dal.vo.CategoryVO;
import com.vdlm.dal.vo.FragmentVO;
import com.vdlm.dal.vo.OrderItemCommentVO;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用于展现商品基本信息+扩展信息+sku+其他一些日后扩展与商品相关的表信息
 * 
 * @author reese 2015/7/16
 */
public class ProductInfoVO extends Product  {

	private static final long serialVersionUID = 1L;

    private String short_intro ;

    private String short_name ;

    private BigDecimal ms_price ;

    private Date start_time;//秒杀-开始时间

    private Date end_time;//秒杀-结束时间

    private Boolean onlyUpdSales = false ;//是否只修改伪销量;

    public Boolean getOnlyUpdSales() {
        return onlyUpdSales;
    }

    public void setOnlyUpdSales(Boolean onlyUpdSales) {
        this.onlyUpdSales = onlyUpdSales;
    }

    public String getShort_intro() {
        return short_intro;
    }

    public void setShort_intro(String short_intro) {
        this.short_intro = short_intro;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
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
}
