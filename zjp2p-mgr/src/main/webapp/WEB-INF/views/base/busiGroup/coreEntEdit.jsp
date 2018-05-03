<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.zjgt.p2p.BaseConstant"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
</head>
<body>
<style type="text/css">
.blank_td {
	width: 10%;
}
.td_remark {
	text-align: left;
}
.td_name {
	text-align: right;
}
.td_button {
	text-align: left;
}
.span_required {
	color: red;
}
input[class="easyui-numberbox numberbox-f validatebox-text"] {
	text-align: right;
}
/* 去除tree图标 */
span[class^='tree-icon']{
	width: 0;
}

.td_label {
    padding-left:10px;
    width: 200px;
    height: 30px;
    text-align: right;
    font-size: 12px;
    nowrap: nowrap;
    color:#333;
    padding:0 5px;
    font-weight:bold;
}
</style>
<script type="text/javascript">
function viewImgFile(fileNo){
	if(isNull(fileNo)){
		if(isNull(fileNo)){
			$.messager.show({
				title: '消息',
				msg: '没有图片可供预览！',
				timeout: 5000,
				showType: 'slide'
			});
			return;
		}
		return;
	}
	// 创建图片层
	var box = self.parent.document.createElement("div");
	box.id = "_img_box_div";
	box.style.zIndex = "9999";
	box.style.display = "block";
	box.style.position = "absolute";
	self.parent.document.body.appendChild(box);
	// 创建背景层
	var layer = self.parent.document.createElement("div");
	layer = self.parent.document.createElement("div");
	layer.id = "_box_layer_div";
	layer.style.width = layer.style.height = "100%";
	layer.style.position = "absolute";
	layer.style.top = layer.style.left = 0;
	layer.style.backgroundColor = "#555";
	layer.style.zIndex = "9998";
	layer.style.opacity = "0.6";
	self.parent.document.body.appendChild(layer);
	var loadFlag = false;
	var img = $('<img />').attr("src", '${ctx}/base/file/download/'+fileNo+'/00').load(function(){
		loadFlag = true;
		//图片加载成功后，重新设置显示位置
		var left = (self.parent.document.body.clientWidth-this.width)/2;
		var top = (self.parent.document.body.clientHeight-this.height)/2;
		// 设置弹出层样式
		box.style.top = top>0 ? top+'px' : 0;
		box.style.left = left>0? left+'px' : 0;
		box.style.width = this.width;
		box.style.height = this.height;
		layer.style.width = self.parent.document.body.scrollWidth;
		layer.style.height = self.parent.document.body.scrollHeight;
		layer.style.backgroundColor = "#555";
	});
	if(!loadFlag){
		var left = (self.parent.document.body.clientWidth-img.get(0).width)/2;
		var top = (self.parent.document.body.clientHeight-img.get(0).height)/2;
		// 设置弹出层样式
		box.style.top = top>0 ? top+'px' : 0;
		box.style.left = left>0? left+'px' : 0;
		box.style.width = img.get(0).width;
		box.style.height = img.get(0).height;
		layer.style.width = self.parent.document.body.scrollWidth;
		layer.style.height = self.parent.document.body.scrollHeight;
		layer.style.backgroundColor = "#555";
	}
	box.appendChild(img.get(0));

	// 绑定点击关闭方法
	self.parent.$('#_box_layer_div').bind('click', function(){
		self.parent.$('#_img_box_div').remove();
		self.parent.$('#_box_layer_div').remove();
	});
	img.bind('click', function(){
		self.parent.$('#_img_box_div').remove();
		self.parent.$('#_box_layer_div').remove();
	});
}

function downloadFile(fileNo){
	if(isNull(fileNo)){
		return;
	}
	// fireFox由于安全限制，不允许模拟点击动作
	// $('<a target="_blank" href="${ctx}/base/busiGroup/download/'+fileNo+'"></a>').get(0).click();
	location.href='${ctx}/base/file/download/'+fileNo+'/00';
}

function deleteFile(fileNo, postfixStr){
	var value = $('#_deleteStatus'+postfixStr).val();
	if(value=='1'){
		$('#_deleteStatus'+postfixStr).val('0');
		$('#_deleteBtn'+postfixStr).linkbutton({
			text: '删除'
		});
	} else {
		$('#_deleteStatus'+postfixStr).val('1');
		cancelChange(fileNo, postfixStr);
		$('#_deleteBtn'+postfixStr).linkbutton({
			text: '取消删除'
		});
	}
}

function cancelChange(fileNo, postfixStr){
	$('#_filedata'+postfixStr).val('');
	if(!isNull($('#_filedata'+postfixStr).val())){
		var file = $('#_filedata'+postfixStr);
		file.after(file.clone().val(''));
		file.remove();
	}
	$('#_cancelChangeBtn'+postfixStr).attr('style', 'display:none');
	if(postfixStr=='_E0_0_0'){
		$('#_fileStatus_E0_0_0').combobox('setValue', '');
	}
}

