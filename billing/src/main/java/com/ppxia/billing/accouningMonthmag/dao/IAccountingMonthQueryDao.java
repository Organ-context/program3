package com.ppxia.billing.accouningMonthmag.dao;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IAccountingMonthQueryDao {
	
	public PagerBean findAccountingMonthByParams(PagerBean param,Map params);
}
