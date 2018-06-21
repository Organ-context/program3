package com.ppxia.billing.osmag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.osmag.service.IOsQueryService;
import com.ppxia.billing.viewobj.DataGrid;

@RestController
@RequestMapping("/osmagcontroller")
public class OsMagController {
	
	  @Resource
	  private IOsQueryService osQueryServiceImpl; 

	@RequestMapping(value = "/findosdaypage", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public DataGrid findOsDayByMapToPager(PagerBean pager, String userName, String accountName, String idcard,
			String time) {
		Map params = new HashMap<>();
		params.put("userName", userName);
		params.put("accountName", accountName);
		params.put("idcard", idcard);
		params.put("time", time);

		params.put("index", pager.getIndex());
		params.put("page", pager.getPage());
		System.out.println(params);
		osQueryServiceImpl.findOsDayBeansByParams(pager, params);

		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(), pager.getDatas());

		return dataGrid;
	}

	@RequestMapping(value = "/findosmonthpage", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public DataGrid findOsMonthByMapToPager(PagerBean pager, String userName, String accountName, String idcard,
			String time) {
		Map params = new HashMap<>();
		params.put("userName", userName);
		params.put("accountName", accountName);
		params.put("idcard", idcard);
		params.put("time", time);

		params.put("index", pager.getIndex());
		params.put("page", pager.getPage());
		osQueryServiceImpl.findOsMonthBeansByAccountingAndMonth(pager, params);

		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(), pager.getDatas());

		return dataGrid;
	}
}
