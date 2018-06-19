package com.ppxia.billing.accountingmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.accountingmag.dao.IAccountingHandleDao;
import com.ppxia.billing.accountingmag.service.IAccountingHandleService;
import com.ppxia.billing.beans.UserBean;

@Service
public class AccountingHandleServiceImpl implements IAccountingHandleService {

	@Resource
	private IAccountingHandleDao accountingHandleDaoImpl;
	
	
	//单个添加
	@Override
	public void saveAndFlushAccounting(UserBean accounting) {
		accountingHandleDaoImpl.save(accounting);
	}
	
	//批量添加
	@Override
	public void saveManyAccounting(List<UserBean> list) {
		accountingHandleDaoImpl.save(list);
	}
	
	
	//修改状态
	@Override
	public void updateAccountingState(UserBean users) {
		accountingHandleDaoImpl.saveAndFlush(users);
	}
}
