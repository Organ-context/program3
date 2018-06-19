package com.ppxia.billing.osmag.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.osmag.dao.IOsBeanQueryDao;
import com.ppxia.billing.osmag.service.IOsBeanQueryService;

@Service
public class OsBeanQueryServiceImpl implements IOsBeanQueryService {
	
	@Resource
	private IOsBeanQueryDao osBeanQueryDaoImpl;
	@Override
	public PagerBean findOsMonthBeansByAccountingAndMonth(int accountingNum, Date month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagerBean findOsDayBeansByOsNumAndMonth(int osNum, Date month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagerBean findOsByNameOrOsName(Map map) {
		// TODO Auto-generated method stub
		PagerBean pager = new PagerBean();
		pager.setDatas(osBeanQueryDaoImpl.findOsByNameOrOsName(map));
		pager.setTotalRows(osBeanQueryDaoImpl.findByAll(map));
		return pager;
	}

	


}
