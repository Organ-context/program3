package com.ppxia.billing.logmag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.ppxia.billing.beans.OperateLogBean;
import com.ppxia.billing.logmag.dao.IOperateLogHandleDao;
import com.ppxia.billing.logmag.service.IOperatelogHandleService;

@Service
public class OperateLogHandleServiceImpl implements IOperatelogHandleService{
	@Resource
	private IOperateLogHandleDao OperateLogHandleDao;

	@Override
	public void addOperateLogBean(OperateLogBean operationLog) {
		
		OperateLogHandleDao.save(operationLog);
	}
   




	

}
