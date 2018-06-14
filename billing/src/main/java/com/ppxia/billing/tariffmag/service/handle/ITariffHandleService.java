package com.ppxia.billing.tariffmag.service.handle;

import com.ppxia.billing.beans.TariffBean;

public interface ITariffHandleService {
	//修改
	public void updateTariff(TariffBean tariff);
	//添加
	public void saveTariff(TariffBean tariff);
	//删除
	public void deleteTariff(Long id);
}
