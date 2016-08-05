package com.vdlm.utils;

public interface ResourceResolver {
	/**
	 * 给定资源key，转换为相应的url
	 * 
	 * @param resKey
	 * @return
	 */
	String resolveUrl(String resKey);
}
