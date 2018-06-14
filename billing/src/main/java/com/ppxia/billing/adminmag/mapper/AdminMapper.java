package com.ppxia.billing.adminmag.mapper;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface AdminMapper {
	//模糊查询管理员分页对象
		public PagerBean findAdminByParams(PagerBean pager,Map params);
}
