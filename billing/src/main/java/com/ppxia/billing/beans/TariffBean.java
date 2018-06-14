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
//资费实体
//t_tariff
@Entity
@Table(name="t_tariff")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class TariffBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8559835059707967471L;

	@Id
	@Column
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Long id;//id bigint

	@Column(name="tariff_name",length=20)
	private String tariffName;//资费方式	//tariff_name  varchar
	
	@Column(name="basic_cost",length=11)
	private int basicCost;//基础费用//basic_cost  int
	
	@Column(name="per_cost")
	private double perCost;//单位费用//per_cost  decimal

	public TariffBean(String tariffName, int basicCost, double perCost) {
		super();
		this.tariffName = tariffName;
		this.basicCost = basicCost;
		this.perCost = perCost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTariffName() {
		return tariffName;
	}

	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}

	public int getBasicCost() {
		return basicCost;
	}

	public void setBasicCost(int basicCost) {
		this.basicCost = basicCost;
	}

	public double getPerCost() {
		return perCost;
	}

	public void setPerCost(double perCost) {
		this.perCost = perCost;
	}

	@Override
	public String toString() {
		return "TariffBean [id=" + id + ", tariffName=" + tariffName + ", basicCost=" + basicCost + ", perCost="
				+ perCost + "]";
	}
	
	
}
