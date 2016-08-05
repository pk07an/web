package com.vdlm.utils.http;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Wayne.Wang<5waynewang@gmail.com>
 * @since 8:05:15 PM Jul 28, 2014
 */
public class HttpClientConfig {

	public static final String HTTP_CHARSET = StringUtils.defaultIfBlank(
			System.getProperty("ouer.client.http.charset"), "UTF-8");

	public static final int HTTP_SO_TIMEOUT = Integer.parseInt(StringUtils.defaultIfBlank(
			System.getProperty("ouer.client.http.sotimeout"), "30000"));

	public static final boolean HTTP_KEEPALIVE = Boolean.parseBoolean(StringUtils.defaultIfBlank(
			System.getProperty("ouer.client.http.keepalive"), "true"));
	/**
	 * 服务端断掉连接后，客户端需重建连接 该参数表示这些 CLOSE_WAIT 状态的连接能保持多长时间，超过这个时间则重新创建连接
	 */
	public static final int HTTP_KEEPIDLE_DURATION = Integer.parseInt(StringUtils.defaultIfBlank(
			System.getProperty("ouer.client.http.keepidle.duration"), "5000"));

	public static final boolean HTTP_STALE_CHECK = Boolean.parseBoolean(StringUtils.defaultIfBlank(
			System.getProperty("ouer.client.http.stalecheck"), "true"));

	public static final int HTTP_CONN_TIMEOUT = Integer.parseInt(StringUtils.defaultIfBlank(
			System.getProperty("ouer.client.http.conntimeout"), "4000"));

	public static final int HTTP_MAX_TOTAL_CONN = Integer.parseInt(StringUtils.defaultIfBlank(
			System.getProperty("ouer.client.http.maxtotalconn"), "50"));

	public static final int HTTP_MAX_CONN_PER_ROUTE = Integer.parseInt(StringUtils.defaultIfBlank(
			System.getProperty("ouer.client.http.maxconnperroute"), "5"));

}
