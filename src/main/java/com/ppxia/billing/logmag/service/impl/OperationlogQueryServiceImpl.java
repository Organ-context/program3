package com.ppxia.billing.logmag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.logmag.dao.IOperateLogQueryDao;

import com.ppxia.billing.logmag.service.IOperationlogQueryService;


@Service
public class OperationlogQueryServiceImpl implements IOperationlogQueryService{

	@Resource
	private IOperateLogQueryDao OperateLogQueryDao;
	@Override
	public int findAllByNum(Map map) {
		
		return OperateLogQueryDao.findAllByNum(map);
	}
	
    @Override
	public PagerBean findPagerByOperateLogBean(PagerBean pager, Map map) {
    	map.put("index", pager.getIndex());
		map.put("rows", pager.getRows());
		int totalRows = OperateLogQueryDao.findAllByNum(map);
		List<?> datas =OperateLogQueryDao.findPagerByOperateLogBean(map);
		pager.setTotalRows(totalRows);
		pager.setDatas(datas);
		return pager;
	}


}
