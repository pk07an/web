package com.vdlm.dal.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.vdlm.dal.model.WithdrawApply;
import com.vdlm.dal.mybatis.IdTypeHandler;

public class WithdrawAdmin extends WithdrawApply {
	private static final long serialVersionUID = 1L;
	
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getIdLong() {
		try {
			return IdTypeHandler.decode(this.getId()) + "";
		} catch (Exception e) {
			return this.getId();
		}
	}
	
	public String getTypeStr(){
		int type = getType();
		if(type==1){
			return "银行卡";
		}else if(type==2){
			return "支付宝";
		}else{
			return "";
		}
	}
	
	public String getCreatedAtStr() {
		Date date = this.getCreatedAt();
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return simpleDateFormat.format(date);
		}
	}
	
	public String getUpdatedAtStr() {
		Date date = this.getUpdatedAt();
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return simpleDateFormat.format(date);
		}
	}
}
