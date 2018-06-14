package com.ppxia.billing.osAccountingmag.dao.query;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IOsaccountingQueryDao {
	//跟据参数查询业务账号的分页对象
	public PagerBean findOsAccountingByParams(PagerBean pager,Map params);
}
