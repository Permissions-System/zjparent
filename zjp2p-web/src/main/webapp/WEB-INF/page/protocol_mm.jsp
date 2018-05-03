<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html xmlns="http://www.w3.org/1999/xhtml">  
  <head>
  <title>月月富T投资协议 - 百富网小额投资理财平台</title>
  <%@include file="../common/tdk.jsp"%> 
  <%@include file="../common/header.jsp"%>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
	position:relative;
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
  <div class="debt_titles">百富网月月富投资协议书</div>
  
  <div>
百富网编号：${obj.contractNo}<br/><br/>
本投资协议书（以下简称“本协议”）由以下双方于【${obj.year}】年【${obj.month}】月【${obj.day}】日签订：
<br/><br/><br/><br/>
甲方：上海必富金融信息服务有限公司<br/><br/>
地址：上海市江场西路299号中环时代广场4座11楼<br/><br/>
<br/><br/>
乙方：${obj.realname}<br/><br/>
百富网用户名：${obj.username}<br/><br/>
身份证号码：${obj.idcard}<br/><br/>
<br/><br/>
鉴于甲方具有提供互联网信息服务的资质并拥有百富网（www.biifoo.com）的经营权，甲乙双方经友好协商，本着平等自愿、诚实信用的原则，就百富网提供的"月月富"理财计划的相关事项达成如下协议：
<br/><br/>
释义：
<br/><br/>
除非本协议另有规定，以下词语在本协议中定义如下：
<br/><br/>
a. 百富网：指由甲方运营和管理的网站，域名为：<a href="http://www.biifoo.com">www.biifoo.com</a>。
<br/><br/>
b. 投资人（乙方）：指通过甲方百富网成功注册账户的会员，可参考甲方的推荐自主选择投资一定金额的资金给投资项目，且具有完全民事权利/行为能力的自然人。
<br/><br/>
c. 合作机构：指与甲方建立合作关系的机构，包括但不限于金融服务公司、小额贷款公司、融资性担保公司、第三方支付机构等。
<br/><br/>
d. 月月富产品范围：由经过平台严格认证成为战略合作伙伴的合作机构推荐的以国有大型知名金融机构发行的金融资产作为增信的投资项目，包括但不限于债权转让、融资租赁、信托受益权等
<br/><br/>
e. 融资：投资人拟向融资客户提供的融资。
<br/><br/>
f. 监管账户：以甲方名义在银行开立的、账户内资金独立于甲方自有资金的银行监管/保管账户。
<br/><br/>
g. 百富网账户：指出投资人或融资客户以自身名义在百富网注册后系统自动产生的虚拟账户，通过第三方支付机构及/或其他通道进行充值或提现。
<br/><br/>
h. 《百富网融资合同》：指通过百富网平台完成撮合的融资合同。
<br/><br/>
i. 月月富：指百富网推出的按月计息，到期还本付息的投资项目。

<br/><br/><br/>
<strong>一、主要内容</strong>
<br/><br/>
1.1 月月富：月月富是由百富网推出的根据第三方机构推荐的以优质的投资项目作为支持的理财项目，现阶段分为6个月。乙方投资的本金及其获得的相关收益将在投资期限届满后一次性返回其账户。
<br/><br/>
1.2 额度：本期月月富的总额度为【${obj.bidAmount}】元人民币 。
<br/><br/>
1.3 期限：本期月月富的期限为【${obj.investperiod}】个月，自本协议生效日起计。
<br/><br/>
1.4 投资金额及预期收益：乙方知悉、了解并同意，本协议项下涉及的任何收益均为预期收益，甲方未以任何方式对本金及预期收益进行承诺或担保，乙方投资本金存在不能够按期收回的风险，同时，在实际收益未达到预期收益的情况下，乙方仅能收取其期初加入本金数额所对应的实际收益，在前述前提下，乙方同意通过百富网平台加入甲方提供的本期月月富，具体如下：
<br/><br/>
<table width="100%" border="1" cellspacing="0" cellpadding="0" style="text-align:center; color:#999">
  <tr>
    <td width="14%" height="45">名称</td>
    <td width="10%">${obj.bidclassname}</td>
    <td width="16%">预期年化收益率</td>
    <td width="4%">${obj.annualizedrate}%</td>
    <td width="7%">十万</td>
    <td width="7%">万</td>
    <td width="7%">千</td>
    <td width="7%">百</td>
    <td width="7%">十</td>
    <td width="7%">元</td>
    <td width="7%">角</td>
    <td width="7%">分</td>
  </tr>
  <tr>
    <td height="45">期初加入本金数额</td>
    <td colspan="3">${obj.buyAmountCapital}</td>
    <td>${obj.buymoneyArray[0]}</td>
    <td>${obj.buymoneyArray[1]}</td>
    <td>${obj.buymoneyArray[2]}</td>
    <td>${obj.buymoneyArray[3]}</td>
    <td>${obj.buymoneyArray[4]}</td>
    <td>${obj.buymoneyArray[5]}</td>
    <td>${obj.buymoneyArray[6]}</td>
    <td>${obj.buymoneyArray[7]}</td>
  </tr>
  <tr>
    <td height="45">期末偿还本息金额</td>
    <td colspan="3">${obj.exptIncomeCapital}</td>
    <td>${obj.exptIncomeArray[0]}</td>
    <td>${obj.exptIncomeArray[1]}</td>
    <td>${obj.exptIncomeArray[2]}</td>
    <td>${obj.exptIncomeArray[3]}</td>
    <td>${obj.exptIncomeArray[4]}</td>
    <td>${obj.exptIncomeArray[5]}</td>
    <td>${obj.exptIncomeArray[6]}</td>
    <td>${obj.exptIncomeArray[7]}</td>
  </tr>
  <tr>
    <td height="45">期限</td>
    <td>${obj.investperiod}个月</td>
    <td colspan="2">投资范围</td>
    <td colspan="8">金融资产质押的融资项目</td>
  </tr>
  <tr>
    <td height="45">收益分配方式</td>
    <td>${obj.repaymentwayStr}</td>
    <td colspan="2">预计还款日期</td>
    <td colspan="8">${obj.exptexpiredate}</td>
  </tr>
