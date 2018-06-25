package com.ppxia.billing.accountingmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.accountingmag.dao.IServerQueryDao;
import com.ppxia.billing.accountingmag.mapper.ServerMapper;
import com.ppxia.billing.beans.ServerBean;

@Repository
public class ServerQueryDaoImpl implements IServerQueryDao {

	@Resource
	private ServerMapper serverMapper;
	
	@Override
	public ServerBean findServerById(Long id) {
		// TODO Auto-generated method stub
		return serverMapper.findServerById(id);
	}

	@Override
	public List<ServerBean> findAllServer() {
		// TODO Auto-generated method stub
		return serverMapper.findAllServer();
	}

}
