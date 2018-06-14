package com.ppxia.billing.logmag.mapper;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface LogMapper {
	public PagerBean findLoginLogByParam(PagerBean pager,Map params);
	
	
	public PagerBean findOperationLogByParams(PagerBean pager,Map params);
}
