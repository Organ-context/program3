<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Basic DataGrid - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css" href="/billing/static/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/billing/static/js/themes/icon.css" />
<!--  <link href="../css/bootstrap.min.css" rel="stylesheet"/>
      <link href="../css/bootstrap-theme.min.css" rel="stylesheet"/> -->
<script type="text/javascript" src="/billing/static/js/jQuery-2.2.2-min.js"></script>
<script type="text/javascript" src="/billing/static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/billing/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/billing/static/js/locale/easyui-lang-zh_CN.js"></script>
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
				<table id="dg" title="业务账号资费查询查询"
					style="width: 764px; height: 458px" class="easyui-datagrid"
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

				<div id="tb" style="padding: 3px;">
					<span>资费名：</span> <input id="tariffName"
						style="line-height: 26px; border: 1px solid #ccc"> <a
						href="#" style="margin-left: 100px" class="easyui-linkbutton"
						iconCls="icon-search" style="border:6px" onclick="submitForm()">搜索</a>
				</div>
				
				<div style="margin: 20px 0;">
					<a href="javascript:void(0)" class="easyui-linkbutton" id="update1" iconCls="icon-reload">修改资费</a> 
					<a href="javascript:void(0)" class="easyui-linkbutton" id="deleteTariff" iconCls="icon-add">删除</a>
				</div>

				<div style="width: 90%; height: 60px; margin-top: 40px; background-color: #269abc">
					<h2 style="margin-left: 10px; padding-top: 15px">添加新资费</h2>
				</div>
				<div style="margin-top: 50px">
						<span>资费名：</span>
						<input type="text" style="width: 200px; height: 20px;" name="" id="newTariffName" /> 
						<span style="margin-left: 100px">基础花费：</span>
						<input type="text" style="width: 200px; height: 20px;" name="" id="newBasicCost" /> 
						<span style="margin-left: 100px">计价方式：</span>
						<input type="text" style="width: 200px; height: 20px;" name="" id="newPerCost" /> 
						<a id="saveNewTariff" href="#" style="margin-left: 400px" class="easyui-linkbutton" iconCls="icon-ok" style="border:6px">添加</a>
				</div>

				<div id="updateWindow" class="easyui-window" title="修改资费" closed="true" 
					data-options="iconCls:'icon-save'"
					style="width: 330px; height: 360px; padding: 5px;">
					<div class="easyui-layout" data-options="fit:true">
						<div data-options="region:'center'"
							style="padding: 10px; display: none">
							<div style="text-align: center; margin-top: 20px">
								<span>资费名:</span><input type="text"
									style="width: 200px; height: 20px;" name="" id="updateTariffName" />
							</div>
							<div style="margin-top: 50px">
								<span>资费类型：</span><input type="text"
									style="width: 200px; height: 20px;" name="" id="updateBasicCost" />
							</div>
							<div style="margin-top: 50px">
								<span>计价方式：</span><input type="text"
									style="width: 200px; height: 20px;" name="" id="updatePerCost" />
							</div>
						</div>
						<div data-options="region:'south',border:false"
							style="text-align: right; padding: 5px 0 0;">
							<a id="update99" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="$('#updateWindow').window('close');javascript:alert('修改成功')">修改</a>
							<a href="javascript:void(0)" class="easyui-linkbutton"
								data-options="iconCls:'icon-cancel'"
								onclick="$('#updateWindow').window('close')">取消</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script>

	var nowOs = "";
	
	// 删除按钮
	$("#deleteTariff").bind('click', function() {
		nowOs = $('#dg').datagrid('getSelected');
		var data = {
				nowTariffId : nowOs.id
		}
		if (nowOs != null) {
			$.ajax({
				type : "DELETE",
				data : data,
				url : "/billing/tariff/deleteTariff",
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
				msg : '请选择需要修改的数据',
				timeout : 5000,
				showType : 'slide'
			})
		}
	});
	
	// 修改按钮,点击之后弹出修改窗口
	$("#update1").bind('click', function() {
		nowOs = $('#dg').datagrid('getSelected');
		if (nowOs != null) {
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
	
	//修改业务账号的状态
	$("#update99").bind('click',function(){
		nowOs = $('#dg').datagrid('getSelected');
		var data = {
				nowTariffId : nowOs.id,
				updateTariffName : $('#updateTariffName').val(),
				updateBasicCost : $('#updateBasicCost').val(),
				updatePerCost : $('#updatePerCost').val()
		}
		console.log(data)
		if (nowOs != null) {
			$.ajax({
				type : "POST",
				data : data,
				url : "/billing/tariff/updateTariffInfo",
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
		} else {
			$.messager.show({
				title : '提示',
				msg : '请选择需要修改的数据',
				timeout : 5000,
				showType : 'slide'
			})
		}
	})
	
	
	
	//添加新资费
	$("#saveNewTariff").bind('click',function(){
		var data = {
				newTariffName : $('#newTariffName').val(),
				newBasicCost : $('#newBasicCost').val(),
				newPerCost : $('#newPerCost').val()
		}
		console.log(data)
		$.ajax({
			type : "POST",
			data : data,
			url : "/billing/tariff/add",
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
	
	//参数获取
	function queryParams() {
		var data = {
			tariffName : $('#tariffName').val(),
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
			url : '/billing/tariff/getTariffs',
			queryParams : queryParams(),
			columns : [ [ {
				field : 'tariffName',
				title : '资费名',
				width : 100,
				align : 'center'
			}, {
				field : 'basicCost',
				title : '基础花费',
				width : 110,
				align : 'center'
			}] ]
		})
	}
</script>

</html>