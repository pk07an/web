package com.vdlm.service.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <pre>
 *     &#64;类名： MeiLaRedisUtils.java 
 *     &#64;描述：辅助redis的一些工具
 *     &#64;作者： Toney
 *     &#64;修改日期： 2015年8月11日
 * </pre>
 */
public class MeiLaRedisUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeiLaRedisUtils.class);
    
    private static final RedisSerializer<String> serializerStr = new StringRedisSerializer();
    /*
     * 默认过去时间2小时
     */
    private static final int DEFAULT_EXPIRE_SECONDS = 7200;

    /**
     * 功能描述：if createDate is null then return true;else compareTo now
     * 
     * @param createDate
     * @return
     */
    public static Boolean isDefaultExpire(Date createDate) {
        return MeiLaRedisUtils.isExpire(createDate, DEFAULT_EXPIRE_SECONDS);
    }

    /**
     * 功能描述：if createDate is null then return true;else createDate add seconds compareTo now
     * 
     * @param createDate
     * @param expireSeconds
     *            seconds
     * @return
     */
    public static Boolean isExpire(Date createDate, int expireSeconds) {
        if (createDate == null) {
            return true;
        }
        Date expireDate = DateUtils.addSeconds(createDate, expireSeconds);
        Date now = new Date();
        if (expireDate.compareTo(now) < 0) {
            return true;
        }
        return false;
    }

    /**
     * 功能描述：对象的序列化
     * @param obj
     * @return
     */
    public static byte[] serializeToByteArray(Object obj) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(baos);
            out.writeObject(obj);
            return baos.toByteArray();
        } catch (NotSerializableException e) {
            LOGGER.error("序列化对象失败", e);
        } catch (IOException e) {
            LOGGER.error("IOException writing to a byte array!", e);
        }
        return null;
    }

    /**
     * 功能描述：对象的反序列化
     * @param bytes
     * @return
     */
    public static Object deserializeFromByteArray(byte[] bytes) {
        try {
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
            return in.readObject();
        } catch (IOException e) {
            LOGGER.error("bytes 反序列化失败 IOException", e);
        } catch (ClassNotFoundException e) {
            LOGGER.error("bytes 反序列化失败 ClassNotFoundException", e);
        }
        return null;
    }
    
    public static byte[][] serializeMulti(Collection<String> fields) {
		return serializeMulti(fields, serializerStr);
	}
	
	public static <T> byte[][] serializeMulti(Collection<T> fields, RedisSerializer<T> serializer) {
		if (fields == null) {
			return new byte[0][];
		}
		
		byte[][] ret = new byte[fields.size()][];
		int i = 0;
		for(T t : fields){
			ret[i] = serializer.serialize(t);
			i++;
		}
		return ret;
	}
	
	public static byte[][] serializeMulti(Collection<String> fields, String prefix) {
		if (fields == null) {
			return new byte[0][];
		}
		
		byte[][] ret = new byte[fields.size()][];
		int i = 0;
		for(String t : fields){
			ret[i] = serializerStr.serialize(prefix + t);
			i++;
		}
		return ret;
	}

}
