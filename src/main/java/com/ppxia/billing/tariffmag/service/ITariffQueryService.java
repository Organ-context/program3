package com.ppxia.billing.tariffmag.service;

import java.util.List;
import java.util.Map;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.TariffBean;

public interface ITariffQueryService {
	// 查询所有资费分页显示
	//只传Map参数
	public PagerBean findPagerByParams(Map map);

	// 查询系统所有的资费
	public List<TariffBean> findAllTariffName();
	
	//通过资费名查询id
	public int findIdByName(String name);
}
