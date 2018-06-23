package com.ppxia.billing.tariffmag.mapper;

import java.util.List;
import java.util.Map;

import javax.persistence.OneToOne;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.ppxia.billing.beans.OsBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.ServerBean;
import com.ppxia.billing.beans.TariffBean;
import com.ppxia.billing.beans.UserBean;

public interface TariffMapper {
	// 查询所有资费分页显示
	@Results({
			@Result(id=true,property = "id",column="oid",javaType=Long.class),
			@Result(property ="osAccount",column="os_account",javaType=String.class),
			@Result(property ="osState",column="os_state",javaType=Integer.class),
			@Result(property ="tariffBean",column="fk_tariff_id",javaType=TariffBean.class,one=@One(fetchType=FetchType.LAZY,select="com.ppxia.billing.tariffmag.mapper.TariffMapper.findTariffById")),
			@Result(property ="serverBean",column="fk_server_id",javaType=ServerBean.class,one=@One(fetchType=FetchType.LAZY,select="com.ppxia.billing.tariffmag.mapper.TariffMapper.findServerById")),
			@Result(property ="userBean",column="fk_user_id",javaType=UserBean.class,one=@One(fetchType=FetchType.LAZY,select="com.ppxia.billing.usermag.mapper.UserMapper.getManager"))
	})
	@SelectProvider(type=TariffMapperSqlProvider.class,method="findTariffByParams")
	public List<OsBean> findPagerByParams(Map map);
	
	
	//查询所有满足要求的数据条数
	@SelectProvider(type=TariffMapperSqlProvider.class,method="findTariffByAll")
	public int findTariffByAll(Map map);

	// 查询系统所有的资费名称
	@ResultType(TariffBean.class)
	@Select("select id, tariff_name as tariffName from t_tariff")
	public List<TariffBean> findAllTariffName();
	
	
	//通过资费名查询id
	@Select("select id from t_tariff where tariff_name = #{name}")
	public int findIdByName(@Param("name")String name);
	
	//通过ID查询资费对象
	@ResultType(TariffBean.class)
	@Select("select id,tariff_name as tariffName,basic_cost as basicCost,per_cost as perCost from t_tariff where id = #{id}")
	public TariffBean findTariffById(Long id);
	
	//通过ID查询服务器对象
	@ResultType(ServerBean.class)
	@Select("select * from t_server where id = #{id}")
	public ServerBean findServerById(Long id);
}
