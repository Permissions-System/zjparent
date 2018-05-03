<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<title>重置密码 - 百富网小额投资理财平台</title>
<%@include file="../common/tdk.jsp"%> 
<%@include file="../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link rel="stylesheet" href="${ctx}/static/css/amazeui.css">
<link href="${ctx }/static/css/style.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="${ctx}/static/css/app.css">
<link href="${ctx}/static/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>

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
		var passwordisuseful=false;
		var repasswordisuseful=false;
	 $("#password").blur(function(){
		 var $password=$.trim($("#password").val());
		 var reg=/^[a-zA-Z0-9]\w{5,17}$/;
		 if($password==""){
			 $("#passwordJS").html("<font color='red'>密码不能为空</font>");
		 }else if(!reg.test($password)){
			 $("#passwordJS").html("<font color='red'>密码的长度在6~20位字符，可为数字、字母、符号</font>");
		 }else{
			 $("#passwordJS").html("<font color='green'>密码格式正确</font>");
			 passwordisuseful=true;
	 	}
	});
	$("#repassword").blur(function(){
	 	var $repassword=$.trim($("#repassword").val());
	 	var $password=$.trim($("#password").val());
	 	if($repassword==""){
	 		 $("#repasswordJS").html("<font color='red'>确定密码不能为空</font>");
	 	}
	 	else if($repassword!=$password){
			 $("#repasswordJS").html("<font color='red'>两次密码输入不一致</font>");
		 }else {
			 $("#repasswordJS").html("<font color='green'>两次密码输入一致</font>");
			 repasswordisuseful=true;
		 }
	});
	$("#button1").click(function(){
		if(!passwordisuseful&&repasswordisuseful){
			return ;
		}
		$.post("modifypassword.do",{password:$("#password").val(),pwduuid:$("#uuid").val()},function(data){
			if(data.result=="修改成功"){
				$("#sp1").html("<font color='green'>修改成功</font>");
				$("#a1").html("现在就去登录页");
				var i=2;
				setInterval(function(){
					if(i>=0){
					$("#showtime").html(""+i--);
					}
				},1000);
				setTimeout(function(){
					window.location.href="login.do";
				},3000);
			}else{
				alert("修改失败");
				$("#a1").html("现在就去首页");
				$("#a1").href="index.do";
				window.location.href="index.do";
			}
		});
	});
	$("#a1").click(function(){
		window.location.href="login.do";
		return false;
	})
});
</script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<!--网站logo 导航条  end-->

<div class="login"><!--login  start-->
  <div class="reset_h">重置密码</div>
  <div class="reset_txt"></div>
  <div class="reset_tab"><table width="490" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="125" height="45" style="font-family:'微软雅黑'; font-size:15px; color:#565B5D"></td>
    <td width="400"><input type="password" name="password" onkeyup="value=value.replace(/[\W]/g,'') " 
      onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" id="password" style="background-image:url(${ctx}/static/images/input-04.jpg); background-repeat:no-repeat; line-height:45px; font-size:18px;" placeholder="请设置新的登录密码">
   </td>
  </tr>
  <tr>
    <td height="30"></td>
    <td><input type="hidden" id="uuid" value="${uuid }"><div id="passwordJS"></div></td>
  </tr>
  <tr>
    <td height="40" style="font-family:'微软雅黑'; font-size:15px; color:#565B5D"></td>
    <td><input type="password" name="password2" id="repassword" onkeyup="value=value.replace(/[\W]/g,'') " 
      onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" style="background-image:url(${ctx}/static/images/input-05.jpg); background-repeat:no-repeat; line-height:45px; font-size:18px;" placeholder="请再次设置新的登录密码">
    </td>
  </tr>
  <tr>
    <td height="30"></td>
    <td><div id="repasswordJS"></div></td>
  </tr>
  <tr>
    <td height="40">&nbsp;</td>
    <td> <button id="button1" class="am-btn am-btn-primary" data-am-modal="{target: '#doc-modal-1'}" style="width:400px; height:45px;">确定</button>
    <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">
    <span id="sp1"></span>正在跳转。。。
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    </div>
    <div class="am-modal-bd">
       我们将在&nbsp;<span id="showtime" style="font-size:20px;color:#009CE4">3</span>&nbsp;秒后
       <a  id="a1" href="#" style="font-size:15px;color:#009CE4"></a>
    </div>
  </div>
</div>
    </td>
  </tr>
  </table>
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
<script src="${ctx}/static/js/amazeui.js"></script>
</body>
</html>
