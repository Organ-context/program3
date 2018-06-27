<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../../js/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="../../js/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="../../demo/demo.css">
    <script type="text/javascript" src="../../js/jQuery-2.2.2-min.js"></script>
    <script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/locale/easyui-lang-zh_CN.js"></script>
    <style>
        #form1 {
            position: relative;
            margin-left: 180px;
            margin-top: 50px;
        }
    </style>
</head>
<script>

</script>
<body>
<div class="container">
    <div class="row" id="form1">
        <div class="col-md-6  col-lg-offset-1">
            <table id="tt" class="easyui-datagrid" style="width:714px;height:458px;"
                   toolbar="#tb"
                   title="用户管理" iconCls="icon-save"
                   rownumbers="true" pagination="true" singleSelect="true" pageList="[10]">
                <thead>
                <tr>
                    <th data-options="field:'itemid',width:100,align:'center'">姓名</th>
                    <th data-options="field:'productid',width:100,align:'center'">用户</th>
                    <th data-options="field:'listprice',width:80,align:'center'">性别</th>
                    <th data-options="field:'unitcost',width:150,align:'center'">联系方式</th>
                    <th data-options="field:'attr1',width:100,align:'center'">角色</th>
                    <th data-options="field:'status',width:150,align:'center'">邮箱</th>
                    <!--       <th data-options="field:'status',width:100,align:'center'">操作</th> -->
                </tr>
                </thead>
                <tbody id="t1">
                <tr>
                    <td>admin</td>
                    <td>admin</td>
                    <td>男</td>
                    <td>16546541234</td>
                    <td>用户管理员</td>
                    <td>123@qq.com</td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>admin</td>
                    <td>男</td>
                    <td>16546541234</td>
                    <td>用户管理员</td>
                    <td>123@qq.com</td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>admin</td>
                    <td>男</td>
                    <td>16546541234</td>
                    <td>用户管理员</td>
                    <td>123@qq.com</td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>admin</td>
                    <td>男</td>
                    <td>16546541234</td>
                    <td>用户管理员</td>
                    <td>123@qq.com</td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>admin</td>
                    <td>男</td>
                    <td>16546541234</td>
                    <td>用户管理员</td>
                    <td>123@qq.com</td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>admin</td>
                    <td>男</td>
                    <td>16546541234</td>
                    <td>用户管理员</td>
                    <td>123@qq.com</td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>admin</td>
                    <td>男</td>
                    <td>16546541234</td>
                    <td>用户管理员</td>
                    <td>123@qq.com</td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>admin</td>
                    <td>男</td>
                    <td>16546541234</td>
                    <td>用户管理员</td>
                    <td>123@qq.com</td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>admin</td>
                    <td>男</td>
                    <td>16546541234</td>
                    <td>用户管理员</td>
                    <td>123@qq.com</td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>admin</td>
                    <td>男</td>
                    <td>16546541234</td>
                    <td>用户管理员</td>
                    <td>123@qq.com</td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>admin</td>
                    <td>男</td>
                    <td>16546541234</td>
                    <td>用户管理员</td>
                    <td>123@qq.com</td>
                </tr>



                </tbody>
            </table>

            <!--搜索-->
            <div id="tb" style="padding:3px;">
                <span>真实姓名：</span>
                <input id="realname" style="line-height:26px;border:1px solid #ccc">
                <span>用户名：</span>
                <input id="productid" style="line-height:26px;border:1px solid #ccc">
                <span>角色：</span>
                <select id="cc" class="easyui-combobox" name="dept" style="width:150px;">
                    <option value="userMag">用户管理员</option>
                    <option value="tariffMag">资费管理员</option>
                    <option value="accoutingMag">账务查询管理员</option>
                    <option value="accoutingMonthMag">账单查询管理员</option>
                    <option value="osMag">报表管理员</option>
                    <option value="logMag">日志管理员</option>
                </select>
                <a href="#" class="easyui-linkbutton" iconCls="icon-search" style="border:6px">搜索</a>
            </div>

            <!--右下角按钮-->
            <div style="margin:20px 0;">
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('open')"
                   iconCls="icon-reload">修改</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#add').window('open')"
                   iconCls="icon-add">新增</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" href="javascript:void(0)"
                   onclick="$('#deleteUser').window('close');javascript:alert('删除成功')">删除</a>
            </div>


            <div id="o">
                <div id="w" class="easyui-window" title="修改" data-options="iconCls:'icon-save'"
                     style="width:330px;height:300px;padding:5px;" closed="true">
                    <div class="easyui-layout" data-options="fit:true">
                        <!--右侧树状图区域-->
                        <!--  <div data-options="region:'east',split:true" style="width:100px"></div> -->
                        <div data-options="region:'center'" style="padding:10px;display: none">
                            <div style="margin-left: 10px;width: 90px;display: inline-block"><label
                                    for="newPwd">请输入新密码：</label></div>
                            <input id="newPwd" name="newPwd" style="line-height:20px;border:1px solid #ccc">
                            </br>
                            </br>
                            <div style="margin-left: 10px;width: 90px;display: inline-block"><label
                                    for="oldPwd">请确认密码：</label></div>
                            <input id="oldPwd" name="newPwd" style="line-height:20px;border:1px solid #ccc">
                            </br>
                            </br>
                            <div style="margin-left: 10px;width: 90px;display: inline-block"><label
                                    for="oldPwd">联系方式：</label></div>
                            <input id="tel" name="tel" style="line-height:20px;border:1px solid #ccc">
                            </br>
                            </br>
                            <div style="margin-left: 10px;width: 90px;display: inline-block"><label
                                    for="email">邮箱：</label></div>
                            <input id="email" name="email" style="line-height:20px;border:1px solid #ccc">
                        </div>
                        <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                            <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)"
                               onclick="$('#w').window('close');javascript:alert('修改成功')">保存</a>
                            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
                               onclick="$('#w').window('close')">取消</a>
                        </div>
                    </div>
                </div>
            </div>


            <div id="add" class="easyui-window" title="新增" data-options="iconCls:'icon-save'"
                 style="width:330px;height:360px;padding:5px;" closed="true">
                <div class="easyui-layout" data-options="fit:true">
                    <!--右侧树状图区域-->
                    <!--  <div data-options="region:'east',split:true" style="width:100px"></div> -->
                    <div data-options="region:'center'" style="padding:10px;display: none">
                        <div style="margin-left: 10px;width: 90px;display: inline-block"><label
                                for="adminName">管理员名称：</label></div>
                        <input id="adminName" name="adminName" style="line-height:20px;border:1px solid #ccc">
                        </br>
                        </br>
                        <div style="margin-left: 10px;width: 90px;display: inline-block"><label
                                for="adminAcc">管理员账号：</label></div>
                        <input id="adminAcc" name="adminAcc" style="line-height:20px;border:1px solid #ccc">
                        </br>
                        </br>
                        <div style="margin-left: 10px;width: 90px;display: inline-block"><label
                                for="adminPwd">密码：</label></div>
                        <input id="adminPwd" name="adminPwd" style="line-height:20px;border:1px solid #ccc">
                        </br>
                        </br>
                        <div style="margin-left: 10px;width: 90px;display: inline-block"><label
                                for="adminPwdSure">确认密码：</label></div>
                        <input id="adminPwdSure" name="adminPwdSure" style="line-height:20px;border:1px solid #ccc">
                        </br>
                        </br>

                        <div style="margin-left: 10px;width: 90px;display: inline-block"><label
                                for="adminTel">联系方式：</label></div>
                        <input id="adminTel" name="adminTel" style="line-height:20px;border:1px solid #ccc">
                        </br>
                        </br>
                        <div style="margin-left: 10px;width: 90px;display: inline-block"><label
                                for="adminEmail">邮箱：</label></div>
                        <input id="adminEmail" name="adminEmail" style="line-height:20px;border:1px solid #ccc">
                    </div>
                    <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                        <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)"
                           onclick="$('#add').window('close');javascript:alert('修改成功')">保存</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
                           onclick="$('#add').window('close')">取消</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>