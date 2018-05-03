<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.zjgt.p2p.BaseConstant"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
</head>
<style type="text/css">
.blank_td {
    width: 10%;
}
.td_remark {
     align: center;
}
.dialog-button {
    border-top: 1px solid #dddddd;
    text-align: center;
}
.span_required {
    color: red;
}
/* numberbox 数字右对齐*/
input[class="easyui-numberbox numberbox-f validatebox-text"] {
	text-align: right;
}
/* 去除tree图标 */
span[class^='tree-icon']{
	width: 0;
}
</style>
<body>
	<div>
		<div>
			<div style="padding-top: 20px;">
				<p style="text-align: center;">
					<span style="font-size: 16px; font-weight: bold; font-style: normal;">新增客户资料</span>
				</p>
			</div>
		</div>
	</div>
	<div style="width:30px;">
	</div>
	<form id="coreEntAddForm" method="post">
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
						<label for="busiGroupName"><span class="span_required">*</span>商圈名称:</label>
					</td>
					<td class="td_input">
						<input id="busiGroupName" class="easyui-validatebox"
							data-options="required:true,validType:['maxLength[1, 60]']" />
					</td>
					<td></td>
					<td></td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label"><a id="tradeCode_REF" href="#tradeCode_REF"></a>
						<label for="tradeCode"><span class="span_required">*</span>归属行业:</label>
					</td>
					<td class="td_input">
						<input id="tradeCode" class="easyui-combotree" data-options="panelWidth:250,panelHeight:280,multiple:false,required:true">
					</td>
					<td class="td_label">
						<label for="listFlag">是否上市企业:</label>
					</td>
					<td class="td_input">
						<input id="listFlag" class="easyui-combobox" data-options="panelHeight:'auto',multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_ENT_LIST_FLAG%>'">
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label"><a id="qualityCredit_REF" href="#qualityCredit_REF"></a>
						<label for="qualityCredit">信用质量:</label>
					</td>
					<td class="td_input">
						<input id="qualityCredit" class="easyui-combobox" data-options="multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_LN_DIC_DDIRBCDRATE%>'">
					</td>
					<td class="td_label"><a id="abilityPayable_REF" href="#abilityPayable_REF"></a>
						<label for="abilityPayable">偿债能力:</label>
					</td>
					<td class="td_input">
						<input id="abilityPayable" class="easyui-combobox" data-options="panelHeight:'auto',multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_LN_DIC_DDDEBTABILITY%>'">
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="upLcAmt">上游授信额度(万元):</label>
					</td>
					<td class="td_input">
						<input id="upLcAmt" type="text" class="easyui-numberbox"
							data-options="required:false,value:0,min:0,max:99999999999,precision:0,groupSeparator:','" />
					</td>
					<td class="td_label">
						<label for="downLcAmt">下游授信额度(万元):</label>
					</td>
					<td class="td_input">
						<input id="downLcAmt" type="text" class="easyui-numberbox"
							data-options="required:false,value:0,min:0,max:99999999999,precision:0,groupSeparator:','" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="totalLcAmt">商圈总授信额度(万元):</label>
					</td>
					<td class="td_input">
						<input id="totalLcAmt" type="text" class="easyui-numberbox" readonly="readonly"
							data-options="required:false,value:0,min:0,precision:0,groupSeparator:','" />
					</td>
					<td class="td_label">
						<label for="upLcValiddate"><span class="span_required">*</span>商圈授信到期日:</label>
					</td>
					<td class="td_input">
						<input id="upLcValiddate" type="text" class="easyui-datebox" data-options="required:true,editable:false" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="coreEntSaleAmtPerYear">近一年核心企业年销售收入(万元):</label>
					</td>
					<td class="td_input">
						<input id="coreEntSaleAmtPerYear" type="text" class="easyui-numberbox"
							data-options="required:false,value:0,min:0,precision:2,groupSeparator:','" />
					</td>
					<td class="td_label">
						<label for="coreEntSaleGrowthRate">近一年核心企业销售增长率(%):</label>
					</td>
					<td class="td_input">
						<input id="coreEntSaleGrowthRate" type="text" class="easyui-numberbox" 
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
						<input id="saleGrossProfitRate" type="text" class="easyui-numberbox" 
							data-options="required:false,value:0,min:0,max:100,precision:2,groupSeparator:','" />
					</td>
					<td class="td_label">
						<label for="assetLiabRate">近一年核心企业资产负债率(%):</label>
					</td>
					<td class="td_input">
						<input id="assetLiabRate" type="text" class="easyui-numberbox" 
							data-options="required:false,value:0,min:0,max:100,precision:2,groupSeparator:','" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="lyToCoreEntGoodsCost">上年度对核心企业进货成本(万元):</label>
					</td>
					<td class="td_input">
						<input id="lyToCoreEntGoodsCost" type="text" class="easyui-numberbox" 
							data-options="required:false,value:0,min:0,precision:2,groupSeparator:','" />
					</td>
					<td class="td_label">
						<label for="lyToCoreEntSaleIncome">上年度对核心企业销售收入(万元):</label>
					</td>
					<td class="td_input">
						<input id="lyToCoreEntSaleIncome" type="text" class="easyui-numberbox" 
							data-options="required:false,value:0,min:0,precision:2,groupSeparator:','" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr style="height:30px;">
					<td></td>
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
						<label>收款账号:</label>
					</td>
					<td class="td_input">
						<input id="coreEntAcct" maxlength="18" class="easyui-validatebox" data-options="validType:['maxLength[1,32]','coreEntAcctA[]','coreEntAcctB[]']"
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
						<input id="chineseFullname" class="easyui-validatebox" data-options="required:true,validType:['maxLength[1,30]']" />
					</td>
					<td class="td_label"><a id="registerIdentType_REF" href="#registerIdentType_REF" ></a>
						<label for="registerIdentType"><span class="span_required">*</span>注册或登记证件类型:</label>
					</td>
					<td class="td_input">
						<input id="registerIdentType" class="easyui-combobox" data-options="panelHeight:'auto',multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_REGISTER_IDENT_TYPE%>'">
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="chineseName">中文简称:</label>
					</td>
					<td class="td_input">
						<input id="chineseName" class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,5]']" />
					</td>
					<td class="td_label">
						<label for="registerIdentNo"><span class="span_required">*</span>注册或登记证件号码:</label>
					</td>
					<td class="td_input">
						<input id="registerIdentNo" class="easyui-validatebox" 
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
						<input id="englishFullname" class="easyui-validatebox" 
							data-options="required:false,validType:['englishFullName[100]']" />
					</td>
					<td class="td_label"><a id="registerCountry_REF" href="#registerCountry_REF"></a>
						<label for="registerCountry"><span class="span_required">*</span>注册国家或地区:</label>
					</td>
					<td class="td_input">
						<input id="registerCountry" class="easyui-combobox" data-options="multiple:false,valueField:'countryCode',textField:'cnName',type:'post',url:'${ctx}/base/busiGroup/getCountrys'">
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="englishName">英文简称:</label>
					</td>
					<td class="td_input">
						<input id="englishName" class="easyui-validatebox" data-options="required:false,validType:['englishName[15]']" />
					</td>
					<td class="td_label"><a id="areaCode_REF" href="#areaCode_REF"></a>
						<label for="areaCode"><span class="span_required">*</span>注册地行政区划:</label>
					</td>
					<td class="td_input" colspan="2">
						<input id="areaCodeProvince" class="easyui-combobox" 
							data-options="multiple:false,editable:false,width:80,method:'post',url:'${ctx}/base/busiGroup/getProvinceList',valueField:'areaCode',textField:'areaName'">
						<input id="areaCodeCity" class="easyui-combobox"
							data-options="multiple:false,editable:false,width:80,method:'post',valueField:'areaCode',textField:'areaName'">
						<input id="areaCodeCounty" class="easyui-combobox"
							data-options="multiple:false,editable:false,width:80,method:'post',valueField:'areaCode',textField:'areaName'">
					</td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label"><a id="entType_REF" href="#entType_REF"></a>
						<label for="entType"><span class="span_required">*</span>单位类型:</label>
					</td>
					<td class="td_input">
						<input id="entType" class="easyui-combobox" data-options="panelHeight:'auto',multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_ENT_TYPE%>'">
					</td>
					<td class="td_label">
						<label for="address">注册地址:</label>
					</td>
					<td class="td_input">
						<input id="address" class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,30]']" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="checkDate"><span class="span_required">*</span>组织机构代码年检日期:</label>
					</td>
					<td class="td_input">
						<input id="checkDate" type="text" class="easyui-datebox" required="required"
							data-options="editable:false,validType:['checkDate[]']" />
					</td>
					<td class="td_label"><a id="addressAttribute_REF" href="#addressAttribute_REF"></a>
						<label for="addressAttribute"><span class="span_required">*</span>注册地城乡属性:</label>
					</td>
					<td class="td_input">
						<input id="addressAttribute" class="easyui-combobox" data-options="panelHeight:'auto',multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_ADDRESS_ATTRIBUTE%>'">
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
							data-options="editable:false,validType:['registerDateA[]','registerDateB[]']" />
					</td>
					<td class="td_label">
					</td>
					<td class="td_input">
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
							data-options="editable:false,validType:['regCheckDate[]']" />
					</td>
					<td class="td_label">
						<label for="orgCode"><span class="span_required">*</span>组织机构代码:</label>
					</td>
					<td class="td_input">
						<input id="orgCode" class="easyui-validatebox" data-options="required:true,validType:['orgCodeA[]','orgCodeB[]','maxLength[1,20]']" />
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
							data-options="editable:false,validType:['busiStartDateA[]','busiStartDateB[]']" />
					</td>
					<td class="td_label"><a id="corpIdentType_REF" href="#corpIdentType_REF"></a>
						<label for="corpIdentType"><span class="span_required">*</span>企业法人代表有效证件类型:</label>
					</td>
					<td class="td_input">
						<input id="corpIdentType" class="easyui-combobox" data-options="panelHeight:'auto',multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_ENT_CORP_IDENT_TYPE%>'">
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
							data-options="editable:false,validType:['busiEndDate[]']" />
					</td>
					<td class="td_label">
						<label for="corpIdentNo"><span class="span_required">*</span>企业法人代表有效证件号码:</label>
					</td>
					<td class="td_input">
						<input id="corpIdentNo" class="easyui-validatebox" data-options="required:true,validType:['corpIdentNoA[]','corpIdentNoB[]','maxLength[1,32]']" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="corpName"><span class="span_required">*</span>企业法人代表姓名:</label>
					</td>
					<td class="td_input">
						<input id="corpName" class="easyui-validatebox" data-options="required:true,validType:['corpName[]','maxLength[1,30]']" />
					</td>
					<td class="td_label">
						<label for="corpIdentMobile"><span class="span_required">*</span>企业法人代表手机号:</label>
					</td>
					<td class="td_input">
						<input id="corpIdentMobile" class="easyui-validatebox"
							data-options="required:true,validType:['maxLength[1,11]','checkPhoneNum[]']" />
					</td>
					<td class="blank_td"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<form id="coreEntFileAddForm" style="margin: 0px" enctype="multipart/form-data" method="post">
		<table style="width: 100%;height:100%" border="0" cellpadding="2" cellspacing="3" align="center">
			<tbody>
				<tr>
					<td colspan="6"><hr /></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">名称</td>
					<td align="center">文件路径</td>
					<td></td>
					<td class="td_remark">备注</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"><a id="_filedata_E1_REF" href="#_filedata_E1_REF"></a></td>
					<td class="td_label">
						<label><span class="span_required">*</span>注册或登记证件:</label>
					</td>
					<td class="td_input">
						<input type="file" value="" id="_filedata_E1" name="_filedata_E1"
							accept="image/*" required="required" />
					</td>
					<td></td>
					<td class="td_remark">
						<input id="_remark_E1" name="_remark_E1" class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,200]']" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"><a id="_filedata_E2_REF" href="#_filedata_E2_REF"></a></td>
					<td class="td_label">
						<label><span class="span_required">*</span>组织机构代码证:</label>
					</td>
					<td class="td_input">
						<input type="file" value="" id="_filedata_E2" name="_filedata_E2"
							accept="image/*" required="required" />
					</td>
					<td></td>
					<td class="td_remark">
						<input id="_remark_E2" name="_remark_E2" class="easyui-validatebox"data-options="required:false,validType:['maxLength[1,200]']" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"><a id="_filedata_E3_REF" href="#_filedata_E3_REF"></a></td>
					<td class="td_label">
						<label>企业法人代表授权书:</label>
					</td>
					<td class="td_input">
						<input type="file" value="" id="_filedata_E3" name="_filedata_E3"
							accept="image/*" required="required" />
					</td>
					<td></td>
					<td class="td_remark">
						<input id="_remark_E3" name="_remark_E3" class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,200]']" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<!--  
				<tr>
					<td class="blank_td"><a id="_filedata_E4_REF" href="#_filedata_E4_REF"></a></td>
					<td class="td_label">
						<label>企业法人代表有效证件:</label>
					</td>
					<td class="td_input">
						<input type="file" value="" id="_filedata_E4" name="_filedata_E4"
							accept="image/*" required="required" />
					</td>
					<td></td>
					<td class="td_remark">
						<input id="_remark_E4" name="_remark_E4" class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,200]']" />
					</td>
					<td class="blank_td"></td>
				</tr>
				-->
				<tr>
					<td class="blank_td"><a id="_filedata_E0_0_REF" href="#_filedata_E0_0_REF"></a></td>
					<td class="td_label">
						<label>其他文件:</label>
					</td>
					<td class="td_input">
						<input type="file" value="" id="_filedata_E0_0" name="_filedata_E0_0" />
					</td>
					<td align="left">
						<a id="anotherOneBtn" class="easyui-linkbutton">添加文件</a>
					</td>
					<td class="td_remark">
						<input id="_remark_E0_0" name="_remark_E0_0" class="easyui-validatebox" data-options="required:false,validType:['maxLength[1,200]']" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr id="appendBeforeMe"></tr>
			</tbody>
		</table>
		<input type="text" name="_entNoForFiles" id="_entNoForFiles" style="display:none;" />
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
<script type="text/javascript">
//身份证
var IDENT_TYPE = '<%=BaseConstant.IDENTT_TYPE%>';

