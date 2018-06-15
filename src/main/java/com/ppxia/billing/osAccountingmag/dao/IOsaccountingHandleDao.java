package com.ppxia.billing.osAccountingmag.dao;

public interface IOsaccountingHandleDao {
	//根据业务账号ID修改业务账号状态
	public void changeOsAccountingState(int osAccountingNum,int state);
}
