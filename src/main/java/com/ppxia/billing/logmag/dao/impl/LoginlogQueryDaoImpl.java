package com.ppxia.billing.logmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.LoginLogBean;
import com.ppxia.billing.logmag.dao.ILoginlogQueryDao;
import com.ppxia.billing.logmag.mapper.LoginlogMapper;

@Repository
public class LoginlogQueryDaoImpl implements ILoginlogQueryDao {
	@Resource
	private LoginlogMapper loginlogMapper;

	@Override
	public List<LoginLogBean> findPagerByLoginlogBean(Map params) {
		return loginlogMapper.findPagerByLoginlogBean(params);
	}

	@Override
	public int findAllByNum(Map map) {
		return loginlogMapper.findAllByNum(map);
	}

}