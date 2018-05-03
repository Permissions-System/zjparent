<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<%@include file="../common/header.jsp"%>
<meta charset="utf-8">
<title>百富网-智富人生</title>
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link rel="Stylesheet" type="text/css" href="${ctx}/static/css/jquery.validity.css" />

<link href="${ctx}/static/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.validity.js"></script>
<script type="text/javascript">
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>
<script type="text/javascript">
	$(function(){
		// checkbox 默认选中
	    var hideCheckbox = '${hideCheckbox}';
	    if(hideCheckbox == 'check'){
	    	 $('#checkbox').attr("checked","true");
	    }
		$.validity.setup({outputMode:"label"});
		var nameisuseful=true;
		var passwordisuseful=true;
		$("#textfield").blur(function(){
			var $textfield=$.trim($("#textfield").val());
			var reg= /^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;  
			if($textfield==""){
				$("#nameprompt").html("<font color='red'>邮箱不能为空</font>");
				nameisuseful=false;
			}else if(!reg.test($textfield)){
				$("#nameprompt").html("<font color='red'>邮箱不合法</font>");
				nameisuseful=false;
			}else{
				$("#nameprompt").html("<font color='blue'>邮箱格式正确</font>");
				nameisuseful=true;
			}
		});
		$("#password").blur(function(){
			var $password=$.trim($("#password").val());
			var reg=/^[a-zA-Z0-9]\w{5,17}$/;
			if($password==""){
				$("#passwordprompt").html("<font color='red'>密码不能为空</font>");
				passwordisuseful=false;
			}else if(!reg.test($password)){
				$("#passwordprompt").html("<font color='red'>密码长度在6~18位</font>");
				passwordisuseful=false;
			}else{
				$("#passwordprompt").html("<font color='blue'>密码格式正确</font>");
				passwordisuseful=true;
			}
		});
		
		$("#submit").click(function(){
			if(!(nameisuseful&&passwordisuseful)){
				return false;
			}
			return true;
		});
		$("#qq").click(function(){
			window.open("http://openapi.qzone.qq.com/oauth/show?which=Login&display=pc&client_id=101181022&response_type=token&scope=all&redirect_uri=http://www.biifoo.com/afterlogin.do");
		});
		$("#submit2").click(function(){
			window.location.href="register.do";
			return false;
		});
	});
</script>
<script type="text/javascript">
	$(function(){
		var accessToken =window.location.hash.substring(1);
		alert(accessToken);
		 $.ajax({
		      type: 'GET',
		      url: "https://graph.qq.com/oauth2.0/me?"+accessToken,
		      async: false,
		      dataType: "jsonp",
		      jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
		      jsonpCallback:"callback",
		      success: function(o){
		    	  if(o.error!=null){
		    		  return ;
		    	  }else{
		    		  $.post("qqloginafter.do",{openid:o.openid},function(){
		    			  window.location.href="index.do";
		    		  });
		    	  }
		      }
		 });
	});

</script>
</head>

<body onLoad="MM_preloadImages('${ctx}/static/images/banner_buttom2.png','${ctx}/static/images/weibo2.png','${ctx}/static/images/wechat2.png','${ctx}/static/images/icon_weibo.fw.png','${ctx}/static/images/icon_wechat.fw.png')">
<jsp:include page="header.jsp"/><!-- 引用header标签 -->


