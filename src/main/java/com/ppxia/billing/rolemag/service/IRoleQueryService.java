package com.ppxia.billing.rolemag.service;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IRoleQueryService {
	public PagerBean findRoleByParams( PagerBean pager,Map params);
}
