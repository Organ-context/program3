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
    private String OperateManagerName;//操作者的名称
  
	@Column(name="operate_manager_type",length=20)
    private String  OperateManagerType;//操作者的类型
   
	@Column(name="operate_time")
    private  Date   OperateTime;//操作时间
   
	@Column(name="system_model",length=20)
    private String  SystemModel;//系统板块
   
	@Column(name="operate_operation",length=20)
    private  String OperateOperation;//操作行为
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
	public String getSystemModel() {
		return SystemModel;
	}
	public void setSystemModel(String systemModel) {
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
