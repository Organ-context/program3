package com.ppxia.billing.prosceniummag.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.ppxia.billing.utils.StringUtils;

public class ProsceniumMapperSqlProvider {
	/**
	 * ProsceniumMapper 中 queryUserListByMap()的SQL提供方法
	 * 根据用户名和密码查询判断是否存在用户，构建sql
	 * @param params
	 * @return
	 */
	public String loginName(String userName,String userPassword) {
		StringBuilder sb = new StringBuilder("select * from t_user where user_name='"+userName+"' and user_password='"+userPassword+"'");
		return sb.toString();
	}
	public String selectUserBeanById(@Param("id")int id) {
		StringBuilder sb= new StringBuilder("select * from t_user where id="+id);
		return sb.toString();
	}
	
	public String updateUserBeanById(@Param("id")int id,@Param("telephone")Long telephone) {
		StringBuilder sb = new StringBuilder("update t_user set user_telephone="+telephone+" where id="+id);
		return sb.toString();
	}
	
	public String selectDate(int pageIndex,int pageSize,int id, Date monthe) {
		StringBuilder sb = new StringBuilder("select * from t_accounting_month where fk_user_id="+id);
		if(monthe!=null) {
			sb.append(" and	 YEAR(month)=YEAR('"+StringUtils.Date2StringMonth(monthe)+"') and MONTH(month)=MONTH('"+StringUtils.Date2StringMonth(monthe)+"') ");
		}
		sb.append(" limit "+(pageIndex-1)*pageSize+","+pageSize);
		return sb.toString();
	}
	
	public String countAccountingMonthTotalRow(int id, Date monthe) {
		StringBuilder sb = new StringBuilder("select count(id) from t_accounting_month where fk_user_id="+id);
		if(monthe!=null) {
			sb.append(" and	 YEAR(month)=YEAR('"+StringUtils.Date2StringMonth(monthe)+"') and MONTH(month)=MONTH('"+StringUtils.Date2StringMonth(monthe)+"') ");
		}
		return sb.toString();
	}
	public String selectOsAccountNumberByMonth(int id,Date month) {
		StringBuilder sb = new StringBuilder("select * from t_os_month where mont="+month);
		if(month!=null) {
			sb.append(" and mont='"+month.toString()+"'");
		}
		return sb.toString();
	}
	public String selectOsCostDetailsBymonth(int pageIndex,int pageSize,int id,Date monthe) {
		StringBuilder sb = new StringBuilder("select *from t_os_day where mont=\"+month");
		if(monthe!=null) {
			sb.append(" and mont='"+monthe.toString()+"'");
		}
		sb.append(" limit "+(pageIndex-1)*pageSize+","+pageSize);
		return sb.toString();
	}
	public String selectOsDayBeanBymonth(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("id")int id,@Param("monthe")Date monthe) {
		StringBuilder sb= new StringBuilder("select * from t_os_day where fk_os_id="+id);
		if(monthe!=null) {
			sb.append(" and CONCAT(YEAR(login_time),\"-\",MONTH(login_time))=CONCAT(YEAR('"+StringUtils.Date2StringMonth(monthe)+"'),\"-\",MONTH('"+StringUtils.Date2StringMonth(monthe)+"'))");
		}
		sb.append(" limit "+(pageIndex-1)*pageSize+","+pageSize);
		return sb.toString();
	}
	public String selectCountOsDay(@Param("id")int id,@Param("monthe")Date monthe) {
		StringBuilder sb= new StringBuilder("select count(id) from t_os_day where fk_os_id="+id);
		if(monthe!=null) {
			sb.append(" and  CONCAT(YEAR(login_time),\"-\",MONTH(login_time))=CONCAT(YEAR('"+StringUtils.Date2StringMonth(monthe)+"'),\"-\",MONTH('"+StringUtils.Date2StringMonth(monthe)+"'))");
		}
		return sb.toString();
	}
	
	
}
