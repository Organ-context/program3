package com.ppxia.billing.osAccountingmag.dao;

import java.util.List;
import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IOsaccountingQueryDao {
	 /**
     * 根据条件查询年账务账单的集合
     * @param params  传入三个参 业务账号 实验室名字 年份
     * @return 集合
     */
	public List<?> findOsYearAccountingByParams(Map params);
	
	
	/**
     * 根据条件查询年账务账单的总条数
     * @param params  传入三个参 业务账号 实验室名字 年份
     * @return 总条数
     */
	public int findOsYearAccountingTotals(Map params);
	
	
	 /**
     * 根据条件查询月账务账单的集合
     * @param params  传入三个参 业务账号 实验室名字 月份
     * @return 集合
     */
	public List<?> findOsMonthAccountingByParams(Map params);
	
	
	/**
     * 根据条件查询月账务账单的总条数
     * @param params  传入三个参 业务账号 实验室名字 月份
     * @return 总条数
     */
	public int findOsMonthAccountingTotals(Map params);
	
	 /**
     * 根据条件查询日账务账单的集合
     * @param params  传入三个参 业务账号 实验室名字 日份
     * @return 集合
     */
	public List<?> findOsDayAccountingByParams(Map params);
	
	
	/**
     * 根据条件查询年账务账单的总条数
     * @param params  传入三个参 业务账号 实验室名字 日份
     * @return 总条数
     */
	public int findOsDayAccountingTotals(Map params);
}
