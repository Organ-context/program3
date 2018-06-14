package com.ppxia.billing.accountingmag.service.handle;

import com.ppxia.billing.beans.AccountingBean;

public interface IAccountingHandleService {
	//根据账户ID修改账务账户状态
	public void changAccountingState (Long accountingId,int state);
	
	public void saveAndFlushAccounting(AccountingBean accounting);
}
 