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
	
	@Results({ @Result(id = true, property = "id", column = "id", javaType = Long.class),
			@Result(property = "userName", column = "user_name", javaType = String.class),
			@Result(property = "userAccountingName", column = "user_accounting_name", javaType = String.class),
			@Result(property = "userPassword", column = "user_password", javaType = String.class),
			@Result(property = "email", column = "user_email", javaType = String.class),
			@Result(property = "telephone", column = "user_telephone", javaType = Long.class),
			@Result(property = "roleBean", column = "fk_role_id", javaType = RoleBean.class, one = @One(fetchType = FetchType.LAZY, select = "com.ppxia.billing.usermag.mapper.UserMapper.getRoleById")) })
	@Select("select * from t_user where id=#{id}")
	public UserBean getManager(long id);

	
	/**
	 * 根据id查角色信息
	 * @param id
	 * @return
	 */
	@ResultType(RoleBean.class)
	@Select("select id as id , role_name  as roleName , role_type as roleType from t_role where id=#{id}")
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
			@Result(property = "email", column = "user_email", javaType = String.class),
			@Result(property = "telephone", column = "user_telephone", javaType = Long.class),
//			@Result(property = "roleBean", column = "fk_role_id", javaType = RoleBean.class, one = @One(fetchType = FetchType.LAZY, select = "getRoleById")) })
			@Result(property = "roleBean.roleName", column = "roleName", javaType = String.class) })
	@SelectProvider(type = UserMapperSqlProvider.class, method = "findManagerByParams")
	public List<UserBean> findManagerByParams(@Param("params") Map params);
	
	
	
	
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(id=true,property="userName",column="user_name",javaType=String.class),
		@Result(id=true,property="userPassword",column="user_password",javaType=String.class)
	})
	@Select("select id,user_name,user_password from t_user where user_name=#{username}")
	public UserBean findUserByName(@Param("username")String username);
	
	/**
	 * 通过用户姓名查找用户角色
	 * @param username
	 * @return
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(id=true,property="roleName",column="role_name",javaType=String.class),
		@Result(id=true,property="roleType",column="role_type",javaType=Integer.class)
	})
	@Select("select * from t_role r left join t_user u on r.id = u.fk_role_id where u.user_name = #{username}")
	public RoleBean findRoleByUsername(@Param("username")String username);
}