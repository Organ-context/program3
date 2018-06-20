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
				gender : $("#gender").val(),
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
				error : function() {
					console.log(11111)
				}
			}, "json");
		});
		$('#adminName').validatebox({
			required : true,
			validType : 'unnormal'
		});
