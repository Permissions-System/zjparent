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
/*按钮*/
.button1 {
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
					<span>&nbsp;&nbsp;&nbsp;&nbsp;个人客户相关资料</span>
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
						<td width="*" class="td_info">
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
						<td width="30%" class="td_info">
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
						<td width="30%" class="td_info">
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
						<td width="30%" class="td_info">
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
						<label>公民身份证:</label>
					</td>
					<td align="center">
						<a onclick="javascript:viewPersonIdentAndValidate('${p1File.filePath}')" class="easyui-linkbutton">校验</a>
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
<%-- 				
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>身份证反面复印件:</label>
					</td>
					<td align="center">
						<a onclick="javascript:viewImgFile('${p2File.fileNo}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${p2File.fileNo}')" class="easyui-linkbutton">下载</a>
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
--%>
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
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<table id="personAuditTable" width="95%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td height="30" width="25%">
						<div align="right">客户经理编码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
					</td>
					<td width="30%">
						<input id="managerCodeCode" name="managerCode" value="${currentStaff.id }" type="text" readOnly="true" style="width: 170px;border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" />
					</td>
					<td width="*"><span>&nbsp;</span></td>
				</tr>
				<tr>
					<td height="30" width="25%" valign="top">
						<div align="right">客户经理姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
					</td>
					<td width="30%" valign="top">
						<input id="managerName" name="managerName" value="${currentStaff.name }"  type="text" readOnly="true" style="width: 170px;border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" />
					</td>
					<td width="*"><span>&nbsp;</span></td>
				</tr>
				<tr>
					<td height="30" width="25%" valign="top">
						<div align="right">审核意见:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
					</td>
					<td>
						<textarea id="managerDescription" name="managerDescription" cols="95" rows="8" style="overflow-y:scroll"></textarea>
					</td>
				<tr/>
				<tr>
					<td height="30" width="25%">
						<div align="right">审核结果:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
					</td>
					<td width="30%">
                     <select id="auditResult" class="easyui-combobox" panelHeight="auto" name="auditResult" style="width:80px" data-option="required:true;editable:false,multiple:false">
		                <option value="0" selected="selected">通过</option> 
		                <option value="1">驳回</option>    
            		</select> 
					</td>
					<td>
						<input type="hidden" id="userNo" value="${person.userNo }" name="userNo"/>
						<input type="hidden" id="personName" value="${person.name }" name="name"/>
						<input type="hidden" id="identNo" value="${person.identNo }" name="identNo"/>
						<input type="hidden" id="identStatus" value="${p1File.fileStatus }" name="identStatus"/>
						<input type="hidden" id="approvedFileNum" value="${approvedFileNum }" name="approvedFileNum"/>
						<input type="hidden" id="submitFileNum" value="${submitFileNum }" name="submitFileNum"/>
						<input type="hidden" id="unsactionedFileNum" value="${unsactionedFileNum }" name="unsactionedFileNum"/>
						<input type="hidden" id="submitFileP1" value="${submitFileP1 }" name=""submitFileP1""/>
						<input type="hidden" id="isP1FilePathError" value="${isP1FilePathError }" name=""isP1FilePathError""/>
					</td>
				<tr/>
			</table>
		</tr>
	</table>

	<div align="center">
<!-- 	<input id="submitButton" class="button1" value="   提   交  " type="button" onClick="submitAudit()">
		<input id="btnReturn" class="button1" value="   返   回  " type="button" onClick="self.parent.closeCurrentTab()"> -->
		<a onclick="submitAudit()" class="easyui-linkbutton">&nbsp;提&nbsp;&nbsp;&nbsp;交&nbsp;</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a onclick="self.parent.closeCurrentTab()" class="easyui-linkbutton">&nbsp;返&nbsp;&nbsp;&nbsp;回&nbsp;</a>
	</div>
	<br>
	<br>
	
<script type="text/javascript">

//提交审核,将客户号userNo，审核结果result跟审核意见description传递给Controller
function submitAudit() {
	//审核意见
	var description = $('#managerDescription').val();
	//审核结果0为通过1为驳回
	var result = $("#auditResult").combobox('getValue');
	//被审核人用户编码
	var userNo = $('#userNo').val();
	//状态为审核通过的文件数
	var approvedFileNum =$('#approvedFileNum').val();
	//状态为已提交待审核的文件数
	var submitFileNum =$('#submitFileNum').val();
	//状态为审核不通过的文件数
	var unsactionedFileNum =$('#unsactionedFileNum').val();
	//P1文件状态的判断条件，如果为已提交待审核，为1，其他状态则为0
	var submitFileP1 =$('#submitFileP1').val();
/*  	
	alert("description: " + description + "||" +
			"result: " + result + "||" + "userNo: " + userNo + "||" +
			"approvedFileNum: " + approvedFileNum + "||" +
			"submitFileNum: " + submitFileNum + "||" +
			"unsactionedFileNum: " + unsactionedFileNum + "||" +
			"submitFileP1: " + submitFileP1);
 */
	//当审核意见为空时，进行提示
	if(result=="") {
		$.messager.alert('温馨提示','请至少选择一项审核结果并提交审核！');
		return;
	}
	if(approvedFileNum==0 && submitFileNum==0 && unsactionedFileNum==0) {
		$.messager.alert('温馨提示','该用户尚未提交任何资料，无需进行审批操作！');
	}
	//当身份证正面证件状态为已提交待审核时，此时进行提交操作，进行提示警告
	if(submitFileP1 == 1) {
		$.messager.alert('温馨提示','请首先对个人身份证件进行校验，再提交批量审核结果！');
		}  
/* 			else if(submitFileNum == 0) {
			$.messager.alert('温馨提示','该客户没有更新任何文件，无需进行审核操作！');
			}  */
			else {
				//审核结果为驳回
				if(result == 1) {
						if($.trim(description) == "") {
							$.messager.alert('温馨提示','审核不通过时，审核者必须输入个人的审核意见！');						
						} else {
							$.messager.confirm('确认信息', '确定提交审核意见?', function(r){
								if(r){
								$.ajax({   
									url: '${ctx}/base/personal/personAudit', 
									type : 'POST',
									dataType: 'json',
									async: 'false',
									cache: 'false',
									data: {
										description: description,
										result: result,
								   		userNo: userNo
									},
									success: function(data, status) {
										$.messager.alert('消息', '驳回成功!','info', function(){
											self.parent.reloadTabGrid('个人客户待审核列表','#personTable');
											self.parent.closeCurrentTab();
										});
									},
									error : function(data, status) {
										$.messager.alert('温馨提示','审核失败！');
									}
								});
							} else {
								return;
							}
						});
				      }
					} else if(result == 0) {
						if(unsactionedFileNum > 0) {
							$.messager.alert('温馨提示','该客户提交的文件中存在审核不通过的文件，在该文件进行更新前，不能执行文件批量通过操作！');
						} else {
							$.messager.confirm('确认信息', '确定提交审核意见?', function(r){
								if(r){
									$.ajax({   
										url: '${ctx}/base/personal/personAudit', 
										type : 'POST',
										dataType: 'json',
										async: 'false',
										cache: 'false',
										data: {
											description: description,
											result: result,
									   		userNo: userNo
										},
										success: function(data, status) {
											$.messager.alert('消息', '审核成功!','info', function(){
												self.parent.reloadTabGrid('个人客户待审核列表','#personTable');
												self.parent.closeCurrentTab();
											});
										},
										error : function(data, status) {
											$.messager.alert('温馨提示','审核失败！');
										}
									});
							} else {
								return;
								}
						});
				   }
			}
	}
	
}

//进行图片下载
function downloadFile(fileNo){
	if(isNull(fileNo)){
		$.messager.alert('温馨提示','该证件图片没有上传，不可进行下载！');
		return;
	}
	location.href='${ctx}/base/file/download/'+fileNo+'/00';
}

//进行图片预览
function viewImgFile(fileNo){
	if(isNull(fileNo)){
		$.messager.alert('温馨提示','该证件图片没有上传，不可进行预览！');
		return;
	}
	var src="${ctx}/base/file/download/"+fileNo+"/00";
	var content = "<img width='700' height='540' src="+src+"/>";
    TINY.box.show(content,0,0,0,1);
}

//跳转到个人联网核查页面
function viewPersonIdentAndValidate(fileNo){
	var name = $('#personName').val();
 	var identStatus = $('#identStatus').val(); 
	var userNo = $('#userNo').val();
	var isP1FilePathError = $('#isP1FilePathError').val();
	if(identStatus==1) {
		$.messager.alert('温馨提示','该用户身份信息已经通过审核，无需进行重审！');
	} else if(identStatus==2) {
		$.messager.alert('温馨提示','该用户身份信息审核不通过，需等客户重新上传资料方可进行审核！');
	} else {
		if(!isP1FilePathError) {
			if($.trim(fileNo)!="") {
				self.parent.openTab('联网核查：'+name,'${ctx}/base/personal/onlineValidate/'+ userNo);
				} else
					$.messager.alert('温馨提示','该用户暂未提交此类证件，无需进行联网核查！');
			} else {
				var identOpinion = "该客户提交的身份证正面文件路径存在异常，无法成功打开进行身份校验，予以驳回！";
				$.messager.confirm('温馨提示', '该客户提交的身份证正面文件路径存在异常，无法成功打开文件图片进行身份校验，请予以驳回！', function(r){
					if(r){
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
							success: function(data, status) {
								$.messager.alert('消息', '该个人身份证正面文件驳回成功!','info', function(){
									//self.parent.openTab('审核：' + name, '${ctx}/base/personal/audit/' + userNo);
									self.parent.closeTab('审核：' + name);
									self.parent.openTab('审核：'+ name,'${ctx}/base/personal/audit/'+ userNo);
								});
							},
							error : function(data, status) {
								$.messager.alert('温馨提示','身份证正面文件驳回失败！');
							}
						});
				} else {
					return;
					}
			});
			}
		}

	}
	
//审核结果Combobox不能编辑
$("#auditResult").combobox({
    editable:false
});

//审核意见文本输入框字数限制
$(document).ready(function(){
	$("#managerDescription").keydown(function(){
		var curLength=$("#managerDescription").val().length;	
		if(curLength>=60){
			var num=$("#managerDescription").val().substr(0,59);
			$("#managerDescription").val(num);
			$.messager.alert('温馨提示','描述内容不能超过60个字，否则多出的字将被截断！' );
		}
	});
	$("#managerDescription").keyup(function(){
		var curLength=$("#managerDescription").val().length;	
		if(curLength>=60){
			var num=$("#managerDescription").val().substr(0,59);
			$("#managerDescription").val(num);
			$.messager.alert('温馨提示','描述内容不能超过60个字，否则多出的字将被截断！' );
		}
	})
})
	
</script>
</body>
</html>