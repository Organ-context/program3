package com.ppxia.billing.osAccountingmag.service;

import java.util.Map;

import com.ppxia.billing.beans.PagerBean;

public interface IOsaccountingQueryService {

        /**
         * 根据条件查询年账务账单的分页对象
         * @param pager 分页
         * @param params  传入三个参 业务账号 实验室名字 年份
         * @return 返回分页对象
         */
		public PagerBean findOsYearAccountingByParams(PagerBean pager,Map params);
		
		
		
		  /**
         * 根据条件查询月账务账单的分页对象
         * @param pager  分页
         * @param params 包含三个参数 业务账号 实验室名字 月份
         * @return 返回分页对象
         */
		public PagerBean findOsMonthAccountingByParams(PagerBean pager,Map params);
		
		
		
		  /**
         * 根据条件查询日账务账单的分页对象
         * @param pager  分页
         * @param params 包含三个参数 业务账号 实验室名字 日期
         * @return 返回分页对象
         */
		public PagerBean findOsDayAccountingByParams(PagerBean pager,Map params);
}
