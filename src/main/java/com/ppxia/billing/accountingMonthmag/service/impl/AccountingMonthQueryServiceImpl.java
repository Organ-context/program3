package com.ppxia.billing.accountingMonthmag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.accountingMonthmag.dao.IAccountingMonthQueryDao;
import com.ppxia.billing.accountingMonthmag.service.IAccountingMonthQueryService;
import com.ppxia.billing.beans.PagerBean;
@Service
public class AccountingMonthQueryServiceImpl implements IAccountingMonthQueryService {

	@Resource
	private IAccountingMonthQueryDao  accountingMonthQueryDaoImpl;
	@Override
	public PagerBean findAccountingMonthByParams(PagerBean param, Map params) {
		// TODO Auto-generated method stub
		int totalRows = accountingMonthQueryDaoImpl.findAccountingMonthTotal(params);
		List<?> datas = accountingMonthQueryDaoImpl.findAccountingMonthByParams(params);
		param.setTotalRows(totalRows);
		param.setDatas(datas);
		return param;
	}

}