function changehandler(postfixStr, required, fileNo) {
	var localfile = $('#_filedata'+postfixStr).val();
	if(!checkFile($('#_filedata'+postfixStr).get(0))){
		$('#_filedata'+postfixStr).val('');
		if(!isNull($('#_filedata'+postfixStr).val())){
			var file = $('#_filedata'+postfixStr);
			file.after(file.clone().val(''));
			file.remove();
		}
	} else if(isNull(localfile)){
		$('#_cancelChangeBtn'+postfixStr).attr('style', 'display:none');
	} else if(!required && !isNull(fileNo)) {
		// 如果是必要的文件、且文件从未上传，则不允许取消
		$('#_cancelChangeBtn'+postfixStr).attr('style', '');
	}
}
</script>
	<div>
		<div>
			<div style="padding-top: 20px;">
				<p style="text-align: center;">
					<span style="font-size: 16px; font-weight: bold; font-style: normal;">修改核心企业商圈信息</span>
				</p>
			</div>
		</div>
	</div>
	<div style="width:30px;">
	</div>
	<form id="coreEntEditForm" method="post">
		<table style="width: 100%;height:100%" border="0" cellpadding="2" cellspacing="3" align="center">
			<tbody>
				<tr>
					<td colspan="6" style="align:'left'">
						<p>
							<span style="font-size: 15px;font-style: normal;">商圈信息</span>
						</p>
					</td>
				</tr>
				<tr>
					<td colspan="6"><hr /></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="busiGroupCode">商圈代码:</label>
					</td>
					<td class="td_input">
						<input id="busiGroupCode" class="easyui-validatebox" disabled="disabled" value="${busiGroup.busiGroupCode}" />
					</td>
					<td class="td_label">
						<label for="busiGroupName"><span class="span_required">*</span>商圈名称:</label>
					</td>
					<td class="td_input">
						<input id="busiGroupName" class="easyui-validatebox" 
							data-options="required:true,validType:['maxLength[1, 60]']" value="${busiGroup.busiGroupName}" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label"><a id="tradeCode_REF" href="#tradeCode_REF" ></a>
						<label for="tradeCode"><span class="span_required">*</span>归属行业:</label>
					</td>
					<td class="td_input">
						<input id="tradeCode" class="easyui-combotree" data-options="value:'${busiGroup.tradeCode}',panelWidth:250,panelHeight:280,multiple:false,required:true">
					</td>
					<td class="td_label">
						<label for="listFlag">是否上市企业:</label>
					</td>
					<td class="td_input">
						<input id="listFlag" class="easyui-combobox" data-options="value:'${busiGroup.listFlag}',panelHeight:'auto',multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_ENT_LIST_FLAG%>'">
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label"><a id="qualityCredit_REF" href="#qualityCredit_REF" ></a>
						<label for="qualityCredit">信用质量:</label>
					</td>
					<td class="td_input">
						<input id="qualityCredit" class="easyui-combobox" data-options="value:'${busiGroup.qualityCredit}',multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_LN_DIC_DDIRBCDRATE%>'">
					</td>
					<td class="td_label"><a id="abilityPayable_REF" href="#abilityPayable_REF" ></a>
						<label for="abilityPayable">偿债能力:</label>
					</td>
					<td class="td_input">
						<input id="abilityPayable" class="easyui-combobox" data-options="value:'${busiGroup.abilityPayable}',panelHeight:'auto',multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_LN_DIC_DDDEBTABILITY%>'">
					</td>
					<td class="blank_td"></td>
				</tr>
                <tr>
                    <td class="blank_td"></td>
                    <td class="td_label">
                        <label for="coreEntSaleAmtPerYear">近一年核心企业年销售收入(百万元):</label>
                    </td>
                    <td class="td_input">
                        <input id="coreEntSaleAmtPerYear" type="text" class="easyui-numberbox"
                            data-options="required:false,value:0,min:0,max:999999.99,precision:2,groupSeparator:','" value="${busiGroup.coreEntSaleAmtPerYear}"/>
                    </td>
                    <td class="td_label">
                        <label for="coreEntSaleGrowthRate">近一年核心企业销售增长率(%):</label>
                    </td>
                    <td class="td_input">
	                    <input id="coreEntSaleGrowthRate" type="text" class="easyui-numberbox" value="${busiGroup.coreEntSaleGrowthRate}"
                            data-options="required:false,value:0,min:0,max:100,precision:2,groupSeparator:','" />
                    </td>
                    <td class="blank_td"></td>
                </tr>
                <tr>
                    <td class="blank_td"></td>
                    <td class="td_label">
                        <label for="saleGrossProfitRate">近一年核心企业销售毛利率(%):</label>
                    </td>
                    <td class="td_input">
	                    <input id="saleGrossProfitRate" type="text" class="easyui-numberbox" value="${busiGroup.saleGrossProfitRate}"
                            data-options="required:false,value:0,min:0,max:100,precision:2,groupSeparator:','" />
                    </td>
                    <td class="td_label">
                        <label for="assetLiabRate">近一年核心企业资产负债率(%):</label>
                    </td>
                    <td class="td_input">
                        <input id="assetLiabRate" type="text" class="easyui-numberbox" value="${busiGroup.assetLiabRate}"
                            data-options="required:false,value:0,min:0,max:100,precision:2,groupSeparator:','" />
                    </td>
                    <td class="blank_td"></td>
                </tr>
				<tr style="height:30px;">
					<td><input id="headEntNo" type="hidden" value="${headEntNo}" /> </td>
				</tr>
				<tr>
					<td colspan="6" style="align:'left'">
						<p>
							<span style="font-size: 15px;font-style: normal;">受托支付账户</span>
						</p>
					</td>
				</tr>
				<tr>
					<td colspan="6"><hr /></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>收款账户开户行名称:</label>
					</td>
					<td class="td_input">
						<input id="coreEntAcctInst" class="easyui-validatebox" data-options="validType:['maxLength[1,30]','coreEntAcctInst[]']"
							value="${busiGroup.coreEntAcctInst}" />
					</td>
					<td class="td_label">
						<label><span class="span_required">*</span>收款账号:</label>
					</td>
					<td class="td_input">
						<input id="coreEntAcct" maxlength="18" class="easyui-validatebox" data-options="required:true,validType:['maxLength[1,32]','coreEntAcctA[]','coreEntAcctB[]']"
							value="${busiGroup.coreEntAcct}" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr style="height:30px;">
					<td></td>
				</tr>
				<tr>
					<td colspan="6" style="align:'left'">
						<p>
							<span style="font-size: 15px;font-style: normal;">客户基本信息</span>
						</p>
					</td>
				</tr>
				<tr>
					<td colspan="6"><hr /></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="chineseFullname"><span class="span_required">*</span>中文全称:</label>
					</td>
					<td class="td_input">
						<input id="chineseFullname" class="easyui-validatebox" data-options="required:true,validType:['maxLength[1,30]']"
							value="${coreEnt.chineseFullname}" />
					</td>
					<td class="td_label"><a id="registerIdentType_REF" href="#registerIdentType_REF" ></a>
						<label for="registerIdentType"><span class="span_required">*</span>注册或登记证件类型:</label>
					</td>
					<td class="td_input">
						<input id="registerIdentType" class="easyui-combobox" 
							data-options="value:'${coreEnt.registerIdentType}',panelHeight:'auto',multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_REGISTER_IDENT_TYPE%>'">
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="chineseName">中文简称:</label>
					</td>
					<td class="td_input">
						<input id="chineseName" class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,5]']"
							value="${coreEnt.chineseName}" />
					</td>
					<td class="td_label">
						<label for="registerIdentNo"><span class="span_required">*</span>注册或登记证件号码:</label>
					</td>
					<td class="td_input">
						<input id="registerIdentNo" class="easyui-validatebox" value="${coreEnt.registerIdentNo}"
						data-options="required:true,validType:['maxLength[1,18]','registerIdentNo[]']" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="englishFullname">英文全称:</label>
					</td>
					<td class="td_input">
						<input id="englishFullname" class="easyui-validatebox" value="${coreEnt.englishFullname}"
							data-options="required:false,validType:['englishFullName[100]']" />
					</td>
					<td class="td_label"><a id="registerCountry_REF" href="#registerCountry_REF" ></a>
						<label for="registerCountry"><span class="span_required">*</span>注册国家或地区:</label>
					</td>
					<td class="td_input">
						<input id="registerCountry" class="easyui-combobox" data-options="value:'${coreEnt.registerCountry}',multiple:false,valueField:'countryCode',textField:'cnName',type:'post',url:'${ctx}/base/busiGroup/getCountrys'">
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="englishName">英文简称:</label>
					</td>
					<td class="td_input">
						<input id="englishName" class="easyui-validatebox" data-options="required:false,validType:['englishName[15]']"
							value="${coreEnt.englishName}" />
					</td>
					<td class="td_label"><a id="areaCode_REF" href="#areaCode_REF"></a>
						<label for="areaCode"><span class="span_required">*</span>注册地行政区划:</label>
					</td>
					<td class="td_input" colspan="2">
						<input id="areaCodeProvince" class="easyui-combobox" value="${areaCodeProvince.areaCode}"
							data-options="multiple:false,editable:false,width:80,method:'post',url:'${ctx}/base/busiGroup/getProvinceList',valueField:'areaCode',textField:'areaName'">
						<input id="areaCodeCity" class="easyui-combobox" value="${areaCodeCity.areaCode}"
							data-options="multiple:false,editable:false,width:80,method:'post',valueField:'areaCode',textField:'areaName'">
						<input id="areaCodeCounty" class="easyui-combobox" value="${areaCodeCounty.areaCode}"
							data-options="multiple:false,editable:false,width:80,method:'post',valueField:'areaCode',textField:'areaName'">
					</td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label"><a id="entType_REF" href="#entType_REF"></a>
						<label for="entType"><span class="span_required">*</span>单位类型:</label>
					</td>
					<td class="td_input">
						<input id="entType" class="easyui-combobox" 
							data-options="value:'${coreEnt.entType}',panelHeight:'auto',multiple:false,required:true,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_ENT_TYPE%>'">
					</td>
					<td class="td_label">
						<label for="address">注册地址:</label>
					</td>
					<td class="td_input">
						<input id="address" class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,30]']"
							value="${coreEnt.address}" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="checkDate"><span class="span_required">*</span>组织机构代码年检日期:</label>
					</td>
					<td class="td_input">
						<input id="checkDate" type="text" class="easyui-datebox"
							data-options="required:true,editable:false,validType:['checkDate[]']" value="${coreEnt.checkDate}" />
					</td>
					<td class="td_label"><a id="addressAttribute_REF" href="#addressAttribute_REF"></a>
						<label for="addressAttribute"><span class="span_required">*</span>注册地城乡属性:</label>
					</td>
					<td class="td_input">
						<input id="addressAttribute" class="easyui-combobox" 
							data-options="value:'${coreEnt.addressAttribute}',panelHeight:'auto',multiple:false,required:true,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_ADDRESS_ATTRIBUTE%>'">
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="registerDate"><span class="span_required">*</span>注册或批准成立日期:</label>
					</td>
					<td class="td_input">
						<input id="registerDate" type="text" class="easyui-datebox" required="required" 
							data-options="editable:false,validType:['registerDateA[]','registerDateB[]']" value="${coreEnt.registerDate}" />
					</td>
					<td class="td_label">
					    <label for="email"><span class="span_required">*</span>企业邮箱:</label>
					</td>
					<td class="td_input">
					<input id="email" type="text" class="easyui-validatebox" required="required" 
                             value="${coreEnt.email}" data-options="required:true,validType:'email'" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="regCheckDate"><span class="span_required">*</span>注册或登记证件年检日期:</label>
					</td>
					<td class="td_input">
						<input id="regCheckDate" type="text" class="easyui-datebox" required="required"
							data-options="editable:false,validType:['regCheckDate[]']"value="${coreEnt.regCheckDate}" />
					</td>
					<td class="td_label">
						<label for="orgCode"><span class="span_required">*</span>组织机构代码:</label>
					</td>
					<td class="td_input">
						<input id="orgCode" class="easyui-validatebox" data-options="required:true,validType:['orgCodeA[]','orgCodeB[]','maxLength[1,20]']"
							value="${coreEnt.orgCode}" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="busiStartDate"><span class="span_required">*</span>营业或有效期限起始日期:</label>
					</td>
					<td class="td_input">
						<input id="busiStartDate" type="text" class="easyui-datebox" required="required"
							data-options="editable:false,validType:['busiStartDateA[]','busiStartDateB[]']" value="${coreEnt.busiStartDate}" />
					</td>
					<td class="td_label"><a id="corpIdentType_REF" href="#corpIdentType_REF"></a>
						<label for="corpIdentType"><span class="span_required">*</span>企业法人代表有效证件类型:</label>
					</td>
					<td class="td_input">
						<input id="corpIdentType" class="easyui-combobox" 
							data-options="value:'${coreEnt.corpIdentType}',panelHeight:'auto',multiple:false,required:true,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_ENT_CORP_IDENT_TYPE%>'">
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="busiEndDate"><span class="span_required">*</span>营业或有效期限终止日期:</label>
					</td>
					<td class="td_input">
						<input id="busiEndDate" type="text" class="easyui-datebox" required="required"
							data-options="editable:false,validType:['busiEndDate[]']" value="${coreEnt.busiEndDate}" />
					</td>
					<td class="td_label">
						<label for="corpIdentNo"><span class="span_required">*</span>企业法人代表有效证件号码:</label>
					</td>
					<td class="td_input">
						<input id="corpIdentNo" class="easyui-validatebox" data-options="required:true,validType:['corpIdentNoA[]','corpIdentNoB[]','maxLength[1,32]']"
							value="${coreEnt.corpIdentNo}" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="corpName"><span class="span_required">*</span>企业法人代表姓名:</label>
					</td>
					<td class="td_input">
						<input id="corpName" class="easyui-validatebox" data-options="required:true,validType:['corpName[]','maxLength[1,30]']"
							value="${coreEnt.corpName}" />
					</td>
					<td class="td_label">
						<label for="corpIdentMobile"><span class="span_required">*</span>企业法人代表手机号:</label>
					</td>
					<td class="td_input">
						<input id="corpIdentMobile" class="easyui-validatebox" data-options="required:true,validType:['maxLength[1,11]','checkPhoneNum[]']"
							value="${coreEnt.corpIdentMobile}" />
					</td>
					<td class="blank_td"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<form id="coreEntFileEditForm" style="margin: 0px" enctype="multipart/form-data" method="post">
		<table id="fileTable" style="width: 100%;height:100%" border="0" cellpadding="2" cellspacing="3" align="center">
			<tbody>
				<tr>
					<td colspan="5"><hr /></td>
				</tr>
				<tr>
					<td align="center">名称</td>
					<td class="td_file" align="center">本次新增或修改文件路径</td>
					<td class="td_button">操作</td>
					<td class="td_fileStatus">状态</td>
					<td class="td_remark">备注</td>
				</tr>
				<tr>
					<td class="td_name">
						<a id="_filedata_E1_1_${e1File.fileNo}_REF" href="#_filedata_E1_1_${e1File.fileNo}_REF"></a>
						<label><span class="span_required">*</span>注册或登记证件:</label>
					</td>
					<td class="td_file">
						<input type="file" value="" id="_filedata_E1_1_${e1File.fileNo}" name="_filedata_E1_1_${e1File.fileNo}"
							accept="image/*" required="required" onchange="javascript:changehandler('_E1_1_${e1File.fileNo}', true, '${e1File.fileNo}')" />
					</td>
					<td class="td_button">
						<a onclick="javascript:viewImgFile('${e1File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${e1File.filePath}')" class="easyui-linkbutton">下载</a>
						<a id="_cancelChangeBtn_E1_1_${e1File.fileNo}" style="display:none"
							onclick="javascript:cancelChange('${e1File.fileNo}', '_E1_1_${e1File.fileNo}')" class="easyui-linkbutton">取消修改</a>
					</td>
					<td class="td_fileStatus">
						<input id="_fileStatus_E1_1_${e1File.fileNo}" name="_fileStatus_E1_1_${e1File.fileNo}"
							class="easyui-combobox" value="${e1File.fileStatus}" disabled="disabled" data-options="required:false"/>
					</td>
					<td class="td_remark">
						<input id="_remark_E1_1_${e1File.fileNo}" name="_remark_E1_1_${e1File.fileNo}"
							class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,200]']" value="${e1File.description}" />
					</td>
				</tr>
				<tr>
					<td class="td_name">
						<a id="_filedata_E2_1_${e2File.fileNo}_REF" href="#_filedata_E2_1_${e2File.fileNo}_REF"></a>
						<label><span class="span_required">*</span>组织机构代码证:</label>
					</td>
					<td class="td_file">
						<input type="file" id="_filedata_E2_1_${e2File.fileNo}" name="_filedata_E2_1_${e2File.fileNo}"
							accept="image/*" required="required"  onchange="javascript:changehandler('_E2_1_${e2File.fileNo}', true, '${e2File.fileNo}')" />
					</td>
					<td class="td_button">
						<a onclick="javascript:viewImgFile('${e2File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${e2File.filePath}')" class="easyui-linkbutton">下载</a>
						<a  id="_cancelChangeBtn_E2_1_${e2File.fileNo}" style="display:none"
							onclick="javascript:cancelChange('${e2File.fileNo}', '_E2_1_${e2File.fileNo}')" class="easyui-linkbutton">取消修改</a>
					</td>
					<td class="td_fileStatus">
						<input id="_fileStatus_E2_1_${e2File.fileNo}" name="_fileStatus_E2_1_${e2File.fileNo}"
							class="easyui-combobox" value="${e2File.fileStatus}" disabled="disabled" data-options="required:false"/>
					</td>
					<td class="td_remark">
						<input id="_remark_E2_1_${e2File.fileNo}" name="_remark_E2_1_${e2File.fileNo}"
							class="easyui-validatebox"data-options="required:false,validType:['maxLength[1,200]']" value="${e2File.description}" />
					</td>
				</tr>
				<tr>
					<td class="td_name">
						<a id="_filedata_E3_1_${e3File.fileNo}_REF" href="#_filedata_E3_1_${e3File.fileNo}_REF" ></a>
						<label>企业法人代表授权书:</label>
					</td>
					<td class="td_file">
						<input type="file" value="" id="_filedata_E3_1_${e3File.fileNo}" name="_filedata_E3_1_${e3File.fileNo}"
							accept="image/*" required="required"  onchange="javascript:changehandler('_E3_1_${e3File.fileNo}', true, '${e3File.fileNo}')" />
					</td>
					<td class="td_button">
						<a onclick="javascript:viewImgFile('${e3File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${e3File.filePath}')" class="easyui-linkbutton">下载</a>
						<a id="_cancelChangeBtn_E3_1_${e3File.fileNo}" style="display:none"
							onclick="javascript:cancelChange('${e3File.fileNo}', '_E3_1_${e3File.fileNo}')" class="easyui-linkbutton">取消修改</a>
					</td>
					<td class="td_fileStatus">
						<input id="_fileStatus_E3_1_${e3File.fileNo}" name="_fileStatus_E3_1_${e3File.fileNo}"
							class="easyui-combobox" value="${e3File.fileStatus}" disabled="disabled" data-options="required:false"/>
					</td>
					<td class="td_remark">
						<input id="_remark_E3_1_${e3File.fileNo}" name="_remark_E3_1_${e3File.fileNo}"
							class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,200]']" value="${e3File.description}" />
					</td>
				</tr>
				<!--  
				<tr>
					<td class="td_name">
						<a id="_filedata_P1_1_${p1File.fileNo}_REF" href="#_filedata_P1_1_${p1File.fileNo}_REF"></a>
						<label>企业法人代表有效证件:</label>
					</td>
					<td class="td_file">
						<input type="file" id="_filedata_P1_1_${p1File.fileNo}" name="_filedata_P1_1_${p1File.fileNo}"
							accept="image/*" required="required" onchange="javascript:changehandler('_P1_1_${p1File.fileNo}', true, '${p1File.fileNo}')" />
					</td>
					<td class="td_button">
						<a onclick="javascript:viewImgFile('${p1File.fileNo}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${p1File.fileNo}')" class="easyui-linkbutton">下载</a>
						<a id="_cancelChangeBtn_P1_1_${p1File.fileNo}" style="display:none"
							onclick="javascript:cancelChange('${p1File.fileNo}', '_P1_1_${p1File.fileNo}')" class="easyui-linkbutton">取消修改</a>
					</td>
					<td class="td_fileStatus">
						<input id="_fileStatus_P1_1_${p1File.fileNo}" name="_fileStatus_P1_1_${p1File.fileNo}"
							class="easyui-combobox" value="${p1File.fileStatus}" disabled="disabled" data-options="required:false"/>
					</td>
					<td class="td_remark">
						<input id="_remark_P1_1_${p1File.fileNo}" name="_remark_P1_1_${p1File.fileNo}"
							class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,200]']" value="${p1File.description}"/>
					</td>
				</tr>
				-->
				<c:forEach items="${e0FileList}" var="e0File">
				<tr>
					<td class="td_name">
						<a id="_filedata_E0_1_${e0File.fileNo}_REF" href="#_filedata_E0_1_${e0File.fileNo}_REF"></a>
						<label>其他文件:</label>
					</td>
					<td class="td_file">
						<input type="file" value="" id="_filedata_E0_1_${e0File.fileNo}" name="_filedata_E0_1_${e0File.fileNo}"
							accept="image/*" onchange="javascript:changehandler('_E0_1_${e0File.fileNo}', false, '${e0File.fileNo}')" />
					</td>
					<td class="td_button">
						<a onclick="javascript:viewImgFile('${e0File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${e0File.filePath}')" class="easyui-linkbutton">下载</a>
						<a id="_deleteBtn_E0_1_${e0File.fileNo}" onclick="javascript:deleteFile('${e0File.fileNo}', '_E0_1_${e0File.fileNo}')"
							class="easyui-linkbutton">删除</a>
						<a id="_cancelChangeBtn_E0_1_${e0File.fileNo}" style="display:none"
							onclick="javascript:cancelChange('${e0File.fileNo}', '_E0_1_${e0File.fileNo}')" class="easyui-linkbutton">取消修改</a>
					</td>
					<td class="td_fileStastus">
						<input id="_fileStatus_E0_1_${e0File.fileNo}" name="_fileStatus_E0_1_${e0File.fileNo}"
							class="easyui-combobox" value="${e0File.fileStatus}" disabled="disabled" data-options="required:false" />
					</td>
					<td class="td_remark">
						<input id="_remark_E0_1_${e0File.fileNo}" name="_remark_E0_1_${e0File.fileNo}"
							class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,200]']" />
						<input type="text" id="_deleteStatus_E0_1_${e0File.fileNo}" name="_deleteStatus_E0_1_${e0File.fileNo}"
							 value="0" style="display:none;"/>
					</td>
				</tr>
				</c:forEach>
				<tr>
					<td class="td_name">
						<a id="_filedata_E0_0_0_REF" href="#_filedata_E0_0_0_REF"></a>
						<label>其他文件(本次新增):</label>
					</td>
					<td class="td_file">
						<input type="file" value="" id="_filedata_E0_0_0" name="_filedata_E0_0_0"
							onchange="javascript:changehandler('_E0_0_0', false, '0')"/>
					</td>
					<td class="td_button">
						<a id="anotherOneBtn" class="easyui-linkbutton">添加文件</a>
						<a id="_cancelChangeBtn_E0_0_0" style="display:none"
							onclick="javascript:cancelChange('0', '_E0_0_0')" class="easyui-linkbutton">取消</a>
					</td>
					<td class="td_fileStatus">
						<input id="_fileStatus_E0_0_0" name="_fileStatus_E0_0_0"
							value="" class="easyui-combobox" disabled="disabled" data-options="required:false" />
					</td>
					<td class="td_remark">
						<input id="_remark_E0_0_0" name="_remark_E0_0_0"
							class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,200]']" />
					</td>
				</tr>
				<tr id="appendBeforeMe"></tr>
			</tbody>
		</table>
		<input type="text" name="_entNoForFiles" id="_entNoForFiles" style="display:none;" value="${coreEnt.entNo}" />
	</form>
	<table style="width: 100%;height:100%" border="0" cellpadding="2" cellspacing="3" align="center">
		<tbody>
			<tr><td><hr /></td></tr>
			<tr>
				<td align="center">
					<a id="submitBtn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">提交</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a id="backBtn" class="easyui-linkbutton" data-options="iconCls:'icon-back'">取消</a>
				</td>
			</tr>
		</tbody>
	</table>
	<div id="imgDialog">
		<div style="text-align:center;">
			<img id="_img" src="" style="display:none;"></img>
		</div>
	</div>
