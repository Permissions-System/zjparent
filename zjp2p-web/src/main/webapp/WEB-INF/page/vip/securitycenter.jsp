 <%@page import="java.util.Date"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="com.zjgt.shiro.ShiroMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>
<head>
<title>账户认证 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/joinus.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.cookie.js"></script>
<script language="javascript" type="text/javascript"> 
function fn_browse() 
{ 
document.test_form.browse.click(); 
document.test_form.file.value = document.all.test_form.browse.value; 
} 
</script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
<script type="text/javascript">
	//身份实名认证
	$(function(){
		$("#bankcard1").click(function(){
			alert("请先实名认证，再进行银行卡认证");
		});
		$("#bankcard2").click(function(){
			alert("请先实名认证，再进行银行卡认证");
		});

		$("#s1").click(function(){
				 if($("#realname").val()==""){
					$("#JSrealname").html("<font color='red'>姓名不能为空</font>");
					return false;
				} else {
					$.post("${ctx}/member/idcardisuseful.do",{idcard:$("#idcard").val()},function(data){
						if(data.status=="1"){
							$("#JSrealname").html("&nbsp");
							$("#fromidcard").submit();
						}else{
							$("#JSidcard").html("<font color='red'>身份证错误</font>");
							return false;
						}
					});
				}
				
		});
		/**
		* author:ruiz
		* StrNo:用户输入的身份证件号码
		* _id:用来承载错误信息的控件ID号,用来进行友好提示
		*判断身份证号码格式函数
		*公民身份号码是特征组合码，
		*排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码
		*如果验证通过　返回 true
		*/
		function IdentityCodeValid(code) { 
            var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
            var tip = "";
            var pass= true;
            if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
                tip = "身份证号格式错误";
                pass = false;
            }
            
           else if(!city[code.substr(0,2)]){
                tip = "地址编码错误";
                pass = false;
            }
            else{
                //18位身份证需要验证最后一位校验位
                if(code.length == 18){
                    code = code.split('');
                    //∑(ai×Wi)(mod 11)
                    //加权因子
                    var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
                    //校验位
                    var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
                    var sum = 0;
                    var ai = 0;
                    var wi = 0;
                    for (var i = 0; i < 17; i++)
                    {
                        ai = code[i];
                        wi = factor[i];
                        sum += ai * wi;
                    }
                    var last = parity[sum % 11];
                    if(parity[sum % 11] != code[17]){
                        tip = "校验位错误";
                        pass =false;
                    }
                }
            }
            if(!pass) $("#JSidcard").html("<font color='red'>"+tip+"</font>");
            return pass;
        }
	});
</script>

<script type="text/javascript">
//验证邮箱
	$(function(){
		$("#emailclick1").click(function(){
			alert("邮箱已认证！！");
		});
		$("#emailclick2").click(function(){
			alert("邮箱已认证！！");
		});
		$("#emailclick3").click(function(){
			alert("邮箱已认证！！");
		});
		$("#emailclick4").click(function(){
			alert("邮箱已认证！！");
		});
		$("#sendemail").click(function(){
			butDisabled($("#sendemail"));
			var url="${ctx}/sendemailagain.do";
			$.post(url,{email:$("#email").val()},function(data){
				alert(data.result);
				butEnabled($("#sendemail"),"发送激活邮件");
				$("#doc-modal-2").modal("close");
			});
		});
		
		$("#formtsendemail").click(function(){
				$("#JSformtemail").html(" ");
				var $formtemail=$.trim($("#formtemail").val());
				var reg=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
				if($formtemail==""){
					$("#JSformtemail").html("<font color='red'>邮箱不能为空</font>")
				}else if(!reg.test($formtemail)){
					$("#JSformtemail").html("<font color='red'>邮箱格式不正确</font>")
				}else{
					$.get("${ctx}/emailajax.do?email="+$formtemail,function(date){
						if(date.result=="E-mail不可用"){
							$("#JSformtemail").html("<font color='red'>邮箱已被认证</font>");
							emailisuseful=false;
						}else{
							$.get("${ctx}/sendemailagain.do?email="+$("#formtemail").val(),function(data){
								alert(data.result);
								$("#doc-modal-10").modal("close");
							});
						}
					})
				}
			});
	});
