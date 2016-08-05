package com.vdlm.dal.type;

/**
 * 图片所属
 * 不同的图片类型放入不同的空间
 * @author huxaya
 *
 */
public enum FileBelong {
	PRODUCT,
	SHOP,
	STAT, //统计类
	RESOURCE,
	LOG,  //日志上传Crash
	OTHER //未归类
}
