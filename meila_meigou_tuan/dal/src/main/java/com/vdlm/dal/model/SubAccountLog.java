package com.vdlm.dal.model;

import java.math.BigDecimal;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.type.AccountOpType;

public class SubAccountLog extends BaseEntityImpl{
    
	private static final long serialVersionUID = 1L;

	private AccountOpType opType;

    private String requestId;

    private String subAccountId;

    private BigDecimal amount;

    private String comment;
	
    public SubAccountLog(){
    	
    }
    
	public SubAccountLog(String requestId, String subAccountId, AccountOpType opType, BigDecimal amount){
		this.requestId = requestId;
		this.subAccountId = subAccountId;
		this.opType = opType;
		this.amount = amount;
	}
    
    public AccountOpType getOpType() {
        return opType;
    }

    public void setOpType(AccountOpType opType) {
        this.opType = opType;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(String subAccountId) {
        this.subAccountId = subAccountId;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}