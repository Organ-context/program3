package com.ppxia.billing.accountingmag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.AccountingBean;

@Repository
public interface IAccountingHandleDao extends JpaRepository<AccountingBean, Long>,JpaSpecificationExecutor<AccountingBean>{

}
