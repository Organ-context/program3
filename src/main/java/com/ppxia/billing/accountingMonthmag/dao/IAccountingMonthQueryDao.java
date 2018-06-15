package com.ppxia.billing.accountingMonthmag.dao;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IAccountingMonthQueryDao {
	
	public PagerBean findAccountingMonthByParams(PagerBean param,Map params);
}
