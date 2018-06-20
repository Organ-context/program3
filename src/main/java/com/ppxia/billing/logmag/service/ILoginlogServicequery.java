package com.ppxia.billing.logmag.service;

import java.util.List;
import java.util.Map;

import com.ppxia.billing.beans.LoginLogBean;
import com.ppxia.billing.beans.PagerBean;




public interface ILoginlogServicequery {


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