<script type="text/javascript">
// 类型代码
$('#email').validatebox({    
    validType:['email']
});

// 身份证
var IDENT_TYPE = '<%=BaseConstant.IDENTT_TYPE%>';
//计算字符串长度,中文按照3个字符计算
function countCharNum(str){
	if(str==null){
		return 0;
	}
	return str.replace(/([^\x00-\xff])/g,'aaa').length;
}
//校验规则
$.extend($.fn.validatebox.defaults.rules, {
	maxLength: {
		validator: function(value, param){
			// param[0]字符串类型: 1-数字英文字符, 2-中文字符
			if(param[0]==2){
				return countCharNum(value) <= param[1];
			} else {
				return value.length <= param[1];
			}
		},
		message: '最大长度为{1}个字符'
	},
	length: {
		validator: function(value, param){
			return (value.length >= param[0] && value.length <= param[1]);
		},
		message: '长度为{0}至{1}个字符'
	},
	englishFullName: {
		validator: function(value, param){
			// var p = new RegExp('^[\w]{1}[ \w,\(\)\x26.]{0,'+(param[0]-1)+'}$');
			var p = new RegExp('^[a-zA-Z0-9]{1}[ a-zA-Z0-9,\(\)\x26._-]{0,'+(param[0]-1)+'}$');
			return p.test(value);
		},
		message: '英文全称应为长度不超过{0}字符的英文字符串'
	},
	englishName: {
		validator: function(value, param){
			// var p = new RegExp('^[!-~]{1}[ !-~]{0,'+(param[0]-1)+'}$');
			var p = new RegExp('^[a-zA-Z0-9]{1}[ a-zA-Z0-9,\(\)\x26._-]{0,'+(param[0]-1)+'}$');
			return p.test(value);
		},
		message: '英文简称应为长度不超过{0}字符的英文字符串'
	},
	registerIdentNo: {
		validator: function(value, param){
			if($('#registerIdentType').combobox('getValue')=='<%=BaseConstant.REGISTER_IDENT_TYPE_BUSI_LICENSE%>'){
				var p = new RegExp('[^a-zA-Z0-9]');
				return ((value.length==13 || value.length==15) && !p.test(value) );
			} else {
				return true;
			}
		},
		message: '营业执照号码应由数字或英文字母组成，长度13位或15位'
	},
	checkDate: {
		validator: function(value, param){
			if(value && value>getCurrentDateStr()){
				return false;
			}
			return true;
		},
		message: '组织机构代码年检日期不能为当前日期之后！'
	},
	registerDateA: {
		validator: function(value, param){
			if(value && value>getCurrentDateStr()){
				return false;
			}
			return true;
		},
		message: '注册或批准成立日期不能为当前日期之后！'
	},
	registerDateB: {
		validator: function(value, param){
			// 必须这么做，否则可能因为busiStartDate还未初始化出现取值异常，导致js错误
			try {
				var busiStartDate = $('#busiStartDate').datebox('getValue');
				if(isNotNull(busiStartDate) && busiStartDate<value){
					return false;
				}
			} catch(e) {
			}
			return true;
		},
		message: '注册批准成立日期不应晚于营业或有效期限起始日期！'
	},
	regCheckDate: {
		validator: function(value, param){
			if(value && value>getCurrentDateStr()){
				return false;
			}
			return true;
		},
		message: '注册或登记证件年检日期不能为当前日期之后！'
	},
	busiStartDateA: {
		validator: function(value, param){
			if(value && value>getCurrentDateStr()){
				return false;
			}
			return true;
		},
		message: '营业或有效期限起始日期不能为当前日期之后！'
	},
	busiStartDateB: {
		validator: function(value, param){
			var registerDate = $('#registerDate').datebox('getValue');
			if(isNotNull(registerDate) && registerDate>value){
				return false;
			}
			return true;
		},
		message: '营业或有效期限起始日期不应早于注册批准成立日期！'
	},
	busiEndDate: {
		validator: function(value, param){
			var busiStartDate = $('#busiStartDate').datebox('getValue');
			if(isNotNull(busiStartDate) && busiStartDate>value){
				return false;
			}
			return true;
		},
		message: '注册批准成立日期不应晚于营业或有效期限起始日期！'
	},
	checkPhoneNum: {
		validator: function(value, param){
			var p = new RegExp('^[0-9]{0,11}$');
			return p.test(value);
		},
		message: '请输入正确的手机号码！'
	},
	orgCodeA: {
		validator: function(value, param){
			var p = new RegExp('^[A-Z0-9]{8}-[0-9X]{1}$');
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
	corpName: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5 ]');
			return !p.test(value);
		},
		message: '法人姓名应由英文字母或中文字符组成'
	},
	corpIdentNoA : {
		validator : function(value) {
			try{
				var corpIdentType = $('#corpIdentType').combobox('getValue');
				if(isNull(corpIdentType) || corpIdentType!=IDENT_TYPE){
					return true;
				}
				return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
			} catch (e){
				
			}
		},
		message : '身份证号码格式不正确'
	},
	corpIdentNoB : {
		validator: function(value, param){
			var corpIdentType = $('#corpIdentType').combobox('getValue');
			if(isNull(corpIdentType) || corpIdentType!=IDENT_TYPE){
				return true;
			}
			return true;
		},
		message : '身份证号已被使用'
	},
	coreEntAcctA: {
		validator: function(value, param){
			var p = new RegExp('^[0-9]{2}-[0-9]{15}$');
			return p.test(value);
		},
		message : '收款账号格式应为:XX-XXXXXXXXXXXXXXX'
	},
	coreEntAcctB: {
		validator: function(value, param){
			return true;
		},
		message : '收款账号错误'
	},
	coreEntAcctInst: {
		validator: function(value, param){
			return true;
		},
		message : '收款账户开户行名称错误'
	}
});

