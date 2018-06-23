package com.ppxia.billing.tariffmag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppxia.billing.beans.OsBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.TariffBean;
import com.ppxia.billing.osmag.service.IOsBeanHandleService;
import com.ppxia.billing.tariffmag.service.ITariffHandleService;
import com.ppxia.billing.tariffmag.service.ITariffQueryService;
import com.ppxia.billing.viewobj.DataGrid;

/**
 * 
 * @author 张进
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/tariff")
public class TariffController {

	@Resource
	private ITariffQueryService tariffQueryServiceImpl;

	@Resource
	private ITariffHandleService tariffHandleServiceImpl;
	
	@Resource
	private IOsBeanHandleService osHandleServiceImpl;

	@RequestMapping(value = "/add", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public String addTariff(TariffBean tariff) {
		tariffHandleServiceImpl.saveTariff(tariff);
		return "";
	}

	@RequestMapping(value = "/updateTariff", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public String updateTariff(OsBean osBean,Long newTariff) {
		TariffBean tariff = tariffQueryServiceImpl.findTariffById(newTariff);
		osBean.setTariffBean(tariff);
		osHandleServiceImpl.updateOsBean(osBean);
		List<TariffBean> datas = tariffQueryServiceImpl.findAllTariffName();
		System.out.println(datas);
		return null;
	}

	@RequestMapping(value = "/getAllTariff", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public List<TariffBean> getAllTariff() {
		List<TariffBean> datas = tariffQueryServiceImpl.findAllTariffName();
		System.out.println(datas);
		return datas;
	}

	@RequestMapping(value = "/getTariffPager", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public DataGrid findOsByParams2Pager(PagerBean pager, String userName, String accountName) {
		Map<String, Object> params = new HashMap<>();
		pager.setRows(10);
		params.put("userName", userName);
		params.put("osAccount", accountName);
		params.put("pager", pager);
		DataGrid dataGrid = null;
		tariffQueryServiceImpl.findPagerByParams(params, pager);
		dataGrid = new DataGrid((long) pager.getTotalRows(), pager.getDatas());
		return dataGrid;
	}

	/**
	 * 跳转到资费添加页面
	 * 
	 * @param viewName
	 * @return 资费添加页面视图
	 */
	@RequestMapping("/jump")
	public String jump(String viewName) {
		return viewName;
	}
}
