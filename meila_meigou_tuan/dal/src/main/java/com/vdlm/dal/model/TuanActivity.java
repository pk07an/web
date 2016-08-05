package com.vdlm.dal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @类名 : TuanActivity
 *
 *
 * @DESCRIPTION : 团购活动页相关类
 * @AUTHOR : Dan
 * @DATE : 2016-03-01
 */
public class TuanActivity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String actcName;

    private String img;

    private Integer imgWidth;

    private Integer imgHeight;

    private Date beginTime;

    private Date endTime;

    private Short status;

    private Long productId;

    private String productCode;

    private Long skuId;

    private String skuCode;

    private String productName;

    private BigDecimal skuPrice;

    private BigDecimal tuanPrice;

    private Integer skuStock;

    private Integer skuTuanStock;

    private Integer totalNum;

    private Integer nowNum;

    private Integer lockFlag;

    private Integer memberNum;

    private Integer activeAlive;

    private Date createdAt;

    private Date updatedAt;

    private Byte archive;

    private String createdUser;

    private String description;

    private String img2;

    private long rank;

    private BigDecimal discount;

    private String tuanType;

    private boolean hideJoin;

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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public void setTuanPrice(BigDecimal tuanPrice) {
        this.tuanPrice = tuanPrice;
    }

    public Integer getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(Integer skuStock) {
        this.skuStock = skuStock;
    }

    public Integer getSkuTuanStock() {
        return skuTuanStock;
    }

    public void setSkuTuanStock(Integer skuTuanStock) {
        this.skuTuanStock = skuTuanStock;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getNowNum() {
        return nowNum;
    }

    public void setNowNum(Integer nowNum) {
        this.nowNum = nowNum;
    }

    public Integer getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(Integer lockFlag) {
        this.lockFlag = lockFlag;
    }

    public Integer getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }

    public Integer getActiveAlive() {
        return activeAlive;
    }

    public void setActiveAlive(Integer activeAlive) {
        this.activeAlive = activeAlive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Byte getArchive() {
        return archive;
    }

    public void setArchive(Byte archive) {
        this.archive = archive;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg2() {
        if (StringUtils.isBlank(img2)) {
            return img;
        }
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

    public String getTuanType() {
        return tuanType;
    }

    public void setTuanType(String tuanType) {
        this.tuanType = tuanType;
    }

    public boolean getHideJoin() {
        return hideJoin;
    }

    public void setHideJoin(boolean hideJoin) {
        this.hideJoin = hideJoin;
    }
}
