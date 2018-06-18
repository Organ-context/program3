package com.ppxia.billing.usermag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.usermag.dao.IUserHandleDao;
import com.ppxia.billing.usermag.dao.IUserQueryDao;
import com.ppxia.billing.usermag.service.IUserHandleService;

@Service
public class UserHandleServiceImpl implements IUserHandleService{

	@Resource
	private IUserHandleDao userHandleDao;
	@Resource
	private IUserQueryDao userQueryDaoImpl;
	
	
	/**
	 *  删除
	 */
	@Override
	public void deleteManager(UserBean user) {
		// TODO Auto-generated method stub
		userHandleDao.delete(user);
	}

	
	/**
	 * 添加
	 */
	@Override
	public void saveManager(UserBean user) {
		// TODO Auto-generated method stub
		userHandleDao.save(user);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void updateManatger(Long id,String userPassword,Long telephone,String email) {
		// TODO Auto-generated method stub
		UserBean user = userQueryDaoImpl.getUser(id);
		user.setUserPassword(userPassword);
		user.setTelephone(telephone);
		user.setEmail(email);
		userHandleDao.saveAndFlush(user);
	}

}
