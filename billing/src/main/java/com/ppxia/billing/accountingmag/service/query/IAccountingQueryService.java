package com.ppxia.billing.accountingmag.service.query;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IAccountingQueryService {

	
	public PagerBean findAccountingByParams(PagerBean pager,Map params);
}
