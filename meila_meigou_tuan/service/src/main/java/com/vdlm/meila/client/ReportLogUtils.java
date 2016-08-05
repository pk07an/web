package com.vdlm.meila.client;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vdlm.utils.CommonUtils;

public class ReportLogUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportLogUtils.class);
    
    /**
     * 
     *
     * 功能描述：日志上报方法
     * 
     * @param reportModel void
     *
     */
    public static void doReport(ReportModel reportModel){
        String jsonStr =CommonUtils.objectToString(reportModel);
        if(StringUtils.isNotBlank(jsonStr)){
            LOGGER.info(jsonStr);
        }
        
    }
}
