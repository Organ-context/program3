package com.ppxia.billing.rolemag.dao.handle;

import com.ppxia.billing.beans.RoleBean;

public interface IRoleHandleDao {
	
	//修改
	public void updateRole(RoleBean role);
	
	//添加
	public void saveRole(RoleBean role);
	
	//删除
	public void deleteRole(Long id);
}
