package com.ppxia.billing.rolemag.service;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.RoleBean;

public interface IRoleQueryService {
	public PagerBean findRoleByParams( PagerBean pager,Map params);
	
	/**
	 * 通过用户名查询角色对象
	 * @param userName
	 * @return 该用户名对应的角色对象
	 */
	public RoleBean findRoleByUserName(String userName);
	
	/**
	 * 通过角色ID查询角色对象
	 * @param id
	 * @return
	 */
	public RoleBean findRoleByRoleId(Long id);
}
