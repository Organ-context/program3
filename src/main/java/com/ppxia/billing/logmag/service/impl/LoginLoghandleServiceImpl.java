package com.ppxia.billing.logmag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.LoginLogBean;
import com.ppxia.billing.logmag.dao.ILoginlogHandleDao;
import com.ppxia.billing.logmag.service.ILoginlogHandleService;


@Service
public class LoginLoghandleServiceImpl implements ILoginlogHandleService{
	@Resource
   private ILoginlogHandleDao LoginlogDaohandle;

//	@Override
//	public PagerBean findUserByParams2Pager(Map params, PagerBean pager) {
//		params.put("index", pager.getIndex());
//		params.put("rows", pager.getRows());
//		pager.setDatas(LoginlogDaoquery.findPagerByLoginlogBean(params));
//		pager.setTotalRows(LoginlogDaoquery.countLoginLogBeanByParams(params));
//		return pager;
//	}





	@Override
	public void addLoginLogBean(LoginLogBean LoginLog) {
		// TODO Auto-generated method stub
		LoginlogDaohandle.save(LoginLog);
	}



	

}