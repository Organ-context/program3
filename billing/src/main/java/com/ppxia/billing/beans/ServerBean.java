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
//服务器实体对象
//t_server
@Entity
@Table(name="t_server")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class ServerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Long id;//id  bigint
	
	@Column(name="server_ip",length=20)
	private String server_ip;//服务器地址//server_ip  varchar
	public ServerBean() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getServer_ip() {
		return server_ip;
	}
	public void setServer_ip(String server_ip) {
		this.server_ip = server_ip;
	}
	@Override
	public String toString() {
		return "ServerBean [id=" + id + ", server_ip=" + server_ip + "]";
	}
	
}
