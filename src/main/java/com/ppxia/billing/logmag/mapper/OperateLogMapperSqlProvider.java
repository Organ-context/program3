package com.ppxia.billing.logmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.util.StringUtils;

import com.ppxia.billing.beans.OperateLogBean;

public class OperateLogMapperSqlProvider {
	
	public String findAllByNum(Map<String, Object> map) {

		Map<String, Object> param1 = (Map<String, Object>) map.get("param1");
		StringBuilder sb = new StringBuilder("select count(*) from t_operate_log where 1=1 ");
		if ((param1.get("OperateManagerName") != null
				&& StringUtils.hasLength(((String) param1.get("OperateManagerName")).trim()))) {
			sb.append("and operate_manager_name like '" + param1.get("OperateManagerName") + "%'");
		} else if ((param1.get("startingtime") != null)) {
			sb.append("and operate_time > '" + param1.get("startingtime"));
		} else if ((param1.get("endtime") != null)) {
			sb.append("and operate_time < '" + param1.get("endtime"));
		}
		return sb.toString();
		





	}

	public String findPagerByOperateLogBean(Map<String, Object> map) {
		Map<String, Object> param1 = (Map<String, Object>) map.get("param1");
		StringBuilder sb = new StringBuilder("select * from t_operate_log where 1=1 ");
		if ((param1.get("OperateManagerName") != null
				&& StringUtils.hasLength(((String) param1.get("OperateManagerName")).trim()))) {
			sb.append("and operate_manager_name like '" + param1.get("OperateManagerName") + "%'");
		} else if ((param1.get("startingtime") != null)) {
			sb.append("and operate_time > '" + param1.get("startingtime"));
		} else if ((param1.get("endtime") != null)) {
			sb.append("and operate_time < '" + param1.get("endtime"));
		}
		sb.append(" limit "+param1.get("index")+","+param1.get("rows"));
		return sb.toString();
	}
	
}
