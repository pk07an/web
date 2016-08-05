package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.PayBank;
import com.vdlm.dal.model.PayBankWay;
import com.vdlm.dal.type.PaymentMode;

public interface PayBankMapper {

	List<PayBankWay> queryAllPayBanksCreditCard();
	
	List<PayBankWay> queryHotPayBanksCreditCard();
	
	List<PayBankWay> queryAllPayBanksDebitCard();
	
	List<PayBankWay> queryHotPayBanksDebitCard();
	
	int updateBankStatusFalse(@Param("bankCodeList") List<String> bankCodeList, @Param("mode") PaymentMode mode);
	
	List<String> supportBank(@Param("mode") PaymentMode mode);
	
	List<PayBank> obtainCommonlyBankList();
}
