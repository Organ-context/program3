<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/billing/static/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/billing/static/js/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="/billing/static/demo/demo.css">
<script type="text/javascript" src="/billing/static/js/jQuery-2.2.2-min.js"></script>
<script type="text/javascript" src="/billing/static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/billing/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/billing/static/js/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="/billing/static/css/bootstrap.min.css">
</head>
<body>
<table id="dg"></table>
<div id="tb">
	<input id="dd" type="text">
	<button type="button" class="btn btn-primary search">搜索</button>
</div>
<div id="win">
	<table id="detailed"></table>
</div>
<div id="ch">
	<table id="detailedS"></table>
</div>
<script>
$(function() {
	$('#dd').datebox({
	    required:true
	});
	$('#dg').datagrid({
		url:"/billing/Proscenium/selectAccountingMonthByUserId",
		queryParams:{id:1,monthe:null},
		autoRowHeight:true,
		toolbar: '#tb',
		pagination:true,
		onDblClickRow: function(rowIndex,rowData){
			//弹出弹框，加载数据
			$('#win').window('open'); // open a window
			loadDetailed(1,rowData.month);
		},
	    columns:[[
			{field:'payCondition',title:'支付状态',width:200,align:'center'},
			{field:'month',title:'月份',width:200,align:'center',formatter: function(value,row,index){
				//格式化日期
				return getMyDate(value);
			}},
			{field:'monthCoast',title:'费用',width:200,align:'center'},
			{field:'payWay',title:'支付方式',width:200,align:'center'},
	    ]]
	});
	//搜索事件
	$(".search").on("click",function(){
		//获取日历的值
		var v = $('#dd').datebox('getValue');
		var queryParams = $('#dg').datagrid('options').queryParams; 
		queryParams.monthe=v;
		$('#dg').datagrid('reload',queryParams);
	})
	//弹框
	$('#win').window({
	    width:1000,
	    height:400,
	    title:"费用明细",
	    modal:true
    });
	
	//账单明细表格初始化
	function loadDetailed(id,monthe){
		$("#detailed").datagrid({
			url:"/billing/Proscenium/selectOsCostDetailsBymonth",
			queryParams:{id:id,monthe:monthe},
			autoRowHeight:true,
			pagination:true,
			onDblClickRow: function(rowIndex,rowData){
				//弹出弹框，加载数据
				$('#ch').window('open'); // open a window
				loadDetailedS(1,rowData.month);
			},
			columns:[[
				{field:'loginTime',title:'登入时间',width:200,align:'center',formatter: function (value,row,index) {
					console.log(value);
					return getMyDate2Day(value);
				}},
				{field:'outTime',title:'退出时间',width:200,align:'center',formatter: function(value,row,index){
					//格式化日期
					return getMyDate2Day(value);
				}},
				{field:'totalTime',title:'使用时长',width:100,align:'center'},
				{field:'dayCoast',title:'费用',width:100,align:'center'},
				{field:'costType',title:'资费类型',width:100,align:'center'},
				{field:'ip',title:'服务器Ip',width:200,align:'center'},
		    ]]
		})
	}
	
	
	
	//账单明细表格初始化
	function loadDetailedS(id,monthe){
		$("#detailedS").datagrid({
			url:"/billing/Proscenium/selectOsCostDetailsBymonth",
			queryParams:{id:id,monthe:monthe},
			autoRowHeight:true,
			pagination:true,
			columns:[[
				{field:'loginTime',title:'登入时间',width:200,align:'center',formatter: function (value,row,index) {
					console.log(value);
					return getMyDate2Day(value);
				}},
				{field:'outTime',title:'退出时间',width:200,align:'center',formatter: function(value,row,index){
					//格式化日期
					return getMyDate2Day(value);
				}},
				{field:'totalTime',title:'使用时长',width:100,align:'center'},
				{field:'dayCoast',title:'费用',width:100,align:'center'},
				{field:'costType',title:'资费类型',width:100,align:'center'},
				{field:'ip',title:'服务器Ip',width:200,align:'center'},
		    ]]
		})
	}
	
	$('#win').window('close'); // close a window
	//时间戳转换日期(到月)
	function getMyDate(str){  
        var oDate = new Date(str),  
        oYear = oDate.getFullYear(),  
        oMonth = oDate.getMonth()+1,  
        oDay = oDate.getDate(),  
        oHour = oDate.getHours(),  
        oMin = oDate.getMinutes(),  
        oSen = oDate.getSeconds(),  
        oTime = oYear +'-'+ getzf(oMonth);//最后拼接时间  
        return oTime;  
    	}; 
    	//补0操作
	  function getzf(num){  
	      if(parseInt(num) < 10){  
	          num = '0'+num;  
	      }  
	      return num;  
	 }
    	//到日
	  function getMyDate2Day(str){  
	        var oDate = new Date(str),  
	        oYear = oDate.getFullYear(),  
	        oMonth = oDate.getMonth()+1,  
	        oDay = oDate.getDate(),  
	        oHour = oDate.getHours(),  
	        oMin = oDate.getMinutes(),  
	        oSen = oDate.getSeconds(),  
	        oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间  
	        return oTime;  
	    	}; 
	    	//补0操作
		  function getzf(num){  
		      if(parseInt(num) < 10){  
		          num = '0'+num;  
		      }  
		      return num;  
		 }
})

</script>
</body>
</html>