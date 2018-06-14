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
/**
 * OS日实体对象
 * @author Liuxinyu
 *
 */
//t_os_day
@Entity
@Table(name="t_os_day")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class OsDayBean implements Serializable {

	private static final long serialVersionUID = 1L;
   
	@Id
	@Column
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Long id;//id //id  bigint
	
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.SAVE_UPDATE})
	@JoinColumn(name="fk_os_id")
    private OsBean osBean;//业务实体对象//fk_os_id  bigint//private Long fk_os_id;//业务账号
   
	@Column(name="login_time")
    private Date LoginTime;//登入时间 //login_time  datetime
   
	@Column(name="out_time")
    private Date OutTime;//登出时间 //out_time   datetime
   
	@Column(name="total_time")
    private Long TotalTime;//使用时长 //total_time datetime
   
	@Column(name="day_coast")
    private double DayCoast;//费用 //day_coast decimal
   
	@Column(name="ip",length=20)
    private  String IP;//IP //ip  varchar
    
	@Column(name="costType",length=11)
    private  int  costType;//资费类型//costType   int
    
	public OsDayBean() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OsBean getOsBean() {
		return osBean;
	}

	public void setOsBean(OsBean osBean) {
		this.osBean = osBean;
	}

	public Date getLoginTime() {
		return LoginTime;
	}

	public void setLoginTime(Date loginTime) {
		LoginTime = loginTime;
	}

	public Date getOutTime() {
		return OutTime;
	}

	public void setOutTime(Date outTime) {
		OutTime = outTime;
	}

	public Long getTotalTime() {
		return TotalTime;
	}

	public void setTotalTime(Long totalTime) {
		TotalTime = totalTime;
	}

	public double getDayCoast() {
		return DayCoast;
	}

	public void setDayCoast(double dayCoast) {
		DayCoast = dayCoast;
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
		return "OsDayBean [id=" + id + ", osBean=" + osBean + ", LoginTime=" + LoginTime + ", OutTime=" + OutTime
				+ ", TotalTime=" + TotalTime + ", DayCoast=" + DayCoast + ", IP=" + IP + ", costType=" + costType + "]";
	}
	
}
