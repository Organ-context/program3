package com.ppxia.billing.authortymag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ppxia.billing.beans.AuthorityBean;

public interface IAuthorityHandleDao extends JpaRepository<AuthorityBean, Long>,JpaSpecificationExecutor<AuthorityBean>{
	
}
