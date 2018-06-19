package com.ppxia.billing.tariffmag.service;

import com.ppxia.billing.beans.TariffBean;
import com.ppxia.billing.beans.UserBean;

public interface ITariffHandleService {
	//修改资费
	public void updateTariff(TariffBean tariff);
	
	//添加资费
	public void saveTariff(TariffBean tariff);
	
	//删除资费
	public void deleteTariff(Long id);
	
}
