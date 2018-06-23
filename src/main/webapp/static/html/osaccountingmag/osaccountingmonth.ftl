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
	<table id="dg" title="月账务查询" style="width: 764px; height: 458px"
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
		<label for="osaccountingname" style="margin-left: 5px">业务账号:</label> <input
			id="osaccountingname"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="请输入业务账号"> <label for="serveripname"
			style="margin-left: 5px">实验室名字:</label> <input id="serveripname"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="请输入实验室名字"> <label for="querymonth"
			style="margin-left: 5px">月份:</label> <input id="querymonth"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="请输入yyyy-mm"><a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-search" style="border: 6px"
			onclick="submitForm()">搜索</a>
	</div>


	<!-- 弹出来的窗口 -->
	<div id="win" class="easyui-window" title="日账务信息"
		style="width: 778px; height: 500px; top: 10px"
		data-options="iconCls:'icon-save',modal:true">
		<!--表格部分-->
		<table id="dg2" style="width: 760px; height: 460px" toolbar="#tb2"
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
	<!--第二层搜索-->
	<div id="tb2" style="padding: 3px;">
		<strong style="position: relative; left: 10px">业务账号:</strong> <strong
			id="strong3" style="position: relative; left: 30px"></strong> <strong
			style="position: relative; left: 80px">实验室名字:</strong> <strong
			id="strong4" style="position: relative; left: 100px"></strong>
	</div>

</body>
<script type="text/javascript">
	//最底层分页
	function queryParams() {
		var data = {
			osAccount : $('#osaccountingname').val(),
			IP : $('#serveripname').val(),
			month : $('#querymonth').val(),
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
			url : '/billing/osAccountingcontroller/findOsAccountingMonthPage',
			queryParams : queryParams(),
			columns : [ [ {
				field : 'OsAccount',
				title : '业务账号',
				width : 180,
				align : 'center',
				formatter : function(value, row, rec) {
					return row.osBean.osAccount
				}
			}, {
				field : 'ip',
				title : '实验室名字',
				width : 180,
				align : 'center'
			}, {
				field : 'totalTime',
				title : '总时长',
				width : 190,
				align : 'center'
			}, {
				field : 'month',
				title : '费用',
				align : 'center',
				width : 180
			}, ] ]
		})
	}

	// 窗口初始化关闭
	$(function() {
		$('#win').window('close')
	})

	var top1 = "";
	//窗口自启动然后刷新数据
	$(function() {
		$('#dg').datagrid({
			onDblClickRow : function(rowIndex, rowData) {
				$('#win').window('open')
				getData2(rowData);
				top1 = rowData
				$("#strong3").html(top1.osBean.osAccount)
				$("#strong4").html(top1.ip)
			}
		});
	});


	Date.prototype.toLocaleString = function() {
		return this.getFullYear() + "年" + (this.getMonth() + 1) + "月"
				+ this.getDate() + "日 " + this.getHours() + "点"
				+ this.getMinutes() + "分" + this.getSeconds() + "秒";
	};

	//第三层分页
	function getData2(top) {
		$('#dg2').datagrid({
			url : '/billing/osAccountingcontroller/findOsAccountingDayPage',
			queryParams : {
				osAccount : top.osBean.osAccount,
				IP : top.ip,
			},
			columns : [ [ {
				field : 'loginTime',
				title : '账单日期',
				width : 370,
				align : 'center',
				formatter : function(row, rec, value) {
					var newTime = new Date(row)
					return newTime.toLocaleString()
				}
			}, {
				field : 'totalTime',
				title : '使用时长',
				width : 365,
				align : 'center'
			}, ] ]
		})
	}
</script>
</html>