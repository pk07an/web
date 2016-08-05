package com.vdlm.service.error;

/**
 * 业务逻辑异常。抛向前端，方便不同的客户端，不同的处理方式
 * 
 * @author jamesp
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static final Throwable t = null;

    private final GlobalErrorCode errorCode;

    private String bizCode;

    public BizException(GlobalErrorCode ec, String message, Throwable cause) {
        super(message, cause);
        errorCode = ec;
    }

    public BizException(GlobalErrorCode ec, String bizCode, String message, Throwable cause) {
        super(message, cause);
        errorCode = ec;
        this.bizCode = bizCode;
    }

    public BizException(GlobalErrorCode ec, String message) {
        this(ec, message, t);
    }

    public BizException(GlobalErrorCode ec, Throwable cause) {
        this(ec, null, cause);
    }

    public BizException(GlobalErrorCode ec, String code, String message) {
        this(ec, code, message, null);
    }

    public GlobalErrorCode getErrorCode() {
        return errorCode;
    }

    public String getBizCode() {
        return bizCode;
    }

}
