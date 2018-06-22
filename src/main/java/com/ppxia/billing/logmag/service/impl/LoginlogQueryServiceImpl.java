package com.ppxia.billing.logmag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.logmag.dao.ILoginlogQueryDao;
import com.ppxia.billing.logmag.service.ILoginlogQueryService;


@Service
public class LoginlogQueryServiceImpl implements ILoginlogQueryService{
	@Resource
	private ILoginlogQueryDao loginlogQueryDaoImpl;

	@Override
	public int findAllByNum(Map map) {
		// TODO Auto-generated method stub
		return loginlogQueryDaoImpl.findAllByNum(map);
	}

	@Override
	public PagerBean findPagerByLoginlogBean(PagerBean pager, Map map) {
		map.put("index", pager.getIndex());
		map.put("rows", pager.getRows());
		int totalRows = loginlogQueryDaoImpl.findAllByNum(map);
		List<?> datas = loginlogQueryDaoImpl.findPagerByLoginlogBean(map);
		pager.setTotalRows(totalRows);
		pager.setDatas(datas);
		return pager;
	
	}

}