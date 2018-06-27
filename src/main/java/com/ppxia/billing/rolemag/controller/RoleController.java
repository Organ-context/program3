package com.ppxia.billing.rolemag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.RoleBean;
import com.ppxia.billing.rolemag.service.IRoleHandleService;
import com.ppxia.billing.rolemag.service.IRoleQueryService;
import com.ppxia.billing.viewobj.DataGrid;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Resource
	private IRoleQueryService roleQueryServiceImpl;
	
	@Resource
	private IRoleHandleService roleHandleServiceImpl;
	
	/**
	 * 新增角色
	 * @param nowRoleId
	 * @param newRoleName
	 * @param newRoleType
	 * @return
	 */
	@RequestMapping(value="/saveRole",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public String saveRole(Long nowRoleId,String updateRoleName) {
		RoleBean nowRole = roleQueryServiceImpl.findRoleByRoleId(nowRoleId);
		RoleBean newRole = new RoleBean();
		newRole.setId(nowRoleId);
		newRole.setAuthoritys(nowRole.getAuthoritys());
		newRole.setRoleName(updateRoleName);
		newRole.setRoleType(1);
		roleHandleServiceImpl.saveRole(newRole);
		return null;
	}
	
	/**
	 * 修改角色信息
	 * @param nowRoleId
	 * @param newRoleName
	 * @param newRoleType
	 * @return
	 */
	@RequestMapping(value="/updateRole",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public String updateRole(Long nowRoleId,String updateRoleName) {
		RoleBean nowRole = roleQueryServiceImpl.findRoleByRoleId(nowRoleId);
		RoleBean newRole = new RoleBean();
		newRole.setId(nowRoleId);
		newRole.setAuthoritys(nowRole.getAuthoritys());
		newRole.setRoleName(updateRoleName);
		newRole.setRoleType(1);
		roleHandleServiceImpl.updateRole(newRole);
		return null;
	}
	
	/**
	 * 删除
	 * @param roleId 要删除的对象ID
	 * @return
	 */
	@RequestMapping(value="/deleteRole",method= {RequestMethod.DELETE},produces= {"application/json;charset=utf-8"})
	public String deleteRole(Long roleId) {
		roleHandleServiceImpl.deleteRole(roleId);
		return "";
	}
	
	/**
	 * 分页
	 */
	@RequestMapping(value="/getRolePager",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public DataGrid findRoleByParams2Pager(PagerBean pager,String roleName,String roleType) {
		Map<String, Object> params = new HashMap<>();
		params.put("roleName", roleName);
		params.put("roleType", roleType);
		roleQueryServiceImpl.findRoleByParams(pager, params);
		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(),pager.getDatas());
		return dataGrid;
	}
}
