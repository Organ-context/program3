<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${request.contextPath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/billing/static/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/billing/static/js/themes/icon.css" />
<script type="text/javascript" src="/billing/static/js/jQuery-2.2.2-min.js"></script>
<script type="text/javascript" src="/billing/static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/billing/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/billing/static/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/billing/static/js/jquery.json-2.4.js"></script>
</head>
<body>
	<div style="width:200px;height:auto;border:1px solid #ccc;">
		<ul id="tt" class="easyui-tree" data-options="url:'/billing/authority/getAuthoritys',method:'get',animate:true"></ul>
	</div>
	<div style="margin: 20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" id="saveAuthority"  iconCls="icon-reload">添加权限</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" id="deleteAuthority" iconCls="icon-add">删除权限</a>
	</div>
	
	<!-- 添加新权限的弹窗 -->
	<div id="saveWindow" class="easyui-window" title="添加权限"
		data-options="iconCls:'icon-save'"
		style="width: 330px; height: 450px; padding: 5px;" closed="true">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'"
				style="padding: 10px; display: none">
				<div style="text-align: center">
					<span>当前父权限名：</span> <span id="nowAuthority"style="font-size: 20px; color: #0000FF">包月</span>
				</div>
				<div style="text-align: center">
					<input type="text" id="newAuthorityName">
				</div>
			</div>
			<div data-options="region:'south',border:false"
				style="text-align: right; padding: 5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
					href="javascript:void(0)"
					onclick="$('#saveWindow').window('close')" id="save">添加</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'"
					onclick="$('#saveWindow').window('close')">取消</a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var node = "";
	
	//权限删除按钮
	$("#deleteAuthority").bind('click', function() {
		node = $('#tt').tree('getSelected');
		var datas = {
				authorityId : node.id,
		}
		if (node != null) {
			$.ajax({
				type : "DELETE",
				data : datas,
				url : "/billing/authority/deleteAuthority",
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
			
		} else {
			$.messager.show({
				title : '提示',
				msg : '请选择要删除的权限',
				timeout : 5000,
				showType : 'slide'
			})
		}
	});
	
	//权限添加按钮
	$("#saveAuthority").bind('click', function() {
		node = $('#tt').tree('getSelected');
		if (node != null) {
			$("#saveWindow").window('open');
			$("#nowAuthority").html(node.text);
			console.log(node);
		} else {
			$.messager.show({
				title : '提示',
				msg : '请选择权限父节点',
				timeout : 5000,
				showType : 'slide'
			})
		}
	});
	
	//添加权限
	$("#save").bind('click', function() {
		var newAuthorityName = $('#newAuthorityName').val();
			var datas={
				superAuthorityId : node.id,
				newAuthorityName : newAuthorityName
			}
			console.log(datas)
			$.ajax({
				type : "POST",
				data : datas,
				url : "/billing/authority/saveAuthority",
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
	});
</script>
</html>