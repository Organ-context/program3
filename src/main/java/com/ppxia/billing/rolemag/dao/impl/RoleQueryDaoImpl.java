package com.ppxia.billing.rolemag.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.RoleBean;
import com.ppxia.billing.rolemag.dao.IRoleQueryDao;
import com.ppxia.billing.rolemag.mapper.RoleMapper;

@Repository
public class RoleQueryDaoImpl implements IRoleQueryDao {

	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public PagerBean findRoleByParams(PagerBean pager, Map params) {
		// TODO Auto-generated method stub
		pager.setDatas(roleMapper.findRoleByParams(params));
		pager.setTotalRows(roleMapper.findTotalNumByParams(params));
		return pager;
	}

	@Override
	public RoleBean findRoleByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleIdByRoleName(roleName);
	}

	@Override
	public RoleBean findRoleByUserName(String userName) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleByUserName(userName);
	}

}
