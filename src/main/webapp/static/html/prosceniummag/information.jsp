<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
<form  class="form-horizontal">
	<div class="form-group">
	    <label  class="col-sm-2 control-label">姓名：</label>
	    <div class="col-sm-4">
	    	<input type="text" class="form-control" name="username">
	    </div>
  </div>
 <div class="form-group">
    <label class="col-sm-2 control-label">性别：</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" name="gender">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">身份证：</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" name="userIdcard">
    </div>
  </div>
   <div class="form-group">
    <label class="col-sm-2 control-label">账务账号：</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" name="userAccountingName">
    </div>
  </div>
   <div class="form-group">
    <label class="col-sm-2 control-label">账务账号状态：</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" name="userAccountingState">
    </div>
  </div>
   <div class="form-group">
    <label class="col-sm-2 control-label">通讯地址：</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" name="userAddress">
    </div>
  </div>
   <div class="form-group">
    <label class="col-sm-2 control-label">邮编：</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" name="userPostnum">
    </div>
  </div>
    <div class="form-group">
    <label class="col-sm-2 control-label">qq号码：</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" name="userQqnum">
    </div>
  </div>
    <div class="form-group">
    <label class="col-sm-2 control-label">电话号码：</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" name="telephone">
    </div>
    <button type="button" class="btn btn-primary savatelephonenum">修改</button>
  </div>
   
</form>
</body>
<script type="text/javascript">
    $(function(){
    	//添加修改时间
    	$(".savatelephonenum").on("click",function(){
    		//todo:使电话号码input处于编辑状态，就是移除disabled属性
    		$("input[name='telephone']").removeAttr("disabled");
    		$(".savatelephonenum").after("<button type='button' class='btn btn-primary sava'>保存</button>")
    	})
    	//保存的点击事件
    	$("form").on("click",".sava",function(){
    		//获取id和电话号码
    		var id = 1;
    		var telephone=$("input[name='telephone']").val();
    		//通过Ajax将修改内容传输到后台
    	$.ajax({
    			url:"/billing/Proscenium/getupdateTelephonenumById",
    			data:{"id":id,"telephone":telephone},
    			type:"post",
    			dataType:"json",
    			/*回调*/
    			success:function(data){
    		   		$.messager.alert('提示',data.information);
    		   		$(".sava").remove();
    				$("input[name='telephone']").attr("disabled","disabled");
    			}
    		})
    	})
    	//加载用户信息
    	loadUserInfo();
    	function loadUserInfo(){
    		$.ajax({
    			url:"/billing/Proscenium/getUserInfo",
    			data:{"id":1},
    			type:"post",
    			dataType:"json",
    			/*回调*/
    			success:function(data){
    				console.log(data);
    				$("input[name='username']").val(data.userName);
    				if(data.gender==0){
    					$("input[name='gender']").val("男");
    				}else{
    					$("input[name='gender']").val("女");
    				}
    				$("input[name='userIdcard']").val(data.userIdcard);
    				$("input[name='userAccountingName']").val(data.userAccountingName);
    				$("input[name='userAccountingState']").val(data.userAccountingState);
    				$("input[name='userAddress']").val(data.userAddress);
    				$("input[name='userPostnum']").val(data.userPostnum);
    				$("input[name='userQqnum']").val(data.userQqnum);
    				$("input[name='telephone']").val(data.telephone);
    				//todo：循环input，添加disabled属性
    				$("form input").each(function(index,element){
    					$(element).attr("disabled","disabled");
    				})
    			}
    		})
    	}
    });
</script>
</html>