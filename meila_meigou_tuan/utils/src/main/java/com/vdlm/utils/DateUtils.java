package com.vdlm.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static Date getYesterdayStart(Date today){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	public static Date getYesterdayEnd(Date today){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		return calendar.getTime();
	}
	
	public static long getSecond(Date date){
		if(date==null){
			return 0;
		}
		return date.getTime()/1000;
	}
}
