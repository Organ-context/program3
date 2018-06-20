package com.ppxia.billing.logmag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.logmag.dao.ILoginlogQueryDao;
import com.ppxia.billing.logmag.service.ILoginlogServicequery;


@Service
public class LoginlogServicequeryImpl implements ILoginlogServicequery{
	@Resource
	private ILoginlogQueryDao loginlogDaoqueryImpl;
//	
//	@Override
//	public int findAllByNum(Map map) {
//		
//		return loginlogDaoqueryImpl.findAllByNum(map);
//	}
//
//	@Override
//	public List<LoginLogBean> findPagerByLoginlogBean(Map map) {
//		
//		return loginlogDaoqueryImpl.findPagerByLoginlogBean(map);
//	}
//
//	@Override
//	public PagerBean findLoginLogBeanByParams2Pager(Map params, PagerBean pager) {
//		
//		
//		params.put("index", pager.getIndex());
//		params.put("rows", pager.getRows());
////		System.out.println(userQueryDaoImpl.findUserByParams(params));
////		pager.setDatas(userQueryDaoImpl.findUserByParams(params));
////		System.out.println(userQueryDaoImpl.findUserByParams(params));
////		pager.setTotalRows(userQueryDaoImpl.countUserByParams(params));
//		loginlogDaoqueryImpl.findPagerByLoginlogBean(params);
//	   
//		return pager;
//	}
//
//	@Override
//	public PagerBean findPagerByLoginlogBean(PagerBean pager, Map map) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int findAllByNum(Map map) {
		// TODO Auto-generated method stub
		return loginlogDaoqueryImpl.findAllByNum(map);
	}

	@Override
	public PagerBean findPagerByLoginlogBean(PagerBean pager, Map map) {
		
		int totalRows = loginlogDaoqueryImpl.findAllByNum(map);
		List<?> datas = loginlogDaoqueryImpl.findPagerByLoginlogBean(map);
		pager.setTotalRows(totalRows);
		pager.setDatas(datas);
		return pager;
	
	}

	

}