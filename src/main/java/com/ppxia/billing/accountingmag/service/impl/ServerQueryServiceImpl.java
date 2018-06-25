package com.ppxia.billing.accountingmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.accountingmag.dao.IServerQueryDao;
import com.ppxia.billing.accountingmag.service.IServerQuerySevice;
import com.ppxia.billing.beans.ServerBean;

@Service
public class ServerQueryServiceImpl implements IServerQuerySevice {

	@Resource
	private IServerQueryDao serverQueryDaoImpl;
	
	@Override
	public ServerBean findServerById(Long id) {
		// TODO Auto-generated method stub
		return serverQueryDaoImpl.findServerById(id);
	}

	@Override
	public List<ServerBean> findAllServer() {
		// TODO Auto-generated method stub
		return serverQueryDaoImpl.findAllServer();
	}

}
