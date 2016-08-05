package com.vdlm.service.utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

/***************************************************************************
 * <PRE>
 *
 *  className       : JSONUtils.java
 * 
 *  Description     : json工具包
 * 
 *  AUTHOR          : mike
 * 
 *  Date   		    : 2015-10-10
 *  
 * </PRE>
 ***************************************************************************/
public class JSONUtils {
	
	protected static Log logger = LogFactory.getLog(JSONUtils.class);
	
	private static final SerializeConfig config;
	
	static {
	    config = new SerializeConfig();
	    config.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
	    config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
	} 
	
	private static final SerializerFeature[] features = { 
		SerializerFeature.WriteMapNullValue, // 输出空置字段
        SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
        SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
        SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
        SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null，输出为""，而不是null
        SerializerFeature.DisableCircularReferenceDetect // 禁用循环引用检测 ($ref)
    };
   
	// 序列化为和JSON-LIB兼容的字符串
    public static String convertToJSON(Object object) {
        return JSON.toJSONString(object, config, features);
    }
    
    public static String convertToJSONArray(Object object){
        return JSONArray.toJSONString(object, config,features);
    }
}
