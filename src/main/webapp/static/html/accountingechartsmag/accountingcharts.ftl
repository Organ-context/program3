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
<link rel="stylesheet" type="text/css"
	href="/billing/static/demo/demo.css">
<script type="text/javascript"
	src="/billing/static/js/jQuery-2.2.2-min.js"></script>
<script type="text/javascript"
	src="/billing/static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/billing/static/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/billing/static/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="/billing/static/js/jquery.json-2.4.js"></script>
<script type="text/javascript"
	src="/billing/static/js/echarts.common.min.js"></script>

</head>
<script>
	
</script>
<body>

	<!--账务月账单表格部分-->
	<table id="dg" title="业务账号总费用报表" style="width: 764px; height: 460px"
		toolbar="#tb"
		data-options="
				rownumbers:true,
				pageList:[10],
				singleSelect:true,
				autoRowHeight:true,
				pagination:true,
				pageSize:10,
				method:'get'">
	</table>
	<!--搜索-->
	<div id="tb" style="padding: 3px;">
		<label for="name" style="margin-left: 5px">姓 名:</label> <input
			id="name"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="请输入姓名"> <label for="accountingname"
			style="margin-left: 5px">账务账号:</label> <input id="accountingname"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="请输入账务账号"> <label for="accountingtime"
			style="margin-left: 5px">账单时间:</label> <input id="accountingtime"
			style="line-height: 26px; width: 100px; border: 1px solid #ccc"
			placeholder="输入格式yyyy-mm"> <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-search" style="border: 6px"
			onclick="submitForm()">搜索</a>
	</div>
	<!--右下角功能按钮-->
	<div style="margin: 20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" id="query1"
			iconCls="icon-search">查看账单图形报表</a> <a href="javascript:void(0)" id="query2"
			class="easyui-linkbutton" iconCls="icon-search">查看业务图形报表</a>
	</div>


	<!-- 弹出来的窗口 -->
	<div id="win" class="easyui-window" title="账单图形报表"
		style="width: 700px; height: 500px; top: 10px"
		data-options="iconCls:'icon-save',modal:true">
		<div id="main" style="width: 680px; height: 450px;"></div>
	</div>


	<!-- 弹出来的第二个窗口 -->
	<div id="win2" class="easyui-window" title="业务图形报表"
		style="width: 778px; height: 500px; top: 5px"
		data-options="iconCls:'icon-save',modal:true">
		<div id="main2" style="width: 680px; height: 450px;"></div>
	</div>

