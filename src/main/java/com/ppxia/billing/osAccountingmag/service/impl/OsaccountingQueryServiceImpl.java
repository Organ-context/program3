package com.ppxia.billing.osAccountingmag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.OsDayBean;
import com.ppxia.billing.beans.OsMonthBean;
import com.ppxia.billing.beans.OsYearBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.osAccountingmag.dao.IOsaccountingQueryDao;
import com.ppxia.billing.osAccountingmag.service.IOsaccountingQueryService;

@Service
public class OsaccountingQueryServiceImpl implements IOsaccountingQueryService {
   
	  @Resource
	  private IOsaccountingQueryDao osaccountingQueryDaoImpl;
	@Override
	public PagerBean findOsYearAccountingByParams(PagerBean pager, Map params) {
		// TODO Auto-generated method stub
		int totalRows = osaccountingQueryDaoImpl.findOsYearAccountingTotals(params);
		List<OsYearBean> datas = (List<OsYearBean>) osaccountingQueryDaoImpl.findOsYearAccountingByParams(params);
		pager.setTotalRows(totalRows);
		pager.setDatas(datas);
		return pager;
	}

	@Override
	public PagerBean findOsMonthAccountingByParams(PagerBean pager, Map params) {
		// TODO Auto-generated method stub
		int totalRows = osaccountingQueryDaoImpl.findOsMonthAccountingTotals(params);
		List<OsMonthBean> datas = (List<OsMonthBean>) osaccountingQueryDaoImpl.findOsMonthAccountingByParams(params);
		pager.setTotalRows(totalRows);
		pager.setDatas(datas);
		return pager;
	}

	@Override
	public PagerBean findOsDayAccountingByParams(PagerBean pager, Map params) {
		// TODO Auto-generated method stub
		int totalRows = osaccountingQueryDaoImpl.findOsDayAccountingTotals(params);
		List<OsDayBean> datas = (List<OsDayBean>) osaccountingQueryDaoImpl.findOsDayAccountingByParams(params);
		pager.setTotalRows(totalRows);
		pager.setDatas(datas);
		return pager;
	}

}
