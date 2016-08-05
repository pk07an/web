package com.vdlm.service.utils;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class NameUtils {

    public static boolean isChinese(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        String regex = "[\u4E00-\u9FA5]{2,}";
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {
        System.out.println(NameUtils.isChinese(null));
        System.out.println(NameUtils.isChinese("安"));
        System.out.println(NameUtils.isChinese("安安"));
        System.out.println(NameUtils.isChinese("a"));

    }

}
