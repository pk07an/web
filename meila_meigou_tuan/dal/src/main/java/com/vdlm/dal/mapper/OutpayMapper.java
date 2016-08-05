package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.OutPay;

public interface OutpayMapper {
    int deleteByPrimaryKey(String id);

    int insert(OutPay record);

    int insertSelective(OutPay record);

    OutPay selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OutPay record);

    List<OutPay>selectByUserId(String userId); 
    
    List<OutPay> selectByBillNO(String billNO);
    
    List<OutPay> selectByTradeNo(String tradeNo);
    
    List<OutPay> selectByAccountName(String name);
    
    int finishOutPay(OutPay record);

	OutPay findByOrderNo4Refund(@Param(value="payNo") String payNo, @Param(value="payType") String payType);
 
	OutPay findOutPayByTradeNo(@Param(value="tradeNo") String tradeNo, @Param(value="payType") String payType);

	/**
	 * 根据payNo查询outpay(批量)
	 * @param payOns
	 * @return
	 */
    List<OutPay> selectOutPaysBypayOns(@Param("payOns") List<String> payOns);
}