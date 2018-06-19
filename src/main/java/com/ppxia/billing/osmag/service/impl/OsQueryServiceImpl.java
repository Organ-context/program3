package com.ppxia.billing.osmag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.OsMonthBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.osmag.dao.IOsQueryDao;
import com.ppxia.billing.osmag.service.IOsQueryService;

@Service
public class OsQueryServiceImpl implements IOsQueryService {

	 @Resource
	 private IOsQueryDao osQueryDaoImpl;
	@Override
	public PagerBean findOsMonthBeansByAccountingAndMonth(PagerBean param, Map map) {
		// TODO Auto-generated method stub
		int totalRows = osQueryDaoImpl.findOsMonthBeansTotal(map);
		List<OsMonthBean> datas = (List<OsMonthBean>) osQueryDaoImpl.findOsMonthBeansByAccountingAndMonth(map);
		param.setTotalRows(totalRows);
		param.setDatas(datas);
		return param;
				
				
	}

	@Override
	public PagerBean findOsDayBeansByParams(PagerBean param, Map map) {
		// TODO Auto-generated method stub
		List<?> datas=osQueryDaoImpl.findOsDayBeansByParams(map);
		int totalRows=osQueryDaoImpl.findOsDayBeansTotal(map);
		param.setTotalRows(totalRows);
		param.setDatas(datas);
		return param;
	}

}
