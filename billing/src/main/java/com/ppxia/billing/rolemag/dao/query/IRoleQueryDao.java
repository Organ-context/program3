package com.ppxia.billing.rolemag.dao.query;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IRoleQueryDao {
	public PagerBean findRoleByParams( PagerBean pager,Map params);
}
