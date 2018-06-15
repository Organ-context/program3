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
//t_operate_log 
@Entity
@Table(name="t_operate_log")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class OperateLogBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private  Long id;//id//id  bigint
    
	@Column(name="operate_manager_name",length=20)
    private String OperateManagerName;//管理员名称//operate_manager_name varchar
  
	@Column(name="operate_manager_type",length=20)
    private String  OperateManagerType;//操作类型  //operate_manager_type varchar
   
	@Column(name="operate_time")
    private  Date   OperateTime;//操作时间 //operate_time  date
   
	@Column(name="system_model",length=11)
    private int   SystemModel;//系统模块 //system_model  int
   
	@Column(name="operate_operation",length=20)
    private  String OperateOperation;//操作 //operate_operation varchar
	public OperateLogBean() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOperateManagerName() {
		return OperateManagerName;
	}
	public void setOperateManagerName(String operateManagerName) {
		OperateManagerName = operateManagerName;
	}
	public String getOperateManagerType() {
		return OperateManagerType;
	}
	public void setOperateManagerType(String operateManagerType) {
		OperateManagerType = operateManagerType;
	}
	public Date getOperateTime() {
		return OperateTime;
	}
	public void setOperateTime(Date operateTime) {
		OperateTime = operateTime;
	}
	public int getSystemModel() {
		return SystemModel;
	}
	public void setSystemModel(int systemModel) {
		SystemModel = systemModel;
	}
	public String getOperateOperation() {
		return OperateOperation;
	}
	public void setOperateOperation(String operateOperation) {
		OperateOperation = operateOperation;
	}
	@Override
	public String toString() {
		return "OperateLogBean [id=" + id + ", OperateManagerName=" + OperateManagerName + ", OperateManagerType="
				+ OperateManagerType + ", OperateTime=" + OperateTime + ", SystemModel=" + SystemModel
				+ ", OperateOperation=" + OperateOperation + "]";
	}
	
}
