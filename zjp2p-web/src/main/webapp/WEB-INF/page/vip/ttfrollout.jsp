<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="com.zjgt.shiro.ShiroMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!doctype html>
<html>
<head>
<title>天天富 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
<script type="text/javascript"> 
$(function(){
	$("#ttfSubmit").click(function(){
		butDisabled($("#ttfSubmit"));
		var $outAmount = $('#ttfAmount').val();
		var $dealpassword = $("#ttfPassword").val();
		console.info({dealpassword:$dealpassword,outAmout:$outAmount});
		$.ajax({
			type:"post",
			url:"ttfSumRollout.do",
			data:{dealpassword:$dealpassword,outAmout:$outAmount,canoutamount:$("input[name=canoutamount]").val()},
			dataType:"json",
		success:function(data){
			if(data.result=="申请成功"){
				$("#ttfSubmit").attr("data-am-modal","{target: '#success'}");
				$("#success").modal({closeViaDimmer:0});
				$("#success").modal('open');
				$("#conform1").on('click',function(data){
					window.location.href="${ctx}/member/ttfrecord.do";
				});
// 				butEnabled($("#ttfSubmit"),"确认转出");
			}
			if(data.result=="转出金额不能为空"){
				$("#amterror").html(data.result);
				$("#pwderror").html("");
				butEnabled($("#ttfSubmit"),"确认转出");
			}else if(data.result=="请输入正整数"){
				$("#amterror").html(data.result);
				$("#pwderror").html("");
				butEnabled($("#ttfSubmit"),"确认转出");
			}else if(data.result=="转出金额不能大于订单金额"){
				$("#amterror").html(data.result);
				$("#pwderror").html("");
				butEnabled($("#ttfSubmit"),"确认转出");
			}else if(data.result=="天天富转出金额不能大于余额!"){
				$("#amterror").html(data.result);
				$("#pwderror").html("");
				butEnabled($("#ttfSubmit"),"确认转出");
			}else if(data.result=="交易密码不能为空"){
				$("#pwderror").html(data.result);
				$("#amterror").html("");
				butEnabled($("#ttfSubmit"),"确认转出");
			}else if(data.result=="交易密码未设置"){
				$("#pwderror").html(data.result+"　"+"<a href='securitycenter.do' style='margin-top:-5px;'>去设置交易密码 </a>")
				$("#amterror").html("");
				butEnabled($("#ttfSubmit"),"确认转出");
			}else if(data.result=="交易密码输入错误"){
				$("#pwderror").html(data.result);
				$("#amterror").html("");
				butEnabled($("#ttfSubmit"),"确认转出");
			}else{
				$("#pwderror").html(data.result);
				butEnabled($("#ttfSubmit"),"确认转出");
			}
		},
		error:function(data){
			$("#ttfSubmit").attr("data-am-modal","{target: '#error'}");
			$("#msg").html(getJsonErrorMsg(data));
			$("#error").modal({closeViaDimmer:0});
			$("#error").modal('open');
			$("#conform2").on('click',function(data){
				window.location.href="${ctx}/member/ttfrolloutIndex.do";
				 butEnabled($("#ttfSubmit"),"确认转出");
			});
		}
		});
	});
});

function fn_browse() 
{ 
document.test_form.browse.click(); 
document.test_form.file.value = document.all.test_form.browse.value; 
} 
</script>
</head>

<body>
<%@include file="../header.jsp"%>
<!--网站logo 导航条  end-->

<div class="person_info">
  <%@include file="left.jsp"%>
  <div class="person_info_right" >
    <div class="member_h"><img src="${ctx}/static/images/member_icon06.png" style="margin-top:-5px; vertical-align:middle" alt=""/><span style="color:#009CE4; font-size:18px;line-height:normal;"> 天天富转出</span></div>
    <div class="personalinfo" style="margin-top:60px;">
      <div style="margin-left:23px; font-size:18px; color:#565A5C">转出至可用资金：</div>
      <hr data-am-widget="divider" style="width:90%;margin-left:20px; margin-top:10px;" class="am-divider am-divider-default" />
      <div style="margin-left:33px; margin-top:40px; font-size:16px; color:#565A5C">天天富总金额：<span style="color:#f00; font-size:18px;"><fmt:formatNumber value="${amount}" type="number" maxFractionDigits="2"/></span> 元</div>
      
      <div style="margin-left:33px; margin-top:40px; font-size:16px; color:#565A5C">
        <span style="display:block;float:left">本次转出金额：</span>
        <input type="text" id="ttfAmount" class="am-form-field am-radius" style="width:115px; height:30px; float:left" autocomplete="off"/>　<span style="display:block;float:left;margin-left:10px;">元</span> 
        <div style="float:left; margin-left:10px;margin-top:4px;color:#f00; font-size:14px;" id="amterror"></div>      
      </div>
      <input type="hidden" name="canoutamount" value="${canoutamount}" >
      <div style="margin-left:145px; margin-top:7px; font-size:13px; color:#565A5C">本次最多可转出 <span style="color:#EA544A"><fmt:formatNumber value="${canoutamount}" type="number" maxFractionDigits="2"/></span> 元　　每人每天累计最大转出资金限额为 <span style="color:#EA544A">50,000</span> 元</div>
      
      <div style="margin-left:33px; margin-top:40px; font-size:16px; color:#565A5C; position: relative;">
        <span style="display:block;float:left">交易密码：　　</span>
        <input type="password" id="ttfPassword" class="am-form-field am-radius" style="width:115px; height:30px; float:left" autocomplete="off"/>
        <div style="position:absolute; left:237px;top:4px;color:#f00; font-size:14px;" id="pwderror"></div>        
      </div>
      <div style="margin-left:-225px; margin-top:60px; font-size:16px; float:left">
        <button type="button" class="am-btn am-btn-secondary" id="ttfSubmit"  data-am-modal="{closeViaDimmer: 0}">确认转出</button>　　<button type="button" class="am-btn am-btn-secondary" onclick="window.location.href='${ctx}/member/ttfrecord.do'">返 回</button>
      </div>
      
      <div class="am-modal am-modal-alert" tabindex="-1" id="success">
        <div class="am-modal-dialog">
          <div class="am-modal-hd">转出成功</div>
          <div class="am-modal-footer">
            <span class="am-modal-btn" id="conform1">确定</span>
          </div>
         </div>
       </div>
       
       <div class="am-modal am-modal-alert" tabindex="-2" id="error">
        <div class="am-modal-dialog">
          <div class="am-modal-hd">转出失败</div>
          <div class="am-modal-bd" id="msg">
          </div>
           <div class="am-modal-footer">
             <span class="am-modal-btn" id="conform2">确定</span>
           </div>
         </div>
       </div>
      
      <div class="dealtips2" style="margin-left:33px; margin-top:210px;height:130px;">
        <span style="color:#f00">备注</span><br>
1.  买入天天富当天即可转出，转出当天不计息；<br>
2.  天天富当前的手续费是0元；<br>
3.  当总金额＜100元时，不产生收益；<br>
4.  每人每天累计最大转出资金限额为50,000元 （具体限额以页面显示为准）；
      </div>
    </div>
  </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>