var fileCount = 0;//文件计数器
var dataStep = 0;// 数据处理步骤: 0-数据未保存 1-数据以保存，文件未保存， 2-文件已保存
var COUNRTY_CODE_CHN="<%=BaseConstant.REGISTER_COUNTRY_CHN%>";// 国家代码:中国
var MAX_FILE_SIZE = <%=BaseConstant.UPLOAD_FILE_SIZE_MAX_LIMIT%>; // 文件大小限制 10MB

//弹出全局图片预览
function loadImgbase64(base64) {
	// 创建图片层
	var box = self.parent.document.createElement("div");
	box.id = "_img_box_div";
	box.style.zIndex = "9999";
	box.style.display = "block";
	box.style.position = "absolute";
	self.parent.document.body.appendChild(box);
	// 创建背景层
	var layer = self.parent.document.createElement("div");
	layer = self.parent.document.createElement("div");
	layer.id = "_box_layer_div";
	layer.style.width = layer.style.height = "100%";
	layer.style.position = "absolute";
	layer.style.top = layer.style.left = 0;
	layer.style.backgroundColor = "#555";
	layer.style.zIndex = "9998";
	layer.style.opacity = "0.6";
	self.parent.document.body.appendChild(layer);
	var img = $('<img />').attr("src", base64).load(function(){
		// 图片加载成功后，重新设置显示位置
		var left = (self.parent.document.body.clientWidth-this.width)/2;
		var top = (self.parent.document.body.clientHeight-this.height)/2;
		// 设置弹出层样式
		box.style.top = top>0 ? top+'px' : 0;
		box.style.left = left>0? left+'px' : 0;
		box.style.width = this.width;
		box.style.height = this.height;
		layer.style.width = self.parent.document.body.scrollWidth;
		layer.style.height = self.parent.document.body.scrollHeight;
		layer.style.backgroundColor = "#555";
	});
	box.appendChild(img.get(0));

	// 绑定点击关闭方法
	self.parent.$('#_box_layer_div').bind('click', function(){
		self.parent.$('#_img_box_div').remove();
		self.parent.$('#_box_layer_div').remove();
	});
	img.bind('click', function(){
		self.parent.$('#_img_box_div').remove();
		self.parent.$('#_box_layer_div').remove();
	});
}

