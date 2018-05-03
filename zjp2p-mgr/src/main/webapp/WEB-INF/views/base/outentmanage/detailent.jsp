<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<script type="text/javascript" src="${ctx}/static/js/pub/tinybox.js"></script>
<style type="text/css">
html,body {
	overflow-y: auto;
	overflow-x: hidden;
}
td{
	word-break:break-all;
    word-wrap:break-word;
}
.blank_td {
    width: 10%;
}
.td_label {
    padding-left:10px;
    width: 180px;
    height: 30px;
    text-align: right;
    font-size: 12px;
    nowrap: nowrap;
}
.td_input {
    padding-left:5px;
    width: 200px;
    height: 30px;
    text-align: left;
}
.td_remark {
     align: center;
     word-break:break-all;
     word-wrap:break-word;
     width: 15%;
}
.area{
        height:150px;
        width:50%;
        overflow-y:scroll;
}
#msg,#errorMsg{
	color:red;
	padding-left:10px;
}
#tinybox{
position:absolute; display:none; padding:10px; background:#ffffff url(${ctx}/static/images/preload.gif) no-repeat 50% 50%; 
border:10px solid #e3e3e3; z-index:2000;
}
#tinymask{position:absolute; display:none; top:0; left:0; height:100%; width:100%; background:#000000; z-index:1500;}
#tinycontent{background:#ffffff; font-size:1.1em;}
</style>
</head>
<body>
	<div>
		<div>
			<div>
				<p style="text-align: center; padding-top:30px;">
					<span style="font-size: 16px; font-weight: bold; font-style: normal;">圈外企业信息</span>
				</p>
			</div>
		</div>
	</div>
	<div style="width:30px;">
	</div>
		<table style="width: 100%" border="0" cellpadding="2" cellspacing="3" align="center">
			<tbody>
				<tr>
					<td colspan="7" style="align:'left'">
						<p>
							<span style="font-size: 15px;font-style: normal;">客户基本信息</span>
						</p>
					</td>
				</tr>
				<tr>
					<td colspan="7"><hr /></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>*中文全称:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entInfo.chineseFullname}
					</td>
					<td class="td_label">
						<label>*注册或登记证件类型:</label>
					</td>
					<td class="td_input">
						${entInfoMap.registerIdentType }
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>中文简称:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entInfo.chineseName}
					</td>
					<td class="td_label">
						<label>*注册或登记证件号码:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entInfo.registerIdentNo}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>英文全称:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entInfo.englishFullname}
					</td>
					<td class="td_label">
						<label>*注册国家或地区:</label>
					</td>
					<td class="td_input">
						${entInfoMap.country }
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>英文简称:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entInfo.englishName}
					</td>
					<td class="td_label">
						<label>注册地行政区划:</label>
					</td>
					<td class="td_input">
						${entInfoMap.registerArea }
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>*单位类型:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entType }
					</td>
					<td class="td_label">
						<label>注册地址:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entInfo.address}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>*组织机构代码年检日期:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entInfo.checkDate}
					</td>
					<td class="td_label">
						<label>*注册地城乡属性:</label>
					</td>
					<td class="td_input">
						${entInfoMap.addressAttribute }
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>*注册或批准成立日期:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entInfo.registerDate}
					</td>
					<td class="td_label">
						<label>*审核状态:</label>
					</td>
					<td class="td_input">
						${entInfoMap.status }
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>*注册或登记证件年检日期:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entInfo.regCheckDate}
					</td>
					<td class="td_label">
						<label>*组织机构代码:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entInfo.orgCode}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>*营业或有效期限起始日期:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entInfo.busiStartDate}
					</td>
					<td class="td_label">
						<label>*企业法人代表有效证件类型:</label>
					</td>
					<td class="td_input">
						${entInfoMap.identType}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>*营业或有效期限终止日期:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entInfo.busiEndDate}
					</td>
					<td class="td_label">
						<label>*企业法人代表有效证件号码:</label>
					</td>
					<td class="td_input">
						${entInfoMap.identNo}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>*企业法人代表姓名:</label>
					</td>
					<td class="td_input">
						${entInfoMap.name}
					</td>
					<td class="td_label">
						<label>*企业法人代表手机号:</label>
					</td>
					<td class="td_input">
						${entInfoMap.mobile}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>公司规模:</label>
					</td>
					<td class="td_input">
						${entInfoMap.entScale}
					</td>
					<td class="td_label">
						<label>所属行业:</label>
					</td>
					<td class="td_input">
						${entInfoMap.tradeName }
					</td>
					<td class="blank_td"></td>
				</tr>
			</tbody>
		</table>
		<table style="width: 100%;" border="0" cellpadding="2" cellspacing="3" align="center">
			<tbody>
				<tr>
					<td colspan="7"><hr /></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">名称</td>
					<td></td>
					<td align="center">操作</td>
					<td align="left">资料状态</td>
					<td class="td_remark">备注</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>*注册或登记证件:</label>
					</td>
					<td></td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${entInfoMap.e1File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${entInfoMap.e1File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
						<c:forEach items="${entInfoMap.fileStatus}" var="status">
				      		<c:if test="${entInfoMap.e1File.fileStatus==status.configCode}">
				      			${status.configName }
				     		</c:if>
						</c:forEach>
					</td>
					<td class="td_remark">
						${entInfoMap.e1File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>*组织机构代码证:</label>
					</td>
					<td></td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${entInfoMap.e2File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${entInfoMap.e2File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
						<c:forEach items="${entInfoMap.fileStatus}" var="status">
				      		<c:if test="${entInfoMap.e2File.fileStatus==status.configCode}">
				      			${status.configName }
				     		</c:if>
						</c:forEach>
					</td>
					<td class="td_remark">
						${entInfoMap.e2File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>*企业法人代表授权书:</label>
					</td>
					<td></td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${entInfoMap.e3File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${entInfoMap.e3File.filePath}')"" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
						<c:forEach items="${entInfoMap.fileStatus}" var="status">
				      		<c:if test="${entInfoMap.e3File.fileStatus==status.configCode}">
				      			${status.configName }
				     		</c:if>
						</c:forEach>
					</td>
					<td class="td_remark">
						${entInfoMap.e3File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>*营业执照:</label>
					</td>
					<td></td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${entInfoMap.e5File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${entInfoMap.e5File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
						<c:forEach items="${entInfoMap.fileStatus}" var="status">
				      		<c:if test="${entInfoMap.e5File.fileStatus==status.configCode}">
				      			${status.configName }
				     		</c:if>
						</c:forEach>
					</td>
					<td class="td_remark">
						${entInfoMap.e5File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<c:forEach items="${entInfoMap.e0FileList}" var="e0File">
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>其他文件:</label>
					</td>
					<td></td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${e0File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${e0File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
						<c:forEach items="${entInfoMap.fileStatus}" var="status">
				      		<c:if test="${e0File.fileStatus==status.configCode}">
				      			${status.configName }
				     		</c:if>
						</c:forEach>
					</td>
					<td class="td_remark">
						${e0File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	<c:choose>
		<c:when test="${false!=audit }">
			<form id="auditForm" action="#" align="left">
				<table  style="width: 100%;" class="audit" border="0" cellpadding="2" cellspacing="3" align="center">
					<tbody>
						<tr><td><hr /></td></tr>
						<tr>
								<td style="padding-left:250px;"><label for="name">客户经理编码: </label>${entInfoMap.userID }</td>
							<tr>
								<td style="padding-left:250px;"><label for="email">客户经理姓名: </label>${entInfoMap.userName }</td>
							<tr>
								<td style="padding-left:250px;"><label for="name">审核意见:</label> <label id="msg"></label><label id="errorMsg"></label></td>
							</tr>
							<tr>
								<td style="padding-left:250px;"><textarea name="opinion" class="area" id="opinion" ></textarea>
								</td>
							</tr>
							<tr>
								<td style="padding-left:250px;"><label for="name">审核结果:</label> 
								<select id="result" name="name" class="easyui-combobox" data-options="editable:false" style="width:80px" panelHeight="auto">
										<option value="0">通过</option>
										<option value="1">驳回</option>
								</select></td>
							</tr>
						</tbody>
					</table>
					<input type="text" id="entNo" value="${entInfoMap.entInfo.entNo }" name="entNo"/>
					<table style="width: 100%;" border="0" cellpadding="2" cellspacing="3" align="center" >
						<tbody>
							<tr>
								<td><hr /></td>
							</tr>
							<tr>
								<td align="center">
								<a id="submit" class="easyui-linkbutton" data-options="iconCls:'icon-save'"> 提交</a>
								<a id="btnReturn" class="easyui-linkbutton" data-options="iconCls:'icon-back'"> 返回</a>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
		</c:when>
		<c:otherwise>
				<table style="width: 100%;">
					<tbody>
						<tr>
							<td><hr /></td>
						</tr>
						<tr>
							<td align="center"><a id="btnReturn" class="easyui-linkbutton" data-options="iconCls:'icon-back'"> 返回</a></td>
						</tr>
					</tbody>
				</table>
			
		</c:otherwise>
	</c:choose>
	<div id="imgDialog">
		<div style="text-align: center;">
			<img id="img" src="" alt="图片预览失败！" style="display: none;"></img>
		</div>
	</div> 
	<div style="padding-bottom:20px;"></div>
<script type="text/javascript">
$(document).ready(function(){
	if($.browser.msie&&$.browser.version!='9.0') //判断浏览器
	{
		//ie浏览器
		$('#opinion').bind('propertychange', function() {
			var message="还可以输入：58字!";
			$("#msg").text(message);
			var content = $("#opinion").val();
 				var curLength=content.length;
 				if(curLength > 58) {
 	                 $(this).text($(this).text().substring(0, 58));
 	             }
 				var num=58-curLength;
 				message="还可以输入："+num+"字!";
 				$("#msg").text(message);
		});
	}else{
		//非ie浏览器
		$('#opinion').bind('input', function() {
			checkcontent();
		});
	}
	
	$('#entNo').hide();
	
	$.ajaxSetup ({
		   cache: false //关闭AJAX响应的缓存
	});
	
	//提交前检测是否填写审核意见
	 $('#submit').click(function(){
		 if(1==$('#result').combobox('getValue')){
			if($.trim($('#opinion').val())== "") {
				$('#errorMsg').text("审核意见未填写！");
				return false;
			}
		 }
		 if(0==$('#result').combobox('getValue')){//判断注册或登记证件与组织机构代码证与企业信息是否齐全
			var e1File='${entInfoMap.e1File.fileNo}';
			var e2File='${entInfoMap.e2File.fileNo}';
			if(!isNull(e1File) && !isNull(e2File)){ //注册或登记证件与组织机构代码证都已提交
				var chineseFullName='${entInfoMap.entInfo.chineseFullname}';
				var registerIdentType = '${entInfoMap.registerIdentType }';
				var registerIdentNo= '${entInfoMap.entInfo.registerIdentNo}';
				var orgCode='${entInfoMap.entInfo.orgCode}';
				if(isNull(chineseFullName)){
					$('#errorMsg').append("<font color='red'>&nbsp;&nbsp;企业中文全称为空，不能通过审核！</font>");
					return false;
				}
				if(isNull(registerIdentType)){
					$('#errorMsg').append("<font color='red'>&nbsp;&nbsp;企业注册或登记证件类型为空，不能通过审核！</font>");
					return false;
				}
				if(isNull(registerIdentNo)){
					$('#errorMsg').append("<font color='red'>&nbsp;&nbsp;企业注册或登记证件号码为空，不能通过审核！</font>");
					return false;
				}
				if(isNull(orgCode)){
					$('#errorMsg').append("<font color='red'>&nbsp;&nbsp;企业组织机构代码为空，不能通过审核！</font>");
					return false;
				}
			}
		 }
		 $.messager.confirm('确认信息', '确定提交审核意见?', function(r){
			if(r){		
					$.ajax({   
						url: '${ctx}/base/outent/entaudit', 
						type : 'POST',
						dataType: 'json',
						async: 'false',
						cache: 'false',
						data: {
							result: $('#result').combobox('getValue'),
							no: $('#no').val(),
					   		name: $('#name').val(),
					   		entNo: $("#entNo").val(),
					   		opinion: $("#opinion").val()
						},
						success: function(data, status) {
							if(data.status=='success'){
								$.messager.alert('消息', '审核请求处理成功!','info', function(){
									self.parent.reloadTabGrid("圈外企业待审核列表","#entTable");
									self.parent.reloadTabGrid("圈外企业认证待审核","#entTable");
									self.parent.closeCurrentTab();
								});
							}else{
								$.messager.alert('消息', data.result,'error');
							}
						},
						error: function(){
							$.messager.alert('消息', '审核失败!','error');
						}
					});
			}
		 });
	}); 
	//绑定返回事件
	 $('#btnReturn').click(function(){
		self.parent.closeCurrentTab();
	 });
});

function checkcontent(){
	if($.syncProcessSign) return ;
	$.syncProcessSign = true;
	var message="还可以输入：58字!";
	var desc = $("#opinion").val();
	var curLength=desc.length;
	if(curLength >= 58) {
		$("#opinion").val($("#opinion").val().substring(0, 58));//此处最好换成您的中文截取方式
		message="还可以输入：0字!";
		$("#msg").text(message);//可以显示字数
	}else{
		var num=58-curLength;
		message="还可以输入："+num+"字!";
		$("#msg").text(message);//可以显示字数
	}
	$.syncProcessSign = false;
}

//点击审核意见框后清除错误信息
$('#opinion').click(function(){
	$('#errorMsg').text("");
});
		
function downloadFile(fileNo) {
	if (isNull(fileNo)) {
		$.messager.alert('警告信息','没有资料可以下载！','info');
		return;
	}
	location.href='${ctx}/base/file/download/'+fileNo+'/00';
}
function viewImgFile(fileNo){
	if(isNull(fileNo)){
		$.messager.alert('警告信息','没有资料可以预览！','info');
		return;
	}
	var src="${ctx}/base/file/download/"+fileNo+"/00";
	var content = "<img width='700' height='540' src="+src+"/>";
       TINY.box.show(content,0,0,0,1);
}
</script>
</body>
</html>