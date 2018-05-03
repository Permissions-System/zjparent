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
/*返回按钮*/
.buttonReturn {
	cursor: hand;
	font-size: 10pt;
	font-family: 宋体;
	border: thin outset #B7BACC;
	height: 22px;
}

.td_description {
	width:300px;
	word-break:break-all;
    word-wrap:break-word;
}

.td_info {
	word-break:break-all;
    word-wrap:break-word;
}

body
{
	font-size: 13px;
	margin-top:0; margin-bottom:0; margin-left:0; margin-right:0;
	border-width:0;
	padding: 0px;
	overflow-y: auto;
	overflow-x: hidden;
}

span {
	color:#000; 
	text-decoration:none; 
	cursor:pointer; 
	font-size:10pt;
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
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td style="width:100%;height:28px;background-color:#E0EEEE"> 
					<span>&nbsp;&nbsp;&nbsp;个人客户相关资料</span>
				</td>
			</tr>

			<tr>
				<table id="personInfoTable" width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="30" width="18%">
							<div align="right">员工姓名:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="30%" class="td_info">
							${person.name }
						</td>

						<td height="30" width="18%">
							<div align="right">证件类型:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="*">
							<c:forEach items="${identTypes}" var="identType">
				      			<c:if test="${person.identType==identType.configCode}">
				      				${identType.configName }
				      			</c:if>
						    </c:forEach>
						</td>
					</tr>
						
					<tr>
						<td height="30" width="18%">
							<div align="right">员工性别:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="30%">
							<c:forEach items="${genders}" var="gender">
				      			<c:if test="${person.gender==gender.configCode}">
				      				${gender.configName }
				      			</c:if>
						    </c:forEach>
						</td>
						<td height="30" width="18%">
							<div align="right">证件号码:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="*">
							${person.identNo }
						</td>
					</tr>
					
					<tr>
						<td height="30" width="18%">
							<div align="right">员工年龄:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="30%">
							${person.age }
						</td>

						<td height="30" width="18%">
							<div align="right">婚姻状况:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="*">
							<c:forEach items="${marriStatuses}" var="marriStatus">
				      			<c:if test="${person.marriStatus==marriStatus.configCode}">
				      				${marriStatus.configName }
				      			</c:if>
						    </c:forEach>
						</td>
					</tr>
					
					<tr>
						<td height="30" width="18%">
							<div align="right">手机号码:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="30%">
						    ${person.userAccount.mobile }
<%-- 						${userAccount.mobile } --%>
						</td>

						<td height="30" width="18%">
							<div align="right">联系地址:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="*" class="td_info">
							${person.address }
						</td>
					</tr>
					
					<tr>
						<td height="30" width="18%">
							<div align="right">邮箱地址:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="30%">
						    ${person.userAccount.email }
<%-- 						${userAccount.email } --%>
						</td>
						<td height="30" width="18%">
							<div align="right">紧急联络人:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="*" class="td_info">
							${person.urgentPerson }
						</td>
					</tr>
					
					<tr>
						<td height="30" width="18%">
							<div align="right">紧急联系方式:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="30%">
							${person.urgentTel }
						</td>

						<td height="30" width="18%">
							<div align="right">工作省市:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="*">
							<c:forEach items="${provinces}" var="province">
				      			<c:if test="${person.workProvince==province.areaCode}">
				      				${province.areaName }
				      			</c:if>
						    </c:forEach>
						    <c:forEach items="${cities}" var="city">
				      			<c:if test="${person.workCity==city.areaCode}">
				      				${city.areaName }
				      			</c:if>
						    </c:forEach>
						</td>
					</tr>
					
					<tr>
						<td height="30" width="18%">
							<div align="right">所属行业:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="30%">
						    ${tradeName }
						</td>

						<td height="30" width="18%">
							<div align="right">所在公司:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="*" class="td_info">
							${person.company }
						</td>
					</tr>
					
					<tr>
						<td height="30" width="18%">
							<div align="right">公司职位:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="30%" class="td_info">
							${person.position }
						</td>
						<td height="30" width="18%">
							<div align="right">工作时间:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="*">
							<c:forEach items="${workYears}" var="workYear">
				      			<c:if test="${person.workYear==workYear.configCode}">
				      				${workYear.configName }
				      			</c:if>
						    </c:forEach>
						</td>
					</tr>
					
					<tr>
						<td height="30" width="18%">
							<div align="right">年收入范围:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="30%">
							<c:forEach items="${incomeScopes}" var="incomeScope">
				      			<c:if test="${person.incomeScope==incomeScope.configCode}">
				      				${incomeScope.configName }
				      			</c:if>
						    </c:forEach>
						</td>
						<td height="30" width="18%">
							<div align="right">最高学历:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="*">
							<c:forEach items="${eduLevels}" var="eduLevel">
				      			<c:if test="${person.education==eduLevel.configCode}">
				      				${eduLevel.configName }
				      			</c:if>
						    </c:forEach>
						</td>
					</tr>
					<tr>
						<td height="30" width="18%">
							<div align="right">毕业院校:&nbsp;&nbsp;&nbsp;</div>
						</td>
						<td width="30%" class="td_info">
							${person.school }
						</td>
					</tr>
				</table>
			</tr>
		</table>
		
	<div align="center">
		<br></>
	</div>

	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td style="width:100%;height:28px;background-color:#E0EEEE"><span>&nbsp;&nbsp;&nbsp;个人客户证件列表</span></td>
		</tr>
		<tr>	
			<table style="width: 100%;height:100%" border="0" cellpadding="2" cellspacing="3" align="center">
			<tbody>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>名称&nbsp;&nbsp;&nbsp;&nbsp;</label>
					</td>
					<td align="center" style="font-size: 12px;font-weight:bold;color:#333;">
						<label>操作</label>
					</td>
					<td class="td_input" style="font-size: 12px;font-weight:bold;color:#333;">
						<label>&nbsp;&nbsp;&nbsp;状态</label>
					</td>
					<td class="td_description" style="font-size: 12px;font-weight:bold;color:#333;">
						<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注</label>					
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td ><hr width="100%" align="center" size=0></td>
					<td ><hr width="100%" align="center" size=0></td>
					<td ><hr width="100%" align="center" size=0></td>
					<td ><hr width="100%" align="center" size=0></td>
					<td ><hr width="100%" align="center" size=0></td>
					<td ><hr width="100%" align="center" size=0></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>身份证正面复印件:</label>
					</td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${p1File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${p1File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
 							<c:forEach items="${fileStatus}" var="status">
				      			<c:if test="${p1File.fileStatus==status.configCode}">
				      				${status.configName }
				      			</c:if>
						    </c:forEach> 
					</td>
					<td class="td_description">
						${p1File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>身份证反面复印件:</label>
					</td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${p2File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${p2File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
							<c:forEach items="${fileStatus}" var="status">
				      			<c:if test="${p2File.fileStatus==status.configCode}">
				      				${status.configName }
				      			</c:if>
						    </c:forEach>
					</td>

					<td class="td_description">
						${p2File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>银行流水:</label>
					</td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${p3File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${p3File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
							<c:forEach items="${fileStatus}" var="status">
				      			<c:if test="${p3File.fileStatus==status.configCode}">
				      				${status.configName }
				      			</c:if>
						    </c:forEach>
					</td>

					<td class="td_description">
						${p3File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>征信记录:</label>
					</td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${p4File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${p4File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
							<c:forEach items="${fileStatus}" var="status">
				      			<c:if test="${p4File.fileStatus==status.configCode}">
				      				${status.configName }
				      			</c:if>
						    </c:forEach>
					</td>
					<td class="td_description">
						${p4File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>银行存储单元:</label>
					</td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${p5File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${p5File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
							<c:forEach items="${fileStatus}" var="status">
				      			<c:if test="${p5File.fileStatus==status.configCode}">
				      				${status.configName }
				      			</c:if>
						    </c:forEach>
					</td>
					<td class="td_description">
						${p5File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>收入证明：</label>
					</td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${p6File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${p6File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
							<c:forEach items="${fileStatus}" var="status">
				      			<c:if test="${p6File.fileStatus==status.configCode}">
				      				${status.configName }
				      			</c:if>
						    </c:forEach>
					</td>
					<td class="td_description">
						${p6File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>个体户营业执照：</label>
					</td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${p7File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${p7File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
							<c:forEach items="${fileStatus}" var="status">
				      			<c:if test="${p7File.fileStatus==status.configCode}">
				      				${status.configName }
				      			</c:if>
						    </c:forEach>
					</td>
					<td class="td_description">
						${p7File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<c:forEach items="${p0FileList}" var="p0File">
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>其他文件:</label>
					</td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${p0File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${p0File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_input">
							<c:forEach items="${fileStatus}" var="status">
				      			<c:if test="${p0File.fileStatus==status.configCode}">
				      				${status.configName }
				      			</c:if>
						    </c:forEach>
					</td>
					<td class="td_description">
						${p0File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
		</tr>
	</table>
	<hr width="100%" align="center" size=0>
	<div align="center">
<!-- 	<input id="btnReturn" class="buttonReturn" value="   返   回   " type="button" onClick="self.parent.closeCurrentTab()"> -->
		<a onclick="self.parent.closeCurrentTab()" class="easyui-linkbutton">&nbsp;返&nbsp;&nbsp;&nbsp;回&nbsp;</a>
	</div>
	<br>
	<br>
<script type="text/javascript">
//文件下载功能
function downloadFile(fileNo){
	if(isNull(fileNo)){
		$.messager.alert('温馨提示','没有图片可供下载！');
		return;
	}
	location.href='${ctx}/base/file/download/'+fileNo+"/00";
}

//文件预览功能
function viewImgFile(fileNo){
	if(isNull(fileNo)){
		$.messager.alert('温馨提示','没有图片可供预览！');
		return;
	}
	var src="${ctx}/base/file/download/"+fileNo+"/00";
	var content = "<img width='700' height='540' src="+src+"/>";
    TINY.box.show(content,0,0,0,1);
}
</script>
</body>
</html>