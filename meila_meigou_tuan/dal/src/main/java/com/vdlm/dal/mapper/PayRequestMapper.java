package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.PayRequest;

public interface PayRequestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PayRequest record);

    PayRequest selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PayRequest record);
    
    List<PayRequest> listByPayNo(String payNo);
    
    int updateByPay(PayRequest request);
    
    int updateBySuccess(PayRequest request);
    
    int updateByFailed(PayRequest request);

	int updateByOnCancel(PayRequest request);

	String findPayNoByBizId(@Param(value="bizId") String bizId);
	
	PayRequest queryPaidPayInfoByBizId(@Param(value="bizId") String bizId);
	
	PayRequest queryRefundByOutPayId(@Param(value="id") String id);

	/**
	 *得到该笔订单的转入担保的记录
	 *预付款会返回多个 
	 * @param bizId
	 * @return
	 */
	List<PayRequest> loadDanbaoRequest(PayRequest request);

	/**
	 * 得到该笔订单的转入消费账户的记录
	 * @param bizId
	 * @return
	 */
	List<PayRequest> loadConsumeReqeustByPayNo(@Param(value="payNo") String payNo);

	
	List<PayRequest> loadRefundRequest(PayRequest request);
}