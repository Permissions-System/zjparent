<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>会员管理->用户列表</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	//快速查询
 	function searchUserQ()
	{
 		var membername = $("input[name='membername']").val();
 		var mobile = $("input[name='mobile']").val();
 		var recommendcode = $("input[name='recommendcode']").val();
 		var recommendperson = $("input[name='recommendperson']").val();
 		var promotecode = $("input[name='promotecode']").val();
 		var firstinvestmoney = $("input[name='firstinvestmoney']").val();
 		var hasfuiou = $("input[name='hasfuiou']").val();
 		var regBeginTime = $("input[name='regBeginTime']").val();
 		var regEndTime = $("input[name='regEndTime']").val();
 		var firstInvBeginTime = $("input[name='firstInvBeginTime']").val();
 		var firstInvEndTime = $("input[name='firstInvEndTime']").val();
 		
 		if(regEndTime!=null && regEndTime!=''){
 			var sear=new RegExp('23:59:59');
			if(!sear.test(regEndTime))
			{
			　　regEndTime = regEndTime +" 23:59:59";
			}
		}
 		if(firstInvEndTime!=null && firstInvEndTime!=''){
 			firstInvEndTime = firstInvEndTime +" 23:59:59";
		}
 		
	 	$('#datagrid').datagrid('reload',{
	 		membername: membername,
	 		mobile: mobile,
	 		recommendcode: recommendcode,
	 		recommendperson: recommendperson,
	 		promotecode: promotecode,
	 		firstinvestmoney: firstinvestmoney,
	 		hasfuiou: hasfuiou,
	 		regBeginTime: regBeginTime,
	 		regEndTime: regEndTime,
	 		firstInvBeginTime: firstInvBeginTime,
	 		firstInvEndTime: firstInvEndTime
		}); 
	}
	
 	/**
 	 * 格式化 是否开户 字段 
 	 *
 	 * @param num 数值(Number或者String)
 	 * @return 字符串,如0未开户,1已开户
 	 * @type String
 	 */
 	function formatHasfuiou(hasfuiou) 
 	{
 		var result;
 		if(hasfuiou==0)
 		{
 			result="未开户";
 		}
 		else if(hasfuiou==1)
		{
			result="已开户";
		}
		else
		{
			result="";
		}
 		return result;
 	}
 	
 	function fmtSex(sex){
 		if(sex=='F'){
 			return "女 ";
 		}else if(sex=='M'){
 			return "男";
 		}
 		
 	}
	
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="会员管理->用户列表" class="easyui-datagrid" fit="true"
			url="${path}//userList/datagrid"  pagination="true" toolbar="#tb"
			fitColumns="false" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<th data-options="field:'membername',width:100,align:'center'" >会员名称</th>
					<th data-options="field:'realname',width:100,align:'center'" >真实姓名</th>
					<th data-options="field:'mobile',width:100,align:'center'" >手机号</th>
					<th data-options="field:'hasfuiou',width:100,align:'center',formatter:formatHasfuiou" >富有开户</th>
					<th data-options="field:'regtime',width:150,align:'center',formatter:CEdit" >注册时间</th>
					<th data-options="field:'nearlyinvestmoney',width:100,align:'center',formatter:formatCurrency" >近投金额</th>
					<th data-options="field:'nearlyinvesttime',width:150,align:'center',formatter:CEdit" >近投时间</th>
					<th data-options="field:'firstinvestmoney',width:100,align:'center',formatter:formatCurrency" >首投金额</th>
					<th data-options="field:'firstinvesttime',width:150,align:'center',formatter:CEdit" >首投时间</th>
					<th data-options="field:'recommendperson',width:100,align:'center'" >推荐人</th>
					<th data-options="field:'recommendcode',width:100,align:'center'" >推荐码</th>
					<th data-options="field:'promotecode',width:100,align:'center'" >推广渠道码</th>
					<th data-options="field:'identity',width:100,align:'center'" >身份</th>
					<th data-options="field:'area',width:150,align:'center'" >地域</th>
					<th data-options="field:'gender',width:150,align:'center',formatter:fmtSex" >性别</th>
					<th data-options="field:'age',width:150,align:'center'" >年龄</th>
					<th data-options="field:'accountbalance',width:150,align:'center',formatter:formatCurrency" >账户余额</th>
					<th data-options="field:'addrechargemoney',width:150,align:'center',formatter:formatCurrency" >累计充值金额</th>
					<th data-options="field:'addwithdrawalmoney',width:150,align:'center',formatter:formatCurrency" >累计提现金额</th>
					<th data-options="field:'addinvestmoney',width:150,align:'center',formatter:formatCurrency" >累计投资金额</th>
					<th data-options="field:'addinvestcnt',width:150,align:'center',formatter:formatCurrency" >累计提现次数</th>
					<th data-options="field:'zjbnum',width:150,align:'center'" >中金币数量</th>
					<th data-options="field:'recommendregcnt',width:150,align:'center'" >推荐注册数</th>
					<th data-options="field:'addlogincnt',width:150,align:'center'" >累计登入次数</th>
					<th data-options="field:'lastlogintime',width:150,align:'center',formatter:CEdit" >最后登录时间</th>
					<th data-options="field:'record',width:150,align:'center'" >记录</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="tb" style="padding:5px;">
			<div >
				<form id="" action="" method="post">
					会员名称：<input class="" style="width:100px" name="membername" >
					手机号码：<input class="" style="width:100px" name="mobile" >
					推荐码：<input class="" style="width:100px" name="recommendcode" >
					推荐人：<input class="" style="width:100px" name="recommendperson" >
					推广渠道码：<input class="" style="width:100px" name="promotecode" ><br/>
					是否投资：
					<select class="easyui-combobox" name="firstinvestmoney" panelHeight="auto" style="width:100px">
						<option value="-1" selected="selected">全部</option>
						<option value="0">无投资</option>
						<option value="1">已有投资</option>
					</select>
					富有：
					<select class="easyui-combobox" name="hasfuiou" id="yearStr" panelHeight="auto" style="width:100px">
						<option value="">全部</option>
						<option value="1">已开户</option>
						<option value="0">未开户</option>
					</select>
					
					注册时间 : 
					<input class="easyui-datebox" style="width:100px" name="regBeginTime">
					- 
					<input class="easyui-datebox" style="width:100px" name="regEndTime">
					首次投资时间 : 
					<input class="easyui-datebox" style="width:100px" name="firstInvBeginTime">
					- 
					<input class="easyui-datebox" style="width:100px" name="firstInvEndTime">
					
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:searchUserQ();" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">Search</a>
					<input type="reset" />
				</form>
			</div>
		</div>

	</div>
</body>
</html>
