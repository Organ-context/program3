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
//	
//	@SelectProvider(type=OperationlogMapperSqlProvider.class,method="findAllByNum")
//	public int findAllByNum(@Param("map")Map map);
//
//	/**
//	 * 
//	 * @param map
//	 */
//	@ResultType(value=OperationLogBean.class)
//	@SelectProvider(type=OperationlogMapperSqlProvider.class,method="findPagerByOperationLogBean")
//	public List<OperationLogBean> findPagerByOperationLogBean(@Param("map")Map map);
//	
//	// 查询登录
//		@Results({ @Result(id = true, property = "id", column = "id", javaType = Long.class),
//				@Result(property = "LoginManagerName", column = "login_manager_name", javaType = String.class),
//				@Result(property = "LoginManagerType", column = "login_manager_type", javaType = String.class),
//				@Result(property = "LoginOperateTime", column = "login_operate_time", javaType = Data.class),
//				@Result(property = "ip", column = "ip", javaType = String.class),
//				@Result(property = "LoginOperation", column = "login_operation", javaType = String.class),
//		})
//		@Select("select * from t_operate_log where id=#{id}")
//		public OperateLogBean getOperateLogBeanById(long id);
//		
//		
//		
//		@ResultType(LoginLogBean.class)
//		@Select("select id as id , operate_manager_name  as name from t_operate_log where id=#{id}")
//		public OperateLogBean getOperateLogById2(long id);
//		
//		/**
//		 * 根据参数查询登录日志总数
//		 * @param map   页面参数
//		 * @return    返回登录日志总数
//		 */
//		@SelectProvider(type=OperationlogMapperSqlProvider.class,method="countOpertionlogByParams")
//		public int findAllByParams(@Param("params")Map params);
//	    
//		
//		//登录日志集合
//		@Results({ @Result(id = true, property = "id", column = "id", javaType = Long.class),
//			@Result(property = "OperateManagerName", column = "operate_manager_name", javaType = String.class),
//			@Result(property = "OperateManagerType", column = "operate_manager_type", javaType = String.class),
//			@Result(property = "OperateTime", column = "operate_time", javaType = Date.class),
//			@Result(property = "SystemModel", column = "system_model", javaType = Integer.class),
//			@Result(property = "OperateOperation", column = "operate_operation", javaType = String.class),
//       })
//		@ResultType(value=OperateLogBean.class)
//		@SelectProvider(type=OperationlogMapperSqlProvider.class,method="findPagerByOperationLogBean")
//		public List<OperateLogBean> findPagerByOperateLogBean(@Param("params")Map params);


	
//	/**
//	 * 
//	 * @param map
//	 */
//	@SelectProvider(type=OperationlogMapperSqlProvider.class,method="findAllByNum")
//	public int findAllByNum(@Param("map")Map map);
//
//	/**
//	 * 
//	 * @param map
//	 */
//	@ResultType(value=OperateLogBean.class)
//	@SelectProvider(type=OperationlogMapperSqlProvider.class,method="findPagerByOperationLogBean")
//	public List<OperateLogBean> findPagerByOperationLogBean(@Param("map")Map map);
//
//	
//	
//	
//	
//	/**
//	 * 
//	 * @param id
//	 *            根据id 查询 管理员 以及管理员的角色
//	 */
//	// 查询客户
//	@Results({ @Result(id = true, property = "id", column = "id", javaType = Long.class),
//			@Result(property = "OperateManagerName", column = "operate_manager_name", javaType = String.class),
//			@Result(property = "OperateManagerType", column = "operate_manager_type", javaType = String.class),
//			@Result(property = "OperateTime", column = "operate_time", javaType = Date.class),
//			@Result(property = "SystemModel", column = "system_model", javaType = Integer.class),
//			@Result(property = "OperateOperation", column = "operate_operation", javaType = String.class),
//       })
//	@Select("select * from t_operate_log where id=#{id}")
//	public OperateLogBean getManager(long id);
//
//	@ResultType(OperateLogBean.class)
//	@Select("select id as id , operate_manager_name  as name from t_operate_log where id=#{id}")
//	public OperateLogBean getOperateLogBeanById(long id);
//
//	/**
//	 * 根据参数查询管理员总数
//	 * 
//	 * @param params
//	 *            页面参数
//	 * @return 返回管理员总数
//	 * 
//	 */
//	@SelectProvider(type = OperationlogMapperSqlProvider.class, method = "countByParams")
//	public int countManagerByParams(@Param("params") Map params);
//
//	/**
//	 * 根据参数查询管理员集合
//	 * 
//	 * @param params
//	 *            页面参数
//	 * @return 返回分页的管理员集合
//	 * 管理员名称 管理员级别 操作时间  系统模块  行为
//	 */
//	@Results({ @Result(id = true, property = "id", column = "id", javaType = Long.class),
//			@Result(property = "OperateManagerName", column = "operate_manager_name", javaType = String.class),
//			@Result(property = "OperateManagerType", column = "operate_manager_type", javaType = String.class),
//			@Result(property = " OperateTime", column = "operate_time", javaType = Date.class),
//			@Result(property = "SystemModel", column = "system_model", javaType = String.class),
//			@Result(property = "OperateOperation", column = "operate_operation", javaType =Integer.class),
//			@Result(property = "userAccountingName", column = "user_accounting_name", javaType = String.class),
//	
//	})
//	@SelectProvider(type = OperationlogMapperSqlProvider.class, method = "findPagerByOperationLogBean")
//	public List<OperateLogBean> findOperateLogBeanByParams(@Param("params") Map params);

}