</script>
<script type="text/javascript">
//重置登录密码
	$(function(){
		var oldpassword=false;
		var newpassword=false;
		var renewpassword=false;
		var mobilecode=false;
		$("#newpassword").blur(function(){
			var $newpassword=$.trim($("#newpassword").val());
			 var reg=/^[a-zA-Z0-9]\w{5,19}$/;
			 if($newpassword==""){
				 $("#JSnewpassword").html("<font color='red'>密码不能为空</font>");
				 newpassword=false;
			 }else if(!reg.test($newpassword)){
				 $("#JSnewpassword").html("<font color='red'>密码长度为6~20位字符</font>");
				 newpassword=false;
			 }else{
				 $("#JSnewpassword").html("<font color='green'>密码格式正确</font>");
				 newpassword=true;
			 }
		});
		$("#renewpassword").blur(function(){
			 var $renewpassword=$.trim($("#renewpassword").val());
			 var $newpassword=$.trim($("#newpassword").val());
			 if($newpassword==""){
				 $("#JSrenewpassword").html("<font color='red'>确定密码不能为空</font>");
				 renewpassword=false;
			 }
			 else if($renewpassword!=$newpassword){
				 $("#JSrenewpassword").html("<font color='red'>密码不相同</font>");
				 renewpassword=false;
			 }else {
				 $("#JSrenewpassword").html("<font color='green'>两次密码一致</font>");
				 renewpassword=true;
			 }
		 });
		function time(o,wait) {
	        if (wait == 0) {
	        	$.cookie("time",0);
	            o.removeAttribute("disabled");          
	            o.value="免费获取验证码";
	            wait = 60;
	        } else {
	            o.setAttribute("disabled", true);
	            o.value="重新发送(" + wait + ")";
	            wait--;
	            $.cookie("time",wait);
	            setTimeout(function() {
	                time(o,wait)
	            },
	            1200)
	        }
	    }
		$("#clickformobile").click(function(){
			$("#JSmoilecode").html("　");
			var o2=document.getElementById("sendmobilecode2");
			time(o2,60);
			var o=document.getElementById("clickformobile");
			time(o,60);
			$.get("sendMobilcode.do?mobile=${membersafety.mobile}",function(){
			});
		});
		$("#oldpassword").blur(function(){
			var $oldpassword=$("#oldpassword").val();
			$.post("oldpasswordisright.do",{oldpassword:$oldpassword},function(data){
				if(data.result=="密码匹配"){
					$("#JSoldpassword").html("<font color='green'>"+data.result+"</font>");
					oldpassword=true;
				}else{
					$("#JSoldpassword").html("<font color='red'>"+data.result+"</font>");
				}
			})
		});
		$("#s3").click(function(){
			if(oldpassword&&newpassword&&renewpassword){
				$.post("mobilecodeisright.do",{code:$("#mobilecode").val()},function(data){
					if(data.result=="验证码正确"){
						$.post("alterPassword.do",{newpassword:$("#newpassword").val()},function(){
							window.location.href="${ctx}/member/securitycenter.do";
						});
					}else{
						$("#JSmoilecode").html("<font color='red'>"+data.result+"</font>");
					}
				});
			}else{
				return false;
			}
		});
		$("#mobile1").click(function(){
			//手机没认证不能修改密码
			alert("手机没认证不能修改密码！！！");
		});
	});
