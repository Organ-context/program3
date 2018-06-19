package com.ppxia.billing.osmag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;



/**
 * UserMapper.java 中接口的SQL提供类
 * 
 * @author pu
 *
 */
public class OsMagMapperSqlProvider {

	/**
	 * UserMapper 中 queryUserListByMap()的SQL提供方法
	 * 根据传入的账务账号名字和月份,查询某个账务账号下该月的所有os账号费用明细 提供页数进入分页对象传入
	 * @param params
	 * @return
	 */
	public String queryOsMonthByParams(Map<String, Object> params) {
		Map map = (Map) params.get("map");
		StringBuilder sb = new StringBuilder(
       "select om.id as id,os.os_account as OsAccount,om.server_ip as IP,om.total_time as totalTime,om.month_coast as monthCoast,om.tariff_type as costType from t_os_month om, t_os os, t_user u"
       + " where om.fk_os_id=os.id and os.fk_user_id=u.id "
       + "and u.user_accounting_name like '"+map.get("accountingName")+"%'"
       + "and om.month like '"+map.get("Month")+"%' limit "+map.get("index")+" ,10");

		return sb.toString();
	}
	
	
	public String queryOsMonthTotals(Map params) {
		Map<String, Object> map = (Map<String, Object>) params.get("map");
		StringBuilder sb = new StringBuilder(
       "select count(*) from t_os_month om, t_os os, t_user u"
       + " where om.fk_os_id=os.id and os.fk_user_id=u.id "
       + "and u.user_accounting_name like '"+map.get("accountingName")+"%'"
       + "and om.month like '"+map.get("Month")+"%'");
		return sb.toString();
	}


	public String queryOsDayByParams(Map<String, Object> params) {
		Map map = (Map) params.get("map");
		StringBuilder sb = new StringBuilder("select od.id as id,os.os_account as OsAccount,od.server_ip as IP,od.login_time as LoginTime,od.out_time as OutTime,od.total_time as TotalTime,od.day_coast as DayCoast,od.tariff_type as costType "
				+ " from t_user u,t_os os,t_os_day od where"
				+ " od.fk_os_id=os.id and os.fk_user_id=u.id "
				+ "and u.user_accounting_name like '"+map.get("accountingName")+"%' and od.out_time like '"+map.get("time")+"%' and"
			    + " os.os_account ='"+map.get("osaccount")+"' and od.server_ip ='"+map.get("serverip")+"' limit "+map.get("index")+",10");
		return sb.toString();
	}
	
	public String queryOsDayTotals(Map<String, Object> params) {
		Map map = (Map) params.get("map");
		StringBuilder sb = new StringBuilder("select count(*)"
				+ " from t_user u,t_os os,t_os_day od where "
				+ "od.fk_os_id=os.id and os.fk_user_id=u.id "
				+ "and u.user_accounting_name like '"+map.get("accountingName")+"%' and od.out_time like '"+map.get("time")+"%' and "
			    + "os.os_account ='"+map.get("osaccount")+"' and od.server_ip ='"+map.get("serverip")+"'");
		return sb.toString();
	}

}
