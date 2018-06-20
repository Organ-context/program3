package com.ppxia.billing.accountingmag.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ppxia.billing.beans.UserBean;

public interface IAccountingBeanHandleDao extends JpaRepository<UserBean, Long>,JpaSpecificationExecutor<UserBean>{


}
