<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
  var ctx = '${ctx}';
</script>
<div class="footer">
  <div class="footer_nav">
    <div class="footer_logo">
      <div class="logo"><img src="${ctx }/static/images/logo_1.png" alt=""/></div>
      <div style="float:left;margin-left:78px;margin-top:57px;"><img src="${ctx }/static/images/2w.png" width="101" height="101"  alt=""/></div>
      <div class="we"><a href="http://weibo.com/u/5368161400" target="new" class="am-biifoolg-btn am-icon-weibo" ></a></div>
      <div class="we2" id="BizQQWPA"><a  class="am-biifoolg-btn am-icon-qq"></a>
      <script type="text/javascript">BizQQWPA.addCustom({aty: '0', a: '0', nameAccount: 4009616588, selector: 'BizQQWPA'});</script>
      </div>
      <p>与我快乐的玩耍吧！</p>
    </div>
    <div class="footernav1">
      <ul>
        <li class="current">基本信息</li>
        <li><a href="${ctx}/introduce.do" target="_blank">百富网介绍</a></li>
        <li><a href="${ctx}/team.do" >精英团队</a></li>
        <li><a href="${ctx}/queryNewsAll.do?categoryid=21" target="_blank">公司新闻</a></li>
        <li><a href="${ctx}/queryNewsAll.do?categoryid=22" target="_blank">媒体报道</a></li>
        <li><a href="${ctx}/investor.do" target="_blank">投资人关系</a></li>
        <li><a href="${ctx}/queryDeptAll.do?parent=3" target="_blank">加入我们</a></li>
        <li><a href="${ctx}/policy.do">政策法规</a></li>
      </ul>
    </div>
    <div class="footernav2">
      <ul>
        <li class="current">发现</li>
        <!-- <li>百富精选</li> -->
        <li>每日任务（即将上线）</li>
        <li><a href="${ctx }/richman.do" target="_black">大富翁测试</a></li>
        <!-- <li>投资收益计算器</li> -->
        <li><a href="${ctx }/redadv.do" target="_black">分享红包</a></li>
        <li><a href="http://www.biifoo.com/m" target="_black">访问移动端</a></li>
        <li>网站地图</li>
      </ul>
    </div>
    <div class="footernav3">
      <ul>
        <li class="current">安全与帮助</li>
        <li><a href="${ctx }/help_detail.do#x1" target="_blank">产品安全</a></li>
        <li><a href="${ctx }/help_detail.do#x1" target="_blank">资金安全</a></li>
        <li><a href="${ctx }/help_detail.do#x1" target="_blank">数据及信息</a></li>
        <li><a href="${ctx }/help_detail.do#x1" target="_blank">隐私保密</a></li>
        <li><a href="${ctx }/helpcenter.do#x3" target="_blank">联系我们</a></li>
        <li><div id="BizQQWPA1"><a href="#">在线客服</a>
		<script type="text/javascript">BizQQWPA.addCustom({aty: '0', a: '0', nameAccount: 4009616588, selector: 'BizQQWPA1'});</script></div></li>
        <li><a href="${ctx }/helpcenter.do#x2" target="_blank">常见问题</a></li>
      </ul>
    </div>
  </div>
  <div class="footer_bottom">
     <div style="float:left"><a href="http://www.itrust.org.cn/yz/pjwx.asp?wm=1320816711" target="new"><img src="${ctx }/static/images/1.png" alt=""/></a></div>
     <div style="float:left; margin-left:32px;"><a href="http://www.sheca.com/default.aspx" target="new"><img src="${ctx }/static/images/22.png" alt=""/></a></div>
     <div style="float:left; margin-left:32px;"><img src="${ctx }/static/images/3.png" alt=""/></div>
  </div>
  <div class="footer_bottom2">
     投资有风险，购买需谨慎 <a href="http://www.miitbeian.gov.cn/" style="color:#565A5C" target="_black">沪ICP备14050495号-2</a><br>Copyright©2015 www.biifoo.com All Rights Reserved
  </div>
</div>
<script src="${ctx }/static/js/amazeui.js"></script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?5cfa4fa7388cde487998f927e3477559";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>