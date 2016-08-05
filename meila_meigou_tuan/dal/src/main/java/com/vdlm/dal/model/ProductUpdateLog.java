package com.vdlm.dal.model;

import com.vdlm.dal.BaseEntityImpl;

import java.util.Date;

/**
 * 商品信息修改记录 reese 2015/7/15
 */
public class ProductUpdateLog  {

    private long id ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private int type;


    private String preUpdate;


    private String afterUpdate;


    private Long opUserId;


    private Date updateAt;


    public int getType() {
        return type;
    }


    public void setType(int type) {
        this.type = type;
    }


    public String getPreUpdate() {
        return preUpdate;
    }


    public void setPreUpdate(String preUpdate) {
        this.preUpdate = preUpdate == null ? null : preUpdate.trim();
    }


    public String getAfterUpdate() {
        return afterUpdate;
    }


    public void setAfterUpdate(String afterUpdate) {
        this.afterUpdate = afterUpdate == null ? null : afterUpdate.trim();
    }


    public Long getOpUserId() {
        return opUserId;
    }


    public void setOpUserId(Long opUserId) {
        this.opUserId = opUserId;
    }


    public Date getUpdateAt() {
        return updateAt;
    }


    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}