package com.ppxia.billing.logmag.service;

import java.util.Map;

import com.ppxia.billing.beans.OperateLogBean;
import com.ppxia.billing.beans.PagerBean;


public interface IOperatelogServicehandle {

    //分页显示
	
	//条件显示
//	public PagerBean findUserByParams2Pager(Map params,PagerBean pager);
	public void addOperateLogBean(OperateLogBean operationLog);
}