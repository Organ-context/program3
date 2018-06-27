package com.ppxia.billing.login;


import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Controller;

import com.ppxia.billing.beans.AuthorityBean;
import com.ppxia.billing.beans.RoleBean;
import com.ppxia.billing.beans.UserBean;
import com.ppxia.billing.rolemag.service.IRoleQueryService;
import com.ppxia.billing.usermag.service.IUserQueryService;
//Realm 需要查询数据库，并且得到正确的数据
//AuthorizingRealm 继承于AuthenticatingRealm，同时具有认证和授权的功能
public class ShiroRealm extends AuthorizingRealm {
	/**
	 * 1.doGetAuthenticationInfo，获取认证消息，如果数据库中没有数据，返回null，如果得到正确的用户名和密码，返回制定类型的对象
	 * 
	 * 2.AuthenticationInfo 可以使用SimpleAuthenticationInfo实现类，封装给调用者正确的用户名和密码
	 * 
	 * 3.token参数，就是需要认证的token
	 */
	
	@Resource
	private IUserQueryService userQueryServiceImpl;
	@Resource
	private IRoleQueryService roleQueryServiceImpl;
	
	/**
	 * 为当前用户授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		//返回值：AuthorizationInfo，封装获取的用户对应的所有角色，SimpleAuthenticationInfo(Set<String>)
		//参数：principals 登录的身份,即用户名
		SimpleAuthorizationInfo info = null ;
		String username = (String) principals.fromRealm(getName()).iterator().next();
		RoleBean role = roleQueryServiceImpl.findRoleByUserName(username);
		
		if(role!=null) {
			

			Set<String> rol = new HashSet<String>();
			rol.add(role.getRoleName());
			 info = new SimpleAuthorizationInfo(rol);
			System.out.println("********************"+info);
			
		}
		return info;
	}
	
	
	/**
	 * 验证当前用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//1.将token转换成UsernamePasswordToken
		SimpleAuthenticationInfo info = null;
		UserBean bean = null;
		//UsernamePasswordToken：用户输入的用户名和密码
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		
		//2.获取用户名即可
		String username = upToken.getUsername();
		
		//3.查询数据库，是否存在指定用户名和密码
		bean=userQueryServiceImpl.findUserByName(username);
		System.out.println(bean);
		if(bean!=null) {
			Object principal =bean.getUserAccountingName();
			
			Object credentials= bean.getUserPassword();
			
			String realmName=this.getName();
			//SimpleAuthenticationInfo：封装数据库查询的正确账号密码，shiro框架内部进行比对
			//对比的操作是调用了doCredentialsMatch(token,info)
			info=new SimpleAuthenticationInfo(principal, credentials, realmName);
			return info; 
		}
			//如果不存在就抛出异常
		//4.如果查询到了，封装查询结果，返回给调用者
		//5.如果没有查询到，抛出异常
		return null; 	
	}

	
}