</table>
<br/><br/>
1.5 投资资金来源保证：乙方保证其所用于投资的资金来源合法，乙方是该资金的合法所有人，如果第三方对资金归属、合法性问题提出异议，由乙方自行解决。如未能解决，则乙方承诺放弃享有其所投资资金带来的利息等收益。
<br/><br/><br/>
<strong>二、本协议的成立</strong>
<br/><br/>
2.1 本协议成立：乙方按照百富网的规则，通过在百富网上勾选"我同意《月月富投资协议书》"以及点击"立刻投资"按钮确认后，即视为乙方与甲方已达成协议并同意接受本协议的全部约定以及与百富网网站所包含的其他与本协议有关的各项规则的规定。
<br/><br/>
2.2 加入资金冻结：乙方点击"我要投资"按钮确认后，即视为乙方已经向甲方发出不可撤销的授权指令，授权甲方委托相应的第三方支付机构及甲方开立监管账户的监管银行（"监管银行"）等合作机构，在监管账户中乙方百富网用户名项下的虚拟账户（"乙方百富网账户"）中，冻结金额等同于本协议第1.4条所列的"期初加入本金数额"的资金。上述冻结在本协议生效时或本协议确定失效时解除。
<br/><br/>
2.3 资金划转：
<br/><br/>
2.3.1 本期月月富所对应的加入资金全部冻结，且甲方系统完成所有资金的匹配后，根据本期月月富所投项目的《融资担保合同${obj.contractNo}号》的相关约定，上述项目的投资客户即不可撤销地授权甲方委托相应的第三方支付机构及监管银行等合作机构，将金额等同于本协议1.4条所列的"期初加入本金数额"的资金，逐笔按照《融资担保合同${obj.contractNo}号》第1条所列的"融资本金数额"，由监管账户中乙方百富网账户下划转至监管账户中相应的融资方客户的百富网账户，再由甲方系统划转至融资方客户的银行账户，划转完毕即视为投资成功。
<br/><br/>
2.3.2 甲方将在任意一期月月富所对应的加入资金全部冻结后的1-3个工作日内完成当期月月富资金的统一投资及划转。如1-3个工作日未完成上述操作，则甲方将乙方冻结资金退回乙方在百富网的账户，资金冻结期间不计收益。
<br/><br/>
2.4 本协议生效：本协议于甲方完成本期月月富所对应的全部资金划转之日（"生效日"）立即生效，收益及相关费用自生效日开始计算。
<br/><br/>
2.5 在月月富存续期限内，除本协议双方协商一致或本协议另有约定外，本协议项下的期限、收益分配方式、每月还款日期等均不得变更。
<br/><br/><br/>
<strong>三、投资管理</strong>
<br/><br/>
3.1 乙方全权委托甲方按照本协议的约定，对等同于本协议1.4条所列的"期初加入本金"进行自动优先投资，作为投资资金投资给百富网平台上经甲方认真审核并将其拥有的由国有大型金融机构发行的金融资产在第三方合作质押作为其增信手段的融资客户；同时，乙方授权甲方在完成上述自动优先投资后以乙方名义代为签署相应的《融资担保合同${obj.contractNo}号》。
<br/><br/>
3.2 投资范围：百富网平台上由国有大型信托机构发行的金融资产作为质押增信债权的项目，且由甲方仔细审核通过。
<br/><br/>
3.3 乙方加入月月富后，甲方将按照乙方加入时间的先后顺序，对乙方加入月月富的一定金额的资金进行自动优先投资。先加入月月富的资金，在同期月月富所对应的全部资金内具有自动优先投资和到期赎回的更高优先级。
<br/><br/>
3.4 后续管理：乙方全权委托甲方对本期月月富所投资项目的后续回款进行如下处理并以乙方名义代为签署相应的《融资担保合同${obj.contractNo}号》：
<br/><br/>
3.4.1 在本期月月富的存续期限内，如投资项目发生提前还款的，甲方有权将本期月月富所投资项目返还的本金（包括但不限于等额本息还款所还本金、提前还款所还本金等）自动优先投资到新的与原项目的类型和信用等级相同的项目，投资范围参见本协议第3.2条。
<br/><br/>
3.4.2 在本期月月富的存续期限内，对于月月富所投资项目每月返还的利息收益，甲方将根据乙方选择的本期月月富的收益分配方式（参见本协议第4.3条），决定对其的管理方式。
<br/><br/>
3.5 在本期月月富期限届满后，乙方全权委托甲方将乙方所持有未到期的债权代为进行债权转让并以乙方名义代为签署相应的《融资担保合同》。
<br/><br/>
3.6 本金返还时间：月月富期限届满后1-3个工作日内（含3个工作日）。
<br/><br/><br/>
<strong>四、收益及费用</strong>
<br/><br/>
4.1 收益来源：乙方委托甲方通过自动优先投资将自有资金投资给百富网平台上的融资客户后，融资客户每月还款的利息在扣除管理费用和/或提前赎回费用后的剩余部分将作为月月富的收益支付给乙方（若融资客户每月还款的利息不足以扣除提前赎回费用的，则在本金中予以扣除）。
<br/><br/>
4.2 收益起算时间：自本协议生效且资金划转到融资方账户后开始计算收益。<br/><br/>
4.3 收益分配方式：乙方在加入本期月月富产品时， 使用自动优先投资功能将每月产生的利息收益投资百富网平台上的经甲方合作机构推荐其他融资项目。<br/><br/>
4.4 月月富费用种类：月月富费用包括管理费用以及提前赎回费用。
<br/><br/>
4.5 管理费用来源：本协议项下管理费用来源于乙方购买的月月富所对应的融资的利息中超过月月富预期年化收益以外的部分（本期月月富预期年化收益请参见本协议第1.4条）。月月富实际收益不及预期年化收益的，甲方不收取管理费用。
<br/><br/>
4.6 费用收取方式：甲方向乙方返还每月收益时或进行收益复投时，甲方自动扣除当期管理费用，管理费用按月计算并收取。
<br/><br/>
4.7 提前赎回费用仅在乙方申请提前赎回时产生，费用标准参见本协议第5.8条。
<br/><br/><br/>
<strong>五、提前赎回</strong>
<br/><br/>
5.1 发起申请：乙方可在月月富存续期限内选择提前赎回；但在月月富到期日3个工作日内（含3个工作日），乙方不得发起提前赎回申请。
<br/><br/>
5.2 赎回方式：乙方只可选择一次性提前赎回其加入月月富的单笔全部资金，不能选择部分赎回或分期赎回。
<br/><br/>
5.3 申请确认：乙方提交的申请，甲方在1-3工作日内（含3个工作日）受理并确认
<br/><br/>
5.4 申请撤销：乙方发起的提前赎回申请无法撤销。
<br/><br/>
5.5 赎回时间：提前赎回申请确认后，一般在确认日的次工作日内完成赎回。甲方确保因提前赎回产生的债权，具备较高的投资优先级。
<br/><br/>
5.6 额度限制：乙方单日能够提投资的金额，应同时符合下列条件：
<br/><br/>
5.6.1 月月富单日单笔最高投资额度限制：【50000】元；
<br/><br/>
5.6.2 所有产品提前赎回的总额度，每日不能超过百富网流动保障金账户中相关产品的赎回流动保障金总额。
<br/><br/>
5.7 利息结算：提前赎回的利息结算精确到日，截止到甲方确认乙方的提前赎回申请当天，提前赎回当天计息。
<br/><br/>
5.8 提前赎回费用：提前赎回成功后，甲方收取赎回本金的2%作为提前赎回费用。
<br/><br/>
5.9 提前赎回失败：甲方不保证乙方的提前赎回申请成功实现。乙方发起的提前赎回申请被甲方确认后的第3个工作日24：00（含24:00）时，若乙方所持有的本期月月富T所对应的融资项目未能成功进行转让的，则乙方此次提前赎回失败。乙方须自行承担提前赎回失败对其所造成的一切损失。
<br/><br/><br/>
<strong>六、其他</strong>
<br/><br/>
6.1 本协议的任何修改、补充均须以百富网平台电子文本形式作出。
<br/><br/>
6.2 双方均确认，本协议的签订、生效和履行以不违反法律为前提。如果本协议中的任何一条或多条被司法部门认定为违反所须适用的法律，则该条将被视为无效，但该无效条款并不影响本协议其他条款的效力。
<br/><br/>
6.3 如双方在本协议履行过程中发生任何争议，应友好协商解决；如协商不成，则须提交甲方所在地有管辖权的人民法院诉讼解决。
  </div>
  <div class="sign">
    <div class="sign_a">
    甲方（签章）${obj.firstParty}
    <br/><br/><br/>
    ${obj.dateStr}
    <div class="sign_mark"><img src="http://www.biifoo.com/static/images/mark2.png"  alt=""/></div>
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