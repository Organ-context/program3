package com.ppxia.billing.logmag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.ppxia.billing.beans.OperateLogBean;
import com.ppxia.billing.logmag.dao.IOperationlogHandleDao;
import com.ppxia.billing.logmag.service.IOperatelogHandleService;

@Service
public class OperationlogHandleServiceImpl implements IOperatelogHandleService{
	@Resource
	private IOperationlogHandleDao operationlogHandleDaoImpl;
   
	@Override
	public void addOperateLogBean(OperateLogBean operationLog) {
		// TODO Auto-generated method stub
		operationlogHandleDaoImpl.save(operationLog);
	}



	

}
