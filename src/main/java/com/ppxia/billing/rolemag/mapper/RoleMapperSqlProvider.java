package com.ppxia.billing.rolemag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;

public class RoleMapperSqlProvider {
	
	public String queryRoleBeanByParams(Map<String, Object> params) {
		StringBuilder sb = new StringBuilder("select * from t_role where 1=1");
          if(!StringUtils.isEmpty(params.get("roleName"))) {
        	  sb.append(" and role_name like '"+params.get("roleName")+"%'");
          }
          if(!StringUtils.isEmpty(params.get("roleType"))) {
        	  sb.append(" and role_type like '"+params.get("roleType")+"%'");
          }
          sb.append(" limit "+params.get("index")+" ,10");

		return sb.toString();
	}
	
	public String queryTotalRoleByParams(Map<String, Object> params) {
		StringBuilder sb = new StringBuilder(
       "select count(id) from t_role where 1=1 ");
          if(!StringUtils.isEmpty(params.get("roleName"))) {
        	  sb.append("and role_name like '"+params.get("roleName")+"%' ");
          }
          if(!StringUtils.isEmpty(params.get("roleType"))) {
        	  sb.append("and role_type like '"+params.get("roleType")+"%' ");
          }

		return sb.toString();
	}
}
