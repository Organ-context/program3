package com.ppxia.billing.osmag.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.osmag.dao.IOsBeanQueryDao;
import com.ppxia.billing.osmag.mapper.OsBeanMapper;
@Repository
public class OsBeanQueryDaoImpl implements IOsBeanQueryDao{
	
	@Resource
	private OsBeanMapper osBeanMapper;
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
	public List<UserBean> findOsByNameOrOsName(Map params) {
		// TODO Auto-generated method stub
		return osBeanMapper.findOsByNameOrOsName(params);
	}

	@Override
	public int findByAll(Map params) {
		// TODO Auto-generated method stub
		return osBeanMapper.findByAll(params);
	}

	

}
