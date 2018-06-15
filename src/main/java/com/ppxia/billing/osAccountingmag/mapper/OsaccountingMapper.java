package com.ppxia.billing.osAccountingmag.mapper;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface OsaccountingMapper {
	//跟据参数查询业务账号的分页对象
		public PagerBean findOsAccountingByParams(PagerBean pager,Map params);
}
