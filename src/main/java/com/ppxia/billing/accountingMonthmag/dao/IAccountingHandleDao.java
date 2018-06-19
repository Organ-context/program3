package com.ppxia.billing.accountingMonthmag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ppxia.billing.beans.AccountingMonthBean;

public interface IAccountingHandleDao  extends JpaRepository<AccountingMonthBean, Long>,JpaSpecificationExecutor<AccountingMonthBean>{

}
