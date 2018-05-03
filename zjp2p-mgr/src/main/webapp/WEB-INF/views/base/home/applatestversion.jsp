<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
input,select{
	width:180px;
}
#appDlg tr{
	height:50px;
}
#appDlg td label {
	text-align:right;
	padding-left:20px;	
}
.button{
	width:50px;
}
.itemMagin{
    height:30px;
}
</style>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,selected:true">
	<div data-options="region:'center'",boder="true">
		<table id="applatestversionTab"></table>
	</div>

</div>

<!-- 新增修改页面 -->
<div id="appDlg" class="easyui-dialog" style="width:450px;height:600px;padding:
10px 0px 10px 0px"
    data-options="resizable:false,modal:true" closed="true" buttons="#app-dlg-buttons">
	<form id="appForm" method="post">
		<table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 12px">
            <tbody>
				<tr>
					<td><label>手机操作系统:</label></td>
					<td>
						<select id="mobos" class="easyui-combobox" panelHeight="auto" name="mobos" style="width:200px;" data-option="editable:false,required:true,multiple:false"> 
		                <option value="iOS">iOS</option>
		                <option value="Android">Android</option>
			        	</select>
					</td>
					<td></td>
				</tr>
				<tr>
					<td><label>APP名称:</label></td>
					<td>
						<select id="appname" class="easyui-combobox" panelHeight="auto" name="appname" style="width:200px;" data-option="editable:false,required:true,multiple:false"> 
		                <option value="1">企业版</option>
		                <option value="0">个人版</option>
			        	</select>
					</td>
				</tr>
				<tr>
					<td><label>操作系统版本:</label></td>
					<td><input class="easyui-validatebox" type="text" style="width:200px;" id="osver" name="osver"/></td>
				</tr>
				<tr>
					<td><label>APP版本:</label></td>
					<td><input class="easyui-validatebox" type="text" style="width:200px;" id="appver" name="appver" data-options="required:true"/></td>
				</tr>
				<tr>
					<td><label>上线日期:</label></td>
					<td>
						<div>
							<input id="issuedate" name="issuedate" style="width:200px;" class="easyui-datebox" data-option="editable:false,showSeconds:false" >
						</div>
					</td>
				</tr>
				<tr>
					<td><label>上线时间:</label></td>
					<td>
						<div>
							<select id="issuehour"  name="issuehour" class="easyui-combobox" style="width:80px;" data-option="required:false,editable:false">     
	                            <c:forEach items="${Hour}" var="hour">
	   								<option value="${hour}">${hour}</option>
	   							</c:forEach>
	                    	</select>
	                    	<label style="padding-left:0px;">时</label>
	                    	<select id="issuemin"  name="issuemin" class="easyui-combobox" style="width:80px;" data-option="required:false,editable:false">     
	                            <c:forEach items="${Min}" var="min">
	   								<option value="${min}">${min}</option>
	   							</c:forEach>
	                    	</select>
	                    	<label style="padding-left:0px;">分</label>
	                    </div>
                    </td>
				</tr>
				<tr>
					<td><label>是否强制更新:</label></td>
					<td>
						<select id="uptflg" class="easyui-combobox" panelHeight="auto" name="uptflg" style="width:200px;" data-option="editable:false,required:true,multiple:false"> 
		                <option value="1">是</option>
		                <option value="0">否</option>
			        	</select>
					</td>
				</tr>
				<tr>
					<td><label>更新描述:</label></td>
					<td><input class="easyui-validatebox" type="text" style="width:200px;" id="uptdesc" name="uptdesc" /></td>
				</tr>
				<tr id="apkupload1" style="display:none">
					<td><label>APK上传:</label></td>
					<td><span id="APKupload" type="file" fileName="" fileNail=""></span></td>
				</tr>
				<tr id="apkupload2" style="display:none">
					<td><label></label></td>
					<td>
						<a class="easyui-linkbutton" onclick="ajaxFileUpload('APKupload', 'apk', fileUploadCallback,'');" href="#">上传</a> 
						<label id="uploadResult"></label>
					</td>
				</tr>
				</tbody>
		</table>
	</form>
</div>
<div id="app-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="saveInfo" >保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" id="closeInfo">关闭</a>
</div>

	
<script type="text/javascript" src="${ctx}/static/js/pub/ajaxfileupload.js"></script>
<script type="text/javascript" src="${ctx}/static/js/pub/jquery.form.min.js"></script>
	
