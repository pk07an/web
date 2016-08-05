package com.vdlm.dal.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.vdlm.dal.model.Product;
import com.vdlm.dal.status.ProductStatus;
import com.vdlm.dal.vo.ProductAdmin;

public interface ProductMapper {
    int insert(Product record);

    Product selectByPrimaryKey(String id);
    
    Product selectOriginalById(String id);
    
//    Product selectByCode(String code);
    
    Product selectOriginalByCode(String code);

    int updateByPrimaryKeySelective(Product record);

    int updateAmountAndSales(String id, Integer amount);
    
    int updateForArchive(String id);
	
    int updateForUnArchive(String id);
    
    int updateForInstock(String id);
	
    int updateForOnsale(String id);
    
    int updateForForsale(String id, Date forsaleAt);
    
    /**
     * 上架列表
     * @param shopId
     * @param page
     * @param params
     * @return
     */
    List<Product> listProductsByOnsaleAt(@Param(value="shopId") String shopId, @Param(value="page") Pageable page, @Param(value="params") Map<String, Object> params);
    
    /**
     * 销量列表
     * @param shopId
     * @param page
     * @return
     */
	List<Product> listProductsBySales(@Param(value="shopId") String shopId, @Param(value="page") Pageable page, @Param(value="direction") Direction direction);
	
	Long countProductsBySales(@Param(value="shopId") String shopId);
	
	/**
	 * 库存列表
	 * @param shopId
	 * @param page
	 * @return
	 */
	List<Product> listProductsByAmount(@Param(value="shopId") String shopId, @Param(value="page") Pageable page, @Param(value="direction") Direction direction);
	
	/**
	 * 下架列表
	 * @param shopId
	 * @return
	 */
	List<Product> listProductsBySoldout(@Param(value="shopId") String shopId, @Param(value="page") Pageable page, @Param(value="direction") Direction direction);
	
	
	/**
	 * 查询
	 * @param shopId
	 * @param kwd
	 * @return
	 */
	List<Product> listProductsBySearch(@Param(value="shopId") String shopId, @Param(value="kwd") String kwd,@Param(value="page") Pageable page);
	
	/**
	 * 根据关键字进行搜索，返回总记录数据  by zzd
	 * @param shopId
	 * @param name
	 * @return
	 */
	Long CountTotalByName(@Param(value="shopId")String shopId, @Param(value="kwd") String kwd);
	
	
	
	/**
	 * 草稿列表
	 * @param shopId
	 * @param page
	 * @return
	 */
	List<Product> listProductsByStatusDraft(@Param(value="shopId") String shopId, @Param(value="page") Pageable page);
	
	/**
	 * 计划发布列表
	 * @param shopId
	 * @param page
	 * @return
	 */
	List<Product> listProductsByForSale(@Param(value="shopId") String shopId, @Param(value="page") Pageable page);
	
	/**
	 * 缺货列表
	 * @param shopId
	 * @param page
	 * @return
	 */
	List<Product> listProductsByOutOfStock(@Param(value="shopId") String shopId, @Param(value="page") Pageable page);
	
	/**
	 * 店长推荐
	 * @param shopId
	 * @return
	 */
	List<Product> listProductsByRecommend(@Param(value="shopId") String shopId, @Param(value="page") Pageable page);
	
	Long countByRecommend(@Param(value="shopId") String shopId);
	
	/**
	 * 相关商品，根据tag
	 * @param id
	 * @return
	 */
	List<Product> listProductsByRelated(String shopId, String id);
	
	/**
	 * 根据发布计划自动上架
	 * @return
	 */
	int updateForSaleToOnSale();
	
	/**
	 * 最近发布商品
	 * @param shopId
	 * @param date
	 * @param days
	 * @return
	 */
	List<Map<String, Object>> listProductByRecently(@Param(value="shopId") String shopId, @Param(value="date") Date date, @Param(value="days") int days);

	/**
	 * 每种状态商品的数量
	 * @param shopId
	 * @param status
	 * @return
	 */
	Long countProductsByStatus(@Param(value="shopId") String shopId, @Param(value="status") ProductStatus status);
	
	/**
	 * 缺货商品的数量
	 * @param shopId
	 * @return
	 */
	Long countProductsByOutofStock(@Param(value="shopId") String shopId);
	
