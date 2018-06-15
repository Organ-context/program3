package com.ppxia.billing.usermag.dao;

import com.ppxia.billing.beans.UserBean;

public interface IUserHandleDao {
	//修改
	public void updateUser(UserBean user);
	
	//添加
	public void saveUser(UserBean user);
	
	//删除
	public void deleteUser(Long id);
}
