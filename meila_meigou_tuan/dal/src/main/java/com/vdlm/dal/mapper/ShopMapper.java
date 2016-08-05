package com.vdlm.dal.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.Shop;
import com.vdlm.dal.vo.ShopAdmin;

public interface ShopMapper {
	
    int deleteByPrimaryKey(@Param(value="id") String id, @Param(value="opRemark")String opRemark);
    
    int undeleteByPrimaryKey(@Param(value="id") String id, @Param(value="opRemark")String opRemark);

    int insert(Shop record);

    Shop selectByPrimaryKey(String id);
    
    Shop selectByCode(@Param(value="code") String code);
    
    Shop selectByShopName(@Param(value="name") String name);
    
    int updateByPrimaryKeySelective(Shop record);

	Shop selectByUserId(String userId);

	int openDanbao(@Param(value="id") String id);
	
    int closeDanbao(@Param(value="id") String id);

	List<Shop> selectAll(@Param(value="page") Pageable pageable);
	
	Long countByShop();
	
	int updateImgByPrimaryKey(@Param(value="id") String id, @Param(value="img") String img);
	
	int updateNameByPrimaryKey(@Param(value="id") String id, @Param(value="name") String name);
	
	int updateWechatByPrimaryKey(@Param(value="id") String id, @Param(value="wechat") String wechat);
	
	int updateDescByPrimaryKey(@Param(value="id") String id, @Param(value="description") String description);
	
	int updateBulletinByPrimaryKey(@Param(value="id") String id, @Param(value="bulletin") String bulletin);
	
	int updateLocalByPrimaryKey(@Param(value="id") String id, @Param(value="provinceId") Long provinceId, @Param(value="cityId") Long cityId);
	
	int updatePostageStatusByPrimaryKey(@Param(value="id") String id, @Param(value="postageStatus") Boolean postageStatus);
	
	int updatePostageByPrimaryKey(@Param(value="id") String id, @Param(value="freeZone") Long freeZone, @Param(value="postage") BigDecimal postage);

	/**
	 * 用于后台店铺管理
	 * @param page
	 * @return
	 */
	List<ShopAdmin> listShopsByAdmin(@Param(value="params") Map<String, Object> params, @Param(value="page") Pageable page);
	
	Long countShopsByAdmin(@Param(value="params") Map<String, Object> params);

	int saveFragmentById(@Param(value="id") String id, @Param(value="fragmentStatus") boolean fragmentStatus);
	
	int addCode(@Param("id") String id);

	Long countByCode(@Param("code") String code); // add by reese 2015-7-23
}