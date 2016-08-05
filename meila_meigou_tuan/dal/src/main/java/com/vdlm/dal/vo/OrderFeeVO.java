package com.vdlm.dal.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderFeeVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private BigDecimal amount;
	private String type;

	public OrderFeeVO() {

	}

	public OrderFeeVO(String code, String name, BigDecimal amount, String type) {
		this.code = code;
		this.name = name;
		this.amount = amount;
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
