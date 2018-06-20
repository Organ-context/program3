package com.ppxia.billing.logmag.mapper;

import java.util.Map;

import org.springframework.*;
import org.springframework.util.StringUtils;

public class LoginlogMapperSqlProvider {
	
	
	public String findAllByNum(Map<String, Object> params) {
		Map<String, Object> map = (Map<String, Object>) params.get("params");
			StringBuilder sb = new StringBuilder("select count(*) from t_login_log as l where 1=1 ");
			if ((map.get("LoginManagerName")!=null  && StringUtils.hasLength(((String) params.get("LoginManagerName")).trim()))) {
				sb.append("and l.login_manager_name like '"+map.get("LoginManagerName")+"%'");
			}else if ((map.get("startingtime")!=null)) {
				sb.append("and l.login_operate_time > '"+map.get("startingtime"));
			}else if ((map.get("endtime")!=null)) {
				sb.append("and l.login_operate_time < '"+map.get("endtime"));
			}
	        return sb.toString();
	}
	
	public String findPagerByLoginlogBean(Map<String, Object> params) {
		Map<String, Object> map = (Map<String, Object>) params.get("map");
		StringBuilder sb = new StringBuilder("select * from t_login_log where 1=1 ");
		if ((map.get("LoginManagerName")!=null  && StringUtils.hasLength(((String) params.get("LoginManagerName")).trim()))) {
			sb.append("and l.login_manager_name like '"+map.get("LoginManagerName")+"%'");
		}else if ((map.get("startingtime")!=null)) {
			sb.append("and l.login_operate_time > '"+map.get("startingtime"));
		}else if ((map.get("endtime")!=null)) {
			sb.append("and l.login_operate_time < '"+map.get("endtime"));
		}
		sb.append(" limit "+map.get("index")+","+map.get("rows"));
		return sb.toString();
	}
	
//	  //总数--模糊查询
//	public String countLoginlogByParams(Map map) {
//        Map<String, Object> params = (Map<String, Object>) map.get("params");
//		StringBuilder sb = new StringBuilder("select count(*) from t_login_log as l where 1=1 ");
//		if ((params.get("LoginManagerName")!=null  && StringUtils.hasLength(((String) params.get("LoginManagerName")).trim()))) {
//			sb.append("and l.login_manager_name like '"+params.get("LoginManagerName")+"%'");
//		}else if ((params.get("startingtime")!=null)) {
//			sb.append("and l.login_operate_time > '"+params.get("startingtime"));
//		}else if ((params.get("endtime")!=null)) {
//			sb.append("and l.login_operate_time < '"+params.get("endtime"));
//		}
//        return sb.toString();
//	}
//	//集合
//	public String findPagerByLoginlogBean(Map map) {
//		Map<String, Object> params  = (Map<String, Object>) map.get("params");
//		StringBuilder sb = new StringBuilder("select * from t_login_log as l where 1=1 ");
//		if ((params.get(" LoginManagerName")!=null && StringUtils.hasLength(((String) params.get("LoginManagerName")).trim()))) {
//			sb.append("and  l.login_manager_name  like '"+params.get(" LoginManagerName")+"%'");
//        }else if ((params.get("startingtime")!=null)) {
//			sb.append("and l.login_operate_time > '"+params.get("startingtime"));
//		}else if ((params.get("endtime")!=null)) {
//			sb.append("and l.login_operate_time < '"+params.get("endtime"));
//		}
//		sb.append(" limit "+params.get("index")+","+params.get("rows"));
//		return sb.toString();
//	}


	
	
}
