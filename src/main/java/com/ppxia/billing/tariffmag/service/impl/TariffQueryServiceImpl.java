package com.ppxia.billing.tariffmag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.TariffBean;
import com.ppxia.billing.tariffmag.dao.ITariffQueryDao;
import com.ppxia.billing.tariffmag.service.ITariffQueryService;

@Service
public class TariffQueryServiceImpl implements ITariffQueryService {
	
	@Resource
	private ITariffQueryDao tariffQueryDaoImpl;
	
	//查询资费分页对象
	@Override
	public PagerBean findPagerByParams(Map map) {
		// TODO Auto-generated method stub
		return tariffQueryDaoImpl.findPagerByParams(map);
	}

	
	//通过姓名查找资费集合
	@Override
	public List<TariffBean> findAllTariffName() {
		// TODO Auto-generated method stub
		return tariffQueryDaoImpl.findAllTariffName();
	}

	
	//通过资费名查找资费id
	@Override
	public int findIdByName(String name) {
		// TODO Auto-generated method stub
		return tariffQueryDaoImpl.findIdByName(name);
	}

}
