package com.ppxia.billing.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
//权限实体类
//t_authority
@Entity
@Table(name="t_authority")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class AuthorityBean implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Long  id;//权限id
	
	@Column(name="authority_name",length=20)
   	private String authorityName;//权限名称//authority_name varchar
   	
	@Column(name="authority_num",length=11)
   	private int authorityNum;//权限编号//authority_num int
	public AuthorityBean() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public int getAuthorityNum() {
		return authorityNum;
	}
	public void setAuthorityNum(int authorityNum) {
		this.authorityNum = authorityNum;
	}
	@Override
	public String toString() {
		return "AuthorityBean [id=" + id + ", authorityName=" + authorityName + ", authorityNum=" + authorityNum + "]";
	}
	
}
