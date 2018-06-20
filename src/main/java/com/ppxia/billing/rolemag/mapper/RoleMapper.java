package com.ppxia.billing.rolemag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.RoleBean;

public interface RoleMapper {
	
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result()
	})
	public List<RoleBean> findRoleByParams(Map params);
	
	public int findTotalNumByParams(Map params);
}
