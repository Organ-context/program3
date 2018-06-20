package com.ppxia.billing.logmag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ppxia.billing.beans.LoginLogBean;



//登录日志的持久层
public interface ILoginlogHandleDao extends JpaRepository<LoginLogBean, Long>,JpaSpecificationExecutor<LoginLogBean>{
	

}