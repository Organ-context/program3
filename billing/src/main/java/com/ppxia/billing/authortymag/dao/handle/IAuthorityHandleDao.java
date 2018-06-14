package com.ppxia.billing.authortymag.dao.handle;

import com.ppxia.billing.beans.AuthorityBean;

public interface IAuthorityHandleDao {
	//根据id删除
	public void deleteAuthority(Long id );
	
	//添加
	public void saveAuthority(AuthorityBean authory);
}
