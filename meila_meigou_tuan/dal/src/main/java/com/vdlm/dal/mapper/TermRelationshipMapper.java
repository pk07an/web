package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.TermRelationship;

public interface TermRelationshipMapper {
	
	int insert(TermRelationship record);
	
	int delete(String id);

	TermRelationship select(String objType, String objId, String cid);
	
	List<TermRelationship> listInCategory(@Param("cid")String cid, @Param("objType")String objType, @Param("pager")Pageable pager);

	List<TermRelationship> listUnderCategory(@Param("cid")String cid, @Param("shopId")String shopId, @Param("objType")String objType, @Param("pager")Pageable pager);
	
    long countUnderCategory(@Param("cid")String cid, @Param("objType")String objType);

	void deleteByCatAndObject(@Param("objType") String type, @Param("objId")String posterId, @Param("cid")String cid);

    long countProducts(String id, String userId);

    List<TermRelationship> checkProductIdExists(@Param("objType")String objType, @Param("objId")String objId);
    
}
