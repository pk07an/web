package com.vdlm.utils.http;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

/**
 * @author Wayne.Wang<5waynewang@gmail.com>
 * @since 8:05:04 PM Jul 28, 2014
 */
public class PoolingHttpClients {
	private static final Log log = LogFactory.getLog(PoolingHttpClients.class);

	private final static PoolingClientConnectionManager cm;

	private final static DefaultHttpClient httpClient;

	private final static ResponseHandler<HttpInvokeResult> responseHandler = new DefaultResponseHandler();

	static {
		cm = new PoolingClientConnectionManager();
		cm.setMaxTotal(HttpClientConfig.HTTP_MAX_TOTAL_CONN);
		cm.setDefaultMaxPerRoute(HttpClientConfig.HTTP_MAX_CONN_PER_ROUTE);
		httpClient = new DefaultHttpClient(cm);
		// 增加 keep alive 策略
		httpClient.setKeepAliveStrategy(new ConnectionKeepAliveStrategy() {
			@Override
			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				return HttpClientConfig.HTTP_KEEPIDLE_DURATION;
			}
		});

		final HttpParams httpParams = httpClient.getParams();
		HttpProtocolParams.setContentCharset(httpParams, HttpClientConfig.HTTP_CHARSET);
		HttpProtocolParams.setHttpElementCharset(httpParams, HttpClientConfig.HTTP_CHARSET);
		HttpConnectionParams.setSoTimeout(httpParams, HttpClientConfig.HTTP_SO_TIMEOUT);
		HttpConnectionParams.setConnectionTimeout(httpParams, HttpClientConfig.HTTP_CONN_TIMEOUT);
		HttpConnectionParams.setSoKeepalive(httpParams, HttpClientConfig.HTTP_KEEPALIVE);
		HttpConnectionParams.setStaleCheckingEnabled(httpParams, HttpClientConfig.HTTP_STALE_CHECK);
		HttpConnectionParams.setTcpNoDelay(httpParams, true);
	}

	public static HttpInvokeResult get(final String url) {
		return get(url, 0);
	}

	public static HttpInvokeResult get(final String url, final long timeout) {
		return get(url, timeout, null);
	}

	public static HttpInvokeResult get(final String url, final long timeout, final List<Header> headers) {
		if (log.isDebugEnabled()) {
			log.debug("get url:" + url);
		}
		final HttpGet httpGet = new HttpGet(url);
		addHeaders(headers, httpGet);
		return invoke(httpGet, timeout);
	}

	private static void addHeaders(final List<Header> headers, final HttpRequestBase request) {
		if (headers != null) {
			for (final Header header : headers) {
				if (header == null) {
					continue;
				}
				request.addHeader(header);
			}
		}
	}

	public static HttpInvokeResult post(final String url, final Map<String, String> params) {

		return post(url, params, 0);
	}

	public static HttpInvokeResult post(final String url, final Map<String, String> params, final long timeout) {
		final HttpPost httpPost = new HttpPost(url);

		final List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (params != null) {
			for (final Map.Entry<String, String> entry : params.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}

		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		}
		catch (final UnsupportedEncodingException e) {
			log.error(e);
			//ignore
		}

		return invoke(httpPost, timeout);
	}

	public static HttpInvokeResult post(String url, byte[] body) {
		return post(url, body, 0);
	}

	public static HttpInvokeResult post(String url, byte[] body, long timeout) {
		return post(url, body, 0, body.length, timeout);
	}

	public static HttpInvokeResult post(String url, byte[] body, int off, int len) {

		return post(url, body, off, len, 0);
	}

	public static HttpInvokeResult post(String url, byte[] body, int off, int len, long timeout) {
		final HttpPost httpPost = new HttpPost(url);

		httpPost.setEntity(new ByteArrayEntity(body, off, len, ContentType.APPLICATION_JSON));

		return invoke(httpPost, timeout);
	}

	static HttpInvokeResult invoke(final HttpRequestBase request, final long timeout) {
		final String url = request.getURI().toString();
		if (log.isDebugEnabled()) {
			log.debug("invoke url:" + url);
		}

		HttpInvokeResult result;

		if (timeout > 0) {
			request.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, (int) timeout);
			HttpConnectionParams.setConnectionTimeout(request.getParams(), (int) timeout);
		}

		try {
			result = httpClient.execute(request, responseHandler);
			if (result.getException() != null) {
				request.abort();
				log.error("请求失败,statusCode=" + result.getStatusCode() + ",url=" + url + ","
						+ result.getException().getMessage());
			}
			result.setUrl(request.getURI().toString());
			request.releaseConnection();
			return result;
		}
		catch (final Throwable e) {
			request.abort();
			log.error("请求失败,url=" + url + "," + e.getMessage());
			result = new HttpInvokeResult();
			result.setUrl(url);
			result.setException(e);
			result.setReason(e.getMessage());
			return result;
		}
		finally {
			request.reset();
		}
	}

}
