package com.vdlm.dal.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.Activity;
import com.vdlm.dal.type.ActivityStatus;
import com.vdlm.dal.type.ActivityType;
import com.vdlm.dal.vo.ActivityEX;

public interface ActivityMapper {
	
	Activity loadById(@Param("id")String id);

    ActivityEX selectByPrimaryKey(@Param("id")String id, @Param("shopId")String shopId, @Param("onlySubmitted")boolean onlySubmitted);
    
    List<ActivityEX> selectAll();

    List<ActivityEX> selectPub();

    List<ActivityEX> selectByUser(String userId);
    
    //TODO 后期重构
    List<ActivityEX> selectPublicForeverList();
    ActivityEX selectPublicForeverSelf(@Param("activityId")String activityId, @Param("shopId")String shopId);

    List<ActivityEX> selectPubAndPrivate(@Param("userId")String userId, @Param("shopId")String shopId);
    
    int insert(Activity entity);
    
    int update(Activity entity);
    
    int delete(@Param("id") String id, @Param("userId") String userId);
    
    void updateStatusToInProgress();
    
    void updateStatusToClosed();
    
    void updateStatusToClosedById(@Param("id") String id);

    List<ActivityEX> selectNotStartedToBeInProgress();
    
    List<ActivityEX> selectNotStartedToBeClosed();
    
    List<ActivityEX> selectInProgressToBeClosed();

    int updateStatusFromStatus(@Param("id") String id, @Param("fromStatus") ActivityStatus fromStatus, @Param("toStatus") ActivityStatus toStatus);

    Long selectCountByRange(@Param("userId") String userId, @Param("from") Date from, @Param("to") Date to, @Param("excludeId") String excludeId);

    Activity obtainProductCurrentActivities(@Param("productId") String productId);
    
    ActivityEX loadActivityEx(@Param("activityId")String activityId, @Param("shopId")String shopId, @Param("activityType") ActivityType activityType);
    
    
    //partner
    Long countActivitysByQuery(@Param("paramsMap")Map<String, Object> paramsMap);
    List<Activity> listActivitysByQuery(@Param("paramsMap")Map<String, Object> paramsMap, @Param("pager")Pageable pager);
}