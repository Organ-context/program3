package com.ppxia.billing.logmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.ppxia.billing.beans.OperateLogBean;

public interface OperatelogMapper {
	
	/**
	 * 
	 * @param map
	 */
	@SelectProvider(type=OperateLogMapperSqlProvider.class,method="findAllByNum")
	public int findAllByNum(@Param("map")Map map);

	/**
	 * 
	 * @param map
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="operateManagerName",column="operate_manager_name",javaType=String.class),
		@Result(property="operateManagerType",column="operate_manager_type",javaType=String.class),
		@Result(property="operateTime",column="operate_time",javaType=java.util.Date.class),
		@Result(property="systemModel",column="system_model",javaType=String.class),
		@Result(property="operateOperation",column="operate_operation",javaType=String.class)
	})
	@SelectProvider(type=OperateLogMapperSqlProvider.class,method="findPagerByOperateLogBean")
	public List<OperateLogBean> findPagerByOperateLogBean(@Param("map")Map map);

}