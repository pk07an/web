package com.vdlm.biz.authentication;

/**
 *
 * @author:  chenxi
 */

public class LoginConfigurationException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 296136311569044829L;

    public LoginConfigurationException() {
        super();
    }

    public LoginConfigurationException(String msg) {
        super(msg);
    }

    public LoginConfigurationException(Throwable t) {
        super(t);
    }

    public LoginConfigurationException(String msg, Throwable t) {
        super(msg, t);
    }

}
