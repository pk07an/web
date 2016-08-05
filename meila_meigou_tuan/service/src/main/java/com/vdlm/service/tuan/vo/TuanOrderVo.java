package com.vdlm.service.tuan.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @类名 : TuanOrderVo.java
 *
 * @DESCRIPTION : 我的拼团对象
 * @AUTHOR : peter
 * @DATE : 2016年3月3日
 */
public class TuanOrderVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tuanNo;// 团单号

    private String orderNo;// 订单号，作为订单详情跳转参数

    private String payNo;// 支付单号，作为去支付

    private String orderStatus;// 订单支付状态

    private String tuanStatus;// 团单状态

    private TuanActivityVo tuanActivity;

    private String status;

    private String statusDesc;

    private int count;

    private Date createdAt;
    
    private List<TuanUserVo> tuanUser;

    public String getTuanNo() {
        return tuanNo;
    }

    public void setTuanNo(String tuanNo) {
        this.tuanNo = tuanNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTuanStatus() {
        return tuanStatus;
    }

    public void setTuanStatus(String tuanStatus) {
        this.tuanStatus = tuanStatus;
    }

    public TuanActivityVo getTuanActivity() {
        return tuanActivity;
    }

    public void setTuanActivity(TuanActivityVo tuanActivity) {
        this.tuanActivity = tuanActivity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<TuanUserVo> getTuanUser() {
        return tuanUser;
    }

    public void setTuanUser(List<TuanUserVo> tuanUser) {
        this.tuanUser = tuanUser;
    }

}
