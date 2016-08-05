package com.vdlm.meila.client;

import java.io.Serializable;

/**
 ************************************************************
 * @类名 : ReportAddrActModel.java
 *
 * @DESCRIPTION :地址数据上报社区MODEL
 * @AUTHOR : Toney
 * @DATE : 2015年10月14日
 ************************************************************
 */
public class ReportAddrActModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String action;// 操作的名字viewaddrs(地址列表), addaddr(添加地址), deladdr(删除地址)，editaddr(编辑地址)
    private Long userId;// 用户ID
    private String source;// (来源,app接口传空字符串,web传’web’)
    private Integer count;// : 当action为viewaddrs时有此参数，代表地址的数量
    private Long addrId;// (int): 当action为addaddr, deladdr, editaddr代表操作的地址id
    
    private ReportModel reportModel;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getAddrId() {
        return addrId;
    }

    public void setAddrId(Long addrId) {
        this.addrId = addrId;
    }

    public ReportModel getReportModel() {
        return reportModel;
    }

    public void setReportModel(ReportModel reportModel) {
        this.reportModel = reportModel;
    }

}
