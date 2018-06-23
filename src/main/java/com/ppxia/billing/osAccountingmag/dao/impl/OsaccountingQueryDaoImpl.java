package com.ppxia.billing.osAccountingmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.osAccountingmag.dao.IOsaccountingQueryDao;
import com.ppxia.billing.osAccountingmag.mapper.OsaccountingMapper;
@Repository
public class OsaccountingQueryDaoImpl implements IOsaccountingQueryDao {

	@Resource
	 private OsaccountingMapper osaccountingMapper;
	@Override
	public List<?> findOsYearAccountingByParams(Map params) {
		// TODO Auto-generated method stub
		return osaccountingMapper.findOsYearAccountingByParams(params);
	}

	@Override
	public int findOsYearAccountingTotals(Map params) {
		// TODO Auto-generated method stub
		return osaccountingMapper.findOsYearAccountingTotals(params);
	}

	@Override
	public List<?> findOsMonthAccountingByParams(Map params) {
		// TODO Auto-generated method stub
		return osaccountingMapper.findOsMonthAccountingByParams(params);
	}

	@Override
	public int findOsMonthAccountingTotals(Map params) {
		// TODO Auto-generated method stub
		return osaccountingMapper.findOsMonthAccountingTotals(params);
	}

	@Override
	public List<?> findOsDayAccountingByParams(Map params) {
		// TODO Auto-generated method stub
		return osaccountingMapper.findOsDayAccountingByParams(params);
	}

	@Override
	public int findOsDayAccountingTotals(Map params) {
		// TODO Auto-generated method stub
		return osaccountingMapper.findOsDayAccountingTotals(params);
	}

}
