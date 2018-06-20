<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登陆</title>
    <link href="js/themes/icon.css" rel="stylesheet" type="text/css" />
    <link href="js/themes/default/easyui1.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>

    <script type="text/javascript" src="js/jquery.easyui.min-1.2.0.js"></script>

    <script src="js/Cookie.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(function() {
            $("#loginWindow").window({
                title: '登陆',
                width: 290,
                height: 180,
                modal: true,
                shadow: false,
                closable: false,
                maximizable: false,
                minimizable: false,
                collapsible: false,
                resizable: false
            });
            //登录
            $("#btnLogin").click(function() {
                var username = document.getElementById("username").value;
                var password = document.getElementById("password").value;

                loginSys(username, password);
            });

//            $("#aboutSys").click(function() {
//                $.messager.alert('about', 'fuma soft CRM!', 'info');
//            });
        });

        //登陆操作方法
        function loginSys(username, password) {
            window.location = "index.html";
            $.ajax({
                type: "POST",
                dataType: "json",
                //cache:true,
                url: "Service/EasyUiService.ashx?Method=Login",
                data: { username: username, password: password },
                success: function(json) {
                    if (json.Flag[0].Status == 1) {
                        window.location.href = "Index.aspx";
                    }
                    else {
                        $.messager.alert('错误', '账号或密码错误!', 'error');
                    }
                },
                error: function() {
                    $.messager.alert('错误', '获取账号信息失败...请联系管理员!', 'error');
                }
            });
        }
    </script>

</head>
<body>
<div id="loginWindow" class="easyui-window" title="登陆" iconcls="icon-login"
     style="width: 300px; height: 180px; padding: 5px; background: #fafafa;">
    <div border="false" style="padding-left: 30px; background: #fff; border: 1px solid #ccc;">
        <form>
            <table>
                <tr>
                    <td>
                        账号：
                    </td>
                    <td>
                        <input id="username" class="easyui-validatebox" required="true" validtype="length[1,10]"
                               style="width: 150px;" />
                    </td>
                </tr>
                <tr>
                    <td>
                        密码：
                    </td>
                    <td>
                        <input type="password" id="password" style="width: 150px;" class="easyui-validatebox"
                               required="true" validtype="length[3,10]" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!--        <div border="false" style="text-align: center; height: 30px; line-height: 30px; margin-top: 6px;">
        <a class="easyui-linkbutton" iconcls="icon-thereof" href="javascript:void(0)" id="aboutSys">
            关于</a> <a class="easyui-linkbutton" iconcls="icon-ok" href="javascript:void(0)" id="btnLogin">
                登陆</a>
    </div>-->
    <div class="toolbar" style="text-align: center; margin-top: 20px;">
        <a href="#" class="easyui-linkbutton" iconcls="icon-no" id="aboutSys" style="margin-right: 10px;">
            取消</a> <a href="#" class="easyui-linkbutton" iconcls="icon-ok" id="btnLogin" style="margin-left: 10px;">
        登陆</a>
    </div>
</div>
</body>
</html>