package com.vdlm.dal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.CampaignProduct;
import com.vdlm.dal.vo.CampaignProductEX;
import com.vdlm.dal.vo.XQHomeActProductVO;

public interface CampaignProductMapper {

    int insert(CampaignProduct prod);

    void deleteByActivityAndProduct(@Param("activityId") String activityId, @Param("productId") String productId);

    List<CampaignProduct> selectByTicket(@Param("ticketId") String ticketId);
    
    List<CampaignProduct>  selectByProdcut(@Param("productId") String productId);

    CampaignProduct selectByTicketAndProduct(@Param("ticketId") String ticketId, @Param("productId") String productId);

    int updateByTicketAndProduct(CampaignProduct prod);
    
    void deleteActivityProducts(@Param("activityId") String activityId, @Param("productIds") List<String> productIds);

    List<CampaignProductEX> loadCampaignProductEX(@Param("activityId") String activityId, @Param("shopId") String shopId);
    
    //partner
    Long countCampaignProductByQuery(@Param("paramsMap")Map<String, Object> paramsMap);
    List<CampaignProductEX> listCampaignProductByQuery(@Param("paramsMap")Map<String, Object> paramsMap, @Param("pager")Pageable pager);
    
	Long countCampaignProduct4Home(@Param("paramsMap")Map<String, Object> paramsMap);
    List<XQHomeActProductVO> listCampaignProduct4Home(@Param("paramsMap")Map<String, Object> paramsMap, @Param("page")Pageable page);
    
    void auditTicketProduct(@Param("newTicketId")String newTicketId, @Param("activityId")String activityId, @Param("oldTicketId")String oldTicketId, @Param("productId")String productId);
}
