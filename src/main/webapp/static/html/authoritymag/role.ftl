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
		<label for="roleName" style="margin-left: 5px">角色名称:</label> <input
			id="roleName"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="请输入角色名称"> <label for="roleType"
			style="margin-left: 5px">角色类型:</label> <input id="roleType"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="请输入角色类型"> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" style="border: 6px" onclick="submitForm()">搜索</a>
	</div>

	<div style="margin: 20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" id="update1" iconCls="icon-reload">修改角色</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" id="saveRole" onclick="$('#saveWindow').window('open')" iconCls="icon-add">添加角色</a>
	</div>
	
	
	
	<!-- 添加角色的弹窗 -->
	<div id="saveWindow" class="easyui-window" title="修改资费"
		data-options="iconCls:'icon-save'"
		style="width: 330px; height: 450px; padding: 5px;" closed="true">
		<div class="easyui-layout" data-options="fit:true">
			<!--右侧树状图区域-->
			<!--  <div data-options="region:'east',split:true" style="width:100px"></div> -->
			<div data-options="region:'center'" style="padding: 10px; display: none">
				<div style="text-align: center">
					<span>角色名：</span> <input type="text" id="newRoleName">
				</div>

				<div style="text-align: center; margin-top: 50px">
					<label for="savett">选择权限</label>
					<div style="width:200px;height:auto;border:1px solid #ccc;">
						<ul id="savett" class="easyui-tree" data-options="url:'/billing/authority/getAuthoritys',method:'get',animate:true,checkbox:true,cascadeCheck:false"></ul>
					</div>

				</div>
			</div>
			<div data-options="region:'south',border:false" style="text-align: right; padding: 5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="$('#saveWindow').window('close')" id="save">添加</a> 
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#updateWindow').window('close')">取消</a>
			</div>
		</div>
	</div>
	
	
	

	<!-- 修改的弹窗 -->
	<div id="updateWindow" class="easyui-window" title="修改资费"
		data-options="iconCls:'icon-save'"
		style="width: 330px; height: 450px; padding: 5px;" closed="true">
		<div class="easyui-layout" data-options="fit:true">
			<!--右侧树状图区域-->
			<!--  <div data-options="region:'east',split:true" style="width:100px"></div> -->
			<div data-options="region:'center'"
				style="padding: 10px; display: none">
				<div style="text-align: center">
					<span>角色名：</span> <input type="text" id="updateRoleName">
				</div>

				<div style="text-align: center; margin-top: 50px">
					<label for="tt">选择权限</label>
					<div style="width:200px;height:auto;border:1px solid #ccc;">
						<ul id="tt" class="easyui-tree" data-options="url:'/billing/authority/getAuthoritys',method:'get',animate:true,checkbox:true,cascadeCheck:false"></ul>
					</div>
				</div>
				
			</div>
			<div data-options="region:'south',border:false"
				style="text-align: right; padding: 5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
					href="javascript:void(0)"
					onclick="$('#updateWindow').window('close')" id="update">保存</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'"
					onclick="$('#updateWindow').window('close')">取消</a>
			</div>
		</div>
	</div>
	
	

</body>
<script type="text/javascript">
	//参数获取
	function queryParams() {
		var data = {
			userName : $('#roleName').val(),
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
			url : '/billing/role/getRolePager',
			queryParams : queryParams(),
			columns : [ [ {
				field : 'roleName',
				title : '角色名称',
				width : 100,
				align : 'center'
			}, {
				field : 'roleType',
				title : '角色类型',
				width : 110,
				align : 'center'
			} ] ]
		})
	}
	
	var nowRole = "";
	//添加按钮
	$("#save").bind('click',function(){
		var authoritys = $('#savett').tree('getChecked').id;
		var newRoleName = $('#newRoleName').val();
		var data = {
				newRoleName : newRoleName,
				authoritys : authoritys
		}
		console.log(data)
			$.ajax({
				type : "POST",
				data : data,
				url : "/billing/role/saveRole",
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
	})
	

	// 修改按钮,点击之后弹出修改窗口
	$("#update1").bind('click', function() {
		nowRole = $('#dg').datagrid('getSelected');
		if (nowRole != null) {
			$("#updateWindow").window('open')
		} else {
			$.messager.show({
				title : '提示',
				msg : '请选择需要修改的数据',
				timeout : 5000,
				showType : 'slide'
			})
		}
	});

	//修改操作
	$("#update").bind('click', function() {
		var authoritys = $('#tt').tree('getChecked');
		var updateData = {
			nowRoleId : nowRole.id,
			updateRoleName : $('#updateRoleName').val()
		}
		console.log(updateData)
		$.ajax({
			type : "GET",
			data : updateData,
			url : "/billing/role/updateRole",
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
		$.messager.show({
			title : '提示',
			msg : '添加成功',
			timeout : 5000,
			showType : 'slide'
		})
	})
</script>
</html>