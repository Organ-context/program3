package com.ppxia.billing.rolemag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;

public class RoleMapperSqlProvider {
	
	public String queryRoleBeanByParams(Map<String, Object> params) {
		Map map = (Map) params.get("map");
		StringBuilder sb = new StringBuilder("select * from t_role where 1=1");
          if(!StringUtils.isEmpty(map.get("roleName"))) {
        	  sb.append("and role_name like '"+map.get("roleName")+"%'");
          }
          if(!StringUtils.isEmpty(map.get("roleType"))) {
        	  sb.append("and role_type like '"+map.get("roleType")+"%'");
          }
          sb.append("limit "+map.get("index")+" ,10");

		return sb.toString();
	}
	
	public String queryTotalRoleByParams(Map<String, Object> params) {
		Map map = (Map) params.get("map");
		StringBuilder sb = new StringBuilder(
       "select * from t_role where 1=1");
          if(!StringUtils.isEmpty(map.get("roleName"))) {
        	  sb.append("and role_name like '"+map.get("roleName")+"%'");
          }
          if(!StringUtils.isEmpty(map.get("roleType"))) {
        	  sb.append("and role_type like '"+map.get("roleType")+"%'");
          }

		return sb.toString();
	}
}
