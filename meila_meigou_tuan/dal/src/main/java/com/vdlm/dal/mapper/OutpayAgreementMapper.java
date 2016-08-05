package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.OutpayAgreement;
import com.vdlm.dal.model.UserPayBankVO;
import com.vdlm.dal.type.PaymentMode;

public interface OutpayAgreementMapper {

	/**
	 * 插入协议表
	 * @param record
	 * @return
	 */
    int insert(OutpayAgreement record);

    /**
     * 解绑
     * @param id
     * @return
     */
    int unbind(String id);

    /**
     * 根据主键获得对象
     * @param id
     * @return
     */
    OutpayAgreement selectByPrimaryKey(String id);
    
    /**
     * 获得用户的签约记录
     * @param userId
     * @return
     */
    List<OutpayAgreement> listByUserId(@Param("userId")String userId);
    
    /**
     * 获取用户的签约银行记录
     * @param userId
     * @return
     */
    List<UserPayBankVO> listBankByUserId(@Param("userId")String userId);

    /**
     * 
     * @param userId
     * @param payAgreeId
     * @param payMode
     * @return
     */
	OutpayAgreement findByPayAgreeId(@Param("userId")String userId, @Param("payAgreeId")String payAgreeId, @Param("payMode")PaymentMode payMode);
}