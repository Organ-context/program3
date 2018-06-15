package com.ppxia.billing.tariffmag.dao;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface ITariffQueryDao {
	public PagerBean findTariffByParams(PagerBean pager,Map params);
}
