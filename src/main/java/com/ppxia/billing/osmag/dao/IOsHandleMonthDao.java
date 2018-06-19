package com.ppxia.billing.osmag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ppxia.billing.beans.OsMonthBean;

public interface IOsHandleMonthDao  extends JpaRepository<OsMonthBean, Long>,JpaSpecificationExecutor<OsMonthBean>{

}
