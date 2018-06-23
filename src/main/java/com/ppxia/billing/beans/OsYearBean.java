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
//t_os_year 业务年账单
@Entity
@Table(name="t_os_year")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class OsYearBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Long id;////id bigint
	
	@Column(name="year",length=20)
    private String Year;//账单年份//year date
   
	@Column(name="year_total_time")
    private Long YearTotalTime;//使用时长 //year_total_time  bigint
   
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.SAVE_UPDATE})
	@JoinColumn(name="fk_os_id")
    private OsBean osBean;//业务实体对象 //fk_os_id  bigint//private Long fk_os_id;//业务账号
	
	@Column(name="server_ip",length=20)
	private String IP;////ip  varchar
	public OsYearBean() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public Long getYearTotalTime() {
		return YearTotalTime;
	}
	public void setYearTotalTime(Long yearTotalTime) {
		YearTotalTime = yearTotalTime;
	}
	public OsBean getOsBean() {
		return osBean;
	}
	public void setOsBean(OsBean osBean) {
		this.osBean = osBean;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	@Override
	public String toString() {
		return "OsYearBean [id=" + id + ", Year=" + Year + ", YearTotalTime=" + YearTotalTime + ", osBean=" + osBean
				+ ", IP=" + IP + "]";
	}
	
}
