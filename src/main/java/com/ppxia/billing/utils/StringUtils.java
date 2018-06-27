package com.ppxia.billing.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

	public static boolean isEmpty(String str) {
		
		if(str == null || "".equals(str)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isEmpty(Object obj) {
		if(obj == null) return true;
		else return false;
	}
	
	/**
	 * 时间格式化
	 * @param str
	 * @return
	 */
	public static Date formatDate(String str) {
		SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		try {
			date = sf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	public static String Date2StringMonth(Date date) {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String dateStr=sf.format(new Date(date.getTime()));
		return dateStr;
	}
	public static Date timestamp2Date(long timestamp) {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		Date date=new Date(timestamp);
		return date;
	}
}
