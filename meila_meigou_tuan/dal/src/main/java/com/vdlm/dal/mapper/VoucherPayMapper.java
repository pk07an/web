package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.promotion.VoucherPay;

public interface VoucherPayMapper {

	 
	    int  lock(String id,@Param("payNo") String payNo);
	
	    int  unlock(String id);
	   
	    List<VoucherPay>  getVoucherPayList(@Param("userID") String userID,@Param("proID") String proId);
	    
	    int  insert(@Param("voucherPay") VoucherPay voucherPay);
	    
	    int close(@Param("id")  String id);
		
	    int  closeByProId(String proId);
	    
	    VoucherPay  findVoucherByVID(String extId);
	    
	    int update(@Param("voucherPay") VoucherPay voucherPay);
	    
	    
	    int use(@Param("id") String id ,@Param("payNo") String payNo);
	    
}
