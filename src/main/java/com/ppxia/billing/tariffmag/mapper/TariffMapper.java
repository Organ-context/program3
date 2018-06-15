package com.ppxia.billing.tariffmag.mapper;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface TariffMapper {
	public PagerBean findTariffByParams(PagerBean pager,Map params);
}
