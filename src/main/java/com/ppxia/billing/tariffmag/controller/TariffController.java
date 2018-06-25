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
import com.ppxia.billing.osmag.service.IOsBeanQueryService;
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
	private IOsBeanHandleService osBeanHandleServiceImpl;

	@Resource
	private IOsBeanQueryService osBeanQueryServiceImpl;

	/**
	 * 修改OS账号的状态
	 * @param nowOsId
	 * @return
	 */
	@RequestMapping(value = "/changeOsState", method = { RequestMethod.POST }, produces = {
			"application/json;charset=utf-8" })
	public String changeOsState(Long nowOsId) {
		OsBean newOsBean = new OsBean();
		OsBean oldOsBean = osBeanQueryServiceImpl.findOsBeanById(nowOsId);
		newOsBean.setId(oldOsBean.getId());
		newOsBean.setOsAccount(oldOsBean.getOsAccount());
		newOsBean.setOsState(oldOsBean.getOsState());
		if (oldOsBean.getOsState()==1) {
			newOsBean.setOsState(0);
		}else {
			newOsBean.setOsState(1);
		}
		newOsBean.setServerBean(oldOsBean.getServerBean());
		newOsBean.setUserBean(oldOsBean.getUserBean());
		newOsBean.setTariffBean(oldOsBean.getTariffBean());
		osBeanHandleServiceImpl.updateOsBean(newOsBean);
		return "";
	}

	/**
	 * 修改业务账号资费
	 * 
	 * @param nowOsId
	 * @param newTariffId
	 * @return
	 */
	@RequestMapping(value = "/updateTariff", method = { RequestMethod.POST }, produces = {
			"application/json;charset=utf-8" })
	public String updateTariff(Long nowOsId, Long newTariffId) {
		OsBean newOsBean = new OsBean();
		OsBean oldOsBean = osBeanQueryServiceImpl.findOsBeanById(nowOsId);
		newOsBean.setId(oldOsBean.getId());
		newOsBean.setOsAccount(oldOsBean.getOsAccount());
		newOsBean.setOsState(oldOsBean.getOsState());
		newOsBean.setServerBean(oldOsBean.getServerBean());
		newOsBean.setUserBean(oldOsBean.getUserBean());

		TariffBean tariff = tariffQueryServiceImpl.findTariffById(newTariffId);
		newOsBean.setTariffBean(tariff);
		osBeanHandleServiceImpl.updateOsBean(newOsBean);
		return "";
	}

	@RequestMapping(value = "/add", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public String addTariff(TariffBean tariff) {
		tariffHandleServiceImpl.saveTariff(tariff);
		return "";
	}

	/**
	 * 获取全部资费对象
	 * @return
	 */
	@RequestMapping(value = "/getAllTariff", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public List<TariffBean> getAllTariff() {
		List<TariffBean> datas = tariffQueryServiceImpl.findAllTariffName();
		return datas;
	}

	/**
	 * 获得业务账号的资费分页对象
	 * @param pager
	 * @param userName
	 * @param accountName
	 * @return
	 */
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
