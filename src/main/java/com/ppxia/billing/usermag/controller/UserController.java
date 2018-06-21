package com.ppxia.billing.usermag.controller;

import java.util.HashMap;
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
import com.ppxia.billing.viewobj.DataGrid;

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
		user.setUserName(userName);
		user.setUserAccountingName(userAccountingName);
		user.setUserPassword(userPassword);
		user.setGender(gender);
		user.setRoleBean(roleBean);
		user.setTelephone(telephone);
		user.setEmail(email);
		userHandleServiceImpl.saveManager(user);
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
		System.out.println(params);
		userQueryServiceImpl.findUserByParams2Pager(params, pager);
		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(),pager.getDatas());
		return dataGrid;	
	}
	
	
	@ResponseBody
	@RequestMapping(value="/deleteAdmin",method= {RequestMethod.DELETE},produces= {"application/json;charset=utf-8"})
	public String deleteAdmin(UserBean user) {
		userHandleServiceImpl.deleteManager(user);
		return "";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/updateAdmin",method= {RequestMethod.PUT},produces= {"application/json;charset=utf-8"})
	public String updateAdmin(Long id,String userPassword,Long telephone,String email,String roleName) {
		UserBean user = userQueryServiceImpl.getUser(id);
		UserBean user1 = new UserBean();
		user1.setId(user1.getId());
		user1.setUserName(user.getUserName());
	
		user1.setGender(user.getGender());
		user1.setUserAccountingName(user.getUserAccountingName());
		user1.setRoleBean(user.getRoleBean());
	//	user1.setTelephone(user.getTelephone());
	//	user1.setEmail(user.getEmail());
    //	user1.setUserPassword(user.getUserPassword());
		if (userPassword!=null) {
			user1.setUserPassword(userPassword);
		}else {
			user1.setUserPassword(user.getUserPassword());
		}
		if (telephone!=null) {
			user1.setTelephone(telephone);
		}else {
			user1.setTelephone(user.getTelephone());
		}
		if (email!=null) {
			user1.setEmail(email);
		}else {
			user1.setEmail(user.getEmail());
		}
		userHandleServiceImpl.updateManatger(user1);
		
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}