package com.ppxia.billing.prosceniummag.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import com.ppxia.billing.beans.AccountingMonthBean;
import com.ppxia.billing.beans.OsDayBean;
import com.ppxia.billing.beans.OsMonthBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;


public interface ProsceniumMapper {
	/**
	 * 用户登陆
	 * @param userName 用户账号
	 * @param userPassword 用户密码
	 * @return
	 */
	@Results({
		  @Result(id=true,property="id",column="id",javaType=Long.class),
		  @Result(property="userName",column="user_name",javaType=String.class),
		  @Result(property="userPassword",column="user_password",javaType=String.class),
		  @Result(property="gender",column="gender",javaType=Integer.class),
		  @Result(property="userIdcard",column="user_idcard",javaType=String.class),
		  @Result(property="userAccountingName",column="user_accounting_name",javaType=String.class)	,	 
		  @Result(property="userAccountingState",column="user_accounting_state",javaType=Integer.class),
		  @Result(property="userAddress",column="user_address",javaType=String.class)	,	 
		  @Result(property="userPostnum",column="user_postnum",javaType=Integer.class)	,	 
		  @Result(property="userQqnum",column="user_qqnum",javaType=Long.class),
		  @Result(property="telephone",column="user_telephone",javaType=Long.class)	
		  
	  })
	@SelectProvider(type=ProsceniumMapperSqlProvider.class, method = "loginName")
	public UserBean loginName(@Param("userName")String userName,@Param("userPassword")String userPassword); 
	/**
	 * 根据id查询个人信息
	 * @param id
	 * @return
	 */
	@Results({
		  @Result(id=true,property="id",column="id",javaType=Long.class),
		  @Result(property="userName",column="user_name",javaType=String.class),
		  @Result(property="userPassword",column="user_password",javaType=String.class),
		  @Result(property="gender",column="gender",javaType=Integer.class),
		  @Result(property="userIdcard",column="user_idcard",javaType=String.class),
		  @Result(property="userAccountingName",column="user_accounting_name",javaType=String.class)	,	 
		  @Result(property="userAccountingState",column="user_accounting_state",javaType=Integer.class),
		  @Result(property="userAddress",column="user_address",javaType=String.class)	,	 
		  @Result(property="userPostnum",column="user_postnum",javaType=Integer.class)	,	 
		  @Result(property="userQqnum",column="user_qqnum",javaType=Long.class),
		  @Result(property="telephone",column="user_telephone",javaType=Long.class)	
		  
	  })
	@SelectProvider(type=ProsceniumMapperSqlProvider.class,method="selectUserBeanById")
	public UserBean selectUserBeanById(@Param("id")int id);
	
	@UpdateProvider(type=ProsceniumMapperSqlProvider.class,method="updateUserBeanById")
	public int updateUserBeanById(@Param("id")int id,@Param("telephone")Long telephone);					
	@Results({
		  @Result(id=true,property="id",column="id",javaType=Long.class),
		  @Result(property="payCondition",column="pay_condition",javaType=Integer.class),
		  @Result(property="payWay",column="pay_way",javaType=Integer.class),
		  @Result(property="monthCoast",column="month_coast",javaType=Double.class),
		  @Result(property="month",column="month",javaType=Date.class,jdbcType=JdbcType.TIMESTAMP),
		
	  })
	@SelectProvider(type=ProsceniumMapperSqlProvider.class,method="selectDate")
	public List<AccountingMonthBean> selectDate(int pageIndex,int pageSize,int id, Date monthe);
	@SelectProvider(type=ProsceniumMapperSqlProvider.class,method="countAccountingMonthTotalRow")
	public int countAccountingMonthTotalRow(int id, Date monthe);
	@Results({
		  @Result(id=true,property="id",column="id",javaType=Long.class),
		  @Result(property="month",column="month",javaType=Date.class),
		  @Result(property="totalTime",column="total_time",javaType=Long.class),
		  @Result(property="monthCoast",column="month_coast",javaType=Double.class),
		  @Result(property="IP",column="server_ip",javaType=Date.class),
		  @Result(property="costType",column="tariff_type",javaType=Double.class),
		
	  })
	@SelectProvider(type=ProsceniumMapperSqlProvider.class,method="selectOsAccountNumberByMonth")
	public OsMonthBean selectOsAccountNumberByMonth(int id,Date month); 
	@Results({
		  @Result(id=true,property="id",column="id",javaType=Long.class),
		  @Result(property="LoginTime",column="login_time",javaType=Date.class),
		  @Result(property="OutTime",column="out_time",javaType=Date.class),
		  @Result(property="TotalTime",column="total_time",javaType=Long.class),
		  @Result(property="DayCoast",column="day_coast",javaType=Double.class),
		
		
	  })
	@SelectProvider(type=ProsceniumMapperSqlProvider.class,method="selectOsCostDetailsBymonth")
	public OsDayBean selectOsCostDetailsBymonth(int pageIndex,int pageSize,int id,Date monthe); 
	@Results({
		  @Result(id=true,property="id",column="id",javaType=Long.class),
		  @Result(property="LoginTime",column="login_time",javaType=Date.class),
		  @Result(property="OutTime",column="out_time",javaType=Date.class),
		  @Result(property="TotalTime",column="total_time",javaType=Long.class),
		  @Result(property="DayCoast",column="day_coast",javaType=Double.class),
		  @Result(property="IP",column="服务器IP",javaType=String.class),
		  @Result(property="costType",column="资费类型",javaType=Integer.class)
		
	  })
	@SelectProvider(type=ProsceniumMapperSqlProvider.class,method="selectOsDayBeanBymonth")
	public List<OsDayBean> selectOsDayBeanBymonth(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("id")int id,@Param("monthe")Date monthe);
	/**
	 * 查询日账单总条数
	 * @param id
	 * @param 
	 * @return
	 */
	@SelectProvider(type=ProsceniumMapperSqlProvider.class,method="selectCountOsDay")
	public int selectCountOsDay(@Param("id")int id,@Param("monthe")Date monthe);
	
}
