package com.ppxia.billing.prosceniummag.dao.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ppxia.billing.beans.OsDayBean;
import com.ppxia.billing.beans.OsMonthBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.prosceniummag.dao.IProsceniumDao;
import com.ppxia.billing.prosceniummag.mapper.ProsceniumMapper;
@Repository
public class ProsceniumDaoImpl implements IProsceniumDao{
	 @Resource
	 private ProsceniumMapper prosceniumMapper;
	@Override
	public UserBean loginName(String userName, String userPassword) {
		return prosceniumMapper.loginName(userName, userPassword);
	}
	@Override
	public UserBean selectUserBeanById(int id) {
		return prosceniumMapper.selectUserBeanById(id);
	}

	@Override
	public void updateUserBeanById(int id, Long telephone) {
		// TODO Auto-generated method stub
		prosceniumMapper.updateUserBeanById(id, telephone);
	}
	@Override
	public PagerBean selectAccountingMonthByUserId(int pageIndex,int pageSize,int id, Date monthe) {
		// TODO Auto-generated method stub
		PagerBean pagerBean=new PagerBean();
		pagerBean.setPage(pageIndex);
		pagerBean.setRows(pageSize);
		pagerBean.setDatas(prosceniumMapper.selectDate(pageIndex, pageSize, id, monthe));
		pagerBean.setTotalRows(prosceniumMapper.countAccountingMonthTotalRow(id, monthe));
		return pagerBean;
	}
	@Override
	public OsMonthBean selectOsAccountNumberByMonth(int id, Date month) {
		// TODO Auto-generated method stub
		return prosceniumMapper.selectOsAccountNumberByMonth(id, month);
	}
	@Override
	public PagerBean selectOsCostDetailsBymonth(int pageIndex, int pageSize, int id, Date monthe) {
		// TODO Auto-generated method stub
		PagerBean pagerBean=new PagerBean();
		pagerBean.setPage(pageIndex);
		pagerBean.setRows(pageSize);
		pagerBean.setDatas(prosceniumMapper.selectOsDayBeanBymonth(pageIndex, pageSize, id, monthe));
		pagerBean.setTotalRows(prosceniumMapper.selectCountOsDay(id, monthe));
		return pagerBean;
	}
	
	

}
