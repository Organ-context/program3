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
	<table id="dg" title="账单查询" style="width: 764px; height: 458px"
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
		<a href="javascript:void(0)" class="easyui-linkbutton" id="update1"
			iconCls="icon-reload">修改资费</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="$('#add').window('open')"
			iconCls="icon-add">开通</a>
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
					<span>当前资费：</span> <span id="nowTariff"
						style="font-size: 20px; color: #0000FF">包月</span>
				</div>

				<div style="text-align: center; margin-top: 50px">
					<select id="cc" class="easyui-combobox" name="dept" style="width: 100px"
						data-options="
							url:'/billing/tariff/getAllTariff',
							method:'get',
							valueField:'id',
							textField:'tariffName',
							panelHeight:'auto'
					">
					</select>

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
					console.log(rec)
					return rec.userBean.userName
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

	// 修改按钮,点击之后弹出修改窗口
	var nowOs = "";
	$("#update1").bind('click', function() {
		nowOs = $('#dg').datagrid('getSelected');
		if (nowOs != null) {
			$("#updateWindow").window('open')
			$("#nowTariff").html(nowOs.tariffBean.tariffName)
		} else {
			$.messager.show({
				title : '提示',
				msg : '请选择需要修改的数据',
				timeout : 5000,
				showType : 'slide'
			})
		}
	});
	
	$("#update").bind('click', function(){
		var data = {
				osBean : nowOs,
				newTariff : $("#cc").val()
		}
		console.log(data)
		$.ajax({
			type : "POST",
			data : data,
			url : "/billing/tariff/updateTariff",
			datatype:"json",
			success : function(msg) {
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
	})

</script>
</html>