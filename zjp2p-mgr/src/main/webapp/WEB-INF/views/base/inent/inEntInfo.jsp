<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<script type="text/javascript" src="${ctx}/static/js/pub/tinybox.js"></script>
<style type="text/css">
#fileInfo tr, #auditInfo tr{
	height:40px;
}
#fileInfo td
{
	text-align:left;
	padding-left:100px;	
}
#fileInfo th
{
	text-align:center;
	padding-left:100px;	
}
#auditInfo td{
	align:left;
	padding-left:140px;	
}
td{
	word-break:break-all;
    word-wrap:break-word;
}
#main{width:960px;margin:20px auto;}
.td_input{width:220px;}
#detailForm{width:100%;}
#auditMessage{width:400px;}
.red{color:red;}

#tinybox {
    position: absolute;
    display: none;
    padding: 10px;
    background: #ffffff url(${ctx}/static/images/preload.gif) no-repeat 50%
        50%;
    border: 10px solid #e3e3e3;
    z-index: 2000;
}
#tinymask {
    position: absolute;
    display: none;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    background: #000000;
    z-index: 1500;
}
#tinycontent {
    background: #ffffff;
    font-size: 1.1em;
}
.trwidth {
    height:30px;
    width:18%;
}

</style>
</head>
<body>
<div id="main">
	<table id="detailForm" data-options="fit:true">
		<tr>
			<td class="td_label"><label><span class="red">*</span>中文全称:</label></td>
			<td class="td_input">${ent.chineseFullname}</td>
			<td class="td_label"><label>*注册或登记证件类型:</label></td>
			<td class="td_input">${ent.registerIdentType}</td>
		</tr>
		<tr>
			<td class="td_label"><label>中文简称:</label></td>
			<td class="td_input">${ent.chineseName}</td>
			<td class="td_label"><label>*注册或登记证件号码:</label></td>
			<td class="td_input">${ent.registerIdentNo}</td>
		</tr>
		<tr>
			<td class="td_label"><label>英文全称:</label></td>
			<td class="td_input">${ent.englishFullname}</td>
			<td class="td_label"><label>*注册或批准成立日期:</label></td>
			<td class="td_input">${ent.registerDate}</td>
		</tr>
		<tr>
			<td class="td_label"><label>英文简称:</label></td>
			<td class="td_input">${ent.englishName}</td>
			<td class="td_label"><label>*注册或登记证件年检日期:</label></td>
			<td class="td_input">${ent.regCheckDate}</td>
		</tr>
		<tr>
			<td class="td_label"><label>*注册国家或地区:</label></td>
			<td class="td_input">${ent.registerCountry}</td>
			<td class="td_label"><label>*营业或有效期限起始日期:</label></td>
			<td class="td_input">${ent.busiStartDate}</td>
		</tr>
		<tr>
			<td class="td_label"><label>注册地行政区划:</label></td>
			<td class="td_input">${ent.areaCode}</td>
			<td class="td_label"><label>*营业或有效期限终止日期:</label></td>
			<td class="td_input">${ent.busiEndDate}</td>
		</tr>
		<tr>
			<td class="td_label"><label>*注册地址:</label></td>
			<td class="td_input">${ent.address}</td>
			<td class="td_label"><label>所属商圈:</label></td>
			<td class="td_input">${busGroup}</td>
		</tr>
		<tr>
			<td class="td_label"><label>*注册地城乡属性:</label></td>
			<td class="td_input">${ent.addressAttribute}</td>
			<td class="td_label"><label><span class="red">*</span>企业法人代表姓名:</label></td>
			<td class="td_input">${ent.corpName}</td>
		</tr>
		<tr>
			<td class="td_label"><label>*单位类型:</label></td>
			<td class="td_input">${ent.entType}</td>
			<td class="td_label"><label><span class="red">*</span>企业法人代表有效证件类型:</label></td>
			<td class="td_input">${ent.corpIdentType}</td>
		</tr>
		<tr>
			<td class="td_label"><label><span class="red">*</span>组织机构代码:</label></td>
			<td class="td_input">${ent.orgCode}</td>
			<td class="td_label"><label><span class="red">*</span>企业法人代表有效证件号码:</label></td>
			<td class="td_input">${ent.corpIdentNo}</td>
		</tr>
		<tr>
			<td class="td_label"><label>*组织机构代码年检日期:</label></td>
			<td class="td_input">${ent.checkDate}</td>
			<td class="td_label"><label><span class="red">*</span>企业法人代表手机号:</label></td>
			<td class="td_input">${ent.corpIdentMobile}</td>
		</tr>
		<tr>
			<td class="td_label"><label>公司规模:</label></td>
			<td class="td_input">${ent.entScale}</td>
			<td class="td_label"><label>归属行业:</label></td>
			<td class="td_input">${ent.tradeCode}</td>
		</tr>
		<tr style="display:none"><td><input type="hidden" id="entNo" value="${ent.entNo}"></td></tr>
	</table>
	<c:if test="${fn:length(files)!=0}">
		<br>
		<hr width="100%" size="0" align="center">
		<br>
		<table id="fileInfo">
			<thead>
				<tr><th>名称</th><th>操作</th><th>状态<th>备注</th></tr>
			</thead>
			<tbody>
				<c:forEach items="${files}" var="file">
					<c:if test='${!empty file.fileType}'>
					<tr>
						<td><span>${file.fileType}</span></td>
						<td>
							<a class="easyui-linkbutton" onclick="viewImgFile('${file.filePath}')">预览</a>
							<a class="easyui-linkbutton" onclick="downloadFile('${file.filePath}')">下载</a>
						</td>
						<td>${file.fileStatus}</td>
						<td width="25%">${file.description}</td>
					</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</c:if> 
    <div id="preview"></div>
    <br>
    <hr width="100%" size="0" align="center">
    <br>
	<c:if test="${auditFlag==true}">
		<table id="auditInfo" style="width:100%;height:100%;border:0px;cellpadding:2;cellspacing:3;align:center">
			<tr>
		  		<td><label>操作员代码：</label></td>
		  		<td><shiro:principal property="id"/></td>
		 	</tr>
		 	<tr>
				<td><label>操作员名称：</label></td>
				<td><shiro:principal property="name"/></td>
			</tr>
			<tr> 
				<td><label>审核意见：</label></td>
			  	<td><textarea id="auditMessage" class="easyui-validatebox" rows="3" data-options="required:false,validType:'length[2,58]'"></textarea></td>
			</tr>
			<tr>
				<td><label>审核结果：</label></td>
				<td>
					<select class="easyui-combobox" id="auditorResult" data-options="required:true,panelHeight:'auto'">
						<option value="0">通过</option>
						<option value="1">驳回</option>
					</select> 
				</td>
			</tr>
		</table>
	</c:if>
    <div align="center">
	    <c:if test="${auditFlag==true}">
	     <a onclick="auditFile()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">&nbsp;审&nbsp;&nbsp;&nbsp;核&nbsp;</a>
	    </c:if>
        <a onclick="self.parent.closeCurrentTab()" class="easyui-linkbutton" data-options="iconCls:'icon-back'">&nbsp;返&nbsp;&nbsp;&nbsp;回&nbsp;</a>
    </div>
