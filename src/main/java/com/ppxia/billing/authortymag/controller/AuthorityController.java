package com.ppxia.billing.authortymag.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppxia.billing.authortymag.service.IAuthorityQueryService;
import com.ppxia.billing.authortymag.service.IAuthoryHandleService;
import com.ppxia.billing.beans.AuthorityBean;
import com.ppxia.billing.beans.TreeNode;
import com.ppxia.billing.utils.TreeUtil;

@RestController
@RequestMapping("/authority")
public class AuthorityController {

	@Resource
	private IAuthoryHandleService authorityHandleServiceImpl;

	@Resource
	private IAuthorityQueryService authorityQueryServiceImpl;
	
	/**
	 * 添加权限
	 * @param authority
	 * @return
	 */
	@RequestMapping(value = "/saveAuthority", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public String saveAuthority(Long superAuthorityId,String newAuthorityName) {

		AuthorityBean newAuthority = new AuthorityBean();
		newAuthority.setAuthorityName(newAuthorityName);
		AuthorityBean superAuthority = authorityQueryServiceImpl.findAuthorityById(superAuthorityId);
		AuthorityBean LastAuthority = authorityQueryServiceImpl.findLastAuthorityBySuperAuthority(superAuthority.getAuthorityNum());
		int newAuthorityNum = Integer.parseInt(LastAuthority.getAuthorityNum())+1;
		newAuthority.setAuthorityNum(newAuthorityNum+"");
		authorityHandleServiceImpl.saveAuthority(newAuthority);
		return "";
	}
	
	/**
	 * 根据父权限编号返回全部子权限
	 * @return
	 */
	@RequestMapping(value = "/getAuthoritys", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public List<TreeNode> getAuthoritys() {
		List<AuthorityBean> datas = authorityQueryServiceImpl.findAllAuthority();
		System.out.println(TreeUtil.tree(TreeUtil.toListNode(datas)));
		return TreeUtil.tree(TreeUtil.toListNode(datas));
	}
	
	/**
	 * 删除选中权限及其子权限
	 * @param authorityNum
	 * @return
	 */
	@RequestMapping(value = "/deleteAuthority", method = { RequestMethod.DELETE }, produces = { "application/json;charset=utf-8" })
	public String deleteAuthority(Long authorityId) {
		AuthorityBean authority = authorityQueryServiceImpl.findAuthorityById(authorityId);
		List<AuthorityBean> authoritys = authorityQueryServiceImpl.findAuthorityBySuperAuthorityContainSuperAuthority(authority.getAuthorityNum());
		for (AuthorityBean authorityBean : authoritys) {
			authorityHandleServiceImpl.deleteAuthority(authorityBean.getId());
		}

		return "";
	}
	
}
