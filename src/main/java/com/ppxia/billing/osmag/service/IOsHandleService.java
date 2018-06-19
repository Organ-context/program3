package com.ppxia.billing.osmag.service;

import java.time.Month;

import com.ppxia.billing.beans.OsDayBean;

public interface IOsHandleService {

	  /**
	   * 为该业务账号添加一个日账单信息
	   * @param osDayBean  传入一个日账单对象
	   */
	  public void addOsDay(OsDayBean osDayBean);
	  
	  
	  /**
	   * 修改该业务账号的当月的月账单
	   * @param osMonthBean  传入一个日账单 
	   */
	  public void updateMonth(OsDayBean osDayBean);
	  
}
