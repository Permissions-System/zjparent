<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">

body
{
	font-size: 13px;
	margin-top:0; margin-bottom:0; margin-left:0; margin-right:0;
	border-width:0;
	padding: 0px;
}

span {
	color:#000; 
	text-decoration:none; 
	cursor:pointer; 
	font-size:10pt;
}
</style>
</head>

<body>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td width="100%" height="28" bgcolor=#E0EEEE> 
				<span>&nbsp;&nbsp;&nbsp;个人身份信息联网核查</span>
			</td>
		</tr>

		<tr>
			<table id="personInfoTable" width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td height="30" width="48%">
						<div align="right">员工姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
					</td>
					<td width="*">
						${person.name }
					</td>
				</tr>
				
				<tr>
					<td height="30" width="48%">
						<div align="right">证件类型:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
					</td>
					<td width="*">
						<div align="left">身份证</div>
					</td>
				</tr>
					
				<tr>
					<td height="30" width="48%">
						<div align="right">证件号码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
					</td>
					<td width="*">
						${person.identNo }
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="hidden" id="userNo" value="${person.userNo }" name="userNo"/>
						<input type="hidden" id="personName" value="${person.name }" name="name"/>
						<input type="hidden" id="identNo" value="${person.identNo }" name="identNo"/>
						<input type="hidden" id="p2FileNo" value="${P2FileNo }" name="p2FileNo"/>
					</td>
				</tr>
			</table>
		</tr>
	</table>
	<div align="center">
<%-- 	<img id="personPicture" src="data:image/gif;base64,${personImage }"> --%>
		<img id="personPicture" title="身份证正面" src="${ctx}/base/file/download/${p1File.filePath }/00" height="250" width="380">
		&nbsp;&nbsp;
		<img id="personBackPicture" title="身份证反面" src="${ctx}/base/file/download/${P2FileNo }/00" height="250" width="380">
	</div>
	<div align="center">
		<td align="right" width="44%">身份核实情况：&nbsp;&nbsp;</td>
		<td align="left" width="*">
			<input id="validateResult" name="validateResult" value="" style="width:220px;color:#FF0000"></input>
		</td>
	</div>
	<div align="center">
		<img id="resultPicture" style="display:none" src="">
	</div>
	<br>
	<div align="center" style="margin-right:130px">	
		<table id="validateTable" style="display:none" width="500px" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr width="100%" align="center">
				<td height="30" width="40%" valign="top" display="inline-block" white-space="nowrap">
					<p align="right" >审核意见:&nbsp;&nbsp;</p>
				</td>
				<td width="*">
					<textarea id="managerDescription" name="managerDescription" cols="55" rows="8" style="overflow-y:scroll"></textarea>
				</td>
		    <tr/>
		</table>
	</div>
	<br>
	<div>
		<table width="100%" border="0" align="center" cellpadding="5" cellspacing="5">
			<tr width="100%">
    			<td align="right" width="42%">
					<a id="identValidate" onclick="javascript:identValidate()" class="easyui-linkbutton">身份核实</a>
				</td>
				<td align="center" width="8%">
					<a id="passButton" onclick="javascript:identPass()" class="easyui-linkbutton" style="display:none" >通&nbsp;&nbsp;过</a>
				</td>
				<td align="center" width="*">
				    <a id="failButton" onclick="javascript:identFail()" class="easyui-linkbutton" style="display:none">驳&nbsp;&nbsp;回</a>
				</td>
				<td align="left" width="42%">
					<a onclick="self.parent.closeCurrentTab()" class="easyui-linkbutton">关闭页面</a>
				</td>	
			<tr>
		</table>
	</div>
	<br>
	<br>
	<br>
	 
<script type="text/javascript">
//初始判断身份证反面文件是否存在，如果不存在则进行提示
window.load = p2FileCheck();

