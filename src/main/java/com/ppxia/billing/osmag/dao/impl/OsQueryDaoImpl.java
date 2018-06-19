package com.ppxia.billing.osmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.OsDayBean;
import com.ppxia.billing.beans.OsMonthBean;
import com.ppxia.billing.osmag.dao.IOsQueryDao;
import com.ppxia.billing.osmag.mapper.OsMapper;

@Repository
public class OsQueryDaoImpl implements IOsQueryDao {
 
	  @Resource
	  private OsMapper osmapper;
	@Override
	public List<OsMonthBean> findOsMonthBeansByAccountingAndMonth(Map map) {
		// TODO Auto-generated method stub	
		return osmapper.findOsMonthBeansByAccountingAndMonth(map);
	}

	@Override
	public int findOsMonthBeansTotal(Map map) {
		// TODO Auto-generated method stub
		return osmapper.findOsMonthBeansTotal(map);
	}
	@Override
	public List<?> findOsDayBeansByParams( Map map) {
		// TODO Auto-generated method stub
		return osmapper.findOsDayBeansByParams( map);
	}


	@Override
	public int findOsDayBeansTotal(Map map) {
		// TODO Auto-generated method stub
		return osmapper.findOsDayBeansTotal(map);
	}

}
