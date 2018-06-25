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


	<!-- 弹出来的窗口 -->
	<div id="win" class="easyui-window" title="账单图形报表"
		style="width: 700px; height: 500px; top: 10px"
		data-options="iconCls:'icon-save',modal:true">
		<div id="main" style="width: 680px;height:450px;"></div>
	</div>


	<!-- 弹出来的第二个窗口 -->
	<div id="win2" class="easyui-window" title="业务图形报表"
		style="width: 778px; height: 500px; top: 5px"
		data-options="iconCls:'icon-save',modal:true">
		<div id="main2" style="width: 680px;height:450px;"></div>
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
		$('#dg').datagrid({
			url : '/billing/accountingmonthajax/findpage',
			queryParams : queryParams(),
			columns : [ [ {
				field : 'userName',
				title : '姓名',
				width : 120,
				align : 'center',
				formatter : function(value, rec) {
					return rec.userBean.userName
				}
			}, {
				field : 'userAccountingName',
				title : '账务账号',
				width : 120,
				align : 'center',
				formatter : function(value, rec) {
					return rec.userBean.userAccountingName
				}
			}, {
				field : 'monthCoast',
				title : '费用',
				align : 'center',
				width : 150
			},  {
				field : 'month',
				title : '账单日期',
				align : 'center',
				width : 110
			}, {
				field:'operate',
				title:'账单图形报表',
				align:'center',
				width:$(this).width()*0.1,  
			    formatter:function(value, row, index){  
			        var str = '<a href="javascript:void(0)" onclick="js_method()" name="opera" class="easyui-linkbutton" ></a>';  
			        return str
			    }
			},{
				field:'operate2',
				title:'业务图形报表',
				align:'center',
				width:$(this).width()*0.1,  
			    formatter:function(value, row, index){  
			        var str = '<a href="javascript:void(0)" onclick="js_method2()" name="opera" class="easyui-linkbutton" ></a>';  
			        return str
			    }
			},] ],
			onLoadSuccess:function(data){    
		        $("a[name='opera']").linkbutton({text:'查看',plain:true,iconCls:'icon-search'});    
		},  
		})
	}

	// 窗口初始化关闭
	$(function() {
		$('#win').window('close')
		$('#win2').window('close')
	})

	function js_method(){
		$('#win').window('open')	
		
		var myChart = echarts.init(document.getElementById('main'));
    option = {
   		    title : {
   		        text: '某站点用户访问来源',
   		        subtext: '纯属虚构',
   		        x:'center'
   		    },
   		    tooltip : {
   		        trigger: 'item',
   		        formatter: "{a} <br/>{b} : {c} ({d}%)"
   		    },
   		    legend: {
   		        orient: 'vertical',
   		        left: 'left',
   		        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
   		    },
   		    series : [
   		        {
   		            name: '访问来源',
   		            type: 'pie',
   		            radius : '55%',
   		            center: ['50%', '60%'],
   		            data:[
   		                {value:335, name:'直接访问'},
   		                {value:310, name:'邮件营销'},
   		                {value:234, name:'联盟广告'},
   		                {value:135, name:'视频广告'},
   		                {value:1548, name:'搜索引擎'}
   		            ],
   		            itemStyle: {
   		                emphasis: {
   		                    shadowBlur: 10,
   		                    shadowOffsetX: 0,
   		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
   		                }
   		            }
   		        }
   		    ]
   		};
	     myChart.setOption(option);
	}
	
	function js_method2(){
		$('#win2').window('open')	
		
		var myChart = echarts.init(document.getElementById('main2'));
		option = {
		         title: {
		             text: '折线图堆叠'
		         },
		         tooltip: {
		             trigger: 'axis'
		         },
		         legend: {
		             data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
		         },
		         grid: {
		             left: '3%',
		             right: '4%',
		             bottom: '3%',
		             containLabel: true
		         },
		         toolbox: {
		             feature: {
		                 saveAsImage: {}
		             }
		         },
		         xAxis: {
		             type: 'category',
		             boundaryGap: false,
		             data: ['周一','周二','周三','周四','周五','周六','周日']
		         },
		         yAxis: {
		             type: 'value'
		         },
		         series: [
		             {
		                 name:'邮件营销',
		                 type:'line',
		                 stack: '总量',
		                 data:[120, 132, 101, 134, 90, 230, 210]
		             },
		             {
		                 name:'联盟广告',
		                 type:'line',
		                 stack: '总量',
		                 data:[220, 182, 191, 234, 290, 330, 310]
		             },
		             {
		                 name:'视频广告',
		                 type:'line',
		                 stack: '总量',
		                 data:[150, 232, 201, 154, 190, 330, 410]
		             },
		             {
		                 name:'直接访问',
		                 type:'line',
		                 stack: '总量',
		                 data:[320, 332, 301, 334, 390, 330, 320]
		             },
		             {
		                 name:'搜索引擎',
		                 type:'line',
		                 stack: '总量',
		                 data:[820, 932, 901, 934, 1290, 1330, 1320]
		             }
		         ]
		     };
	     myChart.setOption(option);
	}

</script>
</html>