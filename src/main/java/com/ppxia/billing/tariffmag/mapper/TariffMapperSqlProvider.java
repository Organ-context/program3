package com.ppxia.billing.tariffmag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;

import com.ppxia.billing.beans.PagerBean;

public class TariffMapperSqlProvider {
	
	public String findTariffByMap(Map<String, Object> map) {
		StringBuilder sb = new StringBuilder("select id, tariff_name as tariffName,basic_cost as basicCost,per_cost as perCost from t_tariff where 1=1 ");
		String tariffName = (String) map.get("tariffName");
		if (StringUtils.hasLength(tariffName)) {
			sb.append("and tariff_name like CONCAT('" + tariffName + "','%') ");
		}
		int num1 = (int) map.get("index");
		sb.append(" limit " + num1 + " ,10");
		return sb.toString();
	}
	
	public String findTotalTariffByMap(Map<String, Object> map) {
		StringBuilder sb = new StringBuilder("select count(id) from t_tariff where 1=1 ");
		String tariffName = (String) map.get("tariffName");
		if (StringUtils.hasLength(tariffName)) {
			sb.append("and tariff_name like CONCAT('" + tariffName + "','%') ");
		}
		return sb.toString();
	}
	
	// 查询分页的具体数据
	public String findTariffByParams(Map<String, Object> map) {
		Map params = (Map) map.get("params");
		StringBuilder sb = new StringBuilder(
				"select o.id as oid,os_account,os_state,fk_tariff_id,fk_server_id,fk_user_id from t_tariff as t, t_user as u ,t_server as s ,t_os as o where (1=1) ");
		// 获得条件“名字”
		String userName = (String) map.get("userName");
		if (StringUtils.hasLength(userName)) {
			sb.append("and u.user_name like CONCAT('" + userName + "','%') ");
		}

		// 获得条件“账号”
		String userAccountingName = (String) map.get("osAccount");
		if (StringUtils.hasLength(userAccountingName)) {
			sb.append("and os_account like CONCAT('" + userAccountingName + "','%') ");
		}

		sb.append("and u.id=o.fk_user_id and o.fk_tariff_id =t.id and o.fk_server_id = s.id");
		// 获得从第几条开始查
		PagerBean pager = (PagerBean) map.get("pager");
		int num1 = pager.getIndex();
		sb.append(" limit " + num1 + " ,10");
		return sb.toString();
	}

	// 查询满足条件数据的所有条数
	public String findTariffByAll(Map<String, Object> map) {
		Map params = (Map) map.get("params");
		StringBuilder sb = new StringBuilder(
				"select count(t.id) from t_tariff as t, t_user as u ,t_server as s ,t_os as o where (1=1) ");

		String userName = (String) map.get("userName");
		if (StringUtils.hasLength(userName)) {
			sb.append("and u.user_name like CONCAT('" + userName + "','%') ");
		}

		String userAccountingName = (String) map.get("osAccount");
		if (StringUtils.hasLength(userAccountingName)) {
			sb.append("and os_account like CONCAT('" + userAccountingName + "','%') ");
		}

		sb.append("and u.id=o.fk_user_id and o.fk_tariff_id =t.id and o.fk_server_id = s.id ");
		return sb.toString();
	}
}
