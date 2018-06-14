package com.ppxia.billing.accountingmag.dao.query;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IAccountingQueryDao {
	public PagerBean findAccountingByParams(PagerBean pager,Map params);
}
