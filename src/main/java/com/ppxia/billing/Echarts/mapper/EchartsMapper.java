package com.ppxia.billing.Echarts.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.ppxia.billing.beans.OsMonthBean;
import com.ppxia.billing.osmag.mapper.OsMagMapperSqlProvider;

public interface EchartsMapper {
	@Results({
		  @Result(id=true,property="id",column="id",javaType=Long.class),
		  @Result(property="IP",column="IP",javaType=String.class),
		  @Result(property="totalTime",column="totalTime",javaType=Long.class),
		  @Result(property="monthCoast",column="monthCoast",javaType=Double.class),
		  @Result(property="costType",column="costType",javaType=Integer.class),
		  @Result(property="osBean.OsAccount",column="OsAccount",javaType=String.class)		 
	  })
	    @SelectProvider(type=EchartsMapperSqlProvider.class,method="queryOsMonthEchartsParams")
		public List<OsMonthBean> findOsMonthEchartsByMap(@Param("map")Map map);
}
