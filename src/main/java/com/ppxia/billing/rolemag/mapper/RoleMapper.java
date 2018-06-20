package com.ppxia.billing.rolemag.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.ppxia.billing.beans.RoleBean;

public interface RoleMapper {
	
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property = "roleName", column = "role_name", javaType = String.class),
		@Result(property = "roleType", column = "role_type", javaType = Integer.class),
		@Result(property="authoritys",column="id",javaType=Set.class,many=@Many(fetchType=FetchType.LAZY,select="com.ppxia.billing.authortymag.mapper.AuthorityMapper.findAuthorityById"))
	})
	@SelectProvider(type=RoleMapperSqlProvider.class,method="queryRoleBeanByParams")
	public List<RoleBean> findRoleByParams(Map params);
	
	@SelectProvider(type=RoleMapperSqlProvider.class,method="queryTotalRoleByParams")
	public int findTotalNumByParams(Map params);
	
	@Select("select id from t_role where role_name = {#roleName}")
	public int findRoleIdByRoleName(String roleName);
}
