package com.ppxia.billing.accountingMonthmag.service;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IAccountingMonthQueryService {
	
	public PagerBean findAccountingMonthByParams(PagerBean param,Map params);
}
