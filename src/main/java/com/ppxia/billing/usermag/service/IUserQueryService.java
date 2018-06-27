package com.ppxia.billing.usermag.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.RoleBean;
import com.ppxia.billing.beans.UserBean;

public interface IUserQueryService {
	
	/**
	 * 模糊搜索得到分页对象
	 * @param map
	 */
	public PagerBean findUserByParams2Pager(Map params,PagerBean pager);

	/**
	 * 根据id查询
	 * @param id
	 */
	public UserBean getUser(long id);
	
	/**
	 * 	通过名字查询用户信息
	 * @param username
	 * @return
	 */
	public UserBean findUserByName(String username);
	

	
}
