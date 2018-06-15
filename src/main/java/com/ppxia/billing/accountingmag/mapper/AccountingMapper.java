package com.ppxia.billing.accountingmag.mapper;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface AccountingMapper {
	public PagerBean findAccountingByParams(PagerBean pager,Map params);
}
