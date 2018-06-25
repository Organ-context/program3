<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${request.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/billing/static/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="/billing/static/js/themes/icon.css" />
<script type="text/javascript"
	src="/billing/static/js/jQuery-2.2.2-min.js"></script>
<script type="text/javascript"
	src="/billing/static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/billing/static/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/billing/static/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="/billing/static/js/jquery.json-2.4.js"></script>
</head>
<body>

	<!--账务月账单表格部分-->
	<table id="dg" title="业务账号资费查询查询" style="width: 764px; height: 458px"
		class="easyui-datagrid" toolbar="#tb"
		data-options="
				rownumbers:true,
				pageList:[10],
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10,
				method:'get'">
	</table>
	<!--搜索-->
	<div id="tb" style="padding: 3px;">
		<label for="username" style="margin-left: 5px">姓 名:</label> <input
			id="username"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="请输入姓名"> <label for="osAccount"
			style="margin-left: 5px">业务账号:</label> <input id="osAccount"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="请输入业务账号"> <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-search" style="border: 6px"
			onclick="submitForm()">搜索</a>
	</div>

	<div style="margin: 20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" id="changeState"
			iconCls="icon-reload">修改业务账号状态</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" id="deleteOs"
			iconCls="icon-add">删除</a>
	</div>

</body>
<script type="text/javascript">
	//参数获取
	function queryParams() {
		var data = {
			userName : $('#username').val(),
			accountName : $('#osAccount').val()
		}
		return data;
	}
	//搜索
	function submitForm() {
		getData();
	}

	//第一次进入时刷新
	$(function() {
		getData();
	})

	//获取分页数据
	function getData() {
		$('#dg').datagrid({
			url : '/billing/tariff/getTariffPager',
			queryParams : queryParams(),
			columns : [ [ {
				field : 'userName',
				title : '姓名',
				width : 100,
				align : 'center',
				formatter : function(value, rec) {
					return rec.userBean.userName
				}
			}, {
				field : 'userAccountingName',
				title : '账务账号',
				width : 110,
				align : 'center',
				formatter : function(value, rec) {
					return rec.userBean.userAccountingName
				}
			}, {
				field : 'osAccount',
				title : '业务账号',
				width : 110,
				align : 'center'
			}, {
				field : 'osState',
				title : '状态',
				width : 180,
				align : 'center'
			}, {
				field : 'server_ip',
				title : '服务器',
				align : 'center',
				width : 100,
				formatter : function(value, rec) {
					return rec.serverBean.server_ip
				}
			}, {
				field : 'tariffName',
				title : '当前资费',
				align : 'center',
				width : 75,
				formatter : function(value, rec) {
					return rec.tariffBean.tariffName
				}
			} ] ]
		})
	}
	
	var nowOs = "";
	//修改业务账号的状态
	$("#changeState").bind('click',function(){
		nowOs = $('#dg').datagrid('getSelected');
		var data = {
				nowOsId : nowOs.id
		}
		console.log(data)
		if (nowOs != null) {
			$.ajax({
				type : "POST",
				data : data,
				url : "/billing/tariff/changeOsState",
				datatype : "json",
				success : function(msg) {
					$.messager.show({
						title : '提示',
						msg : msg,
						timeout : 5000,
						showType : 'slide'
					})
				}
			});
			getData();
		} else {
			$.messager.show({
				title : '提示',
				msg : '请选择需要修改的数据',
				timeout : 5000,
				showType : 'slide'
			})
		}
	})
	

	//删除业务账号的状态
	$("#deleteOs").bind('click',function(){
		nowOs = $('#dg').datagrid('getSelected');
		var data = {
				nowOsId : nowOs.id
		}
		console.log(data)
		if (nowOs != null) {
			$.ajax({
				type : "POST",
				data : data,
				url : "/billing/osAccountingmag/deleteOsAccounting",
				datatype : "json",
				success : function(msg) {
					$.messager.show({
						title : '提示',
						msg : msg,
						timeout : 5000,
						showType : 'slide'
					})
				}
			});
			getData();
		} else {
			$.messager.show({
				title : '提示',
				msg : '请选择需要修改的数据',
				timeout : 5000,
				showType : 'slide'
			})
		}
	})
</script>
</html>