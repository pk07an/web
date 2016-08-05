package com.vdlm.dal.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.vdlm.dal.model.OrderAddress;
import com.vdlm.dal.model.OrderItem;
import com.vdlm.dal.status.OrderStatus;
import com.vdlm.dal.status.PayStatus;
import com.vdlm.dal.type.OrderType;
import com.vdlm.dal.type.PaymentMode;
import com.vdlm.dal.type.RefundType;
import com.vdlm.dal.type.UserPartnerType;

public class OrderItemWithOrderVO {

	private String id;
	private String orderId;
	private String productId;
	private String skuId;
	private String productName;
	private String skuStr;
	private String productImg;
	private BigDecimal price;
	private Integer amount;
	private Date createdAt;
	private Date updatedAt;

	private String buyerPhone;
	private String sellerPhone;
	private String shopName;
	private String imgUrl;
	private String addressDetails;
	private String outTradeNo;

	private String orderNo;
	private OrderType type;
	private PaymentMode payType;
	private String buyerId;
	private String shopId;
	private String sellerId;
	private BigDecimal totalFee;
	private BigDecimal goodsFee;
	private BigDecimal logisticsFee;
	private BigDecimal discountFee;
	private BigDecimal paidFee;
	private BigDecimal refundFee;
	private Date paidAt;
	private PayStatus paidStatus;
	private Date cancelledAt;
	private Date shippedAt;
    private Date refundAt;
	private String logisticsCompany;
	private String logisticsOrderNo;
	private Date succeedAt;
	private OrderStatus status;
	private String remark;
	private Boolean vip;
	private Boolean archive;
	private String unionId;
	private RefundType refundType;
	private String promotionId;
	private String couponId;
	private Date checkingAt;
	private Date oCreatedAt;
	private Date oUpdatedAt;
	private UserPartnerType partnerType;
	
	private String orderAddressId;
	private String zoneId;
	private String consignee;
	private String street;
	private String phone;
	private String weixinId;
	private Date oaCreatedAt;
	private Date oaUpdatedAt;
	
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

	public Date getoCreatedAt() {
		return oCreatedAt;
	}

	public void setoCreatedAt(Date oCreatedAt) {
		this.oCreatedAt = oCreatedAt;
	}

	public Date getoUpdatedAt() {
		return oUpdatedAt;
	}

	public void setoUpdatedAt(Date oUpdatedAt) {
		this.oUpdatedAt = oUpdatedAt;
	}

	public Date getOaCreatedAt() {
		return oaCreatedAt;
	}

	public void setOaCreatedAt(Date oaCreatedAt) {
		this.oaCreatedAt = oaCreatedAt;
	}

	public Date getOaUpdatedAt() {
		return oaUpdatedAt;
	}

