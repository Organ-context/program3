<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电信计费项目</title>
<link href="static/css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="static/js/themes/default/easyui1.css" />
<link rel="stylesheet" type="text/css" href="static/js/themes/icon.css" />
<script type="text/javascript" src="static/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="static/js/jquery.easyui.min-1.2.0.js"></script>
<script type="text/javascript" src="static/js/indexjs.js"></script>


<style type="text/css">
#css3menu li {
	float: left;
	list-style-type: none;
}

#css3menu li a {
	color: #fff;
	padding-right: 20px;
}

#css3menu li a.active {
	color: yellow;
}
</style>


</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
	<!--noscript>
    <div style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px;
        width: 100%; background: white; text-align: center;">
        <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
    </div>
</noscript-->

	<div region="north" split="true" border="false"
		style="overflow: hidden; height: 40px; background: url(static/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%; line-height: 30px; color: #fff; font-family: Verdana, 微软雅黑, 黑体">
		<div></div>
		<span style="float: right; padding-right: 20px;" class="head">
			欢迎您！&nbsp; <!--<a href="#" id="updatePwd">修改密码</a>--> <!--<a href="#" id="loginOut">安全退出</a>-->
			<button style="padding: 1px">
				<a href="#" class="easyui-menubutton" menu="#mm1" iconCls="icon-man">kuro</a>
			</button>
			<div id="mm1" style="width: 150px;">
				<div iconCls="icon-undo">查看个人信息</div>
				<div> <a href="logout">注销</a></div>
				<div class="menu-sep"></div>
			</div>
		</span> <span style="padding-left: 10px; font-size: 16px; float: left;">
			<img src="static/images/blocks.gif" width="20" height="20" align="absmiddle" />项目一组
		</span>


		<ul id="css3menu"
			style="padding: 0px; margin: 0px; list-type: none; float: left; margin-left: 40px;">
			<li><a class="active" name="basic" href="html/admin/admin.html"
				title=""></a>
		</ul>
	</div>
	<div region="south" split="true"
		style="height: 30px; background: #D2E0F2;">
		<div class="footer">By 项目一组</div>
	</div>
	<div region="west" hide="true" split="true" title="导航菜单"
		style="width: 180px;" id="west">

			<!--  导航内容 -->
			
			<div class="easyui-panel" style="width: 172px; height: 500px; border-bottom: none;">
        <ul id="tt"  class="easyui-tree">
			
				<li data-options="state:'closed'"><span>用户前台系统</span>
	                <ul>
	                    <li><span>个人信息</span></li>
	                    <li><span>账单信息</span></li>
	                </ul>
	            </li>
	            	<shiro:hasAnyRoles name="superadmin,admin">
	            <li data-options="state:'closed'"><span>前台运营系统</span>
	                <ul>
	       
            		 	
	                    <li data-options="state:'closed'"><span>管理员管理系统</span>
	                    	<ul>
	                    		<li><span>管理员管理</span></li>
	                    	</ul>
	                    </li>
	              </shiro:hasAnyRoles>  
             				<shiro:hasAnyRoles name="superadmin,accounting"> 
	                    <li data-options="state:'closed'"><span>账务查询系统</span>
	                <ul>
	                    <li><span>年账务查询</span></li>
	                    <li><span>月账务查询</span></li>
	                </ul>
	            </li>
				 </shiro:hasAnyRoles>   
             				<shiro:hasAnyRoles name="superadmin,admin"> 
	            <li data-options="state:'closed'"><span>权限管理系统</span>
	                <ul>
	                    <li><span>权限管理</span></li>
	                    <li><span>角色管理</span></li>
	                </ul>
	            </li>
				</shiro:hasAnyRoles> 
							<shiro:hasAnyRoles name="superadmin,accounting">
				<li data-options="state:'closed'"><span>报表查询系统</span>
	                <ul>
	                    <li><span>账务账号报表</span></li>
	                </ul>
	            </li>
				  </shiro:hasAnyRoles> 
             				<shiro:hasAnyRoles name="superadmin,tariff"> 
		            <li data-options="state:'closed'"><span>资费管理系统</span>
		                <ul>
		                    <li><span>业务资费管理</span></li>
		                    <li><span>资费套餐管理</span></li>
		                </ul>
		            </li>
				</shiro:hasAnyRoles>  
             				<shiro:hasAnyRoles name="superadmin,user">   
		            <li data-options="state:'closed'"><span>用户管理系统</span>
		                <ul>
		                    <li><span>账务账号管理</span></li>
		                    <li><span>业务账号管理</span></li>
		                </ul>
		            </li>
				</shiro:hasAnyRoles>   
             				<shiro:hasAnyRoles name="superadmin,log">  
			            <li data-options="state:'closed'"><span>前台日志系统</span>
			                <ul>
			                    <li><span>登录日志</span></li>
			                    <li><span>前台日志</span></li>
			                </ul>
			            </li>
				</shiro:hasAnyRoles>  
             				<shiro:hasAnyRoles name="superadmin,log"> 
			            <li data-options="state:'closed'"><span>账单查询</span>
			                <ul>
			                    <li><span>账单查询系统</span></li>
			                </ul>
			            </li>
	                     </shiro:hasAnyRoles>   
	                </ul>
	            </li>
            
	          
        </ul>
    </div>
    
			
	</div>
	<div id="mainPanle" region="center"
		style="background: #eee; overflow-y: hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">
				
    <div title="主页" id="wp">
        <img alt="" src="static/images/000.jpg" style="height:50%;width:100%;">

</div>
			</div>
		</div>
	</div>
	<!--修改密码窗口-->
	<div id="w" class="easyui-window" title="修改密码" collapsible="false" closed="true"
		minimizable="false" maximizable="false" icon="icon-save"
		style="width: 300px; height: 150px; padding: 5px; background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding="3">
					<tr>
						<td>新密码：</td>
						<td><input id="txtNewPass" type="password"
							class="easyui-validatebox" required="true"
							validtype="length[3,10]" /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input id="txtRePass" type="password"
							class="easyui-validatebox" required="true"
							validtype="length[3,10]" />
						<!-- class="txt01"--></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
					href="javascript:void(0)">确定</a> <a id="btnCancel"
					class="easyui-linkbutton" icon="icon-cancel"
					href="javascript:void(0)"> 取消</a>
			</div>
		</div>
	</div>
	<div id="mm" class="easyui-menu" style="width: 150px;">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>
</body>
</html>
