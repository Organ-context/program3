package com.ppxia.billing.accountingMonthmag.mapper;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface AccountingMonthMapper {
	
	public PagerBean findAccountingMonthByParams(PagerBean param,Map params);
}
