<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<html>
<head>
    <%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
    <!-- 对话框的样式 -->
    <link href="${path}/css/userList.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>支付平台配置管理</title>
 


    <script type="text/javascript">
        var isUpdate = false;
        var updateId = "";

        $(function () {

            $("#datagrid").datagrid({
                onDblClickRow: function (rowIndex, rowData) {
                    isUpdate = true;
                    //双击开启编辑行
                    updateId = rowData.id;
                    $('#showDialog').dialog({
                        title: '平台配置编辑',
                        width: 600,
                        height: 200
                    });

                    var remark = rowData.remark;
                    var platformid = rowData.plateformid;
                    var plateformname = rowData.plateformname;
                    var checkInid = rowData.checkin;
                    var checkinname = rowData.checkinname;

                    $("#showDialog #platFormName").combobox('setValue', platformid).combobox('setText', plateformname);
                    $("#showDialog #checkInName").combobox('setValue', checkInid).combobox('setText', checkinname);
                    $('#showDialog #remark').val(remark);
                }
            });
        })


        $(document).ready(function () {

            $('#showDialog').dialog("close");

        });

        function submitForm() {


            $('#searchdata').form('submit', {
                onSubmit: function () {
                    return $(this).form('enableValidation').form('validate');
                },
                success: function (res) {

                    $('#datagrid').datagrid('reload', {
                        isCheck: "true",
                        plateformid: $("#platFormName").combobox('getValue'),
                        checkin: $("#checkInName").combobox('getValue')
                    });
                }
            });
        }


        function addPlatForm() {

            $('#showDialog').dialog({
                title: '平台配置新增',
                width: 600,
                height: 200
            });

            $("#showDialog #platFormName").combobox('setValue', '').combobox('setText', '');
            $("#showDialog #checkInName").combobox('setValue', '').combobox('setText', '');
            $('#showDialog #remark').val('');
        }


        function savePlatForm() {


            $('#dialogForm').form('submit', {
                onSubmit: function () {
                    return $(this).form('enableValidation').form('validate');
                },
                success: function (res) {


                    var url = "${path}/platFormType/saveOrUpdateType";


                    var plateFormName = $("#showDialog #platformname").combobox('getValue');
                    var checkInName = $("#showDialog #checkinname").combobox('getValue');

                    var remark = $('#showDialog #remark').val();

                    var obj = {};
                    if (updateId != "") {
                        obj.id = updateId;
                    }
                    obj.remark = remark;
                    obj.plateForm = plateFormName;
                    obj.checkIn = checkInName;

                    if (isUpdate) {
                        obj.isUpdate = true;
                    } else {
                        obj.isUpdate = false;
                    }

                    url += "?objJson=" + JSON.stringify(obj);


                    $.ajax({
                        url: url,
                        type: "get",
                        success: function (data) {
                            data = eval('(' + data + ')');

                            closeLoading();
                            if (data.isHave) {
                                $.messager.alert('平台数据', data.responseText);
                            } else {

                                $('#showDialog').dialog('close');
                                var showContent = "";
                                if (isUpdate) {
                                    showContent = "修改成功";
                                } else {
                                    showContent = "添加成功";
                                }
                                isUpdate = false;
                                $.messager.alert('平台数据', showContent);
                            }

                        },
                        error: function (m) {
                            closeLoading();
                            $.messager.alert('warning', m.responseText);
                        }
                    });

                }
            });

        }

    </script>
</head>
<body class="easyui-layout">
<div region="center" border="false" style="overflow: hidden;">


    <table id="datagrid" title="平台配置管理" fit="true"
           url="${path}/platFormType/getPlatFormTypeData" toolbar="#tb"
           fitColumns="true" singleSelect="true" rownumbers="true"
           border="false" nowrap="false">
        <thead>
        <tr>
            <th data-options="field:'plateformid',width:50,hidden:true">支付平台key</th>
            <th data-options="field:'plateformname',width:100">支付平台</th>
            <th data-options="field:'checkinid',width:50,hidden:true">使用系统key</th>
            <th data-options="field:'checkinname',width:50">使用系统</th>
            <th data-options="field:'remark',width:200">备注</th>
        </tr>
        </thead>
    </table>

    <div id="tb" style="padding:5px;height:65px">
        <form id="searchdata" class="easyui-form" style="height:35px;margin-top: 5px" method="post"
              data-options="novalidate:true">
            <div style="width:100%;">
                <fieldset style="border: #dddddd solid 1px;border-radius: 5px;">
                    <legend>支付平台管理</legend>
                    <table>
                        <tr>
                            <td style="font-size: 12px;">支付平台：<input id="platFormName" name="platFormName" class="easyui-combobox"  editable="false"
                                            data-options="valueField:'key',textField:'value',url:'${path}/platformType/getPlatformData'">
                            </td>
                            <td style="font-size: 12px;">使用系统：<input id="checkInName" name="checkInName" class="easyui-combobox"  editable="false"
                                            data-options="valueField:'key',textField:'value',url:'${path}/platformType/getUserPlatform'">
                            </td>
                            <td>&nbsp;<a href="javascript:void(0)" id="search" class="easyui-linkbutton"
                                         iconCls="icon-search" onclick="submitForm()">查询</a></td>
                            <td>&nbsp;<a href="javascript:void(0)" id="addPlatForm" class="easyui-linkbutton"
                                         iconCls="icon-add" onclick="addPlatForm()">新增</a></td>
                        </tr>
                    </table>
                </fieldset>

            </div>
        </form>
    </div>

    <div id="showDialog" class="easyui-dialog" style="width:600px;height:300px"
         data-options="title:'支付配置新增',modal:true,
			buttons:[{
				text:'保存',
				handler:function(e){
				savePlatForm();
				}
			},{
				text:'关闭',
				handler:function(){
				$('#showDialog').dialog('close');
				}
			}]">
        <form id="dialogForm" class="easyui-form" style="height:35px;margin-top: 5px" method="post"
              data-options="novalidate:true">
            <table style="width:98%">
                <tr>
                    <td style="text-align:right;font-size: 12px;">支付平台：</td>
                    <td><input id="platformname" name="platFormName" class="easyui-combobox"
                               data-options="required:true,valueField:'key',textField:'value',url:'${path}/platformType/getPlatformData'">
                    </td>
                    <td style="text-align: right;font-size: 12px;">使用系统：</td>
                    <td><input id="checkinname" name="checkInName" class="easyui-combobox"
                               data-options="required:true,valueField:'key',textField:'value',url:'${path}/platformType/getUserPlatform'">
                    </td>
                </tr>

                <tr>
                    <td style="text-align: right;font-size: 12px;">备注：</td>
                    <td colspan="3"><textarea id="remark" rows=5 name="remark" style="resize:none;width:93%"
                                              class="textarea easyui-validatebox"
                                              data-options="required:true"></textarea></td>
                </tr>
            </table>
        </form>
    </div>


</div>

</body>
</html>