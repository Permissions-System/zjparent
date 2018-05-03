<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="WEB-INF/common/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>


</script>

<script charset="utf-8" src="http://wpa.b.qq.com/cgi/wpa.php"></script>
<style type="text/css">
td {
	padding:10px;
}
</style>

</head>

<body>
<%@include file="WEB-INF/page/header.jsp"%>

<div style="width:1000px; margin-left:auto; margin-right:auto;margin-top:30px;font-size:14px">
<span style="font-size:16px; font-weight:600; line-height:30px;">快捷支付为什么会支付失败</span><br>
支付失败会有多种原因：<br>
1、	银行卡户名与微钱包账号实名信息不符；<br>
2、	当前填写的手机号与该银行卡在银行预留的手机号不匹配；<br>
3、	支付金额超出银行单笔限额或每日限额，会导致支付失败。若超出每日限额，您可以在第二天重新发起支付；<br>
4、	支付金额超出您在银行端设置的单笔限额或每日限额，会导致支付失败，请登录银行网站修改支付限额后重新发起支付；<br>
5、	系统繁忙：微钱包系统或者开户行银行系统繁忙或者正在升级，您可以稍后重新发起支付。<br>
<br><br>
<span style="font-size:16px; font-weight:600; line-height:40px;">各种快捷支付的限额</span><br>  
<table width="100%" border="1" cellspacing="0" cellpadding="0">
    <tr>
      <td width="88">银行</td>
      <td width="72">卡类型</td>
      <td width="104">每日限（元）</td>
      <td width="83">每日限次</td>
      <td width="129">日累计限额（元）</td>
      <td width="120">月累计限额</td>
    </tr>
    <tr>
      <td width="88">所有银行</td>
      <td width="72">所有卡</td>
      <td width="104">500</td>
      <td width="83">不限</td>
      <td width="129">1500</td>
      <td width="120">不限</td>
    </tr>
</table>
<br>
<br>
  
