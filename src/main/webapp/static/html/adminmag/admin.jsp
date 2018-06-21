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
<script type="text/javascript" src="../../js/locale/easyui-lang-zh_CN.js"></script>
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
	<table id="dg" title="用户管理" style="width: 764px; height: 458px"
		toolbar="#tb"
		data-options="
				rownumbers:true,
				pageList:[10],
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10">
		<thead>
		</thead>
		<tbody>
		</tbody>
	</table>
	<!--搜索-->
	<div id="tb" style="padding: 3px;">
		<span>真实姓名：</span> 
		<input id="realname" name="realname" style="line-height: 26px; border: 1px solid #ccc"> 
		<span>用户名：</span>
		<input id="username" name="username" style="line-height: 26px; border: 1px solid #ccc"> 
		<span>角色：</span> 
		<select id="role" name="role" class="easyui-combobox" style="width: 150px;">
			<option value="">全部管理员</option>
			<option value="用户管理员">用户管理员</option>
			<option value="资费管理员">资费管理员</option>
			<option value="账务查询管理员">账务查询管理员</option>
			<option value="账单查询管理员">账单查询管理员</option>
			<option value="报表管理员">报表管理员</option>
			<option value="日志管理员">日志管理员</option>
		</select> 
		<a  href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" style="border: 6px" onclick="submitForm()">搜索</a>
	</div>

	<!--右下角功能按钮-->
	<div style="margin: 20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" id="update1" iconCls="icon-reload">修改</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#add').window('open')" iconCls="icon-add">新增</a> 
		<a href="javascript:void(0)" id="delete1" class="easyui-linkbutton" iconCls="icon-remove" href="javascript:void(0)" onclick="$('#deleteUser').window('close')">删除</a>
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
					<input id="oldPwd" name="oldPwd"
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
		style="width: 330px; height: 450px; padding: 5px;" closed="true">
		<div class="easyui-layout" data-options="fit:true">
			<!--右侧树状图区域-->
			<!--  <div data-options="region:'east',split:true" style="width:100px"></div> -->
			<div data-options="region:'center'"
				style="padding: 10px; display: none">
				<div style="margin-left: 10px; width: 90px; display: inline-block">
					<label for="adminName">管理员名称：</label>
				</div>
				<input id="adminName" name="adminName"
					style="line-height: 20px; border: 1px solid #ccc"> </br> </br>
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
					<label for="gender">性别：</label>
				</div>
				<select id="gender" class="easyui-combobox" name="gender"
					style="width: 150px;">
					<option value="1">男</option>
					<option value="0">女</option>
				</select> </br> </br>
	 			<div style="margin-left: 10px; width: 90px; display: inline-block">
					<label for="role">角色：</label>
				</div>
				<select id="role1" class="easyui-combobox" name="role" style="width: 150px;">
					<option value="用户管理员" selected>用户管理员</option>
					<option value="资费管理员">资费管理员</option>
					<option value="账务查询管理员">账务查询管理员</option>
					<option value="账单查询管理员">账单查询管理员</option>
					<option value="报表管理员">报表管理员</option>
					<option value="日志管理员">日志管理员</option>
				</select>
				</br> 
				</br> 
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
</body>
<script type="text/javascript">
//分页
function queryParams(){
	var data = {
			realname : $('#realname').val(),
			username : $('#username').val(),
			role : $('#role').val()
	}
	return data;
}

//搜索
function submitForm(){
	getData();
	$('#realname').val(''),
	$('#username').val(''),
	$('#role').val('')
}

$(function(){
	getData();
})

function getData(){
	$('#dg').datagrid({
		url : '/program3/admin/getAdminPager',
		queryParams : queryParams(),
		columns:[[
			{field:'userName',title:'姓名',width:100},
			{field:'userAccountingName',title:'用户',width:100},
			{field:'gender',title:'性别',width:80,formatter:function(value,row,index){
				if(value==1){
					return '男'
				}else{
					return '女'
				}
			}},
			{field:'telephone',title:'联系方式',width:150},
			{field:'roleBean',title:'角色',width:150,formatter:function(value){
					return value.roleName
			}},
			{field:'email',title:'邮箱',width:150},
	    ]]
	})
}


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
		roleName : $("#role1").val(),
		telephone : $("#adminTel").val(),
		email : $("#adminEmail").val()
	};
	console.log(data)
	$.ajax({
		type : "POST",
		data : data,
		url : "/billing/admin/add",
		datatype:"json",
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
	getData();
	$.messager.show({
        title: '提示',
        msg: '添加成功',
        timeout: 5000,
        showType: 'slide'
    })
	$('#add').window('close')
	 	$("#adminName").val("")
		$("#adminAcc").val("")
		$("#adminPwd").val("")
		$("#adminPwdSure").val("")
		$("#gender").val("")
		$("#role").val("")
		$("#adminTel").val("")
		$("#adminEmail").val("")
		$("oldPwd").val()
});



</script>
</html>