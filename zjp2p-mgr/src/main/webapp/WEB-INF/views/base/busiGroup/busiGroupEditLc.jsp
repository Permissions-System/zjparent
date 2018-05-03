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
.span_required {
    color: red;
}
input[class="easyui-numberbox numberbox-f validatebox-text"] {
	text-align: right;
}
</style>
<body>
	<div>
		<div>
			<div style="padding-top: 20px;">
				<p style="text-align: center;">
					<span style="font-size: 16px; font-weight: bold; font-style: normal;">调整商圈额度信息</span>
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
						<label for="busiGroupCode">商圈代码:</label>
					</td>
					<td class="td_input">
						<input id="busiGroupCode" class="easyui-validatebox" disabled="disabled" value="${busiGroup.busiGroupCode}" />
					</td>
					<td class="td_label">
						<label for="busiGroupName">商圈名称:</label>
					</td>
					<td class="td_input">
						<input id="busiGroupName" class="easyui-validatebox" disabled="disabled" value="${busiGroup.busiGroupName}" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="tradeCode">归属行业:</label>
					</td>
					<td class="td_input">
						<input id="tradeCode" class="easyui-combotree" disabled="disabled" data-options="value:'${busiGroup.tradeCode}'">
					</td>
					<td class="td_label">
						<label for="listFlag">是否上市企业:</label>
					</td>
					<td class="td_input">
						<input id="listFlag" class="easyui-combobox" disabled="disabled" data-options="value:'${busiGroup.listFlag}',multiple:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_ENT_LIST_FLAG%>'">
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="qualityCredit">信用质量:</label>
					</td>
					<td class="td_input">
						<input id="qualityCredit" class="easyui-combobox" disabled="disabled" data-options="value:'${busiGroup.qualityCredit}',multiple:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_LN_DIC_DDIRBCDRATE%>'">
					</td>
					<td class="td_label">
						<label for="abilityPayable">偿债能力:</label>
					</td>
					<td class="td_input">
						<input id="abilityPayable" class="easyui-combobox" disabled="disabled" data-options="value:'${busiGroup.abilityPayable}',multiple:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/busiGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_LN_DIC_DDDEBTABILITY%>'">
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="upLcLimit">上游额度编码:</label>
					</td>
					<td class="td_input">
						<input id="upLcLimit" class="easyui-validatebox" disabled="disabled" value="${busiGroup.upLcLimit}" />
					</td>
					<td class="td_label">
						<label for="downLcLimit">下游额度编码:</label>
					</td>
					<td class="td_input">
						<input id="downLcLimit" class="easyui-validatebox" disabled="disabled" value="${busiGroup.downLcLimit}" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="upLcAmt">上游授信额度(万元):</label>
					</td>
					<td class="td_input">
						<input id="upLcAmt" type="text" class="easyui-numberbox" value="${busiGroup.upLcAmt}" 
							data-options="min:0,max:99999999999,precision:0,groupSeparator:',',validType:['upLcAmt[]']" />
					</td>
					<td class="td_label">
						<label for="downLcAmt">下游授信额度(万元):</label>
					</td>
					<td class="td_input">
						<input id="downLcAmt" type="text" class="easyui-numberbox" value="${busiGroup.downLcAmt}"
							data-options="min:0,max:99999999999,precision:0,groupSeparator:',',validType:['downLcAmt[]']" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="upUcAmt">上游用信额度(万元):</label>
					</td>
					<td class="td_input">
						<input id="upUcAmt" type="text" class="easyui-numberbox" disabled="disabled" data-options="min:0,precision:0,groupSeparator:','"
							value="${busiGroup.upUcAmt}" />
					</td>
					<td class="td_label">
						<label for="downUcAmt">下游用信额度(万元):</label>
					</td>
					<td class="td_input">
						<input id="downUcAmt" type="text" class="easyui-numberbox" disabled="disabled" data-options="min:0,precision:0,groupSeparator:','"
							value="${busiGroup.downUcAmt}" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="totalLcAmt">商圈总授信额度(万元):</label>
					</td>
					<td class="td_input">
						<input id="totalLcAmt" type="text" class="easyui-numberbox" disabled="disabled" data-options="min:0,precision:0,groupSeparator:','"
							value="${busiGroup.totalLcAmt}" />
					</td>
					<td class="td_label">
						<label for="upLcValiddate"><span class="span_required">*</span>商圈授信到期日:</label>
					</td>
					<td class="td_input">
						<input id="upLcValiddate" type="text" class="easyui-datebox" data-options="required:true,editable:false"
							value="${busiGroup.upLcValiddate}" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="coreEntSaleAmtPerYear">近一年核心企业年销售收入(万元):</label>
					</td>
					<td class="td_input">
						<input id="coreEntSaleAmtPerYear" type="text" class="easyui-numberbox" disabled="disabled" data-options="min:0,precision:2,groupSeparator:','"
							value="${busiGroup.coreEntSaleAmtPerYear}"  />
					</td>
					<td class="td_label">
						<label for="coreEntSaleGrowthRate">近一年核心企业销售增长率(%):</label>
					</td>
					<td class="td_input">
						<input id="coreEntSaleGrowthRate" type="text" class="easyui-numberbox" disabled="disabled" data-options="min:0,max:100,precision:2,groupSeparator:','"
							value="${busiGroup.coreEntSaleGrowthRate}"  />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="saleGrossProfitRate">近一年核心企业销售毛利率(%):</label>
					</td>
					<td class="td_input">
						<input id="saleGrossProfitRate" type="text" class="easyui-numberbox" disabled="disabled" data-options="min:0,max:100,precision:2,groupSeparator:','"
							value="${busiGroup.saleGrossProfitRate}"  />
					</td>
					<td class="td_label">
						<label for="assetLiabRate">近一年核心企业资产负债率(%):</label>
					</td>
					<td class="td_input">
						<input id="assetLiabRate" type="text" class="easyui-numberbox" disabled="disabled" data-options="min:0,max:100,precision:2,groupSeparator:','"
							value="${busiGroup.assetLiabRate}" />
					</td>
					<td class="blank_td"></td>
				</tr>
				<tr>
					<td class="blank_td"></td>
					<td class="td_label">
						<label for="lyToCoreEntGoodsCost">上年度对核心企业进货成本(万元):</label>
					</td>
					<td class="td_input">
						<input id="lyToCoreEntGoodsCost" type="text" class="easyui-numberbox" disabled="disabled" data-options="min:0,precision:2,groupSeparator:','"
							value="${busiGroup.lyToCoreEntGoodsCost}" />
					</td>
					<td class="td_label">
						<label for="lyToCoreEntSaleIncome">上年度对核心企业销售收入(万元):</label>
					</td>
					<td class="td_input">
						<input id="lyToCoreEntSaleIncome" type="text" class="easyui-numberbox" disabled="disabled" data-options="min:0,precision:2,groupSeparator:','"
							value="${busiGroup.lyToCoreEntSaleIncome}" />
					</td>
					<td class="blank_td"></td>
				</tr>
			</tbody>
		</table>
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
//校验规则
$.extend($.fn.validatebox.defaults.rules, {
	maxLength: {
		validator: function(value, param){
			// param[0]字符串类型: 1-数字英文字符, 2-中文字符
			if(param[0]==2){
				return value.length*3 <= param[1];
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
	upLcAmt: {
		validator: function(value, param){
			try{
				var upUcAmt = $('#upUcAmt').numberbox('getValue');
				if(isNull(value)){
					return (0>=Number(upUcAmt));
				} else {
					var numValue = value.replace(/\,/g,'');
					return (Number(numValue)>=Number(upUcAmt));
				}
			} catch (e){
				
			}
		},
		message: '上游授信额度不应小于上游用信额度'
	},
	downLcAmt: {
		validator: function(value, param){
			try{
				var downUcAmt = $('#downUcAmt').numberbox('getValue');
				if(isNull(value)){
					return (0>=Number(downUcAmt));
				} else {
					var numValue = value.replace(/\,/g,'');
					return (Number(numValue)>=Number(downUcAmt));
				}
			} catch (e){
				
			}
		},
		message: '下游授信额度不应小于下游用信额度'
	}
});

function checkBeforeSubmit(){
	if(!$('#coreEntAddForm').form('validate')){
		return false;
	}
	return true;
}

function submitData(sucessFunc, errorFunc){
	if(!checkBeforeSubmit()){
		return;
	}
	$.messager.progress({
		title: '',
		msg: '正在调整商圈额度信息，请稍候...',
		text: ''
	});
	// 保存核心企业商圈数据
	$.ajax({
		type : 'POST',
		async: false,
		url : '${ctx}/base/busiGroup/busiGroupEditLc/updateBusiGroupLc',
		data : {
			// BusinessGroup
			busiGroupCode:			$('#busiGroupCode').val(),		// 商圈代码
			upLcAmt:				$('#upLcAmt').numberbox('getValue'),
			downLcAmt:				$('#downLcAmt').numberbox('getValue'),
			upUcAmt:				$('#upUcAmt').numberbox('getValue'),
			downUcAmt:				$('#downUcAmt').numberbox('getValue'),
			upLcValiddate:			$('#upLcValiddate').datebox('getValue')
		},
		success : function(data, status) {
			if(sucessFunc){
				sucessFunc(data);	
			}
		},
		error : function(data, status) {
			$.messager.progress('close');
			$.messager.alert('错误信息','调整商圈额度信息失败！<br/>'+getJsonErrorMsg(data),'error');
			if(errorFunc){
				errorFunc(data, status);
			}
		},
		datatype : "json"
	});
}

//关闭当前tab页
function closeTab(){
	// 刷新父Tab dataGrid
	self.parent.reloadTabGrid("核心企业（商圈）维护","#coreEntDatagrid");
	// 关闭当前tab
	self.parent.closeCurrentTab();
}

//解析Ajax请求失败的json错误信息
function getJsonErrorMsg(data){
	var errorMsg = '';
	if(data && data.responseText){
		// errorMsg = JSON.parse(data.responseText).string;
		errorMsg = (eval('('+data.responseText+')')).string;
	}
	return errorMsg;
}

$(document).ready(function(){
	// 初始化页面值
	// 下拉框
	$('#listFlag').combobox('setValue', '${busiGroup.listFlag}');

	// 绑定按钮动作
	$("[id^='submitBtn']").click(function(){
		$.messager.confirm('确认信息', '确定提交?', function(r){
			if(r){
				submitData(function(){
					$.messager.alert('提示信息', '商圈额度信息更新成功！','info', function(){
						closeTab();
					});
				}, function(){
					
				});
			}
		});
	});
	$("[id^='backBtn']").click(function(){
		// closeTab();
		self.parent.closeCurrentTab();
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
					async: false,//务必使用同步请求，否则菜单展开会有问题
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
	if(isNull('${busiGroup.tradeCode}')){
		$.ajax({
			type : 'POST',
			async: false,//务必使用同步请求，否则菜单展开会有问题
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
			async: false,//务必使用同步请求，否则菜单展开会有问题
			url : '${ctx}/base/busiGroup/getTreeForTrade/${busiGroup.tradeCode}',
			success : function(data, status) {
				tree.tree('loadData', data);
			},
			error : function(data, status) {
				$.messager.alert('错误信息','获取行业分类数据失败！<br/>'+getJsonErrorMsg(data),'error');
			},
			datatype : "json"
		});
		var treeNode = tree.tree('find', '${busiGroup.tradeCode}');
		if(treeNode && treeNode.target) {
			tree.tree('expandTo', treeNode.target);
		}
	}
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
	
	
	if(isNull($('#coreEntSaleAmtPerYear').numberbox('getValue'))){
		$('#coreEntSaleAmtPerYear').numberbox('setValue', 0);
	}
	if(isNull($('#coreEntSaleGrowthRate').numberbox('getValue'))){
		$('#coreEntSaleGrowthRate').numberbox('setValue', 0);
	}
	if(isNull($('#saleGrossProfitRate').numberbox('getValue'))){
		$('#saleGrossProfitRate').numberbox('setValue', 0);
	}
	if(isNull($('#assetLiabRate').numberbox('getValue'))){
		$('#assetLiabRate').numberbox('setValue', 0);
	}
	if(isNull($('#lyToCoreEntGoodsCost').numberbox('getValue'))){
		$('#lyToCoreEntGoodsCost').numberbox('setValue', 0);
	}
	if(isNull($('#lyToCoreEntSaleIncome').numberbox('getValue'))){
		$('#lyToCoreEntSaleIncome').numberbox('setValue', 0);
	}
});
</script>
</body>
</html>