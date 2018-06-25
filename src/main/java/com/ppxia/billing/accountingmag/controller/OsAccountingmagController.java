package com.ppxia.billing.accountingmag.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppxia.billing.osmag.service.IOsBeanHandleService;

@RestController
@RequestMapping("/osAccountingmag")
public class OsAccountingmagController {
	@Resource
	private IOsBeanHandleService osBeanHandleServiceImpl;

	/**
	 * 删除OS账号
	 * 
	 * @param nowOsId
	 * @return
	 */
	@RequestMapping(value = "/deleteOsAccounting", method = { RequestMethod.POST }, produces = {
			"application/json;charset=utf-8" })
	public String changeOsState(Long nowOsId) {
		osBeanHandleServiceImpl.deleteOsBean(nowOsId);
		return "";
	}
	
	/**
	 * 查询当前输入的业务账号是否存在
	 * @param osAccount
	 * @return
	 */
	@RequestMapping(value = "/deleteOsAccounting", method = { RequestMethod.POST }, produces = {
			"application/json;charset=utf-8" })
	public String checkOsAccount(String osAccount) {
		
		return "";
	}
}
