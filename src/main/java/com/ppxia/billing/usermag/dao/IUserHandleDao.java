package com.ppxia.billing.usermag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.UserBean;

@Repository
public interface IUserHandleDao extends JpaRepository<UserBean, Long>,JpaSpecificationExecutor<UserBean>{
	
}
