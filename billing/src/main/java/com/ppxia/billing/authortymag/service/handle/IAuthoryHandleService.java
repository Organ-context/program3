package com.ppxia.billing.authortymag.service.handle;

import com.ppxia.billing.beans.AuthorityBean;

public interface IAuthoryHandleService {
	// 根据id删除
	public void deleteAuthority(Long id);

	// 添加
	public void saveAuthority(AuthorityBean authory);
}
