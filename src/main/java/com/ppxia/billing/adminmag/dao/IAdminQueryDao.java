package com.ppxia.billing.adminmag.dao;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IAdminQueryDao {
	//模糊查询管理员分页对象
	public PagerBean findAdminByParams(PagerBean pager,Map params);
}
