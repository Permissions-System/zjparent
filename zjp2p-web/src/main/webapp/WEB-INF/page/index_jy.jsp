<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head lang="en">
<meta charset="UTF-8">
<%@include file="../common/header.jsp"%>
<title></title>
</head>
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/public.css"/>
<script src="${ctx}/static/js/jquery-1.8.2.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.SuperSlide.2.1.js"></script>
<script>
    (function(d,D,v){d.fn.responsiveSlides=function(h){var b=d.extend({auto:!0,speed:1E3,timeout:7E3,pager:!1,nav:!1,random:!1,pause:!1,pauseControls:!1,prevText:"Previous",nextText:"Next",maxwidth:"",controls:"",namespace:"rslides",before:function(){},after:function(){}},h);return this.each(function(){v++;var e=d(this),n,p,i,k,l,m=0,f=e.children(),w=f.size(),q=parseFloat(b.speed),x=parseFloat(b.timeout),r=parseFloat(b.maxwidth),c=b.namespace,g=c+v,y=c+"_nav "+g+"_nav",s=c+"_here",j=g+"_on",z=g+"_s",
            o=d("<ul class='"+c+"_tabs "+g+"_tabs' />"),A={"float":"left",position:"relative"},E={"float":"none",position:"absolute"},t=function(a){b.before();f.stop().fadeOut(q,function(){d(this).removeClass(j).css(E)}).eq(a).fadeIn(q,function(){d(this).addClass(j).css(A);b.after();m=a})};b.random&&(f.sort(function(){return Math.round(Math.random())-0.5}),e.empty().append(f));f.each(function(a){this.id=z+a});e.addClass(c+" "+g);h&&h.maxwidth&&e.css("max-width",r);f.hide().eq(0).addClass(j).css(A).show();if(1<
            f.size()){if(x<q+100)return;if(b.pager){var u=[];f.each(function(a){a=a+1;u=u+("<li><a href='#' class='"+z+a+"'>"+a+"</a></li>")});o.append(u);l=o.find("a");h.controls?d(b.controls).append(o):e.after(o);n=function(a){l.closest("li").removeClass(s).eq(a).addClass(s)}}b.auto&&(p=function(){k=setInterval(function(){var a=m+1<w?m+1:0;b.pager&&n(a);t(a)},x)},p());i=function(){if(b.auto){clearInterval(k);p()}};b.pause&&e.hover(function(){clearInterval(k)},function(){i()});b.pager&&(l.bind("click",function(a){a.preventDefault();
        b.pauseControls||i();a=l.index(this);if(!(m===a||d("."+j+":animated").length)){n(a);t(a)}}).eq(0).closest("li").addClass(s),b.pauseControls&&l.hover(function(){clearInterval(k)},function(){i()}));if(b.nav){c="<a href='javascript:' class='"+y+" prev'>"+b.prevText+"</a><a href='javascript:' class='"+y+" next'>"+b.nextText+"</a>";h.controls?d(b.controls).append(c):e.after(c);var c=d("."+g+"_nav"),B=d("."+g+"_nav.prev");c.bind("click",function(a){a.preventDefault();if(!d("."+j+":animated").length){var c=f.index(d("."+j)),
            a=c-1,c=c+1<w?m+1:0;t(d(this)[0]===B[0]?a:c);b.pager&&n(d(this)[0]===B[0]?a:c);b.pauseControls||i()}});b.pauseControls&&c.hover(function(){clearInterval(k)},function(){i()})}}if("undefined"===typeof document.body.style.maxWidth&&h.maxwidth){var C=function(){e.css("width","100%");e.width()>r&&e.css("width",r)};C();d(D).bind("resize",function(){C()})}})}})(jQuery,this,0);
    $(function() {
        $(".f426x240").responsiveSlides({
            auto: true,
            pager: true,
            nav: true,
            speed: 700
        });
        $(".f160x160").responsiveSlides({
            auto: true,
            pager: true,
            speed: 700
        });
    });
</script>
<body>
<div class="header">
  <div class="main">
    <ul class="ri wid">
      <li><img src="${ctx}/static/images/pic3.gif"><a href="#">手机上冀银</a></li>
      <li><img src="${ctx}/static/images/pic4.gif"><a href="#">登陆</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">注册</a></li>
    </ul>
    <ul>
      <li><img src="${ctx}/static/images/pic1.gif"><span>400 888 8888</span></li>
      <li><img src="${ctx}/static/images/pic14.gif"></li>
      <li><a href="#">关注我们</a><img src="${ctx}/static/images/pic2.gif"></li>
    </ul>
  </div>
