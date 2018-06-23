package com.ppxia.billing.osAccountingmag.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.osAccountingmag.service.IOsaccountingQueryService;
import com.ppxia.billing.viewobj.DataGrid;

import freemarker.template.SimpleDate;

@RestController
@RequestMapping("/osAccountingcontroller")
public class OsAccountingController {

	@Resource
	private IOsaccountingQueryService osaccountingQueryServiceImpl;

	@RequestMapping(value = "/findOsAccountingYearPage", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public DataGrid findOsAccountingYearByMapToPager(PagerBean pager, String osAccount, String IP, String Year)
			throws UnsupportedEncodingException {
		Map params = new HashMap<>();
		params.put("osAccount", new String(osAccount.getBytes("iso8859-1"), "utf-8"));
		params.put("IP", new String(IP.getBytes("iso8859-1"), "utf-8"));
		params.put("Year", new String(Year.getBytes("iso8859-1"), "utf-8"));
		params.put("index", pager.getIndex());
		params.put("page", pager.getPage());
		osaccountingQueryServiceImpl.findOsYearAccountingByParams(pager, params);

		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(), pager.getDatas());

		return dataGrid;
	}

	@RequestMapping(value = "/findOsAccountingMonthPage", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public DataGrid findOsAccountingMonthByMapToPager(PagerBean pager, String osAccount, String IP, String month)
			throws UnsupportedEncodingException {
		Map params = new HashMap<>();
		params.put("osAccount", new String(osAccount.getBytes("iso8859-1"), "utf-8"));
		params.put("IP", new String(IP.getBytes("iso8859-1"), "utf-8"));
		params.put("month", new String(month.getBytes("iso8859-1"), "utf-8"));
		params.put("index", pager.getIndex());
		params.put("page", pager.getPage());
		osaccountingQueryServiceImpl.findOsMonthAccountingByParams(pager, params);

		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(), pager.getDatas());

		return dataGrid;
	}

	@RequestMapping(value = "/findOsAccountingDayPage", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public DataGrid findOsAccountingDayByMapToPager(PagerBean pager, String osAccount, String IP)
			throws UnsupportedEncodingException {
		
		Map params = new HashMap<>();
		params.put("osAccount", new String(osAccount.getBytes("iso8859-1"), "utf-8"));
		params.put("IP", new String(IP.getBytes("iso8859-1"), "utf-8"));
		params.put("index", pager.getIndex());
		params.put("page", pager.getPage());
		osaccountingQueryServiceImpl.findOsDayAccountingByParams(pager, params);

		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(), pager.getDatas());

		System.out.println(dataGrid);
		return dataGrid;
	}
}
