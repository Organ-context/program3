package com.ppxia.billing.logmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.ppxia.billing.beans.LoginLogBean;

public interface LoginlogMapper {
/**
	 * 
	 * @param map
	 */
	@SelectProvider(type=LoginlogMapperSqlProvider.class,method="findAllByNum")
	public int findAllByNum(@Param("map")Map map);

	/**
	 * 
	 * @param map
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="LoginManagerName",column="login_manager_name",javaType=String.class),
		@Result(property="login_manager_type",column="LoginManagerType",javaType=String.class),
		@Result(property="LoginOperateTime",column="login_operate_time",javaType=Date.class),
		@Result(property="ip",column="ip",javaType=String.class),
		@Result(property="LoginOperation",column="login_operation",javaType=String.class)
	})
	@SelectProvider(type=LoginlogMapperSqlProvider.class,method="findPagerByLoginlogBean")
	public List<LoginLogBean> findPagerByLoginlogBean(@Param("map")Map map);
	
}