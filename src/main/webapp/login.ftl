<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${request.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="static/js/jquery-3.3.1.min.js?version=20180522" charset="utf-8"></script>
<script type="text/javascript" src="static/js/index.page.js"
	charset="utf-8"></script>
</head>
<body>
	<button id="btn01">新增用户</button>
	<button id="btn02">查询用户</button>
	<button id="btn03">修改用户</button>
	<button id="btn04">删除用户</button>
	<button id="btn05">按照条件查询用户</button>
	<button id="btn06">按照条件完成分页查询</button>

	<p>
	<form action="customersform/111" method="post">
		<input type="hidden" name="_method" value="put" /> <input
			type="hidden" name="version" value="0" /> 用户名：<input type="text"
			name="customerName" /> <br /> 登录名：<input type="text"
			name="loginName" /> <br /> 出生日期：<input type="date" name="birthday" />
		<br /> <input type="submit" value="修改" />

	</form>

	<p>下面是Freemarker页面测试
	<p>
	<form action="customersform/hello" method="post">
		<input name="name" type="text" /> <br /> <input type="submit"
			value="提交" />
	</form>
	<p>
	<p>
	<a href="page/jump?viewName=usermag/userlist">跳转到userlist.ftl页面中</a>
	
</body>
</html>