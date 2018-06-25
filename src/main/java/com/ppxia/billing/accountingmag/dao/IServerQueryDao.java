package com.ppxia.billing.accountingmag.dao;

import java.util.List;

import com.ppxia.billing.beans.ServerBean;

public interface IServerQueryDao {
	
	/**
	 * 根据ID查询服务器对象
	 * @param id
	 * @return
	 */
	public ServerBean findServerById(Long id);
	
	/**
	 * 获取全部服务器对象
	 * @return
	 */
	public List<ServerBean> findAllServer();
}