function checkBeforeSubmit(){
	if(!$('#coreEntEditForm').form('validate')){
		return false;
	}
	if(isNull($('#registerIdentType').combobox('getValue'))){
		$.messager.alert('提示信息','注册或登记证件类型是必选项！','info');
		$('#registerIdentType_REF').get(0).click();
		return false;
	} else if(isNull($('#registerCountry').combobox('getValue'))){
		$.messager.alert('提示信息','注册国家或地区是必选项！','info');
		$('#registerCountry_REF').get(0).click();
		return false;
	} else if($('#registerCountry').combobox('getValue') == COUNRTY_CODE_CHN &&
			isNull(getAreaCode())){
		$.messager.alert('提示信息','注册地行政区划是必选项！','info');
		$('#areaCode_REF').get(0).click();
		return false;
	} else if(isNull($('#entType').combobox('getValue'))){
		$.messager.alert('提示信息','单位类型是必选项！','info');
		$('#entType_REF').get(0).click();
		return false;
	} else if(isNull($('#addressAttribute').combobox('getValue'))){
		$.messager.alert('提示信息','注册地城乡属性是必选项！','info');
		$('#addressAttribute_REF').get(0).click();
		return false;
	}
	else if(isNotNull($('#email').val())){
		// 邮件地址有值验证在CP_ENT_INFO表内的唯一性
		var headEntNo = $('#headEntNo').val();
		var modifyFlag = 0;
	    jQuery.ajax({
	        type : "POST",
	        async: false,
	        url : "${ctx}/base/busiGroup/checkEmail",
	        data : {
	        	email: $("#email").val(),
	        	headEntNo: headEntNo
	        },
	        success : function(data) {
	             if(data.result.message=='success'){
	            	 modifyFlag = 0;
		         }else{
		        	 modifyFlag = 1;
		         }
	        },
	        error : function(data) {
	        	modifyFlag = 1;
	        },
	        datatype : "json"
	    });

		if(modifyFlag==1){
			$.messager.alert('提示信息','企业邮箱已存在，请重新输入！','info');
			return false;
		}
        
    }
	else if(isNull($('#corpIdentType').combobox('getValue'))){
		$.messager.alert('提示信息','企业法人代表有效证件类型是必选项！','info');
		$('#corpIdentType_REF').get(0).click();
		return false;
	} else if(isNull('${e1File.fileNo}') && isNull($('#_filedata_E1_1_${e1File.fileNo}').val())){
		$.messager.alert('提示信息','注册或登记证件还未上传！','info');
		$('#_filedata_E1_1_${e1File.fileNo}_REF').get(0).click();
		return false;
	} else if(isNull('${e2File.fileNo}') && isNull($('#_filedata_E2_1_${e2File.fileNo}').val())){
		$.messager.alert('提示信息','组织机构代码证还未上传！','info');
		$('#_filedata_E2_1_${e2File.fileNo}_REF').get(0).click();
		return false;
	}
	return true;
}

