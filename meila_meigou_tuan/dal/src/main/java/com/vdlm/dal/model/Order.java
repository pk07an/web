package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.model.promotion.VoucherPay;
import com.vdlm.dal.status.OrderStatus;
import com.vdlm.dal.status.PayStatus;
import com.vdlm.dal.type.OrderSingleType;
import com.vdlm.dal.type.OrderType;
import com.vdlm.dal.type.PaymentMode;
import com.vdlm.dal.type.RefundType;
import com.vdlm.dal.type.UserPartnerType;

public class Order extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;

	private String buyerId;// 注册用户ID
	private String shopId; // 卖家店铺ID
	private String sellerId; // 卖家ID
	private Boolean vip; // 是否vip买家
	
	private String orderNo; // 交易订单号
	private OrderType type; // 交易类型
	private OrderStatus status;// 订单状态
	
	private PaymentMode payType; // 支付类型
	
	private BigDecimal totalFee; // 订单总金额 totalFee = goodsFee + logisticsFee - discountFee totalFee = paidFee
	private BigDecimal goodsFee; // 订单商品总金额
	private BigDecimal logisticsFee; // 订单物流金额
	private BigDecimal discountFee; // 订单折扣金额
	private BigDecimal paidFee; // 订单付款总金额
	private PayStatus paidStatus;// 付款状态
	private Date paidAt; // 付款时间
	private String payNo;//支付单号
	private Date succeedAt;// 订单成功时间
	
	private BigDecimal refundFee; // 退款金额，对于新接口为 商品额退款+运费退款
	private BigDecimal refundGoodsFee; // 退款（商品额）
	private BigDecimal refundLogisticsFee; // 退款（运费）
	private BigDecimal refundPlatformFee; // 退平台优惠
	private Date refundAt; // 退款时间
	
	
	private Date cancelledAt; // 订单取消时间
	private Date shippedAt; // 订单发货时间
    
	private String logisticsCompany; // 物流公司
	private String logisticsOrderNo; // 物流公司订单号
	private String logisticsOfficial; // 物流公司官网
	
	private Date latestSignAt; // 预计最晚收货时间 (延迟收货)
	private Date remindShipAt; // 上次提醒卖家发货时间
	
	private String remark; // 备注
	private String remarkAdmin;// 备注-管理端
	
	private Boolean archive; // 订单是否被删除
	private String unionId; // 第三方ID
	private RefundType refundType;
	private String promotionId; // 订单使用的优惠
	private String couponId;
	private Date checkingAt; // 订单对账时间
	private UserPartnerType partnerType;// 订单类型
	
	private OrderSingleType orderSingleType;//下单方式 
	
	private  List<String> orginVouchers;
	
	private  List<String> validVouchers;

	
	
	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
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

	public BigDecimal getLogisticsFee() {
		return logisticsFee;
	}

	public void setLogisticsFee(BigDecimal logisticsFee) {
		this.logisticsFee = logisticsFee;
	}

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public BigDecimal getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(BigDecimal paidFee) {
		this.paidFee = paidFee;
	}

	public BigDecimal getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(BigDecimal discountFee) {
		this.discountFee = discountFee;
	}

	public BigDecimal getGoodsFee() {
		return goodsFee;
	}

	public void setGoodsFee(BigDecimal goodsFee) {
		this.goodsFee = goodsFee;
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

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
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

	public String getLogisticsOrderNo() {
		return logisticsOrderNo;
	}

	public void setLogisticsOrderNo(String logisticsOrderNo) {
		this.logisticsOrderNo = logisticsOrderNo;
	}
	
	public String getLogisticsOfficial(){
		return logisticsOfficial;
	}
	
	public void setLogisticsOfficial(String logisticsOfficial){
		this.logisticsOfficial = logisticsOfficial;
	}

	public Date getSucceedAt() {
		return succeedAt;
	}

	public void setSucceedAt(Date succeedAt) {
		this.succeedAt = succeedAt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemarkAdmin() {
		return remarkAdmin;
	}

	public void setRemarkAdmin(String remarkAdmin) {
		this.remarkAdmin = remarkAdmin;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public String getLogisticsCompany() {
		return logisticsCompany;
	}

	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	public RefundType getRefundType() {
		return refundType;
	}

	public void setRefundType(RefundType refundType) {
		this.refundType = refundType;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
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

	public UserPartnerType getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(UserPartnerType partnerType) {
		this.partnerType = partnerType;
	}

    public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public BigDecimal getRefundFee() {
        return ObjectUtils.defaultIfNull(refundFee, BigDecimal.ZERO);
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    
    public BigDecimal getRefundGoodsFee() {
    	return ObjectUtils.defaultIfNull(refundGoodsFee, BigDecimal.ZERO);
	}

	public void setRefundGoodsFee(BigDecimal refundGoodsFee) {
		this.refundGoodsFee = refundGoodsFee;
	}

	public BigDecimal getRefundLogisticsFee() {
		return ObjectUtils.defaultIfNull(refundLogisticsFee, BigDecimal.ZERO);
	}

	public void setRefundLogisticsFee(BigDecimal refundLogisticsFee) {
		this.refundLogisticsFee = refundLogisticsFee;
	}

	public BigDecimal getRefundPlatformFee() {
		return refundPlatformFee;
	}

	public void setRefundPlatformFee(BigDecimal refundPlatformFee) {
		this.refundPlatformFee = refundPlatformFee;
	}

	public Date getRefundAt() {
        return refundAt;
    }

    public void setRefundAt(Date refundAt) {
        this.refundAt = refundAt;
    }

	public Date getCheckingAt() {
		return checkingAt;
	}

	public void setCheckingAt(Date checkingAt) {
		this.checkingAt = checkingAt;
	}

	public Date getLatestSignAt() {
		return latestSignAt;
	}

	public void setLatestSignAt(Date latestSignAt) {
		this.latestSignAt = latestSignAt;
	}

	public Date getRemindShipAt() {
		return remindShipAt;
	}

	public void setRemindShipAt(Date remindShipAt) {
		this.remindShipAt = remindShipAt;
	}

	public OrderSingleType getOrderSingleType() {
		return orderSingleType;
	}

	public void setOrderSingleType(OrderSingleType orderSingleType) {
		this.orderSingleType = orderSingleType;
	}

	public List<String> getOrginVouchers() {
		return orginVouchers;
	}

	public void setOrginVouchers(List<String> orginVouchers) {
		this.orginVouchers = orginVouchers;
	}

	public List<String> getValidVouchers() {
		return validVouchers;
	}

	public void setValidVouchers(List<String> validVouchers) {
		this.validVouchers = validVouchers;
	}

}