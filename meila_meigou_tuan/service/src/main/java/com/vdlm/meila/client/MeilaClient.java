package com.vdlm.meila.client;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.alibaba.fastjson.JSONObject;
import com.vdlm.service.common.BaseServiceImpl;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;
import com.vdlm.service.utils.MeiLaRedisUtils;
import com.vdlm.service.utils.MeiLaRestTemplate;
import com.vdlm.utils.RedisKeyConstant;

@Service("meilaClient")
public class MeilaClient extends BaseServiceImpl {

    private static Logger LOG = LoggerFactory.getLogger(MeilaClient.class);

    // 这个地址是app接口权限校验，下单，支付成功通知接口等
    @Value("${meila.check.req.host}")
    private String checkReqHost;

    private String checkReqUrl = "/ouer/check_req";

    private String getUserUrl = "/ouer/user_info/";
    private String getUsersUrl = "/ouer/users_info/";

    @Autowired
    private MeiLaRestTemplate meiLaRestTemplate;

    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    private static String charset = "utf-8";
    private final RedisSerializer<String> serializerStr = new StringRedisSerializer();

    // 对社区数据上报接口，详情页，购物流程
    private static final String onPurchaseActionUrl = "/ouer/log_data";

    private static final String notifySNSOrder = "/ouer/on_new_order_v2";

    // 微信接口
    private static final String WEIXIN_API_PATH = "/ouer/weixin_share_signature";
    //// 这个只是用于web的获取请求用户信息
    @Value("${meila.client.host2}")
    private String meilaClientHost2;

    @Value("${meila.client.get_user_by_header}")
    private String getUserByHeader;

    private String onAddrAction = "/ouer/on_addr_action?action=%s&user_id=%s&source=%s&count=%s&addr_id=%s";

    private JSONObject parseMeilaResult(JSONObject json) {
        if (json.getString("ret").equals("0")) {
            return json.getJSONObject("data");
        } else if (json.getString("ret").equals("-1")) {
            throw new BizException(GlobalErrorCode.MEILA_CHECK_REQ_ERROR, json.getString("msg"));
        } else if (json.getString("ret").equals("1")) {
            throw new BizException(GlobalErrorCode.MEILA_CHECK_REQ_ERROR, json.getString("msg"));
        } else {
            LOG.info("解析用户信息失败");
            throw new BizException(GlobalErrorCode.UNKNOWN, json.getString("msg"));
        }
    }

    public MeilaSimpleUser userVerify(HttpServletRequest request, HttpServletResponse response) {
        String responseStr = checkGetReq(request, checkReqHost, checkReqUrl, request.getServletPath());
        LOG.debug("checkreq responseStr:" + responseStr);
        JSONObject json = JSONObject.parseObject(responseStr);
        JSONObject data = parseMeilaResult(json);
        MeilaSimpleUser mUser = JSONObject.parseObject(data.getString("user"), MeilaSimpleUser.class);
        return mUser;
    }

    public MeilaUser getUserInfo(String id) {
        String gateway = checkReqHost + getUserUrl + id;
        String res = meiLaRestTemplate.getForObject(gateway, String.class);
        JSONObject json = JSONObject.parseObject(res);
        JSONObject data = parseMeilaResult(json);
        MeilaUser user = JSONObject.parseObject(data.getString("user"), MeilaUser.class);
        if (user != null) {
            user.setId(id);
        }
        return user;
    }

