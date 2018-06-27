<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="width: 100%;height:100%">
<head>
<base href="${request.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电信计费系统</title>
<link href="static/js/themes/icon.css" rel="stylesheet" type="text/css" />
<link href="static/js/themes/default/easyui1.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="static/js/jquery-1.4.2.min.js"></script>

<script type="text/javascript" src="static/js/jquery.easyui.min-1.2.0.js"></script>

<script src="static/js/Cookie.js" type="text/javascript"></script>

</head>
<style>
	 .max img{
            width: 100%;
            height: 100%;
        }
</style>
<body style="width: 100%;height:100%">
	<div class="max">
	<img src="static/images/dianxin.jpg" />
		<div id="loginWindow" class="easyui-window" title="登陆"
		iconcls="icon-login"
		style="width: 300px; height: 180px; padding: 5px; background: #fafafa;">
		<div border="false"
			style="padding-left: 30px; background: #fff; border: 1px solid #ccc;">
			<form action="/billing/logonFirst" method="post">
				<table>
					<tr>
						<td>账号：</td>
						<td><input id="userAccountingName" name="userAccountingName" class="easyui-validatebox"
							required="true" validtype="length[1,10]" style="width: 150px;" />
						</td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" id="password" name="password"
							style="width: 150px;" class="easyui-validatebox" required="true"
							validtype="length[3,10]" /></td>
					</tr>
				</table>
		</div>
				<div class="toolbar" style="text-align: center; margin-top: 20px;">
					<button  type="button" class="easyui-linkbutton" iconcls="icon-no" id="aboutSys" style="margin-right:10px;">取消</button>
					 <button type="submit" class="easyui-linkbutton" iconcls="icon-ok" id="" style="margin-left:10px;"> 登陆</button>
				</div>
			</form>
		
</div>
	</div>
</body>
</html>