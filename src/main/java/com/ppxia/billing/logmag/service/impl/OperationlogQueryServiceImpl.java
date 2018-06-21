package com.ppxia.billing.logmag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.logmag.dao.IOperationlogQueryDao;
import com.ppxia.billing.logmag.service.IOperationlogQueryService;

@Service
public class OperationlogQueryServiceImpl implements IOperationlogQueryService{
	@Resource
	private IOperationlogQueryDao operationlogQueryDaoImpl;

	@Override
	public int findAllByNum(Map map) {
	
		return operationlogQueryDaoImpl.findAllByNum(map);
	}

	@Override
	public PagerBean findPagerByLoginlogBean(PagerBean pager, Map map) {
		int totalRows = operationlogQueryDaoImpl.findAllByNum(map);
		List<?> datas = operationlogQueryDaoImpl.findPagerByOperationBean(map);
		pager.setTotalRows(totalRows);
		pager.setDatas(datas);
		return pager;
	}


}
