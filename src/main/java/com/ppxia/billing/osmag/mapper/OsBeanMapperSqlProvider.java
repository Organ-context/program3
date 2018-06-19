package com.ppxia.billing.osmag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;

public class OsBeanMapperSqlProvider {
	//查询业务账号满足条件的具体数据
	
	//在osbean类中加OsState属性，数据库中加os_state字段
	public String findOsByNameOrOsName(Map<String, Object> map) {
		Map params = (Map) map.get("params");
		StringBuilder sb = new StringBuilder(
				"select u.user_name,u.user_accounting_name,o.os_account, o.os_state,s.server_ip,t.tariff_name from t_user as u ,t_os as o ,t_server as s, t_tariff as t where (1=1) ");
		//获得条件姓名
		String osAccount = params.get("OsAccount").toString();
		if(StringUtils.hasLength(osAccount)) {
			sb.append("and u.user_name like CONCAT('"+osAccount+"','%') ");
		}
		
		//获得条件账务账号
		String userName = params.get("userName").toString();
		if(StringUtils.hasLength(userName)) {
			sb.append("and u.user_accounting_name like CONCAT('"+userName+"','%') ");
		}
		
		sb.append("u.id = o.fk_user_id and o.fk_server_id = s.id and o.fk_tariff_id = t.id");
		return sb.toString();
	}
	
	//查询满足条件的总条数
	public String findByAll(Map<String, Object> map) {
		Map params = (Map) map.get("params");
		StringBuilder sb = new StringBuilder(
				"select count(u.id) from t_user as u ,t_os as o ,t_server as s, t_tariff as t where (1=1) ");
		//获得条件姓名
		String osAccount = params.get("OsAccount").toString();
		if(StringUtils.hasLength(osAccount)) {
			sb.append("and u.user_name like CONCAT('"+osAccount+"','%') ");
		}
		
		//获得条件账务账号
		String userName = params.get("userName").toString();
		if(StringUtils.hasLength(userName)) {
			sb.append("and u.user_accounting_name like CONCAT('"+userName+"','%') ");
		}
		//外键关系
		sb.append("u.id = o.fk_user_id and o.fk_server_id = s.id and o.fk_tariff_id = t.id");
		return sb.toString();
	}
}
