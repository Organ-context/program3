package com.ppxia.billing.Echarts.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ppxia.billing.Echarts.dao.IEchartsDao;
import com.ppxia.billing.Echarts.service.IEchartsService;

@Service
public class EchartsServiceImpl implements IEchartsService {
 
	@Resource
	 private IEchartsDao echartsDaoImpl;
	@Override
	public List<?> findOsMonthEcharts(Map map) {
		// TODO Auto-generated method stub
		return echartsDaoImpl.findOsMonthEcharts(map);
	}

}
