package com.ppxia.billing.osmag.dao.query;

import java.util.Date;

import com.ppxia.billing.beans.PagerBean;

public interface IOsQueryDao {
	//根据账务账单号与月份查询月度业务账单分页对象
	public PagerBean findOsMonthBeansByAccountingAndMonth(int  accountingNum,Date month);
	
	//据业务账单号与月份查询业务日账单
	public PagerBean findOsDayBeansByOsNumAndMonth(int  osNum,Date month);
	
	
}