function checkFile(file){
	var fileName = '';
	var fileSize = 0;
	if(isNull(file.files)){
		try{
			file.select();
			fileName = document.selection.createRange().text;
			var fso = new ActiveXObject("Scripting.FileSystemObject");
			fileSize = fso.GetFile(fileName).size;
		} catch(e) {
			// IE浏览器无法完成本地文件大小校验
			if(document.all){
				/* IE浏览器,需要将浏览器权限调到最低
				$.messager.show({
					title: '消息',
					msg: '您使用的是IE浏览器，请将安全级别调低！',
					timeout: 5000,
					showType:'slide'
				});
				*/
			}
			// return false;
		}
	} else if(file.files.length==0){
		return true;
	} else {
		fileSize = file.files[0].length;
	}
	// 文件大小限制
	if(fileSize>MAX_FILE_SIZE){
		$.messager.show({
			title: '消息',
			msg: '文件['+file.name+']大小超过10MB,不允许上传',
			timeout: 5000,
			showType:'show',
			style:{
				right:'',
				top:document.body.scrollTop+document.documentElement.scrollTop,
				bottom:''
			}
		});
		return false;
	}
	return true;
}

// ajax提交文件
function submitFile(sucessFunc, errorFunc){
	$.messager.progress({
		title: '',
		msg: '正在上传文件信息，请稍候...',
		text: ''
	});
	try{
		new FormData();
	} catch (e) {
		// IE8\9不支持FormData对象，此处使用easyuiForm提交，controller需要做对应的处理
		$('#coreEntFileEditForm').form('submit',{
			url: '${ctx}/base/busiGroup/coreEntEdit/saveFile',
			success: function(data){
				$.messager.progress('close');
				var jsonData = eval('('+data+')');
				if(jsonData.sucess==true){
					dataStep = 2;
					if(sucessFunc){
						sucessFunc(data);
					}
				} else {
					$.messager.alert('错误信息','文件上传失败:'+jsonData.msg,'error');
					if(errorFunc){
						errorFunc(data);
					}
				}
			}
		});
		return;
	}
	var fileForm = new FormData();
	// 文件
	var allFile = $("[id^='_filedata_']:file");
	if(allFile){
		var i = 0;
		while(i < allFile.length){
			var file = allFile[i];
			// 文件大小限制
			if(checkFile(file)){
				fileForm.append(file.id, file.files[0]);
			} else {
				return;
			}
			i++;
		}
	}
	// 备注
	var allRemark = $("[id^='_remark_']");
	if(allRemark){
		var i = 0;
		while(i < allRemark.length){
			var remark = allRemark[i];
			fileForm.append(remark.id, remark.value);
			i++;
		}
	}
	// 状态
	var allFileStatus = $("[id^='_fileStatus_']");
	if(allFileStatus){
		var i = 0;
		while(i < allFileStatus.length){
			var fileStatus = allFileStatus[i];
			fileForm.append(fileStatus.id, fileStatus.value);
			i++;
		}
	}
	// 状态
	var allDeleteStatus = $("[id^='_deleteStatus_']");
	if(allDeleteStatus){
		var i = 0;
		while(i < allDeleteStatus.length){
			var deleteStatus = allDeleteStatus[i];
			fileForm.append(deleteStatus.id, deleteStatus.value);
			i++;
		}
	}
	// 企业编号
	fileForm.append('_entNoForFiles', $("#_entNoForFiles").val());
	
	$.ajax({
		url:'${ctx}/base/busiGroup/coreEntEdit/saveFile',
		data:fileForm,
		datatype:'json',
		type:'POST',
		async: true,
		processData:false,
		contentType:false,
		success:function(data, status){
			$.messager.progress('close');
			var jsonData = eval('('+data+')');
			if(jsonData.sucess==true){
				dataStep = 2;
				if(sucessFunc){
					sucessFunc(data);
				}
			} else {
				$.messager.alert('错误信息','文件上传失败:'+jsonData.msg,'error');
				if(errorFunc){
					errorFunc(data);
				}
			}
		},
		error: function(data, status){
			$.messager.progress('close');
			$.messager.alert('错误信息','文件上传失败！<br/>'+getJsonErrorMsg(data),'error');
			if(errorFunc){
				errorFunc(data);
			}
		}
	});
}

function submitData(sucessFunc, errorFunc){
	// 如果企业数据已提交，则无需重复提交，只需要提交文件
	if(dataStep==1){
		submitFile(sucessFunc, errorFunc);
	} else if(dataStep==0){
		$.messager.progress({
			title: '',
			msg: '正在更新核心企业信息，请稍候...',
			text: ''
		});
		// 保存核心企业商圈数据
		$.ajax({
			type : 'POST',
			async: true,
			url : '${ctx}/base/busiGroup/coreEntEdit/updateCoreEnt',
			data : {
				// BusinessGroup
				busiGroupCode:			$('#busiGroupCode').val(),		// 商圈代码
				busiGroupName:			$('#busiGroupName').val(),		// 商圈名称
				tradeCode:				$('#tradeCode').combotree('getValue'),		//归属行业
				qualityCredit:			$('#qualityCredit').combobox('getValue'),	//信用质量
				abilityPayable:			$('#abilityPayable').combobox('getValue'),	//偿债能力
				listFlag:				$('#listFlag').combobox('getValue'),        // 是否上市企业
				coreEntAcctInst:		$('#coreEntAcctInst').val(),                // 收款账户开户行名称
				coreEntAcct:			$('#coreEntAcct').val(),                    // 收款账号
				coreEntSaleAmtPerYear:  $('#coreEntSaleAmtPerYear').numberbox('getValue'),          // 近一年核心企业年销售收入(万元)
				coreEntSaleGrowthRate:  $('#coreEntSaleGrowthRate').numberbox('getValue'),          // 近一年核心企业销售增长率(%)
                saleGrossProfitRate:  $('#saleGrossProfitRate').numberbox('getValue'),              // 近一年核心企业销售毛利率(%)
                assetLiabRate:  $('#assetLiabRate').numberbox('getValue'),                          // 近一年核心企业资产负债率(%)
                
				// EnterpriseInfo
				entNo:				$('#_entNoForFiles').val(),						// 企业编号
				chineseFullname:	$('#chineseFullname').val(),					//中文全称
				registerIdentType:	$('#registerIdentType').combobox('getValue'),	//注册或登记证件类型
				chineseName:		$('#chineseName').val(),						//中文简称
				registerIdentNo:	$('#registerIdentNo').val(),					//注册或登记证件号码
				englishFullname:	$('#englishFullname').val(),					//英文全称
				registerCountry:	$('#registerCountry').combobox('getValue'),		//注册国家或地区
				englishName:		$('#englishName').val(),						//英文简称
				areaCode:			getAreaCode(),									//注册地行政区划
				entType:			$('#entType').combobox('getValue'),				//单位类型
				address:			$('#address').val(),							//注册地址
				checkDate:			$('#checkDate').datebox('getValue'),			//组织机构代码年检日期
				addressAttribute:	$('#addressAttribute').combobox('getValue'),	//注册地城乡属性
				registerDate:		$('#registerDate').datebox('getValue'),			//注册或批准成立日期
				regCheckDate:		$('#regCheckDate').datebox('getValue'),			//注册或登记证件年检日期
				orgCode:			$('#orgCode').val(),							//组织机构代码
				busiStartDate:		$('#busiStartDate').datebox('getValue'),		//营业或有效期限起始日期
				corpIdentType:		$('#corpIdentType').combobox('getValue'),		//企业法人代表有效证件类型
				busiEndDate:		$('#busiEndDate').datebox('getValue'),			//营业或有效期限终止日期
				corpIdentNo:		$('#corpIdentNo').val(),						//企业法人代表有效证件号码
				corpName:			$('#corpName').val(),							//企业法人代表姓名
				corpIdentMobile:	$('#corpIdentMobile').val(),					//企业法人代表手机号
				email:              $('#email').val()                               //企业邮箱
			},
			success : function(data, status) {
				$.messager.progress('close');
				if(showErrorMessage('核心企业商圈信息更新失败！', data)){
					return;
				}
				// 寄存企业编号
				$('#_entNoForFiles').val(data.result.entNo);
				dataStep = 1;
				// 上传文件
				submitFile(sucessFunc, errorFunc);
			},
			error : function(data, status) {
				$.messager.progress('close');
				$.messager.alert('错误信息','更新核心企业商圈信息失败！<br/>'+getJsonErrorMsg(data),'error');
				if(errorFunc){
					errorFunc(data, status);
				}
			},
			datatype : "json"
		});
	} else if(dataStep==2){
		$.messager.alert('提示信息', '核心企业商圈信息更新成功！','info', function(){
			closeTab();
		});
	} else {
		
	}
}

