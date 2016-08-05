package com.vdlm.meila.client;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 ************************************************************
 * @类名 : ReportModel.java
 *
 * @DESCRIPTION : 新日志上报类
 * @AUTHOR : meila-x
 * @DATE : 2016年4月20日
 ************************************************************
 */
public class ReportModel implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String type = "action";
    private int source; // app还是web，1是app，4是web

    private ReportClientModel client = new ReportClientModel();// 客户端对象
    private String create_time; // 创建时间

    private ReportUserModel user = new ReportUserModel();

    private String ip_address; // 用户ip
    private final ReportActionModel action = new ReportActionModel();// 上报参数

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public ReportClientModel getClient() {
        return client;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public ReportUserModel getUser() {
        return user;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public void setClient(ReportClientModel client) {
        this.client = client;
    }

    public void setUser(ReportUserModel user) {
        this.user = user;
    }

    public ReportActionModel getAction() {
        return action;
    }

    public class ReportUserModel implements Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        private long id;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }

    public class ReportClientModel implements Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        private int app;
        private String client_id;

        public int getApp() {
            return app;
        }

        public void setApp(int app) {
            this.app = app;
        }

        public String getClient_id() {
            return client_id;
        }

        public void setClient_id(String client_id) {
            this.client_id = client_id;
        }
    }

    public class ReportActionModel implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        private Map<String, Object> extra_data;
        
        private String name; // 上报的名称

        public Map<String, Object> getExtra_data() {
            return extra_data;
        }

        public void setExtra_data(Map<String, Object> extra_data) {
            this.extra_data = extra_data;
        }
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
