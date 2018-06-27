package com.ppxia.billing.rolemag.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.RoleBean;
import com.ppxia.billing.rolemag.dao.IRoleQueryDao;
import com.ppxia.billing.rolemag.service.IRoleQueryService;

@Service
public class RoleQueryServiceImpl implements IRoleQueryService {

	@Resource
	private IRoleQueryDao roleQueryDaoImpl;
	
	@Override
	public PagerBean findRoleByParams(PagerBean pager, Map params) {
		// TODO Auto-generated method stub
		return roleQueryDaoImpl.findRoleByParams(pager, params);
	}

	@Override
	public RoleBean findRoleByUserName(String userName) {
		// TODO Auto-generated method stub
		return roleQueryDaoImpl.findRoleByUserName(userName);
	}

	@Override
	public RoleBean findRoleByRoleId(Long id) {
		// TODO Auto-generated method stub
		return roleQueryDaoImpl.findRoleByRoleId(id);
	}

}
