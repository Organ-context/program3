package com.ppxia.billing.accountingmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.ppxia.billing.beans.UserBean;


public interface AccountingMapper {
	
	
	
	// 查询所有账务满足条件的总条数
	@ResultType(UserBean.class)
	@SelectProvider(type=AccountingMapperSqlProvider.class,method="findByParams")
	public int findByParams(@Param("params")Map params);

	// 查询分页的满足条件的所有具体数据
	
	@SelectProvider(type=AccountingMapperSqlProvider.class,method="findAccountByAll")
	public List<UserBean> findByAll(@Param("params")Map params);

}
