<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
 <c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link href="${ctx}/static/css/liststyle.css" rel="stylesheet" type="text/css">
<script charset="utf-8" src="http://wpa.b.qq.com/cgi/wpa.php"></script>
<script src="${ctx}/static/js/cufon-yui.js" type="text/javascript"></script>
<script type="text/javascript">
	Cufon.replace('ul.oe_menu div a',{hover: true});
	Cufon.replace('h1,h2,.oe_heading');
</script>
<script type="text/javascript">
$.ajaxSetup({   
		complete: function(jqXHR, textStatus, errorMsg){ // 出错时默认的处理函数
	        // jqXHR 是经过jQuery封装的XMLHttpRequest对象
	        // textStatus 可能为： null、"timeout"、"error"、"abort"或"parsererror"
	        // errorMsg 可能为： "Not Found"、"Internal Server Error"等
	        // console.log('发送AJAX请求到"' + this.url + '[' + jqXHR.status + ']：'+textStatus+',' + errorMsg); 
			 var c = jqXHR.status;
			    switch (c) {
			        case 401: 
			        	alert('登录超时,请重新登录');
			        	window.location.href = ctx+'/login.do';
			            break;
			        case 404:
			        	alert("请求页面不存在!"); 
			            break;
			    }
	    },
	    error: function(jqXHR, textStatus, errorMsg){ // 出错时默认的处理函数
			    var c = jqXHR.status;
			    switch (c) {
			        case 500:{
			         	var resultMsg = getJsonErrorMsg(jqXHR);
			        	if(resultMsg!=''){
			        		alert(resultMsg);
			        		console.log('resultMsg = '+resultMsg); 
			        	}else{
			        		console.log('ajax error'); 
			        	}   
			        }
			    }
	    }
    }); 
</script>
<script type="text/javascript">
            $(function() {
				var $oe_menu		= $('#oe_menu');
				var $oe_menu_items	= $oe_menu.children('li');
				var $oe_overlay		= $('#oe_overlay');

                $oe_menu_items.bind('mouseenter',function(){
					var $this = $(this);
					$this.addClass('slided selected');
					$this.children('div').css('z-index','9999').stop(true,true).slideDown(200,function(){
						$oe_menu_items.not('.slided').children('div').hide();
						$this.removeClass('slided');
					});
				}).bind('mouseleave',function(){
					var $this = $(this);
					$this.removeClass('selected').children('div').css('z-index','1');
				});

				$oe_menu.bind('mouseenter',function(){
					var $this = $(this);
					$oe_overlay.stop(true,true).fadeTo(200, 0.6);
					$this.addClass('hovered');
				}).bind('mouseleave',function(){
					var $this = $(this);
					$this.removeClass('hovered');
					$oe_overlay.stop(true,true).fadeTo(200, 0);
					$oe_menu_items.children('div').hide();
				})
            });
        </script>
 
<div class="top_1"><!--顶部扫微信 登录 注册   start-->
  <div class="top_wrap">
  	<p class="pa">关注我们</p>
  	<div class="top_img"><a href="http://weibo.com/u/5368161400" class="am-biifoo-btn am-icon-weibo" target="new"></a> <a href="#" class="am-biifoo-btn am-icon-qq" id="BizQQWPA3"></a><script type="text/javascript">BizQQWPA.addCustom({aty: '0', a: '0', nameAccount: 4009616588, selector: 'BizQQWPA3'});</script></div>
    <div class="am-biifoo2-btn"><span class="am-icon-wechat" stlye="font-size:16px;"></span></div>
    <shiro:authenticated><p class="pb">欢迎您：<a href="${ctx }/member/investdoc.do"><shiro:principal property="nickname"/></a>　|　<a href="${ctx }/loginout.do">退出</a>　  <a href="${ctx }/member/message.do"><span class="am-icon-envelope-o" style="font-size:14px"></span></a><a href="${ctx }/member/message.do" class="am-numb-btn" style="color: #fff;"><shiro:principal property="unreadMessageCount"/></a>　<a href="${ctx }/helpcenter.do"  target="_blank">帮助</a></p></shiro:authenticated>
    <shiro:notAuthenticated><p class="pb"><a href="${ctx }/login.do">登 录</a>　|　<a href="${ctx }/register.do">注 册</a> </p></shiro:notAuthenticated>
  </div>
