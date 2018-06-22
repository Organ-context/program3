package com.ppxia.billing.osmag.controller;

import java.io.UnsupportedEncodingException;
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
	public DataGrid findOsDayByMapToPager(PagerBean pager, String accountingName, String osaccount, String serverip,
			String time) throws UnsupportedEncodingException {
		Map params = new HashMap<>();
		params.put("accountingName", new String(accountingName .getBytes("iso8859-1"),"utf-8"));
		params.put("osaccount", new String(osaccount .getBytes("iso8859-1"),"utf-8"));
		params.put("serverip", new String(serverip .getBytes("iso8859-1"),"utf-8"));
		params.put("time", time);

		params.put("index", pager.getIndex());
		params.put("page", pager.getPage());
		System.out.println(params);
		osQueryServiceImpl.findOsDayBeansByParams(pager, params);

		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(), pager.getDatas());

		System.out.println(dataGrid);
		return dataGrid;
	}

	@RequestMapping(value = "/findosmonthpage", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public DataGrid findOsMonthByMapToPager(PagerBean pager, String accountingName, String Month) throws UnsupportedEncodingException {
		Map params = new HashMap<>();
		params.put("accountingName",new String(accountingName .getBytes("iso8859-1"),"utf-8") );
		params.put("Month", Month);

		params.put("index", pager.getIndex());
		params.put("page", pager.getPage());
		osQueryServiceImpl.findOsMonthBeansByAccountingAndMonth(pager, params);

		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(), pager.getDatas());
		System.out.println(dataGrid);
		return dataGrid;
	}
}
