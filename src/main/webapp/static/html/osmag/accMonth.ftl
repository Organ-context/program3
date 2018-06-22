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
<link rel="stylesheet" type="text/css"
	href="/billing/static/demo/demo.css">
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
<script>
	
</script>
<body>

	<!--账务月账单表格部分-->
	<table id="dg" title="账单查询" style="width: 764px; height: 458px"
		toolbar="#tb"
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
		<label for="name" style="margin-left: 5px">姓 名:</label> <input
			id="name"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="请输入姓名"> <label for="accountingname"
			style="margin-left: 5px">账务账号:</label> <input id="accountingname"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="请输入账务账号"> <label for="idcard"
			style="margin-left: 5px">身份证:</label> <input id="idcard"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="请输入身份证"> <label for="accountingtime"
			style="margin-left: 5px">账单时间:</label> <input id="accountingtime"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="输入格式yyyy-mm"> <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-search" style="border: 6px"
			onclick="submitForm()">搜索</a>
	</div>
	
	
	<!-- 弹出来的窗口 -->
	<div id="win" class="easyui-window" title="月账单信息"
		style="width: 778px; height: 500px;top:10px"
		data-options="iconCls:'icon-save',modal:true">
		<!--表格部分-->
	<table id="dg2" style="width: 760px; height: 460px"
		toolbar="#tb2"
		data-options="
				rownumbers:true,
				pageList:[10],
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10,
				method:'get'">
	</table>
	</div>
	
	
		<!-- 弹出来的第二层窗口 -->
	<div id="win2" class="easyui-window" title="日账单信息"
		style="width: 778px; height: 500px;top:5px"
		data-options="iconCls:'icon-save',modal:true">
		<!--表格部分-->
	<table id="dg3" style="width: 760px; height: 460px"
	toolbar="#tb3"
		data-options="
				rownumbers:true,
				pageList:[10],
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10,
				method:'get'">
	</table>
	</div>
	<!--搜索-->
	<div id="tb3" style="padding: 3px;">
	<strong style="left:10px">OS账号:</strong>
	<strong id="strong1"></strong>
	<strong style="margin-left: 100px">服务器信息:</strong>
	<strong id="strong2"></strong>		
	</div>
	
</body>
<script type="text/javascript">
	//最底层分页
	function queryParams() {
		var data = {
			userName : $('#name').val(),
			accountName : $('#accountingname').val(),
			idcard : $('#idcard').val(),
			time : $('#accountingtime').val()
		}
		return data;
	}
	//搜索
	function submitForm() {
		getData();
	}

	$(function() {
		getData();
	})

	function getData() {
		$('#dg').datagrid({
			url : '/billing/accountingmonthajax/findpage',
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
				field : 'userIdcard',
				title : '身份证号码',
				width : 180,
				align : 'center',
				formatter : function(value, rec) {
					return rec.userBean.userIdcard
				}
			}, {
				field : 'monthCoast',
				title : '费用',
				align : 'center',
				width : 100
			}, {
				field : 'payCondition',
				title : '支付状态',
				align : 'center',
				width : 75,
				formatter : function(value, row) {
					if (row.payCondition == 0) {
						return '未支付'
					} else if (row.payCondition == 1) {
						return '已付款'
					}

				}
			}, {
				field : 'payWay',
				title : '支付方式',
				align : 'center',
				width : 75,
				formatter : function(value, row) {
					if (row.payWay == 0) {
						return '包日'
					} else if (row.payWay == 1) {
						return '月付'
					} else if (row.payWay == 2) {
						return '年付'
					}
				}
			}, {
				field : 'month',
				title : '账单日期',
				align : 'center',
				width : 90
			}, ] ]
		})
	}
	
	
	// 窗口初始化关闭
	$(function() {
		$('#win').window('close')
		$('#win2').window('close')
	})
	
	var top1="";
	//窗口自启动然后刷新数据
	$(function() {
		$('#dg').datagrid({
			onDblClickRow : function(rowIndex, rowData) {
				
				$('#win').window('open')
				getData2(rowData);
				top1=rowData
			}
		});
		$('#dg2').datagrid({
			onDblClickRow : function(rowIndex, rowData) {
				
				$('#win2').window('open')
				getData3(top1,rowData);
				console.log(rowData)
				$("#strong1").html(rowData.osBean.osAccount)
				$("#strong2").html(rowData.ip)
			}
		});
	});
	
	//第二层分页
	function getData2(rowData) {
		$('#dg2').datagrid({
			url : '/billing/osmagcontroller/findosmonthpage',
			queryParams : {
				accountingName:rowData.userBean.userAccountingName,
					Month:rowData.month
			},
			columns : [ [ {
				field : 'OsAccount',
				title : 'OS账号',
				width : 130,
				align : 'center',
				formatter : function(value, row,rec) {
					return row.osBean.osAccount
				}
			}, {
				field : 'IP',
				title : '服务器信息',
				width : 155,
				align : 'center',
				formatter : function(value,row,rec) {
					return row.ip
				}
			}, {
				field : 'totalTime',
				title : '时长(单位:时分秒)',
				width : 190,
				align : 'center'
			}, {
				field : 'monthCoast',
				title : '费用',
				align : 'center',
				width : 130
			}, {
				field : 'costType',
				title : '资费套餐',
				align : 'center',
				width : 120,
				formatter : function(value, row) {
					if (row.costType == 0) {
						return '包日'
					} else if (row.costType == 1) {
						return '月付'
					} else if (row.costType == 2) {
						return '年付'
					}
				}
			}, ] ]
		})
	}
	
	
	//第三层分页
	function getData3(top,rowData) {
		$('#dg3').datagrid({
			url : '/billing/osmagcontroller/findosdaypage',
			queryParams : {
				accountingName:top.userBean.userAccountingName,
				serverip:rowData.ip,
				osaccount:rowData.osBean.osAccount,
				time :top.month
			},
			columns : [ [ {
				field : 'loginTime',
				title : '登入时间',
				width : 190,
				align : 'center',
				formatter:function(row){
			 var newTime = new Date(row)
			 return newTime.toLocaleString()
				}
			}, {
				field : 'outTime',
				title : '登出时间',
				width : 190,
				align : 'center',
				formatter:function(row){
					 var newTime = new Date(row)
					 return newTime.toLocaleString()
						}
			}, {
				field : 'totalTime',
				title : '使用时长(单位:秒)',
				width : 160,
				align : 'center'
			}, {
				field : 'dayCoast',
				title : '费用',
				align : 'center',
				width : 95
			}, {
				field : 'costType',
				title : '资费套餐',
				align : 'center',
				width : 90,
				formatter : function(value, row) {
					if (row.costType == 0) {
						return '包日'
					} else if (row.costType == 1) {
						return '月付'
					} else if (row.costType == 2) {
						return '年付'
					}
				}
			}, ] ]
		})
	}
</script>
</html>