package com.ppxia.billing.usermag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
		userQueryServiceImpl.findUserByParams2Pager(params, pager);
		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(),pager.getDatas());
		return dataGrid;	
	}
	
	/**
	 * 删除
	 * @param user 要删除的对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteAdmin",method= {RequestMethod.DELETE},produces= {"application/json;charset=utf-8"})
	public String deleteAdmin(UserBean user) {
		userHandleServiceImpl.deleteManager(user);
		return "";
	}
	
	/**
	 * 修改,将原有数据赋值到新的对象中，再将传入的要修改的参数赋值到新对象
	 * @param id 传入的id
	 * @param userPassword 要修改的密码
	 * @param telephone 要修改的手机号码
	 * @param email 要修改的邮箱地址
	 * @param roleName 要修改的角色
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateAdmin",method= {RequestMethod.PUT},produces= {"application/json;charset=utf-8"})
	public String updateAdmin(Long id,String userPassword,Long telephone,String email,String roleName) {
		UserBean user = userQueryServiceImpl.getUser(id);
		UserBean user1 = new UserBean();
		RoleBean newRole =  user.getRoleBean();
		user1.setId(user.getId());
		user1.setUserName(user.getUserName());
		user1.setGender(user.getGender());
		user1.setUserAccountingName(user.getUserAccountingName());
		if (userPassword!=null && StringUtils.hasLength(userPassword.trim())) {
			user1.setUserPassword(userPassword);
		}else {
			user1.setUserPassword(user.getUserPassword());
		}
		if (telephone!=null) {
			user1.setTelephone(telephone);
		}else {
			user1.setTelephone(user.getTelephone());
		}
		if (email!=null && StringUtils.hasLength(email.trim())) {
			user1.setEmail(email);
		}else {
			user1.setEmail(user.getEmail());
		}
		if (roleName!=null ) {
			newRole=roleQueryDaoImpl.findRoleByRoleName(roleName);
			user1.setRoleBean(newRole);
		}else {
			user1.setRoleBean(user.getRoleBean());
		}
		userHandleServiceImpl.updateManatger(user1);
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}