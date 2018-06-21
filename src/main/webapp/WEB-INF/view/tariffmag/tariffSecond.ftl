<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic DataGrid - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="demo/demo.css">
    <!--  <link href="../css/bootstrap.min.css" rel="stylesheet"/>
      <link href="../css/bootstrap-theme.min.css" rel="stylesheet"/> -->
    <script type="text/javascript" src="js/jQuery-2.2.2-min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>
    <style>
        #form1{
            position: relative;
            margin-left: 180px;
            margin-top: 50px;
        }
    </style>
</head>
<script>

    $(function(){
        $("#o").css('display','none');
    });
    $("add").load(function(){
        $("div").text("Image loaded");
    });
</script>
<body>
<div class="container">
    <div class="row" id="form1">

        <div class="col-md-6  col-lg-offset-1">
            <table id="tt" class="easyui-datagrid" style="width:90%;height:480px;"
                   url="datagrid24_getdata.php" toolbar="#tb"
                   title="资费类型" iconCls="icon-save"
                   rownumbers="true" pagination="true">
                <thead>
                <tr>
                    <th data-options="field:'itemid',width:346,align:'center'">资费名</th>
                    <th data-options="field:'productid',width:350,align:'center'">类型</th>
                    <th data-options="field:'listprice',width:400,align:'center'">计价方式</th>
                    <th data-options="field:'status',width:400,align:'center'">操作</th>
                    <!--       <th data-options="field:'status',width:100,align:'center'">操作</th> -->
                </tr>

                </thead>
                <tbody>
                <tr>
                    <td>admin</td>
                    <td>按月</td>
                    <td>100/小时</td>
                    <td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="('#add').window('open')">修改</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="" iconCls="icon-cancel">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>按月</td>
                    <td>100/小时</td>
                    <td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="('#add').window('open')">修改</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="" iconCls="icon-cancel">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>按月</td>
                    <td>100/小时</td>
                    <td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="('#add').window('open')">修改</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="" iconCls="icon-cancel">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>按月</td>
                    <td>100/小时</td>
                    <td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="('#add').window('open')">修改</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="" iconCls="icon-cancel">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>按月</td>
                    <td>100/小时</td>
                    <td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="('#add').window('open')">修改</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="" iconCls="icon-cancel">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>按月</td>
                    <td>100/小时</td>
                    <td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="('#add').window('open')">修改</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="" iconCls="icon-cancel">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>按月</td>
                    <td>100/小时</td>
                    <td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="('#add').window('open')">修改</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="" iconCls="icon-cancel">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>按月</td>
                    <td>100/小时</td>
                    <td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="('#add').window('open')">修改</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="" iconCls="icon-cancel">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>按月</td>
                    <td>100/小时</td>
                    <td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="('#add').window('open')">修改</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="" iconCls="icon-cancel">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>admin</td>
                    <td>按月</td>
                    <td>100/小时</td>
                    <td><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="('#add').window('open')">修改</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="" iconCls="icon-cancel">删除</a>
                    </td>
                </tr>

                </tbody>
            </table>


            <div id="tb" style="padding:3px;">
                <span>资费名：</span>
                <input id="realname" style="line-height:26px;border:1px solid #ccc">

                <a href="#" style="margin-left: 100px" class="easyui-linkbutton" iconCls="icon-search" style="border:6px">搜索</a>

            </div>

            <div style="width: 90%;height: 60px;margin-top: 40px; background-color: #269abc">
                <h2 style="margin-left: 10px;padding-top: 15px">添加新资费</h2>
            </div>
            <div style="margin-top: 50px">
                <form action="">
                        <span>资费名：</span><input type="text" style="width: 200px;height: 20px;" name="" id="1"/>
                        <span style="margin-left: 100px">资费类型：</span><input type="text"style="width: 200px;height: 20px;" name="" id="2"/>
                        <span style="margin-left: 100px">计价方式：</span><input type="text" style="width: 200px;height: 20px;"name="" id="3"/>
                        <a href="#" style="margin-left: 400px" class="easyui-linkbutton" iconCls="icon-ok" style="border:6px">添加</a>
                </form>
            </div>


            <div id="add" class="easyui-window" title="修改资费" data-options="iconCls:'icon-save'" style="width:330px;height:360px;padding:5px;">
                <div class="easyui-layout" data-options="fit:true">
                    <!--右侧树状图区域-->
                    <!--  <div data-options="region:'east',split:true" style="width:100px"></div> -->
                    <div data-options="region:'center'" style="padding:10px;display: none">
                        <div style="text-align: center;margin-top: 20px">
                            <span >资费名:</span><input type="text" style="width: 200px;height: 20px;" name="" id=""/>
                        </div>
                        <div style="margin-top: 50px">
                            <span >资费类型：</span><input type="text"style="width: 200px;height: 20px;" name="" id=""/>
                        </div>
                        <div style="margin-top: 50px">
                            <span>计价方式：</span><input type="text" style="width: 200px;height: 20px;"name="" id=""/>
                        </div>
                    </div>
                    <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                        <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)"
                           onclick="$('#add').window('close');javascript:alert('修改成功')">修改</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton"  data-options="iconCls:'icon-cancel'" onclick="$('#add').window('close')">取消</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    $("#cc").combobox({
        panelHeight:false
    });
</script>

</html>