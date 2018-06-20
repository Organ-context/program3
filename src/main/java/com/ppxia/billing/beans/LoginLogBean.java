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
import org.hibernate.annotations.OptimisticLocking;

//登陆日志实体
@Entity
@Table(name="t_login_log")
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class LoginLogBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GenericGenerator(name = "hibernate.id", strategy = "identity")
	@GeneratedValue(generator = "hibernate.id")
	private Long id;//id
	
	@Column(name="login_manager_name",length=20)
    private String LoginManagerName;//登录的管理者名称
	
	@Column(name="login_manager_type",length=20)
	private String LoginManagerType;//管理员的类型
	
	@Column(name="login_operate_time")
	private Date LoginOperateTime;//登录时间
	
	@Column(name="ip",length=20)
    private String ip;//登录的ip
	
	@Column(name="login_operation",length=20)
	private String LoginOperation;//登录的行为描述
	public LoginLogBean() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginManagerName() {
		return LoginManagerName;
	}
	public void setLoginManagerName(String loginManagerName) {
		LoginManagerName = loginManagerName;
	}
	public String getLoginManagerType() {
		return LoginManagerType;
	}
	public void setLoginManagerType(String loginManagerType) {
		LoginManagerType = loginManagerType;
	}
	public Date getLoginOperateTime() {
		return LoginOperateTime;
	}
	public void setLoginOperateTime(Date loginOperateTime) {
		LoginOperateTime = loginOperateTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLoginOperation() {
		return LoginOperation;
	}
	public void setLoginOperation(String loginOperation) {
		LoginOperation = loginOperation;
	}
	@Override
	public String toString() {
		return "LoginLogBean [id=" + id + ", LoginManagerName=" + LoginManagerName + ", LoginManagerType="
				+ LoginManagerType + ", LoginOperateTime=" + LoginOperateTime + ", ip=" + ip + ", LoginOperation="
				+ LoginOperation + "]";
	}
	
}
