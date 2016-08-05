package com.vdlm.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.meila.client.OnPurchaseModel;
import com.vdlm.meila.client.ReportModel;
import com.vdlm.service.constants.Constants;
import com.vdlm.service.utils.IPUtil;

/**
 ************************************************************
 * @类名 : MeiLaSNSReportUtils.java
 *
 * @DESCRIPTION : 电商向社区上报数据的工具类
 * @AUTHOR : peter
 * @DATE : 2016年4月21日
 ************************************************************
 */
public class MeiLaSNSReportUtils {

    /**
     *
     * 功能描述：构造上报社区数据.
     * 
     * @param action
     * @param req
     * @param curUserId
     * @return OnPurchaseModel
     * @Exception :
     */
    public static OnPurchaseModel createOnPurchaseModel(String action, HttpServletRequest req, String curUserId,
        Map<String, Object> data) {

        final long userId = StringUtils.isBlank(curUserId) ? 0 : IdTypeHandler.decode(curUserId);

        ReportModel reportModel = MeiLaSNSReportUtils.createReportModel(action, req, curUserId);

        OnPurchaseModel model = new OnPurchaseModel();
        model.setClient_id("");
        model.setUser_id(userId);
        model.setName(action);
        model.setIp_address(IPUtil.getRequestIP(req));
        boolean isApp = MeiLaDeviceUtils.isApp(req);
        model.setSource(isApp ? 1 : 4);
        String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        model.setCreate_time(createDate);
        data = data == null ? new HashMap<String, Object>() : data;
        Map<String, String> sourceMap = UtmParamUtil.getSourceMap(req);
        if (sourceMap.containsKey("source")) {
            sourceMap.remove("source");
        }
        data.putAll(sourceMap);
        model.setData(data);
        model.setReportModel(reportModel);
        return model;
    }
    
    /**
    *
    * 功能描述：构造上报社区数据.(new)
    * 
    * @param action
    * @param req
    * @param curUserId
    * @return ReportModel
    * @Exception :
    */
   public static ReportModel createReportModel(String action, HttpServletRequest req, String curUserId) {

       final long userId = StringUtils.isBlank(curUserId) ? 0 : IdTypeHandler.decode(curUserId);

       ReportModel model = new ReportModel();
       model.getUser().setId(userId);
       model.getAction().setName(action);
       model.setIp_address(IPUtil.getRequestIP(req));
       boolean isApp = MeiLaDeviceUtils.isApp(req);
       model.setSource(isApp ? 1 : 4);
       String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
       model.setCreate_time(createDate);

       Map<String, Object> data = new HashMap<String, Object>();
       Map<String, String> sourceMap = UtmParamUtil.getSourceMap(req);
       if (sourceMap.containsKey("client_id")) {
           model.getClient().setClient_id(sourceMap.get("client_id"));
           sourceMap.remove("client_id");
       }else{
           model.getClient().setClient_id("");
       }

       if (sourceMap.containsKey("source")) {
           sourceMap.remove("source");
       }
       data.putAll(sourceMap);
       
       model.getAction().setExtra_data(data);
       model.getClient().setApp(65);
       return model;
   }
}
