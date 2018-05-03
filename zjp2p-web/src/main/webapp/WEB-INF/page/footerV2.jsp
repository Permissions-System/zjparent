<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />    
<div class="footer_o1">
  <div class="footer_i1">
    <div class="f_logo">
      <div class="b_logo"><img src="${ctx}/static/images/logo_b.png" alt="logo"/></div>
      <div class="rol rolm1"><a href="http://weibo.com/u/5368161400" target="_blank">&#xe601;</a></div>
      <div class="rol rolm2"><a href='javascript:void(0)' id="qq3"><script type="text/javascript">BizQQWPA.addCustom({aty: '0', a: '0', nameAccount: 4009616588, selector: 'qq3'});</script>&#xe600;</a></div>
    </div>
    <div class="f_link">
      <div class="svc"><img src="${ctx}/static/images/service.png" alt="hotline"/><br><span class="txr1">400-9616-588</span></div>
      <ul class="f_link1">
        <li class="current">公司信息</li>
        <li><a href="${ctx}/introduce.do" target="_blank">百富网介绍</a></li>
        <li><a href="${ctx}/team.do">精英团队</a></li>
        <li><a href="${ctx}/queryNewsAll.do?categoryid=21" target="_blank">公司新闻</a></li>
        <li><a href="${ctx}/queryNewsAll.do?categoryid=22" target="_blank">媒体报道</a></li>
        <li><a href="${ctx}/investor.do" target="_blank">投资人关系</a></li>
        <li><a href="${ctx}/queryDeptAll.do?parent=3" target="_blank">加入我们</a></li>
        <li><a href="${ctx}/policy.do">政策法规</a></li>
      </ul>
      <ul class="f_link2">
        <li class="current">发 现</li>
        <!-- <li><a href="#">百富精选</a></li>-->
        <li><a href="${ctx}/richman.do">大富翁测试</a></li>
        <!-- <li><a href="#">投资收益计算器</a></li>-->
        <li><a href="${ctx}/redadv.do">分享红包</a></li>
      </ul>
      <ul class="f_link3">
        <li class="current">安全与帮助</li>
        <li><a href="${ctx}/help_detail.do#x1" target="_blank">产品安全</a></li>
        <li><a href="${ctx}/help_detail.do#x1" target="_blank">资金安全</a></li>
        <li><a href="${ctx}/help_detail.do#x1" target="_blank">数据及信息</a></li>
        <li><a href="${ctx}/help_detail.do#x1" target="_blank">隐私保密</a></li>
        <li><a href="${ctx}/helpcenter.do#x2" target="_blank">常见问题</a></li>
      </ul>
      <ul class="f_link4">
        <li class="current">手机应用</li>
        <li><a href="#">iPhone版下载</a></li>
        <li><a href="#">Android版下载</a></li>
        <li class="f_2"><img src="${ctx}/static/images/2_1.png" alt=""/></li>
        <li class="bfp">百富网<br>微信公众号</li>
      </ul>
    </div>
  </div>
</div>

<div class="footer_o2">
  <div class="footer_i2">
    <div class="footer_i2_1"><img src="${ctx}/static/images/linkicon.png" alt="friendship link"/> 友情链接</div>
    <div class="footer_i2_2"><a href="https://www.weicaifu.com/" target="_blank">微财富</a>　　<a href="https://www.tenpay.com/" target="_blank">财付通</a>　　<a href="https://pay.sina.com.cn/" target="_blank">微钱包</a>　　<a href="http://www.shanghai-cis.com.cn/" target="_blank">上海资信</a>　　<a href="http://iof.hexun.com/" target="_blank">和讯互联网金融</a>　　<a href="http://www.noahwm.com/" target="_blank">诺亚财富</a>　　<a href="http://www.yahui.cc/" target="_blank">亚汇网</a>　　<a href="http://chaoshi.pingan.com/" target="_blank">平安银行</a>　　<a href="http://shanghai.rong360.com/" target="_blank">融360</a>　　<a href="http://www.jrj.com.cn/" target="_blank">金融界</a></div>
  </div>
</div>

<div class="footer_o3">
  <div class="footer_i3">
    <div class="footer_i3_1">©2015 百富网  ｜  沪ICP备14050495号-2  ｜  上海必富金融信息服务有限公司  ｜  Shanghai BiiFoo Financial Information Service Co.ltd </div>
    <div class="footer_i3_2"><img src="${ctx}/static/images/ologo-1.png" alt=""/>　　　<a href="http://www.sheca.com/default.aspx" target="new">　<img src="${ctx}/static/images/ologo-2.png" alt=""/> </a>　　　　<a href="http://www.itrust.org.cn/yz/pjwx.asp?wm=1320816711" target="new"><img src="${ctx}/static/images/ologo-3.png" alt=""/></a></div>
  </div>
</div>
<script src="${ctx}/static/js/amazeui.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/tinytip.js"></script>

<script>
  $(function() {
	  var $oe_menu = $('#oe_menu');
	  var $oe_menu_items = $oe_menu.children('li');
	  var $oe_overlay = $('#oe_overlay');

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
<script>
    $(document).ready(function(){
        $('.caselist.bottomwrap').tinytip({
            position : 'bottom',
            // fix : {
            //     left : 30,
            //     top: 7
            // },
            speed : 100,
            tooltip: '扫描关注微信公众号',
            animation : {
                top : 20
            },
            // on : 'click',
            wrapper : '<span class="tooltips" style="display:block;padding:50px;"></span>',
            addClass : 'top_arrow_box center',
            preventClose : true
        });

    });
	$(document).ready(function(){
        $('.caselist.bottomwrap2').tinytip({
            position : 'bottom',
            // fix : {
            //     left : 30,
            //     top: 7
            // },
            speed : 100,
            tooltip: '百富网官方QQ群<br>433212926',
            animation : {
                top : 20
            },
            // on : 'click',
            wrapper : '<span class="tooltips2" style="display:block;padding:50px;"></span>',
            addClass : 'top_arrow_box2 center',
            preventClose : true
        });

    });
	
</script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?5cfa4fa7388cde487998f927e3477559";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>