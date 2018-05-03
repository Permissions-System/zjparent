<%@ page language="java" pageEncoding="UTF-8"%>
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
input[class="easyui-numberbox numberbox-f validatebox-text"] {
	text-align: left;
}
input[id='coreEntSaleAmtPerYear'] {
    border: 0px;
}
input[id='coreEntSaleGrowthRate'] {
    border: 0px;
}
input[id='saleGrossProfitRate'] {
    border: 0px;
}
input[id='assetLiabRate'] {
    border: 0px;
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
		$.messager.show({
			title: '消息',
			msg: '没有图片可供预览！',
			timeout: 5000,
			showType: 'slide'
		});
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
	var img = $('<img />').attr("src", '${ctx}/base/file/download/'+fileNo +'/00').load(function(){
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
</script>
<body>
	<div>
		<div>
			<div style="padding-top: 20px;">
				<p style="text-align: center;">
					<span style="font-size: 16px; font-weight: bold; font-style: normal;">核心企业商圈信息</span>
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
						<label>商圈代码:</label>
					</td>
					<td class="td_input">
						${busiGroup.busiGroupCode}
					</td>
					<td class="td_label">
						<label>商圈名称:</label>
					</td>
					<td class="td_input">
						${busiGroup.busiGroupName}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>归属行业:</label>
					</td>
					<td class="td_input">
						${trade.tradeName}
					</td>
					<td class="td_label">
						<label>是否上市企业:</label>
					</td>
					<td class="td_input">
						${busiGroup.listFlag}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>信用质量:</label>
					</td>
					<td class="td_input">
						${busiGroup.qualityCredit}
					</td>
					<td class="td_label">
						<label>偿债能力:</label>
					</td>
					<td class="td_input">
						${busiGroup.abilityPayable}
					</td>
					<td class="blank_td"></td>
				</tr>
				<!-- 应贷款组要求去除额度相关信息 xrwang 2014-02-24
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>上游额度编码:</label>
					</td>
					<td class="td_input">
						${busiGroup.upLcLimit}
					</td>
					<td class="td_label">
						<label>下游额度编码:</label>
					</td>
					<td class="td_input">
						${busiGroup.downLcLimit}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>上游授信额度(万元):</label>
					</td>
					<td id="upLcAmt" class="td_input">
						${busiGroup.upLcAmt}
					</td>
					<td class="td_label">
						<label>下游授信额度(万元)：</label>
					</td>
					<td id="downLcAmt" class="td_input">
						${busiGroup.downLcAmt}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>上游用信额度(万元):</label>
					</td>
					<td id="upUcAmt" class="td_input">
						${busiGroup.upUcAmt}
					</td>
					<td class="td_label">
						<label>下游用信额度(万元)：</label>
					</td>
					<td id="downUcAmt" class="td_input">
						${busiGroup.downUcAmt}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>商圈总授信额度(万元):</label>
					</td>
					<td id="totalLcAmt" class="td_input">
						${busiGroup.totalLcAmt}
					</td>
					<td class="td_label">
						<label>商圈授信到期日:</label>
					</td>
					<td class="td_input">
						${busiGroup.upLcValiddate}
					</td>
					<td class="blank_td"></td>
				</tr>
				-->
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>近一年核心企业年销售收入(百万元):</label>
					</td>
					<td class="td_input">
                    <input id="coreEntSaleAmtPerYear" type="text" class="easyui-numberbox"
                            data-options="required:false,value:0,min:0,max:999999.99,precision:2" value="${busiGroup.coreEntSaleAmtPerYear}"/>
					</td>
					<td class="td_label">
						<label>近一年核心企业销售增长率(%):</label>
					</td>
					<td class="td_input">
						<input id="coreEntSaleGrowthRate" type="text" class="easyui-numberbox" value="${busiGroup.coreEntSaleGrowthRate}"
						                           data-options="required:false,value:0,min:0,max:100,precision:2" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label">近一年核心企业销售毛利率(%):</label>
					</td>
					<td  class="td_input">
                        <input id="saleGrossProfitRate" type="text" class="easyui-numberbox" value="${busiGroup.saleGrossProfitRate}"
                            data-options="required:false,value:0,min:0,max:100,precision:2" />
					</td>
					<td class="td_label">
						<label>近一年核心企业资产负债率(%):</label>
					</td>
					<td class="td_input">
                        <input id="assetLiabRate" type="text" class="easyui-numberbox" value="${busiGroup.assetLiabRate}"
                            data-options="required:false,value:0,min:0,max:100,precision:2" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<!--
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>上年度对核心企业进货成本(万元):</label>
					</td>
					<td id="lyToCoreEntGoodsCost" class="td_input">
						${busiGroup.lyToCoreEntGoodsCost}
					</td>
					<td class="td_label">
						<label>上年度对核心企业销售收入(万元):</label>
					</td>
					<td id="lyToCoreEntSaleIncome" class="td_input">
						${busiGroup.lyToCoreEntSaleIncome}
					</td>
					<td class="blank_td"></td>
				</tr>
				 -->
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
					<td id="coreEntAcctInst" class="td_input">
						${busiGroup.coreEntAcctInst}
					</td>
					<td class="td_label">
						<label>收款账号:</label>
					</td>
					<td id="coreEntAcct" class="td_input">
						${busiGroup.coreEntAcct}
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
						<label>中文全称:</label>
					</td>
					<td class="td_input">
						${coreEnt.chineseFullname}
					</td>
					<td class="td_label">
						<label>注册或登记证件类型:</label>
					</td>
					<td class="td_input">
						${coreEnt.registerIdentType}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>中文简称:</label>
					</td>
					<td class="td_input">
						${coreEnt.chineseName}
					</td>
					<td class="td_label">
						<label>注册或登记证件号码:</label>
					</td>
					<td class="td_input">
						${coreEnt.registerIdentNo}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>英文全称:</label>
					</td>
					<td class="td_input">
						${coreEnt.englishFullname}
					</td>
					<td class="td_label">
						<label>注册国家或地区:</label>
					</td>
					<td class="td_input">
						${country.cnName}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>英文简称:</label>
					</td>
					<td class="td_input">
						${coreEnt.englishName}
					</td>
					<td class="td_label">
						<label>注册地行政区划:</label>
					</td>
					<td class="td_input">
						${areaCodeProvince.areaName}&nbsp;&nbsp;${areaCodeCity.areaName}&nbsp;&nbsp;${areaCodeCounty.areaName}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>单位类型:</label>
					</td>
					<td class="td_input">
						${coreEnt.entType}
					</td>
					<td class="td_label">
						<label>注册地址:</label>
					</td>
					<td class="td_input">
						${coreEnt.address}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>组织机构代码年检日期:</label>
					</td>
					<td class="td_input">
						${coreEnt.checkDate}
					</td>
					<td class="td_label">
						<label>注册地城乡属性:</label>
					</td>
					<td class="td_input">
						${coreEnt.addressAttribute}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>注册或批准成立日期:</label>
					</td>
					<td class="td_input">
						${coreEnt.registerDate}
					</td>
					<td class="td_label">
					   <label>企业邮箱:</label>
					</td>
					<td class="td_input">
					   ${coreEnt.email}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>注册或登记证件年检日期:</label>
					</td>
					<td class="td_input">
						${coreEnt.regCheckDate}
					</td>
					<td class="td_label">
						<label>组织机构代码:</label>
					</td>
					<td class="td_input">
						${coreEnt.orgCode}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>营业或有效期限起始日期:</label>
					</td>
					<td class="td_input">
						${coreEnt.busiStartDate}
					</td>
					<td class="td_label">
						<label>企业法人代表有效证件类型:</label>
					</td>
					<td class="td_input">
						${coreEnt.corpIdentType}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>营业或有效期限终止日期:</label>
					</td>
					<td class="td_input">
						${coreEnt.busiEndDate}
					</td>
					<td class="td_label">
						<label>企业法人代表有效证件号码:</label>
					</td>
					<td class="td_input">
						${coreEnt.corpIdentNo}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>企业法人代表姓名:</label>
					</td>
					<td class="td_input">
						${coreEnt.corpName}
					</td>
					<td class="td_label">
						<label>企业法人代表手机号:</label>
					</td>
					<td class="td_input">
						${coreEnt.corpIdentMobile}
					</td>
					<td class="blank_td"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<form id="coreEntFileAddForm" style="margin: 0px" enctype="multipart/form-data">
		<table style="width: 100%;height:100%" border="0" cellpadding="2" cellspacing="3" align="center">
			<tbody>
				<tr>
					<td colspan="6"><hr /></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">名称</td>
					<td></td>
					<td align="left">操作</td>
					<td class="td_remark">备注</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>注册或登记证件:</label>
					</td>
					<td class="td_input">
						${e1File.fileName}
					</td>
					<td align="left">
						<a onclick="javascript:viewImgFile('${e1File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${e1File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_remark">
						${e1File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>组织机构代码证:</label>
					</td>
					<td class="td_input">
						${e2File.fileName}
					</td>
					<td align="left">
						<a onclick="javascript:viewImgFile('${e2File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${e2File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_remark">
						${e2File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>企业法人代表授权书:</label>
					</td>
					<td class="td_input">
						${e3File.fileName}
					</td>
					<td align="left">
						<a onclick="javascript:viewImgFile('${e3File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${e3File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_remark">
						${e3File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				<!--  
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>企业法人代表有效证件:</label>
					</td>
					<td class="td_input">
						${e4File.fileName}
					</td>
					<td align="left">
						<a onclick="javascript:viewImgFile('${e4File.fileNo}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${e4File.fileNo}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_remark">
						${e4File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				-->
				<c:forEach items="${e0FileList}" var="e0File">
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label>其他文件:</label>
					</td>
					<td class="td_input">
						${e0File.fileName}
					</td>
					<td align="left">
						<a onclick="javascript:viewImgFile('${e0File.filePath}')" class="easyui-linkbutton">预览</a>
						<a onclick="javascript:downloadFile('${e0File.filePath}')" class="easyui-linkbutton">下载</a>
					</td>
					<td class="td_remark">
						${e0File.description}
					</td>
					<td class="blank_td"></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<table style="width: 100%;height:100%" border="0" cellpadding="2" cellspacing="3" align="center">
		<tbody>
			<tr><td><hr /></td></tr>
			<tr>
				<td align="center">
					<a id="backBtn" class="easyui-linkbutton" data-options="iconCls:'icon-back'">返回</a>
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
// 弹出全局图片预览
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

$(document).ready(function(){
	$("[id^='backBtn']").click(function(){
		self.parent.closeCurrentTab();
	});
});

</script>
</body>
</html>