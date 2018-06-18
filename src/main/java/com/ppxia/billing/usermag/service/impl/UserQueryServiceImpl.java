package com.ppxia.billing.usermag.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.usermag.dao.IUserQueryDao;
import com.ppxia.billing.usermag.service.IUserQueryService;


@Service
public class UserQueryServiceImpl implements IUserQueryService {

	@Resource
	public IUserQueryDao userQueryDaoImpl;
	
	@Override
	public PagerBean findUserByParams2Pager(Map params, PagerBean pager) {
		// TODO Auto-generated method stub
		params.put("index", pager.getIndex());
		params.put("rows", pager.getRows());
		System.out.println(userQueryDaoImpl.findUserByParams(params));
		pager.setDatas(userQueryDaoImpl.findUserByParams(params));
		System.out.println(userQueryDaoImpl.findUserByParams(params));
		pager.setTotalRows(userQueryDaoImpl.countUserByParams(params));
		return pager;
	}

	@Override
	public UserBean getUser(long id) {
		// TODO Auto-generated method stub
		return userQueryDaoImpl.getUser(id);
	}

}
