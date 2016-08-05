package com.vdlm.service.tuan.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @类名 : TuanInfoVo
 * @DESCRIPTION :
 * @AUTHOR : Dan
 * @DATE : 2016-03-03 
 */
public class TuanInfoVo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private TuanActivityVo productInfo;

    private List<TuanUserVo> tuanUser;

    private Long tuanBeginTime;

    private Long tuanAliveTime;

    private Long tuanId;

    private String payNo;

    private String userStatus;

    private Long endSec;// 结束的秒数,(开始时间+团持续时间)-当前服务器时间

    private String tuanNo;

    @JsonIgnore(value = true)
    private boolean isChief = false;
    @JsonIgnore(value = true)
    private boolean isPaid = false;
    @JsonIgnore(value = true)
    private boolean isExpire = false;
    @JsonIgnore(value = true)
    private boolean isMemberFull = false;

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public TuanActivityVo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(TuanActivityVo productInfo) {
        this.productInfo = productInfo;
    }

    public List<TuanUserVo> getTuanUser() {
        return tuanUser;
    }

    public void setTuanUser(List<TuanUserVo> tuanUser) {
        this.tuanUser = tuanUser;
    }

    public Long getTuanBeginTime() {
        return tuanBeginTime;
    }

    public void setTuanBeginTime(Long tuanBeginTime) {
        this.tuanBeginTime = tuanBeginTime;
    }

    public Long getTuanAliveTime() {
        return tuanAliveTime;
    }

    public void setTuanAliveTime(Long tuanAliveTime) {
        this.tuanAliveTime = tuanAliveTime;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public Long getTuanId() {
        return tuanId;
    }

    public void setTuanId(Long tuanId) {
        this.tuanId = tuanId;
    }

    public Long getEndSec() {
        return endSec;
    }

    public void setEndSec(Long endSec) {
        this.endSec = endSec;
    }

    public String getTuanNo() {
        return tuanNo;
    }

    public void setTuanNo(String tuanNo) {
        this.tuanNo = tuanNo;
    }

    public boolean getIsChief() {
        return isChief;
    }

    public void setChief(boolean isChief) {
        this.isChief = isChief;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public boolean getIsExpire() {
        return isExpire;
    }

    public void setExpire(boolean isExpire) {
        this.isExpire = isExpire;
    }

    public boolean getIsMemberFull() {
        return isMemberFull;
    }

    public void setMemberFull(boolean isMemberFull) {
        this.isMemberFull = isMemberFull;
    }

}
