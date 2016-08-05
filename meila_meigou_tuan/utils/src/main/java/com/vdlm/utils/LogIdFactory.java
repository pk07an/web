/**
 * 
 */
package com.vdlm.utils;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @author flong
 *
 */
public class LogIdFactory {
	private static final String numberChar = "0123456789";

	private static int serialNo = 0;

	/**
	 * 生成一个日志流水号，用来跟踪日志记录 生成规则：日期14位，随机数6位，自增4位
	 * 
	 * @return 24位的日志流水号
	 */
	public static String getLogId() {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		sb.append(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
		for (int i = 0; i < 6; i++) {
			sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
		}
		serialNo++;
		if (serialNo > 9999) {
			serialNo = 0;
		}
		String strSerialNo = String.valueOf(serialNo);
		for (int i = 0; i < 4 - strSerialNo.length(); i++) {
			sb.append("0");
		}
		sb.append(strSerialNo);
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			String id = getLogId();
			System.out.println(id);
		}
	}
}