	public void setOaUpdatedAt(Date oaUpdatedAt) {
		this.oaUpdatedAt = oaUpdatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSkuStr() {
		return skuStr;
	}

	public void setSkuStr(String skuStr) {
		this.skuStr = skuStr;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
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

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public String getSellerPhone() {
		return sellerPhone;
	}

	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public PaymentMode getPayType() {
		return payType;
	}

	public void setPayType(PaymentMode payType) {
		this.payType = payType;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public BigDecimal getGoodsFee() {
		return goodsFee;
	}

	public void setGoodsFee(BigDecimal goodsFee) {
		this.goodsFee = goodsFee;
	}

	public BigDecimal getLogisticsFee() {
		return logisticsFee;
	}

	public void setLogisticsFee(BigDecimal logisticsFee) {
		this.logisticsFee = logisticsFee;
	}

	public BigDecimal getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(BigDecimal discountFee) {
		this.discountFee = discountFee;
	}

	public BigDecimal getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(BigDecimal paidFee) {
		this.paidFee = paidFee;
	}

	public BigDecimal getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}

	public Date getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}

	public PayStatus getPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(PayStatus paidStatus) {
		this.paidStatus = paidStatus;
	}

	public Date getCancelledAt() {
		return cancelledAt;
	}

	public void setCancelledAt(Date cancelledAt) {
		this.cancelledAt = cancelledAt;
	}

	public Date getShippedAt() {
		return shippedAt;
	}

	public void setShippedAt(Date shippedAt) {
		this.shippedAt = shippedAt;
	}

	public Date getRefundAt() {
		return refundAt;
	}

	public void setRefundAt(Date refundAt) {
		this.refundAt = refundAt;
	}

	public String getLogisticsCompany() {
		return logisticsCompany;
	}

	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	public String getLogisticsOrderNo() {
		return logisticsOrderNo;
	}

	public void setLogisticsOrderNo(String logisticsOrderNo) {
		this.logisticsOrderNo = logisticsOrderNo;
	}

	public Date getSucceedAt() {
		return succeedAt;
	}

	public void setSucceedAt(Date succeedAt) {
		this.succeedAt = succeedAt;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public RefundType getRefundType() {
		return refundType;
	}

	public void setRefundType(RefundType refundType) {
		this.refundType = refundType;
	}

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public Date getCheckingAt() {
		return checkingAt;
	}

	public void setCheckingAt(Date checkingAt) {
		this.checkingAt = checkingAt;
	}

	public UserPartnerType getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(UserPartnerType partnerType) {
		this.partnerType = partnerType;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWeixinId() {
		return weixinId;
	}

	public void setWeixinId(String weixinId) {
		this.weixinId = weixinId;
	}

	public String getOrderAddressId() {
		return orderAddressId;
	}

	public void setOrderAddressId(String orderAddressId) {
		this.orderAddressId = orderAddressId;
	}

	public OrderItem getOrderItem() {
		OrderItem oi = new OrderItem();
		oi.setId(getId());
		oi.setOrderId(getOrderId());
		oi.setProductId(getProductId());
		oi.setSkuId(getSkuId());
		oi.setProductName(getProductName());
		oi.setSkuStr(getSkuStr());
		oi.setProductImg(getProductImg());
		oi.setPrice(getPrice());
		oi.setAmount(getAmount());
		oi.setCreatedAt(getCreatedAt());
		oi.setUpdatedAt(getUpdatedAt());
		return oi;
	}
	
	public OrderAddress getOrderAddress(){
		OrderAddress oa = new OrderAddress();
		oa.setId(getOrderAddressId());
		oa.setOrderId(getOrderId());
		oa.setZoneId(getZoneId());
		oa.setConsignee(getConsignee());
		oa.setStreet(getStreet());
		oa.setPhone(getPhone());
		oa.setWeixinId(getWeixinId());
		oa.setCreatedAt(getOaCreatedAt());
		oa.setUpdatedAt(getOaUpdatedAt());
		return oa;
	}
	
	public OrderVO getOrderVO(){
		OrderVO o = new OrderVO();
		o.setId(getOrderId());
		o.setBuyerPhone(getBuyerPhone());
		o.setSellerPhone(getSellerPhone());
		o.setShopName(getShopName());
		o.setImgUrl(getImgUrl());
		o.setAddressDetails(getAddressDetails());
		o.setOutTradeNo(getOutTradeNo());

		o.setOrderNo(getOrderNo());
		o.setType(getType());
		o.setPayType(getPayType());
		o.setBuyerId(getBuyerId());
		o.setShopId(getShopId());
		o.setSellerId(getSellerId());
		o.setTotalFee(getTotalFee());
		o.setGoodsFee(getGoodsFee());
		o.setLogisticsFee(getLogisticsFee());
		o.setDiscountFee(getDiscountFee());
		o.setPaidFee(getPaidFee());
		o.setRefundFee(getRefundFee());
		o.setPaidAt(getPaidAt());
		o.setPaidStatus(getPaidStatus());
		o.setCancelledAt(getCancelledAt());
		o.setShippedAt(getShippedAt());
		o.setRefundAt(getRefundAt());
		o.setLogisticsCompany(getLogisticsCompany());
		o.setLogisticsOrderNo(getLogisticsOrderNo());
		o.setSucceedAt(getSucceedAt());
		o.setStatus(getStatus());
		o.setRemark(getRemark());
		o.setVip(getVip());
		o.setArchive(getArchive());
		o.setUnionId(getUnionId());
		o.setRefundType(getRefundType());
		o.setPromotionId(getPromotionId());
		o.setCouponId(getCouponId());
		o.setCheckingAt(getCheckingAt());
		o.setCreatedAt(getoCreatedAt());
		o.setUpdatedAt(getoUpdatedAt());
		o.setPartnerType(getPartnerType());
		
		o.setOrderAddress(getOrderAddress());
		return o;
	}
}
