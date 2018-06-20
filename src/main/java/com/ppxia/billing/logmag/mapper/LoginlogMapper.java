package com.ppxia.billing.logmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.mysql.fabric.xmlrpc.base.Data;
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
	@ResultType(value=LoginLogBean.class)
	@SelectProvider(type=LoginlogMapperSqlProvider.class,method="findPagerByLoginlogBean")
	public List<LoginLogBean> findPagerByLoginlogBean(@Param("map")Map map);
	
	
	
	
	
//	/**
//	 * 
//	 * @param id
//	 *  根据id查询 得到登陆者的信息
//	 */
//	// 查询登录
//	@Results({ @Result(id = true, property = "id", column = "id", javaType = Long.class),
//			@Result(property = "LoginManagerName", column = "login_manager_name", javaType = String.class),
//			@Result(property = "LoginManagerType", column = "login_manager_type", javaType = String.class),
//			@Result(property = "LoginOperateTime", column = "login_operate_time", javaType = Data.class),
//			@Result(property = "ip", column = "ip", javaType = String.class),
//			@Result(property = "LoginOperation", column = "login_operation", javaType = String.class),
//	})
//	@Select("select * from t_login_log where id=#{id}")
//	public LoginLogBean getLoginLogBeanById(long id);
//	
//	
//	
//	@ResultType(LoginLogBean.class)
//	@Select("select id as id , login_manager_name  as name from t_login_log where id=#{id}")
//	public LoginLogBean getLoginLogBeanById2(long id);
//	
//	/**
//	 * 根据参数查询登录日志总数
//	 * @param map   页面参数
//	 * @return    返回登录日志总数
//	 */
//	@SelectProvider(type=LoginlogMapperSqlProvider.class,method="countLoginlogByParams")
//	public int findAllByParams(@Param("params")Map params);
//    
//	
//	//登录日志集合
//	@Results({ @Result(id = true, property = "id", column = "id", javaType = Long.class),
//		@Result(property = "LoginManagerName", column = "login_manager_name", javaType = String.class),
//		@Result(property = "LoginManagerType", column = "login_manager_type", javaType = String.class),
//		@Result(property = "LoginOperateTime", column = "login_operate_time", javaType = Data.class),
//		@Result(property = "ip", column = "ip", javaType = String.class),
//		@Result(property = "LoginOperation", column = "login_operation", javaType = String.class),
//})
//	@ResultType(value=LoginLogBean.class)
//	@SelectProvider(type=LoginlogMapperSqlProvider.class,method="findPagerByLoginlogBean")
//	public List<LoginLogBean> findPagerByLoginlogBean(@Param("params")Map params);
//
//
//
//
//    
//	
//
//	/**
//	 * 根据参数查询登陆者总数
//	 * 
//	 * @param params  页面参数
//	 *            
//	 * @return 返回登陆者总数
//	 * 
//	 */
//	@SelectProvider(type = LoginlogMapperSqlProvider.class, method = "countLoginlogByParams")
//	public int countLoginLogBeanByParams(@Param("params") Map params);
//
//	/**
//	 * 根据参数查询登陆者集合
//	 * @param params 页面参数
//     * @return 返回分页的登陆者集合
//	 */
//	@Results({ @Result(id = true, property = "id", column = "id", javaType = Long.class),
//			@Result(property = "LoginManagerName", column = "login_manager_name", javaType = String.class),
//			@Result(property = "LoginManagerType", column = "login_manager_type", javaType = String.class),
//			@Result(property = "LoginOperateTime", column = "login_operate_time", javaType = Data.class),
//			@Result(property = "ip", column = "ip", javaType = String.class),
//			@Result(property = "LoginOperation", column = "login_operation", javaType = String.class)
//        })
//	@SelectProvider(type = LoginlogMapperSqlProvider.class, method = "findPagerByLoginlogBean")
//	public List<LoginLogBean> findManagerByParams(@Param("params") Map params);
//
//	

}