<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="headloginlog">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" type="text/css"
	href="../../js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../../js/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="../../demo/demo.css">
<script type="text/javascript" src="../../js/jQuery-2.2.2-min.js"></script>
<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../js/locale/easyui-lang-zh_CN.js"></script>
<style>
#form1 {
	position: relative;
	margin-left: 180px;
	margin-top: 50px;
}
</style>
</head>
<script>
	$(function() {
		$("#o").css('display', 'none');
	});
</script>
<body>
	<div class="container">
		<div class="row" id="form1">

			<div class="col-md-5  col-lg-offset-1">
				<table id="dg" class="easyui-datagrid"
					style="width: 714px; height: 500px;" url="datagrid24_getdata.php"
					toolbar="#tb" title="登录日志" iconCls="icon-save" data-options="
				rownumbers:true,
				pageList:[10],
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10">
					<thead>
						<tr>
							<th data-options="field:'itemid'" hidden="ture" field="id"></th>
							<th data-options="field:'managername',width:110,align:'center'"field="managername">管理员名称</th>
							<th data-options="field:'managerlevel',width:110,align:'center'"field="managerlevel">管理员级别</th>
							<th data-options="field:'logintime',width:170,align:'center'"field="logintime">操作时间</th>
							<th data-options="field:'ip',width:170,align:'center'"field="ip">IP</th>
							<th data-options="field:'operation',width:125,align:'center'"field="operation">操作</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<div id="tb" style="padding: 3px;">
				<span>管理员名称：</span> <input id="managername"
					style="line-height: 26px; border: 1px solid #ccc">
				<span>日期：</span>
				<input id="logtime" type="date"
					style="line-height: 26px; border: 1px solid #ccc"> <span>角色：</span>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" style="border: 6px">搜索</a>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	function getData() {
		var rows = [];
		for (var i = 1; i <= 8; i++) {
		
			rows.push({
				id : i,
				managername : '张三'+i,
				managerlevel : '普通管理员',
				logintime : 2018-06-21,
				ip : iiiiiiiiii,
				operation : '账务管理员'
			});
		}
		return rows;
	}
	
	function pagerFilter(data) {
		if (typeof data.length == 'number'&& typeof data.splice == 'function') { // is array
			data = {
				total : data.length,
				rows : data
			}
		}
		var dg = $(this);
		var opts = dg.datagrid('options');
		var pager = dg.datagrid('getPager');
		pager.pagination({
			onSelectPage : function(pageNum, pageSize) {
				opts.pageNumber = pageNum;
				console.log(opts.pageNumber);
				opts.pageSize = pageSize;
				pager.pagination('refresh', {
					pageNumber : pageNum,
					pageSize : pageSize
				});
				dg.datagrid('loadData', data);
			}
		});
		if (!data.originalRows) {
			data.originalRows = (data.rows);
		}
		var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
		var end = start + parseInt(opts.pageSize);
		data.rows = (data.originalRows.slice(start, end));
		return data;
	}

	$(function() {
		$('#dg').datagrid({
			loadFilter : pagerFilter
		}).datagrid('loadData', getData());
	});
	
	
	
	
</script>
</html>