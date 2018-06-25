package com.ppxia.billing.osmag.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ppxia.billing.beans.OsBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;

public interface IOsBeanQueryDao {
	//根据账务账单号与月份查询月度业务账单分页对象
	public PagerBean findOsMonthBeansByAccountingAndMonth(int  accountingNum,Date month);
	
	//据业务账单号与月份查询业务日账单
	public PagerBean findOsDayBeansByOsNumAndMonth(int  osNum,Date month);
	
	//通过姓名或业务账号查询业务账号信息
	public List<UserBean> findOsByNameOrOsName(Map params);
	
	public int findByAll(Map params);
	
	//通过ID查询业务账号
	public OsBean findOsBeanById(Long id);
	
}
