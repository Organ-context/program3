package com.ppxia.billing.logmag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.logmag.dao.IOperationlogQueryDao;
import com.ppxia.billing.logmag.service.IOperationlogQueryService;


@Service
public class OperationlogServicequeryImpl implements IOperationlogQueryService{
	@Resource
	private IOperationlogQueryDao operationlogDaoqueryImpl;

	@Override
	public int findAllByNum(Map map) {
	
		return operationlogDaoqueryImpl.findAllByNum(map);
	}

	@Override
	public PagerBean findPagerByLoginlogBean(PagerBean pager, Map map) {
		int totalRows = operationlogDaoqueryImpl.findAllByNum(map);
		List<?> datas = operationlogDaoqueryImpl.findPagerByOperationBean(map);
		pager.setTotalRows(totalRows);
		pager.setDatas(datas);
		return pager;
	}


}
