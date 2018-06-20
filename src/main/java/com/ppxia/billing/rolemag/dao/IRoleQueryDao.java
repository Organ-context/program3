package com.ppxia.billing.rolemag.dao;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.RoleBean;

public interface IRoleQueryDao {
	public PagerBean findRoleByParams( PagerBean pager,Map params);
	
	public int findRoleByRoleName(String roleName);
}
