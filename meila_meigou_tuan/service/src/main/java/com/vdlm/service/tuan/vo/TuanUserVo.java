package com.vdlm.service.tuan.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @类名 : TuanUserVo 
 * @DESCRIPTION :
 * @AUTHOR : Dan
 * @DATE : 2016-03-02 
 */
public class TuanUserVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String userCode;

    private String nickName;

    private String userImg;

    private String userRole;

    @JsonIgnore(value = true)
    private Date createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
