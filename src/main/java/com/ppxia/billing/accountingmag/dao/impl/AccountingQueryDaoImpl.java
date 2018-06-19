package com.ppxia.billing.accountingmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.accountingmag.dao.IAccountingQueryDao;
import com.ppxia.billing.accountingmag.mapper.AccountingMapper;
import com.ppxia.billing.beans.UserBean;
@Repository
public class AccountingQueryDaoImpl implements IAccountingQueryDao {

	@Resource
	private AccountingMapper accountingMapper;
	@Override
	public int findAccountByAll(Map map) {
		// TODO Auto-generated method stub
		return accountingMapper.findByParams(map);
	}

	@Override
	public List<UserBean> findByParams(Map map) {
		// TODO Auto-generated method stub
		return accountingMapper.findByAll(map);
	}

}
