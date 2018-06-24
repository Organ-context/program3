package com.ppxia.billing.usermag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.RoleBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.usermag.dao.IUserQueryDao;
import com.ppxia.billing.usermag.mapper.UserMapper;

@Repository
public class UserQueryDaoImpl implements IUserQueryDao{

	@Resource
	public UserMapper userMapper;
	@Override
	public UserBean getUser(long id) {
		// TODO Auto-generated method stub
		return userMapper.getManager(id);
	}

	@Override
	public int countUserByParams(Map params) {
		// TODO Auto-generated method stub
		return userMapper.countManagerByParams(params);
	}

	@Override
	public List<UserBean> findUserByParams(Map params) {
		// TODO Auto-generated method stub
		return userMapper.findManagerByParams(params);
	}

	@Override
	public UserBean findUserByName(String username) {
		// TODO Auto-generated method stub       
		return userMapper.findUserByName(username);
	}

	@Override
	public RoleBean findRoleByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.findRoleByUsername(username);
	}

}
