package com.ppxia.billing.usermag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.ppxia.billing.beans.RoleBean;
import com.ppxia.billing.beans.UserBean;

/**
 * @author Administrator
 * @version 1.0
 * @created 13-6��-2018 16:34:40
 */
public interface UserMapper {

	/**
	 * 
	 * @param id
	 *            根据id 查询 管理员 以及管理员的角色
	 */
	// 查询客户
	@Results({ @Result(id = true, property = "id", column = "id", javaType = Long.class),
			@Result(property = "userName", column = "user_name", javaType = String.class),
			@Result(property = "userAccountingName", column = "user_accounting_name", javaType = String.class),
			@Result(property = "roleBean", column = "fk_role_id", javaType = RoleBean.class, one = @One(fetchType = FetchType.LAZY, select = "getRoleById")) })
	@Select("select * from t_user where id=#{id}")
	public UserBean getManager(long id);

	@ResultType(RoleBean.class)
	@Select("select id as id , role_name  as name from t_role where id=#{id}")
	public RoleBean getRoleById(long id);

	/**
	 * 根据参数查询管理员总数
	 * 
	 * @param params
	 *            页面参数
	 * @return 返回管理员总数
	 * 
	 */
	@SelectProvider(type = UserMapperSqlProvider.class, method = "countManagerByParams")
	public int countManagerByParams(@Param("params") Map params);

	/**
	 * 根据参数查询管理员集合
	 * 
	 * @param params
	 *            页面参数
	 * @return 返回分页的管理员集合
	 */
	@Results({ @Result(id = true, property = "id", column = "id", javaType = Long.class),
			@Result(property = "userName", column = "user_name", javaType = String.class),
			@Result(property = "userAccountingName", column = "user_accounting_name", javaType = String.class),
			@Result(property = "roleBean", column = "fk_role_id", javaType = RoleBean.class, one = @One(fetchType = FetchType.LAZY, select = "getRoleById")) })
	@SelectProvider(type = UserMapperSqlProvider.class, method = "findManagerByParams")
	public List<UserBean> findManagerByParams(@Param("params") Map params);

}