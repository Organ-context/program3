package com.ppxia.billing.osmag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ppxia.billing.beans.OsDayBean;



public interface IOsHandleDayDao extends JpaRepository<OsDayBean, Long>,JpaSpecificationExecutor<OsDayBean>{

	 
}
