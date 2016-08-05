package com.vdlm.biz.res;

import com.vdlm.biz.qiniu.Qiniu;
import com.vdlm.utils.ResourceResolver;

/**
 * 静态资源门面. 分为线下环境和线上环境，2套实现。<br/>
 * 资源分为2种：系统自带的静态文件（key有固定前缀）；用户上传的静态文件。
 * 
 * @author jamesp
 */
public interface ResourceFacade extends ResourceResolver {
    /**
     * 系统自带的静态资源的key的前缀
     */
    static final String EXT_RES_PREFIX = "http://";

	/**
	 * 系统自带的静态资源的key的前缀
	 */
    static final String RES_PREFIX_SYS = "/_resource";

	/**
	 * 用户上传的文件资源的url前缀
	 */
	static final String RES_PREFIX_UP_FILE = "/_f";
	
	/**
	 * 本地数据文件存储标识（第一版本）
	 */
	static final String FILE_STORE_KEY_V1 = "md_";
	
	/**
	 * 七牛文件存储标识(第二版本)
	 */
	static final String FILE_STORE_KEY_V2 = "qn" + Qiniu.SPLIT_SYMBOL;
	
	
	/**
	 * 图片尺寸定义样式，在引用图片时，使用分隔符和样式名
	 * 分隔符使用方法： http://绑定域名/文件名称 + 分隔符 + 处理样式名
	 * 分隔符为 中划线 “|”  如//http://xayas.qiniudn.com/FhBTwagylk6IydUY968lc-mu2_YF$IMAGE|S1
	 * 
	 * 可以再加后缀x加上倍数，如：IMAGE_S025x2，则由四分之一变为二分之一
	 */
	//指定宽度缩放, 满屏
	static final String IMAGE_S1 = "s1";
	
	//指定宽度缩放, 二分之一屏
	static final String IMAGE_S05 = "s05";
	
	//指定宽度缩放, 三分之一屏
	static final String IMAGE_S03 = "s03";
	
	//指定宽度缩放, 四分之一屏
	static final String IMAGE_S025 = "s025";
	/**
	 * 给定资源key，转换为相应的url
	 * 
	 * @param resKey
	 * @return
	 */
	String resolveUrl(String resKey);
	
}
