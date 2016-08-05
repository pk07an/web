package com.vdlm.dal.voex;

import java.util.List;

import com.vdlm.dal.vo.OrderFeeVO;
import com.vdlm.dal.vo.OrderVO;

public class OrderVOEx extends OrderVO {

	private static final long serialVersionUID = 1L;
	
	List<OrderFeeVO> orderFees;
	
	public OrderVOEx(OrderVO order, List<OrderFeeVO> fees) {
		super(order);
		this.orderFees = fees;
	}
	
	public List<OrderFeeVO> getOrderFees() {
		return orderFees;
	}
	public void setOrderFees(List<OrderFeeVO> orderFees) {
		this.orderFees = orderFees;
	}
}
