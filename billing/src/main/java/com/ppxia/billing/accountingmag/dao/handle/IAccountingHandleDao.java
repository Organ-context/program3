package com.ppxia.billing.accountingmag.dao.handle;

import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.AccountingBean;

@Repository
public interface IAccountingHandleDao extends JpaRepository<AccountingBean, Long>,JpaSpecificationExecutor<AccountingBean>{
	//根据账户ID修改账务账户状态
	
	@Update(value = { "" })
	public void changAccountingState (Long accountingId,int state);
	
	public void saveAccounting(AccountingBean account);
}
