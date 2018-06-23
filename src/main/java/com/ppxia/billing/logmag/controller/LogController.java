package com.ppxia.billing.logmag.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.logmag.service.ILoginlogQueryService;
import com.ppxia.billing.logmag.service.IOperationlogQueryService;
import com.ppxia.billing.viewobj.DataGrid;

@Controller
@RequestMapping("/log")
public class LogController {
	
	
	@Resource
	private ILoginlogQueryService loginlogQueryServiceImpl;
		
	@Resource
	private IOperationlogQueryService operationlogQueryServiceImpl;
	

	/**
	 * 登录日志分页
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping(value="/getLoginlogPager",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public DataGrid findLoginlogByParams2Pager(PagerBean pager,String managername,String starttime,String endtime) throws UnsupportedEncodingException {
		
		Map<String, Object> params = new HashMap<>();
		//managername .getBytes("iso8859-1"),"utf-8")为了转换中文的编码问题
		params.put("managername", new String(managername .getBytes("iso8859-1"),"utf-8"));
		params.put("startingtime", starttime);
		params.put("endtime", endtime);
		params.put("index", pager.getIndex());
		params.put("page", pager.getPage());
		loginlogQueryServiceImpl.findPagerByLoginlogBean(pager, params);
		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(),pager.getDatas());
		System.out.println(dataGrid);
		return dataGrid;	
	}
	
	
	/**
	 * 操作日志分页
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping(value="/getOperationlogPager",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public DataGrid findOperationlogByParams2Pager(PagerBean pager,String managername,String starttime,String endtime) throws UnsupportedEncodingException {
		
		Map<String, Object> params = new HashMap<>();
		//managername .getBytes("iso8859-1"),"utf-8")为了转换中文的编码问题
		params.put("managername", new String(managername .getBytes("iso8859-1"),"utf-8"));
		params.put("startingtime", starttime);
		params.put("endtime", endtime);
		params.put("index", pager.getIndex());
		params.put("page", pager.getPage());
		operationlogQueryServiceImpl.findPagerByOperateLogBean(pager, params);
		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(),pager.getDatas());
		System.out.println(dataGrid);
		return dataGrid;	
	}

}
