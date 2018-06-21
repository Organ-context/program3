package com.ppxia.billing.logmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.OperateLogBean;
import com.ppxia.billing.logmag.dao.IOperateLogQueryDao;

import com.ppxia.billing.logmag.mapper.OperatelogMapper;


@Repository
public class OperateLogQueryDaoImpl implements IOperateLogQueryDao{
	@Resource
	private OperatelogMapper operatelogMapper;


	@Override
	public int findAllByNum(Map map) {
		
		return operatelogMapper.findAllByNum(map);
	}

	@Override
	public List<OperateLogBean> findPagerByOperateLogBean(Map params) {
	
		return operatelogMapper.findPagerByOperateLogBean(params);
	}
  
}