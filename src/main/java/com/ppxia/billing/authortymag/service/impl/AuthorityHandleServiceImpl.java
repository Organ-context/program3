package com.ppxia.billing.authortymag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.authortymag.dao.IAuthorityHandleDao;
import com.ppxia.billing.authortymag.service.IAuthoryHandleService;
import com.ppxia.billing.beans.AuthorityBean;

@Service
public class AuthorityHandleServiceImpl implements IAuthoryHandleService {

	@Resource
	private IAuthorityHandleDao authorityHandleDaoImpl;
	
	@Override
	public void deleteAuthority(Long id) {
		// TODO Auto-generated method stub
		authorityHandleDaoImpl.delete(id);
	}

	@Override
	public void saveAuthority(AuthorityBean authority) {
		// TODO Auto-generated method stub
		authorityHandleDaoImpl.saveAndFlush(authority);
	}

}
