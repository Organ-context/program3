package com.ppxia.billing.osmag.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IOsQueryDao {
	/**
	    * 根据传入的账务账号名字和月份,查询某个账务账号下该月的所有os账号费用明细
	    * 提供页数进入分页对象传入
	    * @param accountingNum 账务账号
	    * @param month 月份
	    * @return  返回一个分页对象,该对象包含了该账务账号下该月的os账号,服务器信息
	    * 该os账号该月消费的时长和费用 还有资费套餐
	    */
		public List<?> findOsMonthBeansByAccountingAndMonth(Map map);
		
		
		
		/**
		 * 根据传入的账务账号名字和月份,查询某个账务账号下该月的所有os账号总条数
		 * @param param 分页对象
		 * @param accountingNum  账务账号
		 * @param month 月份
		 * @return  返回一个总条数
		 */
		public int findOsMonthBeansTotal(Map map);
		
		/**
		 * 根据传入一个账务账号和os账号,还有日期查询该月下对应日期的分页对象
		 * 根据页数查询分页对象
		 * @param map  包含账务账号,os账号,日期(初始为空字符串)
		 * @return 返回一个分页对象,包含了所有该osDaybean里面的内容  ,包含os账号,服务器账号
		 * 登入登出时长,使用时长,费用,资费套餐
		 */
		public List<?> findOsDayBeansByParams(Map map);
		
		/**
		 * 根据传入一个账务账号和os账号,还有日期查询该月下对应日期的总条数
		 * 
		 * @param map  包含账务账号,os账号,日期(初始为空字符串)
		 * @return 返回一个总条数
		 */
		public int findOsDayBeansTotal(Map map);
	
}
