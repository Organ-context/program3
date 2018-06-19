package com.ppxia.billing.authortymag.dao;

import java.util.List;

import com.ppxia.billing.beans.AuthorityBean;

public interface IAuthorityQueryDao {
	public List<AuthorityBean> findAuthorityBySuperAuthority(int authorityNum);
	
	public AuthorityBean findLastAuthorityBySuperAuthority(int authorityNum);
}
