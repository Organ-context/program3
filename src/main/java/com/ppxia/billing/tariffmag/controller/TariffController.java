package com.ppxia.billing.tariffmag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.RoleBean;
import com.ppxia.billing.beans.TariffBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.tariffmag.service.ITariffHandleService;
import com.ppxia.billing.tariffmag.service.ITariffQueryService;
import com.ppxia.billing.viewobj.DataGrid;

/**
 * 
 * @author 张进
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/tariff")
public class TariffController {
	
	@Resource
	private ITariffQueryService tariffQueryServiceImpl;
	
	@Resource
	private ITariffHandleService tariffHandleServiceImpl;
	
	@ResponseBody
	@RequestMapping(value="/add",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public String addTariff(TariffBean tariff) {
		tariffHandleServiceImpl.saveTariff(tariff);
		return "";
	}
	
	/**
	 * 分页
	 */
	@ResponseBody
	@RequestMapping(value="/getAdminPager",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public DataGrid findUserByParams2Pager(PagerBean pager,String realname,String username,String role) {
		Map<String, Object> params = new HashMap<>();
		params.put("realname", realname);
		params.put("username", username);
		params.put("role", role);
		params.put("pager", pager);
		tariffQueryServiceImpl.findPagerByParams(params);
		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(),pager.getDatas());
		return dataGrid;	
	}
	
	/**
	 * 跳转到资费添加页面
	 * @param viewName
	 * @return 资费添加页面视图
	 */
	@RequestMapping("/jump")
	public String jump(String viewName) {
		return viewName;
	}
}
