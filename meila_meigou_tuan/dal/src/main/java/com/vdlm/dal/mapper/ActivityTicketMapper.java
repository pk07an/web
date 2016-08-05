package com.vdlm.dal.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vdlm.dal.model.ActivityTicket;
import com.vdlm.dal.status.ActivityTicketAuditStatus;
import com.vdlm.dal.type.ActivityStatus;

public interface ActivityTicketMapper {

    int insert(ActivityTicket ticket);
    
    int update(ActivityTicket ticket);

//    ActivityTicket selectLatest(@Param("activityId") String activityId, @Param("shopId") String shopId);

    ActivityTicket selectOne(@Param("activityId") String activityId, @Param("shopId") String shopId);

    void updateAuditStatus(@Param("activityId") String activityId, @Param("status") ActivityTicketAuditStatus status);
    
    Long selectCountByRange(@Param("shopId") String shopId, @Param("from") Date from, @Param("to") Date to, @Param("excludeId") String excludeId);

    int deleteByActivityId(@Param("activityId") String activityId);

    void updateStatusToInProgress();

    void updateStatusToClosed();

    List<ActivityTicket> selectNotStartedToBeInProgress(@Param("activityId") String activityId);

    List<ActivityTicket> selectNotStartedToBeClosed();

    List<ActivityTicket> selectInProgressToBeClosed();

    int updateStatusFromStatus(@Param("id") String ticketId, @Param("fromStatus") ActivityStatus fromStatus, @Param("toStatus") ActivityStatus toStatus);

    ActivityTicket loadJoinTicketByActivityAndShop(@Param("activityId")String activityId, @Param("shopId")String shopId);
    
    ActivityTicket loadSubmittedTicket4Audit(@Param("activityId")String activityId, @Param("productId")String productId);

	void updateStatusToClosedById(@Param("id") String id);
	
	List<ActivityTicket> loadAllTicketByActId(@Param("activityId") String activityId);
}
