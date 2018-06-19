package com.ppxia.billing.accountingmag.service;

import java.util.List;

import com.ppxia.billing.beans.UserBean;

public interface IAccountingHandleService {
	//单个添加
	public void saveAndFlushAccounting(UserBean accounting);
	
	//批量添加
	public void saveManyAccounting(List<UserBean> list);
	
	
	//修改状态
	public void updateAccountingState(UserBean users);
}
 