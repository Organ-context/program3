package com.ppxia.billing.tariffmag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ppxia.billing.beans.TariffBean;

public interface ITariffHandleDao extends JpaRepository<TariffBean, Long>,JpaSpecificationExecutor<TariffBean>{

}