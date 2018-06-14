package com.ppxia.billing.authortymag.service.query;

import java.util.List;

import com.ppxia.billing.beans.AuthorityBean;

public interface IAuthorityQueryService {
	public List<AuthorityBean> findAuthorityBiInfo(Long id);
}
