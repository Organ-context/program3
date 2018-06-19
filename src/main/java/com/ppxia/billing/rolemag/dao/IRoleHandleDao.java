package com.ppxia.billing.rolemag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ppxia.billing.beans.RoleBean;

public interface IRoleHandleDao extends JpaRepository<RoleBean, Long>,JpaSpecificationExecutor<RoleBean>{
	
}
