package com.ppxia.billing.accountingmag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppxia.billing.accountingmag.service.IAccountingHandleService;
import com.ppxia.billing.accountingmag.service.IAccountingQueryService;
import com.ppxia.billing.accountingmag.service.IServerQuerySevice;
import com.ppxia.billing.beans.OsBean;
import com.ppxia.billing.beans.PagerBean;
import com.ppxia.billing.beans.ServerBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.osmag.service.IOsBeanHandleService;
import com.ppxia.billing.tariffmag.service.ITariffQueryService;
import com.ppxia.billing.usermag.service.IUserHandleService;
import com.ppxia.billing.usermag.service.IUserQueryService;
import com.ppxia.billing.viewobj.DataGrid;

/**
 * 
 * @author 张进
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/accountingmag")
public class AccoutingController {
	
	@Resource
	private IAccountingQueryService accountingQueryServiceImpl;
	
	@Resource
	private IAccountingHandleService accountingHandleServiceImpl;
	
	@Resource
	private IOsBeanHandleService osBeanHandleServiceImpl;
	
	@Resource
	private IUserQueryService userQueryServiceImpl;
	
	@Resource
	private IUserHandleService userHandleServiceImpl;
	
	@Resource
	private ITariffQueryService tariffQueryServiceImpl;
	
	@Resource
	private IServerQuerySevice serverQuerySeviceImpl;
	
	@RequestMapping(value="/saveAccountings",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public String saveAccountings(String fileAddress) {
		System.out.println();
		return null;
	}
	
	/**
	 * 获取所有服务器对象
	 * @return
	 */
	@RequestMapping(value="/getAllServer",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public List<ServerBean> getAllServer() {
		
		List<ServerBean> datas = serverQuerySeviceImpl.findAllServer();
		return datas;
	}
	
	/**
	 * 新增业务账号
	 * @param accountingId
	 * @param osAccounting
	 * @param tariffId
	 * @param serverId
	 * @return
	 */
	@RequestMapping(value="/addOsAccounting",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public String add(Long accountingId,String osAccounting,Long tariffId,Long serverId) {
		OsBean newOs = new OsBean();
		newOs.setOsAccount(osAccounting);
		UserBean nowUser = userQueryServiceImpl.getUser(accountingId);
		newOs.setUserBean(nowUser);
		newOs.setTariffBean(tariffQueryServiceImpl.findTariffById(tariffId));
		newOs.setServerBean(serverQuerySeviceImpl.findServerById(serverId));
		newOs.setOsState(1);
		osBeanHandleServiceImpl.saveOsBean(newOs);
		return "";
	}
	
	/**
	 * 分页
	 */
	@RequestMapping(value="/getAccountingPager",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public DataGrid findUserByParams2Pager(PagerBean pager,String userName,String userAccountingName) {
		Map<String, Object> params = new HashMap<>();
		params.put("userName", userName);
		params.put("userAccountingName", userAccountingName);
		accountingQueryServiceImpl.findAccountingByParams(pager, params);
		DataGrid dataGrid = new DataGrid((long) pager.getTotalRows(),pager.getDatas());
		return dataGrid;
	}
	
	/**
	 * 删除
	 * @param user 要删除的对象
	 * @return
	 */
	@RequestMapping(value="/deleteAccounting",method= {RequestMethod.DELETE},produces= {"application/json;charset=utf-8"})
	public String deleteAdmin(UserBean user) {
//		userHandleServiceImpl.deleteManager(user);
		return "";
	}
	
	/**
	 * 修改,将原有数据赋值到新的对象中，再将传入的要修改的参数赋值到新对象
	 * @param id 传入的id
	 * @param userPassword 要修改的密码
	 * @param telephone 要修改的手机号码
	 * @param email 要修改的邮箱地址
	 * @param roleName 要修改的角色
	 * @return
	 */
	@RequestMapping(value="/updateAccounting",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public String updateAdmin(Long nowAccount) {
		UserBean nowUser = userQueryServiceImpl.getUser(nowAccount);
		UserBean newUser = new UserBean();
		newUser.setEmail(nowUser.getEmail());
		newUser.setGender(nowUser.getGender());
		newUser.setId(nowUser.getId());
		newUser.setRoleBean(nowUser.getRoleBean());
		newUser.setTelephone(nowUser.getTelephone());
		newUser.setUserAccountingName(nowUser.getUserAccountingName());
		newUser.setUserAddress(nowUser.getUserAddress());
		newUser.setUserIdcard(nowUser.getUserIdcard());
		newUser.setUserName(nowUser.getUserName());
		newUser.setUserPassword(nowUser.getUserPassword());
		newUser.setUserPostnum(nowUser.getUserPostnum());
		newUser.setUserQqnum(nowUser.getUserQqnum());
		if (nowUser.getUserAccountingState()==0) {
			newUser.setUserAccountingState(1);
		}else {
			newUser.setUserAccountingState(0);
		}
		userHandleServiceImpl.updateManatger(newUser);
		return null;
	}
}
