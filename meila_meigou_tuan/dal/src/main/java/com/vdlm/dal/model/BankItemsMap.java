package com.vdlm.dal.model;

import java.util.List;

public class BankItemsMap {

	private String keyName;
	private List<PayBankWay> valueList;

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public List<PayBankWay> getValueList() {
		return valueList;
	}

	public void setValueList(List<PayBankWay> valueList) {
		this.valueList = valueList;
	}

}
