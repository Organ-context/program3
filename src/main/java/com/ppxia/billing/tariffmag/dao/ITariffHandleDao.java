package com.ppxia.billing.tariffmag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ppxia.billing.beans.TariffBean;

public interface ITariffHandleDao extends JpaRepository<TariffBean, Long>,JpaSpecificationExecutor<TariffBean>{
//		//修改
//		public void updateTariff(TariffBean tariff);
//		//添加
//		public void saveTariff(TariffBean tariff);
//		//删除
//		public void deleteTariff(Long id);
}