</div><!--顶部扫微信 登录 注册  end-->


<div class="nav"><!--网站logo 导航条   start-->
  <div class="nav_wrap">
    <div class="logo"><div style="width:187px;float:left"><a href="http://www.biifoo.com"><img src="${ctx }/static/images/biifoo_logo.png" alt="biifoo logo"/></a></div><div style="width: 80px; float: left; margin-left: 13px; margin-top: -17px"><img src="${ctx }/static/images/spring.gif"  alt=""/></div></div>
    <div class="navi">
      <ul>
        <li><a href="${ctx }/" >&nbsp;首　页&nbsp;</a></li>
        <li><a href="${ctx }/queryBidAll.do" >我要投资</a></li>
        <li><a href="${ctx }/helpcenter.do"  target="_blank">新手指南</a></li>
        <li><a href="${ctx }/safeguard.do" target="_blank">安全保障</a></li>
        <li><a href="${ctx}/introduce.do" target="_blank">关于百富</a></li>
      </ul>
    </div>
    <div class="oe_wrapper">
		  <ul id="oe_menu" class="oe_menu">
		  	<shiro:authenticated>
		  		<li><a href="${ctx }/member/investdoc.do"><img src="${ctx}/static/images/mine.png" style="margin-top:10px"  alt=""/> <span style="vertical-align:top;">我的百富 </span><span class="am-icon-caret-down" style="vertical-align:top;margin-top:1px;"></span></a>
					<div>
						<ul>
							<li><a href="${ctx }/member/investdoc.do">资产档案</a></li>
							<li><a href="${ctx }/member/ttfrecord.do">天 天 富</a></li>
							<li><a href="${ctx }/member/investmentrecord.do">投资记录</a></li>
                            <li><a href="${ctx }/member/dealhistory.do">交易记录</a></li>
						</ul>
					</div>
				</li>
  			</shiro:authenticated>
  			<shiro:notAuthenticated>
  				<li><a href="${ctx}/login.do"><img src="${ctx}/static/images/mine.png" style="margin-top:10px"  alt=""/> <span style="vertical-align:top;">我的百富 </span><span class="am-icon-caret-down" style="vertical-align:top;margin-top:1px;"></span></a>
					<div>
						<ul>
							<li><a href="${ctx}/login.do">资产档案</a></li>
							<li><a href="${ctx}/login.do">天 天 富</a></li>
							<li><a href="${ctx}/login.do">投资记录</a></li>
                            <li><a href="${ctx}/login.do">交易记录</a></li>
						</ul>
					</div>
				</li>
  			</shiro:notAuthenticated>
			</ul>	
		</div>
    
    
    <!-- div class="am-dropdown" data-am-dropdown style="float:right; margin-top:28px; margin-right:-15px;">
  <button class="am-btn am-btn-biifoo am-dropdown-toggle" data-am-dropdown-toggle style="height:42px; padding-top: 12px;"><img src="${ctx}/static/images/mine.png" style="margin-top:-2px;" alt=""/> <span style="vertical-align:top;font-size:14px;">我的百富</span> <span class="am-icon-caret-down" style="vertical-align:top;margin-top:-2px;"></span></button>
  <shiro:authenticated>
  <ul class="am-dropdown-content">
    <li><a href="${ctx }/member/investdoc.do">资产总览</a></li>
    <li><a href="${ctx }/member/investmentrecord.do">我的理财</a></li>
    <li><a href="${ctx }/member/dealhistory.do">我的交易单</a></li>
  </ul>
  </shiro:authenticated>
   <shiro:notAuthenticated>
  <ul class="am-dropdown-content">
    <li><a href="${ctx }/login.do">资产总览</a></li>
    <li><a href="${ctx }/queryBidAll.do">我的理财</a></li>
    <li><a href="${ctx }/login.do">我的交易单</a></li>
  </ul>
  </shiro:notAuthenticated>
</div -->
   </div>
  </div>
 