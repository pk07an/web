package com.vdlm.web;

import java.net.URLDecoder;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.vdlm.meila.client.MeilaClient;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;
import com.vdlm.web.common.JsonResult;

@RequestMapping("/service")
@Controller
public class MeilaWeixinSignController extends MeilaBaseController{
    private static Logger LOG = LoggerFactory.getLogger(MeilaWeixinSignController.class);
    @Autowired
    private MeilaClient meilaClient;
    
    @RequestMapping("getWeinXinSign.json")
    @ResponseBody
    public JsonResult getWeiXinSign(String url){
        JsonResult result = new JsonResult();
        try{
            
            String decodeUrl = URLDecoder.decode(url, "UTF-8");
            LOG.debug("微信open js签名url:" + decodeUrl);
            String weiXinShareSignJsonStr = meilaClient.getWeiXinShareSign(decodeUrl);
            if (StringUtils.isBlank(weiXinShareSignJsonStr)) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "获取微信分享接口签名失败");
            }
            
            JSONObject json  =   JSONObject.parseObject(weiXinShareSignJsonStr);
            if("0".equals(json.getString("ret"))){
                result.setData( json.get("signature"));
            }else{
                result.setRet(JsonResult.FAILED);
                result.setErrCode(json.getString("ret"));
                result.setMsg(json.getString("msg"));
            }
        }catch(Exception ex){
            result.setRet(JsonResult.FAILED);
            result.setErrCode("-11");
            result.setMsg("获取微信分享接口失败");
        }
        return result;
    }
}