</script>
<script type="text/javascript">
//认证手机号码
	$(function(){
			var mobile=false;
			var mobilecode1=false;
			var wait=60;
			function time(o,wait) {
			        if (wait == 0) {
			        	$.cookie("time",0);
			        	o.removeAttribute("disabled");          
			            o.value="免费获取验证码";
			            wait = 60;
			        } else {
			            o.setAttribute("disabled", true);
			            o.value="重新发送(" + wait + ")";
			            wait--;
			            $.cookie("time",wait);
			            setTimeout(function() {
			                time(o,wait)
			            },
			            1200)
			        }
			    }
	       $("#sendmobile1").click(function(){
	    	   $("#JSmobile").html("　");
	    	   if($("#mobile").val()==""){
	    		   $("#JSmobile").html("<font color='red'>手机不能为空</font>");
	    		   return;
	    	   	}
	    	   var reg=/1[3-8]+\d{9}/;
	    	   if(!reg.test($("#mobile").val())){
	    		   $("#JSmobile").html("<font color='red'>您输入的手机号码有误</font>");
	    		   return ;
	    	   }
	    	   $.post("mobileisusable.do",{mobile:$("#mobile").val()},function(data){
	    		   if(data.status=="0"){
	    			   $("#JSmobile").html("<font color='red'>手机已被认证</font>");
	    		   }else {
	    			   var o1=document.getElementById("clickformobile");
	   					time(o1,60);
	   					var o2=document.getElementById("sendmobilecode2");
	    				time(o2,60);
	    				var o=document.getElementById("sendmobile1");
	    				time(o,60);
	    			   //$("#JSmobile").html("");
	    			   $.get("sendMobilcode.do?mobile="+$("#mobile").val(),function(){
	    				   mobilecode1=true;
					});
	    		   }
	    	   })
	       });
	       $("#s4").click(function(){
	    	   if($mobile=$("#mobile").val()==""){
	    		   return false;
	    	   }
	    	   $.post("mobilecodeisright.do",{code:$("#code").val()},function(data){
					if(data.result=="验证码正确"){
						$.post("authenticationMobile.do",{"mobile":$("#mobile").val()},function(){
							window.location.href="${ctx}/member/securitycenter.do";
						});
					}else{
						$("#JScode").html("<font color='red'>"+data.result+"</font>");
					}
				});
	    	   return false;
	       });
	});
</script>
<script type="text/javascript">
	$(function(){
		var time=parseInt($.cookie("time"));
		function showtime(o,wait) {
			if (wait == 0) {
				$.cookie("time",0);
	            o.removeAttribute("disabled");          
	            o.value="免费获取验证码";
	            wait = 60;
	        } else {
	            o.setAttribute("disabled", true);
	            o.value="重新发送(" + wait + ")";
	            wait--;
	            $.cookie("time",wait);
	            setTimeout(function() {
	                showtime(o,wait)
	            },
	            1200)
	        }
	    }
		if(time>0){
		var o1=document.getElementById("clickformobile");
		showtime(o1,time);
		var o2=document.getElementById("sendmobilecode2");
		showtime(o2,time);
		var o3=document.getElementById("sendmobile1");
		showtime(o3,time);}
	});
