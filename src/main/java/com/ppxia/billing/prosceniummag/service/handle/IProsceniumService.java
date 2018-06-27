package com.ppxia.billing.prosceniummag.service.handle;

import java.util.Date;

import com.ppxia.billing.beans.OsDayBean;
import com.ppxia.billing.beans.OsMonthBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;

public interface IProsceniumService {
	/**
	 * 用户登陆
	 * @param userName 用户账号
	 * @param userPassword 用户密码
	 * @return
	 */
	public UserBean loginName(String userName,String userPassword); 
	/**
	 * 根据id查询个人信息
	 * @param id
	 * @return
	 */
	public UserBean selectUserBeanById(int id);
	/**
	 * 对用户的个人信息进行修改
	 * @param gender
	 * @param userQqnum
	 * @param userPostnum
	 * @param userAddress
	 */
	public void updateUserBeanById(int id,Long telephone);					
	
	
	/**
	 * 根据用户的id查询月账单
	 * @param pageIndex
	 * @param pageSize
	 * @param id
	 * @param monthe
	 * @return
	 */
	public PagerBean selectAccountingMonthByUserId(int pageIndex,int pageSize,int id,Date monthe);
	
	/**
	 * 根据输入的月份查询本月的账务账号产生的总费用
	 * @param id
	 * @param month
	 * @return
	 */
	public OsMonthBean selectOsAccountNumberByMonth(int id,Date month); 
	
	/**
	 * 根据这个月账号查询本月所有业务产生的费用明细。
	 * @param pageIndex
	 * @param pageSize
	 * @param id
	 * @param monthe
	 * @return
	 */
	public PagerBean selectOsCostDetailsBymonth(int pageIndex,int pageSize,int id,Date monthe); 
	}