package com.ppxia.billing.authortymag.mapper;

import java.util.List;

import com.ppxia.billing.beans.AuthorityBean;

public interface AuthorityMapper {
	public List<AuthorityBean> findAuthorityBiInfo(Long id);
}
