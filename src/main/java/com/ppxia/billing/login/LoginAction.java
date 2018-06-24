package com.ppxia.billing.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginAction {
	
	@RequestMapping(value="/logonFirst",method=RequestMethod.POST)
	public String logon(@RequestParam("username") String username,@RequestParam("password") String password) {
		//创建Subject实例
		Subject currentUser = SecurityUtils.getSubject();
		
		//判断当前用户是否登录
		if(currentUser.isAuthenticated()==false) {
			
			//将用户名及密码封装UsernamePasswordToken
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			try {
				currentUser.login(token);
			} catch (Exception e) {
				return "/login";
			}
		}
		return "/index";
	}
}
