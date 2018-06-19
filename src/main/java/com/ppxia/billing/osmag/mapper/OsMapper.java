package com.ppxia.billing.osmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.ppxia.billing.beans.OsDayBean;
import com.ppxia.billing.beans.OsMonthBean;

public interface OsMapper {
	  @Results({
		  @Result(id=true,property="id",column="id",javaType=Long.class),
		  @Result(property="IP",column="IP",javaType=String.class),
		  @Result(property="totalTime",column="totalTime",javaType=Long.class),
		  @Result(property="monthCoast",column="monthCoast",javaType=Double.class),
		  @Result(property="costType",column="costType",javaType=Integer.class),
		  @Result(property="osBean.OsAccount",column="OsAccount",javaType=String.class)		 
	  })
	    @SelectProvider(type=OsMagMapperSqlProvider.class,method="queryOsMonthByParams")
		public List<OsMonthBean> findOsMonthBeansByAccountingAndMonth(@Param("map")Map map);
		
		
		
		/**
		 * 根据传入的账务账号名字和月份,查询某个账务账号下该月的所有os账号总条数
		 * @param param 分页对象
		 * @param accountingNum  账务账号
		 * @param month 月份
		 * @return  返回一个总条数
		 */
	    @SelectProvider(type=OsMagMapperSqlProvider.class,method="queryOsMonthTotals")
		public int findOsMonthBeansTotal(@Param("map")Map map);
		
		/**
		 * 根据传入一个账务账号和os账号,还有日期查询该月下对应日期的分页对象
		 * 根据页数查询分页对象
		 * @param map  包含账务账号,os账号,日期(初始为空字符串)
		 * @return 返回一个分页对象,包含了所有该osDaybean里面的内容  ,包含os账号,服务器账号
		 * 登入登出时长,使用时长,费用,资费套餐
		 */
		 @Results({
			  @Result(id=true,property="id",column="id",javaType=Long.class),
			  @Result(property="osBean.OsAccount",column="OsAccount",javaType=String.class),
			  @Result(property="IP",column="IP",javaType=String.class),
			  @Result(property="LoginTime",column="LoginTime",javaType=java.sql.Date.class),
			  @Result(property="OutTime",column="OutTime",javaType=java.sql.Date.class),
			  @Result(property="TotalTime",column="TotalTime",javaType=Long.class),
			  @Result(property="DayCoast",column="DayCoast",javaType=Double.class),
			  @Result(property="costType",column="costType",javaType=Integer.class),	 
		  })
	    @SelectProvider(type=OsMagMapperSqlProvider.class,method="queryOsDayByParams")
		public List<OsDayBean> findOsDayBeansByParams(@Param("map")Map map);
		
		/**
		 * 根据传入一个账务账号和os账号,还有日期查询该月下对应日期的总条数
		 * 
		 * @param map  包含账务账号,os账号,日期(初始为空字符串)
		 * @return 返回一个总条数
		 */
	    @SelectProvider(type=OsMagMapperSqlProvider.class,method="queryOsDayTotals")
		public int findOsDayBeansTotal(@Param("map")Map map);
}