//计算字符串长度,中文按照3个字符计算
function countCharNum(str){
	if(str==null){
		return 0;
	}
	// return str.replace(/([\u4E00-\u9FA5\uF900-\uFA2D])/g,'aaa').length
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
		message: '英文全称应长度不超过{0}字符的英文字符串'
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
			var busiStartDate = $('#busiStartDate').datebox('getValue');
			if(isNotNull(busiStartDate) && busiStartDate<value){
				return false;
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
			var corpIdentType = $('#corpIdentType').combobox('getValue');
			if(isNull(corpIdentType) || corpIdentType!=IDENT_TYPE){
				return true;
			}
			return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
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
	
function checkBeforeSubmit(){
	if(!$('#coreEntAddForm').form('validate')){
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
	} else if(isNull($('#corpIdentType').combobox('getValue'))){
		$.messager.alert('提示信息','企业法人代表有效证件类型是必选项！','info');
		$('#corpIdentType_REF').get(0).click();
		return false;
	} else if(isNull($('#_filedata_E1').val())){
		$.messager.alert('提示信息','注册或登记证件还未上传！','info');
		$('#_filedata_E1_REF').get(0).click();
		return false;
	} else if(isNull($('#_filedata_E2').val())){
		$.messager.alert('提示信息','组织机构代码证还未上传！','info');
		$('#_filedata_E2_REF').get(0).click();
		return false;
	}
	/* delete by xrwang 2014-01-22,For:应贷款组要求去除这两个文件的必传验证
	else if(isNull($('#_filedata_E3').val())){
		$.messager.alert('提示信息','企业法人代表授权书还未上传！','info');
		$('#_filedata_E3_REF').get(0).click();
		return false;
	} else if(isNull($('#_filedata_E4').val())){
		$.messager.alert('提示信息','企业法人代表有效证件还未上传！','info');
		$('#_filedata_E4_REF').get(0).click();
		return false;
	}
	*/
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
// TODO不兼容IE8
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
		$('#coreEntFileAddForm').form('submit',{
			url: '${ctx}/base/busiGroup/coreEntAdd/saveFile',
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
	// 企业编号
	fileForm.append('_entNoForFiles', $("#_entNoForFiles").val());
	
	$.ajax({
		url:'${ctx}/base/busiGroup/coreEntAdd/saveFile',
		data:fileForm,
		datatype:'text',
		type:'POST',
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
			msg: '正在创建核心企业信息，请稍候...',
			text: ''
		});
		// 保存核心企业商圈数据
		$.ajax({
			type : 'POST',
			async: false,
			url : '${ctx}/base/busiGroup/coreEntAdd/saveCoreEnt',
			data : {
				// BusinessGroup
				busiGroupName:			$('#busiGroupName').val(),					// 商圈名称
				tradeCode:				$('#tradeCode').combotree('getValue'),		//归属行业
				qualityCredit:			$('#qualityCredit').combobox('getValue'),	//信用质量
				abilityPayable:			$('#abilityPayable').combobox('getValue'),	//偿债能力
				upLcAmt:				$('#upLcAmt').numberbox('getValue'),
				downLcAmt:				$('#downLcAmt').numberbox('getValue'),
				upLcValiddate:			$('#upLcValiddate').datebox('getValue'),
				coreEntSaleAmtPerYear:	$('#coreEntSaleAmtPerYear').numberbox('getValue'),
				coreEntSaleGrowthRate:	$('#coreEntSaleGrowthRate').numberbox('getValue'),
				saleGrossProfitRate:	$('#saleGrossProfitRate').numberbox('getValue'),
				assetLiabRate:			$('#assetLiabRate').numberbox('getValue'),
				listFlag:				$('#listFlag').combobox('getValue'),
				lyToCoreEntGoodsCost:	$('#lyToCoreEntGoodsCost').numberbox('getValue'),
				lyToCoreEntSaleIncome:	$('#lyToCoreEntSaleIncome').numberbox('getValue'),
				coreEntAcctInst:		$('#coreEntAcctInst').val(),
				coreEntAcct:			$('#coreEntAcct').val(),
				
				// EnterpriseInfo
				chineseFullname:	$('#chineseFullname').val(),					//中文全称
				registerIdentType:	$('#registerIdentType').combobox('getValue'),	//注册或登记证件类型
				chineseName:		$('#chineseName').val(),						//中文简称
				registerIdentNo:	$('#registerIdentNo').val(),					//注册或登记证件号码
				englishFullname:	$('#englishFullname').val(),					//英文全称
				registerCountry:	$('#registerCountry').combobox('getValue'),		//注册国家或地区
				englishName:		$('#englishName').val(),						//英文简称
				areaCode:			getAreaCode(),									//注册地区行政区划编号
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
				corpIdentMobile:	$('#corpIdentMobile').val()						//企业法人代表手机号
			},
			success : function(data, status) {
				$.messager.progress('close');
				if(showErrorMessage('创建核心企业(商圈)失败！', data)){
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
				$.messager.alert('错误信息','创建核心企业(商圈)失败！<br/>'+getJsonErrorMsg(data),'error');
				if(errorFunc){
					errorFunc(data, status);
				}
			},
			datatype : "json"
		});
	} else if(dataStep==2) {
		$.messager.alert('提示信息','核心企业创建成功！','info',function(){
			// 刷新父Tab dataGrid
			self.parent.reloadTabGrid("核心企业（商圈）维护","#coreEntDatagrid");
			// 关闭当前tab
			self.parent.closeCurrentTab();
		});
	} else {
		
	}
}

/**
 * 为了保证备注与文件能够一一对应，使用命名规则: 
 *	文件name = '_filedata_' + 类型  + '_' + 序号;
 *  备注name = '_remark_' + 类型 + '_' + 序号;
 */
var anotherOne = function(){
	fileCount++;
	var id = '' + 'OTHER_FILE_ID_'+fileCount;
	var fileId = '_filedata_E0_'+fileCount;
	var remarkId = '_remark_E0_'+fileCount;
	
	var htmlStr = '<tr id="'+id+'_TR">';
	htmlStr += '<td id="'+id+'_TD1" class="blank_td"><a id="'+fileId+'_REF" href="#'+fileId+'_REF" /></td>';
	htmlStr += '<td id="'+id+'_TD2" class="td_label"><labe></label></td>';
	htmlStr += '<td id="'+id+'_TD3" class="td_input"><input type="file" value="" id="'+fileId+'" name="'+fileId+'" /></td>';
	htmlStr += '<td id="'+id+'_TD4" align="left">';
	htmlStr += '<a id="'+id+'anotherOneBtn">添加文件</a>';
	htmlStr += '<a id="'+id+'deleteFile">删除</a>';
	htmlStr += '<td id="'+id+'_TD5" class="td_remark"><input id="'+remarkId+'" name="'+remarkId+'" class="easyui-validatebox" data-options="required:false,validType:[\'maxLength[1,200]\']" /></td>';
	htmlStr += '<td id="'+id+'_TD6" class="blank_td"></td></tr>';
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
	$('#'+fileId).change(function(){
		if(!checkFile($("#"+fileId).get(0))){
			$("#"+fileId).val('');
		}
	});
};

// 获取当前日期,格式'yyyy-MM-dd'
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

//获取注册行政区划
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

// 设置完整区域编号
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

var orgCodeValueChangeFlag = false;
$(document).ready(function(){
	// 绑定按钮方法
	$("[id^='anotherOneBtn']").click(anotherOne);
	
	$("[id^='submitBtn']").click(function(){
		if(!checkBeforeSubmit()){
			return;
		}
		$.messager.confirm('确认信息', '确定提交?', function(r){
			if(r){
				submitData(function(data, status){
					$.messager.alert('提示信息','核心企业创建成功！','info',function(){
						// 刷新父Tab dataGrid
						self.parent.reloadTabGrid("核心企业（商圈）维护","#coreEntDatagrid");
						// 关闭当前tab
						self.parent.closeCurrentTab();
					});
				}, function(data, status){
					$.messager.progress('close');
				});
			}
		});
	});
	$("[id^='backBtn']").click(function(){
		self.parent.closeCurrentTab();
	});
	
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
				panelHeight:'auto',
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
				panelHeight:'auto',
				value: '',
				method: 'post',
				url:'${ctx}/base/busiGroup/getCountyList/'+record.areaCode,
				valueField:'areaCode',
				textField:'areaName'
			});
		}
	});
	
	$("[id^='_filedata_']").change(function(){
		if(!checkFile($('#'+this.id).get(0))){
			$('#'+this.id).val('');
		}
	});
	
	// --------------- 行业下拉框树  start ---------------
	$('#tradeCode').combotree({
		lines:true,
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
	$.ajax({
		type : 'POST',
		async: false,
		url : '${ctx}/base/busiGroup/getTrades',
		success : function(data, status) {
			$('#tradeCode').combotree('tree').tree('loadData', data);
		},
		error : function(data, status) {
			$.messager.alert('错误信息','获取行业分类数据失败！<br/>'+getJsonErrorMsg(data),'error');
		},
		datatype : "json"
	});
	// --------------- 行业下拉框 END ---------------
	
	// 计算商圈总授信额度
	$('#upLcAmt').numberbox({
		onChange: function(newValue,oldValue){
			if(isNull(newValue)){
				$('#upLcAmt').numberbox('setValue', 0);
			}
			var downLcAmt = $('#downLcAmt').numberbox('getValue');
			var totalLcAmt = Number(isNull(newValue)?0:newValue) + Number(isNull(downLcAmt)?0:downLcAmt);
			$('#totalLcAmt').numberbox('setValue', totalLcAmt);
		}
	});
	$('#downLcAmt').numberbox({
		onChange: function(newValue,oldValue){
			if(isNull(newValue)){
				$('#downLcAmt').numberbox('setValue', 0);
			}
			var upLcAmt = $('#upLcAmt').numberbox('getValue');
			var totalLcAmt = Number(isNull(newValue)?0:newValue) + Number(isNull(upLcAmt)?0:upLcAmt);
			$('#totalLcAmt').numberbox('setValue', totalLcAmt);
		}
	});
	
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
	$('#lyToCoreEntGoodsCost').numberbox({
		onChange: function(newValue,oldValue){
			if(isNull(newValue)){
				$('#lyToCoreEntGoodsCost').numberbox('setValue', 0);
			}
		}
	});
	$('#lyToCoreEntSaleIncome').numberbox({
		onChange: function(newValue,oldValue){
			if(isNull(newValue)){
				$('#lyToCoreEntSaleIncome').numberbox('setValue', 0);
			}
		}
	});
	
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
				if(enterpriseInfoByOrgCode.coreFlag=='<%=BaseConstant.CORE_FLAG_Y%>'){
					$.messager.alert('提示信息','组织机构编号为['+enterpriseInfoByOrgCode.orgCode+']企业名称为['+enterpriseInfoByOrgCode.chineseFullname+']的核心企业已经存在','info',function(){
						$('#orgCode').val('');
					});
				} else {
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
							setAreaCode(enterpriseInfoByOrgCode.areaCode);								//注册地区行政区划编号
							$('#entType').combobox('setValue',enterpriseInfoByOrgCode.entType);				//单位类型
							$('#address').val(enterpriseInfoByOrgCode.address);							//注册地址
							$('#checkDate').datebox('setValue',enterpriseInfoByOrgCode.checkDate);			//组织机构代码年检日期
							$('#addressAttribute').combobox('setValue',enterpriseInfoByOrgCode.addressAttribute);	//注册地城乡属性
							$('#registerDate').datebox('setValue',enterpriseInfoByOrgCode.registerDate);			//注册或批准成立日期
							$('#regCheckDate').datebox('setValue',enterpriseInfoByOrgCode.regCheckDate);			//注册或登记证件年检日期
							$('#orgCode').val(enterpriseInfoByOrgCode.orgCode);								//组织机构代码
							$('#busiStartDate').datebox('setValue',enterpriseInfoByOrgCode.busiStartDate);		//营业或有效期限起始日期
							$('#corpIdentType').combobox('setValue',enterpriseInfoByOrgCode.corpIdentType);		//企业法人代表有效证件类型
							$('#busiEndDate').datebox('setValue',enterpriseInfoByOrgCode.busiEndDate);			//营业或有效期限终止日期
							$('#corpIdentNo').val(enterpriseInfoByOrgCode.corpIdentNo);						//企业法人代表有效证件号码
							$('#corpName').val(enterpriseInfoByOrgCode.corpName);							//企业法人代表姓名
							$('#corpIdentMobile').val(enterpriseInfoByOrgCode.corpIdentMobile);					//企业法人代表手机号
						} else {
							$('#orgCode').val('');
						}
					});
				}
			}
		}
	});
});
</script>
</body>
</html>