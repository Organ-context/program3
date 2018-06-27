
$(function () {
    $('#tt').tree({

    	onClick: function(node) {
            var str='';

            if(node.text=="个人信息"){
            	str='static/html/adminmag/admin2.ftl';
            }
            if(node.text=="账单信息"){
            	str='static/html/adminmag/admin2.ftl';
            }
            if(node.text=="管理员管理"){
                str='static/html/adminmag/admin2.ftl';
            }if(node.text=="年账务查询"){
                str='static/html/osaccountingmag/osaccountingyear.ftl';
            }if(node.text=="月账务查询"){
                str='static/html/osaccountingmag/osaccountingmonth.ftl';
            }if(node.text=="权限管理"){
                str='static/html/adminmag/admin2.ftl';
            }if(node.text=="角色管理"){
                str='static/html/adminmag/admin2.ftl';
            }if(node.text=="资费管理"){
                str='static/html/tariffmag/tariffFirst.ftl';
            }if(node.text=="账务账号管理"){
                str='static/html/accountingmag/accounting.ftl';
            }if(node.text=="业务账号管理"){
                str='static/html/accounting_osmag/osaccounting.ftl';
            }if(node.text=="登录日志"){
                str='static/html/logmag/loginlog.ftl';
            }if(node.text=="前台日志"){
                str='static/html/logmag/operationlog.ftl';
            }if(node.text=="账单查询系统"){
                str='static/html/osmag/accMonth.ftl';
            }
            
            
            
            var content = '<iframe scrolling="auto" frameborder="0"  src="'+str+'" style="width:100%;height:100%;"></iframe>';
            if(str!=""){
                $('#tabs').tabs('close', node.text);
                $('#tabs').tabs('add',{
                    title:node.text,
                    content:content,
                    width:'100%',
                    height:'100%',
                    closable:true,
                });
            }

        }
    });

})
			function addone() {
			    var str = "../html/selfservice/112.html";
			    var content = '<iframe scrolling="auto" frameborder="0"  src="'+str+'" style="width:100%;height:100%;"></iframe>'
			    $('#tabs').tabs('close',"个人信息");
			    $('#tabs').tabs('add',{
			        title:"个人信息",
			        content:content,
			        closable:true
			    });
}