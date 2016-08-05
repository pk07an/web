package com.vdlm.dal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.vdlm.dal.Archivable;
import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.WithdrawApplyStatus;

public class WithdrawApply extends BaseEntityImpl implements Archivable {

	private static final long serialVersionUID = 1L;

	private String applyNo;
	
	private String userId;

    private String bankId;
    
    private String accountNumber;
    
    private String accountName;
    
    private String openingBank;
    
    private Boolean archive;

    private BigDecimal applyMoney;

    private BigDecimal confirmMoney;

    private WithdrawApplyStatus status;

    private String opRemark;
    
    private String payOpUser;
    
    private Date payAt;
    
    private int type;
    
    public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getOpeningBank() {
		return openingBank;
	}

	public void setOpeningBank(String openingBank) {
		this.openingBank = openingBank;
	}

	public BigDecimal getApplyMoney() {
        return applyMoney;
    }

    public void setApplyMoney(BigDecimal applyMoney) {
        this.applyMoney = applyMoney;
    }

    public BigDecimal getConfirmMoney() {
        return confirmMoney;
    }

    public void setConfirmMoney(BigDecimal confirmMoney) {
        this.confirmMoney = confirmMoney;
    }

    public WithdrawApplyStatus getStatus() {
        return status;
    }

    public void setStatus(WithdrawApplyStatus status) {
        this.status = status;
    }

    public String getOpRemark() {
		return opRemark;
	}

	public void setOpRemark(String opRemark) {
		this.opRemark = opRemark;
	}

	public String getPayOpUser() {
		return payOpUser;
	}

	public void setPayOpUser(String payOpUser) {
		this.payOpUser = payOpUser;
	}

	public Date getPayAt() {
        return payAt;
    }

    public void setPayAt(Date payAt) {
        this.payAt = payAt;
    }
    
    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "WithdrawApply [applyNo=" + applyNo + ", userId=" + userId + ", bankId=" + bankId + ", accountNumber=" + accountNumber 
				+ ", accountName=" + accountName + ", openingBank=" + openingBank + ", applyMoney=" + applyMoney
				+ ", confirmMoney=" + confirmMoney + ", status=" + status + ", opRemark=" + opRemark 
				+ ", type=" + type + "]";
	}
}