</script>
<script type="text/javascript">
//交易密码设置
	$(function(){
		 var mobilecode2=false;
		 var dealpassword=false;
		 var redealpassword=false;
		 var notEqualsLoginPw=false;
		 $("#dealpassword").blur(function(){
			 dealpassword=false;
			 redealpassword=false;
			 var $dealpassword=$.trim($("#dealpassword").val());
			 var reg=/^[a-zA-Z0-9]\w{5,19}$/;
			 if($dealpassword==""){
				 $("#JSdealpassword").html("<font color='red'>交易密码不能为空</font>");
				 
			 }else if(!reg.test($dealpassword)){
				 $("#JSdealpassword").html("<font color='red'>密码长度为6~20位字符</font>");
			 }else{
				 $("#JSdealpassword").html("<font color='green'>密码格式正确</font>");
				 dealpasswordValidate();
				 dealpassword=true;
			 }
		});
		$("#redealpassword").blur(function(){
			 redealpassword=false;
			 var $redealpassword=$.trim($("#redealpassword").val());
			 var $dealpassword=$.trim($("#dealpassword").val());
			 if($redealpassword==""){
				 $("#JSredealpassword").html("<font color='red'>确定密码不能为空</font>");
			 }
			 else if($redealpassword!=$dealpassword){
					 $("#JSredealpassword").html("<font color='red'>两次密码不一致</font>");
			 }else{
					 $("#JSredealpassword").html("<font color='green'>两次密码输入一致</font>");
					 redealpassword=true;
			 }
			 
		 });
		function time(o,wait) {
	        if (wait == 0) {
	        	$.cookie("time",0);
	            o.removeAttribute("disabled");          
	            o.value="免费获取验证码";
	            wait = 60;
	        } else {
	            o.setAttribute("disabled", true);
	            o.value="重新发送(" + wait + ")";
	            wait--;
	            $.cookie("time",wait);
	            setTimeout(function() {
	                time(o,wait)
	            },
	            1200)
	        }
	    }
		function dealpasswordValidate(){
			notEqualsLoginPw = false;
			var newPw = $("#dealpassword").val();
			$.ajax( {
				async : false,
				type : "POST",
				dataType : "json",
				url : "dealpasswordValidate.do",
				data : {"newPw":newPw},
				success : function(data) {
					if(data.status=='FAIL'){
						$("#JSdealpassword").html("<font color='red'>"+data.msg+"</font>");	
						notEqualsLoginPw = false;
					}else{
						notEqualsLoginPw = true;
					}
				}
			});
		}
		 $("#sendmobilecode2").click(function(){
				$("#JSmobilecode2").html("　");
			 	var o1=document.getElementById("clickformobile");
				time(o1,60);
				var o=document.getElementById("sendmobilecode2");
				time(o,60);
	    		$.get("sendMobilcode.do?mobile=${membersafety.mobile}",function(){
	    			
				});
	       });
		 $("#sdeal").click(function(){
			 	butDisabled($("#sdeal"));
				//alert(dealpassword+' '+redealpassword+' '+notEqualsLoginPw);
			 	if(dealpassword&&redealpassword&&notEqualsLoginPw){
				$.post("mobilecodeisright.do?code="+$("#mobilecode2").val(),function(data){
					if(data.result=="验证码正确"){
						$.post("dealpassword.do",{"dealpassword":$("#dealpassword").val()},function(){
							butEnabled($("#sdeal"),"提交");
							window.location.href="${ctx}/member/securitycenter.do";
						});					
					}else{
						butEnabled($("#sdeal"),"提交");
						$("#JSmobilecode2").html("<span style='color:red'>"+data.result+"</span>");
						return false;
					}
				});
			 	}	
			});
		 $("#ta1").click(function(){
			 alert("请先进行手机认证,再设置交易密码!");
		 });
		 $("#ta2").click(function(){
			 alert("请先进行手机认证,再设置交易密码!");
		 });
		 $("#againcheck").click(function(){
			window.location.href="securitycenter.do"; 
		 });
		 if ($("#realname").val() == "null") {
				$("#realname").attr("value", "");
			}
		 if ($("#mobile").val() == "null") {
				$("#mobile").attr("value", "");
			}
	});

</script>
</head>

<body>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
  <div class="am-modal-dialog" style="height:320px;">
    <div class="am-modal-hd">手机认证<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div>
    <div class="am-modal-bd" style="margin-top:-20px"> <span style="font-size:14px">请仔细填写常用手机号码，保证信息正确。</span>
      <form class="am-form am-form-horizontal" action="authenticationMobile.do" method="post" style="width:90%; margin-top:20px; margin-left:auto; margin-right:auto">
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-4 am-form-label" style=" font-weight:normal">新手机号码：</label>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="text" class="am-input-sm" id="mobile" name="mobile" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px; float:left" value="<shiro:principal property="mobile"/>" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
            <a href="#"><input type="button" id="sendmobile1"  style="color:#000;height:26px;margin-left:10px; margin-top:0px; float:left" value="发送验证码"></a> <small style="float:left; margin-left:-240px; margin-top:30px;" id="JSmobile">&nbsp;　</small> </div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-4 am-form-label" style="font-weight:normal; margin-top:33px;">短信验证码：</label>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="text" class="am-input-sm" id="code" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;">
            <small id="JScode">&nbsp;</small> </div>
        </div>
        <div style="margin-top:30px; margin-left:100px; float:left">
          <input type="submit" id="s4" name="s4" class="am-btn am-btn-secondary" style="width:180px;" value="提 交">
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px;margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
    </div>
  </div>