</div>
<br>
<script type="text/javascript"> 
$(function(){
	$("#detailForm input").attr("readonly",true);
	$('#detailForm select').combobox('disable');
	$(".easyui-datebox").datebox('disable');
});

/* function preview(fileNo){
	var url = "${ctx}/base/userFile/preview/"+fileNo;
	var content = '<iframe scrolling="no" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	$('#preview').dialog({
		title:'图片预览',
		modal:true,
		fit:true,
		content:content
	});
} */

//文件预览功能
function viewImgFile(fileNo) {
    if (isNull(fileNo)) {
        $.messager.alert('温馨提示', '没有图片可供预览！');
        return;
    }
    var src = "${ctx}/base/file/download/" + fileNo + "/00";
    var content = "<img width='700' height='540' src="+src+"/>";
    TINY.box.show(content, 0, 0, 0, 1);
}

//文件下载功能
function downloadFile(fileNo) {
    if (isNull(fileNo)) {
        $.messager.alert('温馨提示', '没有图片可供下载！');
        return;
    }
    location.href = '${ctx}/base/file/download/' + fileNo + "/00";
}

/* function download(fileNo){
	var url = "${ctx}/base/file/download/"+fileNo;
	var content = '<iframe name="downloadIFrame" scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	$('#preview').dialog({
		title:'下载提示',
		content:content
	});
	var result = $(self.frames["downloadIFrame"].document.body).html();
		
	if(typeof result == "undefined" || result =="")
		$('#preview').dialog('close');
} */

function auditFile(){
	//审核不通过时，需要填写审核意见
	if($('#auditorResult').combobox('getValue')==1){
		$('#auditMessage').validatebox({
			required:true,
			validType:['length[4,100]']
		});
	}
	if(!$('#auditMessage').validatebox('isValid'))
		return;	
		
	 $.messager.confirm('提示', '是否确认审核结果?', function(r){
		if(r){
			$.ajax({   
				url:'${ctx}/base/inent/audit/'+$('#entNo').val(), 
				type : 'POST',
				data:{
					auditorCode:'<shiro:principal property="id"/>',
					auditorName:'<shiro:principal property="name"/>',
					auditMessage:$('#auditMessage').val(),
					auditorResult:$('#auditorResult').combobox('getValue')
				},
				success : function(data, status) {
					if(data.status=="SUCCESS"){
						$.messager.show({
							title:'消息',
							msg:'审核成功！',
							timeout:5000,
							showType:'slide'
						});
						self.parent.reloadTabGrid("待审核基本信息","#unauditedEntTable");
						self.parent.closeCurrentTab();
					} else {
						$.messager.alert('错误',data.result,'error')
					}

				}
			});
		}else{
			return;
		}
	});
}
</script>
</body>
</html>