package com.ppxia.billing.logmag.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ppxia.billing.beans.LoginLogBean;


//操作日志的持久层
public interface ILoginlogQueryDao {

    //获得集合 
	/**
	 * 根据参数查询登录日志集合
	 * @param params 页面参数
	 * @return 返回分页的管理员集合
	 */
    public List<LoginLogBean> findPagerByLoginlogBean(Map params);

	/**
	 * 总条数
	 * @param map
	 */
	public int findAllByNum(Map map);

	
}