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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * OS 业务账号实体对象
 * @author Liuxinyu
 *
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Entity
@Table(name="t_os")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class OsBean implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Long id;//业务id
	
	@Column(name="os_account",length=20)
    private String OsAccount;//业务账号名//os_account  varchar
	
	@Column(name="os_state",length=11)
	private int osState;//业务账号状态
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="fk_tariff_id")
    private TariffBean tariffBean;//资费实体对象//private Long fk_tariff_id;//资费方式外键
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.SAVE_UPDATE})
	@JoinColumn(name="fk_server_id")
	private ServerBean serverBean;//服务器实体对象 //private Long fk_server_id;//服务器外键
	
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="fk_user_id")
	private UserBean userBean;//用户实体对象//private Long fk_user_id;//用户外键
	
	public OsBean() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOsAccount() {
		return OsAccount;
	}

	public void setOsAccount(String osAccount) {
		this.OsAccount = osAccount;
	}

	public TariffBean getTariffBean() {
		return tariffBean;
	}

	public void setTariffBean(TariffBean tariffBean) {
		this.tariffBean = tariffBean;
	}

	public ServerBean getServerBean() {
		return serverBean;
	}

	public void setServerBean(ServerBean serverBean) {
		this.serverBean = serverBean;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public int getOsState() {
		return osState;
	}

	public void setOsState(int osState) {
		this.osState = osState;
	}

	@Override
	public String toString() {
		return "OsBean [id=" + id + ", osAccount=" + OsAccount + ", osState=" + osState + ", tariffBean=" + tariffBean
				+ ", serverBean=" + serverBean + ", userBean=" + userBean + "]";
	}
	
}
