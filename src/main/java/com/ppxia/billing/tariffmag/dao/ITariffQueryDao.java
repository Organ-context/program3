package com.ppxia.billing.tariffmag.dao;

import java.util.List;
import java.util.Map;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.TariffBean;

public interface ITariffQueryDao {
	
	//查询所有资费分页显示
	public PagerBean findPagerByParams( Map map);

	// 查询系统所有的资费
	public List<TariffBean> findAllTariffName();
	
	//通过资费名查询id
	public int findIdByName(String name);
}
