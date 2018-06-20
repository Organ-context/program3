package com.ppxia.billing.accountingmag.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.accountingmag.dao.IAccountingQueryDao;
import com.ppxia.billing.accountingmag.service.IAccountingQueryService;
import com.ppxia.billing.beans.PagerBean;
@Service
public class AccountingQueryServiceImpl implements IAccountingQueryService{

	@Resource
	private IAccountingQueryDao accountingQueryDaoImpl;
	@Override
	public PagerBean findAccountingByParams( Map params) {
		PagerBean pager = new PagerBean();
		
//		pager.setDatas(accountingQueryDaoImpl.findByParams(params));
		
		pager.setTotalRows(accountingQueryDaoImpl.findAccountByAll(params));
		
		return accountingQueryDaoImpl.findByParams(params);
	}

}
