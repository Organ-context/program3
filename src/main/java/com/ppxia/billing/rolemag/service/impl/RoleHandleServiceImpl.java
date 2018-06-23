package com.ppxia.billing.rolemag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.RoleBean;
import com.ppxia.billing.rolemag.dao.IRoleHandleDao;
import com.ppxia.billing.rolemag.service.IRoleHandleService;

@Service
public class RoleHandleServiceImpl implements IRoleHandleService {

	@Resource
	private IRoleHandleDao roleHandleDaoImpl;
	
	@Override
	public void updateRole(RoleBean role) {
		// TODO Auto-generated method stub
		roleHandleDaoImpl.saveAndFlush(role);
	}

	@Override
	public void saveRole(RoleBean role) {
		// TODO Auto-generated method stub
		roleHandleDaoImpl.saveAndFlush(role);
	}

	@Override
	public void deleteRole(Long id) {
		// TODO Auto-generated method stub
		roleHandleDaoImpl.delete(id);
	}

}
