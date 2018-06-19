package com.ppxia.billing.osmag.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ppxia.billing.beans.OsBean;

public interface IOsBeanHandleDao extends JpaRepository<OsBean, Long>,JpaSpecificationExecutor<OsBean>{

}
