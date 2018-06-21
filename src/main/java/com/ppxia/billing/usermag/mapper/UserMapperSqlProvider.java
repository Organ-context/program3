package com.ppxia.billing.usermag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;

public class UserMapperSqlProvider {

	public String countManagerByParams(Map map) {

		Map<String, Object> params = (Map<String, Object>) map.get("params");
		StringBuilder sb = new StringBuilder(
				"select count(*) from t_user as u left join t_role as r on u.fk_role_id= r.id where 1=1 ");
		if (params.get("realname") != null && StringUtils.hasLength(((String) params.get("realname")).trim())) {
			sb.append("and u.user_name like concat('" + params.get("realname") + "','%') ");
		}
		if (params.get("username") != null) {
			sb.append("and u.user_accounting_name like concat('" + params.get("username") + "','%') ");
		}
		if (params.get("role") != null && StringUtils.hasLength(((String) params.get("role")).trim())) {
			sb.append("and r.role_name ='" + params.get("role") + "' ");
		}

		return sb.toString();

	}

	
	public String findManagerByParams(Map map) {
		Map<String, Object> params = (Map<String, Object>) map.get("params");
		StringBuilder sb = new StringBuilder(
				"select u.*,r.role_name as roleName from t_user as u left join t_role as r on u.fk_role_id= r.id where 1=1 ");
		if (params.get("realname") != null && StringUtils.hasLength(((String) params.get("realname")).trim())) {
			sb.append("and u.user_name like concat('" + params.get("realname") + "','%') ");
		}
		if (params.get("username") != null) {
			sb.append("and u.user_accounting_name like concat('" + params.get("username") + "','%') ");
		}
		if (params.get("role") != null && StringUtils.hasLength(((String) params.get("role")).trim())) {
			sb.append("and r.role_name ='" + params.get("role") + " '");
		}
		sb.append("limit " + params.get("index") + "," + params.get("rows"));

		return sb.toString();

	}
}
