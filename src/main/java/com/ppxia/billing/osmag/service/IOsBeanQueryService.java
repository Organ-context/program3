package com.ppxia.billing.osmag.service;

import java.util.Date;
import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IOsBeanQueryService {
	//根据账务账单号与月份查询月度业务账单分页对象
		public PagerBean findOsMonthBeansByAccountingAndMonth(int  accountingNum,Date month);
		
		//据业务账单号与月份查询业务日账单
		public PagerBean findOsDayBeansByOsNumAndMonth(int  osNum,Date month);
		
		//通过姓名或业务账号查询业务账号信息
		public PagerBean findOsByNameOrOsName(Map map);
}
