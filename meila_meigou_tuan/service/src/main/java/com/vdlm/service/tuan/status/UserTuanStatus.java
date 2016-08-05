package com.vdlm.service.tuan.status;

public enum UserTuanStatus {
    WAIT_PAID("WAIT_PAID", "等待支付"),
    PAY_CANCEL("PAY_CANCEL", "已取消"),
    REFUNDING("REFUNDING", "拼团失败，退款中"),
    REFUNDED("REFUNDED", "参团失败，已退款"),
    PROCESS("PROCESS", "拼团中"), 
    SUCCESS("SUCCESS", "拼团成功"),
    WAIT_REFUNDING("WAIT_REFUNDING", "拼团失败，等待退款"),
    WAIT_COMFIRM("WAIT_COMFIRM","待确认");
    private String msg;
    private String code;

    private UserTuanStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
