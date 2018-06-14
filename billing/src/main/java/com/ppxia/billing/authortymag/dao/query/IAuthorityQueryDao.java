package com.ppxia.billing.authortymag.dao.query;

import java.util.List;

import com.ppxia.billing.beans.AuthorityBean;

public interface IAuthorityQueryDao {
	public List<AuthorityBean> findAuthorityBiInfo(Long id);
}
