package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.ProductStatus;

/**
 * 商品model类
 * 其中price为sku中最低的价格
 * amount为sku中总的库存
 * price和amout为冗余字段，为方便前端显示
 * descImg：存放商品描述的图片， 包含img的值，以逗号相隔
 * @author huxaya
 *
 */

public class Product extends BaseEntityImpl implements Archivable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String img;
	private String userId;
	private String shopId;
	private ProductStatus status;
	private String description;
	private Boolean archive;
	private BigDecimal marketPrice; // 市场价
	private BigDecimal price; //最低价格
	private BigDecimal postage; //邮费
	private Integer sales;//产品销
	private Boolean freePostage = false;
	private String thirdItemId; //第三方同步id
	// add by luojy 20150708
	private Boolean enableDesc;
	
	//是否是特价商品  seker 20150114增加
	private Boolean productSP = false;
	
	private String code;
	
	
	
	public Product(){
		
	}
	
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Boolean getUpdateLock() {
		return updateLock;
	}

	public void setUpdateLock(Boolean updateLock) {
		this.updateLock = updateLock;
	}

	public Integer getDelayed() {
		return delayed;
	}

	public void setDelayed(Integer delayed) {
		this.delayed = delayed;
	}

	public String getSynchronousFlag() {
		return synchronousFlag;
	}

	public void setSynchronousFlag(String synchronousFlag) {
		this.synchronousFlag = synchronousFlag;
	}

	private Integer fakeSales;// 零时使用产品销量
	private Integer amount;//库存
	private Integer imgWidth;
	private Integer imgHeight;
	private Boolean recommend;
	private Date recommendAt;
	private BigDecimal commissionRate; // 分佣比例
	private Float discount; //折扣，如1.1， 2.2
	private Date forsaleAt; //待发布时间
	private Date onsaleAt;//上架时间
	private Date instockAt;//下架时间
	private Boolean updateLock; // 1不能修改商品信息，0能修改商品信息
	
	private Integer delayAt = 0;//延迟发货时间（天）  （delayed==0的时候才有效）
	private Integer delayed;
	
	private String synchronousFlag;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

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
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}
	
	public Boolean getRecommend() {
		return recommend;
	}

	public void setRecommend(Boolean recommend) {
		this.recommend = recommend;
	}

	public Date getRecommendAt() {
		return recommendAt;
	}

	public void setRecommendAt(Date recommendAt) {
		this.recommendAt = recommendAt;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Date getForsaleAt() {
		return forsaleAt;
	}

	public void setForsaleAt(Date forsaleAt) {
		this.forsaleAt = forsaleAt;
	}

	public Date getOnsaleAt() {
		return onsaleAt;
	}

	public void setOnsaleAt(Date onsaleAt) {
		this.onsaleAt = onsaleAt;
	}

	public Date getInstockAt() {
		return instockAt;
	}

	public void setInstockAt(Date instockAt) {
		this.instockAt = instockAt;
	}
	
	public BigDecimal getCommissionRate() {
		return commissionRate;
	}
	
	public void setCommissionRate(BigDecimal commissionRate) {
		this.commissionRate = commissionRate;
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

    public Integer getFakeSales() {
        return fakeSales;
    }

    public void setFakeSales(Integer fakeSales) {
        this.fakeSales = fakeSales;
    }

	public Integer getDelayAt() {
		return delayAt;
	}

	public void setDelayAt(Integer delayAt) {
		this.delayAt = delayAt;
	}

	public Boolean getFreePostage() {
		return freePostage;
	}

	public void setFreePostage(Boolean freePostage) {
		this.freePostage = freePostage;
	}

	public Boolean getProductSP() {
		return productSP;
	}

	public void setProductSP(Boolean productSP) {
		this.productSP = productSP;
	}
	
	public String getThirdItemId() {
		return thirdItemId;
	}
	
	public void setThirdItemId(String thirdItemId) {
		this.thirdItemId = thirdItemId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getPostage() {
		return postage;
	}

	public void setPostage(BigDecimal postage) {
		this.postage = postage;
	}


	// add by luojy	20150708
	public Boolean getEnableDesc() {
		return enableDesc;
	}

	// add by luojy	20150708
	public void setEnableDesc(Boolean enableDesc) {
		this.enableDesc = enableDesc;
	}
}