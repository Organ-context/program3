package com.ppxia.billing.accountingMonthmag.dao;

import java.util.List;
import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IAccountingMonthQueryDao {
	
	public List<?> findAccountingMonthByParams(Map params);
	
	public int findAccountingMonthTotal(Map params);
}
