package com.vdlm.service.http;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author: chenxi
 */

@Component("httpClientTemplate")
public class HttpClientTemplate {
	
	private static int SUCCESS_CODE_200 = 200;
	private static int SUCCESS_CODE_201 = 201;
	private static int SUCCESS_CODE_202 = 202;
	
	private final static Logger LOG = LoggerFactory.getLogger(HttpClientTemplate.class);
	
	public HttpResult<Boolean> httpGet(String url, int successCode) throws Exception {
		return httpGet(url, new CodeBasedHttpResultCallback(successCode));
	}

	public <T> HttpResult<T> httpGet(String url, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doSimpleGet(url);
		return convertResponse(response, callback);
	}
	
	public <T> HttpResult<T> httpGet(String url, Header header, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doSimpleGet(url, header);
		return convertResponse(response, callback);
	}
	
	public <T> HttpResult<T> httpGet(String url, Header[] headers, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doSimpleGet(url, headers);
		return convertResponse(response, callback);
	}
	
	public HttpResult<Boolean> httpPost(String url, Map<String, String> params, int successCode) throws Exception {
		return httpPost(url, params, new CodeBasedHttpResultCallback(successCode));
	}
	
	public <T> HttpResult<T> httpPost(String url, Map<String, String> params, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doSimplePost(url, params);
		return convertResponse(response, callback);
	}
	
	public HttpResult<Boolean> httpPost(String url, List<NameValuePair> nvps, int successCode) throws Exception {
		return httpPost(url, nvps, new CodeBasedHttpResultCallback(successCode));
	}
	
	public <T> HttpResult<T> httpPost(String url, List<NameValuePair> nvps, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doSimplePost(url, nvps);
		return convertResponse(response, callback);
	}
	
	public <T> HttpResult<T> httpPlainPost(String url, String content, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doPlainPost(url, content);
		return convertResponse(response, callback);
	}
	
	public HttpResult<Boolean> httpJsonPost(String url, Object json, int successCode) throws Exception {
		return httpJsonPost(url, json, new CodeBasedHttpResultCallback(successCode));
	}
	
	public <T> HttpResult<T> httpJsonPost(String url, Object json, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doJsonPost(url, json);
		return convertResponse(response, callback);
	}
	
	public <T> HttpResult<T> httpJsonPost(String url, Object json, Header header, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doJsonPost(url, json, header);
		return convertResponse(response, callback);
	}
	
	public <T> HttpResult<T> httpJsonPost(String url, Object json, Header[] headers, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doJsonPost(url, json, headers);
		return convertResponse(response, callback);
	}
	
	public HttpResult<Boolean> httpFilePost(String url, String filePath, Header[] headers, int successCode) throws Exception {
		return httpFilePost(url, filePath, headers, new CodeBasedHttpResultCallback(successCode));
	}
	
	public <T> HttpResult<T> httpFilePost(String url, String filePath, Header[] headers, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doFilePost(url, filePath, headers);
		return convertResponse(response, callback);
	}
	
	public HttpResult<Boolean> httpMultipartPost(String url, String name, File file, int successCode) throws Exception {
		return httpMultipartPost(url, name, file, new CodeBasedHttpResultCallback(successCode));
	}
	
	public <T> HttpResult<T> httpMultipartPost(String url, String name, File file, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doMultipartPost(url, name, file);
		return convertResponse(response, callback);
	}
	
	public HttpResult<Boolean> httpMultipartPost(String url, File file, int successCode) throws Exception {
		return httpMultipartPost(url, file, new CodeBasedHttpResultCallback(successCode));
	}
	
	public <T> HttpResult<T> httpMultipartPost(String url, File file, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doMultipartPost(url, file);
		return convertResponse(response, callback);
	}
	
	public HttpResult<Boolean> httpMultipartPost(String url, String name, List<File> files, int successCode) throws Exception {
		return httpMultipartPost(url, name, files, new CodeBasedHttpResultCallback(successCode));
	}
	
	public <T> HttpResult<T> httpMultipartPost(String url, String name, List<File> files, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doMultipartPost(url, name, files);
		return convertResponse(response, callback);
	}
	
	public HttpResult<Boolean> httpMultipartPost(String url, List<File> files, int successCode) throws Exception {
		return httpMultipartPost(url, files, new CodeBasedHttpResultCallback(successCode));
	}
	
	public <T> HttpResult<T> httpMultipartPost(String url, List<File> files, HttpResultCallback<T> callback) throws Exception {
		HttpResponse response = doMultipartPost(url, files);
		return convertResponse(response, callback);
	}
	
