/**
 * 
 */
package com.vdlm.web.common;

/**
 * @author yongqi@meila.com
 *
 */
public class JsonResult {

    public static final int FAILED = 1;
    public static final int SUCCESS = 0;

    private int ret;
    private String msg;
    private Object data;
    private String errCode;

    public JsonResult() {
        this.setRet(SUCCESS);
        this.setErrCode("0");
    }

    public JsonResult(int ret, String msg, Object data) {
        this.ret = ret;
        this.msg = msg;
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