</div>
<div class="menu">
  <div class="main">
    <div class="left"><img src="${ctx}/static/images/pic5.gif" width="429" height="100"></div>
    <div class="right">
      <div class="topNav">
        <div class="topNav-width clearfix">
          <dl class="tnLeft">
            <dd>
              <h3><a target="_blank" href="#">首页<i></i></a></h3>
            </dd>
            <dd>
              <h3><a target="_blank" href="#">我要投资<i></i></a></h3>
              <ul>
                <img src="${ctx}/static/images/sj.jpg">
                <div class="left">
                  <h3><a>活期宝</a></h3>
                  <p>活期理财，安心收益 日日复利存取随心 支持随时存取</p>
                </div>
                <div class="right2">
                  <h3><a>银宝理</a></h3>
                  <h3><a>银房宝</a></h3>
                  <h3><a>银企宝</a></h3>
                  <h3><a>银融租</a></h3>
                </div>
              </ul>
            </dd>
            <dd>
              <h3><a target="_blank" href="#">我要借款<i></i></a></h3>
            </dd>
            <dd>
              <h3><a target="_blank" href="#">安全保障<i></i></a></h3>
            </dd>
            <dd>
              <h3><a target="_blank" href="#">关于我们<i></i></a></h3>
            </dd>
            <dd>
              <h3><a target="_blank" href="#">冀银论坛<i></i></a></h3>
            </dd>
          </dl>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="banner" style="overflow:hidden;">
  <div class="new_banner">
    <ul class="rslides f426x240">
      <li style="background:url(${ctx}/static/images/banner1.gif) center no-repeat;"><a href="#">&nbsp;</a></li>
      <li style="background:url(${ctx}/static/images/banner2.gif) center no-repeat;"><a href="#">&nbsp;</a></li>
      <li style="background:url(${ctx}/static/images/banner3.gif) center no-repeat;"><a href="#">&nbsp;</a></li>
      <li style="background:url(${ctx}/static/images/banner4.gif) center no-repeat;"><a href="#">&nbsp;</a></li>
    </ul>
  </div>
</div>
<div class="con_noe">
  <div class="title">
    <div class="title_left"></div>
    <div class="title_right"> <span>活期理财，安心收益</span>
      <h4>活期宝</h4>
    </div>
  </div>
  <div class="conter">
    <div class="conter_noe">
      <div class="conter_noe_left"><img src="${ctx}/static/images/pic7.gif" width="92" height="93"></div>
      <div class="conter_noe_right"><span>日日复利</span>存取随心</div>
    </div>
    <div class="conter_two">
      <div class="conter_two_left"><img src="${ctx}/static/images/pic8.gif" width="92" height="93"></div>
      <div class="conter_two_right">支持随时存取 <span>年化收益6.50%</span> </div>
    </div>
    <div class="conter_three">剩余可投金额：1.800.600.00元<a href="#">立即投资</a></div>
  </div>
</div>
<div class="con_two">
  <div class="con_two_conter">
    <dl>
      <dt><img src="${ctx}/static/images/pic9.gif" width="126" height="126"></dt>
      <dd>
        <h4>关于我们</h4>
        <span>了解钱袋&nbsp;&nbsp;学会理财</span></dd>
    </dl>
    <dl>
      <dt><img src="${ctx}/static/images/pic10.gif" width="126" height="126"></dt>
      <dd>
        <h4>安全保障</h4>
        <span>五重保证&nbsp;&nbsp;投资无忧</span></dd>
    </dl>
    <dl>
      <dt><img src="${ctx}/static/images/pic11.gif" width="126" height="126"></dt>
      <dd>
        <h4>全免体检</h4>
        <span>独立透明&nbsp;&nbsp;轻松收益</span></dd>
    </dl>
  </div>
</div>
<script type="text/javascript">
  $(function(){
     $(".mtab").find('li').click(function(){
         var obj = $(this).parent().nextAll();
         var index = $(this).index();
         $(this).addClass('current').siblings().removeClass('current');
         obj.find('div').eq(index).css('display','block').siblings().css('display','none');
                     
     }) 
  })