<div class="login"><!--login  start-->
  <div class="login_left"></div>
  <div class="login_right">
    <div class="login_h">
      <div class="login_hh">登录百富</div>
      <div class="login_pull"><img src="${ctx}/static/images/reg.png" width="66" height="64"  alt=""/></div>
      <div class="login_input" style="font-size:13px; font-family:'微软雅黑'; color:#565A5C; "><form action="login.do" method="post"><table width="550" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" colspan="8"><font color='red'>${errormsg }</font></td>
    </tr>
  <tr>
    <td height="45" style="text-align:right;">登录邮箱：</td>
    <td height="45" colspan="7" ><input name="username" value="${username }" type="textfield" id="textfield" style="background-image:url(${ctx}/static/images/input-02.jpg); background-repeat:no-repeat; line-height:45px;" placeholder="邮箱"></td>
    </tr>
  <tr>
    <td height="30">&nbsp;</td>
    <td height="30" colspan="7"><div id="nameprompt"></div></td>
    </tr>
  <tr>
    <td height="45" style="text-align:right;">密 码：</td>
    <td height="45" colspan="7"><input type="password" value="${password }"name="password" id="password" style="background-image:url(${ctx}/static/images/input-04.jpg); background-repeat:no-repeat; line-height:45px;" placeholder="密码"></td>
    </tr>
  <tr>
    <td height="30">&nbsp;</td>
    <td height="30" colspan="7"><div id="passwordprompt"></div></td>
    </tr>
  <tr>
    <td width="93" height="30" valign="middle">&nbsp;</td>
    <td width="28" valign="middle"><input type="checkbox" value="check" name="checkbox" id="checkbox" style="width:14px; height:14px; border-width: 0px; border-style:none; border-spacing:0px 0px;
	border-collapse: collapse;
	border-radius: 3px;"></td>
    <td width="99" valign="middle">下次自动登录</td>
    <td colspan="3" valign="middle">&nbsp;</td>
    <td width="30"><img src="${ctx}/static/images/q.png" width="15" height="15"  alt=""/></td>
    <td width="229"><a href="reset_pwdafter.do" style="text-decoration:none; color:#565A5C">忘记密码</a></td>
  </tr>
  <tr>
    <td colspan="8">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="7"><input type="submit" name="submit" id="submit" value="立刻登录" style="background-color:#009CE4; text-indent:0px; color:#FFF; font-size:18px; font-family:'微软雅黑';"></td>
    </tr>
  <tr>
    <td colspan="8">&nbsp;</td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="4">第三方账户登录：</td>
    <td width="46"><img id="qq" src="${ctx}/static/images/qq.png" width="29" height="29"  alt=""/></td>
    <td><img id="sina" src="${ctx}/static/images/wb.png" width="30" height="30"  alt=""/></td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <td colspan="8">&nbsp;</td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="7"><input type="submit" name="submit2" id="submit2" value="注册百富网账号" style="background-color:#009CE4; text-indent:0px; color:#FFF; font-size:18px; font-family:'微软雅黑';"></td>
    </tr>
      </table></form>
</div>
    </div>
  </div>
  
</div>

<div class="footer">
  <div class="footer_nav">
    <div class="footer_logo">
      <div class="logo"><img src="${ctx}/static/images/logo.png" width="201" height="64"  alt=""/></div>
      <div class="we"><a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image10','','${ctx}/static/images/weibo2.png',1)"><img src="${ctx}/static/images/weibo1.png" alt="" width="53" height="53" id="Image10"></a></div>
      <div class="we2"><a class="tooltip" href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image11','','${ctx}/static/images/wechat2.png',1)"><img src="${ctx}/static/images/wechat1.png" alt="" width="52" height="53" id="Image11"></a></div>
      <p>与我快乐的玩耍吧！</p>
    </div>
    <div class="footernav1">
      <ul>
        <li class="current">基本信息</li>
        <li><a href="#">百富网介绍</a></li>
        <li><a href="#">精英团队</a></li>
        <li><a href="#">公司新闻</a></li>
        <li><a href="#">媒体报道</a></li>
        <li><a href="#">投资人关系</a></li>
        <li><a href="#">加入我们</a></li>
        <li><a href="#">政策法规</a></li>
      </ul>
    </div>
    <div class="footernav2">
      <ul>
        <li class="current">发现</li>
        <li><a href="#">百富精选</a></li>
        <li>每日任务（即将上线）</li>
        <li>大富翁测试（即将上线）</li>
        <li><a href="#">投资收益计算器</a></li>
        <li><a href="#">分享红包</a></li>
        <li><a href="#">访问移动端</a></li>
        <li><a href="#">网站地图</a></li>
      </ul>
    </div>
    <div class="footernav3">
      <ul>
        <li class="current">安全与帮助</li>
        <li><a href="#">产品安全</a></li>
        <li><a href="#">资金安全</a></li>
        <li><a href="#">数据及信息</a></li>
        <li><a href="#">隐私保密</a></li>
        <li><a href="#">联系我们</a></li>
        <li><a href="#">在线客服</a></li>
        <li><a href="#">常见问题</a></li>
      </ul>
    </div>
  </div>
  <div class="footer_bottom">市场有风险，投资需谨慎 沪ICP000000号</div>
</div>
</body>
</html>
