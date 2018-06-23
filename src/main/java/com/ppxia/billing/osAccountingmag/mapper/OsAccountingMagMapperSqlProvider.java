package com.ppxia.billing.osAccountingmag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;

/**
 * UserMapper.java 中接口的SQL提供类
 * 
 * @author pu
 *
 */
public class OsAccountingMagMapperSqlProvider {

	/**
	 * UserMapper 中 queryUserListByMap()的SQL提供方法
	 * 根据传入的账务账号名字和月份,查询某个账务账号下该月的所有os账号费用明细 提供页数进入分页对象传入
	 * 
	 * @param params
	 * @return
	 */
	public String queryOsYearAccountingByParams(Map<String, Object> params) {
		Map map = (Map) params.get("map");

		StringBuilder sb = new StringBuilder(
				"select oy.id as id,os.os_account as OsAccount,oy.server_ip as IP,oy.year_total_time as YearTotalTime,oy.year as Year "
						+ "from t_os_year oy, t_os os where oy.fk_os_id=os.id ");
		if (!StringUtils.isEmpty(map.get("osAccount"))) {
			sb.append("and os.os_account like '" + map.get("osAccount") + "%'");
		}
		if (!StringUtils.isEmpty(map.get("IP"))) {
			sb.append("and oy.server_ip like '" + map.get("IP") + "%'");
		}
		if (!StringUtils.isEmpty(map.get("Year"))) {
			sb.append("and oy.year like '" + map.get("Year") + "%'");
		}
		sb.append("limit " + map.get("index") + " ,10");

		return sb.toString();
	}

	public String queryOsYearAccountingTotals(Map params) {
		Map map = (Map) params.get("map");
		StringBuilder sb = new StringBuilder("select count(*) from t_os_year oy, t_os os where oy.fk_os_id=os.id ");
		if (!StringUtils.isEmpty(map.get("osAccount"))) {
			sb.append("and os.os_account like '" + map.get("osAccount") + "%'");
		}
		if (!StringUtils.isEmpty(map.get("IP"))) {
			sb.append("and oy.server_ip like '" + map.get("IP") + "%'");
		}
		if (!StringUtils.isEmpty(map.get("Year"))) {
			sb.append("and oy.year like '" + map.get("Year") + "%'");
		}
		return sb.toString();
	}

	public String queryOsMonthAccountingByParams(Map<String, Object> params) {
		Map map = (Map) params.get("map");

		StringBuilder sb = new StringBuilder(
				"select om.id as id,os.os_account as OsAccount,om.server_ip as IP,om.total_time as totalTime,om.month as month "
						+ "from t_os_month om, t_os os where om.fk_os_id=os.id ");
		if (!StringUtils.isEmpty(map.get("osAccount"))) {
			sb.append("and os.os_account like '" + map.get("osAccount") + "%'");
		}
		if (!StringUtils.isEmpty(map.get("IP"))) {
			sb.append("and om.server_ip like '" + map.get("IP") + "%'");
		}
		if (!StringUtils.isEmpty(map.get("month"))) {
			sb.append("and om.month like '" + map.get("month") + "%'");
		}
		sb.append("limit " + map.get("index") + " ,10");

		return sb.toString();
	}

	public String queryOsMonthAccountingTotals(Map params) {
		Map map = (Map) params.get("map");
		StringBuilder sb = new StringBuilder("select count(*) from t_os_month om, t_os os where om.fk_os_id=os.id ");
		if (!StringUtils.isEmpty(map.get("osAccount"))) {
			sb.append("and os.os_account like '" + map.get("osAccount") + "%'");
		}
		if (!StringUtils.isEmpty(map.get("IP"))) {
			sb.append("and om.server_ip like '" + map.get("IP") + "%'");
		}
		if (!StringUtils.isEmpty(map.get("month"))) {
			sb.append("and om.month like '" + map.get("month") + "%'");
		}
		return sb.toString();
	}

	public String queryOsDayAccountingByParams(Map<String, Object> params) {
		Map map = (Map) params.get("map");

		StringBuilder sb = new StringBuilder(
				"select od.id as id,os.os_account as OsAccount,od.server_ip as IP,od.total_time as totalTime,od.login_time as LoginTime "
						+ "from t_os_day od, t_os os where od.fk_os_id=os.id ");
		if (!StringUtils.isEmpty(map.get("osAccount"))) {
			sb.append("and os.os_account like '" + map.get("osAccount") + "%'");
		}
		if (!StringUtils.isEmpty(map.get("IP"))) {
			sb.append("and od.server_ip like '" + map.get("IP") + "%'");
		}
		sb.append("limit " + map.get("index") + " ,10");

		return sb.toString();
	}

	public String queryOsDayAccountingTotals(Map params) {
		Map map = (Map) params.get("map");
		StringBuilder sb = new StringBuilder("select count(*) from t_os_day od, t_os os where od.fk_os_id=os.id ");
		if (!StringUtils.isEmpty(map.get("osAccount"))) {
			sb.append("and os.os_account like '" + map.get("osAccount") + "%'");
		}
		if (!StringUtils.isEmpty(map.get("IP"))) {
			sb.append("and od.server_ip like '" + map.get("IP") + "%'");
		}

		return sb.toString();
	}

}
