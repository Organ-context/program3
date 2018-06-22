package com.ppxia.billing.logmag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;

public class LoginlogMapperSqlProvider {

	public String findAllByNum(Map<String, Object> map) {

		Map<String, Object> param1 = (Map<String, Object>) map.get("param1");
		StringBuilder sb = new StringBuilder("select count(*) from t_login_log where 1=1 ");
		if ((param1.get("managername") != null
				&& StringUtils.hasLength(((String) param1.get("managername")).trim()))) {
			sb.append("and login_manager_name like '" + param1.get("managername") + "%'");
		} else if ((param1.get("startingtime") != null)) {
			sb.append("and login_operate_time > '" + param1.get("startingtime")+"'");
		} else if ((param1.get("endtime") != null)) {
			sb.append("and login_operate_time < '" + param1.get("endtime")+"'");
		}
		return sb.toString();
	}

	public String findPagerByLoginlogBean(Map<String, Object> map) {
		
		Map<String, Object> param1 = (Map<String, Object>) map.get("param1");
		StringBuilder sb = new StringBuilder("select * from t_login_log where 1=1 ");
		if ((param1.get("managername") != null
				&& StringUtils.hasLength(((String) param1.get("managername")).trim()))) {
			sb.append("and login_manager_name like '" + param1.get("managername") + "%'");
		} else if ((param1.get("startingtime") != null)) {
			sb.append("and login_operate_time > '" + param1.get("startingtime")+"'");
		} else if ((param1.get("endtime") != null)) {
			sb.append("and login_operate_time < '" + param1.get("endtime")+"'");
		}
		sb.append(" limit " + param1.get("index") + "," + param1.get("rows"));
		return sb.toString();
	}

}
