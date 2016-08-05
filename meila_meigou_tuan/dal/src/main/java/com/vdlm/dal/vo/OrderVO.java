package com.vdlm.dal.vo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vdlm.dal.model.Order;
import com.vdlm.dal.model.OrderAddress;
import com.vdlm.dal.model.OrderExt;
import com.vdlm.dal.model.OrderItem;
import com.vdlm.dal.model.User;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.dal.type.RefundType;
import com.vdlm.dal.util.json.JsonResourceUrlSerializer;

public class OrderVO extends Order {

	private static final long serialVersionUID = 1L;
	
	private String buyerPhone;
	
	private String sellerPhone;
	
	private String shopName;
	
	@JsonSerialize(using = JsonResourceUrlSerializer.class)
	private String imgUrl;

	private OrderAddress orderAddress;
	
	private String addressDetails;
	
	private String outTradeNo;

    private String outId ;

	private boolean showRefundBtn;
	
	private List<OrderItem> orderItems;
	
	private Long seq;//客户在店铺的第X笔订单
	
	private BigDecimal hongbaoAmount;
	private BigDecimal commissionFee;
	//快递查询地址
	private String expressUrl;
	
	private String notes;
	
	private int defDelayDate;
	
	private BigDecimal couponAmount = BigDecimal.ZERO;
	
	private String paymentChannel; //付款渠道 
	
	//订单红包信息,需要手动查询
	private List<CouponInfoVO> orderCoupons;

	/**
	 * 可退款的金额（不包含运费）
	 */
	private BigDecimal refundableFee;
	
	private Date doRefundAt;
	
	private Boolean hasComments;
	

    private User buyer;     // 买家用户
    
    private User seller;    // 卖家用户

    private String buyerNickName ;

    private String sellerNickName ;

    private OrderExt orderExt;
	
    private boolean isPayOverdue = false;   // true: 支付已超时(订单未在规定时间内)
    
	public String getExpressUrl() {
        return expressUrl;
    }

    public void setExpressUrl(String expressUrl) {
        this.expressUrl = expressUrl;
    }

    public void setShowRefundBtn(boolean showRefundBtn) {
		this.showRefundBtn = showRefundBtn;
	}

	public OrderVO(){
		
	}
	
	public OrderExt getOrderExt() {
        return orderExt;
    }

    public void setOrderExt(OrderExt orderExt) {
        this.orderExt = orderExt;
    }

