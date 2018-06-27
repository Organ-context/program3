package com.ppxia.billing.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginAction {
	
	@RequestMapping(value = "/toLogin", method = RequestMethod.GET)
	public String toLogin() {
		System.out.println("进入toLogin");
		// 跳转到/login.jsp页面
		return "login.ftl";
	}
	
	@RequestMapping(value="/logonFirst",method=RequestMethod.POST)
	public String logon(@RequestParam("userAccountingName") String userAccountingName,@RequestParam("password") String password) {
		try {
		//创建Subject实例
		Subject currentUser = SecurityUtils.getSubject();
		//将用户名及密码封装UsernamePasswordToken
		UsernamePasswordToken token = new UsernamePasswordToken(userAccountingName,password);
		currentUser.login(token);
			
		//判断当前用户是否登录
		
		if(currentUser.isAuthenticated()) {
			return "redirect:index.jsp";
		}else {
			return "redirect:/toLogin";
		}
		}catch (AuthenticationException e) {
			return "ereeo.ftl";
		}
		
	}
}
