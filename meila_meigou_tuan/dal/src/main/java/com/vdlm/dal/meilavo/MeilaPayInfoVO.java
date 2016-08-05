package com.vdlm.dal.meilavo;


public class MeilaPayInfoVO {

	//支付宝的支付数据
	private MeilaAliPayInfoVO ali_pay_info = new MeilaAliPayInfoVO();
	//订单支付的超时时间	时间点，unix 时间戳
	private Long pay_expire_time;
	
	public MeilaAliPayInfoVO getAli_pay_info() {
		return ali_pay_info;
	}
	public void setAli_pay_info(MeilaAliPayInfoVO ali_pay_info) {
		this.ali_pay_info = ali_pay_info;
	}
	public Long getPay_expire_time() {
		return pay_expire_time;
	}
	public void setPay_expire_time(Long pay_expire_time) {
		this.pay_expire_time = pay_expire_time;
	}
}
