package com.ppxia.billing.accountingMonthmag.service;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;
/**
 * 账务账单
 * @author Administrator
 *
 */
public interface IAccountingMonthQueryService {
	
	/**账务账单月查询,在账单主页面调用这个
	 * 
	 * @param param  里面放入页数信息,
	 * @param params  放入条件,比如身份证(初始为空字符串),账务账号,用户姓名,账单的月份
	 * @return  返回一个查询出来的分页对象.
	 */
	public PagerBean findAccountingMonthByParams(PagerBean param,Map params);
}
