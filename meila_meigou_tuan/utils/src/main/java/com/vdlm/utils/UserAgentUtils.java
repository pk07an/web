package com.vdlm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgentUtils {

	public String getDeviceName(String userAgent) {
//		String userAgent = request.getHeader("User-Agent");
		Pattern pattern = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?(Build)?/");
		Matcher matcher = pattern.matcher(userAgent);
		String model = null;
		if (matcher.find()) {
			model = matcher.group(1).trim();
		} else {
			model = "未识别";
		}
		return model;
	}
}
