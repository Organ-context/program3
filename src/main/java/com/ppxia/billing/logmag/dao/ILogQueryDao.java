package com.ppxia.billing.logmag.dao;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface ILogQueryDao {
	public PagerBean findLoginLogByParam(PagerBean pager,Map params);
	
	
	public PagerBean findOperationLogByParams(PagerBean pager,Map params);
}
