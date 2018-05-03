<%@page import="com.zjgt.util.DateConverterUtil"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="com.zjgt.shiro.ShiroMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!doctype html>
<html>
<head>
<title>个人资料 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<%
    Subject subject = SecurityUtils.getSubject();
			ShiroMember currUser = (ShiroMember) subject.getPrincipal();
%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet"	type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/joinus.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/qqJsAddress.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>

<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
<script type="text/javascript">
	$(function() {
		if ($("#doc-vld-name").val() == "null") {
			$("#doc-vld-name").attr("value", "");
		}
		if ($("#doc-vld-name-2").val() == "null") {
			$("#doc-vld-name-2").attr("value", "");
		}
		if ($("#datepicker").val() == "null") {
			$("#datepicker").attr("value", "");
		}
		if ($("#mobile").val() == "null") {
			$("#mobile").attr("value", "");
		}
		if ($("#address").val() == "null") {
			$("#address").attr("value", "");
		}
		if ($("#email").val() == "null") {
			$("#email").attr("value", "");
		}
		var ifjoinexpence="<shiro:principal property="ifjoinexpence"/>";
		if(ifjoinexpence=="true"){
			$("#ifjoinexpence").attr("checked","checked");
		}
		if(ifjoinexpence=="false"){
			$("#ifjoinexpence").attr("checked",false);
		}
		var gender='<shiro:principal property="gender"/>';
		if(gender=="0"){
			$("option[value=0]").attr("selected","selected");
		}
		else if(gender=="1"){
			$("option[value=1]").attr("selected","selected");
		}else{
			$("option[value=2]").attr("selected","selected");
		}
		String.prototype.len = function() {
		    return this.replace(/[^\x00-\xff]/g, 'xx').length;
		};
		$("#s1").click(function() {
			var reg = "\d{4}[-](\d{2})[-]\d{2}";
			var $date = $("#datepicker").val();
			if($.trim($("input[name='nickname']").val()).len>8&&$.trim($("input[name='nickname']").val()).len==0){
				$("#JSnickname").html("<font color='red'>昵称不能为空且不能超过4个中文或8个字母</font>");
				return false;
			}
			else{
				var selectAddress = $('#addressProvince').val()+','+$('#addressCity').val()+','+$('#addressTown').val()+',';
				$('#address').val(selectAddress+$('#address').val());
				$("#form1").submit();
			}
		});
		setup();
		var fullAddress = '<shiro:principal property="address"/>';
		var addressArray = fullAddress.split(',');
		var addressStr = '';
		for(var i=3;i<addressArray.length;i++){
			addressStr+=addressArray[i]+',';
		}
		addressStr = addressStr.substring(0,addressStr.length-1);
		$('#address').val(addressStr);
		if(addressArray[0]!='省份'){
			$('#addressProvince').val(addressArray[0]);
			$('#addressProvince').change();
		}
		if(addressArray[1]!='城市'){
			$('#addressCity').val(addressArray[1]);
			$('#addressCity').change(); 
		}
		if(addressArray[2]!='区域'){
			$('#addressTown').val(addressArray[2]); 
		}  
	});
</script>
</head>

