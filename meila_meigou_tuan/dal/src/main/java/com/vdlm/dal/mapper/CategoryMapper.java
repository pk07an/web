package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.Category;
import com.vdlm.dal.type.Taxonomy;
import com.vdlm.dal.vo.CategoryVO;

public interface CategoryMapper {
	
    int insert(Category record);

	Category load(String id);
	
	void update(Map<String, Object> params, Map<String, Object> values);
    
	Category selectByTermAndTaxonomy(@Param("termId") String termId, @Param("taxo") Taxonomy taxo, @Param("shopId") String shopId);

    List<Category> selectRootNodes(Taxonomy taxo);
    
    List<Category> selectByTaxonomy(Taxonomy taxo);

    List<Category> selectSiblings(String id);

    Category loadParent(String id);

    List<Category> loadSubs(String id);

    List<Category> loadDescendants(String id);
    
    int update(Category record);
      
    // for shop user
    void updateCategoryTerm(String id, String termId, String term, String userId);

    List<Category> listRootsByUser(Taxonomy taxo, String userId);

    Category loadByTermIdAndTaxonomy(String id, Taxonomy taxo, String userId);
    
    int delete(String id, String userId);

    List<Category> selectByTaxonomyAndShopId(Taxonomy category, String shopId);
    
    Integer selectMaxIdx(@Param("parentId") String parentId, @Param("shopId") String shopId);

    void updateIdx(String srcId, int idx);

    void updateIdxNotBeforeDest(@Param("parentId") String parentId, @Param("shopId") String shopId, @Param("idx") int idx, @Param("increment") int increment);

    void updateIdxAfterDest(@Param("parentId") String parentId, @Param("shopId") String shopId, @Param("idx") int idx, @Param("increment") int increment);
    
    CategoryVO loadCategoryByProductId(String productId);

}