    public OrderVO(Order order) {
		BeanUtils.copyProperties(order, this);
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public OrderAddress getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(OrderAddress orderAddress) {
		this.orderAddress = orderAddress;
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

	public boolean isShowRefundBtn() {
		return showRefundBtn;
	}

	public void refunds(boolean showRefundBtn) {
		this.showRefundBtn = showRefundBtn;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
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

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}
	
	public Date getAutoSignAt() {
	    if (this.getShippedAt() != null) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(this.getShippedAt());
	        c.add(Calendar.DATE, 7);
	        return c.getTime();
	    } else {
	        return null;
	    }
	    
	}
	
	public String getIdLong() {
		try {
			return IdTypeHandler.decode(this.getId()) + "";
		} catch (Exception e) {
			return this.getId();
		}
	}
	
	public String getPaidAtStr() {
		if(this.getPaidAt()==null){
			return "";
		}
		return DateFormatUtils.format(this.getPaidAt(), "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getCreatedAtStr() {
		if(this.getCreatedAt()==null){
			return "";
		}
		return DateFormatUtils.format(this.getCreatedAt(), "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getUpdatedAtStr() {
		if(this.getUpdatedAt()==null){
			return "";
		}
		return DateFormatUtils.format(this.getUpdatedAt(), "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getCheckingAtStr() {
		if(this.getCheckingAt()==null){
			return "";
		}
		return DateFormatUtils.format(this.getCheckingAt(), "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getRefundAtStr() {
		if(this.getRefundAt()==null){
			return "";
		}
		return DateFormatUtils.format(this.getRefundAt(), "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getDoRefundAtStr() {
		if(this.getRefundType()==RefundType.SUCCESS){
			return this.getUpdatedAtStr();
		}
		return "";
	}
	
	public Date getDoRefundAt() {
		if(this.getRefundType()==RefundType.SUCCESS){
			return this.getUpdatedAt();
		}
		return null;
	}

	public void setDoRefundAt(Date doRefundAt) {
		if(this.getRefundType()==RefundType.SUCCESS){
			this.doRefundAt = this.getUpdatedAt();
		}else{
			this.doRefundAt = null;
		}
	}

	public String getTypeStr() {
		if (this.getType() == null) {
			return "";
		}
		String str = "";
		switch (this.getType()) {
		case DIRECT:
			str = "即时到账";
			break;
		case DANBAO:
			str = "担保交易";
			break;
		case PREORDER:
			str = "预定模式";
			break;
		case COD:
			str = "货到付款";
			break;
		default:
			str = this.getType().toString();
			break;
		}
		return str;
	}
	
	public String getPayTypeStr() {
		if (this.getPayType() == null) {
			return "";
		}
		String str = "";
		switch (this.getPayType()) {
		case WEIXIN:
			str = "微信";
			break;
		case UNION:
			str = "银联";
			break;
		case ALIPAY:
			str = "支付宝";
			break;
		case UMPAY:
			str = "U付";
			break;
		default:
			str = this.getPayType().toString();
			break;
		}
		return str;
	}
	
	public String getStatusStr() {
		if (this.getStatus() == null) {
			return "";
		}
		String str = "";
		switch (this.getStatus()) {
		case SUBMITTED:
			str = "已提交";
			break;
		case CANCELLED:
			str = "取消";
			break;
		case PAID:
			str = "已付款";
			break;
		case SHIPPED:
			str = "已发货";
			break;
		case SUCCESS:
			str = "交易成功";
			break;
		case REFUNDING:
			str = "退款申请中";
			break;
		case CLOSED:
			str = "交易关闭";
			break;
		default:
			str = this.getStatus().toString();
			break;
		}
		return str;
	}

	public BigDecimal getHongbaoAmount() {
		return hongbaoAmount;
	}

	public void setHongbaoAmount(BigDecimal hongbaoAmount) {
		this.hongbaoAmount = hongbaoAmount;
	}

	public BigDecimal getCommissionFee() {
		return commissionFee;
	}

	public void setCommissionFee(BigDecimal commissionFee) {
		this.commissionFee = commissionFee;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public BigDecimal getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}

	public int getDefDelayDate() {
		return defDelayDate;
	}

	public void setDefDelayDate(int defDelayDate) {
		this.defDelayDate = defDelayDate;
	}
	
	public String getPaymentChannel(){
		return paymentChannel;
	}
	
	public void setPaymentChannel(String paymentChannel){
		this.paymentChannel = paymentChannel;
	}

	public List<CouponInfoVO> getOrderCoupons() {
		return orderCoupons;
	}

	public void setOrderCoupons(List<CouponInfoVO> orderCoupons) {
		this.orderCoupons = orderCoupons;
	}

	public BigDecimal getRefundableFee() {
		return refundableFee;
	}

	public void setRefundableFee(BigDecimal refundableFee) {
		this.refundableFee = refundableFee;
	}

	public Boolean getHasComments() {
		return hasComments;
	}

	public void setHasComments(Boolean hasComments) {
		this.hasComments = hasComments;
	}

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public boolean getIsPayOverdue() {
        return isPayOverdue;
    }

    public void setIsPayOverdue(boolean isPayOverdue) {
        this.isPayOverdue = isPayOverdue;
    }

    public String getBuyerNickName() {
        return buyerNickName;
    }

    public void setBuyerNickName(String buyerNickName) {
        this.buyerNickName = buyerNickName;
    }

    public String getSellerNickName() {
        return sellerNickName;
    }

    public void setSellerNickName(String sellerNickName) {
        this.sellerNickName = sellerNickName;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }
}
