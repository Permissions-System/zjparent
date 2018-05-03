<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
.itemMagin {
	height: 30px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
	<div class="easyui-layout" data-options="fit:true,selected:true">
		<div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height: 130px; padding: 20px 0px 10px 30px">
			<form id="queryForm" method="post" novalidate>
				<table class="datagrid-toolbar" style="width: 100%; height: 70%; border: 0px; font-size: 12px">
					<tr class="itemMagin">
						<td><label for="qryProductType">归属产品(精确匹配)：</label></td>
						<td><select id="qryProductType" name="productCode" class="easyui-combobox" panelHeight="auto" style="width: 150px;" data-options="editable:false,required:false">
								<option value="">全部</option>
								<c:forEach items="${productCode}" var="item">
									<option value="${item.configCode}">${item.configName}</option>
								</c:forEach>
						</select></td>
						<td><label for="qryErrorCode">错误码(模糊匹配)：</label></td>
						<td><input id="qryErrorCode" name="QryErrCode" type="text" class="easyui-validatebox" style="width: 150px;" maxlength=8 title="录入错误码" data-options="required:false"></td>
						<td><label for="qryErrorUserDesc">用户提示(模糊匹配)：</label></td>
						<td><input id="qryErrorUserDesc" name="QryErrUserDesc" type="text" class="easyui-validatebox" style="width: 150px;" maxlength=50 title="录入匹配文字" data-options="required:false"></td>
					</tr>
					<tr class="itemMagin">
						<td><label for="qryErrorSysDesc">内部描述(模糊匹配)：</label></td>
						<td><input id="qryErrorSysDesc" name="QryErrSysDesc" type="text" class="easyui-validatebox" style="width: 150px;" maxlength=50 title="录入匹配文字" data-options="required:false"></td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href="#" class="easyui-linkbutton" iconCls="icon-search" id="btnQuery">查询</a> <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:true,title:'错误码列表'">
			<table id="ErrorInfoList" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
			</table>
		</div>
	</div>
	<div id="ErrorInfoDlg" class="easyui-dialog" style="width: 400px; height: 260px; padding: 10px 0px 10px 30px" data-options="resizable:false,modal:true" closed="true" buttons="#errorinfo-dlg-buttons">
		<form id="ErrorInfoForm" method="post">
			<table style="width: 100%; magrin-top: 1px; magrin-left: 5px; magrin-right: 5px; magrin-bottom: 1px; padding: 0px 0px 0px 0px; font-size: 12px">
				<tbody>
					<tr class="itemMagin">
						<td><label for="idProductType">归属产品：</label></td>
						<td><select id="idProductType" name="productCode" panelHeight="auto" class="easyui-combobox" style="width: 200px;" data-options="editable:false,required:false,onSelect:function() {setErrorCode();}">
								<c:forEach items="${productCode}" var="item">
									<option value="${item.configCode}">${item.configName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr class="itemMagin">
						<td><label for="idErrorCode">错误码：</label></td>
						<td><label id="idPreError"></label> <input id="idErrorCode" name="errorCode" type="text" title="6位字母数字串" class="easyui-validatebox" style="width: 180px;" maxlength=6 data-options="required:true" /></td>
					</tr>
					<tr class="itemMagin">
						<td><label for="idErrorName">错误别名：</label></td>
						<td><input id="idErrorName" name="errorName" type="text" class="easyui-validatebox" style="width: 200px;" data-options="required:false" /></td>
					</tr>
					<tr class="itemMagin">
						<td><label for="idErrorUserDesc">用户提示：</label></td>
						<td><input id="idErrorUserDesc" name="errorUserDesc" type="text" class="easyui-validatebox" title="最大50位汉字英文字符串" style="width: 200px;" data-options="required:true" maxlength=50 /></td>
					</tr>
					<tr class="itemMagin">
						<td><label for="idErrorSysDesc">错误内部描述:</label></td>
						<td><input id="idErrorSysDesc" name="errorSysDesc" title="最大50位汉字英文字符串" type="text" class="easyui-validatebox" style="width: 200px;" data-options="required:true" maxlength=50 /></td>
					</tr>
				</tbody>
			</table>
		</form>
		<div align="right" id="errorinfo-dlg-buttons">
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="btnSave">保存</a> <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#ErrorInfoDlg').dialog('close');isOpenFlag=0;">关闭</a>
		</div>
	</div>
	<div id="containerDlg" class="easyui-dialog" style="width: 800px; height: 500px; padding: 0px 0px 0px 0px" data-options="resizable:false,modal:true" closed="true"></div>
	<div id="errorCodeWindow" class="easyui-window" title="错误码曲线统计" data-options="maximized:true,modal:true,closed:true">
		<div class="easyui-layout" data-options="fit:true,selected:true">
			<div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height: 90px; padding: 10px 0px 10px 30px">
				<form id="queryCodeForm" method="post" novalidate>
					<table class="datagrid-toolbar" style="width: 100%; height: 70%; border: 0px; font-size: 12px">
						<tr class="itemMagin">
							<td><label for="queryErrorCode">错误码:</label></td>
							<td><input id="queryErrorCode" style="width: 100px;" name="errorCode"  class="easyui-validatebox"></td>
							<td><a id="btnSelectErrorCode" href="#" class="easyui-linkbutton">选择</a></td>
							<td><label for="queryStartDate">查询日期（起）:</label></td>
							<td><input id="queryStartDate" name="startDate" class="easyui-datebox" style="width: 100px;" data-option="editable:false,showSeconds:false"></td>
							<td><label for="queryEndDate">查询日期（止）:</label></td>
							<td><input id="queryEndDate" name="endDate" class="easyui-datebox" style="width: 100px;" data-option="editable:false,showSeconds:false"></td>
							<td><a id="showCodeLine" href="#" class="easyui-linkbutton" iconCls="icon-search">曲线图生成</a></td>
						</tr>
					</table>
				</form>
			</div>
			<div data-options="region:'center',border:true,title:'曲线图'" style="padding: 10px 0px 10px 10px">
				<div id="showcontainer" style="width: 95%; height: 400px;"></div>
			</div>
		</div>
	</div>
	<!-- 查询错误码结果作为 生成错误图表的查询条件 -->
	<div id="errorCodeInfoDlg" class="easyui-dialog" style="width: 740px; height: 500px; padding: 0px 0px 0px 0px" data-options="resizable:false,modal:true" closed="true" buttons="#edit-errorInfo-dlg-buttons">
		<div class="easyui-layout" data-options="fit:true,selected:true">
			<div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height: 80px; padding: 10px 0px 10px 30px">
				<form id="queryErrorCodeForm" method="post" novalidate>
					<table style="width: 100%; magrin-top: 1px; magrin-left: 5px; magrin-right: 5px; magrin-bottom: 1px; padding: 10px 0px 10px 30px">
						<tbody>
							<tr class="fitem">
								<td><label for="erProductCode">归属产品:</label></td>
								<td><select id="erProductCode" name="productCode" panelHeight="auto" class="easyui-combobox" style="width: 120px;" data-option="editable:false">
										<option value="">全部</option>
										<c:forEach items="${productCode}" var="item">
											<option value="${item.configCode}">${item.configName}</option>
										</c:forEach>
								</select></td>
								<td><label for="erErrorCode">错误码:</label></td>
								<td><input id="erErrorCode" style="width: 140px;" name="errorCode" class="easyui-validatebox"></td>
								<td><label for="erUserDesc">错误用户描述:</label></td>
								<td><input id="erUserDesc" style="width: 140px;" name="errorUserDesc" class="easyui-validatebox"></td>
								<td><a id="selectErrorCode" href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div data-options="region:'center',border:true,title:'列表'">
				<table id="queryErrorList" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
				</table>
			</div>
		</div>
	</div>
	<div id="edit-errorInfo-dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="addErrorCode">添加</a> <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" id="addCancel">取消</a>
	</div>
	<!-- 引用Ueditor下的第三方js 版本  -->
	<script src="${ctx}/static/js/pub/ueditor/third-party/highcharts/highcharts.src.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/pub/ueditor/third-party/highcharts/highcharts-more.src.js" type="text/javascript"></script>
	<script type="text/javascript">
		var isOpenFlag = 0; //ErrorInfoDlg是否打开标志
		
		$.extend($.fn.validatebox.defaults.rules, {
			queryErrorCode: {
		        validator: function(value, param){
		            var p = new RegExp('[^a-zA-Z0-9]');
		            return !p.test(value);
		        },
		        message: '错误码应由字符,数字构成'
		    },
		    errorNameValid: {        
                validator: function(value, param){
                    var p = new RegExp('[^a-zA-Z0-9_]');
                    return !p.test(value);
                },
                message: '输入内容应由数字、字母、下划线组成'
            }
		});
		
		//初始化方法
		$(document).ready(function() {
			// 页面初始化
			// 查询按钮绑定事件
			$("#btnQuery").bind("click", function() {
				queryInfo();
			});
			// 取消按钮绑定事件
			$("#btnCancel").bind("click", function() {
				queryCancel();
			});

			initQueryErrorListGrid();
			// 错误码搜索DLG内的查询按钮绑定事件
			$("#btnSelectErrorCode").bind("click", function() {
				openErrorList();
			});

			$("#addErrorCode").bind("click", function() {
				addErrorLogInfo();
				//saveErrorLogInfo();
			});

			// 新增错误取消按钮绑定事件 
			$("#addCancel").bind("click", function() {
				$('#errorCodeInfoDlg').dialog('close');
			});
			// 弹出框 保存按钮处理事件
			$("#btnSave").bind("click", function() {
				saveErrorInfo();
			});
			
			// 单击生成图标按钮事件
			$("#showCodeLine").bind("click", function() {
				createChartInfo();
			});

			iniErrorInfoGrid(); // 初始化页面Grid       
			disEditableComboBox(); //初始化下拉
			// 只读
			//$('#queryCodeForm').find('[name=errorCode]').attr('readonly', 'readonly');

			disEditableDataBox();
			
		    $("#selectErrorCode").bind("click", function(){
		        queryErrorCodeInfo();
		    });
		    
		    //initErrorCodeChart();
		    
		    $("#queryErrorCode").validatebox({
		        //required: true,
		        validType: 'queryErrorCode[]'
		    });
		    
		    requiredBox();
		    
		    $('#idErrorName').validatebox({    
		        validType:['errorNameValid','length[0,60]']
		    });
		});

		/*必输项*/
		function requiredBox(){
			// 错误码后六位
		    $('#idErrorCode').validatebox({    
		        required: true
		    });
			// 用户错误提示
            $('#idErrorUserDesc').validatebox({    
                required: true
            });
            $('#idErrorSysDesc').validatebox({    
                required: true
            });
		}
		
		
		//创建Charts
		function createChartInfo() {
			// 获取错误码 检验 错误是否存在等,查询开始日期，结束日期等的大小判定等处理
			if(ckQueryPosChart()){
				var errorCode = $('#queryErrorCode').val();
				// 判断该校验码是否配置错误表中
				var tmp = null;
			    jQuery.ajax({
			        type : "POST",
			        async: false,
			        url : "${ctx}/base/errorinfo/getCountCodeInfo",
			        data : {
			            errorCode:errorCode
			        },
			        success : function(data) {
			          if(data.message=='Y'){
			        	  tmp = "Y";
			           }else{
			        	   tmp = "N";
			           }
			        },
			        error : function(data) {
			            showSlideMessage("加载错误内容数据过程发生异常，请确认！");
			        },
			        datatype : "json"
			    });
				
			    // 数据存在
			    if(tmp=="Y"){
			    	// 错误码正确的情况下传入日期数据 // errorCode queryStartDate,queryEndDate
			    	var startDate = $('#queryStartDate').datebox('getValue');
			    	var endDate = $('#queryEndDate').datebox('getValue');
	                jQuery.ajax({
	                    type : "POST",
	                    async: false,
	                    url : "${ctx}/base/errorinfo/getChartInfo",
	                    data : {
	                        errorCode:errorCode,
	                        startDate:startDate,
	                        endDate:endDate
	                    },
	                    success : function(data) {
	                     
	                    	if(data.message=="show"){
	                    		initErrorCodeChart(data);
	                    	}else{
	                    		cleanCodeChart();
	                    		showSlideMessage("未查询到数据,请确认！");
	                    	}
	                    },
	                    error : function(data) {
	                    	showSlideMessage("查询错误码统计图表数据异常,请确认！");
	                    	cleanCodeChart();
	                    },
	                    datatype : "json"
	                });
			    	
			    }else{
			    	 showSlideMessage("错误码不存在,请确认！");
			    	 cleanCodeChart();
			    }
			    
			}
		}

		// 清空已经生成的图标
		function cleanCodeChart(){
			var chart = $('#showcontainer').highcharts();
			if(chart){
				if(chart.get("id-chart-xaxis")){ //修复Cannot call method 'remove' of null
	            	chart.get("id-chart-xaxis").remove();
				}
				if(chart.get("id-chart-series")){ //修复Cannot call method 'remove' of null
					chart.get("id-chart-series").remove();
				}
			}
		}
		
		// 校验图标的数据
		function ckQueryPosChart(){
			var val = $('#queryErrorCode').val();
			if(isNull(val)){
				showSlideMessage("请选择或输入错误码！");
				cleanCodeChart();
				return false;
			}
			
			// 如果是输入数据 则补充校验输入数据的校验
		    var p = new RegExp('[^a-zA-Z0-9]');
		    if(p.test(val)){
		        showSlideMessage("错误码应由字符,数字构成！");
		        cleanCodeChart();
		        return false;
		    }
			
			return true;
		}
		
		/**
		 *初始化错误码监控数据曲线图
		 */
		function initErrorCodeChart(data){
			var categories = data.categories;
			var datas = data.series;
			$('#showcontainer').highcharts({
                chart : {
                    type : 'line'
                },
                title : {
                    text : '错误码监控曲线图'
                },
                subtitle : {
                    text : ''
                },
                xAxis : {
                	id:'id-chart-xaxis',
                    categories : categories,
                    title : {
                        align : 'high',
                        text : '时间'
                    }
                },
                yAxis : {
                    title : {
                        text : '错误次数'
                    },
                    linewidth:2,
                    id:'chart-error-count-yaxis'
                },
                tooltip : {
                    enabled : true,
                    formatter : function() {
                        return '<b>' + this.series.name + '</b><br/>'
                                + this.x + ': ' + this.y + '';
                    }
                },
                plotOptions : {
                    line : {
                        dataLabels : {
                            enabled : true
                        },
                        enableMouseTracking : false
                    }
                }
            });
			
			// 获取图标js对象
			var chart = $('#showcontainer').highcharts();
			chart.addSeries({
				id:'id-chart-series',
				name:data.errorCode,
				data:datas
			});
		}
		
		/**
		 * 键入弹出 错误码选择页面
		 */
		function openErrorList() {
			$('#errorCodeInfoDlg').dialog('open').dialog('setTitle', '错误码列表');
			queryErrorCodeInfo();
		}

		function openErrorCodeLine() {
			$('#errorCodeWindow').window('open');
		}

		function queryErrorCodeInfo() {
			$('#queryErrorList').datagrid('load', {
				prdType : $('#erProductCode').combobox('getValue'),
				errorCode : $('#erErrorCode').val(),
				errorUserDesc : $('#erUserDesc').val()
			});
		}

		/**
		 * js初始化弹出框页面DataGrid
		 */
		function initQueryErrorListGrid() {
			$("#queryErrorList").datagrid({
				pagination : true,
				rownumbers : true,
				pageSize : 10,
				pageNumber : 1,
				pageList : [ 10 ],
				nowrap : false,
				autoRowHeight : false,
				striped : true,
				border : false,
				fitColumns : true,
				method : 'post',
				singleSelect : true,
				fit : true,
				url : '${ctx}/base/errorinfo/getErrorCodeInfoList',
				onDblClickRow : function(rowIndex, rowData) {
					addErrorLogInfo();
				},
				columns : [ [ {
					title : '归属产品',
					field : 'productName',
					width : 50
				}, {
					title : '错误码',
					field : 'errorCode',
					width : 60
				}, {
					title : '归属产品',
					field : 'productCode',
					width : 100,
					hidden : true
				}, {
					title : '错误系统描述',
					field : 'errorSysDesc',
					width : 150
				}, {
					title : '错误用户描述',
					field : 'errorUserDesc',
					width : 150
				} ] ]
			});
		}

		function addErrorLogInfo() {
			var row = $('#queryErrorList').datagrid('getSelected');
			if (!row) {
				showSlideMessage("请选择错误码！");
				return;
			}

			// 选择错误DLG关闭
			$('#errorCodeInfoDlg').dialog('close');

			// 复制 错误到 新增页面
			$('#queryErrorCode').val(row.errorCode);
		}

		/**
		 * 绑定 按钮 按回车 激发按钮单击事件
		 * 错误码文本框为readonly时禁用退格键
		 */
		function bindingEnterKey(event) {
			// 保存按钮OJBJECT
			var btnSave = $("#btnSave");
			var btnQuery = $("#btnQuery");
			// 点击 Enter按钮
			if (event.keyCode == 13 && isOpenFlag == 1) {
				btnSave.click();
				event.returnValue = false;
			}
			// 绑定 查询的 Enter
			if (event.keyCode == 13 && isOpenFlag == 0) {
				btnQuery.click();
				event.returnValue = false;
			}
			prevent(event); //文本框、下拉框readonly、disabled时禁用退格键
		}
		/**
		 * 控制页面内下拉不可编辑
		 */
		function disEditableComboBox() {
			$("#qryProductType").combobox({
				editable : false
			});
			$("#idProductType").combobox({
				editable : false
			});
			
            $("#erProductCode").combobox({
                editable : false
            });
		}

		/**
		 * 控制日期控件不可编辑
		 */
		function disEditableDataBox() {
			$('#queryStartDate').datebox({
				editable : false
			});
			$('#queryEndDate').datebox({
				editable : false
			});
		}

		/**
		 * 查询方法:按产品大类或错误码组合查询
		 */
		function queryInfo() {
			/**/
			var errCode = null;
			var errUserDesc = null;
			var errSysDesc = null;
			if ($("#qryErrorCode").val() != null
					&& $("#qryErrorCode").val() != "") {
				errCode = "%" + $("#qryErrorCode").val() + "%";
			}
			if ($("#qryErrorUserDesc").val() != null
					&& $("#qryErrorUserDesc").val() != "") {
				errUserDesc = "%" + $("#qryErrorUserDesc").val() + "%";
			}
			if ($("#qryErrorSysDesc").val() != null
					&& $("#qryErrorSysDesc").val() != "") {
				errSysDesc = "%" + $("#qryErrorSysDesc").val() + "%";
			}

			// 根据查询组合条件，取记录当前的页面 取第一页数据 load
			$("#ErrorInfoList").datagrid('load', {
				prdType : $("#qryProductType").combobox('getValue'),
				errorCode : errCode,
				errorUserDesc : errUserDesc,
				errorSysDesc : errSysDesc
			});

		}

		/**
		 * 清空查询条件
		 */
		function queryCancel() {
			$('#queryForm').form('clear');
			$('#qryProductType').combobox('setValue', '');
		}

		/**
		 * js初始化页面DataGrid
		 */
		function iniErrorInfoGrid() {
			$("#ErrorInfoList").datagrid({
				pagination : true,
				rownumbers : true,
				pageSize : 10,
				pageList : [ 10, 20, 50 ],
				nowrap : true,
				autoRowHeight : false,
				striped : true,
				border : false,
				fitColumns : true,
				method : 'post',
				singleSelect : true,
				fit : true,
				url : '${ctx}/base/errorinfo/qryByPage',
				onDblClickRow : function(rowIndex, rowData) {
					editErrorInfo();
				},
				columns : [ [ {
					title : '归属产品',
					field : 'prdTypeName',
					width : 10
				}, {
					title : '错误码',
					field : 'errorCode',
					width : 15
				}, {
					title : '用户提示',
					field : 'errorUserDesc',
					width : 60
				}, {
					title : '系统内部描述',
					field : 'errorSysDesc',
					width : 60
				}, {
					title : '错误别名',
					field : 'errorName',
					width : 30
				}

				] ],
				toolbar : [ {
					text : '新增',
					iconCls : 'icon-add',
					handler : function() {
						newErrorInfo();
					}
				}, '-', {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						editErrorInfo();
					}
				}, '-', {
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						// 处理明细记录的删除操作handler
						removeErrorInfo();
					}
				}, '-', {
					text : '曲线图',
					iconCls : 'icon-remove',
					handler : function() {
						// 处理明细记录的删除操作handler
						openErrorCodeLine();
					}
				} ]
			});
		}

		/*
		 * 统一弹出侧边消息提示
		 */
		function showSlideMessage(msg) {
			$.messager.show({
				title : '提示',
				msg : msg,
				timeout : 4000,
				showType : 'slide'
			});
		}

		/**
		 * 新增数据
		 */
		function newErrorInfo() {
			$('#ErrorInfoDlg').dialog('open').dialog('setTitle', '新增错误对照信息');
			$('#ErrorInfoForm').form('clear');
			$('#idErrorCode').removeAttr('readonly');
			$('#idErrorCode').css("color", "#000000");
			$('#btnSave').data("action", "insert");
			/*设置归属产品类别代码*/
			$("#idProductType").combobox({
				disabled : false
			});
			$('#idProductType').combobox('setValue', 'CP');
			$('#idPreError').css("color", "#000000");
			$('#idPreError').text('CP'); //前缀赋值 
			isOpenFlag = 1;
		}
		/**
		 * 编辑数据
		 */
		function editErrorInfo() {
			var row = $('#ErrorInfoList').datagrid('getSelected');
			if (!row) {
				showSlideMessage("请选择需要编辑的错误码对照信息！");
				return;
			}
			$('#ErrorInfoDlg').dialog('open').dialog('setTitle', '修改错误对照信息');
			$('#idErrorCode').attr('readonly', 'readonly');
			$('#idErrorCode').css("color", "#9E9E9E");
			$('#ErrorInfoDlg').form('clear');
			$('#ErrorInfoDlg').form('load', row);
			$('#btnSave').data("action", "update"); // 保存操作类型数据
			/*设置归属产品类别代码*/
			var prdType = row.prdType;
			$('#idProductType').combobox('setValue', prdType);
			$("#idProductType").combobox({
				disabled : true
			});
			$('#idPreError').css("color", "#9E9E9E");
			$('#idPreError').text(row.errorCode.substring(0, 2));
			$('#idErrorCode').val(
					row.errorCode.substring(2, row.errorCode.length));
			isOpenFlag = 1;
		}

		/**
		 * 删除数据
		 */
		function removeErrorInfo() {
			var row = $('#ErrorInfoList').datagrid('getSelected');
			if (!row) {
				showSlideMessage("请选择数据需要删除的记录！"); // 未选择记录，给出侧边栏提示 需要选择记录
				return;
			}
			$.messager.confirm('确认', '确定删除当前选择的错误对照信息?', function(r) {
				if (r) {
					jQuery.ajax({

						type : "POST",
						async : false,
						url : "${ctx}/base/errorinfo/delete",
						data : {
							errorCode : row.errorCode
						},
						success : function(data) {
							if (data.result == 'success') {
								showSlideMessage("删除成功!");
								// 重新加载
								$('#ErrorInfoList').datagrid('load');
							} else {
								showSlideMessage("删除失败！");
							}
						},
						error : function(data) {
							showSlideMessage("删除过程发生异常！");
						},
						datatype : "json"
					});
				}
			});
		}

		/**
		 * 新增数据/修改数据，统一保存
		 */
		function saveErrorInfo() {
			var isValid = $('#ErrorInfoForm').form('validate');
		    if(!isValid){
		        return ;
		    }
			
			// 判断 新增或修改
			var action = $('#btnSave').data('action');
			//  对必输项进行校验
			if (!checkValiErrInfo()) {
				return;
			}
			// 判断 新增  或 修改
			if (action == 'insert') {
				// AJAX 提交
				jQuery.ajax({
					type : "POST",
					async : false,
					url : "${ctx}/base/errorinfo/insert",
					data : {
						errorCode : $('#idPreError').text()
								+ $("#idErrorCode").val(),
						errorName : $("#idErrorName").val(),
						errorUserDesc : $("#idErrorUserDesc").val(),
						errorSysDesc : $("#idErrorSysDesc").val()
					},
					success : function(data) {
						if (data.result == 'success') {
							showSlideMessage("新增成功！");
							$('#ErrorInfoDlg').dialog('close');
							isOpenFlag = 0;
							reQuery();
						} else {
							showSlideMessage("新增失败:" + data.message);
						}
					},
					error : function(data) {
						showSlideMessage("新增失败:系统错误！");
					},
					datatype : "json"
				});

			} else {

				// 修改
				jQuery.ajax({
					type : "POST",
					async : false,
					url : "${ctx}/base/errorinfo/update",
					data : {
						errorCode : $('#idPreError').text()
								+ $("#idErrorCode").val(),
						errorName : $("#idErrorName").val(),
						errorUserDesc : $("#idErrorUserDesc").val(),
						errorSysDesc : $("#idErrorSysDesc").val()
					},
					success : function(data) {
						if (data.result == 'success') {
							showSlideMessage("修改成功！");
							$('#ErrorInfoDlg').dialog('close');
							isOpenFlag = 0;
							reQuery();
						} else {
							showSlideMessage("修改失败:" + data.message);
						}
					},
					error : function(data) {
						showSlideMessage("修改失败:系统错误！");
					},
					datatype : "json"
				});
			}
		}

		/**
		 *新增、修改后设置查询条件重新查询
		 */
		function reQuery() {
			$('#qryProductType').combobox('setValue', '');
			$("#qryErrorUserDesc").val("");
			$("#qryErrorSysDesc").val("");
			/*ErrorInfoDlg清空，重新设置错误码*/
			$("#qryErrorCode").val(
					$("#idPreError").text() + $("#idErrorCode").val());
			queryInfo();
		}
		/**
		 * 新增错误码信息时，选择产品类别自动加上错误码前缀
		 */
		function setErrorCode() {
			var preError = $("#idProductType").combobox('getValue');
			$("#idPreError").text(preError);
		}
		/**
		 * 新增和修改 对必输项做校验控制
		 */
		function checkValiErrInfo() {

			if (isNull($("#idErrorCode").val())) {
				showSlideMessage("请录入错误码！");
				return false;
			}
			var valErrorCode = $("#idPreError").text()
					+ $("#idErrorCode").val(); //错误码 
			/*错误码长度校验*/
			if (valErrorCode.length != 8) {
				showSlideMessage("错误码总长度必须为8位，请确认！");
				return false;
			}
			if (!checkChar(valErrorCode, "1")) {
				showSlideMessage("错误码定义不符合要求，规则：字母数字串，前2位必须为产品类别编码！");
				return false;
			}
			var action = $('#btnSave').data('action');
			if (action == 'insert') {
				if (valErrorCode.substring(0, 2) != $("#idProductType")
						.combobox('getValue')) {
					showSlideMessage("按归属产品分类，错误码前2位必须为："
							+ $("#idProductType").combobox('getValue'));
					return false;
				}
			}
			var valErrorName = $("#idErrorName").val();//错误别名
			if (valErrorName != null && valErrorName != "") {
				
				if (valErrorName.length<=0 || valErrorName.length>60) {
					showSlideMessage("错误别名不应超过60个字符，请确认！");
					return false;
				}
				if (!checkChar(valErrorName, "2")) {
					showSlideMessage("错误别名定义不符合要求，规则：字母数字串！");
					return false;
				}
				
			}
			var valErrorUserDesc = $("#idErrorUserDesc").val(); //错误用户描述
			if (isNull(valErrorUserDesc)) {
				showSlideMessage("请录入用户提示信息！");
				return false;
			}
			/*用户提示信息长度校验*/
			if (valErrorUserDesc.length<=0 || valErrorUserDesc.length>50) {
				showSlideMessage("用户提示信息不应超过50个字符，请确认！");
				return false;
			}
			if (!checkChar(valErrorUserDesc, "3")) {
				showSlideMessage("用户提示信息不能含有特殊字符：@&\/?~<>*^·");
				return false;
			}
			var valErrorSysDesc = $("#idErrorSysDesc").val(); //系统内部描述
			if (isNull(valErrorSysDesc)) {
				showSlideMessage("请录入错误内部描述！");
				return false;
			}
			if (valErrorSysDesc.length<=0 || valErrorSysDesc.length>50) {
				showSlideMessage("错误内部描述信息不应超过50个字符，请确认！");
				return false;
			}
			if (!checkChar(valErrorSysDesc, "3")) {
				showSlideMessage("错误内部描述信息不能含有特殊字符：@&\/?~<>*^·");
				return false;
			}
			return true;
		}
		/**
		 * 错误码前缀校验(暂未调用)
		 */
		function checkErrorCode(inStr) {
			var prdType = inStr.substring(0, 2);
			var ObjStr = "CP|EP|LB|WI|LN|OL|WB";
			return (ObjStr.indexOf(prdType) < 0) ? false : true;
		}
		/**
		 * 字符校验
		 */
		function checkChar(inTxt, inTyp) {
			var objTxt
			if (inTyp == "1") {
				objTxt = new RegExp("^[A-Za-z0-9]{1,8}$"); //错误码
			}
			if (inTyp == "2") {
				objTxt = new RegExp("^[A-Za-z0-9-_#]+$"); //错误别名
			} else if (inTyp == "3") {
				objTxt = new RegExp("[@&\\\\/?~<>*^·]"); //用户提示、错误内部描述
			}
			/*未匹配到字符出错*/
			if (inTyp == "1" || inTyp == "2") {
				if (!objTxt.test(inTxt)) {
					return false;
				}
			}
			/*找到特殊字符出错(不能包含特殊字符)*/
			if (inTyp == "3") {
				if (objTxt.test(inTxt)) {
					return false;
				}
			}
			return true;
		}
	</script>
</body>
</html>