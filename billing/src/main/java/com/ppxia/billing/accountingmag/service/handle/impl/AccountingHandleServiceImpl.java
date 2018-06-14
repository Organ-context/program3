package com.ppxia.billing.accountingmag.service.handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.accountingmag.dao.handle.IAccountingHandleDao;
import com.ppxia.billing.accountingmag.service.handle.IAccountingHandleService;
import com.ppxia.billing.beans.AccountingBean;

@Service
public class AccountingHandleServiceImpl implements IAccountingHandleService {

	@Resource
	private IAccountingHandleDao accountingHandleDaoImpl;
	
	@Override
	public void changAccountingState(Long accountingId, int state) {
		// TODO Auto-generated method stub
		accountingHandleDaoImpl.changAccountingState(accountingId, state);
	}
	
	@Override
	public void saveAndFlushAccounting(AccountingBean accounting) {
		// TODO Auto-generated method stub
		accountingHandleDaoImpl.saveAndFlush(accounting);
	}
}
