package com.ppxia.billing.prosceniummag.service.handle.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.OsDayBean;
import com.ppxia.billing.beans.OsMonthBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.prosceniummag.dao.IProsceniumDao;
import com.ppxia.billing.prosceniummag.service.handle.IProsceniumService;
@Service
public class ProsceniumServiceImpl implements IProsceniumService{
	@Resource
	private IProsceniumDao prosceniumDaoImpl;
	@Override
	//根据数据库
	public UserBean loginName(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return prosceniumDaoImpl.loginName(userName, userPassword);
	}

	@Override
	public UserBean selectUserBeanById(int id) {
		// TODO Auto-generated method stub
		return prosceniumDaoImpl.selectUserBeanById(id);
	}


	@Override
	public void updateUserBeanById(int id, Long telephone) {
		// TODO Auto-generated method stub
		prosceniumDaoImpl.updateUserBeanById(id, telephone);
	}

	@Override
	public PagerBean selectAccountingMonthByUserId(int pageIndex,int pageSize,int id, Date monthe) {
		// TODO Auto-generated method stub
		return prosceniumDaoImpl.selectAccountingMonthByUserId(pageIndex,pageSize,id, monthe);
	}

	@Override
	public OsMonthBean selectOsAccountNumberByMonth(int id, Date month) {
		// TODO Auto-generated method stub
		return prosceniumDaoImpl.selectOsAccountNumberByMonth(id, month);
	}

	@Override
	public PagerBean selectOsCostDetailsBymonth(int pageIndex, int pageSize, int id, Date monthe) {
		// TODO Auto-generated method stub
		return prosceniumDaoImpl.selectOsCostDetailsBymonth(pageIndex, pageSize, id, monthe);
	}

}
