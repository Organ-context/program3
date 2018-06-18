package com.ppxia.billing.usermag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;

public class UserMapperSqlProvider {

	public String countManagerByParams(Map map) {

		Map<String, Object> params = (Map<String, Object>) map.get("params");
		StringBuilder sb = new StringBuilder(
				"select count(*) from t_user as u left join t_role as r on u.fk_role_id= r.id where 1=1 ");
		if (params.get("userName") != null && StringUtils.hasLength(((String) params.get("userName")).trim())) {
			sb.append("and u.user_name like concat('" + params.get("userName") + "','%') ");
		}
		if (params.get("userAccountingName") != null) {
			sb.append("and u.user_accounting_name like concat('" + params.get("userAccountingName") + "','%') ");
		}
		if ((int)params.get("roleBean") != 0) {
			sb.append("and r.role_type =" + params.get("roleBean") + " ");
		}

		return sb.toString();

	}

	public String findManagerByParams(Map map) {

		Map<String, Object> params = (Map<String, Object>) map.get("params");
		StringBuilder sb = new StringBuilder(
				"select * from t_user as u left join t_role as r on u.fk_role_id= r.id where 1=1 ");
		if (params.get("userName") != null && StringUtils.hasLength(((String) params.get("userName")).trim())) {
			sb.append("and u.user_name like concat('" + params.get("userName") + "','%') ");
		}
		if (params.get("userAccountingName") != null) {
			sb.append("and u.user_accounting_name like concat('" + params.get("userAccountingName") + "','%') ");
		}
		if ((int)params.get("roleBean") != 0) {
			sb.append("and r.role_type =" + params.get("roleBean") + " ");
		}
		sb.append("limit " + params.get("index") + "," + params.get("rows"));

		return sb.toString();

	}
}
