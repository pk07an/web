package com.vdlm.resolver;

import java.util.Arrays;

import org.springframework.mobile.device.LiteDeviceResolver;

public class VdlmDeviceResolver extends LiteDeviceResolver {
    
    private static final String[] KNOWN_MOBILE_USER_AGENT_KEYWORDS = new String[] {
        "%e6%83%b3%e5%8e%bb" // 想去
    };

    protected void init() {
        super.init();
        getMobileUserAgentKeywords().addAll(
                Arrays.asList(KNOWN_MOBILE_USER_AGENT_KEYWORDS));
    } 
}