/**
 * 为了保证备注与文件能够一一对应，使用命名规则: 
 *	文件name = '_filedata_' + 文件类型  + 文件状态  + '_' + 序号;
 *  备注name = '_remark_' + 文件类型  + 文件状态 + '_' + 序号;
 *  文件类型: E0 ~ E3 P1
 *  文件状态: 1-服务端   0-本次提交
 */
var anotherOne = function(){
	fileCount++;
	var id = 'OTHER_FILE_ID_'+fileCount;
	var fileId = '_filedata_E0_0_'+fileCount;
	var remarkId = '_remark_E0_0_'+fileCount;
	var fileStatusId = '_fileStatus_E0_0_'+fileCount;
	
	var htmlStr = '<tr id="'+ id +'_TR">';
	htmlStr += '<td id="'+id+'_TD1" class="td_name"><a id="'+fileId+'_REF" href="#'+fileId+'_REF" /></td>';
	htmlStr += '<td id="'+id+'_TD2" class="td_file"><input type="file" id="'+fileId+'" name="'+fileId+'" /></td>';
	htmlStr += '<td id="'+id+'_TD3" class="td_button">';
	htmlStr += '<a id="'+id+'anotherOneBtn">添加文件</a>&nbsp;';
	htmlStr += '<a id="'+id+'deleteFile">删除</a>';
	htmlStr += '<td id="'+id+'_TD4" class="td_fileStatus"><input id="'+fileStatusId+'" name="'+fileStatusId+'" class="easyui-combobox" editable="false" disabled="disabled" data-options="required:false" /></td>';
	htmlStr += '<td id="'+id+'_TD5" class="td_remark"><input id="'+remarkId+'" name="'+remarkId+'" class="easyui-validatebox" data-options="required:false,validType:[\'maxLength[1,200]\']" /></td></tr>';
	$('#appendBeforeMe').before(htmlStr);
	// 绑定按钮方法
	$("#"+id+"deleteFile").linkbutton({
	});
	$("#"+id+"anotherOneBtn").linkbutton({
	});
	$("#"+id+"deleteFile").click(function(){
		$("[id^='"+id+"']").remove();
	});
	$("#"+id+"anotherOneBtn").click(anotherOne);
	// 跳转新增文件
	$('#'+fileId+'_REF').get(0).click();
	//
	$('#'+fileId).change(function(){
		if(isNull($('#'+fileId).val())){
			$('#'+fileStatusId).val('');
		} else if(!checkFile($("#"+fileId).get(0))){
			$("#"+fileId).val('');
		} else {
			$('#'+fileStatusId).val('待提交');
		}
	});
};

//获取当前日期,格式'yyyy-MM-dd'
function getCurrentDateStr(){
	var date = new Date();
	var monthPart = date.getMonth() + 1;
	if(monthPart < 10) {
		monthPart = "0"+monthPart;
	}
	var dayPart = date.getDate();
	if(dayPart < 10) {
		dayPart = "0"+dayPart;
	}
	return date.getFullYear()+"-"+ monthPart +"-"+dayPart;
}

// 关闭当前tab页
function closeTab(){
	// 刷新父Tab dataGrid
	self.parent.reloadTabGrid("核心企业（商圈）维护","#coreEntDatagrid");
	// 关闭当前tab
	self.parent.closeCurrentTab();
}

// 获取注册行政区划
function getAreaCode(){
	var countyCode = $('#areaCodeCounty').combobox('getValue');
	if(isNull(countyCode)){
		var cityCode = $('#areaCodeCity').combobox('getValue');
		if(isNull(cityCode)){
			return $('#areaCodeProvince').combobox('getValue');
		}
		return cityCode;
	}
	return countyCode;
}

//根据组织机构编号获取企业信息
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

//解析Ajax请求失败的json错误信息
function getJsonErrorMsg(data){
	var errorMsg = '';
	if(data && data.responseText){
		errorMsg = (eval('('+data.responseText+')')).string;
	}
	return errorMsg;
}

//解析并显示异常信息
function showErrorMessage(prefixStr, data) {
	if(data && data.status && data.status=='FAIL'){
		var errorMsg = prefixStr;
		errorMsg += isNull(data.result.errorMsg) ? '' : ('<br/>'+data.result.errorMsg);
		var fieldErrors = isNull(data.result.fieldErrors)? [] : data.result.fieldErrors;
		for(var i in fieldErrors){
			errorMsg += '<br/>'+fieldErrors[i];
		}
		$.messager.alert('错误信息', errorMsg, 'error');
		return true;
	} else {
		return false;
	}
}

//设置完整区域编号
function setAreaCode(areaCode){
	if(isNull(areaCode)){
		return;
	}
	$.ajax({
		type: 'POST',
		async: false,
		url: '${ctx}/base/busiGroup/getFullArea/'+areaCode,
		success : function(data, status) {
			if(data==null){
				return;
			}
			if(data.length>0){
				$('#areaCodeProvince').combobox('setValue', data[0].areaCode);
				$('#areaCodeCity').combobox({
					method: 'post',
					url:'${ctx}/base/busiGroup/getCityList/'+data[0].areaCode,
					valueField:'areaCode',
					textField:'areaName'
				});
			}
			if(data.length>1){
				$('#areaCodeCity').combobox('setValue', data[1].areaCode);
				$('#areaCodeCounty').combobox({
					method: 'post',
					url:'${ctx}/base/busiGroup/getCountyList/'+data[1].areaCode,
					valueField:'areaCode',
					textField:'areaName'
				});
			}
			if(data.length>2){
				$('#areaCodeCounty').combobox('setValue', data[2].areaCode);
			}
		},
		error : function(data, status) {
			$.messager.show({
				title: '消息',
				msg: '获取区域完整信息失败<br/>'+getJsonErrorMsg(data),
				timeout: 5000,
				showType:'slide'
			});
		},
		datatype : "json"
	});
}

var orgCodeValueChangeFlag = false;

