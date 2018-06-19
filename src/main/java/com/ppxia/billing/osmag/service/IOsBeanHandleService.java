package com.ppxia.billing.osmag.service;

import com.ppxia.billing.beans.OsBean;

public interface IOsBeanHandleService {
	
	//添加业账号
	public void saveOsBean(OsBean bean);
	
	//修改业务账号状态
	public void updateOsBean(OsBean bean);
	
	//删除业务账号
	public void deleteOsBean (Long id);
}
