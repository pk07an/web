package com.vdlm.utils;

import java.util.Arrays;

public class HtmlUtils {
	public static String strToHtml(String text) {
		if (text == null || text.length() == 0)
			return "";
		StringBuffer rBuf = new StringBuffer();
		boolean newLine = true; // 新行标记 直到出现非' '字符转换为false

		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (newLine && ch != ' ')
				newLine = false;

			switch (ch) {
			case ' ':
				if (i == 0) {
					rBuf.append("&nbsp;");
				} else {
					if (text.charAt(i - 1) == ' ')
						rBuf.append("&nbsp;");
					else {
						rBuf.append(' ');
					}
				}
				break;
			case '&':
				rBuf.append("&amp;");
				break;
			case '>':
				rBuf.append("&gt;");
				break;
			case '<':
				rBuf.append("&lt;");
				break;
			case '"':
				rBuf.append("&quot;");
				break;
			case '\n':
				rBuf.append("<br>");
				newLine = true;
				break;
			default:
				rBuf.append(ch);
			}
		}
		return rBuf.toString();
	}
	
	/**
	 * 字符串补全16进制格式字符
	 * @param s
	 * @param length
	 */	
	public static String padLeft(String s, int length){
	    byte[] bs = new byte[length];
	    byte[] ss = s.getBytes();
	    Arrays.fill(bs, (byte) (48 & 0xff));
	    System.arraycopy(ss, 0, bs,length - ss.length, ss.length);
	    return "0x" + new String(bs);
	}
}
