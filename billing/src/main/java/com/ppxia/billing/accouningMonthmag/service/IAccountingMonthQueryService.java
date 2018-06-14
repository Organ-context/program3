package com.ppxia.billing.accouningMonthmag.service;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IAccountingMonthQueryService {
	
	public PagerBean findAccountingMonthByParams(PagerBean param,Map params);
}
