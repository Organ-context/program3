package com.ppxia.billing.accountingmag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.accountingmag.dao.IAccountingHandleDao;
import com.ppxia.billing.accountingmag.service.IAccountingHandleService;
import com.ppxia.billing.beans.AccountingBean;

@Service
public class AccountingHandleServiceImpl implements IAccountingHandleService {

	@Resource
	private IAccountingHandleDao accountingHandleDaoImpl;
	
	@Override
	public void saveAndFlushAccounting(AccountingBean accounting) {
		// TODO Auto-generated method stub
		accountingHandleDaoImpl.saveAndFlush(accounting);
	}
}
