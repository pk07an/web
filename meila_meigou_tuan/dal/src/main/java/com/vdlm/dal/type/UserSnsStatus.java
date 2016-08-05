package com.vdlm.dal.type;


/**
 * 用户好友关系状态
 * @author yongqi@meila.com
 */
public enum UserSnsStatus {

    NONE(0, "无关注"),
    FANS(1, "他关注了我"),
    FOLLOW(10, "我关注了他"),
    BOTH(11, "互相关注");
    

    private Integer code;
    private String msg;
    
    private UserSnsStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static UserSnsStatus findByCode(Integer code) {
        if (null == code) {
            return null;
        }
        for (UserSnsStatus e : values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }
    
    
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
