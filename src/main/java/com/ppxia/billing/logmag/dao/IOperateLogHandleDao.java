package com.ppxia.billing.logmag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ppxia.billing.beans.OperateLogBean;



//操作日志的持久层
public interface IOperateLogHandleDao extends JpaRepository<OperateLogBean, Long>,JpaSpecificationExecutor<OperateLogBean>{

	
}