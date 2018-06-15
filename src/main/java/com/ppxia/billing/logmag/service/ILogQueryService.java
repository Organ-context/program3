package com.ppxia.billing.logmag.service;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface ILogQueryService {
	public PagerBean findLoginLogByParam(PagerBean pager,Map params);
	
	
	public PagerBean findOperationLogByParams(PagerBean pager,Map params);
}
