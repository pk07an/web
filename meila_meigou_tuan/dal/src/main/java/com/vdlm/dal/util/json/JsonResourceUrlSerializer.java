package com.vdlm.dal.util.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vdlm.dal.util.SpringContextUtil;
import com.vdlm.utils.ResourceResolver;

public class JsonResourceUrlSerializer extends JsonSerializer<String> {

//	private final static ThreadLocal<Map<String, String>> imageSize = new ThreadLocal<Map<String, String>>();
	final private String qiniuExtFmt = "";///@w/$w$@/@h/$h$@
	
	@Override
	public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		ResourceResolver resourceFacade = (ResourceResolver) SpringContextUtil.getBean("resourceFacade");
		String url = resourceFacade.resolveUrl(value);
		jgen.writeString(url + qiniuExtFmt);
	}
}
