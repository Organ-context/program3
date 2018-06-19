package com.ppxia.billing.tariffmag.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.TariffBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.tariffmag.dao.ITariffQueryDao;
import com.ppxia.billing.tariffmag.mapper.TariffMapper;

public class TariffQueryDaoImpl implements ITariffQueryDao {
	
	@Resource
	private TariffMapper tariffMapper;
	
	//分页查询
	@Override
	public PagerBean findPagerByParams( Map map) {
		PagerBean pager = new PagerBean();
		int num=tariffMapper.findTariffByAll(map);
		//将查询到的总条数存入pager的总条数属性中
		pager.setTotalRows(num);
		//将查询到的具体数据存入pager的数据集合属性中
		pager.setDatas(tariffMapper.findPagerByParams(map));
		
		return pager;
	}
	//通过姓名查找
	@Override
	public List<TariffBean> findAllTariffName() {
		return tariffMapper.findAllTariffName();
	}
	//通过姓名查找id
	@Override
	public int findIdByName(String name) {
		return tariffMapper.findIdByName(name);
	}

}
