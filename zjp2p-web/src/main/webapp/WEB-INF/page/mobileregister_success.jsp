<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html class="no-js">
<head>
<title>要想富，上百富！1000块红包免费拿，见者有份，抢！- 百富网小额投资理财平台</title>
<%@include file="../common/tdk.jsp"%> 
<%@include file="../common/header.jsp"%>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="${ctx }/static/M_images/biifoo_icon.png" rel="shortcut icon" />
  <!-- Set render engine for 360 browser -->
  <meta name="renderer" content="webkit">

  <!-- No Baidu Siteapp-->
  <meta http-equiv="Cache-Control" content="no-siteapp"/>

  <!-- Add to homescreen for Chrome on Android -->
  <meta name="mobile-web-app-capable" content="yes">
  
  <!-- Add to homescreen for Safari on iOS -->
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-title" content=""/>
  

  <!-- Tile icon for Win8 (144x144 + tile color) -->
  <meta name="msapplication-TileColor" content="#0e90d2">
<link rel="apple-touch-icon-precomposed" href="${ctx }/static/M_images/1-04.png.png"/>
  <link rel="stylesheet" href="${ctx }/static/assets/css/amazeui.css">
  <link rel="stylesheet" href="${ctx }/static/assets/css/app.css">
    <script src="${ctx }/static/assets/js/sweet-alert.js"></script> 
  <link rel="stylesheet" type="text/css" href="${ctx }/static/assets/css/sweet-alert.css">
  <!--[if (gte IE 9)|!(IE)]><!-->
<script src="${ctx }/static/assets/js/jquery.min.js"></script>
<script src="${ctx }/static/assets/js/amazeui.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.cookie.js"></script>
<script type="text/javascript">
	$(function(){
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
            return pass;
        }
        function showtime(o,wait) {
			        if (wait == 0) {
			        	$.cookie("time",0);
			        	o.removeAttr("disabled");          
			            o.html("发送");
			            wait = 60;
			        } else {
			            o.attr({"disabled":"disabled"});
			            o.html("重新发送(" + wait + ")");
			            wait--;
			            $.cookie("time",wait);
			            setTimeout(function() {
			                showtime(o,wait)
			            },
			            1000)
			        }
			    }
			        
        $("#sendmsg").click(function(){
        	if($("#mobile").val()==""){
        		sweetAlert("手机认证", "手机号码不能为空!", "error");
	    		   return;
	    	   	}
	    	   var reg=/1[3-8]+\d{9}/;
	    	   if(!reg.test($("#mobile").val())){
	    		   sweetAlert("手机认证", "手机号码格式错误!", "error");
	    		   return ;
	    	   }
	    	   $.post("${ctx}/member/mobileisusable.do",{mobile:$("#mobile").val()},function(data){
	    		   if(data.status=="0"){
	    			   sweetAlert("手机认证", "手机号码已被认证!", "warning");
	    		   }else {
					   showtime($("#sendmsg"),60);
	    			   $.get("${ctx}/member/sendMobilcode.do?mobile="+$("#mobile").val(),function(){
	    				   
					});
	    		   }
	    	   })
	       });     
            
			$("#s1").click(function(){
					var $name=$.trim($("#name").val());
					var reg=/[\u4e00-\u9fa5]/;
					if($name==""){
						sweetAlert("实名认证", "姓名不能为空!", "error");
					}else if(!reg.test($name)){
						sweetAlert("实名认证", "姓名只能为中文!", "error");
					}else{
						var regidcard = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;							
							if(!regidcard.test(card)){
							$.post("${ctx}/member/mobilecodeisright.do",{code:$("#code").val()},function(data){
										 if(data.result=="验证码正确"){
										 			$("#formid").submit();
										 }else{
											 sweetAlert("手机验证码认证", data.result,"error");
										 }	
								});
							}else{
								sweetAlert("实名认证", "身份证格式不正确!", "error");
							}
					}
			});
		
		});
</script>
<script type="text/javascript">
	$(function(){
		var time=parseInt($.cookie("time"));
		 function showtime(o,wait) {
		        if (wait == 0) {
		        	$.cookie("time",0);
		        	o.removeAttr("disabled");          
		            o.html("发送");
		            wait = 60;
		        } else {
		            o.attr({"disabled":"disabled"});
		            o.html("重新发送(" + wait + ")");
		            wait--;
		            $.cookie("time",wait);
		            setTimeout(function() {
		                showtime(o,wait)
		            },
		            1000)
		        }
		    }
		if(time>0){
		showtime($("#sendmsg"),time);
		}
	});
</script>
<body>
<div class="wrap">
  <div class="am-g topbgc">
    <div class="am-u-sm-8 pdl"><img src="${ctx }/static/M_images/logo_1.png"  alt=""/></div>
    <div class="am-u-sm-4"></div>
  </div>
  <div class="am-g tbg">
    <div class="am-u-sm-11 am-u-sm-centered"><img src="${ctx }/static/M_images/money_2.png"  alt=""/></div>  </div>
  
  <div class="register">
   <form action="authentication.do" method="post" id="formid" class="am-form">
   <fieldset>    
    <input type="text" id="name" name="realname" class="am-form-field am-radius interval" placeholder="姓 名" />
    <input type="text" id="idcard" name="idcard" class="am-form-field am-radius interval" placeholder="身份证号码"  />
    <div class="am-g interval">
      <div class="am-u-sm-6" style="padding-left:0px;padding-right:0px;"><input type="text" name="mobile" id="mobile" class="am-form-field am-radius interval3" placeholder="手机号码" /></div>
      <div class="am-u-sm-6" style="padding-right:0px;"><button type="button" id="sendmsg" class="am-btn am-btn-default am-radius send">发 送</button></div>
    </div>
    <div class="am-g interval">
      <div class="am-u-sm-6" style="padding-left:0px;padding-right:0px;"><input type="text" id="code" class="am-form-field am-radius interval3" placeholder="验证码" /></div>
    </div>
    <button type="button" id="s1" class="btn interval2"><img src="${ctx }/static/M_images/btn_1.png"  alt=""/></button>
   </fieldset>
   </form>
   </div>
   <div class="am-g">
     <div class="am-u-sm-11 am-u-sm-centered bifo">@biifoo.com</div>
   </div>
</div>








<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<![endif]-->
</body>
</html>