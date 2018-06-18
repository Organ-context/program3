package com.ppxia.billing.usermag.service;

import com.ppxia.billing.beans.UserBean;

public interface IUserHandleService {
		/**
		 * 删除
		 * @param manager
		 */
		public void deleteManager(UserBean user);

		/**
		 * 添加
		 * @param manager
		 */
		public void saveManager(UserBean user);

		
		/**
		 * 修改
		 * @param user
		 */
		public void updateManatger(Long id,String userPassword,Long telephone,String email);
}
