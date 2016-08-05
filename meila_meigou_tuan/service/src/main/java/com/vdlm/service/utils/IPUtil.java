package com.vdlm.service.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *************************************************************** 
 * <p>
 * 
 * @DESCRIPTION : IP获取Util
 * @AUTHOR :toney.li
 * @DATE :2014-4-3 下午1:52:11
 *       </p>
 **************************************************************** 
 */
public final class IPUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(IPUtil.class);

    public static String getRequestIP(HttpServletRequest request) {
        int count = 0;
        String[] ipArray = new String[20];

        // 查直接连接的IP（可能是反向代理服务器的IP地址)
        if (request.getRemoteAddr() != null) {
            ipArray[count++] = request.getRemoteAddr();
        }

        // 查负载均衡服务器转发的IP
        String ip = request.getHeader("X-Forwarded-For");
        // String ip = request.getHeader("X-Real-IP");

        // //查正向代理（squid）服务器转发的IP
        // if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        // ip = request.getHeader("X-Cluster-Client-Ip");
        // }

        if (ip != null) {
            if (ip.indexOf(',') < 0) {
                // 直接IP地址
                ipArray[count++] = ip;
            } else {
                // 如果使用代理(或是多级)从代理中取出真实IP地址
                String[] ips = ip.split(",");
                for (String ipEntry : ips) {
                    if (ipEntry == null) {
                        continue;
                    }

                    ipEntry = ipEntry.trim();
                    if (ipEntry.isEmpty()) {
                        continue;
                    }

                    ipArray[count++] = ipEntry;

                    if (count > (ipArray.length - 1)) {
                        break;
                    }
                }
            }
        }

        // 得到最终的IP地址
        String finalIp = null;
        while (count >= 0) {
            ip = ipArray[count--];
            if (ip == null) {
                continue;
            }

            ip = ip.trim();
            if (ip.isEmpty()) {
                continue;
            }

            if (finalIp == null) {
                finalIp = ip;
            }

            if (isPrivateAddress(ip)) {
                continue;
            } else {
                finalIp = ip;
            }
        }

        if (finalIp != null) {
            String[] ips= StringUtils.split(finalIp, ",");
            return ips[0];
        } else {
            return "127.0.0.1";
        }
    }

    /**
     * 判断是否是内部IP地址
     * 
     * @param ip
     * @return
     */
    static public boolean isPrivateAddress(String ip) {
        if (ip.indexOf("127.0.0.1") >= 0) {
            return true;
        }
        if (ip.startsWith("10.")) {
            return true;
        }
        if (ip.startsWith("192.168.")) {
            return true;
        }
        if (ip.startsWith("172.")) {
            return isFrom16To31(ip);
        }

        return false;
    }

    /**
     * 172.16.x.x至172.31.x.x 是内网ip
     * 
     * @param ipString
     * @return
     */
    private static boolean isFrom16To31(String ipString) {

        boolean result = false;

        try {
            String[] ipArr = ipString.split("\\.");

            int sendPart = Integer.parseInt(ipArr[1]);

            if (sendPart >= 16 && sendPart <= 31) {
                result = true;
            }
        } catch (Exception e) {
            LOGGER.warn("Failed to parse IP String: {}", ipString, e);
        }

        return result;
    }

    /**
     * 
     * 功能描述：判断是否手机访问。
     * 
     * @param HttpServletRequest
     * @return
     */
    public static boolean JudgeIsMoblie(HttpServletRequest request) {
        boolean isMoblie = false;
        String[] mobileAgents = { "iphone", "android", "phone", "mobile", "wap", "netfront", "java", "opera mobi", "opera mini", "ucweb",
                "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod", "nokia", "samsung", "palmsource", "xda", "pieplus",
                "meizu", "midp", "cldc", "motorola", "foma", "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra",
                "coolpad", "webos", "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem", "wellcom",
                "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos", "pantech", "gionee", "portalmmm", "jig browser",
                "hiptop", "benq", "haier", "^lct", "320x320", "240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq",
                "bird", "blac", "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs", "kddi",
                "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi", "mot-", "moto", "mwbp", "nec-",
                "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port", "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-",
                "send", "seri", "sgh-", "shar", "sie-", "siem", "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-",
                "upg1", "upsi", "vk-v", "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-", "Googlebot-Mobile" };
        if (request.getHeader("User-Agent") != null) {
            for (String mobileAgent : mobileAgents) {
                if (request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >= 0) {
                    isMoblie = true;
                    break;
                }
            }
        }
        return isMoblie;
    }

}
