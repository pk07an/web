package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.CouponActivity;

public interface CouponActivityMapper {

    CouponActivity selectByPrimaryKey(String id);

    CouponActivity selectByActCode(@Param("actCode") String actCode);
    
    List<CouponActivity> selectByAdmin();
    
}