</div>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-3">
  <div class="am-modal-dialog" style="height:330px;">
    <div class="am-modal-hd">实名认证<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div>
    <div class="am-modal-bd" style="margin-top:-20px"> <span style="font-size:14px">请仔细填写本人身份证号码，保证信息正确。</span>
      <form class="am-form am-form-horizontal" action="${ctx }/member/authenticationIDcard.do" method="post" id="fromidcard" style="width:90%; margin-top:20px; margin-left:auto; margin-right:auto">
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-4 am-form-label" style=" font-weight:normal">姓名：</label>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="text" class="am-input-sm" id="realname" name="realname" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;" value="<shiro:principal property="realname"/>">
            <small id="JSrealname">　</small> </div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-4 am-form-label" style="font-weight:normal; margin-top:35px;">身份证号码：</label>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="text" class="am-input-sm" id="idcard" name="idcard" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;">
            <small id="JSidcard">&nbsp</small> </div>
        </div>
        <div style="margin-top:20px; margin-left:100px; float:left">
          <input type="button" id="s1" class="am-btn am-btn-secondary" style="width:180px;" value="提交">
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px; margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
      
    </div>
  </div>
</div>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-4">
  <div class="am-modal-dialog" style="height:470px;">
    <div class="am-modal-hd">设置交易密码<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div>
    <div class="am-modal-bd" style="margin-top:-20px"> <span style="font-size:14px">交易密码不等同于登录密码，请仔细核实并牢记交易密码。</span>
      <form class="am-form am-form-horizontal" action="dealpassword.do" method="post" style="width:90%; margin-top:20px; margin-left:auto; margin-right:auto">
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-4 am-form-label" style="font-weight:normal; margin-top:15px;">请输入密码：</label>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="password" class="am-input-sm" id="dealpassword" name="dealpassword" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;" placeholder="6~20位字符，可为数字、字母、符号">
            <small id="JSdealpassword">&nbsp;</small> </div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-4 am-form-label" style="font-weight:normal; margin-top:35px;">请再次输入密码：</label>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="password" class="am-input-sm" id="redealpassword" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;" placeholder="请再次输入密码">
            <small id="JSredealpassword">&nbsp;</small> </div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-4 am-form-label" style=" font-weight:normal; margin-top:35px;">手机验证：</label>
          <div class="am-u-sm-8">
            <input type="text" class="am-input-sm" id="mobilecode2" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;float:left;margin-top:15px;">
            <a href="#"><input type="button" id="sendmobilecode2" style="color:#000;height:26px;margin-left:10px; margin-top:18px; float:left" value="发送验证码"></a> <small style="float:left; margin-left:-250px; margin-top:45px;" id="JSmobilecode2">&nbsp;</small> </div>
        </div>
        <div style="margin-top:30px; margin-left:100px; float:left">
          <input type="button" id="sdeal" name="sdeal" class="am-btn am-btn-secondary" style="width:180px;" value="提 交">
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px;margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
      <div style="font-size:12px; float:left; text-align:left; margin-top:20px; margin-left:110px; color:#999"><span style="color:#EA544A">温馨提示</span><br>
        交易密码长度在6~20个字符之间，且不能与登录密码相同</div>
    </div>
  </div>
</div>
<%@include file="bankCardBind.jsp"%>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-6">
  <div class="am-modal-dialog" style="height:490px;">
    <div class="am-modal-hd">修改登录密码<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div>
    <div class="am-modal-bd" style="margin-top:-20px"> <span style="font-size:14px">因涉及资金管理，请认真填写登录密码，保证信息正确。</span>
      <form class="am-form am-form-horizontal"  "width:90%; margin-top:10px; margin-left:auto; margin-right:auto">
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-4 am-form-label" style="font-weight:normal; margin-top:15px;">旧密码：</label>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="password" class="am-input-sm" id="oldpassword" name="oldpassword" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;">
            <small id="JSoldpassword">&nbsp;</small> </div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-4 am-form-label" style="font-weight:normal; margin-top:35px;">新密码：</label>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="password" class="am-input-sm" id="newpassword" name="newpassword" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;">
            <small id="JSnewpassword">注意密码的格式</small> </div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-4 am-form-label" style="font-weight:normal; margin-top:35px;">确认新密码：</label>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="password" class="am-input-sm" id="renewpassword" name="renewpassword" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;">
            <small id="JSrenewpassword">请记住新密码</small> </div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-4 am-form-label" style=" font-weight:normal; margin-top:37px;">手机验证：</label>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="text" class="am-input-sm" id="mobilecode" name="mobilecode" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;float:left;margin-top:15px;">
            <a href="#"><input type="button" id="clickformobile" style="color:#000;height:26px;margin-left:10px; margin-top:18px; float:left" value="短信验证"></a> <small style="float:left; margin-left:-213px; margin-top:45px;" id="JSmoilecode">　</small> </div>
        </div>
        <div style="margin-top:30px; margin-left:100px; float:left">
          <input type="button" id="s3" name="s3" value="提 交" class="am-btn am-btn-secondary" style="width:180px;">
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px;margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
    </div>
  </div>
