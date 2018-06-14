package com.ppxia.billing.rolemag.mapper;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface RoleMapper {
	public PagerBean findRoleByParams( PagerBean pager,Map params);
}
