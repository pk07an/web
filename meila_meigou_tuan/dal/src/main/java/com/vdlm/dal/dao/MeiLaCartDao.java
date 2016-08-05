package com.vdlm.dal.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.CartItem;

public interface MeiLaCartDao {
    
    public int deleteByKeyAndUserId(@Param("ids")List<String> ids,@Param("userId")String userId, @Param("cartType") String cartType);

    public List<CartItem> selectByUserIdAndCartType(@Param("userId")String userId, @Param("cartType") String cartType, @Param("skuIds")Set<String> skuIds);
    
    /**
     * 功能描述：用户购物车中的商品数量
     * @param userId
     * @param cartType
     * @return
     */
    public Integer countByUserIdAndCartType(@Param("userId")String userId, @Param("cartType") String cartType,@Param("skuId")String skuId);

    /**
     * 功能描述：更新购物车中的数量
     * @param skuId
     * @param amount
     * @param userId
     */
    public void updateBySkuSelective(@Param("skuId")String skuId, @Param("amount")int amount, @Param("userId")String userId);
    
    public CartItem selectByUserIdAndSku(@Param("skuId")String skuId, @Param("userId")String userId,@Param("cartType")String cartType);

    public void deleteBySkuAndCartType(@Param("userId")String userId, @Param("skuId")String skuId, @Param("cartType")String cartType);

    /**
     * 功能描述：物理商品skuId
     * @param userId
     * @param skuId
     * @param cartType
     * @return
     */
    public int deleteByUserIdAndSkuId(@Param("userId")String userId, @Param("skuId")String skuId, @Param("cartType")String cartType);
}
