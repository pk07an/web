package com.vdlm.meila.client;

import java.io.Serializable;

/**
 * 社区上报数据MODEL
 * 
 * @author peter
 */
public class OnPurchaseModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String type = "ec_action";
    private String client_id;// 客户端id
    private long user_id;// 用户id
    private String name; // 上报的名称
    private Object data;// 上报参数
    private String ip_address; // 用户ip
    private int source; // app还是web，1是app，4是web
    private String create_time; // 创建时间

    private ReportModel reportModel;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public ReportModel getReportModel() {
        return reportModel;
    }

    public void setReportModel(ReportModel reportModel) {
        this.reportModel = reportModel;
    }
}