	/**
	 * 自动上架
	 */
	int autoOnSaleByTask();
	
	/**
	 * 用于后台商品管理
	 * @param page
	 * @return
	 */
	List<ProductAdmin> listProductsByAdmin(@Param(value="params") Map<String, Object> params, @Param(value="page") Pageable page);
	
	Long countProductsByAdmin(@Param(value="params") Map<String, Object> params); 
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Product selectByAdmin(String code);

	List<Product> selectAll(@Param(value="shopId")String shopId);
	
	Boolean instockByAdmin(@Param("ids")String[] ids);
	
	int deleteByAdmin(@Param("ids")String[] ids);
	
	int undeleteByAdmin(@Param("ids")String[] ids);
	
	/**
	 * 对分页商品列表接口取总数
	 * @param shopId  店铺ID
	 * @param catType  商品排序分类类型  { 'sales', 'amount', 'soldout', 'statusDraft', 'outofstock } + default
	 * @param params
	 * @return
	 */
	Long selectLastCnt(@Param(value="shopId")String shopId, @Param(value="catType") String catType, @Param(value="params")  Map<String, Object> params);

	/**
     * 根据活动取商品列表
     * @param actId
     * @return
     */
    List<Product> listProductsByActId(@Param(value="actId")String actId, @Param("sort")String sortStr);
    
    List<Product> listActivityProducts(@Param("pager")Pageable pager, @Param("sort")String sortStr);

    int updateFakeSales(@Param("id")String id, @Param("count")int count);
    
    List<Product> getForsaleNow();
    
    Long countDelayProduct(String shopId);
    
    List<Product> listDelayProduct(@Param("shopId")String shopId, @Param("page")Pageable page);
    
    List<Product> listUnCategoriedProductsInShop(@Param("shopId")String shopId, @Param("pager")Pageable pager);

    long countUnCategoriedProductsInShop(@Param("shopId") String shopId);

    // 仅在活动的时候使用，注意有update_lock设置
    int updatePriceDiscountByShop(@Param("shopId") String shopId, @Param("discount") Float discount);

    // 仅在活动的时候使用，注意有update_lock设置
    int updatePriceDiscount(@Param("id") String id, @Param("discount") Float discount);
    
    // 仅在活动的时候使用，注意有update_lock设置
    int updatePriceReduction(@Param("id") String id, @Param("reduction") Float reduction);
    
    // 仅在活动的时候使用，注意有update_lock设置
    int updatePriceFromMarketPriceByShop(@Param("shopId") String shopId);

    // 仅在活动的时候使用，注意有update_lock设置
    int updatePriceFromMarketPrice(@Param("id") String id);
    
    int synchronousSource(@Param("id")String id, @Param("sourceVal")String sourceVal);
    List<String> obtainDbSynchronous(@Param("ids")List<String> ids);
 	//获取活动下商品列表 (vdlm_campaign_product)
	List<Product> listProductByActivityId(@Param("activityId") String activityId);

	List<Product> listProductsAvailableByChannel(@Param("activityId")String activityId, @Param("shopId")String shopId, @Param("pager")Pageable pager, @Param("channel")String channel);
	Long countProductsByChannel(@Param("activityId")String activityId,@Param("shopId")String shopId, @Param("channel")String channel);
	
	/**
	 * 根据thirdItemId返回商品id
	 */
	Long selectProductIdByThirdItemId(@Param("thirdItemId") String thirdItemId);

	List<Product> listNoCodeProducts();

	void addCode(String code);

    List<Product> selectSimilarProduct(@Param("shopId")String shopId, @Param("excludeCode")String excludeCode, @Param("page")Pageable page);

	Map<String, Object> loadExt(String productId);

	void insertExt(@Param("map") Map<String, String> map, @Param("productId") String productId);
	void updateExt(@Param("map") Map<String, String> map,  @Param("productId") String productId);

	// 获取扩展属性
	Map<String, Object> loadInfo(String productId);

	void insertInfo(@Param("map") Map<String, String> map, @Param("productId") String productId);

	void updateInfo(@Param("map") Map<String, String> map, @Param("productId") String productId);
	

    List<Product> selectByIdList(@Param("ids") List<String> ids);
    
    long countProductListByUserID(@Param("userId") String userId);

    int updateSaleByProductId(@Param("productId")String productId, @Param("sale")Integer sale);
	
}
