package com.ppxia.billing.osmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.ppxia.billing.beans.OsBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.ServerBean;
import com.ppxia.billing.beans.TariffBean;
import com.ppxia.billing.beans.UserBean;

public interface OsBeanMapper {
	// 根据账务账单号与月份查询月度业务账单分页对象
	public PagerBean findOsMonthBeansByAccountingAndMonth(int accountingNum, Date month);

	// 据业务账单号与月份查询业务日账单
	public PagerBean findOsDayBeansByOsNumAndMonth(int osNum, Date month);

	// 通过姓名或业务账号查询业务账号信息
	@Results({ @Result(id = true, property = "id", column = "id", javaType = Long.class),
			@Result(property = "UserName", column = "u.user_name", javaType = String.class),
			@Result(property = "userAccountingName", column = "u.user_accounting_name", javaType = String.class),
			@Result(property = "OsAccount", column = "o.os_account", javaType = String.class),
			@Result(property = "OsState", column = "o.os_state", javaType = Integer.class),
			@Result(property = "ServerIp", column = "o.os_state,s.server_ip", javaType = String.class),
			@Result(property = "tariffName", column = "t.tariff_name", javaType = String.class), })
	@SelectProvider(type = OsBeanMapperSqlProvider.class, method = "findOsByNameOrOsName")
	public List<UserBean> findOsByNameOrOsName(@Param("params") Map params);

	// 通过姓名或业务账号查询业务总条数
	@SelectProvider(type = OsBeanMapperSqlProvider.class, method = "findByAll")
	public int findByAll(@Param("params") Map params);

	// 通过ID查询业务账号
	@Results({ @Result(id = true, property = "id", column = "oid", javaType = Long.class),
			@Result(property = "osAccount", column = "os_account", javaType = String.class),
			@Result(property = "osState", column = "os_state", javaType = Integer.class),
			@Result(property = "tariffBean", column = "fk_tariff_id", javaType = TariffBean.class, one = @One(fetchType = FetchType.LAZY, select = "com.ppxia.billing.tariffmag.mapper.TariffMapper.findTariffById")),
			@Result(property = "serverBean", column = "fk_server_id", javaType = ServerBean.class, one = @One(fetchType = FetchType.LAZY, select = "com.ppxia.billing.tariffmag.mapper.TariffMapper.findServerById")),
			@Result(property = "userBean", column = "fk_user_id", javaType = UserBean.class, one = @One(fetchType = FetchType.LAZY, select = "com.ppxia.billing.usermag.mapper.UserMapper.getManager")) })
	@Select("select o.id as oid,os_account,os_state,fk_tariff_id,fk_server_id,fk_user_id from t_tariff as t, t_user as u ,t_server as s ,t_os as o where o.id = #{id} and u.id=o.fk_user_id and o.fk_tariff_id =t.id and o.fk_server_id = s.id")
	public OsBean findOsBeanById(Long id);

}
