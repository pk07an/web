package com.vdlm.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections4.map.LRUMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public final class CommonUtils {

    protected static final Map<String, NumberFormat> FORMAT_CACHE = new LRUMap<String, NumberFormat>(20, 100);
    private static final Logger LOGGER=LoggerFactory.getLogger(CommonUtils.class);

    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> asMap(Object... kvs) {
        if (kvs.length % 2 != 0)
            throw new IllegalArgumentException("如参需要双数个");
        Map<K, V> ret = new HashMap<K, V>(kvs.length / 2);
        for (int i = 0; i < kvs.length; i += 2) {
            ret.put((K) kvs[i], (V) kvs[i + 1]);
        }
        return ret;
    }

    /**
     * Provides a cached approach for creating NumberFormat instances. More performant than creating a new one each
     * time.
     * 
     * @param locale
     *            the Locale
     * @param currency
     *            the Currency
     * @return either a new NumberFormat instance, or one taken from the cache
     */
    public static NumberFormat getNumberFormatFromCache(Locale locale, Currency currency) {
        String key = locale.toString() + currency.getCurrencyCode();
        if (!FORMAT_CACHE.containsKey(key)) {
            NumberFormat format = NumberFormat.getCurrencyInstance(locale);
            format.setCurrency(currency);
            FORMAT_CACHE.put(key, format);
        }
        return FORMAT_CACHE.get(key);
    }

    public static Throwable getRootCause(Throwable t) {
        while (t.getCause() != null && t != t.getCause()) {
            t = t.getCause();
        }
        return t;
    }

    /**
     * 截取并保留小数点两位
     * 
     * @param val
     * @param defaultValue
     * @return
     */
    public static BigDecimal defautRoundDown(BigDecimal val, BigDecimal defaultValue) {
        if (val == null)
            return defaultValue;
        return val.setScale(2, BigDecimal.ROUND_DOWN);
    }

    /**
     * 
     * 功能描述：证件号码校验（不一定是身份证）
     * 
     * @param
     * @return
     */
    public static boolean isIdNumber(String idNumber) {
        if (idNumber != null && idNumber.length() <= 20 && idNumber.length() > 0) {
            String regextCode = "^[0-9]\\d{5}(?!d)$";
            Pattern p = Pattern.compile(regextCode);
            Matcher matcher = p.matcher(idNumber);
            return matcher.matches();
        } else {
            return false;
        }
    }

    /**
     * 功能描述：把以逗号分割的字符串转化为Set
     * 
     * @param skuId
     * @return
     */
    public static Set<String> strToSet(String skuId) {
        if (StringUtils.isBlank(skuId)) {
            return new HashSet<String>();
        }
        String[] skuIds = StringUtils.split(skuId, ",");
        Set<String> set = new HashSet<String>();
        for (String sku : skuIds) {
            set.add(sku);
        }
        return set;
    }

    /**
     * 功能描述：对象转obj，如果异常则返回空。
     * 
     * @param obj
     * @return
     */
    public static String objectToString(Object obj) {
        try {
            return JSONObject.toJSONString(obj);
        } catch (Exception e) {
            LOGGER.error("object to string fail Object{}", Objects.toString(obj));
            return "";
        }
    }
}
