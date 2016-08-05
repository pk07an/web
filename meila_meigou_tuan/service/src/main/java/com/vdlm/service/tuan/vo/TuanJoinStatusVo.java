package com.vdlm.service.tuan.vo;

import java.io.Serializable;
import java.util.Date;

public class TuanJoinStatusVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tuanNo;

    private Date startTime;

    private int needNum;

    private String nickName;

    private String userImg;

    public String getTuanNo() {
        return tuanNo;
    }

    public void setTuanNo(String tuanNo) {
        this.tuanNo = tuanNo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getNeedNum() {
        return needNum;
    }

    public void setNeedNum(int needNum) {
        this.needNum = needNum;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

}
