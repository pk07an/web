package com.vdlm.service.tuan.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vdlm.service.tuan.status.TuanActStatus;

/**
 * 
 * @类名 : TuanActivityVo
 *
 *
 * @DESCRIPTION : 团购活动页面VO
 * @AUTHOR : Dan
 * @DATE : 2016-03-01
 */
public class TuanActivityVo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String actcName;

    private String productName;

    private String description;

    private String img;

    private Integer imgWidth;

    private Integer imgHeight;

    private String productCode;

    private Long skuId;

    private BigDecimal skuPrice;

    private BigDecimal tuanPrice;

    private Integer memberNum;

    private String deliveryType;

    private TuanActStatus tuanActStatus;

    private String img2;

    private BigDecimal discount;
    private String skuSpecStr;
    @JsonIgnore(value = true)
    private String tuanType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActcName() {
        return actcName;
    }

    public void setActcName(String actcName) {
        this.actcName = actcName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public BigDecimal getTuanPrice() {
        return tuanPrice;
    }

    public void setTuanPrice(BigDecimal tuanPrice) {
        this.tuanPrice = tuanPrice;
    }

    public Integer getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public TuanActStatus getTuanActStatus() {
        return tuanActStatus;
    }

    public void setTuanActStatus(TuanActStatus tuanActStatus) {
        this.tuanActStatus = tuanActStatus;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getSkuSpecStr() {
        return skuSpecStr;
    }

    public void setSkuSpecStr(String skuSpecStr) {
        this.skuSpecStr = skuSpecStr;
    }

    public String getTuanType() {
        return tuanType;
    }

    public void setTuanType(String tuanType) {
        this.tuanType = tuanType;
    }
}
