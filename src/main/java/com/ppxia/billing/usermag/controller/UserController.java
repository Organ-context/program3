package com.ppxia.billing.usermag.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.usermag.service.IUserHandleService;
import com.ppxia.billing.usermag.service.IUserQueryService;

/**
 * @author Administrator
 * @version 1.0
 * @created 13-6��-2018 16:34:40
 */

@RequestMapping("/admin")
@Controller
public class UserController {
	@Resource
	private IUserHandleService userHandleServiceImpl;

	@Resource
	private IUserQueryService userQueryServiceImpl;

	/**
	 * 增加用户
	 */
	@RequestMapping("/add")
	public String Addmanager(UserBean user) {

		userHandleServiceImpl.saveManager(user);

		return null;
	}

}