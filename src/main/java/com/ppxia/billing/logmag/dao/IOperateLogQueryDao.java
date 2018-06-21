package com.ppxia.billing.logmag.dao;

import java.util.List;
import java.util.Map;

import com.ppxia.billing.beans.LoginLogBean;
import com.ppxia.billing.beans.OperateLogBean;





//操作日志的持久层
public interface IOperateLogQueryDao {
   /**
	 * 根据参数查询登录日志集合
	 * @param params 页面参数
	 * @return 返回分页的管理员集合
	 */
    public List<OperateLogBean> findPagerByOperateLogBean(Map params);
    /**
     * 根据参数查询登录日志的总数
     * @param params  页面参数
     * @return   返回登录日志总数
     */
	public int findAllByNum(Map map);

	
}