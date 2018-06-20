package com.ppxia.billing.utils;

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
	
	
}
