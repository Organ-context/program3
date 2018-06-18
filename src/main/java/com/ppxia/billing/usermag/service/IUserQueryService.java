package com.ppxia.billing.usermag.service;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;
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
}
