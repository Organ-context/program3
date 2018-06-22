package com.ppxia.billing.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;/**
 * 操作日志实体类
 * @author Liuxinyu
 *
 */

@Entity
@Table(name="t_operate_log")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class OperateLogBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private  Long id;//操作者的id
    
	@Column(name="operate_manager_name",length=20)
    private String operateManagerName;//操作者的名称
  
	@Column(name="operate_manager_type",length=20)
    private String  operateManagerType;//操作者的类型
   
	@Column(name="operate_time")
    private  Date   operateTime;//操作时间
   
	@Column(name="system_model",length=20)
    private String  systemModel;//系统板块
   
	@Column(name="operate_operation",length=20)
    private  String operateOperation;//操作行为
	public OperateLogBean() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOperateManagerName() {
		return operateManagerName;
	}
	public void setOperateManagerName(String operateManagerName) {
		this.operateManagerName = operateManagerName;
	}
	public String getOperateManagerType() {
		return operateManagerType;
	}
	public void setOperateManagerType(String operateManagerType) {
		this.operateManagerType = operateManagerType;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public String getSystemModel() {
		return systemModel;
	}
	public void setSystemModel(String systemModel) {
		this.systemModel = systemModel;
	}
	public String getOperateOperation() {
		return operateOperation;
	}
	public void setOperateOperation(String operateOperation) {
		this.operateOperation = operateOperation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "OperateLogBean [id=" + id + ", operateManagerName=" + operateManagerName + ", operateManagerType="
				+ operateManagerType + ", operateTime=" + operateTime + ", systemModel=" + systemModel
				+ ", operateOperation=" + operateOperation + "]";
	}
	
}
