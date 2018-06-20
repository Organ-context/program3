package com.ppxia.billing.tariffmag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.TariffBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.tariffmag.dao.ITariffHandleDao;
import com.ppxia.billing.tariffmag.service.ITariffHandleService;

@Service
public class TariffHandleServiceImpl implements ITariffHandleService {
	
	@Resource
	private ITariffHandleDao tariffHandleDaoImpl;
	/**
	 * 修改资费
	 */
	@Override
	public void updateTariff(TariffBean tariff) {
		// TODO Auto-generated method stub
		tariffHandleDaoImpl.saveAndFlush(tariff);
	}
	/**
	 * 添加资费
	 */
	@Override
	public void saveTariff(TariffBean tariff) {
		// TODO Auto-generated method stub
		tariffHandleDaoImpl.save(tariff);
	}
	/**
	 * 删除资费
	 */
	@Override
	public void deleteTariff(Long id) {
		// TODO Auto-generated method stub
		tariffHandleDaoImpl.delete(id);
	}


}
