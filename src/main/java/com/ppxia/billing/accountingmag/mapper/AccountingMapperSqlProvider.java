package com.ppxia.billing.accountingmag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;

public class AccountingMapperSqlProvider {
	
	//查询满足条件的具体数据
	public String findByParams(Map<String, Object> map) {
		Map params = (Map) map.get("params");
		StringBuilder sb = new StringBuilder(
				"select user_name,user_accounting_name,user_accounting_state,user_address from t_user where (1=1) ");
		//获得条件姓名
		String userName = params.get("userName").toString();
		if(StringUtils.hasLength(userName)) {
			sb.append("and u.user_name like CONCAT('"+userName+"','%') ");
		}
		
		//获得条件账务账号
		String userAccountingName = params.get("userAccountingName").toString();
		if(StringUtils.hasLength(userAccountingName)) {
			sb.append("and u.user_accounting_name like CONCAT('"+userAccountingName+"','%') ");
		}
		return sb.toString();
	}
	
	
	//查询满足条件的具体数据
		public String findAccountByAll(Map<String, Object> map) {
			Map params = (Map) map.get("params");
			StringBuilder sb = new StringBuilder(
					"select count(id) from t_user where (1=1) ");
			//获得条件姓名
			String userName = params.get("userName").toString();
			if(StringUtils.hasLength(userName)) {
				sb.append("and u.user_name like CONCAT('"+userName+"','%') ");
			}
			
			//获得条件账务账号
			String userAccountingName = params.get("userAccountingName").toString();
			if(StringUtils.hasLength(userAccountingName)) {
				sb.append("and u.user_accounting_name like CONCAT('"+userAccountingName+"','%') ");
			}
			return sb.toString();
		}
}
