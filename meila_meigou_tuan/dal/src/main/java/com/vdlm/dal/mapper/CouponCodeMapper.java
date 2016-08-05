package com.vdlm.dal.mapper;

import com.vdlm.dal.model.promotion.CouponCode;
import com.vdlm.dal.model.promotion.CouponCodeStatus;

/**
 *
 * @author: chenxi
 */

public interface CouponCodeMapper 
{
	public int insert(CouponCode code);
	
	public CouponCode selectByPrimaryKey(String id);
	
	public int updateCodeStatus(String id, CouponCodeStatus status);
}
