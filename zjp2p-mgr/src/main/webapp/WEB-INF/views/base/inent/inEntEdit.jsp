<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
input,select {
	width: 180px;
}

#detailForm tr,#fileInfo tr,#auditInfo tr,#uploadForm tr {
	height: 40px;
}
#fileInfo td {
	text-align: left;
	padding-left: 130px;
}

#auditInfo td{
	align: left;
	padding-left: 140px;
}

#uploadForm td {
	align: left;
	padding-left: 70px;
}

#uploadForm th,#fileInfo th {
	text-align: center;
	padding-left: 70px;
}
#main{width:960px;margin:0 auto;}
.red{
	color:red;
}
</style>
</head>
<body>
	<div id="main">
		<p style="text-align:center;"><span class="red">注</span>：标记为<span class="red">*</span>的字段为必输的基本信息，标记为*的字段为客户需要进行贷款业务时必输的信息！</p>
		<form id="baseDetail">
			<table id="detailForm" data-options="fit:true">
				<tr>
					<td class="td_label"><label><span class="red">*</span>中文全称:</label></td>
					<td><input class="easyui-validatebox" id="chineseFullname" value="${ent.chineseFullname}" data-options="required:true,validType:length[0,30]"></td>
					<td class="td_label"><label>*注册或登记证件类型:</label></td>
					<td>
						<div>
							<select id="registerIdentType" panelHeight="auto" class="easyui-combobox" data-options="panelHeight:'auto',editable:false,multiple:false">
								<c:forEach items="${selects.REGISTER_IDENT_TYPE}" var="type">
									<c:choose>
										<c:when test="${type.configCode==ent.registerIdentType}">
											<option value="${type.configCode}" selected="selected">${type.configName}</option>
										</c:when>
										<c:otherwise>
											<option value="${type.configCode}">${type.configName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td class="td_label"><label>中文简称:</label></td>
					<td><input class="easyui-validatebox" id="chineseName" value="${ent.chineseName}" data-options="validType:length[0,30]"></td>
					<td class="td_label"><label>*注册或登记证件号码:</label></td>
					<td><input class="easyui-validatebox" id="registerIdentNo" value="${ent.registerIdentNo}" data-options="validType:['registerIdentNo','length[0,40]']"></td>
				</tr>
				<tr>
					<td class="td_label"><label>英文全称:</label></td>
					<td><input class="easyui-validatebox" id="englishFullname" value="${ent.englishFullname}" data-options="validType:'englishFullName[128]'"></td>
					<td class="td_label"><label>*注册或批准成立日期:</label></td>
					<td><input class="easyui-datebox" id="registerDate" value="${ent.registerDate}" data-options="editable:false,validType:['registerDateA','registerDateB']"></td>
				</tr>
				<tr>
					<td class="td_label"><label>英文简称:</label></td>
					<td><input class="easyui-validatebox" id="englishName" value="${ent.englishName}" data-options="validType:'englishFullName[16]'"></td>
					<td class="td_label"><label>*注册或登记证件年检日期:</label></td>
					<td><input class="easyui-datebox" id="regCheckDate" value="${ent.regCheckDate}" data-options="editable:false,validType:'regCheckDate'"></td>
				</tr>
				<tr>
					<td class="td_label"><label>*注册国家或地区:</label></td>
					<td>
						<div>
							<select id="registerCountry" class="easyui-combobox" panelHeight="auto" data-options="editable:false">
								<c:forEach items="${countries}" var="country">
									<c:choose>
										<c:when test="${country.countryCode==ent.registerCountry}">
											<option value="${country.countryCode}" selected="selected">${country.cnName}</option>
										</c:when>
										<c:otherwise>
											<option value="${country.countryCode}">${country.cnName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</td>
					<td class="td_label"><label>*营业或有效期限起始日期:</label></td>
					<td><input class="easyui-datebox" id="busiStartDate" value="${ent.busiStartDate}" data-options="editable:false,validType:['busiStartDateA','busiStartDateB']"></td>
				</tr>
				<tr>
					<td class="td_label"><label>*注册地行政区划:</label></td>
					<td>
						<input id="provinceCode" class="easyui-combobox" value="${area[0].areaCode}" data-options="width:80,method:'post',url:'${ctx}/base/inent/getProvinceList',valueField:'areaCode',textField:'areaName',editable:false,multiple:false"> 
						<input id="cityCode" class="easyui-combobox" value="${area[1].areaCode}" data-options="width:80,method:'post',valueField:'areaCode',textField:'areaName',editable:false,multiple:false"> 
						<input id="countyCode" class="easyui-combobox" value="${area[2].areaCode}" data-options="width:80,method:'post',valueField:'areaCode',textField:'areaName',editable:false,multiple:false">
					</td>
					<td class="td_label"><label>*营业或有效期限终止日期:</label></td>
					<td><input class="easyui-datebox" id="busiEndDate" value="${ent.busiEndDate}" data-options="editable:false,validType:'busiEndDate'"></td>
				</tr>
				<tr>
					<td class="td_label"><label>*注册地址:</label></td>
					<td><input class="easyui-validatebox" id="address" value="${ent.address}" data-options="validType:'length[0,50]'"></td>
					<td class="td_label"><label>所属商圈:</label></td>
					<td>
						<div>
							<select id="groupCode" class="easyui-combobox" data-options="panelHeight:'auto',disabled:true,editable:false">
								<c:forEach items="${busGroups}" var="busGroup">
									<c:choose>
										<c:when test="${busGroup.busiGroupCode==ent.businessGroup.busiGroupCode}">
											<option value="${busGroup.busiGroupCode}" selected="selected">${busGroup.busiGroupName}</option>
										</c:when>
										<c:otherwise>
											<option value="${busGroup.busiGroupCode}">${busGroup.busiGroupName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td class="td_label"><label>*注册地城乡属性:</label></td>
					<td>
						<div>
							<select id="addressAttribute" class="easyui-combobox" data-options="panelHeight:'auto',editable:false">
								<c:forEach items="${selects.ADDRESS_ATTRIBUTE}" var="address">
									<c:choose>
										<c:when test="${address.configCode==ent.addressAttribute}">
											<option value="${address.configCode}" selected="selected">${address.configName}</option>
										</c:when>
										<c:otherwise>
											<option value="${address.configCode}">${address.configName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</td>
					<td class="td_label"><label><span class="red">*</span>企业法人代表姓名:</label></td>
					<td><input class="easyui-validatebox" id="corpName" value="${ent.corpName}" data-options="required:true,validType:'length[2,15]'"></td>
				</tr>
				<tr>
					<td class="td_label"><label>*单位类型:</label></td>
					<td>
						<div>
							<select id="entType" class="easyui-combobox" data-options="panelHeight:'auto',editable:false">
								<c:forEach items="${selects.ENT_TYPE}" var="type">
									<c:choose>
										<c:when test="${type.configCode==ent.entType}">
											<option value="${type.configCode}" selected="selected">${type.configName}</option>
										</c:when>
										<c:otherwise>
											<option value="${type.configCode}">${type.configName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</td>
					<td class="td_label"><label><span class="red">*</span>企业法人代表有效证件类型:</label></td>
					<td>
						<div>
							<select id="corpIdentType" class="easyui-combobox" data-options="panelHeight:'auto',required:true,editable:false,disabled:true">
								<c:forEach items="${selects.ENT_CORP_IDENT_TYPE}" var="type">
									<c:choose>
										<c:when test="${type.configCode==ent.corpIdentType}">
											<option value="${type.configCode}" selected="selected">${type.configName}</option>
										</c:when>
										<c:otherwise>
											<option value="${type.configCode}">${type.configName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td class="td_label"><label><span class="red">*</span>组织机构代码:</label></td>
					<td><input class="easyui-validatebox" id="orgCode" value="${ent.orgCode}" data-options="required:true,validType:['orgCodeA','orgCodeB']"></td><!--  -->
					<td class="td_label"><label><span class="red">*</span>企业法人代表有效证件号码:</label></td>
					<td><input class="easyui-validatebox" id="corpIdentNo" value="${ent.corpIdentNo}" data-options="required:true,validType:['id','idAgeLimit','idExist']"></td>
				</tr>
				<tr>
					<td class="td_label"><label>*组织机构代码年检日期:</label></td>
					<td><input class="easyui-datebox" id="checkDate" value="${ent.checkDate}" data-options="editable:false,validType:'checkDate'"></td>
					<td class="td_label"><label><span class="red">*</span>企业法人代表手机号:</label></td>
					<td><input class="easyui-validatebox" id="corpIdentMobile" value="${ent.corpIdentMobile}" data-options="required:true,validType:['checkPhoneNum']"></td>
				</tr>
				<tr>
					<td class="td_label"><label>公司规模：</label></td>
					<td>
						<div>
							<select class="easyui-combobox" id="entScale" data-options="panelHeight:'auto',editable:false">
								<c:forEach items="${selects.ENT_SCALE}" var="type">
									<c:choose>
										<c:when test="${type.configCode==ent.entScale}">
											<option value="${type.configCode}" selected="selected">${type.configName}</option>
										</c:when>
										<c:otherwise>
											<option value="${type.configCode}">${type.configName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</td>
					<td class="td_label"><label>归属行业:</label></td>
					<td><input id="tradeCode" data-options="value:'${ent.tradeCode}',editable:false"></td>
				</tr>
				<tr style="display: none">
					<td><input type="hidden" id="entNo" value="${ent.entNo}"></td>
				</tr>
			</table>
		</form>
		<div id="preview"></div>
		<table id="uploadForm" border="0" style="align:left;padding:0px;">
			<thead>
				<tr>
					<th style="text-align:center;width:20%;">类型</th>
					<th style="text-align:left;width:20%;">文件路径</th>
					<th style="text-align:left;width:20%;">文件名称</th>
					<th style="text-align:left;width:20%;">备注</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="text-align:right;padding:0px;">注册或登记证件:&nbsp;&nbsp;</td>
					<td style="text-align:left;padding:0px;"><span id="E1" type="file" fileName="" fileNail=""></span></td>
					<td style="text-align:left;padding:0px;">&nbsp;&nbsp;<b><span class="ui-file-name"></span></b></td>
					<td style="text-align:left;padding:0px;"><input class="easyui-validatebox" id="fileDescriptionE1" data-options="validType:length[0,100]"></td>
					<td style="text-align:left;padding:0px;">
						<a class="easyui-linkbutton" onclick="ajaxFileUpload('E1', 'img', fileUploadCallback,'');" href="#">上传</a> 
						<span id="uploadResultE1">&emsp;&emsp;&emsp;&emsp;&emsp;</span>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;padding:0px;">组织机构代码证:&nbsp;&nbsp;</td>
					<td style="text-align:left;padding:0px;"><span id="E2" type="file" fileName="" fileNail=""></span></td>
					<td style="text-align:left;padding:0px;">&nbsp;&nbsp;<b><span class="ui-file-name"></span></b></td>
					<td style="text-align:left;padding:0px;"><input class="easyui-validatebox" id="fileDescriptionE2"  data-options="validType:length[0,100]"></td>
					<td style="text-align:left;padding:0px;">
						<a class="easyui-linkbutton" onclick="ajaxFileUpload('E2', 'img', fileUploadCallback,'');">上传</a>
						<span id="uploadResultE2"></span>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;padding:0px;">企业法人代表授权书:&nbsp;&nbsp;</td>
					<td style="text-align:left;padding:0px;"><span id="E3" type="file" fileName="" fileNail=""></span></td>
					<td style="text-align:left;padding:0px;">&nbsp;&nbsp;<b><span class="ui-file-name"></span></b></td>
					<td style="text-align:left;padding:0px;"><input class="easyui-validatebox" id="fileDescriptionE3"  data-options="validType:length[0,100]"></td>
					<td style="text-align:left;padding:0px;">
						<a class="easyui-linkbutton" onclick="ajaxFileUpload('E3', 'img', fileUploadCallback,'');">上传</a>
						<span id="uploadResultE3"></span>
					</td>
				</tr>
				<!-- <tr>
					<td style="text-align:right;padding:0px;">企业法人代表有效证件:&nbsp;&nbsp;</td>
					<td style="text-align:left;padding:0px;"><span id="E4" type="file" fileName="" fileNail=""></span></td>
					<td style="text-align:left;padding:0px;">&nbsp;&nbsp;<b><span class="ui-file-name"></span></b></td>
					<td style="text-align:left;padding:0px;"><input class="easyui-validatebox" id="fileDescriptionE4"  data-options="validType:length[0,100]"></td>
					<td style="text-align:left;padding:0px;">
						<a class="easyui-linkbutton" onclick="ajaxFileUpload('E4', 'img', fileUploadCallback,'');">上传</a>
						<span id="uploadResultE4"></span>
					</td>
				</tr> -->
				<!-- <tr>
					<td>营业执照:</td>
					<td><span id="E5" type="file" fileName="" fileNail=""></span></td>
					<td><input class="easyui-validatebox" id="fileDescriptionE5" data-options="validType:length[0,100]"></td>
					<td>
						<a class="easyui-linkbutton" onclick="ajaxFileUpload('E5', 'img', fileUploadCallback,'');">上传</a>
						<span id="uploadResultE5"></span>
					</td>
				</tr> -->
				<tr>
					<td colspan="5" align="center"><a onclick="updateEnt()" class="easyui-linkbutton">更新</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<script type="text/javascript" src="${ctx}/static/js/pub/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/pub/jquery.form.min.js"></script>
	<script type="text/javascript">
		var CHINA_CODE = "156";	
		$(function() {
			
			var orgCodeValueChangeFlag = false;

			$('#registerCountry').combobox({
				onSelect : function() {
					if ($('#registerCountry').combobox('getValue') != CHINA_CODE) {
						$('#provinceCode').combobox('disable');
						$('#provinceCode').combobox('setValue', "");
						$('#cityCode').combobox('disable');
						$('#cityCode').combobox('setValue', "");
						$('#countyCode').combobox('disable');
						$('#countyCode').combobox('setValue', "");

					} else {
						$('#provinceCode').combobox('enable');
						$('#cityCode').combobox('enable');
						$('#countyCode').combobox('enable');
					}
				}
			});

			$('#provinceCode').combobox({
				onSelect : function(record) {
					$('#cityCode').combobox('clear');
					$('#cityCode').combobox('loadData', []);
					$('#countyCode').combobox('clear');
					$('#countyCode').combobox('loadData', []);
					if (isNull(record.areaCode)) {
						return;
					}
					$('#cityCode').combobox({
						value : '',
						method : 'post',
						url : '${ctx}/base/inent/getCityList/' + record.areaCode,
						valueField : 'areaCode',
						textField : 'areaName'
					});
					$('#cityCode').combobox('clear');
					$('#cityCode').combobox('loadData', []);
				}
			});

			$('#cityCode').combobox({
				onSelect : function(record) {
					if (isNull(record.areaCode)) {
						$('#countyCode').combobox('clear');
						$('#countyCode').combobox('loadData', []);
						return;
					}
					$('#countyCode').combobox({
						value : '',
						method : 'post',
						url : '${ctx}/base/inent/getCountyList/' + record.areaCode,
						valueField : 'areaCode',
						textField : 'areaName'
					});
				}
			});

			if ($('#registerCountry').combobox('getValue') != CHINA_CODE) {
				$('#provinceCode').combobox('disable');
				$('#provinceCode').combobox('setValue', "");
				$('#cityCode').combobox('disable');
				$('#cityCode').combobox('setValue', "");
				$('#countyCode').combobox('disable');
				$('#countyCode').combobox('setValue', "");
			} else {
				$('#provinceCode').combobox('enable');
				$('#provinceCode').attr("required", "required");
				$('#cityCode').combobox({
					method : 'post',
					url : '${ctx}/base/inent/getCityList/' + $('#provinceCode').combobox('getValue'),
					valueField : 'areaCode',
					textField : 'areaName'
				});
				$('#countyCode').combobox({
					method : 'post',
					url : '${ctx}/base/inent/getCountyList/' + $('#cityCode').combobox('getValue'),
					valueField : 'areaCode',
					textField : 'areaName'
				});
			}

			// --------------- 行业下拉框树  start ---------------
			$('#tradeCode').combotree({
				lines:true,
				checkbox: false,
				onBeforeExpand: function(node){
					if(!node || !node.id){
						return;
					}
					var tree = $('#tradeCode').combotree('tree');
					var children = tree.tree('getChildren', node.target);
					if(children==null || children.length==0){
						$.ajax({
							type : 'POST',
							async: false,
							url : '${ctx}/base/busiGroup/getSubTrades/'+node.id,
							success : function(data, status) {
								if(data && data.length>0){
									if(node){
										tree.tree('append', {
													parent: node.target,
													data: data
												});
									} else {
										tree.tree('loadData', data);
									}
								} else {
									// 没有子数据,则将展开图标去除,通过增加节点、删除节点实现
									var newId = '_i_am_temp_node_';
									tree.tree('append', {
										parent: node.target,
										data: [{
											id: newId,
											text: 'temp'
										}]
									});
									var newNode = tree.tree('find', newId);
									tree.tree('remove', newNode.target);
								}
							},
							error : function(data, status) {
								$.messager.alert('错误信息','获取行业分类数据失败！<br/>'+getJsonErrorMsg(data),'error');
							},
							datatype : "json"
						});
					}
				}
			});
			// 初始化第一条数据
			var tree = $('#tradeCode').combotree('tree');
			var tradeCode = $('#tradeCode').combobox('getValue');
			if(isNull(tradeCode)){
				$.ajax({
					type : 'POST',
					async: false,
					url : '${ctx}/base/busiGroup/getTrades',
					success : function(data, status) {
						tree.tree('loadData', data);
					},
					error : function(data, status) {
						$.messager.alert('错误信息','获取行业分类数据失败！<br/>'+getJsonErrorMsg(data),'error');
					},
					datatype : "json"
				});
			} else {
				$.ajax({
					type : 'POST',
					async: false,
					url : '${ctx}/base/busiGroup/getTreeForTrade/'+tradeCode,
					success : function(data, status) {
						tree.tree('loadData', data);
					},
					error : function(data, status) {
						$.messager.alert('错误信息','获取行业分类数据失败！<br/>'+getJsonErrorMsg(data),'error');
					},
					datatype : "json"
				});
				
				var treeNode = tree.tree('find', tradeCode);
				if(treeNode && treeNode.target){
					tree.tree('expandTo', treeNode.target);
				}
			}
			// --------------- 行业下拉框 END ---------------
			
			//初始化文件上传
			new IBankFileUpload(200);
			
			
			// 组织机构代码校验
			$('#orgCode').change(function(){
				if(orgCodeValueChangeFlag){
					return;
				}
				if(!isNull($('#orgCode').val())){
					enterpriseInfoByOrgCode = null;
					var orgCode = $('#orgCode').val();
					orgCode = orgCode.toUpperCase();// 转为大写字母
					orgCodeValueChangeFlag = true;
					$('#orgCode').val(orgCode);
					orgCodeValueChangeFlag = false;
					if(!$('#orgCode').validatebox('isValid')){
						return;
					}
					
					getEnterpriseInfoByOrgCode(orgCode);
					if(!isNull(enterpriseInfoByOrgCode)){
						$.messager.alert('提示信息','组织机构编号为['+orgCode+']的企业已经存在','info',function(){
							$('#orgCode').val('');
						});
					}
				}
			});
		});
		
		// 根据组织机构编号获取企业信息
		var enterpriseInfoByOrgCode = null;
		function getEnterpriseInfoByOrgCode(orgCode){
			$.ajax({
				type: 'POST',
				async: false,
				url: '${ctx}/base/busiGroup/getEnterpriseInfoByOrgCode/'+orgCode,
				success : function(data, status) {
					if(isNull(data) || isNull(data.orgCode) || data.orgCode!=orgCode){
						enterpriseInfoByOrgCode = null;
					} else {
						enterpriseInfoByOrgCode = data;
					}
				},
				error : function(data, status) {
					$.messager.show({
						title: '消息',
						msg: '根据组织机构编号查询企业信息失败！<br/>'+getJsonErrorMsg(data),
						timeout: 5000,
						showType:'slide'
					});
				},
				datatype : "json"
			});
		}

		//设置datebox格式 
		$.fn.datebox.defaults.formatter = function(date) {
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			var mf = (m < 10) ? "0" + m : m;
			var d = date.getDate();
			var df = (d < 10) ? "0" + d : d;
			return "" + y + mf + df;
		};

		function upload(type) {
			var fileForm = new FormData();
			fileForm.append("fileUpload", $("#fileUpload" + type).get(0).files[0]);//(fileUploadE1.files[0]);
			fileForm.append("entNo", $('#entNo').val());
			fileForm.append("fileType", $('#fileType' + type).val());
			fileForm.append("fileDescription", $('#fileDescription' + type).val());

			$.ajax({
				url : '${ctx}/base/userFile/upload',
				data : fileForm,
				datatype : 'text',
				type : 'POST',
				processData : false,
				contentType : false,
				success : function(data, status) {
					if (data.status == "SUCCESS") {
						$.messager.show({
							title : '消息',
							msg : '上传成功！',
							timeout : 5000,
							showType : 'slide'
						});
					} else {
						$.messager.alert('错误', data.result, 'error');
					}
				}
			});
		}
		
		//解析Ajax请求失败的json错误信息
		function getJsonErrorMsg(data){
			var errorMsg = '';
			if(data && data.responseText){
				errorMsg = (eval('('+data.responseText+')')).string;
			}
			return errorMsg;
		}

		//获取注册行政区划
		function getAreaCode() {
			var countyCode = $('#countyCode').combobox('getValue');
			if (isNull(countyCode)) {
				var cityCode = $('#cityCode').combobox('getValue');
				if (isNull(cityCode)) {
					return $('#provinceCode').combobox('getValue');
				}
				return cityCode;
			}
			return countyCode;
		}

		function updateEnt() {
 			if (!$('#baseDetail').form('validate'))
				return;
 			if ($('#registerCountry').combobox('getValue') == CHINA_CODE
 					&& $('#provinceCode').combobox('getValue') == "") {
 				$.messager.alert('error','请补充注册地行政区划信息！','error');
 				return;
 			}
 				

			$.ajax({
				url : '${ctx}/base/inent/update',
				type : 'POST',
				data : {
					entNo : $('#entNo').val(),
					chineseFullname : $('#chineseFullname').val(),
					registerIdentType : $('#registerIdentType').combobox('getValue'),
					chineseName : $('#chineseName').val(),
					registerIdentNo : $('#registerIdentNo').val(),
					englishFullname : $('#englishFullname').val(),
					registerDate : $('#registerDate').datebox('getValue'),
					englishName : $('#englishName').val(),
					regCheckDate : $('#regCheckDate').datebox('getValue'),
					registerCountry : $('#registerCountry').combobox('getValue'),
					areaCode : getAreaCode(),
					busiStartDate : $('#busiStartDate').datebox('getValue'),
					busiEndDate : $('#busiEndDate').datebox('getValue'),
					address : $('#address').val(),
					addressAttribute : $('#addressAttribute').combobox('getValue'),
					corpName : $('#corpName').val(),
					entType : $('#entType').combobox('getValue'),
					corpIdentType : $('#corpIdentType').combobox('getValue'),
					orgCode : $('#orgCode').val(),
					corpIdentNo : $('#corpIdentNo').val(),
					checkDate : $('#checkDate').datebox('getValue'),
					corpIdentMobile : $('#corpIdentMobile').val(),
					groupCode : $('#groupCode').combobox('getValue'),
					entScale : $('#entScale').combobox('getValue'),
					tradeCode : $('#tradeCode').combotree('getValue')
				},
				success : function(data, status) {
					if (data.status == "SUCCESS") {
						self.parent.showMessage({
							title : '消息',
							msg : '更新成功！',
							timeout : 5000,
							showType : 'slide'
						});
						self.parent.reloadTabGrid('客户基本信息查询', '#inEntTable');
						self.parent.closeTab('贷款信息');
						self.parent.closeCurrentTab();
					} else {
						$.messager.alert('错误', data.result, 'error');
					}
				}
			});
		}

		//校验规则
		$.extend($.fn.validatebox.defaults.rules, {
			maxLength : {
				validator : function(value, param) {
					// param[0]字符串类型: 1-数字英文字符, 2-中文字符
					if (param[0] == 2) {
						return countCharNum(value) <= param[1];
					} else {
						return value.length <= param[1];
					}
				},
				message : '最大长度为{1}个字符'
			},
			length : {
				validator : function(value, param) {
					return (value.length >= param[0] && value.length <= param[1]);
				},
				message : '长度为{0}至{1}个字符'
			},
			englishFullName : {
				validator : function(value, param) {
					// var p = new RegExp('^[\w]{1}[ \w,\(\)\x26.]{0,'+(param[0]-1)+'}$');
					var p = new RegExp('^[a-zA-Z0-9]{1}[ a-zA-Z0-9,\(\)\x26.]{0,' + (param[0] - 1) + '}$');
					return p.test(value);
				},
				message : '英文全称应为长度不超过{0}字符的英文字符串'
			},
			englishName : {
				validator : function(value, param) {
					// var p = new RegExp('^[!-~]{1}[ !-~]{0,'+(param[0]-1)+'}$');
					var p = new RegExp('^[a-zA-Z0-9]{1}[ a-zA-Z0-9,\(\)\x26.]{0,' + (param[0] - 1) + '}$');
					return p.test(value);
				},
				message : '英文简称应为长度不超过{0}字符的英文字符串'
			},
			registerIdentNo : {
				validator : function(value, param) {
					if ($('#registerIdentType').combobox('getValue') == '610005') {
						var p = new RegExp('^[a-zA-Z0-9]{13}([a-zA-Z0-9]{2})?$')
						return p.test(value);
					} else {
						return true;
					}
				},
				message : '当证件类型是营业执照时，注册或登记证件号码的长度是13或15位'
			},
			checkDate : {
				validator : function(value, param) {
					if (value && value > getCurrentDateStr()) {
						return false;
					}
					return true;
				},
				message : '组织机构代码年检日期不能为当前日期之后！'
			},
			registerDateA : {
				validator : function(value, param) {
					if (value && value > getCurrentDateStr()) {
						return false;
					}
					return true;
				},
				message : '注册或批准成立日期不能为当前日期之后！'
			},
			registerDateB : {
				validator : function(value, param) {
					// 必须这么做，否则可能因为busiStartDate还未初始化出现取值异常，导致js错误
					try {
						var busiStartDate = $('#busiStartDate').datebox('getValue');
						if (isNotNull(busiStartDate) && busiStartDate < value) {
							return false;
						}
					} catch (e) {
					}
					return true;
				},
				message : '注册批准成立日期不应晚于营业或有效期限起始日期！'
			},
			regCheckDate : {
				validator : function(value, param) {
					if (value && value > getCurrentDateStr()) {
						return false;
					}
					return true;
				},
				message : '注册或登记证件年检日期不能为当前日期之后！'
			},
			busiStartDateA : {
				validator : function(value, param) {
					if (value && value > getCurrentDateStr()) {
						return false;
					}
					return true;
				},
				message : '营业或有效期限起始日期不能为当前日期之后！'
			},
			busiStartDateB : {
				validator : function(value, param) {
					var registerDate = $('#registerDate').datebox('getValue');
					if (isNotNull(registerDate) && registerDate > value) {
						return false;
					}
					return true;
				},
				message : '营业或有效期限起始日期不应早于注册批准成立日期！'
			},
			busiEndDate : {
				validator : function(value, param) {
					var busiStartDate = $('#busiStartDate').datebox('getValue');
					if (isNotNull(busiStartDate) && busiStartDate > value) {
						return false;
					}
					return true;
				},
				message : '注册批准成立日期不应晚于营业或有效期限起始日期！'
			},
			checkPhoneNum : {
				validator : function(value, param) {
					var p = /^1[3|4|5|8][0-9]\d{8}$/;
					return p.test(value);
				},
				message : '请输入正确的手机号码！'
			},
			checkPhoneExist: {
				validator: function(value, param){
					var mobile = '${ent.corpIdentMobile}';
					if(mobile==$('#corpIdentMobile').val())
						return true;
					
					var result;
					$.ajax({
						async:false,
						type:'POST',
						url:'${ctx}/base/inent/checkMobile',
						data:{
							corpIdentMobile:$('#corpIdentMobile').val()
						},
						success:function(data,status){
							result = data;
						}
					});
					return result;
				},
				message: '手机号码已存在！'
			},
			orgCode : {
				validator : function(value, param) {
					var p = new RegExp('[^a-zA-Z0-9\-]');
					return !p.test(value);
				},
				message : '组织机构代码应为由字母、数字、中横线组成'
			},
			orgCodeA: {
				validator: function(value, param){
					var p = new RegExp('^[A-Z0-9]{8}-[0-9Xx]{1}$');
					return p.test(value);
				},
				message: '组织机构代码由数字或大写拉丁字母组成，格式应为A1234567-9'
			},
			orgCodeB: {
				validator: function(value, param){
					value = value.toUpperCase();
					// 加权因子
					var str = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ';
					var ws = [3, 7, 9, 10, 5, 8, 4, 2];
					var sum = 0;
					for (var i = 0; i < 8; i++) {
						sum += str.indexOf(value.charAt(i)) * ws[i];
					}
					var C9 = 11 - (sum % 11);
					var checkChar = value.slice(9);
					// 当C9的值为10时，校验码应用大写的拉丁字母X表示;当C9的值为11时校验码用0表示
					if(10 == C9){
						return ("X"==checkChar);
					} else if(11 == C9){
						return ("0"==checkChar);
					} else {
						return ((C9+'')==checkChar);
					}
				},
				message: '请输入正确的组织机构代码'
			},
			id : {
				validator : function(value) {
					return checkIdCardNo(value);
				},
				message : '身份证号码格式不正确'
			},
			idAgeLimit : {
				validator : function(value) {
					var birthday = 18;
					if(value.length == 15){
						birthday = "19" + value.substring(6, 12);
					} else if (value.length == 18) {
						birthday = value.substring(6, 14);
					}
					var adultDate=new Date();
					adultDate.setFullYear(parseInt(birthday.substring(0,4)) + 18,
							parseInt(birthday.substring(4,6)) - 1,birthday.substring(6));
					var today = new Date();
					if(adultDate>today)
						return false;
					return true;
				},
				message : '法人代表不能未满18周岁'
			},
			idExist : {
				validator: function(value, param){
					var id = '${ent.corpIdentNo}';
					if(id == $('#corpIdentNo').val())
						return true;
					
					var result;
					$.ajax({
						async:false,
						type:'POST',
						url:'${ctx}/base/inent/checkIdentNo',
						data:{
							entNo: $('#entNo').val(),
							identNo:$('#corpIdentNo').val()
						},
						success:function(data,status){
							result = data;
						}
					});
					return result;
				},
				message : '身份证号已被使用'
			}
		});

		var provinceAndCity = {
	 		11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
	 		33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",
	 		46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",
	 		65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"
	 	};
	 	//身份证前17位加权值
	 	var powers = ["7","9","10","5","8","4","2","1","6","3","7","9","10","5","8","4","2"];
	 	//身份证最后一位校验位
	 	var parityBit = ["1","0","X","9","8","7","6","5","4","3","2"];

	 	var genders = {male:"男",female:"女"};

	 	//判断身份证前6位地址
	 	function checkAddressCode(addressCode){
	 		var check = /^[1-9]\d{5}$/.test(addressCode);
	 		if(!check){
	 			return false;
	 		}
	 		if(provinceAndCity[parseInt(addressCode.substring(0,2))]){
	 			return true;
	 		}else{
	 			return false;
	 		}

	 	}
	 	//判断出生日期
	 	function checkBirthDayCode(birthDayCode){
	 		var check = /^[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))$/.test(birthDayCode);
	 		if(!check){return false;}
	 		var yyyy = parseInt(birthDayCode.substring(0,4),10);
	 		var mm = parseInt(birthDayCode.substring(4,6),10);
	 		var dd = parseInt(birthDayCode.substring(6),10);

	 		var xdate = new Date(yyyy,mm-1,dd);

	 		if(xdate > new Date()){
	 			return false; //生日不能大于当前日期
	 		}else if((xdate.getFullYear() == yyyy) && (xdate.getMonth() == mm-1) && (xdate.getDate() == dd)){
	 			return true;
	 		}else{
	 			return false;
	 		}
	 	}
	 	//根据身份证号码中的前17位，获取最后一位校验位的值
	 	function getParityBit(idCardNo){
	 		var id17 = idCardNo.substring(0,17);

	 		var power = 0;
	 		for(var i=0;i<17;i++){
	 			power += parseInt(id17.charAt(i),10)*parseInt(powers[i]);
	 		}

	 		var mod = power%11;
	 		return parityBit[mod];
	 	}
	 	//校验身份证最后一位
	 	function checkParityBit(idCardNo){
	 		var parityBit = idCardNo.charAt(17).toUpperCase();
	 		if(getParityBit(idCardNo) == parityBit){
	 			return true;
	 		}else{
	 			return false;
	 		}
	 	}
	 	//主函数 分别验证18 15位身份证
	 	function checkIdCardNo(idCardNo){
	 		//15位和18位身份证的基本校验
	 		var check = /^\d{15}|(\d{17}(\d|x|X))$/.test(idCardNo);
	 		if(!check){return false;}

	 		if(idCardNo.length == 15){
	 			return check15IdCardNo(idCardNo);
	 		}else if(idCardNo.length == 18){
	 			return check18IdCardNo(idCardNo);
	 		}else{
	 			return false;
	 		}
	 	}
	 	//验证15位身份证
	 	function check15IdCardNo(idCardNo){
	 		//基本验证
	 		var check = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}$/.test(idCardNo);
	 		if (!check){ return false; }
	 		//校验地址
	 		var addressCode = idCardNo.substring(0,6);
	 		check = checkAddressCode(addressCode);
	 		if(!check) {return false};
	 		//15位的身份证都是1999年前颁发，2000年后增至18位
	 		var birthDayCode = '19' +idCardNo.substring(6,12);
	 		//校验日期码
	 		return checkBirthDayCode(birthDayCode);
	 	}
	 	//验证18位身份证
	 	function check18IdCardNo(idCardNo){
	 		//基本格式校验
	 		var check = /^[1-9]\d{5}[1-2]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}(\d|x|X)$/.test(idCardNo);
	 		if(!check) {return false;}
	 		//校验地址码
	 		var addressCode = idCardNo.substring(0,6);
	 		check = checkAddressCode(addressCode);
	 		if(!check) {return false;}

	 		//验证校验码
	 		return checkParityBit(idCardNo);

	 	}
		//获取当前日期,格式'yyyyMMdd'
		function getCurrentDateStr() {
			var date = new Date();
			var monthPart = date.getMonth() + 1;
			if (monthPart < 10) {
				monthPart = "0" + monthPart;
			}
			var dayPart = date.getDate();
			if (dayPart < 10) {
				dayPart = "0" + dayPart;
			}
			return date.getFullYear() + "" + monthPart + dayPart;
		}
		//文件上传回调
		
		function fileUploadCallback(fileId, fileDesc, fileName, fileNail) {
			$.ajax({
				url : '${ctx}/base/userFile/upload',
				type : 'POST',
				data : {
					entNo : $('#entNo').val(),
					fileType : fileId,
					fileDescription : $('#fileDescription' + fileId).val(),
					fileName : fileDesc,
					filePath : fileName
				},
				success : function(data, status) {
					if (data.status == "SUCCESS") {
						$('#uploadResult' + fileId).replaceWith("上传成功！");
						
						
						$(".ui-file-name",$("#"+fileId).closest("tr")).text(fileDesc);
				 	} else {
						$.messager.alert('错误', data.result, 'error');
					}
				}
			});
		}
	</script>
</body>
</html>