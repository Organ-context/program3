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
	public AuthorityBean findLastAuthorityBySuperAuthority(String authorityNum) {
		// TODO Auto-generated method stub
		return authorityQueryDaoImpl.findLastAuthorityBySuperAuthority(authorityNum);
	}

	@Override
	public List<AuthorityBean> findAuthorityBySuperAuthorityContainSuperAuthority(String authorityNum) {
		// TODO Auto-generated method stub
		return authorityQueryDaoImpl.findAuthorityBySuperAuthorityContainSuperAuthority(authorityNum);
	}

	@Override
	public List<AuthorityBean> findAllAuthority() {
		// TODO Auto-generated method stub
		return authorityQueryDaoImpl.findAllAuthority();
	}

	@Override
	public AuthorityBean findAuthorityById(Long id) {
		// TODO Auto-generated method stub
		return authorityQueryDaoImpl.findAuthorityById(id);
	}

}
