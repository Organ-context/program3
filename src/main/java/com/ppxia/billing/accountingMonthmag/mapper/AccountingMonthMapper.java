package com.ppxia.billing.accountingMonthmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.ppxia.billing.beans.AccountingMonthBean;

public interface AccountingMonthMapper {
	@Results({
		  @Result(id=true,property="id",column="id",javaType=Long.class),
		  @Result(property="monthCoast",column="monthCoast",javaType=Double.class),
		  @Result(property="payCondition",column="payCondition",javaType=Integer.class),
		  @Result(property="payWay",column="payWay",javaType=Integer.class),
		  @Result(property="month",column="month",javaType=String.class),
		  @Result(property="userBean.userName",column="userName",javaType=String.class)	,	 
		  @Result(property="userBean.userAccountingName",column="userAccountingName",javaType=String.class)	,	 
		  @Result(property="userBean.userIdcard",column="userIdcard",javaType=String.class)		 
	  })
	 @SelectProvider(type=AccountingMonthMapperSqlProvider.class,method="queryAccMonthByParams")
   public List<AccountingMonthBean> findAccountingMonthByParams(@Param("map")Map params);
	
	 @SelectProvider(type=AccountingMonthMapperSqlProvider.class,method="queryAccMonthTotals")
	public int findAccountingMonthTotal(@Param("map")Map params);
}
