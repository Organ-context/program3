package com.ppxia.billing.accountingmag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;

public class AccountingMapperSqlProvider {
	
	//查询满足条件的具体数据
	public String findByParams(Map<String, Object> map) {
		Map<String, Object> params = (Map<String, Object>) map.get("params");
		StringBuilder sb = new StringBuilder("select id, user_name,user_accounting_name,user_accounting_state,user_address from t_user where (1=1) ");
		//获得条件姓名
		String userName = params.get("userName").toString();
		if(StringUtils.hasLength(userName)) {
			sb.append("and user_name like CONCAT('"+userName+"','%') ");
		}
		
		//获得条件账务账号
		String userAccountingName = params.get("userAccountingName").toString();
		if(StringUtils.hasLength(userAccountingName)) {
			sb.append("and user_accounting_name like CONCAT('"+userAccountingName+"','%') ");
		}

		//设置查询数量
		sb.append("limit "+params.get("index")+","+params.get("limit"));
		return sb.toString();
	}
	
	
	//查询满足条件的全部数量
		public String findAccountByAll(Map<String, Object> map) {
			StringBuilder sb = new StringBuilder(
					"select count(id) from t_user where (1=1) ");
			//获得条件姓名
			String userName = map.get("userName").toString();
			if(StringUtils.hasLength(userName)) {
				sb.append("and user_name like CONCAT('"+userName+"','%') ");
			}
			
			//获得条件账务账号
			String userAccountingName = map.get("userAccountingName").toString();
			if(StringUtils.hasLength(userAccountingName)) {
				sb.append("and user_accounting_name like CONCAT('"+userAccountingName+"','%') ");
			}
			
			return sb.toString();
		}
}