</div>
<%@include file="../header.jsp"%>
<!--网站logo 导航条  end-->

<div class="person_info">
  <%@include file="left.jsp"%>
  <div class="s_right">
    <div class="member_h"><img src="${ctx}/static/images/member_icon03.png" style="margin-top:-5px; vertical-align:middle" alt=""/><span style="color:#009CE4; font-size:18px;line-height:normal;"> 账户认证</span></div>
    <div class="safeinfo">
      <div class="s_l">
        <div class="s_l1">
          <div class="s_v"><c:if test="${membersafety.idcardifverified==0 }"><a href="#" data-am-modal="{target: '#doc-modal-3', closeViaDimmer: 0}" style="color:#EA544A;"><span style="font-size:20px">1.</span>实名认证 ＞</a>　　　　<a href="#" data-am-modal="{target: '#doc-modal-3', closeViaDimmer: 0}" style="color:#EA544A;font-size:13px;"><span class="am-icon-times-circle" ></span></a></c:if><c:if test="${membersafety.idcardifverified==1 }"><a href="#" id="idcard1" style="color:#3DB236;"><span style="font-size:20px">1.</span>实名认证 ＞</a>　　　　　<a href="#" id="idcard2" style="color:#3DB236;font-size:13px;"><span class="am-icon-check-circle" ></span></a></c:if></div>
          <div class="s_b"><c:if test="${membersafety.realname!=null }">姓名：${membersafety.realname }</c:if><c:if test="${membersafety.realname==null }">完善身份信息，保障账户安全。</c:if></div>
        </div>
         <div class="s_l2">
          <div class="s_v"><c:if test="${membersafety.email!=null}"><c:if test="${membersafety.emailifverified==0 }"><a href="#" data-am-modal="{target: '#doc-modal-2', closeViaDimmer: 0}" style="color:#EA544A;"><span style="font-size:20px">6.</span>电子邮件认证 ＞</a> 　　<a href="#" data-am-modal="{target: '#doc-modal-2', closeViaDimmer: 0}" style="color:#EA544A;font-size:13px;"><span class="am-icon-times-circle" ></span></a></c:if><c:if test="${membersafety.emailifverified==1 }"><a href="#" id="emailclick1" style="color:#3DB236;"><span style="font-size:20px">6.</span>电子邮件认证 ＞</a> 　　　<a href="#" id="emailclick2" style="color:#3DB236;font-size:13px;"><span class="am-icon-check-circle" ></span></a></c:if></c:if>
          <c:if test="${membersafety.email==null}"><c:if test="${membersafety.emailifverified==0 }"><a href="#" data-am-modal="{target: '#doc-modal-10', closeViaDimmer: 0}" style="color:#EA544A;"><span style="font-size:20px">6.</span>电子邮件认证 ＞</a> 　　<a href="#" data-am-modal="{target: '#doc-modal-10', closeViaDimmer: 0}" style="color:#EA544A;font-size:13px;"><span class="am-icon-times-circle" ></span></a></c:if><c:if test="${membersafety.emailifverified==1 }"><a href="#" id="emailclick3" style="color:#3DB236;"><span style="font-size:20px">6.</span>电子邮件认证 ＞</a> 　　　　<a href="#" id="emailclick4" style="color:#3DB236;font-size:13px;"><span class="am-icon-check-circle" ></span></a></c:if></c:if>
          </div>
      		  <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-2">
  				<div class="am-modal-dialog" style="height:270px;">
   					 <div class="am-modal-hd">认证邮箱地址<br>
			<hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>

     		 <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
   			 </div>
   			 <div class="am-modal-bd"  style="margin-top:-20px">
     	 <span style="font-size:14px">请仔细核对电子邮件地址</span>
     	 <form class="am-form am-form-horizontal" style="width:90%; margin-top:20px; margin-left:auto; margin-right:auto">
    		<div class="am-form"><label for="user-name" class="am-u-sm-4 am-form-label" style=" font-weight:normal; margin-top:-7px;">邮箱：</label>
            <div class="am-u-sm-8">
              <input type="text" class="am-input-sm" id="email" value="${membersafety.email }" style="width: 200px; height:30px; padding-top:1px; padding-bottom:0px;float:left;"  placeholder="请输入新的邮箱地址" disabled="false">
 		 </div></div>
  		
  			<div style="margin-top:30px; margin-left:100px; float:left"><button id="sendemail" type="button" class="am-btn am-btn-secondary" style="width:180px;">发送激活邮件</button> 　　<a href="javascript: void(0)"  data-am-modal-close style="font-size:16px; margin-top:3px;">取 消</a>
				</div>  </form>
    		</div>
		</div>
	</div>
	  <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-10">
  				<div class="am-modal-dialog" style="height:270px;">
   					 <div class="am-modal-hd">认证邮箱地址<br>
			<hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>

     		 <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
   			 </div>
   			 <div class="am-modal-bd"  style="margin-top:-20px">
     	 <span style="font-size:14px">请仔细核对电子邮件地址，保证信息正确。</span>
     	 <form class="am-form am-form-horizontal" style="width:90%; margin-top:20px; margin-left:auto; margin-right:auto">
    		<div class="am-form"><label for="user-name" class="am-u-sm-4 am-form-label" style=" font-weight:normal;margin-top:-10px;">邮箱：</label>
            <div class="am-u-sm-8">
              <input type="text" class="am-input-sm" id="formtemail" style="width: 200px; height:30px; padding-top:1px; padding-bottom:0px;float:left;"  placeholder="请输入新的邮箱地址" >
              <small id="JSformtemail" style="float:left; margin-left:-200px; margin-top:30px;">　</small>
 		 </div></div>
  		
  			<div style="margin-top:30px; margin-left:100px; float:left"><button id="formtsendemail" type="button" class="am-btn am-btn-secondary" style="width:180px;">发送激活邮件</button> 　　<a href="#" data-am-modal-close style="font-size:16px; margin-top:3px;">取 消</a>
				</div>  </form>
    		</div>
		</div>
	</div>
          <div class="s_b">邮箱：${membersafety.email }</div>
        </div>
        <div class="s_l3">
          <div class="s_v" style="color:#3DB236;"><span style="font-size:20px">5.</span>登录密码 ＞<c:if test="${ membersafety.mobileifverified==0}">　　　　<a href="#" id="mobile1"  style="color:#3DB236;font-size:13px;"><span >修改</span></a></c:if> 　　　<c:if test="${ membersafety.mobileifverified==1}">　<a href="#" data-am-modal="{target: '#doc-modal-6', closeViaDimmer: 0}"  style="color:#3DB236;font-size:13px;"><span>修改</span></a></c:if>　</div>
          <div class="s_b" style="width: 200px;">上次登录时间：  <% Subject subject = SecurityUtils.getSubject();
             ShiroMember currUser = (ShiroMember) subject.getPrincipal();
             Date loginDate = currUser.getLoginDate();
          %>
          <fmt:formatDate value="<%=loginDate %>" type="both" pattern="yyyy-MM-dd" /></div>
        </div>
      </div>
      <div class="s_m">
        <div>
          <div id="circle_safe"></div>
          <script type="text/javascript">
