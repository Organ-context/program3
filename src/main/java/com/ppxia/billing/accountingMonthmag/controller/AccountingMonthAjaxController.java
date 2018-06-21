package com.ppxia.billing.accountingMonthmag.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppxia.billing.accountingMonthmag.service.IAccountingMonthQueryService;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.viewobj.DataGrid;
@RestController
@RequestMapping("/accountingmonthajax")
public class AccountingMonthAjaxController<E> {

	  @Resource
	  private IAccountingMonthQueryService  accountingMonthQueryServiceimpl;
	 
	@RequestMapping(value = "/findpage", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public DataGrid findCustomersByMapToPager(PagerBean pager,String userName,String accountName,String idcard,String time) throws UnsupportedEncodingException {
		Map params = new HashMap<>();
		params.put("userName", new String(userName .getBytes("iso8859-1"),"utf-8"));
		params.put("accountName",new String(accountName .getBytes("iso8859-1"),"utf-8") );
		params.put("idcard", new String(idcard .getBytes("iso8859-1"),"utf-8"));
		params.put("time", new String(time .getBytes("iso8859-1"),"utf-8"));
		
		params.put("index", pager.getIndex());
		params.put("page", pager.getPage());
		System.out.println(params);
		accountingMonthQueryServiceimpl.findAccountingMonthByParams(pager, params);
				
		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(),pager.getDatas());
	
		return dataGrid;
	}
}
