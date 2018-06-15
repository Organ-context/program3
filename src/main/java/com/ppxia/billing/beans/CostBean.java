package com.ppxia.billing.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
//业务实体类
//t_cost
@Entity
@Table(name="t_cost")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class CostBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
	@Column
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
    private Long id;//业务实体id
    
	@Column(name="os_account",length=20)
	private String osAccount;//业务账号//os_account varchar
  
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.SAVE_UPDATE})
	@JoinColumn(name="fk_server_id")
	private ServerBean serverBean;//服务器//private Long fk_server_id;//服务器
	
	@Column(name="login_time")
	private Date loginTime;//登入时间//login_time datetime
	
	@Column(name="exit_time")
	private Date exitTime;//退出时间//exit_time datetime
	
	@Column(name="use_time",length=11)
	private int useTime;//使用时长//use_time int
	public CostBean() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOsAccount() {
		return osAccount;
	}
	public void setOsAccount(String osAccount) {
		this.osAccount = osAccount;
	}
	public ServerBean getServerBean() {
		return serverBean;
	}
	public void setServerBean(ServerBean serverBean) {
		this.serverBean = serverBean;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getExitTime() {
		return exitTime;
	}
	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
	}
	public int getUseTime() {
		return useTime;
	}
	public void setUseTime(int useTime) {
		this.useTime = useTime;
	}
	@Override
	public String toString() {
		return "CostBean [id=" + id + ", osAccount=" + osAccount + ", serverBean=" + serverBean + ", loginTime="
				+ loginTime + ", exitTime=" + exitTime + ", useTime=" + useTime + "]";
	}
	
}
