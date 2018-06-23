<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${request.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="../../js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../../js/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="../../demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="../../js/themes/default/easyui.css">
<script type="text/javascript" src="../../js/jQuery-2.2.2-min.js"></script>
<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../js/locale/easyui-lang-zh_CN.js"></script>
<style>
#form1 {
	position: relative;
	margin-left: 30px;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row" id="form1">

			<div class="col-md-5  col-lg-offset-1">
				<table id="dg" class="easyui-datagrid"
					style="width: 714px; height: 500px;" toolbar="#tb" title="登录日志"
					data-options="
						rownumbers:true,
						pageList:[10],
						singleSelect:true,
						autoRowHeight:false,
						pagination:true,
						pageSize:10,
						method:'get'">
					<thead>
					</thead>
					<tbody>
					</tbody>
				</table>

				<div id="tb" style="padding: 3px;">
					<span>管理员名称：</span> <input id="managername1"
						style="line-height: 26px; border: 1px solid #ccc"> 
						<label
						for="starttime" style="margin-left: 5px">开始日期：</label> <input
						id="starttime"
						style="line-height: 26px; width: 100px; border: 1px solid #ccc"
						placeholder="输入格式yyyy-mm-dd"> 
						<label
						for="endtime" style="margin-left: 5px">结束日期：</label> <input
						id="endtime"
						style="line-height: 26px; width: 100px; border: 1px solid #ccc"
						placeholder="输入格式yyyy-mm-dd"> 
						<a
						href="javascript:void(0)" class="easyui-linkbutton"
						iconCls="icon-search" style="border: 6px" onclick="submitForm()">搜索</a>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	//分页
	function queryParams() {
		var data = {
			managername : $('#managername1').val(),
			starttime : $('#starttime').val(),
			endtime : $('#endtime').val()

		}
		return data;
	}

	//搜索
	function submitForm() {
		getData();
		$('#managername').val(''),
		$('#starttime').val(''),
		$('#endtime').val('')
	}

	$(function() {
		getData();
	})

	function getData() {
		$('#dg').datagrid({
			url : '/billing/log/getLoginlogPager',
			queryParams : queryParams(),
			columns : [ [ {
				field : 'loginManagerName',
				title : '管理员名称',
				align : 'center',
				width : 110
			}, {
				field : 'loginManagerType',
				title : '管理员级别',
				align : 'center',
				width : 110
			}, {
				field : 'loginOperateTime',
				title : '操作时间',
				align : 'center',
				width : 170,
				formatter : function(row) {
					var newTime = new Date(row)
					return newTime.toLocaleString()
				}
			}, {
				field : 'ip',
				title : 'IP',
				align : 'center',
				width : 170
			}, {
				field : 'loginOperation',
				title : '操作',
				align : 'center',
				width : 125
			}, ] ]
		})
	}
</script>
</html>