$(document).ready(function(){
	// 绑定按钮方法
	$("[id^='anotherOneBtn']").click(anotherOne);
	// 初始化页面
	$('#registerCountry').combobox({
		onSelect: function(record){
			if(record.countryCode!= COUNRTY_CODE_CHN){
				$('#areaCodeProvince').combobox('setValue', '');
				$('#areaCodeProvince').combobox('disable');
				$('#areaCodeProvince').removeAttr("required");
				$('#areaCodeCity').combobox('setValue', '');
				$('#areaCodeCity').combobox('disable');
				$('#areaCodeCounty').combobox('setValue', '');
				$('#areaCodeCounty').combobox('disable');
			} else {
				$('#areaCodeProvince').combobox('enable');
				$('#areaCodeProvince').attr("required","required");
				$('#areaCodeCity').combobox('enable');
				$('#areaCodeCounty').combobox('enable');
			}
		}
	});
	$('#areaCodeProvince').combobox({
		onSelect: function(record){
			if(isNull(record.areaCode)){
				$('#areaCodeCity').combobox('clear');
				$('#areaCodeCity').combobox('loadData', []);
				$('#areaCodeCounty').combobox('clear');
				$('#areaCodeCounty').combobox('loadData', []);
				return;
			}
			$('#areaCodeCity').combobox({
				value: '',
				method: 'post',
				url:'${ctx}/base/busiGroup/getCityList/'+record.areaCode,
				valueField:'areaCode',
				textField:'areaName'
			});
			$('#areaCodeCounty').combobox('clear');
			$('#areaCodeCounty').combobox('loadData', []);
		}
	});
	$('#areaCodeCity').combobox({
		onSelect: function(record){
			if(isNull(record.areaCode)){
				$('#areaCodeCounty').combobox('clear');
				$('#areaCodeCounty').combobox('loadData', []);
				return;
			}
			$('#areaCodeCounty').combobox({
				value: '',
				method: 'post',
				url:'${ctx}/base/busiGroup/getCountyList/'+record.areaCode,
				valueField:'areaCode',
				textField:'areaName'
			});
		}
	});
	if($('#registerCountry').combobox('getValue')!= COUNRTY_CODE_CHN){
		$('#areaCodeProvince').combobox('setValue', '');
		$('#areaCodeProvince').combobox('disable');
		$('#areaCodeProvince').removeAttr("required");
		$('#areaCodeCity').combobox('setValue', '');
		$('#areaCodeCity').combobox('disable');
		$('#areaCodeCounty').combobox('setValue', '');
		$('#areaCodeCounty').combobox('disable');
	} else {
		$('#areaCodeProvince').combobox('enable');
		$('#areaCodeProvince').attr("required","required");
		$('#areaCodeCity').combobox({
			method: 'post',
			url:'${ctx}/base/busiGroup/getCityList/'+$('#areaCodeProvince').combobox('getValue'),
			valueField:'areaCode',
			textField:'areaName'
		});
		$('#areaCodeCounty').combobox({
			method: 'post',
			url:'${ctx}/base/busiGroup/getCountyList/'+$('#areaCodeCity').combobox('getValue'),
			valueField:'areaCode',
			textField:'areaName'
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
	
	// 初始化文件状态下拉框
	$("[id^='_fileStatus']").combobox({
		valueField: 'configCode',
		textField: 'configName',
		url: '${ctx}/base/busiGroup/getFileStatuData',
		type: 'post'
	});
	
	// 绑定按钮动作
	$("[id^='submitBtn']").click(function(){
		if(!checkBeforeSubmit()){
			return;
		}
		$.messager.confirm('确认信息', '确定提交?', function(r){
			if(r){
				submitData(function(data, status){
					$.messager.alert('提示信息', '核心企业商圈信息更新成功！','info', function(){
						closeTab();
					});
				}, function(data, status){
					$.messager.progress('close');
				});
			}
		});
	});
	
	$('#_filedata_E0_0_0').change(function(){
		if(!checkFile($('#_filedata_E0_0_0').get(0))){
			$('#_filedata_E0_0_0').val('');
		} else if(isNull($('#_filedata_E0_0_0').val())){
			$('#_fileStatus_E0_0_0').combobox('setValue', '');
		} else {
			$('#_fileStatus_E0_0_0').combobox('setValue', '-1');
		}
	});
	
	$("[id^='backBtn']").click(function(){
		// closeTab();
		self.parent.closeCurrentTab();
	});
	
	// 组织机构代码校验
	$('#orgCode').change(function(){
		var entNo = $('#_entNoForFiles').val();
		if(isNull(entNo)){
			entNo = '';
		}
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
				if(enterpriseInfoByOrgCode.entNo==entNo){
					// 本身
					return;
				} else if(enterpriseInfoByOrgCode.coreFlag=='<%=BaseConstant.CORE_FLAG_Y%>'){
					// 不是本身，且已经是核心企业
					$.messager.alert('提示信息','组织机构编号为['+enterpriseInfoByOrgCode.orgCode+']企业名称为['+enterpriseInfoByOrgCode.chineseFullname+']的核心企业已经存在','info',function(){
						$('#orgCode').val('');
					});
				} else if(entNo==''){
					// 还未创建核心企业，发现核心企业信息已经存在
					$.messager.confirm('确认信息', '组织机构编号为['+enterpriseInfoByOrgCode.orgCode+']企业名称为['+enterpriseInfoByOrgCode.chineseFullname+']的非核心企业已经存在,是否更新为核心企业?', function(r){
						if(r){
							if(enterpriseInfoByOrgCode.registerCountry!= COUNRTY_CODE_CHN){
								$('#areaCodeProvince').combobox('setValue', '');
								$('#areaCodeProvince').combobox('disable');
								$('#areaCodeProvince').removeAttr("required");
								$('#areaCodeCity').combobox('setValue', '');
								$('#areaCodeCity').combobox('disable');
								$('#areaCodeCounty').combobox('setValue', '');
								$('#areaCodeCounty').combobox('disable');
							} else {
								$('#areaCodeProvince').combobox('enable');
								$('#areaCodeProvince').attr("required","required");
								$('#areaCodeCity').combobox('enable');
								$('#areaCodeCounty').combobox('enable');
							}
							// EnterpriseInfo
							$('#chineseFullname').val(enterpriseInfoByOrgCode.chineseFullname);//中文全称
							$('#registerIdentType').combobox('setValue',enterpriseInfoByOrgCode.registerIdentType);	//注册或登记证件类型
							$('#chineseName').val(enterpriseInfoByOrgCode.chineseName);						//中文简称
							$('#registerIdentNo').val(enterpriseInfoByOrgCode.registerIdentNo);					//注册或登记证件号码
							$('#englishFullname').val(enterpriseInfoByOrgCode.englishFullname);					//英文全称
							$('#registerCountry').combobox('setValue',enterpriseInfoByOrgCode.registerCountry);		//注册国家或地区
							$('#englishName').val(enterpriseInfoByOrgCode.englishName);						//英文简称
							setAreaCode(enterpriseInfoByOrgCode.areaCode);									//注册地区行政区划编号
							$('#entType').combobox('setValue',enterpriseInfoByOrgCode.entType);				//单位类型
							$('#address').val(enterpriseInfoByOrgCode.address);							//注册地址
							$('#checkDate').datebox('setValue',enterpriseInfoByOrgCode.checkDate);			//组织机构代码年检日期
							$('#addressAttribute').combobox('setValue',enterpriseInfoByOrgCode.addressAttribute);	//注册地城乡属性
							$('#registerDate').datebox('setValue',enterpriseInfoByOrgCode.registerDate);			//注册或批准成立日期
							$('#regCheckDate').datebox('setValue',enterpriseInfoByOrgCode.regCheckDate);			//注册或登记证件年检日期
							$('#orgCode').val(enterpriseInfoByOrgCode.orgCode);							//组织机构代码
							$('#busiStartDate').datebox('setValue',enterpriseInfoByOrgCode.busiStartDate);		//营业或有效期限起始日期
							$('#corpIdentType').combobox('setValue',enterpriseInfoByOrgCode.corpIdentType);		//企业法人代表有效证件类型
							$('#busiEndDate').datebox('setValue',enterpriseInfoByOrgCode.busiEndDate);			//营业或有效期限终止日期
							$('#corpIdentNo').val(enterpriseInfoByOrgCode.corpIdentNo);						//企业法人代表有效证件号码
							$('#corpName').val(enterpriseInfoByOrgCode.corpName);							//企业法人代表姓名
							$('#corpIdentMobile').val(enterpriseInfoByOrgCode.corpIdentMobile);					//企业法人代表手机号
							$('#email').val(enterpriseInfoByOrgCode.email);                                      // 企业邮箱 
						} else {
							$('#orgCode').val('');
						}
					});
				}
			}
		}
	});
	
	// 不允许修改商圈名称，如果核心企业信息已存在
	var entNo = $('#_entNoForFiles').val();
	if(!isNull(entNo)){
		$('#busiGroupName').attr('disabled', 'disabled');
	}
	
	$('#coreEntSaleAmtPerYear').numberbox({
        onChange: function(newValue,oldValue){
            if(isNull(newValue)){
                $('#coreEntSaleAmtPerYear').numberbox('setValue', 0);
            }
        }
    });
    $('#coreEntSaleGrowthRate').numberbox({
        onChange: function(newValue,oldValue){
            if(isNull(newValue)){
                $('#coreEntSaleGrowthRate').numberbox('setValue', 0);
            }
        }
    });
    $('#saleGrossProfitRate').numberbox({
        onChange: function(newValue,oldValue){
            if(isNull(newValue)){
                $('#saleGrossProfitRate').numberbox('setValue', 0);
            }
        }
    });
    $('#assetLiabRate').numberbox({
        onChange: function(newValue,oldValue){
            if(isNull(newValue)){
                $('#assetLiabRate').numberbox('setValue', 0);
            }
        }
    });
});
</script>
</body>
</html>