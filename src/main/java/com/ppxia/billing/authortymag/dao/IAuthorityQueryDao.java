package com.ppxia.billing.authortymag.dao;

import java.util.List;

import com.ppxia.billing.beans.AuthorityBean;

public interface IAuthorityQueryDao {
	public List<AuthorityBean> findAuthorityBySuperAuthority(int authorityNum);
	
	public List<AuthorityBean> findAuthorityBySuperAuthorityContainSuperAuthority(String authorityNum);
	
	public AuthorityBean findLastAuthorityBySuperAuthority(String authorityNum);
	
	public List<AuthorityBean> findAllAuthority();
	
	public AuthorityBean findAuthorityById(Long id);
}