<span style="font-size:16px; font-weight:600; line-height:40px;">各银行网上支付的限额</span><br>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
    <tr>
      <td width="120">银行</td>
      <td width="85">开通范围</td>
      <td width="100">客户类型</td>
      <td width="100">单笔限额(元)</td>
      <td width="100">日累计限额(元)</td>
      <td width="400">开通条件</td>
      <td width="93">客服热线</td>
    </tr>
    <tr>
      <td width="69" rowspan="4">中国工商银行</td>
      <td width="74" rowspan="4">储蓄卡</td>
      <td width="76">电子口令卡</td>
      <td width="76">500</td>
      <td width="85">1000</td>
      <td width="120" rowspan="4">请到中国工商银行各营业网点办理成为个人网上银行客户并开通网上支付功能（静态密码用户进行网上支付如超过累计金额请直接到营业网点申领电子口令卡或USB&nbsp;Key）</td>
      <td width="93" rowspan="4">95588</td>
    </tr>
    <tr>
      <td width="76">短信认证</td>
      <td width="76">2000</td>
      <td width="85">5000</td>
    </tr>
    <tr>
      <td width="76">电子密码</td>
      <td width="76">50万</td>
      <td width="85">100万</td>
    </tr>
    <tr>
      <td width="76">U盾</td>
      <td width="76">100万</td>
      <td width="85">100万</td>
    </tr>
    <tr>
      <td width="69" rowspan="3">中国农业银行</td>
      <td width="74" rowspan="3">储蓄卡</td>
      <td width="76">动态口令</td>
      <td width="76">1000</td>
      <td width="85">3000</td>
      <td width="120" rowspan="3">动态密码用户：请到各营业网点申请成为动态密码用户；K宝用户：请到各营业网点办理成为K宝用户</td>
      <td width="93" rowspan="3">95599</td>
    </tr>
    <tr>
      <td width="76">移动证书（一代k宝）</td>
      <td width="76">50万</td>
      <td width="85">100万</td>
    </tr>
    <tr>
      <td width="76">移动证书（二代k宝）</td>
      <td width="76">100万</td>
      <td width="85">500万</td>
    </tr>
    <tr>
      <td width="69">中国银行</td>
      <td width="74">储蓄卡</td>
      <td width="76" rowspan="2">USBKey证书认证、令牌+动态口令</td>
      <td width="76">1万</td>
      <td width="85">20万</td>
      <td width="120" rowspan="2">请到各营业网点办理开通个人网上银行，申请动态口令e-token，再登陆中国银行网上银行开通网上支付功能并设置网上支付限额</td>
      <td width="93" rowspan="2">95566</td>
    </tr>
    <tr>
      <td width="69">中国银行(大额)</td>
      <td width="74">储蓄卡</td>
      <td width="76">无限额，自行设置</td>
      <td width="85">无限额，自行设置</td>
    </tr>
    <tr>
      <td width="69" rowspan="4">中国建设银行</td>
      <td width="74" rowspan="4">储蓄卡</td>
      <td width="76">账号直接支付</td>
      <td width="76">1000</td>
      <td width="85">1000</td>
      <td width="120" rowspan="4">请到各营业网点办理签约，再登陆个人网银激活；或先登陆个人网银注册，再到各营业网点办理签约</td>
      <td width="93" rowspan="4">95533</td>
    </tr>
    <tr>
      <td width="76">动态口令</td>
      <td width="76">5000</td>
      <td width="85">5000</td>
    </tr>
    <tr>
      <td width="76">网银盾1代</td>
      <td width="76">5万</td>
      <td width="85">10万</td>
    </tr>
    <tr>
      <td width="76">网银盾2代</td>
      <td width="76">50万</td>
      <td width="85">50万</td>
    </tr>
    <tr>
      <td width="69" rowspan="2">交通银行</td>
      <td width="74" rowspan="2">储蓄卡</td>
      <td width="76">手机短信密码验证</td>
      <td width="76">5万</td>
      <td width="85">5万</td>
      <td width="120" rowspan="2">请到交通银行各营业网点办理开通手续，再登陆个人网上银行进行激活</td>
      <td width="93" rowspan="2">95559</td>
    </tr>
    <tr>
      <td width="76">USBKey证书认证</td>
      <td width="76">100万</td>
      <td width="85">100万</td>
    </tr>
    <tr>
      <td width="69" rowspan="2">中信银行</td>
      <td width="74" rowspan="2">储蓄卡</td>
      <td width="76">手机动态密码</td>
      <td width="76">1000</td>
      <td width="85">5000</td>
      <td width="120" rowspan="2">请您到中信银行各营业网点办理开通个人网上银行加强版，选择申请数字文件证书或USB&nbsp;Key，登陆个人网上银行加强版设置网上支付限额；客服热线：95558。</td>
      <td width="93" rowspan="2">95558</td>
    </tr>
    <tr>
      <td width="76">U盾</td>
      <td width="76">100万</td>
      <td width="85">100万</td>
    </tr>
    <tr>
      <td width="69">兴业银行</td>
      <td width="74">储蓄卡</td>
      <td width="76">手机动态密码版</td>
      <td width="76">日累积范围内无限额</td>
      <td width="85">初始5000</td>
      <td width="120"></td>
      <td width="93"></td>
    </tr>
    <tr>
      <td width="69">光大银行</td>
      <td width="74">储蓄卡</td>
      <td width="76">手机动态密码</td>
      <td width="76">1万</td>
      <td width="85">1万</td>
      <td width="120">手机动态密码：指个人客户以通过输入银行账号和指定手机中接受到的动态密码进行支付的方式；签约渠道为网点柜台、个人网上银行（专业版）；</td>
      <td width="93">95595</td>
    </tr>
    <tr>
      <td width="69">民生银行</td>
      <td width="74">储蓄卡</td>
      <td width="76">大众版</td>
      <td width="76">300</td>
      <td width="85">300</td>
      <td width="120">大众版：请先登陆网银大众版开通民生卡支付功能并设置网上支付限额，每个帐户开通和关闭只能各申请一次；</td>
      <td width="93">95568</td>
    </tr>
    <tr>
      <td width="69">广发银行</td>
      <td width="74">储蓄卡</td>
      <td width="76">手机动态密码版</td>
      <td width="76">5000</td>
      <td width="85">5000</td>
      <td width="120">手机动态密码用户：在广发个人网银上申请开通个人网银功能，凭借广发银行向个人网银用户预留手机号发送的六位数字密码进行交易；</td>
      <td width="93">4008308003</td>
    </tr>
    <tr>
      <td width="69" rowspan="2">上海银行</td>
      <td width="74" rowspan="2">储蓄卡</td>
      <td width="76">办理E盾证书版个人网银，开通网上支付功能</td>
      <td width="76">50万元</td>
      <td width="85">100万元</td>
      <td width="120" rowspan="2"></td>
      <td width="93" rowspan="2"></td>
    </tr>
    <tr>
      <td width="76">办理动态密码版个人网银（含文件证书）,开通网上支付功能</td>
      <td width="76">6000元</td>
      <td width="85">1万元</td>
    </tr>
    <tr>
      <td width="69" rowspan="2">招商银行</td>
      <td width="74" rowspan="2">储蓄卡</td>
      <td width="76">大众版</td>
      <td width="76">500</td>
      <td width="85">500</td>
      <td width="120">一卡通大众版：请登陆招行网站，或通过电话银行人工服务，或到网点柜面申请开通一卡通网上支付功能，并设定网上支付密码；</td>
      <td width="93" rowspan="2">95555</td>
    </tr>
    <tr>
      <td width="76">专业版</td>
      <td width="76">无限额</td>
      <td width="85">无限额</td>
      <td width="120">一卡通专业版：请到各营业网点办理成为个人网上银行专业版用户；</td>
    </tr>
    <tr>
      <td width="69">浦发银行</td>
      <td width="74">储蓄卡</td>
      <td width="76">手机动态密码</td>
      <td width="76">20万</td>
      <td width="85">20万</td>
      <td width="120">请到浦发银行各营业网点办理成为网上银行专业版用户的手续，并选择申请手机支付安全动态密码或使用网上银行数字证书来进行网上支付交易。</td>
      <td width="93">95528</td>
    </tr>
    <tr>
      <td width="69">平安银行</td>
      <td width="74">储蓄卡</td>
      <td width="76">网银</td>
      <td width="76">无限额</td>
      <td width="85">5万</td>
      <td width="120">请到银行各营业网点办理成为一账通网银高级客户，预留接收动态密码的电话/手机号码，再登陆银行个人网银操作激活（2009年12月之后申请银行卡的客户可以直接登陆个人网银开通一账通网银）</td>
      <td width="93">4006699999</td>
    </tr>
    <tr>
      <td width="69">渤海银行</td>
      <td width="74">储蓄卡</td>
      <td width="76"></td>
      <td width="76">2万</td>
      <td width="85">10万</td>
      <td width="120">请到渤海银行各营业网点申请办理个人网上银行服务，获得动态口令,绑定动态口令后,登陆个人网上银行，选择&quot;电子商务支付&quot;项下的&quot;网上支付功能开关&quot;选项，完成开通；凭网银客户号、动态口令、静态密码进行网上支付交易</td>
      <td width="93">4008888811</td>
    </tr>
    <tr>
      <td width="69" rowspan="4">华夏银行</td>
      <td width="74" rowspan="4">储蓄卡</td>
      <td width="76" rowspan="2">大众版</td>
      <td width="76" rowspan="2">300</td>
      <td width="85" rowspan="2">1000</td>
      <td width="120">使用华夏银行E商宝网上支付，请先在华夏银行营业网点或网上银行进行签约手续。已经开通华夏银行个人网银功能的客户，可直接在网上银行进行签约手续，如使用华夏盾的客户，请在插上华夏盾之后再在网上银行进行签约手续。</td>
      <td width="93" rowspan="4">95577</td>
    </tr>
    <tr>
      <td width="120">普通支付方式：凭ATM密码通过华夏银行的&ldquo;直接支付&rdquo;方式进行网上支付；</td>
    </tr>
    <tr>
      <td width="76">手机动态</td>
      <td width="76">1000</td>
      <td width="85">5000</td>
      <td width="120">手机动态验证方式：客户选择网上手机动态验证方式进行支付，在收到华夏银行手机动态验证密码后，通过手机动态验证方式进行网上支付。</td>
    </tr>
    <tr>
      <td width="76">数字证书</td>
      <td width="76">50000</td>
      <td width="85">100000</td>
      <td width="120">数字证书验证方式：客户请到华夏银行营业网点办理个人网上银行签约手续，领取网银客户号和华夏盾后，通过数字证书验证方式进行网上支付</td>
    </tr>
    <tr>
      <td width="69" rowspan="3">北京银行</td>
      <td width="74" rowspan="3">借记卡</td>
      <td width="76">普通版</td>
      <td width="76"></td>
      <td width="85">总累计限额为300元</td>
      <td width="120" rowspan="3"></td>
      <td width="93" rowspan="3"></td>
    </tr>
    <tr>
      <td width="76">动态密码版</td>
      <td width="76">1000</td>
      <td width="85">5000</td>
    </tr>
    <tr>
      <td width="76">证书版</td>
      <td width="76">100万</td>
      <td width="85">100万</td>
    </tr>
    <tr>
      <td width="69" rowspan="2">上海农商银行</td>
      <td width="74" rowspan="2">储蓄卡</td>
      <td width="76">短信专业版</td>
      <td width="76">1000</td>
      <td width="85">5000</td>
      <td width="120"></td>
      <td width="93">021-962999</td>
    </tr>
    <tr>
      <td width="76">证书专业版</td>
      <td width="76">10000</td>
      <td width="85">100万</td>
      <td width="120"></td>
      <td width="93">4006962999</td>
    </tr>
    <tr>
      <td width="69" rowspan="2">上海农商银行</td>
      <td width="74" rowspan="2">借记卡</td>
      <td width="76">短信专业版</td>
      <td width="76">1000</td>
      <td width="85">5000</td>
      <td width="120"></td>
      <td width="93"></td>
    </tr>
    <tr>
      <td width="76">证书专业版</td>
      <td width="76">1万</td>
      <td width="85">100万</td>
      <td width="120"></td>
      <td width="93"></td>
    </tr>
    <tr>
      <td width="69" rowspan="2">浙商银行</td>
      <td width="74" rowspan="2">借记卡</td>
      <td width="76">自助注册</td>
      <td width="76">200</td>
      <td width="85">200</td>
      <td width="120"></td>
      <td width="93" rowspan="2">95527</td>
    </tr>
    <tr>
      <td width="76">大众版</td>
      <td width="76">1000</td>
      <td width="85">1000</td>
      <td width="120"></td>
    </tr>
    <tr>
      <td width="69" rowspan="2">恒丰银行</td>
      <td width="74" rowspan="2">借记卡</td>
      <td width="76">大众版</td>
      <td width="76">500</td>
      <td width="85">500</td>
      <td width="120"></td>
      <td width="93" rowspan="2">4008138888</td>
    </tr>
    <tr>
      <td width="76">专业版</td>
      <td width="76">无限额</td>
      <td width="85">无限额</td>
      <td width="120"></td>
    </tr>
  </table>
