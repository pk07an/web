package com.vdlm.dal.type;

public enum OrderType {
	/**
	 * 即时到帐
	 */
	DIRECT,
	
	/**
	 * 担保交易
	 */
	DANBAO,
	
	/**
	 * 预订模式
	 */
	PREORDER,
	
	/**
	 * 货到付款
	 */
	COD // cash on delivery
}
