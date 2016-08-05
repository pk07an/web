package com.vdlm.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import com.meila.meigou.cachehelper.MeilaCached;
import com.vdlm.dal.model.User;
import com.vdlm.meila.client.MeilaClient;
import com.vdlm.meila.client.MeilaSimpleUser;
import com.vdlm.meila.client.MeilaUser;
import com.vdlm.service.user.UserService;
import com.vdlm.service.utils.CdnUtils;
import com.vdlm.web.common.JsonResult;

public class MeilaBaseController extends BaseController {

    @Autowired
    protected MeilaClient meilaClient;
    @Autowired
    protected UserService userService;

    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;

    @Autowired
    private CdnUtils cdnUtils;

    @MeilaCached
    protected MeilaUser getMeilaUserInfo(String userId) {
        User user = userService.loadBySlave(userId);
        log.debug("user.getExtUserId = " + user.getExtUserId());
        MeilaUser user2 = meilaClient.getUserInfo(user.getExtUserId());
        return user2;
    }

    /**
     * 获取meila当前登录用户 根据meila的userId获取在vdlm库中对应的user
     * 
     * @param req
     * @param resp
     * @return
     */
    protected MeilaSimpleUser getCurLoginUserByMeila(HttpServletRequest req, HttpServletResponse resp) {
        MeilaSimpleUser curMeilaUser = meilaClient.getUserByHeaderAndCookie(req, resp);
        return curMeilaUser;
    }

    protected JsonResult buildSuccess(Object data) {
        return new JsonResult(0, "success", data);
    }

    /**
     * 获取模版并渲染
     * 
     * @param req
     * @param resp
     * @param templateName
     * @param modelMap
     * @return html
     */
    protected String getHtmlByTemplate(HttpServletRequest req, HttpServletResponse resp, String templateName, Map<String, Object> modelMap) {
        if (null != modelMap) {
            modelMap.put("cdnUtils", cdnUtils);
        }
        WebContext ctx = new WebContext(req, resp, req.getServletContext(), req.getLocale(), modelMap);
        String templateResult = thymeleafViewResolver.getTemplateEngine().process(templateName, ctx);
        return templateResult;
    }

    public long getTotalPages(long totalCount, int pageSize) {
        if (totalCount <= 0)
            return 0;

        long pageCount = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageCount++;
        }
        return pageCount;
    }
}
