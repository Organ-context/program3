package com.ppxia.billing.accountingMonthmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.accountingMonthmag.dao.IAccountingMonthQueryDao;
import com.ppxia.billing.accountingMonthmag.mapper.AccountingMonthMapper;



@Repository
public class AccountingMonthQueryDaoImpl implements IAccountingMonthQueryDao {

	@Resource
	private AccountingMonthMapper accountingMonthMapper;
	@Override
	public List<?> findAccountingMonthByParams(Map params) {
		// TODO Auto-generated method stub
		return accountingMonthMapper.findAccountingMonthByParams(params);
	}

	@Override
	public int findAccountingMonthTotal(Map params) {
		// TODO Auto-generated method stub
		return accountingMonthMapper.findAccountingMonthTotal(params);
	}


}
