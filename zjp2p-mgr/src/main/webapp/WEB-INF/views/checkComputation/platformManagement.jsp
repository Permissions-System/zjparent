<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
    <!-- 对话框的样式 -->
    <link href="${path}/css/userList.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>支付平台管理</title>

    <script type="text/javascript">
        var isUpdate = false;
        var updateId = "";

        $(function () {
            $("#datagrid").datagrid({
                onDblClickRow: function (rowIndex, rowData) {
                    isUpdate = true;
                    //双击开启编辑行
                    updateId = rowData.id;
                    var remark = rowData.remark;
                    var payMentInterest = rowData.paymentinterest;
                    var computingmethod = rowData.computingmethod;
                    var computingmethodname = rowData.computingmethodname;
                    var interesttype = rowData.interesttype;
                    var interesttypename = rowData.interesttypename;
                    var platformid = rowData.platform;
                    var platformname = rowData.platformname;
                    $('#showDialog').dialog({
                        title: '支付平台数据新增',
                        width: 600,
                        height: 220
                    });

                    $("#showDialog #platFormName").combobox('setValue', platformid).combobox('setText', platformname);
                    $("#showDialog #interestType").combobox('setValue', interesttype).combobox('setText', interesttypename);
                    $("#showDialog #computingMethod").combobox('setValue', computingmethod).combobox('setText', computingmethodname);
                    $('#showDialog #payMentInterest').textbox('setValue', payMentInterest);
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
                        platform: $("#platFormName").combobox('getValue'),
                        interesttype: $("#interestType").combobox('getValue')
                    });

                }
            });
        }


        function addPlatForm() {
            $('#showDialog').dialog({
                title: '支付平台数据新增',
                width: 600,
                height: 220
            });
            $("#showDialog #platFormName").combobox('setValue', '').combobox('setText', '');
            $("#showDialog #interestType").combobox('setValue', '').combobox('setText', '');
            $("#showDialog #computingMethod").combobox('setValue', '').combobox('setText', '');
            $('#showDialog #payMentInterest').textbox('setValue', '');
            $('#showDialog #remark').val('');
        }


        function savePlatForm() {


            $('#dialogForm').form('submit', {
                onSubmit: function () {
                    return $(this).form('enableValidation').form('validate');
                },
                success: function (res) {


                    var url = "${path}/platForm/saveOrUpdate";

                    var plateForm = $("#showDialog #platFormName").combobox('getValue');
                    var interestType = $("#showDialog #interestType").combobox('getValue');
                    var computingMethod = $("#showDialog #computingMethod").combobox('getValue');
                    var payMentInterest = $('#showDialog #payMentInterest').val();
                    var remark = $('#showDialog #remark').val();

                    var obj = {};
                    if (updateId != "") {
                        obj.id = updateId;
                    }
                    obj.platForm = plateForm;
                    obj.interestType = interestType;
                    obj.computingMethod = computingMethod;
                    obj.payMentInterest = payMentInterest;
                    obj.remark = remark;
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

    <table id="datagrid" title="平台管理页面" fit="true"
           url="${path}/platForm/getPlatFormData" toolbar="#tb"
           fitColumns="true" singleSelect="true" rownumbers="true"
           border="false" nowrap="false">
        <thead>
        <tr>
            <th data-options="field:'platform',width:50,hidden:true">支付平台key</th>
            <th data-options="field:'platformname',width:100">支付平台</th>
            <th data-options="field:'interesttype',width:50,hidden:true">支付类型key</th>
            <th data-options="field:'interesttypename',width:50">支付类型</th>
            <th data-options="field:'computingmethod',width:50,hidden:true">计算方式key</th>
            <th data-options="field:'computingmethodname',width:50">计算方式</th>
            <th data-options="field:'paymentinterest',width:50,align:'right'">费率</th>
            <th data-options="field:'remark',width:200">备注</th>
        </tr>
        </thead>
    </table>

    <div id="tb" style="padding:5px;height:65px">
        <form id="searchdata" class="easyui-form" style="height:35px;margin-top: 5px" data-options="novalidate:true">
            <div style="width:100%;">
                <fieldset style="border: #dddddd solid 1px;border-radius: 5px;">
                    <legend>支付平台管理</legend>
                    <table>
                        <tr>
                            <td>支付平台：<input id="platFormName" name="platFormName" class="easyui-combobox"  editable="false"
                                            data-options="valueField:'key',textField:'value',url:'${path}/platformType/getPlatformData'">
                            </td>
                            <td>交易类型：<input id="interestType" name="interestType" class="easyui-combobox"  editable="false"
                                            data-options="valueField:'key',textField:'value',url:'${path}/platformType/getPlatformTrade'">
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
         data-options="title:'支付平台新增',modal:true,
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
                    <td style="text-align: right;">支付平台：</td>
                    <td><input id="platFormName" name="platFormName" class="easyui-combobox"
                               data-options="required:true,valueField:'key',textField:'value',url:'${path}/platformType/getPlatformData'">
                    </td>

                    <td style="text-align: right;">交易类型：</td>
                    <td><input id="interestType" name="interestType" class="easyui-combobox"
                               data-options="required:true,valueField:'key',textField:'value',url:'${path}/platformType/getPlatformTrade'">
                    </td>
                </tr>

                <tr>
                    <td style="text-align: right;">计算方式：</td>
                    <td><input id="computingMethod" name="computingMethod" class="easyui-combobox"
                               data-options="required:true,valueField:'key',textField:'value',url:'${path}/ComputingMethod/getComputingMethod'">
                    </td>

                    <td style="text-align: right;">利率：</td>
                    <td><input id="payMentInterest" name="payMentInterest" data-options="required:true"
                               style="width:172px;" class="easyui-numberbox" precision="2" size="8" maxlength="8"></td>
                </tr>

                <tr>
                    <td style="text-align: right;">备注：</td>
                    <td colspan="3"><textarea id="remark" rows=5 name="remark" style="resize:none;width:92%"
                                              data-options="required:true"
                                              class="textarea easyui-validatebox"></textarea></td>
                </tr>

            </table>
        </form>
    </div>


</div>

</body>
</html>