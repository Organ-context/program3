package com.ppxia.billing.authortymag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ppxia.billing.authortymag.service.IAuthorityQueryService;
import com.ppxia.billing.authortymag.service.IAuthoryHandleService;
import com.ppxia.billing.beans.AuthorityBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.viewObject.DataGrid;

@Controller
@RequestMapping("/authority")
public class AuthorityController {

	@Resource
	private IAuthoryHandleService authorityHandleServiceImpl;

	@Resource
	private IAuthorityQueryService authorityQueryServiceImpl;

	/**
	 * 根据父权限编号返回全部子权限
	 * @param authority
	 * @return
	 */
	@RequestMapping(value = "/authoritys", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public List<AuthorityBean> findCustomersByMapToPager(AuthorityBean authority) {

		List<AuthorityBean> authoritys = authorityQueryServiceImpl.findAuthorityBySuperAuthority(authority.getAuthorityNum());

		return authoritys;
	}
	
	
}
