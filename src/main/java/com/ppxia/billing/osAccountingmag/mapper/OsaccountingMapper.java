package com.ppxia.billing.osAccountingmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.ppxia.billing.beans.OsDayBean;
import com.ppxia.billing.beans.OsMonthBean;
import com.ppxia.billing.beans.OsYearBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.osmag.mapper.OsMagMapperSqlProvider;

public interface OsaccountingMapper {
	@Results({
		  @Result(id=true,property="id",column="id",javaType=Long.class),
		  @Result(property="osBean.OsAccount",column="OsAccount",javaType=String.class),
		  @Result(property="IP",column="IP",javaType=String.class),
		  @Result(property="YearTotalTime",column="YearTotalTime",javaType=Long.class),
		  @Result(property="Year",column="Year",javaType=String.class),	 
	  })
	    @SelectProvider(type=OsAccountingMagMapperSqlProvider.class,method="queryOsYearAccountingByParams")
	public List<OsYearBean> findOsYearAccountingByParams(@Param("map")Map params);
	
	
	@SelectProvider(type=OsAccountingMagMapperSqlProvider.class,method="queryOsYearAccountingTotals")
	public int findOsYearAccountingTotals(@Param("map")Map params);
	
	
	@Results({
		  @Result(id=true,property="id",column="id",javaType=Long.class),
		  @Result(property="osBean.OsAccount",column="OsAccount",javaType=String.class),
		  @Result(property="IP",column="IP",javaType=String.class),
		  @Result(property="totalTime",column="totalTime",javaType=Long.class),
		  @Result(property="month",column="month",javaType=String.class),	 
	  })
	@SelectProvider(type=OsAccountingMagMapperSqlProvider.class,method="queryOsMonthAccountingByParams")
	public List<OsMonthBean> findOsMonthAccountingByParams(@Param("map")Map params);
	
	
	@SelectProvider(type=OsAccountingMagMapperSqlProvider.class,method="queryOsMonthAccountingTotals")
	public int findOsMonthAccountingTotals(@Param("map")Map params);
	
	@Results({
		  @Result(id=true,property="id",column="id",javaType=Long.class),
		  @Result(property="osBean.OsAccount",column="OsAccount",javaType=String.class),
		  @Result(property="IP",column="IP",javaType=String.class),
		  @Result(property="TotalTime",column="TotalTime",javaType=Long.class),
		  @Result(property="LoginTime",column="LoginTime",javaType=java.util.Date.class),	 
	  })
	@SelectProvider(type=OsAccountingMagMapperSqlProvider.class,method="queryOsDayAccountingByParams")
	public List<OsDayBean> findOsDayAccountingByParams(@Param("map")Map params);
	

	@SelectProvider(type=OsAccountingMagMapperSqlProvider.class,method="queryOsDayAccountingTotals")
	public int findOsDayAccountingTotals(@Param("map")Map params);
}
