package com.ppxia.billing.accountingMonthmag.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;



/**
 * UserMapper.java 中接口的SQL提供类
 * 
 * @author pu
 *
 */
public class AccountingMonthMapperSqlProvider {

	/**
	 * UserMapper 中 queryUserListByMap()的SQL提供方法
	 * 根据传入的账务账号名字和月份,查询某个账务账号下该月的所有os账号费用明细 提供页数进入分页对象传入
	 * @param params
	 * @return
	 */
	public String queryAccMonthByParams(Map<String, Object> params) {
		Map map = (Map) params.get("map");
		StringBuilder sb = new StringBuilder(
       "select am.id as id,u.user_name as userName,u.user_accounting_name as userAccountingName,u.user_idcard as userIdcard,am.month_coast as monthCoast,am.pay_condition as payCondition,am.pay_way as payWay,am.month as month from t_accounting_month am, t_user u"
       + " where am.fk_user_id=u.id ");
          if(!StringUtils.isEmpty(map.get("userName"))) {
        	  sb.append("and u.user_name like '"+map.get("userName")+"%'");
          }
          if(!StringUtils.isEmpty(map.get("accountName"))) {
        	  sb.append("and u.user_accounting_name like '"+map.get("accountName")+"%'");
          }
          if(!StringUtils.isEmpty(map.get("idcard"))) {
        	  sb.append("and u.user_idcard like '"+map.get("idcard")+"%'");
          }
          if(!StringUtils.isEmpty(map.get("time"))) {
        	  sb.append("and am.month like '"+map.get("time")+"%'");
          }
          sb.append("limit "+map.get("index")+" ,10");

		return sb.toString();
	}
	
	
	public String queryAccMonthTotals(Map<String, Object> params) {
		Map map = (Map) params.get("map");
		StringBuilder sb = new StringBuilder(
       "select count(*) from t_accounting_month am, t_user u"
       + " where am.fk_user_id=u.id ");
          if(StringUtils.isEmpty(map.get("userName"))) {
        	  sb.append("and u.user_name like '"+map.get("userName")+"%'");
          }
          if(StringUtils.isEmpty(map.get("accountName"))) {
        	  sb.append("and u.user_accounting_name like '"+map.get("accountName")+"%'");
          }
          if(StringUtils.isEmpty(map.get("idcard"))) {
        	  sb.append("and u.user_idcard like '"+map.get("idcard")+"%'");
          }
          if(StringUtils.isEmpty(map.get("time"))) {
        	  sb.append("and am.month like '"+map.get("time")+"%'");
          }

		return sb.toString();
	}


}
