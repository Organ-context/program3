package com.ppxia.billing.tariffmag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;

public class TariffMapperSqlProvider {
	//查询分页的具体数据
	public String findTariffByParams(Map<String, Object> map) {
		Map params = (Map) map.get("params");
		StringBuilder sb = new StringBuilder(
				"select t.tariff_name,u.user_name,u.user_accounting_name, s.server_ip from t_tariff as t, t_user as u ,t_server as s ,t_os as o where (1=1) ");
		//获得条件“名字”
		String userName = params.get("userName").toString();
		if(StringUtils.hasLength(userName)) {
			sb.append("and u.user_name like CONCAT('"+userName+"','%') ");
		}
		
		//获得条件“账号”
		String userAccountingName = params.get("userAccountingName").toString();
		if(StringUtils.hasLength(userAccountingName)) {
			sb.append("and u.user_accounting_name like CONCAT('"+userAccountingName+"','%') ");
		}
		
		//获得从第几条开始查
		int	num1 =Integer.parseInt(params.get("page").toString());
	
		sb.append("and u.id=o.fk_user_id and o.fk_tariff_id =t.id and o.fk_server_id = s.id limit num1,10");
		return sb.toString();
	}
	
	
	//查询满足条件数据的所有条数
	public String findTariffByAll(Map<String, Object> map) {
		Map params = (Map) map.get("params");
		StringBuilder sb = new StringBuilder(
				"select count(t.userName) from t_tariff as t, t_user as u ,t_t_server as s ,t_os as owhere (1=1) ");
		
		String userName = params.get("userName").toString();
		if(StringUtils.hasLength(userName)) {
			sb.append("and u.user_name like CONCAT('"+userName+"','%') ");
		}
		
		String userAccountingName = params.get("userAccountingName").toString();
		if(StringUtils.hasLength(userAccountingName)) {
			sb.append("and u.user_accounting_name like CONCAT('"+userAccountingName+"','%') ");
		}
		
		sb.append("and u.id=o.fk_user_id and o.fk_tariff_id =t.id and o.fk_server_id = s.id ");
		return sb.toString();
	}
}
