<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
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
<!-- <script type="text/javascript" src="../../plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="../../plugins/validatebox.js"></script> -->
<style>
/*#dg {*/
/*position: relative;*/
/*margin-left: 180px;*/
/*margin-top: 50px;*/
/*}*/
</style>
</head>
<script>
	
</script>
<body>
	<!--<div style="margin:20px 0;"></div>-->

	<!--表格部分-->
	<table id="dg" title="用户管理" style="width: 714px; height: 458px"
		toolbar="#tb"
		data-options="
				rownumbers:true,
				pageList:[10],
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10">
		<thead>
			<tr>
				<th data-options="field:'itemid'" hidden="ture" field="id"></th>
				<th data-options="field:'itemid',width:100,align:'center'"
					field="name">姓名</th>
				<th data-options="field:'productid',width:100,align:'center'"
					field="user">用户</th>
				<th data-options="field:'listprice',width:80,align:'center'"
					field="gender">性别</th>
				<th data-options="field:'unitcost',width:150,align:'center'"
					field="tel">联系方式</th>
				<th data-options="field:'attr1',width:100,align:'center'"
					field="role">角色</th>
				<th data-options="field:'status',width:150,align:'center'"
					field="email">邮箱</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<!--搜索-->
	<div id="tb" style="padding: 3px;">
		<span>真实姓名：</span> <input id="realname"
			style="line-height: 26px; border: 1px solid #ccc"> <span>用户名：</span>
		<input id="productid"
			style="line-height: 26px; border: 1px solid #ccc"> <span>角色：</span>
		<select id="cc" class="easyui-combobox" name="dept"
			style="width: 150px;">
			<option value="">全部管理员</option>
			<option value="userMag">用户管理员</option>
			<option value="tariffMag">资费管理员</option>
			<option value="accoutingMag">账务查询管理员</option>
			<option value="accoutingMonthMag">账单查询管理员</option>
			<option value="osMag">报表管理员</option>
			<option value="logMag">日志管理员</option>
		</select> <a href="#" class="easyui-linkbutton" iconCls="icon-search"
			style="border: 6px">搜索</a>
	</div>

	<!--右下角功能按钮-->
	<div style="margin: 20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" id="update1"
			iconCls="icon-reload">修改</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="$('#add').window('open')"
			iconCls="icon-add">新增</a> <a href="javascript:void(0)" id="delete1"
			class="easyui-linkbutton" iconCls="icon-remove"
			href="javascript:void(0)" onclick="$('#deleteUser').window('close')">删除</a>
	</div>

	<!--修改的弹窗-->
	<div id="o">
		<div id="w" class="easyui-window" title="修改"
			data-options="iconCls:'icon-save'"
			style="width: 330px; height: 300px; padding: 5px;" closed="true">
			<div class="easyui-layout" data-options="fit:true">
				<!--右侧树状图区域-->
				<!--  <div data-options="region:'east',split:true" style="width:100px"></div> -->
				<div data-options="region:'center'"
					style="padding: 10px; display: none">
					<div style="margin-left: 10px; width: 90px; display: inline-block">
						<label for="newPwd">请输入新密码：</label>
					</div>
					<input id="newPwd" name="newPwd"
						style="line-height: 20px; border: 1px solid #ccc"> </br> </br>
					<div style="margin-left: 10px; width: 90px; display: inline-block">
						<label for="oldPwd">请确认密码：</label>
					</div>
					<input id="oldPwd" name="newPwd"
						style="line-height: 20px; border: 1px solid #ccc"> </br> </br>
					<div style="margin-left: 10px; width: 90px; display: inline-block">
						<label for="oldPwd">联系方式：</label>
					</div>
					<input id="tel" name="tel"
						style="line-height: 20px; border: 1px solid #ccc"> </br> </br>
					<div style="margin-left: 10px; width: 90px; display: inline-block">
						<label for="email">邮箱：</label>
					</div>
					<input id="email" name="email"
						style="line-height: 20px; border: 1px solid #ccc">
				</div>
				<div data-options="region:'south',border:false"
					style="text-align: right; padding: 5px 0 0;">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
						href="javascript:void(0)" onclick="$('#w').window('close')"
						id="sava1">保存</a> <a href="javascript:void(0)"
						class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
						onclick="$('#w').window('close')">取消</a>
				</div>
			</div>
		</div>
	</div>

	<!--新增的弹窗-->
	<div id="add" class="easyui-window" title="新增"
		data-options="iconCls:'icon-save'"
		style="width: 330px; height: 360px; padding: 5px;" closed="true">
		<div class="easyui-layout" data-options="fit:true">
			<!--右侧树状图区域-->
			<!--  <div data-options="region:'east',split:true" style="width:100px"></div> -->
			<div data-options="region:'center'"
				style="padding: 10px; display: none">
				<div style="margin-left: 10px; width: 90px; display: inline-block">
					<label for="adminName">管理员名称：</label>
				</div>
				<span style="font-size: 18px;"><input id="adminName"
					name="adminName" style="line-height: 20px; border: 1px solid #ccc"
					class="easyui-validatebox"
					data-options="required:true,validType:'unnormal'"></span> </br> </br>
				<div style="margin-left: 10px; width: 90px; display: inline-block">
					<label for="adminAcc">管理员账号：</label>
				</div>
				<input id="adminAcc" name="adminAcc"
					style="line-height: 20px; border: 1px solid #ccc"> </br> </br>
				<div style="margin-left: 10px; width: 90px; display: inline-block">
					<label for="adminPwd">密码：</label>
				</div>
				<input id="adminPwd" name="adminPwd"
					style="line-height: 20px; border: 1px solid #ccc" type="password"
					class="easyui-validatebox" data-options="required:true"> </br> </br>
				<div style="margin-left: 10px; width: 90px; display: inline-block">
					<label for="adminPwdSure">确认密码：</label>
				</div>
				<span style="font-size: 18px;"><input id="adminPwdSure"
					name="adminPwdSure"
					style="line-height: 20px; border: 1px solid #ccc" type="password"
					class="easyui-validatebox" required="required"
					validType="equals['#adminPwd']"></span> </br> </br>

				<div style="margin-left: 10px; width: 90px; display: inline-block">
					<label for="adminTel">联系方式：</label>
				</div>
				<input id="adminTel" name="adminTel"
					style="line-height: 20px; border: 1px solid #ccc"
					class="easyui-validatebox" data-options="required:true"
					validType="mobile"> </br> </br>
				<div style="margin-left: 10px; width: 90px; display: inline-block">
					<label for="adminEmail">邮箱：</label>
				</div>
				<input id="adminEmail" name="adminEmail" class="easyui-validatebox"
					data-options="required:true,validType:'email'"
					style="line-height: 20px; border: 1px solid #ccc">
			</div>
			<div data-options="region:'south',border:false"
				style="text-align: right; padding: 5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
					href="javascript:void(0)" id="sava2">保存</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'"
					onclick="$('#add').window('close')">取消</a>
			</div>
		</div>
	</div>
	<script>
		function getData() {
			var rows = [];
			for (var i = 1; i <= 20; i++) {
				var amount = Math.floor(Math.random() * 1000);
				var price = Math.floor(Math.random() * 1000);
				rows.push({
					id : i,
					name : '用户' + i,
					user : '用户' + i,
					gender : '男',
					tel : amount,
					role : price,
					email : amount * price
				});
			}
			return rows;
		}

		function pagerFilter(data) {
			if (typeof data.length == 'number'
					&& typeof data.splice == 'function') { // is array
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

		$('#sava2').bind('click', function() {
			var data = {
				userName : $("#adminName").val(),
				userAccountingName : $("#adminAcc").val(),
				userPassword : $("#adminPwd").val(),
				telephone : $("#adminTel").val(),
				email : $("#adminEmail").val()
			};
			console.log(data)
			$.ajax({
				type : "POST",
				data : data,
				url : "/program3/admin/add",
				success : function(msg) {
					console.log(9)
					$.messager.show({
						title : '提示',
						msg : '添加成功',
						timeout : 5000,
						showType : 'slide'
					})
				},
				error:function(){
					console.log(11111)
				}
			},"json");
		});
		$('#adminName').validatebox({
			required : true,
			validType : 'unnormal'
		});
	</script>
</body>
</html>