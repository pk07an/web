package com.vdlm.dal.vo;

import java.util.List;

import com.vdlm.dal.model.OrderRefund;

public class OrderRefundVO extends OrderRefund {

	private static final long serialVersionUID = 1L;
	
    private String orderStatusName;
    
//    @JsonSerialize(using = JsonOrderRefundStatusSerializer.class)
    private String statusName;
    
    private String orderNo;
    
    private String orderFee;
    
    private String buyerPhone;
    
    List<String> refuseEvidences;	//拒绝凭证, 图片链接地址
    
	List<OrderRefundOperateDetail> opDetails; //操作记录

//	SUBMITTED, //已提交
//	CANCELLED, //取消
//	AGREE_RETURN, //买家同意退货
//	REJECT_RETURN, //拒绝买家退货
//	REJECT_REFUND, //拒绝买家退款
//	RETURN_ING, //买家填写退货运单号后，处于退货中
//	RETURN_DONE, //买家已退货，商品已签收
//	SUCCESS,   //退款成功，但还未打款
//	COMPLETE,  //退款申请成功，卖家收到货后的状态，（如果是不退货的退款，则直接从success跳到COMPLETE）
//	CLOSE;	   //退款申请被拒绝后关闭
	
	public String getStatusName() {
		String statusName = null;
		switch (super.getStatus()) {
		case SUBMITTED:
			statusName = "买家已提交申请";
			break;
		case CANCELLED:
			statusName = "申请已取消";
			break;
		case AGREE_RETURN:
			statusName = "卖家同意退款";
			break;			
		case REJECT_REFUND:
			statusName = "拒绝买家退款";
			break;
		case REJECT_RETURN:
			statusName = "拒绝买家退货";
			break;
		case RETURN_ING:
			statusName = "退货中";
			break;
		case SUCCESS:
			statusName = "退款成功";
			break;
		default:
			statusName = "未知";
			break;
		}
		this.statusName = statusName;
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getOrderStatusName() {
		
		String orderStatusName = null;
		switch (super.getOrderStatus()) {
		case PAID:
			orderStatusName = "已付款";
			break;
		case SHIPPED:
			orderStatusName = "已发货";
			break;
		case REFUNDING:
			orderStatusName = "退款申请中";
			break;
		case CLOSED:
			orderStatusName = "交易关闭";
			break;			
		default:
			statusName = "未知";
			break;
		}
		this.orderStatusName = orderStatusName;
		
		return this.orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(String orderFee) {
		this.orderFee = orderFee;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public List<String> getRefuseEvidences() {
		return refuseEvidences;
	}

	public void setRefuseEvidences(List<String> refuseEvidences) {
		this.refuseEvidences = refuseEvidences;
	}

	public List<OrderRefundOperateDetail> getOpDetails() {
		return opDetails;
	}

	public void setOpDetails(List<OrderRefundOperateDetail> opDetails) {
		this.opDetails = opDetails;
	}
}
