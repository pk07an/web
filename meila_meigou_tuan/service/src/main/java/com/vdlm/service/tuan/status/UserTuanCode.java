package com.vdlm.service.tuan.status;

/**
 * 
 ************************************************************
 * @类名 : UserTuanCode.java
 *
 * @DESCRIPTION :团异常code 
 * @AUTHOR :  dan
 * @DATE :  2016年3月3日
 ************************************************************
 */
public enum  UserTuanCode {
    CHIEF_SUCCESS,
    CHIEF_REFUNDING,
    CHIEF_REFUNDED,
    CHIEF_REUND_WAIT,
    CHIEF_PROCESS,
    CHIEF_CANCEL,
    CHIEF_UNPAID,
    MEMBER_PROCESS_UNJOIN,
    MEMBER_EXPIRE_UNJOIN,
    MEMBER_FULL_UNJOIN,
    MEMBER_EXPIRE_JOIN,
    MEMBER_FULL_REFUNDING,
    MEMBER_FULL_REFUNDED,
    MEMBER_FULL_REUND_WAIT,
    MEMBER_EXPIRE_REFUNDING,
    MEMBER_EXPIRE_REFUNDED,
    MEMBER_EXPIRE_REFUND_WAIT,
    MEMBER_PROCESS_JOIN,
    MEMBER_PROCESS_UNPAID,
    MEMBER_SUCCESS;
}