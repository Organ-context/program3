package com.ppxia.billing.Echarts.mapper;

import java.util.Map;

public class EchartsMapperSqlProvider {

	public String queryOsMonthEchartsParams(Map<String, Object> params) {
		Map map = (Map) params.get("map");
		StringBuilder sb = new StringBuilder(
       "select om.id as id,os.os_account as OsAccount,om.server_ip as IP,om.total_time as totalTime,om.month_coast as monthCoast,om.tariff_type as costType from t_os_month om, t_os os, t_user u"
       + " where om.fk_os_id=os.id and os.fk_user_id=u.id "
       + "and u.user_accounting_name like '"+map.get("accountingName")+"%'"
       + "and om.month like '"+map.get("Month")+"%'");

		return sb.toString();
	}
}
