package com.ppxia.billing.adminmag.service;

import java.util.Map;

public interface IAdminService {

	//根据条件修改管理员信息
	public void changeAdminInfoByParams(Map params);
	
	//根据ID删除管理员
	public void deleteAdmin(Long id);
}
