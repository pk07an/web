package com.vdlm.service.tuan.vo;

import java.io.Serializable;

public class TuanAdderssVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String addressId;

    private String addressStr; // 详细地址

    private String consignee; // 收件人

    private String phone;

    private String idCard;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressStr() {
        return addressStr;
    }

    public void setAddressStr(String addressStr) {
        this.addressStr = addressStr;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

}
