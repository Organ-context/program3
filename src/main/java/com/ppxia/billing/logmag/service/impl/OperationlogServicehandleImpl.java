package com.ppxia.billing.logmag.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.ppxia.billing.beans.OperateLogBean;
import com.ppxia.billing.logmag.dao.IOperationlogHandleDao;
import com.ppxia.billing.logmag.service.IOperatelogServicehandle;

@Service
public class OperationlogServicehandleImpl implements IOperatelogServicehandle{
	@Resource
	private IOperationlogHandleDao operationlogDaohandle;
   
	@Override
	public void addOperateLogBean(OperateLogBean operationLog) {
		// TODO Auto-generated method stub
		operationlogDaohandle.save(operationLog);
	}



	

}
