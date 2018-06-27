package com.ppxia.billing.prosceniummag.controoler;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.prosceniummag.service.handle.IProsceniumService;
import com.ppxia.billing.utils.StringUtils;


@Controller
@RequestMapping("/Proscenium")
public class ProsceniumController {
	@Resource
	private  IProsceniumService prosceniumService;
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public UserBean getUserInfo(int id) {
		UserBean userBean=null;
		userBean=prosceniumService.selectUserBeanById(id);
		return userBean;
	}
	@RequestMapping("/getupdateTelephonenumById")
	@ResponseBody
	public Map<String,Object> updateTelephonenumById(int id,Long telephone){
		 Map<String,Object> map=new HashMap<String, Object>();
		 try {
			 prosceniumService.updateUserBeanById(id, telephone);
			 map.put("result", true);
			 map.put("information","修改电话号码成功!");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", false);
			 map.put("information","修改电话号码失败!");
		}
		
		return map;
	}
	@RequestMapping("/selectAccountingMonthByUserId")
	@ResponseBody
	public PagerBean selectAccountingMonthByUserId(@RequestParam("page")int pageIndex,@RequestParam("rows")int pageSize,int id, String monthe) {
		PagerBean pagerBean=null;
		Date montheDate=null;
		if(!StringUtils.isEmpty(monthe)) {
			montheDate=StringUtils.formatDate(monthe);
		}
		pagerBean=prosceniumService.selectAccountingMonthByUserId(pageIndex, pageSize, id, montheDate);
		PagerBean pageBean= new PagerBean();
		pageBean.setDatas(pagerBean.getDatas());
		pageBean.setTotalRows(pagerBean.getTotalRows());
		return pageBean;
	}
	@RequestMapping("/selectOsCostDetailsBymonth")
	@ResponseBody
	public PagerBean selectOsCostDetailsBymonth(@RequestParam("page")int pageIndex,@RequestParam("rows")int pageSize,int id,long monthe) {
		PagerBean  pagerBean = null;
		Date montheDate=null;
		if(!StringUtils.isEmpty(monthe)) {
			//把字符串转化为时间格式
			montheDate=StringUtils.timestamp2Date(monthe);
		}
		pagerBean=prosceniumService.selectOsCostDetailsBymonth(pageIndex, pageSize, id, montheDate);
		PagerBean pageBean = new PagerBean();
		pageBean.setDatas(pagerBean.getDatas());
		pageBean.setTotalRows(pagerBean.getTotalRows());
		return pageBean;
	}

}