//身份校验按钮触发
function identValidate(){
	var name = $('#personName').val();
	var identNo = $('#identNo').val();
	if($.trim(name) != "" && $.trim(identNo) != "") {
		$.ajax({
			type : 'GET',
			datatype : "json",
			async: 'false',
			cache: 'false',
			url : '${ctx}/base/personal/onlineValidateResult',
			data : {
				name : name,
				identNo : identNo
			},
			success : function(data, status) {
				var isMatch = data.isMatch;
				var hasImage = data.hasImage;
				var imageString = data.imageBase64;
				if(isMatch) {
					$("#validateResult").val("身份信息校验通过，请核对下图照片。"); 
					if(hasImage) {
						var image="data:image/gif;base64," + imageString;
						document.getElementById("resultPicture").src = image;
						$('#validateTable').show();
						$('#resultPicture').show();
/* 						document.getElementById('validateTable').style.display='block';
						document.getElementById('resultPicture').style.display='block'; */
						$('#identValidate').hide();
						$('#passButton').show();
						$('#failButton').show();
						$.messager.alert('温馨提示','客户姓名及身份证号码联网核查通过，请认真核对下图照片，并根据图片比对结果提交审核结果！');
					} else {
						$('#validateTable').show();
						$('#failButton').show();
						$.messager.alert('温馨提示','联网核查不存在该客户照片，建议驳回！');
					}
				} else {
					$('#identValidate').hide();
					$('#validateTable').show();
					$('#failButton').show();
					$("#validateResult").val("身份信息有误，身份校验不通过！");
					$.messager.alert('温馨提示','该客户身份信息不能通过联网核查，请予以驳回！');
				}
			},
			error : function(data, status) {
				$('#identValidate').hide();
				$('#failButton').show();
				$('#validateTable').show();
/* 				document.getElementById('validateTable').style.display='block'; */
				$.messager.alert('错误信息','联网核查系统出现异常，查询失败！');
			}
		});
	} else {
		$('#validateTable').show();
		$('#identValidate').hide();
		$('#failButton').show();
		$("#validateResult").val("客户身份信息缺失！");
		$.messager.alert('温馨提示','该客户身份信息缺失，联网核查失败，建议驳回！');
	}
}

//身份证审核通过
function identPass() {
	var userNo = $('#userNo').val();
	var name = $('#personName').val();
	var identOpinion = $('#managerDescription').val();
	$.messager.confirm('确认','确认提交身份审核结果?',
			function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						datatype : "json",
						async : 'false',
						cache : 'false',
						url : '${ctx}/base/personal/identPass',
						data : {
							userNo : userNo,
							identOpinion : identOpinion
						},
						success : function(data, status) {
							self.parent.closeTab('审核：' + name);
							self.parent.openTab('审核：' + name, '${ctx}/base/personal/audit/' + userNo);
							self.parent.closeTab('联网核查：' + name);
						},
						error : function(data, status) {
							$.messager.alert('错误信息', '身份证信息审查失败！');
						}
					});
				} else {
				    return
					}
			});
	}

	//身份证审核失败
	function identFail() {
		var userNo = $('#userNo').val();
		var name = $('#personName').val();
		var identOpinion = $('#managerDescription').val();
		if ($.trim(identOpinion) != "") {
			$.messager.confirm('确认','确认提交身份审核结果?',
				function(r) {
					if (r) {
							$.ajax({
								type : 'POST',
								datatype : "json",
								async : 'false',
								cache : 'false',
								url : '${ctx}/base/personal/identFail',
								data : {
									userNo : userNo,
									identOpinion : identOpinion
								},
								success : function(data, status) {
									self.parent.closeTab('审核：' + name);
									self.parent.openTab('审核：' + name,'${ctx}/base/personal/audit/' + userNo);
									self.parent.closeTab('联网核查：' + name);
								},
								error : function(data, status) {
									$.messager.alert('错误信息', '身份证信息审查失败！');
								}
							});
						} else {
						    return;
						}
				});
			} else {
				$.messager.alert('温馨提示', '身份信息核查不通过时，请务必输入驳回意见！');
			}
	}
	

	//身份证反面文件检查是否存在
	function p2FileCheck() {
		var p2FileNo = $('#p2FileNo').val();
		if($.trim(p2FileNo) == "") {
			$('#personBackPicture').hide();
			$.messager.alert('温馨提示', '身份证反面文件没有提交，请根据具体情况进行审核通过或驳回处理！');
		}
	}
	
	//审核意见文本输入框字数限制
	$(document).ready(function(){
		$("#managerDescription").keydown(function(){
			var curLength=$("#managerDescription").val().length;	
			if(curLength>=60){
				var num=$("#managerDescription").val().substr(0,59);
				$("#managerDescription").val(num);
				$.messager.alert('温馨提示','描述内容不能超过60汉字，否则多出的字将被截断！' );
			}
		});
		$("#managerDescription").keyup(function(){
			var curLength=$("#managerDescription").val().length;	
			if(curLength>=60){
				var num=$("#managerDescription").val().substr(0,59);
				$("#managerDescription").val(num);
				$.messager.alert('温馨提示','描述内容不能超过60汉字，否则多出的字将被截断！' );
			}
		});
	});
	
</script>
</body>
</html>