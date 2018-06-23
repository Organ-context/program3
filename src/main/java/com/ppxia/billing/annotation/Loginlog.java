package com.ppxia.billing.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//注解
public @interface Loginlog {	
	    //操作模块
		String module() default ""; 
		//操作类型
		int type() default 0;

}
