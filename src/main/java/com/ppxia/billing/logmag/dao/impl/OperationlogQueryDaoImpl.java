package com.ppxia.billing.logmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.OperateLogBean;
import com.ppxia.billing.logmag.dao.IOperationlogQueryDao;
import com.ppxia.billing.logmag.mapper.OperatelogMapper;


@Repository
public class OperationlogQueryDaoImpl implements IOperationlogQueryDao{
	@Resource
	private OperatelogMapper operationlogMapper;
    @Override
	public int findAllByNum(Map map) {
		// TODO Auto-generated method stub
		return operationlogMapper.findAllByNum(map);
	}

	@Override
	public List<OperateLogBean> findPagerByOperationBean(Map params) {
		// TODO Auto-generated method stub
		return operationlogMapper.findPagerByOperationLogBean(params);
	}
	
}