package com.ppxia.billing.usermag.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.RoleBean;
import com.ppxia.billing.beans.UserBean;



public interface IUserQueryDao {
	/**
	 * 
	 * @param id
	 * @param map
	 */
	public UserBean getUser(long id);
	/**
	 * 根据参数查询管理员总数
	 * @param params 页面参数
	 * @return 返回管理员总数
	 */
	public int countUserByParams(Map params);
	
	/**
	 * 根据参数查询管理员集合
	 * @param params 页面参数
	 * @return 返回分页的管理员集合
	 */
	public List<UserBean> findUserByParams(Map params);
	
	/**
	 * 	通过名字查询用户信息
	 * @param username
	 * @return
	 */
	public UserBean findUserByName(String username);
	
	/**
	 * 通过用户姓名查找用户角色
	 * @param username
	 * @return
	 */
	public RoleBean findRoleByUsername(String username);
}
