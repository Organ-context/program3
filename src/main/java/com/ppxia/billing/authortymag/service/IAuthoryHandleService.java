package com.ppxia.billing.authortymag.service;

import com.ppxia.billing.beans.AuthorityBean;

public interface IAuthoryHandleService {
	// 根据id删除权限
	public void deleteAuthority(Long id);

	// 添加权限
	public void saveAuthority(AuthorityBean authority);
}
