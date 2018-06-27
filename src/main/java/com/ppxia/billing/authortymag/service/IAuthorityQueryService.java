package com.ppxia.billing.authortymag.service;

import java.util.List;

import com.ppxia.billing.beans.AuthorityBean;

public interface IAuthorityQueryService {
	/**
	 * 根据父权限编号查询全部子权限
	 * @param authorityNum
	 * @return 父权限下面的全部子权限集合
	 */
	public List<AuthorityBean> findAuthorityBySuperAuthority(int authorityNum);
	
	/**
	 * 根据父权限编号查询全部子权限以及父权限
	 * @param string
	 * @return
	 */
	public List<AuthorityBean> findAuthorityBySuperAuthorityContainSuperAuthority(String string);
	
	/**
	 * 查询全部权限对象
	 * @return
	 */
	public List<AuthorityBean> findAllAuthority();
	/**
	 * 根据父权限编号查询最后一个子权限
	 * @param string
	 * @return 父权限的最后一个子权限
	 */
	public AuthorityBean findLastAuthorityBySuperAuthority(String string);
	
	/**
	 * 通过ID查询权限对象
	 * @param id
	 * @return
	 */
	public AuthorityBean findAuthorityById(Long id);
}
