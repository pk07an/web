package com.vdlm.dal.mapper;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Personnel;
import com.vdlm.dal.type.UserPartnerType;

public interface PersonnelMapper {
	
	/*List<Personnel> listPersonnelsAdmin(@Param(value="params") Map<String, Object> params, @Param(value="page") Pageable page);
	
	void insert(Personnel bean);
	
	void update(Personnel bean);
	
	void delete(String id);*/
	
	Personnel loadByExtUserIdAndPartner(@Param(value="userId")String userId, @Param(value="partner")UserPartnerType partner);
	
	Personnel loadByInnerIdAndPartner(@Param(value="innerId")String innerId, @Param(value="partner")UserPartnerType partner);
}
