package com.ppxia.billing.logmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.ppxia.billing.beans.OperateLogBean;

public interface OperatelogMapper {
	
	/**
	 * 
	 * @param map
	 */
	@SelectProvider(type=OperationlogMapperSqlProvider.class,method="findAllByNum")
	public int findAllByNum(@Param("map")Map map);

	/**
	 * 
	 * @param map
	 */
	@ResultType(value=OperateLogBean.class)
	@SelectProvider(type=OperationlogMapperSqlProvider.class,method="findPagerByOperationLogBean")
	public List<OperateLogBean> findPagerByOperationLogBean(@Param("map")Map map);

}