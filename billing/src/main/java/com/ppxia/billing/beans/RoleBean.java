package com.ppxia.billing.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
//t_role   角色实体类
@Entity
@Table(name="t_role")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class RoleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@Column
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Long id;//角色Id//id bigint
	
	@Column(name="role_type",length=11)
	private  int roleType;//角色类型//role_type  int
	
	@Column(name="role_name",length=20)
	private  String roleName;//角色名称//role_name  varchar

	private Set<AuthorityBean>  authoritys;
	public RoleBean() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getRoleType() {
		return roleType;
	}
	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<AuthorityBean> getAuthoritys() {
		return authoritys;
	}
	public void setAuthoritys(Set<AuthorityBean> authoritys) {
		this.authoritys = authoritys;
	}
	@Override
	public String toString() {
		return "RoleBean [id=" + id + ", roleType=" + roleType + ", roleName=" + roleName + ", authoritys=" + authoritys
				+ "]";
	}
	
}