</script>

<div class="three">
  <div class="main">
    <div class="container">
      <ul class="mtab">
        <li class="current"><a href="javascript:void();">银保理产品</a></li>
        <li><a href="javascript:void();">银房宝产品</a></li>
        <li><a href="javascript:void();">银企宝产品</a></li>
        <li><a href="javascript:void();">银融租产品</a></li>
      </ul>
      <div class="cmenu">
        <div class="fb">
          <dl>
            <dt>
              <p>年化收益：<span class="red">102.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
        </div>
        <div class="fn">
          <dl>
            <dt>
              <p>年化收益：<span class="red">103.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
        </div>
        <div class="fn">
          <dl>
            <dt>
              <p>年化收益：<span class="red">104.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
        </div>
        <div class="fn">
          <dl>
            <dt>
              <p>年化收益：<span class="red">105.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
          <dl>
            <dt>
              <p>年化收益：<span class="red">10.00%</span></p>
              <p>项目期限：<span>6</span>个月</p>
              <p>项目规模：<span>100</span>万</p>
              <h3><a href="#">立即投资</a></h3>
            </dt>
            <dt>
              <p style=" width:285px;">年还款方式：<span class="size2">按月付息，到期还本</span></p>
              <p style="width:390px;">项目期限：<span class="size2">北京任泰投资担保有限公司</span></p>
              <h2><span>
                <h5 style=" width:80%; "></h5>
                </span>投资进度：80%</h2>
            </dt>
          </dl>
        </div>
      </div>
    </div>
    <div style="clear:both;"></div>
  </div>
</div>
<div class="four">
  <div class="four_conter">
    <div class="four_conter_left">
      <div class="title"><span><a href="#">更多</a>&nbsp;></span>媒体报道</div>
      <div class="conter">
        <dl>
          <dt><img src="${ctx}/static/images/pic15.gif" width="180" height="135"></dt>
          <dd>
            <h4>报道的标题</h4>
            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借款企业为建筑及装饰材料商贸企业持续保持稳健经营，与上游供应商建立长期战略合作关系，下游具备稳定、优质的...</a></span> </dd>
        </dl>
      </div>
      <div class="bottom">
        <ul>
          <li><span>深圳卫视</span><a href="#">本项目融资资金主要用于加速拓展下</a></li>
          <li><span>凤凰网</span><a href="#">本项目融资资金主要用于加速拓展下</a></li>
          <li><span>每日经济新闻</span><a href="#">本项目融资资金主要用于加速拓展下</a></li>
          <li><span>经济观察报</span><a href="#">本项目融资资金主要用于加速拓展下</a></li>
        </ul>
      </div>
    </div>
    <div class="four_conter_right">
      <div class="title"><span><a href="#">更多</a>&nbsp;></span>投资动态</div>
      <ul>
        <li><span>2015/08/08</span><a href="#">加入本息保障计划的投资，在借款逾期</a></li>
        <li><span>2015/08/08</span><a href="#">本项目融资资金主要用于加速拓展下</a></li>
        <li><span>2015/08/08</span><a href="#">本项目融资资金主要用于加速拓展下</a></li>
        <li><span>2015/08/08</span><a href="#">本项目融资资金主要用于加速拓展下</a></li>
      </ul>
      <div class="title1"><span><a href="#">更多</a>&nbsp;></span>理财助手</div>
      <ul>
        <li><span>2015/09/09</span><a href="#">2015年6月6日—7日发标预...</a></li>
        <li><span>2015/09/09</span><a href="#">2015年6月6日—7日发标预...</a></li>
        <li><span>2015/09/09</span><a href="#">2015年6月6日—7日发标预...</a></li>
        <li><span>2015/09/09</span><a href="#">2015年6月6日—7日发标预...</a></li>
      </ul>
    </div>
  </div>