<body>
	<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
		<div class="am-modal-dialog" style="height: 250px;">
			<div class="am-modal-hd">
				认证手机号码 <a href="javascript: void(0)" class="am-close am-close-spin"
					data-am-modal-close>&times;</a>
			</div>
			<div class="am-modal-bd">
				<span style="font-size: 30px">请确定的手机号是否存在!!点击<span
					style="font-size: 32px">修 改</span>按钮
				</span>
			</div>
		</div>
	</div>

	<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-2">
		<div class="am-modal-dialog" style="height: 250px;">
			<div class="am-modal-hd">
				认证邮箱地址 <a href="javascript: void(0)" class="am-close am-close-spin"
					data-am-modal-close>&times;</a>
			</div>
			<div class="am-modal-bd">
				<span style="font-size: 30px">请确定的邮箱是否真实!!点击<span
					style="font-size: 32px">修 改</span>按钮
				</span>

			</div>
		</div>
	</div>




	<%@include file="../header.jsp"%>
	<!--网站logo 导航条  end-->
	<div class="person_info">

		<%@include file="left.jsp"%>

		<div class="person_info_right">
			<div class="member_h"><img src="${ctx}/static/images/member_icon04.png" style="margin-top:-5px; vertical-align:middle" alt=""/><span style="color:#009CE4; font-size:18px;line-height:normal;"> 个人资料</span>
			</div>

			<div class="personalinfo">
			    
				<form class="am-form am-form-horizontal" id="form1" action="${ctx }/member/updatecenter.do" method="post">
					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -6px; font-weight: normal">昵 称：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="doc-vld-name" minlength="3" maxlength="8" placeholder="昵称的长度在3-8字之内"
								name="nickname" style="width: 380px; height: 30px;"
								value="<shiro:principal property="nickname"/>"> <small id="JSnickname">马上给自己取一个个性昵称吧</small>
						</div>
					</div>

					<div class="am-form-group" style="margin-top: 25px;">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -6px; font-weight: normal">姓 名：</label>
						<div class="am-u-sm-10">
					<c:if test="${membersafety.idcardifverified==0 }">		<input type="text" class="am-input-sm" id="doc-vld-name-2"  name="realname"
								style="width: 380px; height: 30px;" 
								value="<shiro:principal property="realname"/>" onpropertychange="if(isNaN(value)) value=value.substring(0,value.length-1);" maxlength="8" size="14"></c:if> 
					<c:if test="${membersafety.idcardifverified==1 }">		<input type="text" class="am-input-sm" id="name" name="realname"
								style="width: 380px; height: 30px;" placeholder="姓名的长度在3-8字之内"
								value="<shiro:principal property="realname"/>" disabled="false" onpropertychange="if(isNaN(value)) value=value.substring(0,value.length-1);" maxlength="5" size="14"></c:if> 			
								<small>请告诉您的真实姓名，方便您在百富网的资产管理。</small>
						</div>
					</div>

					<div class="am-form-group" style="margin-top: 15px;">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -6px; font-weight: normal">性 别：</label>
						<div class="am-u-sm-10">
							<select name="gender" class="am-input-sm" id="doc-select-2"
								style="width: 100px; height: 30px; padding-top: 1px; padding-bottom: 0px;"
								value="<shiro:principal property="gender"/>">
								<option value="2">请选择</option>
								<option value="1">男</option>
								<option value="0">女</option>
							</select> <small>请选择您的性别，我们会为您保密的</small>
						</div>
					</div>

					<div class="am-form-group" style="margin-top: 15px;">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -6px; font-weight: normal">出生日期：</label>
						<div class="am-u-sm-10">
							<%	
							
								String loginDate=null;
								if(currUser.getBirth()!=null){
							    	loginDate = DateConverterUtil.formatDate((currUser.getBirth()));
							    }
							%>
							<input type="text" class="am-form-field am-radius"
								id="datepicker" data-am-datepicker="{format: 'yyyy-mm-dd'}"
								name="birthday" value=<%=loginDate%>
								style="width: 290px; height: 30px; padding-top: 1px; padding-bottom: 0px;">
							<small id="JSdate">请选择您的出生日期，也许你会收获意外的惊喜哦</small>
						</div>
					</div>

					<div class="am-form-group" style="margin-top: 15px;">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -6px; font-weight: normal">电子邮件：</label>
						<div class="am-u-sm-10">
							<input type="email" class="am-input-sm" id="email"
								style="width: 290px; height: 30px; padding-top: 1px; padding-bottom: 0px; float: left;"
								value="<shiro:principal property="email"/>" disabled="false">
							
							<c:if test="${membersafety.emailifverified==0}"><small style="float: left; width: 100%; margin-top: 3px;">邮箱账号为您的登录账号，请及时进行认证，确保账户安全</small></c:if>
							<c:if test="${membersafety.emailifverified!=0 }"><small style="float: left; width: 100%; margin-top: 3px;">邮箱账号为您的登录账号</small></c:if>
						</div>
					</div>

					<div class="am-form-group" style="margin-top: 15px;">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -6px; font-weight: normal">手机号码：</label>
						<div class="am-u-sm-10">
					<c:if test="${membersafety.mobileifverified==0 }"> <input type="text" class="am-input-sm" id="mobile" name="mobile"
								style="width: 290px; height: 30px; padding-top: 1px; padding-bottom: 0px; float: left;"
								value="<shiro:principal property="mobile"/>" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" > 
					</c:if>			
					<c:if test="${membersafety.mobileifverified==1 }"> <input type="text" class="am-input-sm" id="mobile" name="mobile"
								style="width: 290px; height: 30px; padding-top: 1px; padding-bottom: 0px; float: left;"
								value="<shiro:principal property="mobile"/>" disabled="false" > 
					</c:if>		
							<small style="float: left; width: 100%; margin-top: 3px;" id="JSmobile">请填写您的手机号码，第一时间了解您的资金动态</small>
						</div>
					</div>

					<div class="am-form-group" style="margin-top: 15px;">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -6px; font-weight: normal">联系地址：</label>
						<div class="am-u-sm-10">
								<select class="select" name="addressProvince" id="addressProvince" style="width: 100px; float:left">
								  <option></option>
								</select>
								<select class="select" name="addressCity" id="addressCity" style="width: 100px;float:left">
								  <option></option>
								</select>
								<select class="select" name="addressTown" id="addressTown" style="width: 100px;">
								  <option></option>
								</select>
								<input type="text" class="am-input-sm" id="address"
								name="address" style="width: 380px; height: 30px;"
								value=""> <small>请输入您的联系地址，方便资料及礼品的寄送，当然，我们会为您保密的</small>
						</div>
					</div>

					<div class="am-form-group" style="font-weight: normal;margin-top:-12px;">
						<label class="am-form-label" style="margin-left: 150px;">
							<input type="checkbox" name="ifjoinexpence" value="1" id="ifjoinexpence" checked="checked"> <small
							style="font-weight: normal; margin-top: -10px;">您是否愿意加入百富网用户体验计划？如愿意，请勾选，谢谢！</small>
						</label>
					</div>
					<div style="width: 400px; margin-left: 150px;">
						<input type="button" id="s1" class="am-btn am-btn-secondary" value="保 存">
						<c:if test="${status==1 }"><div style="margin-left: 100px; margin-top:-35px;"><span class="am-icon-check" style="color:#24A85F"></span> 保存成功</div> </c:if>
						<c:if test="${status==0 }"><div style="margin-left: 100px; margin-top:-35px;"><span class="am-icon-check" style="color:#24A85F"></span> 保存失败</div> </c:if>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp"%>
</body>
</html>
