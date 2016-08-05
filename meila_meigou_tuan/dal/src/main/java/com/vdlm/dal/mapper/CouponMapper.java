package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.Coupon;
import com.vdlm.dal.status.CouponStatus;

public interface CouponMapper {

    Coupon selectByPrimaryKey(@Param("id") String id);

    void insert(Coupon coupon);

    List<Coupon> selectByUserAndStatus(@Param("userId") String userId, @Param("status") CouponStatus status);

    int updateStatus(@Param("id") String id, @Param("status") CouponStatus status);

    List<Coupon> listValids(@Param("userId") String userId, CouponStatus valid);
    
    Coupon selectByCouponCode(@Param("actCode") String actCode, @Param("couponCode") String couponCode);

    /**
     * 优惠券发给指定用户
     * @param id
     * @param userId
     * @return
     */
    int grant(@Param("id") String id, @Param("userId") String userId);
    
    
    List<Coupon> listCouponsByAdmin(@Param(value="params") Map<String, Object> params, @Param(value="page") Pageable page);
	
	Long countCouponsByAdmin(@Param(value="params") Map<String, Object> params);
	
	int create(@Param(value="codes") List<String> listCodes, @Param(value="params") Map<String, Object> params);
	
	List<Coupon> selectByAdmin(@Param(value="params")Map<String, Object> params, @Param("page") Pageable pageable);
	
	Boolean delete(@Param("ids")String[] ids);
	
	Coupon obtainCoupon(@Param("code")String code);

	// add by luojy 20150703
	List<Coupon> selectByActIdAndUserId(@Param("activityId")String activityId, @Param("userId")String userId);
	List<Coupon> selectByActIdAndDeviceId(@Param("activityId")String activityId, @Param("deviceId")String deviceId);
}
