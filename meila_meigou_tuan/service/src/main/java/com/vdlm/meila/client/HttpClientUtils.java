package com.vdlm.meila.client;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.NameValuePair;

public class HttpClientUtils {

	/**
     * 直接接受request
     * 注：request中提供的getQueryString方法只对Get方法才能生效，
     * 在我们不知道方法的情况下最好重写getQueryString
     * @param request
     * @return
     */
    public static String getQueryString4Get(HttpServletRequest request) {
        StringBuffer sbuf = new StringBuffer("");
        String name = null;
		for(Enumeration<String> names = request.getParameterNames(); names.hasMoreElements(); )
	    {
	        name = names.nextElement();
	        if(sbuf.toString().length() > 0)
	        	sbuf.append("&");
	        sbuf.append(name);
	        sbuf.append("=");
	        sbuf.append(request.getParameter(name));
	    }

        return sbuf.toString();
    }
    
    public static NameValuePair[] getBody4Post(HttpServletRequest request, Set<String> urlParamSet){
    	List<NameValuePair> list = new ArrayList<NameValuePair>();
    	String name = null;
    	for(Enumeration<String> names = request.getParameterNames(); names.hasMoreElements(); ){
    		name = names.nextElement();
    		if(urlParamSet.contains(name)){
    			continue;
    		}
    		String[] values = request.getParameterValues(name);
    		if(values != null){
    			for (int i = 0; i < values.length; i++) {
    				NameValuePair pair = new NameValuePair(name, values[i]);
    	    		list.add(pair);
				}
    		}
    	}
    	return list.toArray(new NameValuePair[0]);
    }
}
