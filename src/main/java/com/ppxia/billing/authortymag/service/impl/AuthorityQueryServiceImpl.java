package com.ppxia.billing.authortymag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.authortymag.dao.IAuthorityQueryDao;
import com.ppxia.billing.authortymag.service.IAuthorityQueryService;
import com.ppxia.billing.beans.AuthorityBean;

@Service
public class AuthorityQueryServiceImpl implements IAuthorityQueryService {
	
	@Resource
	private IAuthorityQueryDao authorityQueryDaoImpl;
	
	@Override
	public List<AuthorityBean> findAuthorityBySuperAuthority(int authorityNum) {
		// TODO Auto-generated method stub
		return authorityQueryDaoImpl.findAuthorityBySuperAuthority(authorityNum);
	}

	@Override
	public AuthorityBean findLastAuthorityBySuperAuthority(int authorityNum) {
		// TODO Auto-generated method stub
		return authorityQueryDaoImpl.findLastAuthorityBySuperAuthority(authorityNum);
	}

}
