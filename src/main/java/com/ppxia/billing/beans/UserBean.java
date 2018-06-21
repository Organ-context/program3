package com.ppxia.billing.beans;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//用户实体类
//t_user
@Entity
@Table(name = "t_user")
@OptimisticLocking(type = OptimisticLockType.VERSION)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	// id bigint
	@Id
	@Column
	@GenericGenerator(name = "hibernate.id", strategy = "identity")
	@GeneratedValue(generator = "hibernate.id")
	private Long id;// 用户id
	// user_name varchar
	@Column(name = "user_name", length = 20)

	private String userName;// 用户名
	// user_password varchar
	@Column(name = "user_password", length = 20)

	private String userPassword;// 用户密码
	// gender int
	private int gender;// 性别
	// user_idcard varchar
	@Column(name = "user_idcard", length = 20)

	private String userIdcard;// 身份证号码
	// user_accounting_name varchar
	@Column(name = "user_accounting_name", length = 20)
	private String userAccountingName;// 账务账号

	// user_accounting_state int
	@Column(name = "user_accounting_state", length = 11)
	private int userAccountingState;// 账务账号状态
	// user_address varchar
	@Column(name = "user_address", length = 20)
	private String userAddress;// 通讯地址
	// user_postnum int
	@Column(name = "user_postnum", length = 11)
	private int userPostnum;// 邮编
	// user_qqnum bigint
	@Column(name = "user_qqnum")
	private Long userQqnum;// QQ号码

	@ManyToOne(fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinColumn(name = "fk_role_id")
	private RoleBean roleBean;// 角色实体对象

	@Column(name = "user_telephone")
	private Long telephone;// 用户的电话号码

	@Column(name = "user_email")
	private String email;// 用户的邮箱

	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getUserIdcard() {
		return userIdcard;
	}

	public void setUserIdcard(String userIdcard) {
		this.userIdcard = userIdcard;
	}

	public String getUserAccountingName() {
		return userAccountingName;
	}

	public void setUserAccountingName(String userAccountingName) {
		this.userAccountingName = userAccountingName;
	}

	public int getUserAccountingState() {
		return userAccountingState;
	}

	public void setUserAccountingState(int userAccountingState) {
		this.userAccountingState = userAccountingState;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getUserPostnum() {
		return userPostnum;
	}

	public void setUserPostnum(int userPostnum) {
		this.userPostnum = userPostnum;
	}

	public Long getUserQqnum() {
		return userQqnum;
	}

	public void setUserQqnum(Long userQqnum) {
		this.userQqnum = userQqnum;
	}

	public RoleBean getRoleBean() {
		return roleBean;
	}

	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", gender=" + gender
				+ ", userIdcard=" + userIdcard + ", userAccountingName=" + userAccountingName + ", userAccountingState="
				+ userAccountingState + ", userAddress=" + userAddress + ", userPostnum=" + userPostnum + ", userQqnum="
				+ userQqnum + ", roleBean=" + roleBean + ", telephone=" + telephone + ", email=" + email + "]";
	}

}
