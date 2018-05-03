<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html xmlns="http://www.w3.org/1999/xhtml">  
  <head>
  <title>债权转让协议 - 百富网小额投资理财平台</title>
  <%@include file="../common/tdk.jsp"%> 
  <%@include file="../common/header.jsp"%>
 	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
.debt {
	width: 1000px;
	margin-left:auto;
	margin-right:auto;
	background-color:#fff;
	border-color:#E8E8E8;
	border-style:solid;
	border-width:1px;
	padding-top:35px;
	padding-left:20px;
	padding-right:20px;
	margin-top:30px;
	font-size:14px;
	font-family:"微软雅黑";
	padding-bottom:30px;
}

.debt_titles{
	font-size:20px;
	font-weight:bold;
	text-align:center;
	margin-bottom:40px;
}

.sign {
	margin-top:120px;
	width:100%;
	height:400px;
}

.sign_a {
	width:60%;
	float:left;
	height:100px;
}

.sign_mark{
	position:absolute;
	left:70px;
	top:-40px;
}

.sign_b {
	width:40%;
	float:left;
	height:100px;
}

.sign_c {
	width:40%;
	float:left;
	height:100px;
	margin-top: 120px;
	position:relative;
}
</style>
</head>
<body>
<div class="debt">
  <div class="debt_titles">债权转让协议</div>
  
  <div>
债权出让人：【${obj.firstParty}】（以下简称“甲方”）<br/><br/>
注册地址：${obj.firstPartyAddress}<br/><br/>
法定代表人：${obj.firstPartyLegalPerson}<br/><br/>
<br/><br/>
债权受让人：【${obj.secondParty}】（以下简称“乙方”）<br/><br/>
身份证号码：${obj.idcard}<br/><br/>
百富网用户名：${obj.username}<br/><br/>
<br/><br/>
甲乙双方就甲方通过上海必富金融信息服务有限公司经营管理的网络投融资交易平台（网址：www. biifoo.com，以下简称“ biifoo平台”）向乙方转让其合法享有的债权的相关事宜，经协商一致，达成如下协议，以资共同信守。
<br/><br/><br/>
<strong>第一条 标的转让</strong><br/><br/>

1.1 甲方自愿将其在编号为：    【${obj.contractNo}】    的合同项下的债权部分（包括部份份额或\和部份期限）转让给乙方，乙方同意按照本合同约定条件和方式受让该部分债权。
<br/><br/>
1.2 甲乙双方一致同意并确认，甲方转让给乙方的债权本金为人民币【${obj.buyAmountCapital}】元（￥【${obj.buyAmount}】）（以下简称“标的债权”）。
<br/><br/>
1.3 在本协议项下债权通过“ biifoo平台”乙方确认受让当日【${obj.buyDate}】为起始日。
<br/><br/><br/>
<strong>第二条 转让对价与支付</strong>
<br/><br/>
2.1 甲乙双方一致同意并确认，标的债权转让对价为人民币【${obj.buyAmountCapital}】元（￥【${obj.buyAmount}】）。
<br/><br/>
2.2 甲乙双方一致同意遵照“ biifoo平台”的有关规则和说明进行本协议项下标的债权的转让和价款支付，暨乙方授权“ biifoo平台”或其合作机构直接从乙方账户中扣划相关款项，代为乙方向甲方支付标的债权转让价款；甲方同意上述转让价款扣划完成即视为乙方完成债权转让价款的支付。
<br/><br/><br/>
<strong>第三条 债权的交割</strong>
<br/><br/>
3.1 甲乙双方一致同意自乙方完成债权转让价款的支付之日起，标的债权由甲方转移至乙方，乙方将在其受让债权份额内取代甲方成为新的债权人，享受债权人的权益。
<br/><br/>
3.2 标的债权交割之前已发生但尚未支付的收益归甲方享有；交割之后标的债权的所有权、收益权等概由乙方享有。
<br/><br/><br/>
<strong>第四条 甲方声明和保证</strong>
<br/><br/>
4.1 甲方声明本协议项下标的债权系其真实、合法、有效拥有的债权，甲方对该等债权享有完全的所有权，甲方未在该等出让债权上设定抵押权、质权、其他担保物权或任何第三方权利，该等出让债权亦不存在被法院保全、查封等权利限制情况。
<br/><br/>
4.2 甲方保证在签署本协议之前，未就本协议标的债权与第三方签订债权转让协议，也未在标的债权上设置任何权利障碍。
<br/><br/><br/>
<strong>第五条 乙方声明和保证</strong>
<br/><br/>
5.1 乙方具有完全民事权利能力和完全民事行为能力，能够独立承担民事责任，签订和履行本协议不会违反对其有约束力的法律法规或监管规定，也不违反任何约束或影响甲方或其资产的裁决、命令、协议、或承诺。
<br/><br/>
5.2 乙方保证用于受让标的债权的资金是其自有或其有权处分的合法资金，如果第三人对该资金归属、合法性等问题提出异议，乙方保证负责协调解决并承担相关责任，与甲方或者 biifoo平台无关。
<br/><br/>
5.3 在签署本协议前，已经详细了解标的债权的相关情况以及 biifoo平台的有关业务规则和交易说明，对受让债权可能存在的风险以及受让该等债权后的所有权利、义务有了充分、全面的认识，清楚知悉其中的投资风险，经独立、审慎判断后仍做出投资决定，自愿签署本协议并承担投资风险。
<br/><br/><br/>
<strong>第六条 违约责任</strong>
<br/><br/>
6.1 一方违反其在本协议中所作的声明和保证或未完全履行其在本协议项下的义务，即视为违约，因此给守约方造成损失的，违约方应予赔偿。
<br/><br/>
6.2 违约方因违约应赔偿给守约方的损失，包括但不限于因违约给守约方造成的直接损失，以及守约方在协议履行后可以获得的利益、守约方为防止或减少损失的扩大而支出的合理费用、守约方支付的诉讼费和律师费等间接损失。
<br/><br/>
6.3 双方均有过错的，应根据双方实际过错程度，分别承担各自的违约责任。
<br/><br/><br/>
<strong>第七条 法律适用与争议处理</strong>
<br/><br/>
7.1 本协议的订立、效力、解释、履行、修改、终止以及争议的处理等，均适用中国的法律。
<br/><br/>
7.2因本合同引起的或与本合同有关的争议，各方应友好协商解决；协商不成的，均提请深圳仲裁委员会，按申请仲裁时该会现行有效的仲裁规则进行仲裁。仲裁裁决是终局的，对各方均有约束力。
<br/><br/><br/>
<strong>第八条 其他事项</strong>
<br/><br/>
8.1 协议的签署
<br/><br/>
本协议由甲方委托上海必富金融信息服务有限公司在 biifoo平台发布，乙方通过登录www. biifoo.com网站，以点击确认的方式进行签署。
<br/><br/>
8.2 协议生效
<br/><br/>
本协议自乙方点击确认受让时成立，自乙方完成标的债权转让价款支付后立即生效。
<br/><br/>
8.3 协议文本
<br/><br/>
甲乙双方一致同意并确认本协议采用电子文本形式制成，由 biifoo平台代为保管并保存在 biifoo平台为此设立的专用服务器上备查，对双方均具有法律约束力。
  </div>
  <div class="sign">
    <div class="sign_a">
    甲方（签章）${obj.firstParty}
    <br/><br/><br/>
    ${obj.dateStr}
    </div>
    <div class="sign_b">
    乙方（签章）${obj.secondParty}
    <br/><br/><br/>
    ${obj.dateStr}
    </div>
  </div>
</div>
</body>
</html>