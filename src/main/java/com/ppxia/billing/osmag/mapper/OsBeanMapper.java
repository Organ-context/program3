package com.ppxia.billing.osmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;

public interface OsBeanMapper {
	// 根据账务账单号与月份查询月度业务账单分页对象
	public PagerBean findOsMonthBeansByAccountingAndMonth(int accountingNum, Date month);

	// 据业务账单号与月份查询业务日账单
	public PagerBean findOsDayBeansByOsNumAndMonth(int osNum, Date month);
	
	//通过姓名或业务账号查询业务账号信息
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="UserName",column="u.user_name",javaType=String.class),
		@Result(property="userAccountingName",column="u.user_accounting_name",javaType=String.class),
		@Result(property="OsAccount",column="o.os_account",javaType=String.class),
		@Result(property="OsState",column="o.os_state",javaType=Integer.class),
		@Result(property="ServerIp",column="o.os_state,s.server_ip",javaType=String.class),
		@Result(property="tariffName",column="t.tariff_name",javaType=String.class),
	})
	@SelectProvider(type=OsBeanMapperSqlProvider.class,method="findOsByNameOrOsName")
	public List<UserBean> findOsByNameOrOsName(@Param("params")Map params);
	
	//通过姓名或业务账号查询业务总条数
	@SelectProvider(type=OsBeanMapperSqlProvider.class,method="findByAll")
	public int findByAll(@Param("params")Map params);
	
}
