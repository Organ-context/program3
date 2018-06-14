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
//t_os_month  
//业务月账单
@Entity
@Table(name="t_os_month")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class OsMonthBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Long id;//id//id bigint
	
	@Column(name="month")
    private Date month;//账单分份//month date
  
	@Column(name="total_time")
    private Long totalTime;//使用时长  //total_time  bigint
    
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.SAVE_UPDATE})
	@JoinColumn(name="fk_os_id")
    private OsBean osBean;//业务实体对象//fk_os_id  bigint//private Long fk_os_id;//业务账号
   
    @Column(name="month_coast")
    private double monthCoast;//费用 //month_coast  decimal
   
    
	@Column(name="ip",length=20)
    private String  IP; //ip varchar
    
	@Column(name="costType",length=20)
    private int costType;//资费类型//costType  int
    
    public OsMonthBean() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public Long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Long totalTime) {
		this.totalTime = totalTime;
	}

	public OsBean getOsBean() {
		return osBean;
	}

	public void setOsBean(OsBean osBean) {
		this.osBean = osBean;
	}

	public double getMonthCoast() {
		return monthCoast;
	}

	public void setMonthCoast(double monthCoast) {
		this.monthCoast = monthCoast;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public int getCostType() {
		return costType;
	}

	public void setCostType(int costType) {
		this.costType = costType;
	}

	@Override
	public String toString() {
		return "OsMonthBean [id=" + id + ", month=" + month + ", totalTime=" + totalTime + ", osBean=" + osBean
				+ ", monthCoast=" + monthCoast + ", IP=" + IP + ", costType=" + costType + "]";
	}
    
}
