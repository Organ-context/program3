package com.ppxia.billing.usermag.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.RoleBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.rolemag.dao.IRoleQueryDao;
import com.ppxia.billing.usermag.service.IUserHandleService;
import com.ppxia.billing.usermag.service.IUserQueryService;

/**
 * @author Administrator
 * @version 1.0
 * @created 13-6��-2018 16:34:40
 */
@Controller
@RequestMapping("/admin")
public class UserController {
	@Resource
	private IUserHandleService userHandleServiceImpl;

	@Resource
	private IUserQueryService userQueryServiceImpl;
	
	@Resource
	private IRoleQueryDao roleQueryDaoImpl;

	/**
	 * 增加用户
	 */
	@ResponseBody
	@RequestMapping(value="/add",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public String Addmanager(UserBean user,String userName,String userAccountingName,String userPassword,Integer gender,String roleName,Long telephone,String email) {
		RoleBean roleBean = roleQueryDaoImpl.findRoleByRoleName(roleName);
//		user.setRoleBean(roleBean);
//		userHandleServiceImpl.saveManager(user);
		user.setUserName(userName);
		user.setUserAccountingName(userAccountingName);
		user.setUserPassword(userPassword);
		user.setGender(gender);
		user.setRoleBean(roleBean);
		user.setTelephone(telephone);
		user.setEmail(email);
		System.out.println(user);
		userHandleServiceImpl.saveManager(user);
		return "";
	}
	
	
	
	
	/**
	 * 分页
	 */
	@ResponseBody
	@RequestMapping(value="/find",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public PagerBean findManger() {
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}