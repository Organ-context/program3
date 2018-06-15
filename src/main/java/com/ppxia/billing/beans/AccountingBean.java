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

@Entity
@Table(name="t_accounting_month")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class AccountingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6615410434441419596L;
	
	@Id
	@Column
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
    private Long id;//id  bigint
    
    @Column(name="pay_condition",length=11)
	private int  payCondition;//支付状态pay_condition  int
    
    @Column(name="pay_way",length=11)
	private int payWay;//支付方式//pay_way  int
    
    @Column(name="month_coast")
	private double monthCoast;//费用//month_coast  decimal
   
    @ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.SAVE_UPDATE})
	@JoinColumn(name="fk_user_id")
    private UserBean userBean;//private Long  fk_user_id;//账务账号外键//bigint
	
    @Column(name="month")
    private  Date month;//月份//month  date

	public AccountingBean(int payCondition, int payWay, double monthCoast, UserBean userBean, Date month) {
		super();
		this.payCondition = payCondition;
		this.payWay = payWay;
		this.monthCoast = monthCoast;
		this.userBean = userBean;
		this.month = month;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPayCondition() {
		return payCondition;
	}

	public void setPayCondition(int payCondition) {
		this.payCondition = payCondition;
	}

	public int getPayWay() {
		return payWay;
	}

	public void setPayWay(int payWay) {
		this.payWay = payWay;
	}

	public double getMonthCoast() {
		return monthCoast;
	}

	public void setMonthCoast(double monthCoast) {
		this.monthCoast = monthCoast;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "AccountingBean [id=" + id + ", payCondition=" + payCondition + ", payWay=" + payWay + ", monthCoast="
				+ monthCoast + ", userBean=" + userBean + ", month=" + month + "]";
	}

}
