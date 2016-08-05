package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.OrderRefundStatus;
import com.vdlm.dal.status.OrderStatus;
import com.vdlm.dal.util.json.JsonResourceUrlSerializer;

public class OrderRefund extends BaseEntityImpl {
	private static final long serialVersionUID = 1L;

	private String applyNo;
	
    private String orderId;

    private OrderStatus orderStatus;
    
    private String productName;

    @JsonSerialize(using = JsonResourceUrlSerializer.class)
    private String img;

    private BigDecimal refundFee;

    private Integer buyerRequire;	//买家要求

    private Integer buyerReceived;	//买家是否已收到货

    private String refundReason;	//退款原因

    private String refundMemo;		//退款备注
    
    private String returnAddress; //退货地址
    
    private String returnName;    //退款人名称
    
    private String returnPhone;   //退货备注
    
    private String returnMemo;    //退货备注
    
	private String refuseReason;	//拒绝原因
	
	private String refuseDetail;	//	拒绝详情

	private String logisticsCompany; //物流公司
	
	private String logisticsNo; //物流编号
	
	private String logisticsMemo; //说明
	
    private OrderRefundStatus status; //退款状态
    
    private String adminStatus;	//运营处理结果
    
    private String adminRemark;
    
    private Date adminOpTime;
    
    private Date rejectTime;
    
    private Date rejectReturnTime;
    
    private Date confirmTime;
    
    private Date shipTime;
    
    private Date signTime;
    
    public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public String getAdminRemark() {
		return adminRemark;
	}

	public void setAdminRemark(String adminRemark) {
		this.adminRemark = adminRemark;
	}

	public Date getAdminOpTime() {
		return adminOpTime;
	}

	public void setAdminOpTime(Date adminOpTime) {
		this.adminOpTime = adminOpTime;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    public Integer getBuyerRequire() {
        return buyerRequire;
    }

    public void setBuyerRequire(Integer buyerRequire) {
        this.buyerRequire = buyerRequire;
    }

    public Integer getBuyerReceived() {
        return buyerReceived;
    }

    public void setBuyerReceived(Integer buyerReceived) {
        this.buyerReceived = buyerReceived;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason == null ? null : refundReason.trim();
    }

    public String getRefundMemo() {
        return refundMemo;
    }

    public void setRefundMemo(String refundMemo) {
        this.refundMemo = refundMemo == null ? null : refundMemo.trim();
    }

    
    
    public String getReturnAddress() {
		return returnAddress;
	}

	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}

	public String getReturnName() {
		return returnName;
	}

	public void setReturnName(String returnName) {
		this.returnName = returnName;
	}

	public String getReturnPhone() {
		return returnPhone;
	}

	public void setReturnPhone(String returnPhone) {
		this.returnPhone = returnPhone;
	}

	public String getReturnMemo() {
		return returnMemo;
	}

	public void setReturnMemo(String returnMemo) {
		this.returnMemo = returnMemo;
	}

	public String getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	public String getRefuseDetail() {
		return refuseDetail;
	}

	public void setRefuseDetail(String refuseDetail) {
		this.refuseDetail = refuseDetail;
	}

	public String getLogisticsCompany() {
		return logisticsCompany;
	}

	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}

	public String getLogisticsMemo() {
		return logisticsMemo;
	}

	public void setLogisticsMemo(String logisticsMemo) {
		this.logisticsMemo = logisticsMemo;
	}

	public OrderRefundStatus getStatus() {
        return status;
    }

    public void setStatus(OrderRefundStatus status) {
        this.status = status;
    }

	public Date getRejectReturnTime() {
		return rejectReturnTime;
	}

	public void setRejectReturnTime(Date rejectReturnTime) {
		this.rejectReturnTime = rejectReturnTime;
	}

	public Date getRejectTime() {
		return rejectTime;
	}

	public void setRejectTime(Date rejectTime) {
		this.rejectTime = rejectTime;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public Date getShipTime() {
		return shipTime;
	}

	public void setShipTime(Date shipTime) {
		this.shipTime = shipTime;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	@Override
	public String toString() {
		return "OrderRefund [applyNo=" + applyNo + ", orderId=" + orderId
				+ ", orderStatus=" + orderStatus + ", productName="
				+ productName + ", img=" + img + ", refundFee=" + refundFee
				+ ", buyerRequire=" + buyerRequire + ", buyerReceived="
				+ buyerReceived + ", refundReason=" + refundReason
				+ ", refundMemo=" + refundMemo + ", returnAddress="
				+ returnAddress + ", returnName=" + returnName
				+ ", returnMemo=" + returnMemo + ", status=" + status + "]";
	}
    
}