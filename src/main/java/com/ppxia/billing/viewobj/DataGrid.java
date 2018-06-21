package com.ppxia.billing.viewobj;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class DataGrid implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1304947483022081858L;
	/**
	 * total总条数
	 * rows 数据集合
	 */
	private Long total;
	private List<?> rows;
	
	public DataGrid() {
		// TODO Auto-generated constructor stub
	}

	public DataGrid(Long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DataGrid [total=" + total + ", rows=" + rows + "]";
	}
	

}
