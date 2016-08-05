package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.promotion.Voucher;
import com.vdlm.dal.vo.VoucherVo;

public interface VoucherMapper {

	
	/**
	 * 
	 * @param voucher
	 */
	 void insert(Voucher voucher); 
	 
	 /**
	  * 券与用户进行绑定
	  * @param voucher
	  */
	 int bound(@Param("code") String voucherCode);
	 
	 /**
	  * 券已经被使用
	  * @param voucher
	  */
	 void used(@Param("id") String voucherID);
	 
	 int del(@Param("id") String voucherID);
	 
	List<Voucher> getListByProID(@Param("proID")String proID);
	
	List<Voucher> getVoucherByIDList(@Param("ids")List<String> proIdList);
	
	Voucher getVoucherByID(@Param("id") String id);
	
	Voucher getVoucherByCode(@Param("code") String code);
	
	List<Voucher> getList(@Param("page") Pageable pageable);
	
	void changeIdToCode(String id);
	
	 List<VoucherVo>   voucherList(@Param("params") Map<String,Object> map,@Param("page") Pageable page);
	    
	 Long countVoucherList(@Param(value="params") Map<String, Object> params);
}
