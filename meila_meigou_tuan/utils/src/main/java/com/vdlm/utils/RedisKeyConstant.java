package com.vdlm.utils;

/**
 * redis key常量
 * @author haoguowei
 *
 */
public class RedisKeyConstant {
	
	private RedisKeyConstant(){
		
	}
	
	private static final int _1_MIN = 60; //一分钟
	private static final int _1_HOUR = _1_MIN * 60; //一小时
	
	//redis key：美啦web拼团项目用户id
	public static final String CACHE_TUAN_USERS = "cache_tuan_users_";
	public static final long CACHE_TUAN_USERS_TIME = _1_MIN * 30; //30分钟
	
	
	//redis key：商品图文详情段落
	public static final String CACHE_TUAN_DESC_PRODUCTID = "cache_tuan_desc_productId_";
	public static final int CACHE_TUAN_DESC_PRODUCTID_TIME = _1_HOUR * 5; //5个小时
	
	
}