</div>
<div class="five">
  <div class="five_conter">
    <div class="title"> <span>合作伙伴</span> </div>
    <ul>
      <li><a href="#"><img src="${ctx}/static/images/pic17.gif" width="170" height="65"></a></li>
      <li><a href="#"><img src="${ctx}/static/images/pic17.gif" width="170" height="65"></a></li>
      <li><a href="#"><img src="${ctx}/static/images/pic17.gif" width="170" height="65"></a></li>
      <li><a href="#"><img src="${ctx}/static/images/pic17.gif" width="170" height="65"></a></li>
      <li><a href="#"><img src="${ctx}/static/images/pic17.gif" width="170" height="65"></a></li>
      <li><a href="#"><img src="${ctx}/static/images/pic17.gif" width="170" height="65"></a></li>
      <li><a href="#"><img src="${ctx}/static/images/pic17.gif" width="170" height="65"></a></li>
      <li><a href="#"><img src="${ctx}/static/images/pic17.gif" width="170" height="65"></a></li>
      <li><a href="#"><img src="${ctx}/static/images/pic17.gif" width="170" height="65"></a></li>
      <li><a href="#"><img src="${ctx}/static/images/pic17.gif" width="170" height="65"></a></li>
    </ul>
  </div>
</div>

<div class="six">
    	<div class="six_top">
        	<div class="left">
            	<ul>
                	<li class="mar1">我要投资</li>
                    <li><a href="#">活期宝</a></li>
                    <li><a href="#">银保理</a></li>
                    <li><a href="#">银房宝</a></li>
                    <li><a href="#">银企宝</a></li>
                    <li><a href="#">银融租</a></li>
                </ul>
                <ul>
                	<li class="mar1">安全保障</li>
                    <li><a href="#">机构合作</a></li>
                    <li><a href="#">风险控制</a></li>
                    <li><a href="#">项目审核</a></li>
                    <li><a href="#">合法合规</a></li>
                </ul>
                <ul>
                	<li class="mar1">关于我们</li>
                    <li><a href="#">关于我们</a></li>
                    <li><a href="#">管理团队</a></li>
                    <li><a href="#">企业文化</a></li>
                    <li><a href="#">招贤纳士</a></li>
                    <li><a href="#">联系我们</a></li>
                </ul>
                <ul style="background:none">
                	<li class="mar1">帮助中心</li>
                    <li><a href="#">注册与登录</a></li>
                    <li><a href="#">认证与安全</a></li>
                    <li><a href="#">P2P理财技巧</a></li>
                    <li><a href="#">理财投资知识</a></li>
                    <li><a href="#">充值与提现</a></li>
                </ul>
            </div>
            <div class="conter">
            	<ul>
                	<li>关注我们</li>
                    <li><a href="#"><img src="${ctx}/static/images/pic20.gif" width="39" height="39"></a></li>
                    <li><a href="#"><img src="${ctx}/static/images/pic21.gif" width="39" height="39"></a></li>
                </ul>
                
              <ul>
                	<li>APP下载</li>
                    <li><a href="#"><img src="${ctx}/static/images/pic22.gif" width="39" height="39"></a></li>
                    <li><a href="#"><img src="${ctx}/static/images/pic23.gif" width="39" height="39"></a></li>
                </ul>
            </div>
            
          <div class="right">
          	<div class="right_top">
            	<dl>
                	<dt><img src="${ctx}/static/images/pic24.gif" width="100" height="95"></dt>
                    <dd>
                    	<ul>
                        	<li>服务时间：</li>
                            <li>09:00 - 18:00</li>
                            <li>邮箱：</li>
                            <li>714104137@qq.com</li>
                        </ul>
                    </dd>
                </dl>
            </div>
            <div class="right_bottom"><img src="${ctx}/static/images/pic25.gif" width="251" height="27"></div>
          </div>
        </div>
        <div class="six_bottom">
        	<ul>
            	<li><a href="#"><img src="${ctx}/static/images/pic26.gif"></a></li>
                <li><a href="#"><img src="${ctx}/static/images/pic28.gif"></a></li>
                <li><a href="#"><img src="${ctx}/static/images/pic29.gif"></a></li>
                <li><a href="#"><img src="${ctx}/static/images/pic30.gif"></a></li>
                <li><a href="#"><img src="${ctx}/static/images/pic31.gif"></a></li>
                <li><a href="#"><img src="${ctx}/static/images/pic32.gif"></a></li>
     
                
                
            </ul>
    </div>
    </div>


<script type="text/javascript">jQuery(".topNav").slide({ type:"menu",  titCell:"dd", targetCell:"ul", delayTime:0,defaultPlay:false,returnDefault:true  });	</script>
</body>
</html>