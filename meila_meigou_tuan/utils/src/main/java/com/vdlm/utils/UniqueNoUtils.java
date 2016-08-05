package com.vdlm.utils;

import java.net.Inet4Address;
import java.util.Calendar;

public class UniqueNoUtils {
	public enum UniqueNoType {
		SO, // 订单号
		SU, //子订单号
		DO, // 交易号
		P,//支付请求号
		CID, //匿名用户唯一号
		WITHDRAW, //提现申请号
		R, //退款单号
		PT//团单号
	}
	private static Calendar cal = Calendar.getInstance();
	private static int seq = 0;
	private static final int ROTATION = 999;
	private static int ipMix = 0;
	

	/**
	 * 订单号生成规则：时间戳（精确到秒）+最后一段的IP地址+序列号
	 * @return 唯一订单号
	 */
	public static synchronized String next(UniqueNoType type) {
		if (seq > ROTATION){
			seq = 0;
		}
		if (ipMix == 0) {
			try {
				String ipAddress = Inet4Address.getLocalHost().getHostAddress();
				String[] ipAddresses = ipAddress.split("\\.");
				ipMix = Integer.parseInt(ipAddresses[3]);
			} catch (Exception e) {
				ipMix = 1;
			}
		}
		cal.setTimeInMillis(System.currentTimeMillis());
		return type+String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$03d%3$03d", cal, ipMix, seq++).substring(2);
	}
	
	public static synchronized String next() {
		if (seq > ROTATION){
			seq = 0;
		}
		if (ipMix == 0) {
			try {
				String ipAddress = Inet4Address.getLocalHost().getHostAddress();
				String[] ipAddresses = ipAddress.split("\\.");
				ipMix = Integer.parseInt(ipAddresses[3]);
			} catch (Exception e) {
				ipMix = 1;
			}
		}
		cal.setTimeInMillis(System.currentTimeMillis());
		return String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$03d%3$03d", cal, ipMix, seq++);
	}

	public static void main(String[] args) {
		System.out.println(UniqueNoUtils.next(UniqueNoType.DO));
		System.out.println(UniqueNoUtils.next());
	}
}
