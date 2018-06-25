package com.ppxia.billing.accountingmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.ppxia.billing.beans.ServerBean;

public interface ServerMapper {
	
	@ResultType(ServerBean.class)
	@Select("select * from t_server where id = #{id}")
	public ServerBean findServerById(Long id);
	
	@ResultType(ServerBean.class)
	@Select("select * from t_server")
	public List<ServerBean> findAllServer();
}
