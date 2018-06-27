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
	<table id="dg" title="账务账号查询" style="width: 764px; height: 458px"
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
		<label for="username" style="margin-left: 5px">姓 名:</label> 
		<input id="username" style="line-height: 26px; width: 100px; border: 1px solid #ccc" placeholder="请输入姓名"> 
		<label for="userAccountingName" style="margin-left: 5px">账务账号:</label> 
		<input id="userAccountingName" style="line-height: 26px; width: 100px; border: 1px solid #ccc" placeholder="请输入账务账号"> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" style="border: 6px" onclick="submitForm()">搜索</a>
		
		<form action="upload" enctype="multipart/form-data" method="post">
        <table>
            <tr>
                <td>请选择文件:</td>
                <td><input type="file" name="file"></td>
            </tr>
            <tr>
                <td><input type="submit" value="批量添加账务账号"></td>
            </tr>
        </table>
   		</form>
	</div>

	<div style="margin: 20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" id="changeState" iconCls="icon-reload">修改账号状态</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" id="addOs" onclick="" iconCls="icon-add">添加业务账号</a>
	</div>

	<!--新增业务账号的弹窗-->
	<div id="add" class="easyui-window" title="添加业务账号" data-options="iconCls:'icon-save'" style="width: 330px; height: 450px; padding: 5px;" closed="true">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'"
				style="padding: 10px; display: none">
				<div style="margin-left: 10px; width: 90px; display: inline-block">
					<label for="nowAccount">账务账号：</label> <span id="nowAccount"style="font-size: 20px; color: #0000FF">666</span>
				</div>
				</br> </br>
				<div style="margin-left: 10px; width: 90px; display: inline-block">
					<label for="newOsAccount">业务账号：</label>
				</div>
				<input id="newOsAccount" name="newOsAccount"style="line-height: 20px; border: 1px solid #ccc"> 
				</br> </br>
				
				<div style="text-align: center; margin-top: 50px">
					<label for="cc">选择资费</label>
					<select id="cc" class="easyui-combobox" name="dept"
						style="width: 100px"
						data-options="
							url:'/billing/tariff/getAllTariff',
							method:'get',
							valueField:'id',
							textField:'tariffName',
							panelHeight:'auto'
					">
					</select>

				</div>
				
				<div style="text-align: center; margin-top: 50px">
					<label for="server">选择服务器</label>
					<select id="server" class="easyui-combobox" name="dept"
						style="width: 100px"
						data-options="
							url:'/billing/accountingmag/getAllServer',
							method:'get',
							valueField:'id',
							textField:'server_ip',
							panelHeight:'auto'
					">
					</select>

				</div>
				</br> </br>
			<div data-options="region:'south',border:false" style="text-align: right; padding: 5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" id="savaOsAccount">保存</a> 
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#add').window('close')">取消</a>
			</div>
		</div>
		</div>
	</div>
</body>
<script type="text/javascript">

	//业务账号的正则
	$("#newOsAccount").bind('onblur',function(){
		var osName = $("#newOsAccount").val; 
        var datas = {
    			fileAddress : osName
    		}
		console.log(src)
		$.ajax({
			type : "POST",
			data : datas,
			url : "//billing/accountingmag/saveAccountings",
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
	})
	//参数获取
	function queryParams() {
		var data = {
			userName : $('#username').val(),
			userAccountingName : $('#userAccountingName').val()
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
	
	//批量添加账务账号
	$("#saveButton").bind('click',function(){
		var oFReader = new FileReader();  
        var file = document.getElementById('accountings').files[0];  
        oFReader.readAsDataURL(file);  
        var src="";
        oFReader.onloadend = function(oFRevent){  
        	src = oFRevent.target.result;  
        }
        var datas = {
    			fileAddress : src
    		}
		console.log(src)
		$.ajax({
			type : "POST",
			data : datas,
			url : "//billing/accountingmag/saveAccountings",
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
	})
	
	//修改账务账号状态
	$("#changeState").bind('click', function() {
		nowAccounting = $('#dg').datagrid('getSelected');
		if (nowAccounting != null) {
			var datas={
				nowAccount : nowAccounting.id
			}
			console.log(datas)
			$.ajax({
				type : "POST",
				data : datas,
				url : "/billing/accountingmag/updateAccounting",
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
				msg : '请选择需要修改的账务账号',
				timeout : 5000,
				showType : 'slide'
			})
		}
	});

	//获取分页数据
	function getData() {
		$('#dg').datagrid({
			url : '/billing/accountingmag/getAccountingPager',
			queryParams : queryParams(),
			columns : [ [ {
				field : 'userName',
				title : '姓名',
				width : 100,
				align : 'center',
			}, {
				field : 'userAccountingName',
				title : '账务账号',
				width : 110,
				align : 'center'
			}, {
				field : 'userAccountingState',
				title : '账号状态',
				width : 180,
				align : 'center'
			}, {
				field : 'userAddress',
				title : '用户地址',
				align : 'center',
				width : 100,
			} ] ]
		})
	}
	
	var nowAccounting = "";
	
	// 添加业务账号按钮
	$("#addOs").bind('click', function() {
		nowAccounting = $('#dg').datagrid('getSelected');
		if (nowAccounting != null) {
			$('#add').window('open')
			$("#nowAccount").html(nowAccounting.userAccountingName)
		} else {
			$.messager.show({
				title : '提示',
				msg : '请选择需要添加的账务账号',
				timeout : 5000,
				showType : 'slide'
			})
		}
		
	});

	//新增业务账号的保存
	$("#savaOsAccount").bind('click', function() {
		var newTariffId = $('#cc').combobox('getValue');
		var serverId = $('#server').combobox('getValue');
		var osAccountingName = $('#newOsAccount').val();
		var data = {
			accountingId : nowAccounting.id,
			tariffId : newTariffId,
			osAccounting : osAccountingName,
			serverId : serverId
		}
		console.log(data)
		$.ajax({
			type : "POST",
			data : data,
			url : "/billing/accountingmag/addOsAccounting",
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
			msg : '修改成功',
			timeout : 5000,
			showType : 'slide'
		})
		$('#add').window('close')
	});
	
</script>
</html>