<script>
var apkId='';
$(document).ready(function() {
	
	$('#saveInfo').bind("click",function(){
		saveappInfo();
	});
	$('#closeInfo').bind("click",function(){
		closeappInfo();
	});
	//对数据修改的话对话框属性会改变
	$('#appForm:input').change(function(){
		$('#appForm').data("change",true);
	});
	//改变操作系统combobox的事件响应
	$('#mobos').combobox({
		onChange:function(){
			if($('#mobos').combobox('getValue')=="iOS"){
				$('#apkupload1').hide();
				$('#apkupload2').hide();
			}else{
				$('#apkupload1').show();
				$('#apkupload2').show();
			}
		}
	});

	$("#mobos").combobox({
        editable:false
	});
	$("#appname").combobox({
        editable:false
	});
	$("#uptflg").combobox({
        editable:false
	});
	$("#issuehour").combobox({
        editable:false
	});
	$("#issuemin").combobox({
        editable:false
	});
	$("#issuedate").datebox({
		editable : false
	});
		init_datagrid();

		requiredBox();
	});

	function requiredBox() {

		$('#osver').validatebox({
			validType : [ 'length[1,20]' ]
		});
		$('#appver').validatebox({
			validType : ['length[1,50]']
		});
		$('#uptdesc').validatebox({
			validType : [ 'length[1,1000]' ]
		});
	};

	function init_datagrid() {
		$('#applatestversionTab').datagrid({
			url : '${ctx}/base/app/applatestversion',
			pagination:true,
			rownumbers:true,
			pageSize:10,
			pageList:[10,20],
		    nowrap: false,
	        autoRowHeight:false,
	        striped:true,
	        border:false,
	        fitColumns:true,
	        method:'post',
	        singleSelect:true,
	        fit:true,
	        loadMsg: '加载数据，请稍候...',
			title : "APP最新版本列表",
			columns : [ [ {
				field : 'mobos',
				title : '手机操作系统',
				width : 80
			}, {
				field : 'appnameDesc',
				title : 'App名称',
				width : 60
			}, {
				field : 'osver',
				title : '操作系统版本',
				width : 80
			}, {
				field : 'appver',
				title : 'App版本',
				width : 60
			}, {
				field : 'downloadurl',
				title : '下载地址',
				width : 400
			}, {
				field : 'issuedate',
				title : '上线日期',
				width : 60
			}, {
				field : 'issuetimeDesc',
				title : '上线时间',
				width : 60
			}, {
				field : 'uptflgDesc',
				title : '是否强制更新',
				width : 80
			}, {
				field : 'uptdesc',
				title : '更新描述',
				width : 100
			} ] ],
			toolbar : [ {
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					update();
				}
			}, '-', {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					reload();
				}
			}]
		});
	};
	
	//初始化文件上传
	new IBankFileUpload(200);

	/**
	 * 弹出新增对话框
	 */
	function add() {

		$('#appDlg').dialog('open').dialog('setTitle', '新增');
		$('#mobos').removeAttr('readonly');
		$('#mobos').css("color", "#000000");
		
		$('#appname').removeAttr('readonly');
		$('#appname').css("color", "#000000");
		$('#appForm').form('clear');
		$('#apkupload1').hide();
		$('#apkupload2').hide();
		
		$('#mobos').combobox('select',"iOS");
		$('#issuehour').combobox('select',"00");
		$('#issuemin').combobox('select',"00");
		$('#appname').combobox('select',0);
		$('#uptflg').combobox('select',0);
		defaultdate();
		//向保存按钮传递参数用于判断
		$('#saveInfo').data("action", "add");
	};
	/*
	 * 弹出修改对话框
	 */
	function update() {
		var row = $('#applatestversionTab').datagrid('getSelected');
		if (!row) {
			showSlideMessage("请选择一条需要编辑的记录");
			return;
		}
		var time = row.issuetime;
		var date = row.issuedate;
		var hour =  time.substr(0,2);
		var min = time.substr(2,2);
		var year =date.substr(0,4);
		var month =date.substr(4,2);
		var day= date.substr(6,2);
		$('#appDlg').dialog('open').dialog('setTitle', '更新');

		$('#mobos').attr('readonly', 'readonly');
		$('#mobos').css("color", "#9E9E9E");
		$('#appname').attr('readonly', 'readonly');
		$('#appname').css("color", "#9E9E9E");

		$('#appForm').form('clear');
		$('#appForm').form('load', row);
		
		$('#uptflg').combobox('setValue',row.uptflg);
		$('#appname').combobox('setValue',row.appname);
		$('#issuehour').combobox('setValue',hour);
		$('#issuemin').combobox('setValue',min);
		$('#issuedate').datebox('setValue',year+"-"+month+"-"+day);
		
		if($('#mobos').combobox('getValue')=='iOS'){
			$('#apkupload1').hide();
			$('#apkupload2').hide();
		}
		else{
			$('#apkupload1').show();
			$('#apkupload2').show();
		}
		//向保存按钮传递参数用于判断
		$('#saveInfo').data("action", "update");
		$('#saveInfo').data("downloadurl", row.downloadurl);
	}

	function saveappInfo() {
		var isValid = $('#appForm').form("validate");
		if (!isValid) {
			return;
		}
		var address='';
		var action = $('#saveInfo').data('action');
		var downloadurl = $('#saveInfo').data('downloadurl');
		var date=$('#issuedate').datebox('getValue');
		var time=$('#issuehour').combobox('getValue')+$('#issuemin').combobox('getValue')+'00';
		if(apkId!=''){
			address= '${Domain}' +'/base/file/download/'+apkId+'/00';
		}
		if(apkId==''&&action=='update'){
			address= downloadurl;
		}
		if($('#mobos').combobox('getValue')=='iOS'){
			address= "${iOSdownloadurl}";
		}
		if (action == 'add') {
			$.ajax({
				type : 'POST',
				async : false,
				url : '${ctx}/base/app/addlatestversion',
				data : {
					mobos : $('#mobos').combobox('getValue'),
					appver : $('#appver').val(),
					appname : $('#appname').combobox('getValue'),
					osver : $('#osver').val(),
					downloadurl : address,
					issuedate : cgReplaceAll(date,'-',''),
					issuetime : time,
					uptflg : $('#uptflg').combobox('getValue'),
					uptdesc : $('#uptdesc').val()
				},
				success : function(data, status) {
					if (data.status == "SUCCESS") {
						showSlideMessage("添加最新版本信息成功！")
						$('#appDlg').dialog('close');
						$('#applatestversionTab').datagrid('reload');
					} else {
						$.messager.alert('添加最新版本信息错误', data.result, 'error');
					}
				}
			});
		} else {
			$.ajax({
				type : 'POST',
				async : false,
				url : '${ctx}/base/app/updatelatestversion',
				data : {
					mobos : $('#mobos').combobox('getValue'),
					appver : $('#appver').val(),
					appname : $('#appname').combobox('getValue'),
					osver : $('#osver').val(),
					downloadurl : address,
					issuedate : cgReplaceAll(date,'-',''),
					issuetime : time,
					uptflg : $('#uptflg').combobox('getValue'),
					uptdesc : $('#uptdesc').val()
				},
				success : function(data, status) {
					if (data.status == "SUCCESS") {
						showSlideMessage("更新成功！");
						$('#appDlg').dialog('close');
						$('#applatestversionTab').datagrid('reload');
					} else {
						$.messager.alert('错误', data.result, 'error');
					}
				}
			});
		}
		//appId置为空
		apkId='';
		$('#uploadResult').html("");
	};
	/**
	刷新
	*/
	function reload(){
			$('#applatestversionTab').datagrid('reload');
	}
	/*
	关闭对话框
	*/
	function closeappInfo(){
		//appId置为空
		apkId='';
		$('#uploadResult').html("");
		$('#appDlg').dialog('close');
	}
	/**
	 * 删除记录
	 */
	function del() {
		var node = $('#applatestversionTab').datagrid('getSelected');
		if (!node) {
			showSlideMessage("请选择需要删除的记录！");
			return;
		}
		$.messager.confirm('确认信息', '确定删除该记录吗?', function(r) {
			if (r) {
				$.ajax({
					type : 'POST',
					url : '${ctx}/base/app/delapplatestversion',
					data : {
						mobos : node.mobos,
						appname : node.appname
					},
					success : function(data, status) {
						if (data.status == "SUCCESS") {
							showSlideMessage("删除成功！");
							$('#applatestversionTab').datagrid('load');
						} else {
							$.messager.alert('错误', data.result, 'error');
						}
					},
					error : function() {
						$.messager.alert('消息', '删除失败!', 'info');
					}
				});
			}
		});
	}
	/*
	文件上传回调
	*/
	function fileUploadCallback(fileId, fileDesc, fileName, fileNail) {
		
		$.ajax({
			url : '${ctx}/base/app/apkuploadcheck',
			type : 'POST',
			data : {
				fileName:fileDesc,
				fileId:fileName
			},
			success : function(data, status) {
				if (data.status == "SUCCESS") {
					$('#uploadResult').html("上传成功！");
					apkId=fileName;
			 	} else {
					$.messager.alert('错误', data.result, 'error');
				}
			}
		});
	}
	/**
	*datebox的初始默认值 
	*/
	function defaultdate(){
		var date = new Date();
		var month=date.getMonth()+1+"";
		var day=date.getDate()+"";
		
		if(month.length==1)
			month="0"+month;
		if(day.length==1)
			day="0"+day;
		$('#issuedate').datebox('setValue',date.getFullYear()+"-"+month+"-"+day);
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
</script>

</body>
</html>