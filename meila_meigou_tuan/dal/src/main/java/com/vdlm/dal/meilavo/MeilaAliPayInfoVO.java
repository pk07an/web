package com.vdlm.dal.meilavo;

public class MeilaAliPayInfoVO {
	
	//支付宝的支付数据
	private String info="";
	//签名数据
	private String sig="";
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
}
