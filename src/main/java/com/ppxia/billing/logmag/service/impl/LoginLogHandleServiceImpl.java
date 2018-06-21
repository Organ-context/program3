package com.ppxia.billing.logmag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.LoginLogBean;
import com.ppxia.billing.logmag.dao.ILoginlogHandleDao;
import com.ppxia.billing.logmag.service.ILoginlogHandleService;


@Service
public class LoginLogHandleServiceImpl implements ILoginlogHandleService{
	
	@Resource
	private ILoginlogHandleDao LoginlogHandleDao;

	@Override
	public void addLoginLogBean(LoginLogBean LoginLog) {
		// TODO Auto-generated method stub
		LoginlogHandleDao.save(LoginLog);
	}

}