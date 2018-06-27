package com.ppxia.billing.authortymag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.authortymag.dao.IAuthorityQueryDao;
import com.ppxia.billing.authortymag.mapper.AuthorityMapper;
import com.ppxia.billing.beans.AuthorityBean;

@Repository
public class AuthorityQueryDaoImpl implements IAuthorityQueryDao {

	@Resource
	private AuthorityMapper authorityMapper;
	
	@Override
	public List<AuthorityBean> findAuthorityBySuperAuthority(int authorityNum) {
		// TODO Auto-generated method stub
		return authorityMapper.findAuthorityBySuperAuthority(authorityNum);
	}

	@Override
	public AuthorityBean findLastAuthorityBySuperAuthority(String authorityNum) {
		// TODO Auto-generated method stub
		return authorityMapper.findLastAuthorityBySuperAuthority(authorityNum);
	}

	@Override
	public List<AuthorityBean> findAuthorityBySuperAuthorityContainSuperAuthority(String authorityNum) {
		// TODO Auto-generated method stub
		return authorityMapper.findAuthorityBySuperAuthorityContainSuperAuthority(authorityNum);
	}

	@Override
	public List<AuthorityBean> findAllAuthority() {
		// TODO Auto-generated method stub
		return authorityMapper.findAllAuthority();
	}

	@Override
	public AuthorityBean findAuthorityById(Long id) {
		// TODO Auto-generated method stub
		return authorityMapper.findAuthorityByAuthorityId(id);
	}

}
