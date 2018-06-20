package com.ppxia.billing.logmag.service;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IOperationlogQueryService {


	/**
	 * 
	 * @param map
	 */
	public int findAllByNum(Map map);

	/**
	 * 
	 * @param map
	 */
	public PagerBean findPagerByLoginlogBean(PagerBean pager,Map map);
}