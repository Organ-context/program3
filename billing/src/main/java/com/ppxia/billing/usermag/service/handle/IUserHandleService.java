package com.ppxia.billing.usermag.service.handle;

import com.ppxia.billing.beans.UserBean;

public interface IUserHandleService {
	//修改
		public void updateUser(UserBean user);
		
		//添加
		public void saveUser(UserBean user);
		
		//删除
		public void deleteUser(Long id);
}
