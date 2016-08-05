package com.vdlm.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Tag;

public interface TagMapper {

	int insert(Tag record);

	Tag selectByPrimaryKey(String id);

	Tag selectByOwnerTagName(@Param(value="tag") String tag, @Param(value="creatorId") String creatorId);
	
    /**
     * 根据商品ID获取所有的Tag列表
     * @param productId
     * @return
     */
//	List<Tag> selectByProductId(String productId);
	
	/**
     * 根据店铺ID获取所有的Tag列表
     * @param productId
     * @return
     */
	List<Tag> selectByShopId(@Param(value="shopId") String shopId, @Param(value="tag") String tag);
	
	List<Tag> selectUserTags(String userid);
	
    Tag selectUserTag(String tag, String userId);

    int updateUserTag(String id, String tag, String userId);

    int deleteTag(String tag, String userId);
}
