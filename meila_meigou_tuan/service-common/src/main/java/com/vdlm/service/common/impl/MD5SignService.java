package com.vdlm.service.common.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vdlm.utils.MD5Util;

@Service("MD5SignService")
public class MD5SignService extends BaseSignServiceImpl {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Value("${partner.sign.md5.key}")
	private String key;
	
	@Value("${partner.sign.skip}")
	private boolean skip;

	private HashMap<String, String> keyMap;

	@Override
	public boolean signCheck(String partner, String sign, String queryString) {
		if (skip) {
			return true;
		}
		String sortQuery = sortQueryString(queryString);
		if (sortQuery == null) {
			log.info("有非法的query请求：" + queryString);
			return false;
		}
		String signKey = getKey(partner);
		if (signKey == null) {
			log.error("外部商户的签名配置不正确，商户名：" + partner);
			return false;
		}
		String signCheck = MD5Util.MD5Encode(sortQuery + signKey, "UTF-8");
		
		return signCheck.equals(sign);
//		if (signCheck.equals(sign)) {
//			return true;
//		} else {
//			return false;
//		}
	}

	@Override
	public String signQuery(String partner, String queryString) {
		String md5 = sign(partner, queryString);
		return queryString + "&sign_type=MD5&sign=" + md5;
	}

	@Override
	public String sign(String partner, String queryString) {
		String sortQuery = sortQueryString(queryString);
		if (sortQuery == null) {
			log.info("有非法的query请求：" + queryString);
		}
		String signKey = getKey(partner);
		if (signKey == null) {
			log.error("外部商户的签名配置不正确，商户名：" + partner);
		}
		return MD5Util.MD5Encode(sortQuery + signKey, "UTF-8");
	}

	protected String getKey(String partner) {
		if (keyMap == null && key != null) {
			keyMap = new HashMap<String, String>();
			String[] fields = key.split(";");
			for (String field : fields) {
				String[] keyValue = field.split(":");
				if (keyValue.length == 2) {
					keyMap.put(keyValue[0], keyValue[1]);
				}
			}
		}
		return keyMap != null ? keyMap.get(partner) : null;
	}

}
