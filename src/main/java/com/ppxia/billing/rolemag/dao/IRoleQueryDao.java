package com.ppxia.billing.rolemag.dao;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.RoleBean;

public interface IRoleQueryDao {
	public PagerBean findRoleByParams( PagerBean pager,Map params);
	
	public RoleBean findRoleByRoleName(String roleName);
	
	public RoleBean findRoleByUserName(String userName);
	
	/**
	 * 通过角色ID查询角色对象
	 * @param id
	 * @return
	 */
	public RoleBean findRoleByRoleId(Long id);
}
