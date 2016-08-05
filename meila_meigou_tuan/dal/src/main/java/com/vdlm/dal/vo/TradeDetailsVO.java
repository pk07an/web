package com.vdlm.dal.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.vdlm.dal.model.SubAccountLog;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.dal.type.AccountType;
import com.vdlm.dal.type.PayRequestPayType;

public class TradeDetailsVO extends SubAccountLog {

	private static final long serialVersionUID = 1L;
	private String accountId;
	private AccountType accountType;
	private String isLock;
	private String bizId;
	private PayRequestPayType payType;
	private String outId;
	private String outStatus;
	private String userPhone;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getIsLock() {
		return isLock;
	}

	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public PayRequestPayType getPayType() {
		return payType;
	}

	public void setPayType(PayRequestPayType payType) {
		this.payType = payType;
	}

	public String getOutId() {
		return outId;
	}

	public void setOutId(String outId) {
		this.outId = outId;
	}

	public String getOutStatus() {
		return outStatus;
	}

	public void setOutStatus(String outStatus) {
		this.outStatus = outStatus;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getIdLong() {
		try {
			return IdTypeHandler.decode(this.getId()) + "";
		} catch (Exception e) {
			return this.getId();
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

	public String getRemarkOpType() {
		if (this.getOpType() == null) {
			return "";
		}
		String str = "";
		switch (this.getOpType()) {
		case RECHARGE:
			str = "充值";
			break;
		case INSTANT:
			str = "即时转账";
			break;
		case DANBAO_ING:
			str = "担保转账中";
			break;
		case DANBAO_DONE:
			str = "担保转账完成";
			break;
		case DANBAO_CANCEL:
			str = "担保转账取消";
			break;
		case REFUND:
			str = "即时转账退款";
			break;
		case WITHDRAW_ING:
			str = "提现";
			break;
		case WITHDRAW_DONE:
			str = "提现完成";
			break;
		case WITHDRAW_CANCEL:
			str = "提现取消";
			break;
		case FROZEN:
			str = "冻结";
			break;
		case UNFROZEN:
			str = "解冻";
			break;
		case AVAILABLE2CONSUME:
			str = "从自己的可用账户转到消费账户";
			break;
		case HONGBAO2CONSUME:
			str = "从自己的红包账户到消费账户";
			break;
		case CONSUME2AVAILABLE:
			str = "从自己的消费转到可用账户账户";
			break;
		case CONSUME2HONGBAO:
			str = "从自己的消费账户到红包账户";
			break;
		default:
			str = this.getOpType().toString();
			break;
		}
		return str;
	}

	public String getRemarkPayType() {
		if (this.getPayType() == null) {
			return "";
		}
		String str = "";
		switch (this.getPayType()) {
		case RECHARGE:
			str = "充值";
			break;
		case INSTANT:
			str = "即时转账";
			break;
		case DANBAO:
			str = "担保转账";
			break;
		case REFUND:
			str = "即时转账退款";
			break;
		case WITHDRAW:
			str = "提现";
			break;
		case FROZEN:
			str = "冻结";
			break;
		case UNFROZEN:
			str = "解冻";
			break;
		case AVAILABLE2CONSUME:
			str = "从可用账户转到消费账户";
			break;
		case HONGBAO2CONSUME:
			str = "从红包账户到可消费账户";
			break;
		case CONSUME2AVAILABLE:
			str = "从消费账户到可用账户";
			break;
		default:
			str = this.getPayType().toString();
			break;
		}
		return str;
	}

	public String getRemarkAccountType() {
		if (this.getAccountType() == null) {
			return "";
		}
		String str = "";
		switch (this.getAccountType()) {
		case AVAILABLE:
			str = "可用账户";
			break;
		case DANBAO:
			str = "担保账户";
			break;
		case FROZEN:
			str = "冻结账户";
			break;
		case COMMISSION:
			str = "佣金账户";
			break;
		case WITHDRAW:
			str = "提现账户";
			break;
		case CREDIT:
			str = "信用账户";
			break;
		case HONGBAO:
			str = "红包账户";
			break;
		case CONSUME:
			str = "消费账户";
			break;
		default:
			str = this.getAccountType().toString();
			break;
		}
		return str;
	}
}
