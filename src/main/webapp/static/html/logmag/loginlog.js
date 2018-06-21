function getData() {
		var rows = [];
		for (var i = 1; i <= 8; i++) {
		
			rows.push({
				id : i,
				managername : '张三'+i,
				managerlevel : '普通管理员',
				logintime : 2018-06-21,
				ip : iiiiiiiiii,
				operation : '账务管理员'
			});
		}
		return rows;
	}
	
	function pagerFilter(data) {
		if (typeof data.length == 'number'&& typeof data.splice == 'function') { // is array
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