</div>

<%@include file="WEB-INF/page/footer.jsp" %>
<script src="${ctx}/static/js/amazeui.js"></script>
</body>

<script type="text/javascript">
$('.DB_tab25').DB_tabMotionBanner({
	key:'b28551',
	autoRollingTime:6000,                            
	bgSpeed:500,
	motion:{
		DB_1_3:{left:0,opacity:0,speed:1000,delay:500},
		DB_2_1:{top:50,opacity:0,speed:1000,delay:500},
		DB_2_2:{top:50,opacity:0,speed:1000,delay:1000},
		DB_2_3:{top:0,opacity:0,speed:1000,delay:500},
		DB_3_1:{left:-50,opacity:0,speed:1000,delay:500},
		DB_3_2:{top:50,opacity:0,speed:1000,delay:1000},
		DB_3_3:{top:0,opacity:0,speed:1000,delay:500},
		DB_4_1:{top:0,opacity:0,speed:1000,delay:500},
		DB_4_2:{top:0,opacity:0,speed:1000,delay:500},
		DB_4_3:{top:0,opacity:0,speed:1000,delay:500},
		DB_4_4:{top:30,opacity:0,speed:1000,delay:2000},
		DB_4_5:{top:100,opacity:0,speed:1000,delay:3000},
		end:null
	}
})
</script>
</html>