	protected <T> HttpResult<T> convertResponse(HttpResponse response, HttpResultCallback<T> callback) throws Exception {
		HttpResult<T> httpResult = new HttpResult<T>();
		LOG.info("http response: " + response);
		if (callback.getSuccessCode() != response.getStatusLine().getStatusCode()) {
			httpResult.setException(callback.returnException(response.getStatusLine().getStatusCode()));
			return httpResult;
		}
		if (SUCCESS_CODE_200 != response.getStatusLine().getStatusCode() &&
				SUCCESS_CODE_201 != response.getStatusLine().getStatusCode() && 
				SUCCESS_CODE_202 != response.getStatusLine().getStatusCode())
			return new HttpResult<T>(true);
		HttpEntity entity = response.getEntity();
//		JSONObject json = new JSONObject(new JSONTokener(new InputStreamReader(entity.getContent(), HTTP.UTF_8)));
		String result = EntityUtils.toString(entity);
		EntityUtils.consume(entity);
		return new HttpResult<T>(true, callback.doConvert(result));
	}
	
	protected HttpResponse doSimpleGet(String url) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		LOG.info("http get:" + url);
		return client.execute(httpGet);
	}
	
	protected HttpResponse doSimpleGet(String url, Header header) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader(header);
		LOG.info("http get:" + url);
		return client.execute(httpGet);
	}
	
	protected HttpResponse doSimpleGet(String url, Header[] headers) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeaders(headers);
		LOG.info("http get:" + url);
		return client.execute(httpGet);
	}
	
	protected HttpResponse doSimplePost(String url, Map<String, String> params) throws Exception {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Iterator<String> it = params.keySet().iterator();
		String name, value;
		NameValuePair param;
		while (it.hasNext()) {
			name = it.next();
			value = params.get(name);
			param = new BasicNameValuePair(name, value);
			nvps.add(param);
		}
		return doSimplePost(url, nvps);
	}
	
	protected HttpResponse doSimplePost(String url, List<NameValuePair> nvps) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		LOG.info("http post:" + url);
		return client.execute(httpPost);
	}
	
	protected HttpResponse doPlainPost(String url, String content) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(content, ContentType.TEXT_PLAIN));
		LOG.info("http post:" + url);
		return client.execute(httpPost);
	}
	
	protected HttpResponse doJsonPost(String url, Object json) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(json.toString(), ContentType.APPLICATION_JSON));
		LOG.info("http post:" + url);
		return client.execute(httpPost);
	}
	
	protected HttpResponse doJsonPost(String url, Object json, Header header) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader(header);
		httpPost.setEntity(new StringEntity(json.toString(), ContentType.APPLICATION_JSON));
		LOG.info("http post:" + url);
		return client.execute(httpPost);
	}
	
	protected HttpResponse doJsonPost(String url, Object json, Header[] headers) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeaders(headers);
		httpPost.setEntity(new StringEntity(json.toString(), ContentType.APPLICATION_JSON));
		LOG.info("http post:" + url);
		return client.execute(httpPost);
	}
	
	protected HttpResponse doMultipartPost(String url, Map<String, String> params, String name, File file) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		MultipartEntity entity = new MultipartEntity();
		entity.addPart(name, new FileBody(file));
		Iterator<String> it = params.keySet().iterator();
		String key, value;
		while (it.hasNext()) {
			key = it.next();
			value = params.get(name);
			entity.addPart(key, StringBody.create(value));
		}
		httpPost.setEntity(entity);
		LOG.info("http post:" + url);
		return client.execute(httpPost);
	}
	
	protected HttpResponse doMultipartPost(String url, Map<String, String> params, File file) throws Exception {
		return doMultipartPost(url, params, "", file);
	}
	
	protected HttpResponse doMultipartPost(String url, String name, File file) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		MultipartEntity entity = new MultipartEntity();
		entity.addPart(name, new FileBody(file));
		httpPost.setEntity(entity);
		LOG.info("http post:" + url);
		return client.execute(httpPost);
	}
	
	protected HttpResponse doMultipartPost(String url, File file) throws Exception {
		return doMultipartPost(url, "", file);
	}
	
	protected HttpResponse doMultipartPost(String url, String name, List<File> files) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		MultipartEntity entity = new MultipartEntity();
		for (File file : files) {
			entity.addPart(name, new FileBody(file));	
		}
		httpPost.setEntity(entity);
		LOG.info("http post:" + url);
		return client.execute(httpPost);
	}
	
	protected HttpResponse doMultipartPost(String url, List<File> files) throws Exception {
		return doMultipartPost(url, "", files);
	}
	
	protected HttpResponse doFilePost(String url, String filePath, Header[] headers) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeaders(headers);
		InputStreamEntity entity = new InputStreamEntity(new FileInputStream(filePath), new File(filePath).length());
		httpPost.setEntity(entity);
		LOG.info("http post:" + url);
		return client.execute(httpPost);
	}
}
