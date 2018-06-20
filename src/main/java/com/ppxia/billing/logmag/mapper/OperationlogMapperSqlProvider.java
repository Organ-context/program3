package com.ppxia.billing.logmag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;

public class OperationlogMapperSqlProvider {
public String findAllByNum(Map<String, Object> params) {
		Map<String, Object> map = (Map<String, Object>) params.get("map");
		StringBuilder sb = new StringBuilder("select count(*) from t_operation_log where 1=1 ");
		if ((params.get("OperateManagerName")!=null && StringUtils.hasLength(((String) params.get("OperateManagerName")).trim()))) {
		sb.append("and l.login_manager_name like '"+params.get("LoginManagerName")+"%'");
		}else if ((params.get("startingtime")!=null)) {
			sb.append("and l.operate_time > '"+params.get("startingtime"));
		}else if ((params.get("endtime")!=null)) {
			sb.append("and l.operate_time < '"+params.get("endtime"));
		}
		
		return sb.toString();
	}
	public String findPagerByOperationLogBean(Map<String, Object> params) {
		Map<String, Object> map = (Map<String, Object>) params.get("map");
		StringBuilder sb = new StringBuilder("select * from t_operation_log where 1=1 ");
		if ((params.get("OperateManagerName")!=null && StringUtils.hasLength(((String) params.get("OperateManagerName")).trim()))) {
			sb.append("and l.login_manager_name like '"+params.get("LoginManagerName")+"%'");
		}else if ((params.get("startingtime")!=null)) {
				sb.append("and l.operate_time > '"+params.get("startingtime"));
		}else if ((params.get("endtime")!=null)) {
				sb.append("and l.operate_time < '"+params.get("endtime"));
		}
		sb.append(" limit "+map.get("index")+","+map.get("rows"));
		return sb.toString();
	}
	//模糊查询--总数
//	public String countOpertionlogByParams(Map map) {
//		Map<String, Object> params = (Map<String, Object>) map.get("params");
//		StringBuilder sb = new StringBuilder(
//				"select count(*) from t_operation_log where 1=1 ");
//		if ((params.get("OperateManagerName")!=null && StringUtils.hasLength(((String) params.get("OperateManagerName")).trim()))) {
//		sb.append("and l.login_manager_name like '"+params.get("LoginManagerName")+"%'");
//		}else if ((params.get("startingtime")!=null)) {
//			sb.append("and l.operate_time > '"+params.get("startingtime"));
//		}else if ((params.get("endtime")!=null)) {
//			sb.append("and l.operate_time < '"+params.get("endtime"));
//		}
//        return sb.toString();
//	}
//	
//
//
//		
//	//集合
//	public String findPagerByOperationLogBean(Map map) {
//		Map<String, Object> params  = (Map<String, Object>) map.get("params");
//        StringBuilder sb = new StringBuilder(
//				"select count(*) from t_operation_log where 1=1 ");
//		if ((params.get("OperateManagerName")!=null && StringUtils.hasLength(((String) params.get("OperateManagerName")).trim()))) {
//		sb.append("and l.login_manager_name like '"+params.get("LoginManagerName")+"%'");
//		}else if ((params.get("startingtime")!=null)) {
//			sb.append("and l.operate_time > '"+params.get("startingtime"));
//		}else if ((params.get("endtime")!=null)) {
//			sb.append("and l.operate_time < '"+params.get("endtime"));
//		}
//		sb.append(" limit "+params.get("index")+","+params.get("rows"));
//        return sb.toString();
//	}
//

	//分页
//	//管理员名称 管理员级别 操作时间  系统模块  行为
//	public String findPagerByOperationLogBean(Map<String, Object> params) {
//		Map<String, Object> map = (Map<String, Object>) params.get("map");
//		StringBuilder sb = new StringBuilder("select * from t_operation_log where 1=1 ");
//		if ((map.get("OperateManagerName")!=null)) {
//			sb.append("and operate_manager_name like '"+map.get("OperateManagerName")+"%'");
//		}else if ((map.get("start")!=null)) {
//			sb.append("and operate_time > '"+map.get("start"));
//		}else if ((map.get("end")!=null)) {
//			sb.append("and operate_time < '"+map.get("end"));
//		}else if ((map.get("SystemModel")!=null)) {
//			sb.append("and system_model > '"+map.get("start"));
//		}else if ((map.get(" OperateOperation")!=null)) {
//			sb.append("and operate_operation < '"+map.get("end"));
//		}
//		sb.append(" limit "+map.get("begin")+","+map.get("rows"));
//		return sb.toString();
//	}

}
