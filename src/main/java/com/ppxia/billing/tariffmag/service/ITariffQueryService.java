package com.ppxia.billing.tariffmag.service;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface ITariffQueryService {
	public PagerBean findTariffByParams(PagerBean pager,Map params);
}
