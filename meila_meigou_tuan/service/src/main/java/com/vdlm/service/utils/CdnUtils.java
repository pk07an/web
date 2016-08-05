package com.vdlm.service.utils;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CdnUtils implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Value("${meila.cdn.host:}")
    private String cdnHost;

    public String getCdnHost() {
        return cdnHost;
    }

    public void setCdnHost(String cdnHost) {
        this.cdnHost = cdnHost;
    }
}