window.onload = function(){


	var object = document.getElementById('circle_safe')
	function loadImg (data,point){
			var i = 0;
			setInterval(function(){
				i++
				if(i>data){
					i=data
				}
				var imgLeft = -(i*185+(i*10))+'px'
				object.style.backgroundPosition = imgLeft+'\t'+'0px'
				object.innerHTML = '认证级别';
			},20)
	
	}
	var pointnum=${membersafety.transpasswdverified+membersafety.mobileifverified+membersafety.emailifverified+membersafety.bankcardifverified+membersafety.idcardifverified+1};
	var data;
	var point;
	
	if(pointnum==1){
		var data=8;
	}
	if(pointnum==2){
		var data=16;
	}
	if(pointnum==3){
		var data=17;
	}
	if(pointnum==4){
		var data=29;
	}
	if(pointnum==5){
		var data=31;
	}
	if(pointnum==6){
		var data=50;
	}
	loadImg(data,point);
}
</script>
          <div class="s_t"></div>
        </div>
        <div class="s_btn">
          <button class="am-btn am-btn-primary" id="againcheck">重新检测</button>
        </div>
      </div>
      <div class="s_r">
        <div class="s_l1">
          <div class="s_v"><c:if test="${membersafety.mobileifverified==0 }"><a href="#" data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}" style="color:#EA544A;"><span style="font-size:20px">2.</span>手机认证 ＞</a> 　　　　<a href="#" data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}" style="color:#EA544A;font-size:13px;"><span class="am-icon-times-circle" ></span></a></c:if><c:if test="${membersafety.mobileifverified==1 }"><a href="#" data-am-modal="{target: '#doc-modal-1'}" style="color:#3DB236;"><span style="font-size:20px">2.</span>手机认证 ＞</a> 　　　　<a href="#" data-am-modal="{target: '#doc-modal-1'}" style="color:#3DB236;font-size:13px;"><span class="am-icon-check-circle" ></span></a></c:if></div>
          <div class="s_b">完成手机认证，即可投资。</div>
        </div>
           <div class="s_l2">
          <div class="s_v"><c:if test="${membersafety.bankcardifverified==0 }"><c:if test="${membersafety.idcardifverified==1}"><a href="#" data-am-modal="{target: '#doc-modal-5', closeViaDimmer: 0}" style="color:#EA544A;"><span style="font-size:20px">3.</span>银行卡绑定 ＞</a> 　　　<a href="#" data-am-modal="{target: '#doc-modal-5', closeViaDimmer: 0}" style="color:#EA544A;font-size:13px;"><span class="am-icon-times-circle" ></span></a></c:if><c:if test="${ membersafety.idcardifverified==0}"><a href="#" id="bankcard1" style="color:#EA544A;"><span style="font-size:20px">3.</span>银行卡绑定 ＞</a> 　　　<a href="#" id="bankcard2" style="color:#EA544A;font-size:13px;"><span class="am-icon-times-circle" ></span></a></c:if></c:if><c:if test="${membersafety.bankcardifverified==1 }"><a href="#" data-am-modal="{target: '#doc-modal-5'}" style="color:#3DB236;"><span style="font-size:20px">3.</span>银行卡绑定 ＞</a> 　　　<a href="#" data-am-modal="{target: '#doc-modal-5'}" style="color:#3DB236;font-size:13px;"><span class="am-icon-check-circle" ></span></a></c:if></div>
          <div class="s_b">完成银行卡绑定，即可提现。</div>
        </div>
    
        <div class="s_l3">
          <div class="s_v"><c:if test="${membersafety.transpasswdverified==0 }"><c:if test="${membersafety.mobileifverified==0}"><a href="#" id="ta1" style="color:#EA544A;"><span style="font-size:20px">4.</span>交易密码 ＞</a> 　　　　<a href="#" id="ta2" style="color:#EA544A;font-size:13px;"><span class="am-icon-times-circle" ></span></a></c:if><c:if test="${membersafety.mobileifverified==1}"><a href="#" data-am-modal="{target: '#doc-modal-4', closeViaDimmer: 0}" style="color:#EA544A;"><span style="font-size:20px">4.</span>交易密码 ＞</a> 　　　　<a href="#" data-am-modal="{target: '#doc-modal-4'}" style="color:#EA544A;font-size:13px;"><span class="am-icon-times-circle" ></span></a></c:if></c:if><c:if test="${membersafety.transpasswdverified==1 }"><a href="#" data-am-modal="{target: '#doc-modal-4'}" style="color:#3DB236;"><span style="font-size:20px">4.</span>交易密码 ＞</a> 　　　　<a href="#" data-am-modal="{target: '#doc-modal-4'}" style="color:#3DB236;font-size:13px;"><span class="am-icon-check-circle" ></span></a></c:if></div>
          <div class="s_b">设置交易密码，保障账户安全。</div>
        </div>
      </div>
    </div>
  </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>
