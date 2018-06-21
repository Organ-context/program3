<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${request.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="/billing/static/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="/billing/static/js/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="/billing/static/demo/demo.css">
<!--  <link href="../css/bootstrap.min.css" rel="stylesheet"/>
      <link href="../css/bootstrap-theme.min.css" rel="stylesheet"/> -->
<script type="text/javascript"
	src="/billing/static/js/jQuery-2.2.2-min.js"></script>
<script type="text/javascript"
	src="/billing/static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/billing/static/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/billing/static/js/locale/easyui-lang-zh_CN.js"></script>
<style>
#form1 {
	position: relative;
	margin-left: 180px;
	margin-top: 50px;
}
</style>
</head>

<body>
	<div class="container">
		<div class="row" id="form1">

			<div class="col-md-6  col-lg-offset-1">
				<table id="tt" class="easyui-datagrid"
					style="width: 90%; height: 500px;" url="datagrid24_getdata.php"
					toolbar="#tb" title="资费管理" iconCls="icon-save" rownumbers="true"
					pagination="true">
					<thead>
						<tr>
							<th data-options="field:'itemid',width:130,align:'center'">姓名</th>
							<th data-options="field:'productid',width:300,align:'center'">账号</th>
							<th data-options="field:'listprice',width:120,align:'center'">状态</th>
							<th data-options="field:'unitcost',width:200,align:'center'">服务器</th>
							<th data-options="field:'attr1',width:160,align:'center'">当前资费</th>
							<th data-options="field:'status',width:200,align:'center'">操作</th>
						</tr>

					</thead>
					<tbody>
						<tr>
							<td>admin</td>
							<td>admin</td>
							<td>开通</td>
							<td>192.168.0.000</td>
							<td>包月</td>
							<td><a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-edit'"
								onclick="('#add').window('open')">修改</a> <a
								href="javascript:void(0)" class="easyui-linkbutton" onclick=""
								iconCls="icon-add">开通</a></td>
						</tr>
						<tr>
							<td>admin</td>
							<td>admin</td>
							<td>开通</td>
							<td>192.168.0.000</td>
							<td>包月</td>
							<td><a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-edit'"
								onclick="('#add').window('open')">修改</a> <a
								href="javascript:void(0)" class="easyui-linkbutton" onclick=""
								iconCls="icon-add">开通</a></td>
						</tr>
						<tr>
							<td>admin</td>
							<td>admin</td>
							<td>开通</td>
							<td>192.168.0.000</td>
							<td>包月</td>
							<td><a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-edit'"
								onclick="('#add').window('open')">修改</a> <a
								href="javascript:void(0)" class="easyui-linkbutton" onclick=""
								iconCls="icon-add">开通</a></td>
						</tr>
						<tr>
							<td>admin</td>
							<td>admin</td>
							<td>开通</td>
							<td>192.168.0.000</td>
							<td>包月</td>
							<td><a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-edit'"
								onclick="('#add').window('open')">修改</a> <a
								href="javascript:void(0)" class="easyui-linkbutton" onclick=""
								iconCls="icon-add">开通</a></td>
						</tr>
						<tr>
							<td>admin</td>
							<td>admin</td>
							<td>开通</td>
							<td>192.168.0.000</td>
							<td>包月</td>
							<td><a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-edit'"
								onclick="('#add').window('open')">修改</a> <a
								href="javascript:void(0)" class="easyui-linkbutton" onclick=""
								iconCls="icon-add">开通</a></td>
						</tr>
						<tr>
							<td>admin</td>
							<td>admin</td>
							<td>开通</td>
							<td>192.168.0.000</td>
							<td>包月</td>
							<td><a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-edit'"
								onclick="('#add').window('open')">修改</a> <a
								href="javascript:void(0)" class="easyui-linkbutton" onclick=""
								iconCls="icon-add">开通</a></td>
						</tr>
						<tr>
							<td>admin</td>
							<td>admin</td>
							<td>开通</td>
							<td>192.168.0.000</td>
							<td>包月</td>
							<td><a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-edit'"
								onclick="('#add').window('open')">修改</a> <a
								href="javascript:void(0)" class="easyui-linkbutton" onclick=""
								iconCls="icon-add">开通</a></td>
						</tr>
						<tr>
							<td>admin</td>
							<td>admin</td>
							<td>开通</td>
							<td>192.168.0.000</td>
							<td>包月</td>
							<td><a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-edit'"
								onclick="('#add').window('open')">修改</a> <a
								href="javascript:void(0)" class="easyui-linkbutton" onclick=""
								iconCls="icon-add">开通</a></td>
						</tr>
						<tr>
							<td>admin</td>
							<td>admin</td>
							<td>开通</td>
							<td>192.168.0.000</td>
							<td>包月</td>
							<td><a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-edit'"
								onclick="('#add').window('open')">修改</a> <a
								href="javascript:void(0)" class="easyui-linkbutton" onclick=""
								iconCls="icon-add">开通</a></td>
						</tr>
						<tr>
							<td>admin</td>
							<td>admin</td>
							<td>开通</td>
							<td>192.168.0.000</td>
							<td>包月</td>
							<td><a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-edit'"
								onclick="('#add').window('open')">修改</a> <a
								href="javascript:void(0)" class="easyui-linkbutton" onclick=""
								iconCls="icon-add">开通</a></td>
						</tr>

					</tbody>
				</table>

				<!--搜索-->
				<div id="tb" style="padding: 3px;">
					<span>姓名：</span> <input id="realname"
						style="line-height: 26px; border: 1px solid #ccc"> <span
						style="margin-left: 100px">账号：</span> <input id="productid"
						style="line-height: 26px; border: 1px solid #ccc"> <a
						href="#" style="margin-left: 100px" class="easyui-linkbutton"
						iconCls="icon-search" style="border:6px">搜索</a> <a
						href="/billing/tariff/jump?viewName=tariffmag/tariffSecond" style="margin-left: 30px"
						class="easyui-linkbutton" iconCls="icon-redo">查看资费</a>
				</div>


				<div
					style="width: 90%; height: 60px; margin-top: 40px; background-color: #269abc">
					<h2 style="margin-left: 10px; padding-top: 15px">资费说明</h2>
				</div>
				<div>
					<h3 style="color: red">1、如果资费类型选择“包月”，计算“基本费用（RMB）”</h3>
					<h3 style="color: red">2、如果选择“计时”资费类型，计算“单位费用（单位：RMB/小时）”</h3>
					<h3 style="color: red">3、如果选择“套餐”资费类型，计算“基本时长（单位：小时）”,“基本费用”，“单位费用”</h3>
				</div>


				<div id="add" class="easyui-window" title="修改资费"
					data-options="iconCls:'icon-save'"
					style="width: 330px; height: 360px; padding: 5px;">
					<div class="easyui-layout" data-options="fit:true">
						<!--右侧树状图区域-->
						<!--  <div data-options="region:'east',split:true" style="width:100px"></div> -->
						<div data-options="region:'center'"
							style="padding: 10px; display: none">
							<div style="text-align: center">
								<span>当前资费：</span> <span style="font-size: 20px; color: #0000FF">包月</span>
							</div>


							<div style="text-align: center; margin-top: 50px">
								<select id="cc" class="easyui-combobox" name="dept"
									style="width: 100px;">
									<option value="aa">请选择</option>
									<option>包月</option>
									<option>计时</option>
									<option>套餐</option>
								</select>

							</div>
						</div>
						<div data-options="region:'south',border:false"
							style="text-align: right; padding: 5px 0 0;">
							<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
								href="javascript:void(0)"
								onclick="$('#add').window('close');javascript:alert('修改成功')">保存</a>
							<a href="javascript:void(0)" class="easyui-linkbutton"
								data-options="iconCls:'icon-cancel'"
								onclick="$('#add').window('close')">取消</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	function getData() {
		var rows = [];
		for (var i = 1; i <= 2; i++) {
			var amount = Math.floor(Math.random() * 1000);
			var price = Math.floor(Math.random() * 1000);
			rows.push({
				id : i,
				name : '张三',
				user : 'admin',
				gender : '男',
				tel : 10086,
				role : '账务管理员',
				email : '13@qq.com'
			});
		}
		return rows;
	}

	function pagerFilter(data) {
		if (typeof data.length == 'number' && typeof data.splice == 'function') { // is array
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

	$("#update1").bind('click', function() {
		var row = $('#dg').datagrid('getSelected');
		if (row != null) {
			$("#w").window('open')
		} else {
			$.messager.show({
				title : '提示',
				msg : '请选择需要修改的数据',
				timeout : 5000,
				showType : 'slide'
			})
		}
	});

	$("#delete1").bind('click', function() {
		var row = $('#dg').datagrid('getSelected');
		if (row != null) {
			$.messager.show({
				title : '提示',
				msg : '删除成功',
				timeout : 5000,
				showType : 'slide'
			})
		} else {
			$.messager.show({
				title : '提示',
				msg : '请选择需要删除的数据',
				timeout : 5000,
				showType : 'slide'
			})
		}
	});

	$('#sava1').bind('click', function() {
		$.messager.show({
			title : '提示',
			msg : '修改成功',
			timeout : 5000,
			showType : 'slide'
		})
	});

	//添加
	$('#sava2').bind('click', function() {
		var data = {
			userName : $("#adminName").val(),
			userAccountingName : $("#adminAcc").val(),
			userPassword : $("#adminPwd").val(),
			gender : $("#gender").val(),
			roleName : $("#role").val(),
			telephone : $("#adminTel").val(),
			email : $("#adminEmail").val()
		};
		$.ajax({
			type : "POST",
			data : data,
			url : "/billing/admin/add",
			datatype : "json",
			success : function(msg) {
				console.log(9)
				$.messager.show({
					title : '提示',
					msg : '添加成功',
					timeout : 5000,
					showType : 'slide'
				})
			}
		});
		$.messager.show({
			title : '提示',
			msg : '添加成功',
			timeout : 5000,
			showType : 'slide'
		})
		$('#add').window('close')
		$("#adminName").val("")
		$("#adminAcc").val("")
		$("#adminPwd").val("")
		$("#gender").val("")
		$("#role").val("")
		$("#adminTel").val("")
		$("#adminEmail").val("")
		$("oldPwd").val()
	});
</script>
</html>