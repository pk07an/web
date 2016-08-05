package com.vdlm.biz.res.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.vdlm.biz.qiniu.Qiniu;
import com.vdlm.biz.res.ResourceFacade;

@Component("resourceFacadePTuan")
public class ResourceFacadePTuan implements ResourceFacade {

    @Autowired
    private Qiniu qiniu;

    // 美啦的七牛地址
    @Value("${meila.qiniu.host.name}")
    private String meilaQiniuHost;

    @Override
    public String resolveUrl(String resKey) {
        if (StringUtils.isBlank(resKey)) {
            return "";
        } else if (resKey.startsWith("commonbanner/")) {
            return meilaQiniuHost + "/uploads/" + resKey;
        } else if (resKey.startsWith(FILE_STORE_KEY_V2)) {
            resKey = resKey.substring(1);
            return qiniu.genQiniuFileUrl(resKey);// 返回七牛的URL，直接去七牛服务器上取
        } else if (resKey.startsWith("/")) {
            return meilaQiniuHost + resKey;// 美啦的七牛地址

        } else if (resKey.startsWith("/avatar") || resKey.startsWith("/meila")) {
            return meilaQiniuHost + "/uploads" + resKey;
            // TODO
        } else if (resKey.startsWith("avatar") || resKey.startsWith("meila")) {
            return meilaQiniuHost + "/uploads/" + resKey;
            // TODO
        } else {
            return meilaQiniuHost + (resKey.startsWith("/") ? "" : "/") + resKey;
        }
    }
}