</body>
<script type="text/javascript">
	//最底层分页
	function queryParams() {
		var data = {
			userName : $('#name').val(),
			accountName : $('#accountingname').val(),
			idcard : "",
			time : $('#accountingtime').val()
		}
		return data;
	}
	//搜索
	function submitForm() {
		getData();
	}

	$(function() {
		getData();
	})

	function getData() {
		$('#dg').datagrid(
						{
							url : '/billing/accountingmonthajax/findpage',
							queryParams : queryParams(),
							columns : [ [
									{
										field : 'userName',
										title : '姓名',
										width : 180,
										align : 'center',
										formatter : function(value, rec) {
											return rec.userBean.userName
										}
									},
									{
										field : 'userAccountingName',
										title : '账务账号',
										width : 180,
										align : 'center',
										formatter : function(value, rec) {
											return rec.userBean.userAccountingName
										}
									},
									{
										field : 'monthCoast',
										title : '费用',
										align : 'center',
										width : 200
									},
									{
										field : 'month',
										title : '账单日期',
										align : 'center',
										width : 170
									}, ] ],
							
						})
	}

	// 窗口初始化关闭
	$(function() {
		$('#win').window('close')
		$('#win2').window('close')
	})

	
	$("#query1").bind('click', function() {
		var row = $('#dg').datagrid('getSelected');
		if (row != null) {
			$('#win').window('open')
			
			var myChart = echarts.init(document.getElementById('main'));
			option = {
				title : {
					text : '账单图形报表',
					subtext : '月费用查询',
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					left : 'left',
					data : [ '2018-01', '2018-02', '2018-03', '2018-04', '2018-06' ]
				},
				series : [ {
					name : '访问来源',
					type : 'pie',
					radius : '55%',
					center : [ '50%', '60%' ],
					data : [ {
						value : 335,
						name : '2018-01'
					}, {
						value : 310,
						name : '2018-02'
					}, {
						value : 234,
						name : '2018-03'
					}, {
						value : 135,
						name : '2018-04'
					}, {
						value : 1548,
						name : '2018-06'
					} ],
					itemStyle : {
						emphasis : {
							shadowBlur : 10,
							shadowOffsetX : 0,
							shadowColor : 'rgba(0, 0, 0, 0.5)'
						}
					}
				} ]
			};
			
			/*  $.ajax({
	             type : "get",
	             async : false, //同步执行
	             url : "/billing/echartsJSP/showEchartPie",
	             dataType : "json", //返回数据形式为json
	             data: "accountingName="+row.userBean.userAccountingName+"&Month="+row.month,
	             success : function(result) {
	            	 console.log(result)
	                 if (result) {
	             /*         options.legend.data = result.legend;

	                     //将返回的category和series对象赋值给options对象内的category和series
	                     //因为xAxis是一个数组 这里需要是xAxis[i]的形式
	                     options.series[0].name = result.series[0].name;
	                     options.series[0].type = result.series[0].type;
	                     var serisdata = result.series[0].data;
	                     
	                     //遍历
	                     /* var datas = [];
	                     for ( var i = 0; i < serisdata.length; i++) {
	                         datas.push({
	                             name : serisdata[i].name,
	                             value : serisdata[i].value
	                         });
	                     }
	                     options.series[0].data = datas; 

	                     //jquery遍历
	                    var value = [];
	                     $.each(serisdata, function(i, p) {
	                         value[i] = {
	                             'name' : p['name'],
	                             'value' : p['value']
	                         };
	                     });
	                     options.series[0]['data'] = value;

	                     myChart.hideLoading();
	                     myChart.setOption(options); 
	                 }
	             },
	             error : function(errorMsg) {
	                 alert("图表请求数据失败啦!");
	             }
	         }); */
			myChart.setOption(option); 
			
		} else {
			$.messager.show({
				title : '提示',
				msg : '请选择需要查看的数据',
				timeout : 5000,
				showType : 'slide'
			})
		}
	});
	
	
	$("#query2").bind('click', function() {
		var row = $('#dg').datagrid('getSelected');
		if (row != null) {
			$('#win2').window('open')

			var myChart = echarts.init(document.getElementById('main2'));
			option = {
				title : {
					text : '业务图形报表'
				},
				tooltip : {
					trigger : 'axis'
				},
				legend : {
					data : [ '2018-01', '2018-02', '2018-03', '2018-04', '2018-06' ]
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},
				toolbox : {
					feature : {
						saveAsImage : {}
					}
				},
				xAxis : {
					type : 'category',
					boundaryGap : false,
					data : [ '2018-01', '2018-02', '2018-03', '2018-04', '2018-06' ]
				},
				yAxis : {
					type : 'value'
				},
				series : [ {
					name : '账单账号',
					type : 'line',
					stack : '费用',
					data : [ 120, 132, 101, 134, 90, 230, 210 ]
				}, {
					name : '账单账号2',
					type : 'line',
					stack : '费用',
					data : [ 220, 182, 191, 234, 290, 330, 310 ]
				}, ]
			};
			myChart.setOption(option);
			
			/*  $.ajax({
	             type : "get",
	             async : false, //同步执行
	             url : "/billing/echartsJSP/showEchartPie",
	             dataType : "json", //返回数据形式为json
	             data: "accountingName="+row.userBean.userAccountingName+"&Month="+row.month,
	             success : function(result) {
	            	 console.log(result)
	                 if (result) {
	             /*         options.legend.data = result.legend;

	                     //将返回的category和series对象赋值给options对象内的category和series
	                     //因为xAxis是一个数组 这里需要是xAxis[i]的形式
	                     options.series[0].name = result.series[0].name;
	                     options.series[0].type = result.series[0].type;
	                     var serisdata = result.series[0].data;
	                     
	                     //遍历
	                     /* var datas = [];
	                     for ( var i = 0; i < serisdata.length; i++) {
	                         datas.push({
	                             name : serisdata[i].name,
	                             value : serisdata[i].value
	                         });
	                     }
	                     options.series[0].data = datas; 

	                     //jquery遍历
	                    var value = [];
	                     $.each(serisdata, function(i, p) {
	                         value[i] = {
	                             'name' : p['name'],
	                             'value' : p['value']
	                         };
	                     });
	                     options.series[0]['data'] = value;

	                     myChart.hideLoading();
	                     myChart.setOption(options); 
	                 }
	             },
	             error : function(errorMsg) {
	                 alert("图表请求数据失败啦!");
	             }
	         }); */
			
		} else {
			$.messager.show({
				title : '提示',
				msg : '请选择需要查看的数据',
				timeout : 5000,
				showType : 'slide'
			})
		}
	});
	
</script>
</html>