    private String checkGetReq(HttpServletRequest request, String checkReqHost, String checkReqUrl, String servletPath) {
        String path = checkReqUrl + servletPath;
        String gateway = checkReqHost + path;
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setConnectionTimeout(50000);
        client.getHttpConnectionManager().getParams().setSoTimeout(50000);
        // cookie
        HttpState state = new HttpState();
        client.setState(state);

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie co = cookies[i];
                org.apache.commons.httpclient.Cookie cookie = new org.apache.commons.httpclient.Cookie(co.getDomain(), co.getName(), co.getValue(),
                    co.getPath(), co.getMaxAge(), co.getSecure());
                state.addCookie(cookie);
            }
        }

        // header
        Header header = new Header();
        header.setName("Mud");
        header.setValue(request.getHeader("Mud"));
        GetMethod getMethod = null;
        PostMethod postMethod = null;
        String strResponse = "";
        try {
            if (request.getMethod().equals("GET")) {
                getMethod = new GetMethod(checkReqHost);
                getMethod.getParams().setContentCharset(charset);
                getMethod.setRequestHeader(header);

                getMethod.setPath(path);
                getMethod.setQueryString(HttpClientUtils.getQueryString4Get(request));
                int statusCode = client.executeMethod(getMethod);
                LOG.debug("execute get method end, return status code :" + statusCode);
                if (statusCode != HttpStatus.SC_OK) {
                    throw new Exception("请求美啦校验逻辑接口失败，URL =" + gateway);
                }
                strResponse = getMethod.getResponseBodyAsString();
            } else if (request.getMethod().equals("POST")) {
                postMethod = new PostMethod(checkReqHost);
                postMethod.getParams().setContentCharset(charset);
                postMethod.setRequestHeader(header);
                String queryString = request.getQueryString();
                Set<String> urlParamSet = new HashSet<String>();
                if (StringUtils.isNoneBlank(queryString)) {
                    path = path + "?" + queryString;
                    String[] urlParamStr = queryString.split("&");
                    if (urlParamStr != null) {
                        for (int i = 0; i < urlParamStr.length; i++) {
                            urlParamSet.add(urlParamStr[i].substring(0, urlParamStr[i].indexOf("=")));
                        }
                    }
                }
                postMethod.setPath(path);
                NameValuePair[] pairs = HttpClientUtils.getBody4Post(request, urlParamSet);
                postMethod.setRequestBody(pairs);

                int statusCode = client.executeMethod(postMethod);
                LOG.debug("execute post method end, return status code :" + statusCode);
                if (statusCode != HttpStatus.SC_OK) {
                    throw new Exception("请求美啦校验逻辑接口失败，URL =" + gateway);
                }
                strResponse = postMethod.getResponseBodyAsString();
            } else {
                throw new BizException(GlobalErrorCode.NOT_FOUND, "暂不支持该方法:" + request.getMethod());
            }
        } catch (Exception e) {
            LOG.error("验证用户信息失败 gateway=[" + gateway + "]", e);
            throw new BizException(GlobalErrorCode.UNKNOWN, e);
        } finally {
            if (getMethod != null) {
                getMethod.releaseConnection();
            }
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }
        return strResponse;
    }

    public String doPostMethod(String host, String path, Map<String, String> paramMap) {
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
        client.getHttpConnectionManager().getParams().setSoTimeout(3000);
        // cookie
        HttpState state = new HttpState();
        client.setState(state);
        PostMethod postMethod = null;
        try {
            postMethod = new PostMethod(host);
            postMethod.setPath(path);
            postMethod.getParams().setContentCharset(charset);
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            String name = null;
            String value = null;
            Iterator<String> it = paramMap.keySet().iterator();
            while (it.hasNext()) {
                name = it.next();
                value = paramMap.get(name);
                NameValuePair pair = new NameValuePair(name, value);
                list.add(pair);
            }
            NameValuePair[] pairs = list.toArray(new NameValuePair[0]);
            postMethod.setRequestBody(pairs);
            int statusCode = client.executeMethod(postMethod);
            if (statusCode != HttpStatus.SC_OK) {
                LOG.error("请求美啦接口失败，URL ={} statusCode{}", host, statusCode);
                throw new Exception("请求美啦接口失败，URL =" + host);
            }
            return postMethod.getResponseBodyAsString();
        } catch (Exception e) {
            LOG.error("请求美啦校接口失败，URL =" + host + "，path=" + path, e);
            throw new BizException(GlobalErrorCode.UNKNOWN, e);
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }
    }

    public MeilaSimpleUser getUserByHeader(HttpServletRequest request, HttpServletResponse response) {
        String responseStr = checkGetReq(request, meilaClientHost2, getUserByHeader, "");
        LOG.debug("checkreq responseStr:" + responseStr);
        JSONObject json = JSONObject.parseObject(responseStr);
        JSONObject data = parseMeilaResult(json);
        MeilaSimpleUser mUser = JSONObject.parseObject(data.getString("user"), MeilaSimpleUser.class);
        return mUser;
    }

    /**
     * 功能描述：该接口为新的购物流程使用，不提供给原生APP使用
     * 
     * @param request
     * @param response
     * @return
     */
    public MeilaSimpleUser getUserByHeaderAndCookie(HttpServletRequest request, HttpServletResponse response) {
        String responseStr = checkGetReqHeaderAndCookie(request, meilaClientHost2, getUserByHeader, "");
        LOG.debug("checkreq responseStr:" + responseStr);
        JSONObject json = JSONObject.parseObject(responseStr);
        JSONObject data = parseMeilaResult(json);
        MeilaSimpleUser mUser = JSONObject.parseObject(data.getString("user"), MeilaSimpleUser.class);

        boolean isApp = false;
        String ua = request.getHeader("user-agent");
        if (StringUtils.isNotBlank(ua)) {
            ua = ua.toLowerCase();
            if (ua.indexOf("meila") != -1) {
                isApp = true;
            }
        }

        String headerMud = request.getHeader("Mud");
        if (StringUtils.isNotEmpty(headerMud)) {
            Cookie cookieMud = new Cookie("Mud", request.getHeader("Mud"));
            cookieMud.setDomain(".meilapp.com");
            cookieMud.setPath("/");
            response.addCookie(cookieMud);

            if (null != mUser) {
                LOG.warn("header中mud非空，写入cookie-mud: " + cookieMud.getValue() + "  ,isApp: " + isApp + " ,mUser: " + mUser.getSlug() + "  "
                        + mUser.getNickName());
            } else {
                LOG.warn("header中mud非空，写入cookie-mud: " + cookieMud.getValue() + "  ,isApp: " + isApp + " ,mUser:  null");
            }
        } else {
            if (null != mUser) {
                LOG.warn("header中mud为空， isApp: " + isApp + " ,mUser: " + mUser.getSlug() + "  " + mUser.getNickName());
            } else {
                LOG.warn("header中mud为空， isApp: " + isApp + " ,mUser:  null");
            }
        }

        return mUser;
    }

    /**
     * 功能描述：需要Cookie和mud都方header中
     * 
     * @param request
     * @param checkReqHost
     * @param checkReqUrl
     * @param servletPath
     * @return
     */
    private String checkGetReqHeaderAndCookie(HttpServletRequest request, String checkReqHost, String checkReqUrl, String servletPath) {
        String path = checkReqUrl + servletPath;
        String gateway = checkReqHost + path;
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
        client.getHttpConnectionManager().getParams().setSoTimeout(5000);
        GetMethod getMethod = null;
        String strResponse = "";
        try {
            getMethod = new GetMethod(checkReqHost);
            getMethod.getParams().setContentCharset(charset);
            // set header
            String headerMud = "";
            String headerCookies = "";
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                if ("cookie".equalsIgnoreCase(name) || "mud".equalsIgnoreCase(name)) {
                    Header header = new Header();
                    header.setName(name);
                    header.setValue(request.getHeader(name));
                    getMethod.addRequestHeader(header);
                    if ("mud".equalsIgnoreCase(name)) {
                        headerMud = request.getHeader(name);
                    } else if ("cookie".equalsIgnoreCase(name)) {
                        headerCookies = request.getHeader(name);
                    }
                }
            }
            // put cookie header end
            getMethod.setPath(path);
            int statusCode = client.executeMethod(getMethod);
            LOG.debug("execute get method end, return status code :" + statusCode);
            if (statusCode != HttpStatus.SC_OK) {
                throw new Exception("请求美啦校验逻辑接口失败，URL =" + gateway);
            }
            strResponse = getMethod.getResponseBodyAsString();

            LOG.warn("登录验证: \n\t headerMud: " + headerMud + " \n\t headerCookie: " + headerCookies + " \n\t statusCode: " + statusCode
                    + " \n\t response: " + strResponse);

        } catch (Exception e) {
            LOG.error("验证用户信息失败  gateway=[" + gateway + "]", e);
            throw new BizException(GlobalErrorCode.UNKNOWN, e);
        } finally {
            if (getMethod != null) {
                getMethod.releaseConnection();
            }
        }
        return strResponse;
    }

    /**
     * 
     * 功能描述：微信分享接口
     * 
     * @param url
     * @return
     * @throws Exception String
     *
     */
    public String getWeiXinShareSign(String url) throws Exception {

        String result = "";
        try {
            Map<String, String> paramMap = new HashMap<String, String>();
            paramMap.put("current_url", url);

            result = this.doPostMethod(checkReqHost, WEIXIN_API_PATH, paramMap);
        } catch (Exception ex) {
            log.error("获取微信分享接口签名失败：" + checkReqHost + WEIXIN_API_PATH, ex);
        }

        return result;
    }

    /**
     * 
     *
     * 功能描述：批量从社区获取用户信息
     * 
     * @param userIds
     * @return List<MeilaUser>
     *
     */
    @Deprecated
    public List<MeilaUser> getUserInfoList(String userIds) {
        String gateway = checkReqHost + getUsersUrl + "?user_id=" + userIds;
        String res = meiLaRestTemplate.getForObject(gateway, String.class);
        JSONObject json = JSONObject.parseObject(res);
        JSONObject data = parseMeilaResult(json);

        JSONObject jsonObject = JSONObject.parseObject(data.getString("users"));

        List<MeilaUser> userList = new ArrayList<MeilaUser>();
        for (Entry<String, Object> entry : jsonObject.entrySet()) {
            String userId = entry.getKey();
            JSONObject userJson = (JSONObject) entry.getValue();
            MeilaUser meiLaUser = JSONObject.parseObject(userJson.toJSONString(), MeilaUser.class);
            meiLaUser.setId(userId);
            userList.add(meiLaUser);
        }
        return userList;
    }

    /**
     * 批量从社区获取用户信息 先从缓存取
     * 
     * @param userIds
     * @return
     */
    public List<MeilaUser> getUserInfoListFromCache(final Set<String> userIds) {
        return redisTemplate.execute(new RedisCallback<List<MeilaUser>>() {
            @Override
            public List<MeilaUser> doInRedis(RedisConnection conn) throws DataAccessException {
                List<MeilaUser> userList = new ArrayList<MeilaUser>(userIds.size());
                RedisSerializer<MeilaUser> serializer = new Jackson2JsonRedisSerializer<MeilaUser>(MeilaUser.class);

                // 从redis取
                List<byte[]> cacheList = conn.mGet(MeiLaRedisUtils.serializeMulti(userIds, RedisKeyConstant.CACHE_TUAN_USERS));
                if (CollectionUtils.isNotEmpty(cacheList)) {
                    for (byte[] v : cacheList) {
                        MeilaUser user = serializer.deserialize(v);
                        if (user != null) {
                            userList.add(user);
                            userIds.remove(user.getId());
                        }
                    }
                }

                // 从社区取
                if (CollectionUtils.isNotEmpty(userIds)) {
                    try {
                        String gateway = checkReqHost + getUsersUrl + "?user_id=" + StringUtils.join(userIds, ",");
                        String res = meiLaRestTemplate.getForObject(gateway, String.class);
                        JSONObject json = JSONObject.parseObject(res);
                        JSONObject data = parseMeilaResult(json);

                        JSONObject jsonObject = JSONObject.parseObject(data.getString("users"));
                        Map<byte[], byte[]> hashes = new HashMap<byte[], byte[]>(jsonObject.size());

                        for (Entry<String, Object> entry : jsonObject.entrySet()) {
                            String userId = entry.getKey();
                            JSONObject userJson = (JSONObject) entry.getValue();
                            MeilaUser meiLaUser = JSONObject.parseObject(userJson.toJSONString(), MeilaUser.class);
                            meiLaUser.setId(userId);
                            userList.add(meiLaUser);

                            hashes.put(serializerStr.serialize(RedisKeyConstant.CACHE_TUAN_USERS + userId), serializer.serialize(meiLaUser));
                        }

                        // 写入缓存
                        if (hashes.size() > 0) {
                            conn.mSet(hashes);
                            for (byte[] k : hashes.keySet()) {
                                conn.expire(k, RedisKeyConstant.CACHE_TUAN_USERS_TIME);
                            }
                        }

                    } catch (Exception ex) {
                        for (String userId : userIds) {
                            MeilaUser meiLaUser = new MeilaUser();
                            meiLaUser.setId(userId);
                            meiLaUser.setNickname("");
                            meiLaUser.setAvatar("");
                            userList.add(meiLaUser);
                        }

                    }
                }
                return userList;
            }
        });
    }

    /**
     * 详情页，购物流程各环节上报社区数据
     * 
     * @return
     */
    public Boolean doOnPurchaseToMeila(OnPurchaseModel model) {
        String res = null;
        try {
            if (null == model) {
                return false;
            }

            Map<String, String> paramMap = new HashMap<String, String>();
            paramMap.put("log_data", JSONObject.toJSONString(model));

            LOG.debug("向社区上报购物流程访问数据: url=[" + checkReqHost+ onPurchaseActionUrl+ "]"+"param=["+paramMap+"]");
            res = this.doPostMethod(checkReqHost, onPurchaseActionUrl, paramMap);
            LOG.debug("向社区上报购物流程访问数据: " + res);

            return true;
        } catch (Exception e) {
            LOG.error("向社区上报购物流程访问数据: url=[" +  checkReqHost+ onPurchaseActionUrl + "], res=[" + res + "]", e);
            return false;
        }
    }

    /**
     * 功能描述：订单提交后需要通知社区
     * 
     * @param sourceMap
     * @throws IOException
     * @throws RestClientException
     */
    public boolean notifySNSOrder(String order_data) throws Exception {
        Map<String, String> orderMap = new HashMap<String, String>();
        orderMap.put("order_data", order_data);
        String res = this.doPostMethod(checkReqHost, notifySNSOrder, orderMap);
        LOG.info(" 订单提交成功通知社区 notifySNSOrder {}", new Object[] { res });
        JSONObject json = JSONObject.parseObject(res);
        if (json.getInteger("ret") == 0) {
            return true;
        }
        return false;
    }

    /**
     *
     * 功能描述：向社区上报地址的操作的数据
     * 
     * @param model
     * @return boolean
     * @Exception :
     */
    public boolean doAdderssActionToMeila(ReportAddrActModel model) {
        String gateway = null;
        String res = null;
        try {
            if (null == model) {
                return false;
            }
            String action = Objects.toString(model.getAction(), "");
            String userId = Objects.toString(model.getUserId(), "");
            String source = Objects.toString(model.getSource(), "");
            String count = Objects.toString(model.getCount(), "");
            String addressId = Objects.toString(model.getAddrId(), "");

            gateway = String.format(checkReqHost + onAddrAction, action, userId, source, count, addressId);

            LOG.debug("向社区上报地址操作访问数据: gateway=[" + gateway + "]");
            res = meiLaRestTemplate.postForObject(gateway, null, String.class);
            LOG.debug("向社区上报地址操作访问数据: " + res);

            return true;
        } catch (Exception e) {
            LOG.error("向社区上报地址操作访问数据: gateway=[" + gateway + "], res=[" + res + "]", e);
            return false;
        }
    }
}
