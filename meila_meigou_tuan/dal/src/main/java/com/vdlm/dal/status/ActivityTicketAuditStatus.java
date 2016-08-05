package com.vdlm.dal.status;

public enum ActivityTicketAuditStatus {
    DRAFT,       // 草稿状态
    SUBMITTED, // 已提交未审核
    AUDITING, // 审核中
    APPROVED, // 通过
    REJECTED,  // 未通过
    CANCELLED  // 撤销
}
