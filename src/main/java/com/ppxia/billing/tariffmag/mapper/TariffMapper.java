package com.ppxia.billing.tariffmag.mapper;

import java.util.List;
import java.util.Map;

import javax.persistence.OneToOne;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.TariffBean;
import com.ppxia.billing.beans.UserBean;

public interface TariffMapper {
	// 查询所有资费分页显示
	@Results({
			@Result(id=true,property = "id",column="id",javaType=Long.class),
			@Result(property ="userName",column="user_name",javaType=String.class),
			@Result(property ="userAccountingName",column="user_accounting_name",javaType=String.class),
			@Result(property ="tariffName",column="t.tariff_name",javaType=String.class),
			@Result(property ="serverIp",column="s.server_ip",javaType=String.class),
	})
	@SelectProvider(type=TariffMapperSqlProvider.class,method="findTariffByParams")
	public List<UserBean> findPagerByParams( Map map);
	
	
	//查询所有满足要求的数据条数
	@SelectProvider(type=TariffMapperSqlProvider.class,method="findTariffByAll")
	public int findTariffByAll(Map map);

	// 查询系统所有的资费名称
	@ResultType(TariffBean.class)
	@Select("select tariff_name from t_tariff")
	public List<TariffBean> findAllTariffName();
	
	
	//通过资费名查询id
	@Select("select id from t_tariff where tariff_name = #{name}")
	public int findIdByName(@Param("name")String name);
}
