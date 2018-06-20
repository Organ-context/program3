package com.ppxia.billing.accountingmag.dao;

import java.util.List;
import java.util.Map;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;


public interface IAccountingQueryDao {
	
	//查询所有账务满足条件的总条数
	public int findAccountByAll(Map map);
	
	//查询分页的满足条件的所有具体数据
	public PagerBean findByParams(Map map);
	
	
	
}
