package com.zjgt.p2p.manage.bid.form;

import java.io.Serializable;

public class BidForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5028855940608015266L;

	/**
	 * 字段名称: 标的ID(序列号) . 字段定义: bid.id
	 *
	 * @ET
	 */
	private String id;

	/**
	 * 字段名称: . 字段定义: bid.bidno
	 *
	 * @ET
	 */
	private String bidno;

	/**
	 * 字段名称: 标的分类编号 . 字段定义: bid.bidclassno
	 *
	 * @ET
	 */
	private String bidclassno;

	/**
	 * 字段名称: 1,新手标 2,定存宝 3,月息宝 标的类型编号(新手标/明星标/定存宝/月息宝) . 字段定义: bid.bidtypeid
	 *
	 * @ET
	 */
	private String bidtypeid;

	/**
	 * 字段名称: 标的类型 . 字段定义: bid.bidtype
	 *
	 * @ET
	 */
	private String bidtype;

	/**
	 * 字段名称: 标的分类名称(月存宝,月息宝,新手标) . 字段定义: bid.bidclassname
	 *
	 * @ET
	 */
	private String bidclassname;

	/**
	 * 字段名称: 标的分类介绍 . 字段定义: bid.bidclasssubject
	 *
	 * @ET
	 */
	private String bidclasssubject;

	/**
	 * 字段名称: 标的图片 . 字段定义: bid.bidimg
	 *
	 * @ET
	 */
	private String bidimg;

	/**
	 * 字段名称: 标的发布金额 . 字段定义: bid.amount
	 *
	 * @ET
	 */
	private String amount;

	/**
	 * 字段名称: 投资期限类型 . 字段定义: bid.investperiodtypeid
	 *
	 * @ET
	 */
	private String investperiodtypeid;

	/**
	 * 字段名称: 投资期限 . 字段定义: bid.investperiod
	 *
	 * @ET
	 */
	private String investperiod;

	/**
	 * 字段名称: 募集期限 . 字段定义: bid.raiseperiod
	 *
	 * @ET
	 */
	private String raiseperiod;

	/**
	 * 字段名称: 募集开始日期 . 字段定义: bid.raisebegindate
	 *
	 * @ET
	 */
	private String raisebegindate;

	/**
	 * 字段名称: 募集结束日期 . 字段定义: bid.raiseenddate
	 *
	 * @ET
	 */
	private String raiseenddate;

	/**
	 * 字段名称: 预计起息日 . 字段定义: bid.exptinterestdate
	 *
	 * @ET
	 */
	private String exptinterestdate;

	/**
	 * 字段名称: 预期到期日 . 字段定义: bid.exptexpiredate
	 *
	 * @ET
	 */
	private String exptexpiredate;

	/**
	 * 字段名称: 年化收益率 . 字段定义: bid.annualizedrate
	 *
	 * @ET
	 */
	private String annualizedrate;

	/**
	 * 字段名称: 利息计算方式编号 . 字段定义: bid.intestcalctypeid
	 *
	 * @ET
	 */
	private String intestcalctypeid;

	/**
	 * 字段名称: 利息计算方式描述 . 字段定义: bid.intestcalctype
	 *
	 * @ET
	 */
	private String intestcalctype;

	/**
	 * 字段名称: 预期最后到账日 . 字段定义: bid.exptlastacctdate
	 *
	 * @ET
	 */
	private String exptlastacctdate;

	/**
	 * 字段名称: 单笔最小投资额 . 字段定义: bid.mininvestamount
	 *
	 * @ET
	 */
	private String mininvestamount;

	/**
	 * 字段名称: 单笔最多投资额 . 字段定义: bid.maxinvestamount
	 *
	 * @ET
	 */
	private String maxinvestamount;

	/**
	 * 字段名称: 是否允许提前赎回1:是 . 字段定义: bid.ifredeem
	 *
	 * @ET
	 */
	private String ifredeem;

	/**
	 * 字段名称: 赎回费用方式0:每笔或1:投资百分比 . 字段定义: bid.redeemfeetype
	 *
	 * @ET
	 */
	private String redeemfeetype;

	/**
	 * 字段名称: 赎回费用(0:每笔费用或1:百分比) . 字段定义: bid.redeemfee
	 *
	 * @ET
	 */
	private String redeemfee;

	/**
	 * 字段名称: 是否允许债权转让 . 字段定义: bid.iftransfer
	 *
	 * @ET
	 */
	private String iftransfer;

	/**
	 * 字段名称: 转让方式(0:每笔费用 1:投资总额百分比) . 字段定义: bid.transfertype
	 *
	 * @ET
	 */
	private String transfertype;

	/**
	 * 字段名称: 转让费用或百分比 . 字段定义: bid.transfee
	 *
	 * @ET
	 */
	private String transfee;

	/**
	 * 字段名称: 担保机构编号 . 字段定义: bid.instcode
	 *
	 * @ET
	 */
	private String instcode;

	/**
	 * 字段名称: 担保机构名称 . 字段定义: bid.assureinstname
	 *
	 * @ET
	 */
	private String assureinstname;

	/**
	 * 字段名称: 保障方式 . 字段定义: bid.ensuretype
	 *
	 * @ET
	 */
	private String ensuretype;

	/**
	 * 字段名称: 协议1 . 字段定义: bid.agreement1
	 *
	 * @ET
	 */
	private String agreement1;

	/**
	 * 字段名称: 协议2 . 字段定义: bid.agreement2
	 *
	 * @ET
	 */
	private String agreement2;

	/**
	 * 字段名称: 协议3 . 字段定义: bid.agreement3
	 *
	 * @ET
	 */
	private String agreement3;

	/**
	 * 字段名称: 已募集金额 . 字段定义: bid.raisemoney
	 *
	 * @ET
	 */
	private String raisemoney;

	/**
	 * 字段名称: 募集状态 . 字段定义: bid.raisestate
	 *
	 * @ET
	 */
	private String raisestate;

	/**
	 * 字段名称: 标的状态 . 字段定义: bid.bidstatus
	 *
	 * @ET
	 */
	private String bidstatus;

	/**
	 * 字段名称: 标的编号 . 字段定义: bid.BidCode
	 *
	 * @ET
	 */
	private String bidcode;

	/**
	 * 字段名称: 还款方式 . 字段定义: bid.repaymentway
	 *
	 * @ET
	 */
	private String repaymentway;

	/**
	 * 字段名称: 内部编号 . 字段定义: bid.bindinnerno
	 *
	 * @ET
	 */
	private String bindinnerno;

	/**
	 * 字段名称: 产品介绍 . 字段定义: bid.bidclassintro
	 *
	 * @ET
	 */
	private String bidclassintro;

	/**
	 * 字段名称: 投资范围描述 . 字段定义: bid.investscope
	 *
	 * @ET
	 */
	private String investscope;

	/**
	 * 字段名称: 收益详情描述 . 字段定义: bid.incomedesc
	 *
	 * @ET
	 */
	private String incomedesc;

	/**
	 * 字段名称: 收益方式 . 字段定义: bid.incomeway
	 *
	 * @ET
	 */
	private String incomeway;

	/**
	 * 字段名称: 加入条件描述(认购条件/募集条件) . 字段定义: bid.raisecond
	 *
	 * @ET
	 */
	private String raisecond;

	/**
	 * 字段名称: 到期赎回方式 . 字段定义: bid.redeemway
	 *
	 * @ET
	 */
	private String redeemway;

	/**
	 * 字段名称: 加入费率(认购费率/募集费率) . 字段定义: bid.raiserate
	 *
	 * @ET
	 */
	private String raiserate;

	/**
	 * 字段名称: 到期赎回费率 . 字段定义: bid.redemrate
	 *
	 * @ET
	 */
	private String redemrate;

	/**
	 * 字段名称: 转让费率 . 字段定义: bid.transrate
	 *
	 * @ET
	 */
	private String transrate;

	/**
	 * 字段名称: 提前赎回费率 . 字段定义: bid.prepayrate
	 *
	 * @ET
	 */
	private String prepayrate;

	/**
	 * 字段名称: 电子回单说明 . 字段定义: bid.receiptdesc
	 *
	 * @ET
	 */
	private String receiptdesc;

	/**
	 * 字段名称: 份数 . 字段定义: bid.bidnum
	 *
	 * @ET
	 */
	private String bidnum;

	/**
	 * 字段名称: 标的发布时间 . 字段定义: bid.pubdate
	 *
	 * @ET
	 */
	private String pubdate;

	/**
	 * 字段名称: 操作人 . 字段定义: bid.memberid
	 *
	 * @ET
	 */
	private String memberid;

	/**
	 * 字段名称: 操作人姓名 . 字段定义: bid.membername
	 *
	 * @ET
	 */
	private String membername;
	
    /**
     * 字段名称: 是否虚拟标 .
     * 字段定义: bid.ifvirtual
     *
     * @ET
     */
    private String ifvirtual;

	/**
	 * 字段名称: 风险管理费 . 字段定义: bid.riskmgrfee
	 *
	 * @ET
	 */
	private String riskmgrfee;

	/**
	 * 字段名称: 年服务费 . 字段定义: bid.yearservicefee
	 *
	 * @ET
	 */
	private String yearservicefee;

	/**
     * 字段名称: 发行费用 .
     * 字段定义: bid.pubfee
     *
     * @ET
     */
    private String pubfee;

    /**
     * 字段名称: 信息服务费 .
     * 字段定义: bid.infofee
     *
     * @ET
     */
    private String infofee;

    /**
     * 字段名称: 逾期违约费 .
     * 字段定义: bid.overduefee
     *
     * @ET
     */
    private String overduefee;

    /**
     * 字段名称: 欠付违约费 .
     * 字段定义: bid.unpaidfee
     *
     * @ET
     */
    private String unpaidfee;
	
	public String getPubfee() {
		return pubfee;
	}

	public void setPubfee(String pubfee) {
		this.pubfee = pubfee;
	}

	public String getInfofee() {
		return infofee;
	}

	public void setInfofee(String infofee) {
		this.infofee = infofee;
	}

	public String getOverduefee() {
		return overduefee;
	}

	public void setOverduefee(String overduefee) {
		this.overduefee = overduefee;
	}

	public String getUnpaidfee() {
		return unpaidfee;
	}

	public void setUnpaidfee(String unpaidfee) {
		this.unpaidfee = unpaidfee;
	}

	public String getBorrowercode() {
		return borrowercode;
	}

	public void setBorrowercode(String borrowercode) {
		this.borrowercode = borrowercode;
	}

	public String getBorrowername() {
		return borrowername;
	}

	public void setBorrowername(String borrowername) {
		this.borrowername = borrowername;
	}

	public String getBorrowerdesc() {
		return borrowerdesc;
	}

	public void setBorrowerdesc(String borrowerdesc) {
		this.borrowerdesc = borrowerdesc;
	}

	/**
	 * 字段名称: 备注 . 字段定义: bid.remark
	 *
	 * @ET
	 */
	private String remark;
	
	/**
     * 字段名称: 借款人编号 .
     * 字段定义: bid.borrowerCode
     *
     * @ET
     */
    private String borrowercode;

    /**
     * 字段名称: 借款人名称 .
     * 字段定义: bid.borrowername
     *
     * @ET
     */
    private String borrowername;

    /**
     * 字段名称: 借款信息描述 .
     * 字段定义: bid.borrowerdesc
     *
     * @ET
     */
    private String borrowerdesc;

    /**
     * 字段名称: 质押方式 0-资产 1-股权 .
     * 字段定义: bid.pledgetype
     *
     * @ET
     */
    private String pledgetype;
    
    /**
     * 字段名称: 质押方式 0-资产 1-股权 .
     * 字段定义: bid.pledgetype
     *
     * @ET
     */
    private String pledgetype1;
    
    /**
     * 字段名称: 转让锁定期,发标后N天可转让,单位天 .
     * 字段定义: bid.lockupperiod
     *
     * @ET
     */
    private Integer lockupperiod;
    
    /**
     * 字段名称:  .
     * 字段定义: bid.projectfeature
     *
     * @ET
     */
    private String projectfeature;
    
    /**
     * 字段名称:  .
     * 字段定义: bid.borrowerinterest
     *
     * @ET
     */
    private String borrowerinterest;
    
	/**
	 * This method:getId bid.id
	 *
	 * @return the value of bid.id
	 *
	 * @ET
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method:setId bid.id
	 *
	 * @param id
	 *            the value for bid.id
	 *
	 * @ET
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * This method:getBidno bid.bidno
	 *
	 * @return the value of bid.bidno
	 *
	 * @ET
	 */
	public String getBidno() {
		return bidno;
	}

	/**
	 * This method:setBidno bid.bidno
	 *
	 * @param bidno
	 *            the value for bid.bidno
	 *
	 * @ET
	 */
	public void setBidno(String bidno) {
		this.bidno = bidno == null ? null : bidno.trim();
	}

	/**
	 * This method:getBidclassno bid.bidclassno
	 *
	 * @return the value of bid.bidclassno
	 *
	 * @ET
	 */
	public String getBidclassno() {
		return bidclassno;
	}

	/**
	 * This method:setBidclassno bid.bidclassno
	 *
	 * @param bidclassno
	 *            the value for bid.bidclassno
	 *
	 * @ET
	 */
	public void setBidclassno(String bidclassno) {
		this.bidclassno = bidclassno == null ? null : bidclassno.trim();
	}

	/**
	 * This method:getBidtypeid bid.bidtypeid
	 *
	 * @return the value of bid.bidtypeid
	 *
	 * @ET
	 */
	public String getBidtypeid() {
		return bidtypeid;
	}

	/**
	 * This method:setBidtypeid bid.bidtypeid
	 *
	 * @param bidtypeid
	 *            the value for bid.bidtypeid
	 *
	 * @ET
	 */
	public void setBidtypeid(String bidtypeid) {
		this.bidtypeid = bidtypeid;
	}

	/**
	 * This method:getBidtype bid.bidtype
	 *
	 * @return the value of bid.bidtype
	 *
	 * @ET
	 */
	public String getBidtype() {
		return bidtype;
	}

	/**
	 * This method:setBidtype bid.bidtype
	 *
	 * @param bidtype
	 *            the value for bid.bidtype
	 *
	 * @ET
	 */
	public void setBidtype(String bidtype) {
		this.bidtype = bidtype == null ? null : bidtype.trim();
	}

	/**
	 * This method:getBidclassname bid.bidclassname
	 *
	 * @return the value of bid.bidclassname
	 *
	 * @ET
	 */
	public String getBidclassname() {
		return bidclassname;
	}

	/**
	 * This method:setBidclassname bid.bidclassname
	 *
	 * @param bidclassname
	 *            the value for bid.bidclassname
	 *
	 * @ET
	 */
	public void setBidclassname(String bidclassname) {
		this.bidclassname = bidclassname == null ? null : bidclassname.trim();
	}

	/**
	 * This method:getBidclasssubject bid.bidclasssubject
	 *
	 * @return the value of bid.bidclasssubject
	 *
	 * @ET
	 */
	public String getBidclasssubject() {
		return bidclasssubject;
	}

	/**
	 * This method:setBidclasssubject bid.bidclasssubject
	 *
	 * @param bidclasssubject
	 *            the value for bid.bidclasssubject
	 *
	 * @ET
	 */
	public void setBidclasssubject(String bidclasssubject) {
		this.bidclasssubject = bidclasssubject == null ? null : bidclasssubject
				.trim();
	}

	/**
	 * This method:getBidimg bid.bidimg
	 *
	 * @return the value of bid.bidimg
	 *
	 * @ET
	 */
	public String getBidimg() {
		return bidimg;
	}

	/**
	 * This method:setBidimg bid.bidimg
	 *
	 * @param bidimg
	 *            the value for bid.bidimg
	 *
	 * @ET
	 */
	public void setBidimg(String bidimg) {
		this.bidimg = bidimg == null ? null : bidimg.trim();
	}

	/**
	 * This method:getAmount bid.amount
	 *
	 * @return the value of bid.amount
	 *
	 * @ET
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * This method:setAmount bid.amount
	 *
	 * @param amount
	 *            the value for bid.amount
	 *
	 * @ET
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * This method:getInvestperiodtypeid bid.investperiodtypeid
	 *
	 * @return the value of bid.investperiodtypeid
	 *
	 * @ET
	 */
	public String getInvestperiodtypeid() {
		return investperiodtypeid;
	}

	/**
	 * This method:setInvestperiodtypeid bid.investperiodtypeid
	 *
	 * @param investperiodtypeid
	 *            the value for bid.investperiodtypeid
	 *
	 * @ET
	 */
	public void setInvestperiodtypeid(String investperiodtypeid) {
		this.investperiodtypeid = investperiodtypeid;
	}

	/**
	 * This method:getInvestperiod bid.investperiod
	 *
	 * @return the value of bid.investperiod
	 *
	 * @ET
	 */
	public String getInvestperiod() {
		return investperiod;
	}

	/**
	 * This method:setInvestperiod bid.investperiod
	 *
	 * @param investperiod
	 *            the value for bid.investperiod
	 *
	 * @ET
	 */
	public void setInvestperiod(String investperiod) {
		this.investperiod = investperiod;
	}

	/**
	 * This method:getRaiseperiod bid.raiseperiod
	 *
	 * @return the value of bid.raiseperiod
	 *
	 * @ET
	 */
	public String getRaiseperiod() {
		return raiseperiod;
	}

	/**
	 * This method:setRaiseperiod bid.raiseperiod
	 *
	 * @param raiseperiod
	 *            the value for bid.raiseperiod
	 *
	 * @ET
	 */
	public void setRaiseperiod(String raiseperiod) {
		this.raiseperiod = raiseperiod == null ? null : raiseperiod.trim();
	}

	/**
	 * This method:getRaisebegindate bid.raisebegindate
	 *
	 * @return the value of bid.raisebegindate
	 *
	 * @ET
	 */
	public String getRaisebegindate() {
		return raisebegindate;
	}

	/**
	 * This method:setRaisebegindate bid.raisebegindate
	 *
	 * @param raisebegindate
	 *            the value for bid.raisebegindate
	 *
	 * @ET
	 */
	public void setRaisebegindate(String raisebegindate) {
		this.raisebegindate = raisebegindate;
	}

	/**
	 * This method:getRaiseenddate bid.raiseenddate
	 *
	 * @return the value of bid.raiseenddate
	 *
	 * @ET
	 */
	public String getRaiseenddate() {
		return raiseenddate;
	}

	/**
	 * This method:setRaiseenddate bid.raiseenddate
	 *
	 * @param raiseenddate
	 *            the value for bid.raiseenddate
	 *
	 * @ET
	 */
	public void setRaiseenddate(String raiseenddate) {
		this.raiseenddate = raiseenddate;
	}

	/**
	 * This method:getExptinterestdate bid.exptinterestdate
	 *
	 * @return the value of bid.exptinterestdate
	 *
	 * @ET
	 */
	public String getExptinterestdate() {
		return exptinterestdate;
	}

	/**
	 * This method:setExptinterestdate bid.exptinterestdate
	 *
	 * @param exptinterestdate
	 *            the value for bid.exptinterestdate
	 *
	 * @ET
	 */
	public void setExptinterestdate(String exptinterestdate) {
		this.exptinterestdate = exptinterestdate;
	}

	/**
	 * This method:getExptexpiredate bid.exptexpiredate
	 *
	 * @return the value of bid.exptexpiredate
	 *
	 * @ET
	 */
	public String getExptexpiredate() {
		return exptexpiredate;
	}

	/**
	 * This method:setExptexpiredate bid.exptexpiredate
	 *
	 * @param exptexpiredate
	 *            the value for bid.exptexpiredate
	 *
	 * @ET
	 */
	public void setExptexpiredate(String exptexpiredate) {
		this.exptexpiredate = exptexpiredate;
	}

	/**
	 * This method:getAnnualizedrate bid.annualizedrate
	 *
	 * @return the value of bid.annualizedrate
	 *
	 * @ET
	 */
	public String getAnnualizedrate() {
		return annualizedrate;
	}

	/**
	 * This method:setAnnualizedrate bid.annualizedrate
	 *
	 * @param annualizedrate
	 *            the value for bid.annualizedrate
	 *
	 * @ET
	 */
	public void setAnnualizedrate(String annualizedrate) {
		this.annualizedrate = annualizedrate;
	}

	/**
	 * This method:getIntestcalctypeid bid.intestcalctypeid
	 *
	 * @return the value of bid.intestcalctypeid
	 *
	 * @ET
	 */
	public String getIntestcalctypeid() {
		return intestcalctypeid;
	}

	/**
	 * This method:setIntestcalctypeid bid.intestcalctypeid
	 *
	 * @param intestcalctypeid
	 *            the value for bid.intestcalctypeid
	 *
	 * @ET
	 */
	public void setIntestcalctypeid(String intestcalctypeid) {
		this.intestcalctypeid = intestcalctypeid;
	}

	/**
	 * This method:getIntestcalctype bid.intestcalctype
	 *
	 * @return the value of bid.intestcalctype
	 *
	 * @ET
	 */
	public String getIntestcalctype() {
		return intestcalctype;
	}

	/**
	 * This method:setIntestcalctype bid.intestcalctype
	 *
	 * @param intestcalctype
	 *            the value for bid.intestcalctype
	 *
	 * @ET
	 */
	public void setIntestcalctype(String intestcalctype) {
		this.intestcalctype = intestcalctype == null ? null : intestcalctype
				.trim();
	}

	/**
	 * This method:getExptlastacctdate bid.exptlastacctdate
	 *
	 * @return the value of bid.exptlastacctdate
	 *
	 * @ET
	 */
	public String getExptlastacctdate() {
		return exptlastacctdate;
	}

	/**
	 * This method:setExptlastacctdate bid.exptlastacctdate
	 *
	 * @param exptlastacctdate
	 *            the value for bid.exptlastacctdate
	 *
	 * @ET
	 */
	public void setExptlastacctdate(String exptlastacctdate) {
		this.exptlastacctdate = exptlastacctdate;
	}

	/**
	 * This method:getMininvestamount bid.mininvestamount
	 *
	 * @return the value of bid.mininvestamount
	 *
	 * @ET
	 */
	public String getMininvestamount() {
		return mininvestamount;
	}

	/**
	 * This method:setMininvestamount bid.mininvestamount
	 *
	 * @param mininvestamount
	 *            the value for bid.mininvestamount
	 *
	 * @ET
	 */
	public void setMininvestamount(String mininvestamount) {
		this.mininvestamount = mininvestamount;
	}

	/**
	 * This method:getMaxinvestamount bid.maxinvestamount
	 *
	 * @return the value of bid.maxinvestamount
	 *
	 * @ET
	 */
	public String getMaxinvestamount() {
		return maxinvestamount;
	}

	/**
	 * This method:setMaxinvestamount bid.maxinvestamount
	 *
	 * @param maxinvestamount
	 *            the value for bid.maxinvestamount
	 *
	 * @ET
	 */
	public void setMaxinvestamount(String maxinvestamount) {
		this.maxinvestamount = maxinvestamount;
	}

	/**
	 * This method:getIfredeem bid.ifredeem
	 *
	 * @return the value of bid.ifredeem
	 *
	 * @ET
	 */
	public String getIfredeem() {
		return ifredeem;
	}

	/**
	 * This method:setIfredeem bid.ifredeem
	 *
	 * @param ifredeem
	 *            the value for bid.ifredeem
	 *
	 * @ET
	 */
	public void setIfredeem(String ifredeem) {
		this.ifredeem = ifredeem;
	}

	/**
	 * This method:getRedeemfeetype bid.redeemfeetype
	 *
	 * @return the value of bid.redeemfeetype
	 *
	 * @ET
	 */
	public String getRedeemfeetype() {
		return redeemfeetype;
	}

	/**
	 * This method:setRedeemfeetype bid.redeemfeetype
	 *
	 * @param redeemfeetype
	 *            the value for bid.redeemfeetype
	 *
	 * @ET
	 */
	public void setRedeemfeetype(String redeemfeetype) {
		this.redeemfeetype = redeemfeetype;
	}

	/**
	 * This method:getRedeemfee bid.redeemfee
	 *
	 * @return the value of bid.redeemfee
	 *
	 * @ET
	 */
	public String getRedeemfee() {
		return redeemfee;
	}

	/**
	 * This method:setRedeemfee bid.redeemfee
	 *
	 * @param redeemfee
	 *            the value for bid.redeemfee
	 *
	 * @ET
	 */
	public void setRedeemfee(String redeemfee) {
		this.redeemfee = redeemfee;
	}

	/**
	 * This method:getIftransfer bid.iftransfer
	 *
	 * @return the value of bid.iftransfer
	 *
	 * @ET
	 */
	public String getIftransfer() {
		return iftransfer;
	}

	/**
	 * This method:setIftransfer bid.iftransfer
	 *
	 * @param iftransfer
	 *            the value for bid.iftransfer
	 *
	 * @ET
	 */
	public void setIftransfer(String iftransfer) {
		this.iftransfer = iftransfer;
	}

	/**
	 * This method:getTransfertype bid.transfertype
	 *
	 * @return the value of bid.transfertype
	 *
	 * @ET
	 */
	public String getTransfertype() {
		return transfertype;
	}

	/**
	 * This method:setTransfertype bid.transfertype
	 *
	 * @param transfertype
	 *            the value for bid.transfertype
	 *
	 * @ET
	 */
	public void setTransfertype(String transfertype) {
		this.transfertype = transfertype;
	}

	/**
	 * This method:getTransfee bid.transfee
	 *
	 * @return the value of bid.transfee
	 *
	 * @ET
	 */
	public String getTransfee() {
		return transfee;
	}

	/**
	 * This method:setTransfee bid.transfee
	 *
	 * @param transfee
	 *            the value for bid.transfee
	 *
	 * @ET
	 */
	public void setTransfee(String transfee) {
		this.transfee = transfee;
	}

	/**
	 * This method:getInstcode bid.instcode
	 *
	 * @return the value of bid.instcode
	 *
	 * @ET
	 */
	public String getInstcode() {
		return instcode;
	}

	/**
	 * This method:setInstcode bid.instcode
	 *
	 * @param instcode
	 *            the value for bid.instcode
	 *
	 * @ET
	 */
	public void setInstcode(String instcode) {
		this.instcode = instcode;
	}

	/**
	 * This method:getAssureinstname bid.assureinstname
	 *
	 * @return the value of bid.assureinstname
	 *
	 * @ET
	 */
	public String getAssureinstname() {
		return assureinstname;
	}

	/**
	 * This method:setAssureinstname bid.assureinstname
	 *
	 * @param assureinstname
	 *            the value for bid.assureinstname
	 *
	 * @ET
	 */
	public void setAssureinstname(String assureinstname) {
		this.assureinstname = assureinstname == null ? null : assureinstname
				.trim();
	}

	/**
	 * This method:getEnsuretype bid.ensuretype
	 *
	 * @return the value of bid.ensuretype
	 *
	 * @ET
	 */
	public String getEnsuretype() {
		return ensuretype;
	}

	/**
	 * This method:setEnsuretype bid.ensuretype
	 *
	 * @param ensuretype
	 *            the value for bid.ensuretype
	 *
	 * @ET
	 */
	public void setEnsuretype(String ensuretype) {
		this.ensuretype = ensuretype;
	}

	/**
	 * This method:getAgreement1 bid.agreement1
	 *
	 * @return the value of bid.agreement1
	 *
	 * @ET
	 */
	public String getAgreement1() {
		return agreement1;
	}

	/**
	 * This method:setAgreement1 bid.agreement1
	 *
	 * @param agreement1
	 *            the value for bid.agreement1
	 *
	 * @ET
	 */
	public void setAgreement1(String agreement1) {
		this.agreement1 = agreement1;
	}

	/**
	 * This method:getAgreement2 bid.agreement2
	 *
	 * @return the value of bid.agreement2
	 *
	 * @ET
	 */
	public String getAgreement2() {
		return agreement2;
	}

	/**
	 * This method:setAgreement2 bid.agreement2
	 *
	 * @param agreement2
	 *            the value for bid.agreement2
	 *
	 * @ET
	 */
	public void setAgreement2(String agreement2) {
		this.agreement2 = agreement2;
	}

	/**
	 * This method:getAgreement3 bid.agreement3
	 *
	 * @return the value of bid.agreement3
	 *
	 * @ET
	 */
	public String getAgreement3() {
		return agreement3;
	}

	/**
	 * This method:setAgreement3 bid.agreement3
	 *
	 * @param agreement3
	 *            the value for bid.agreement3
	 *
	 * @ET
	 */
	public void setAgreement3(String agreement3) {
		this.agreement3 = agreement3;
	}

	/**
	 * This method:getRaisemoney bid.raisemoney
	 *
	 * @return the value of bid.raisemoney
	 *
	 * @ET
	 */
	public String getRaisemoney() {
		return raisemoney;
	}

	/**
	 * This method:setRaisemoney bid.raisemoney
	 *
	 * @param raisemoney
	 *            the value for bid.raisemoney
	 *
	 * @ET
	 */
	public void setRaisemoney(String raisemoney) {
		this.raisemoney = raisemoney;
	}

	/**
	 * This method:getRaisestate bid.raisestate
	 *
	 * @return the value of bid.raisestate
	 *
	 * @ET
	 */
	public String getRaisestate() {
		return raisestate;
	}

	/**
	 * This method:setRaisestate bid.raisestate
	 *
	 * @param raisestate
	 *            the value for bid.raisestate
	 *
	 * @ET
	 */
	public void setRaisestate(String raisestate) {
		this.raisestate = raisestate;
	}

	/**
	 * This method:getBidstatus bid.bidstatus
	 *
	 * @return the value of bid.bidstatus
	 *
	 * @ET
	 */
	public String getBidstatus() {
		return bidstatus;
	}

	/**
	 * This method:setBidstatus bid.bidstatus
	 *
	 * @param bidstatus
	 *            the value for bid.bidstatus
	 *
	 * @ET
	 */
	public void setBidstatus(String bidstatus) {
		this.bidstatus = bidstatus;
	}

	/**
	 * This method:getBidcode bid.BidCode
	 *
	 * @return the value of bid.BidCode
	 *
	 * @ET
	 */
	public String getBidcode() {
		return bidcode;
	}

	/**
	 * This method:setBidcode bid.BidCode
	 *
	 * @param bidcode
	 *            the value for bid.BidCode
	 *
	 * @ET
	 */
	public void setBidcode(String bidcode) {
		this.bidcode = bidcode == null ? null : bidcode.trim();
	}

	/**
	 * This method:getRepaymentway bid.repaymentway
	 *
	 * @return the value of bid.repaymentway
	 *
	 * @ET
	 */
	public String getRepaymentway() {
		return repaymentway;
	}

	/**
	 * This method:setRepaymentway bid.repaymentway
	 *
	 * @param repaymentway
	 *            the value for bid.repaymentway
	 *
	 * @ET
	 */
	public void setRepaymentway(String repaymentway) {
		this.repaymentway = repaymentway == null ? null : repaymentway.trim();
	}

	/**
	 * This method:getBindinnerno bid.bindinnerno
	 *
	 * @return the value of bid.bindinnerno
	 *
	 * @ET
	 */
	public String getBindinnerno() {
		return bindinnerno;
	}

	/**
	 * This method:setBindinnerno bid.bindinnerno
	 *
	 * @param bindinnerno
	 *            the value for bid.bindinnerno
	 *
	 * @ET
	 */
	public void setBindinnerno(String bindinnerno) {
		this.bindinnerno = bindinnerno == null ? null : bindinnerno.trim();
	}

	/**
	 * This method:getBidclassintro bid.bidclassintro
	 *
	 * @return the value of bid.bidclassintro
	 *
	 * @ET
	 */
	public String getBidclassintro() {
		return bidclassintro;
	}

	/**
	 * This method:setBidclassintro bid.bidclassintro
	 *
	 * @param bidclassintro
	 *            the value for bid.bidclassintro
	 *
	 * @ET
	 */
	public void setBidclassintro(String bidclassintro) {
		this.bidclassintro = bidclassintro == null ? null : bidclassintro
				.trim();
	}

	/**
	 * This method:getInvestscope bid.investscope
	 *
	 * @return the value of bid.investscope
	 *
	 * @ET
	 */
	public String getInvestscope() {
		return investscope;
	}

	/**
	 * This method:setInvestscope bid.investscope
	 *
	 * @param investscope
	 *            the value for bid.investscope
	 *
	 * @ET
	 */
	public void setInvestscope(String investscope) {
		this.investscope = investscope == null ? null : investscope.trim();
	}

	/**
	 * This method:getIncomedesc bid.incomedesc
	 *
	 * @return the value of bid.incomedesc
	 *
	 * @ET
	 */
	public String getIncomedesc() {
		return incomedesc;
	}

	/**
	 * This method:setIncomedesc bid.incomedesc
	 *
	 * @param incomedesc
	 *            the value for bid.incomedesc
	 *
	 * @ET
	 */
	public void setIncomedesc(String incomedesc) {
		this.incomedesc = incomedesc == null ? null : incomedesc.trim();
	}

	/**
	 * This method:getIncomeway bid.incomeway
	 *
	 * @return the value of bid.incomeway
	 *
	 * @ET
	 */
	public String getIncomeway() {
		return incomeway;
	}

	/**
	 * This method:setIncomeway bid.incomeway
	 *
	 * @param incomeway
	 *            the value for bid.incomeway
	 *
	 * @ET
	 */
	public void setIncomeway(String incomeway) {
		this.incomeway = incomeway;
	}

	/**
	 * This method:getRaisecond bid.raisecond
	 *
	 * @return the value of bid.raisecond
	 *
	 * @ET
	 */
	public String getRaisecond() {
		return raisecond;
	}

	/**
	 * This method:setRaisecond bid.raisecond
	 *
	 * @param raisecond
	 *            the value for bid.raisecond
	 *
	 * @ET
	 */
	public void setRaisecond(String raisecond) {
		this.raisecond = raisecond == null ? null : raisecond.trim();
	}

	/**
	 * This method:getRedeemway bid.redeemway
	 *
	 * @return the value of bid.redeemway
	 *
	 * @ET
	 */
	public String getRedeemway() {
		return redeemway;
	}

	/**
	 * This method:setRedeemway bid.redeemway
	 *
	 * @param redeemway
	 *            the value for bid.redeemway
	 *
	 * @ET
	 */
	public void setRedeemway(String redeemway) {
		this.redeemway = redeemway == null ? null : redeemway.trim();
	}

	/**
	 * This method:getRaiserate bid.raiserate
	 *
	 * @return the value of bid.raiserate
	 *
	 * @ET
	 */
	public String getRaiserate() {
		return raiserate;
	}

	/**
	 * This method:setRaiserate bid.raiserate
	 *
	 * @param raiserate
	 *            the value for bid.raiserate
	 *
	 * @ET
	 */
	public void setRaiserate(String raiserate) {
		this.raiserate = raiserate;
	}

	/**
	 * This method:getRedemrate bid.redemrate
	 *
	 * @return the value of bid.redemrate
	 *
	 * @ET
	 */
	public String getRedemrate() {
		return redemrate;
	}

	/**
	 * This method:setRedemrate bid.redemrate
	 *
	 * @param redemrate
	 *            the value for bid.redemrate
	 *
	 * @ET
	 */
	public void setRedemrate(String redemrate) {
		this.redemrate = redemrate;
	}

	/**
	 * This method:getTransrate bid.transrate
	 *
	 * @return the value of bid.transrate
	 *
	 * @ET
	 */
	public String getTransrate() {
		return transrate;
	}

	/**
	 * This method:setTransrate bid.transrate
	 *
	 * @param transrate
	 *            the value for bid.transrate
	 *
	 * @ET
	 */
	public void setTransrate(String transrate) {
		this.transrate = transrate;
	}

	/**
	 * This method:getPrepayrate bid.prepayrate
	 *
	 * @return the value of bid.prepayrate
	 *
	 * @ET
	 */
	public String getPrepayrate() {
		return prepayrate;
	}

	/**
	 * This method:setPrepayrate bid.prepayrate
	 *
	 * @param prepayrate
	 *            the value for bid.prepayrate
	 *
	 * @ET
	 */
	public void setPrepayrate(String prepayrate) {
		this.prepayrate = prepayrate;
	}

	/**
	 * This method:getReceiptdesc bid.receiptdesc
	 *
	 * @return the value of bid.receiptdesc
	 *
	 * @ET
	 */
	public String getReceiptdesc() {
		return receiptdesc;
	}

	/**
	 * This method:setReceiptdesc bid.receiptdesc
	 *
	 * @param receiptdesc
	 *            the value for bid.receiptdesc
	 *
	 * @ET
	 */
	public void setReceiptdesc(String receiptdesc) {
		this.receiptdesc = receiptdesc == null ? null : receiptdesc.trim();
	}

	/**
	 * This method:getBidnum bid.bidnum
	 *
	 * @return the value of bid.bidnum
	 *
	 * @ET
	 */
	public String getBidnum() {
		return bidnum;
	}

	/**
	 * This method:setBidnum bid.bidnum
	 *
	 * @param bidnum
	 *            the value for bid.bidnum
	 *
	 * @ET
	 */
	public void setBidnum(String bidnum) {
		this.bidnum = bidnum;
	}

	/**
	 * This method:getPubdate bid.pubdate
	 *
	 * @return the value of bid.pubdate
	 *
	 * @ET
	 */
	public String getPubdate() {
		return pubdate;
	}

	/**
	 * This method:setPubdate bid.pubdate
	 *
	 * @param pubdate
	 *            the value for bid.pubdate
	 *
	 * @ET
	 */
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	/**
	 * This method:getMemberid bid.memberid
	 *
	 * @return the value of bid.memberid
	 *
	 * @ET
	 */
	public String getMemberid() {
		return memberid;
	}

	/**
	 * This method:setMemberid bid.memberid
	 *
	 * @param memberid
	 *            the value for bid.memberid
	 *
	 * @ET
	 */
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	/**
	 * This method:getMembername bid.membername
	 *
	 * @return the value of bid.membername
	 *
	 * @ET
	 */
	public String getMembername() {
		return membername;
	}

	/**
	 * This method:setMembername bid.membername
	 *
	 * @param membername
	 *            the value for bid.membername
	 *
	 * @ET
	 */
	public void setMembername(String membername) {
		this.membername = membername == null ? null : membername.trim();
	}

	/**
	 * This method:getRiskmgrfee bid.riskmgrfee
	 *
	 * @return the value of bid.riskmgrfee
	 *
	 * @ET
	 */
	public String getRiskmgrfee() {
		return riskmgrfee;
	}

	/**
	 * This method:setRiskmgrfee bid.riskmgrfee
	 *
	 * @param riskmgrfee
	 *            the value for bid.riskmgrfee
	 *
	 * @ET
	 */
	public void setRiskmgrfee(String riskmgrfee) {
		this.riskmgrfee = riskmgrfee;
	}

	/**
	 * This method:getYearservicefee bid.yearservicefee
	 *
	 * @return the value of bid.yearservicefee
	 *
	 * @ET
	 */
	public String getYearservicefee() {
		return yearservicefee;
	}

	/**
	 * This method:setYearservicefee bid.yearservicefee
	 *
	 * @param yearservicefee
	 *            the value for bid.yearservicefee
	 *
	 * @ET
	 */
	public void setYearservicefee(String yearservicefee) {
		this.yearservicefee = yearservicefee;
	}

	/**
	 * This method:getRemark bid.remark
	 *
	 * @return the value of bid.remark
	 *
	 * @ET
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method:setRemark bid.remark
	 *
	 * @param remark
	 *            the value for bid.remark
	 *
	 * @ET
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
	 public String getPledgetype() {
		return pledgetype;
	}

	public void setPledgetype(String pledgetype) {
		this.pledgetype = pledgetype;
	}

	public String getPledgetype1() {
		return pledgetype1;
	}

	public void setPledgetype1(String pledgetype1) {
		this.pledgetype1 = pledgetype1;
	}

	/**
     * 字段名称: 项目编号 .
     * 字段定义: bid.projectCode
     *
     * @ET
     */
    private String projectcode;

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}
	
	/**
     * This method:getLockupperiod
     * bid.lockupperiod
     *
     * @return the value of bid.lockupperiod
     *
     * @ET
     */
    public Integer getLockupperiod() {
        return lockupperiod;
    }

    /**
     * This method:setLockupperiod
     *  bid.lockupperiod
     *
     * @param lockupperiod the value for bid.lockupperiod
     *
     * @ET
     */
    public void setLockupperiod(Integer lockupperiod) {
        this.lockupperiod = lockupperiod;
    }
    
    /**
     * This method:getProjectfeature
     * bid.projectfeature
     *
     * @return the value of bid.projectfeature
     *
     * @ET
     */
    public String getProjectfeature() {
        return projectfeature;
    }

    /**
     * This method:setProjectfeature
     *  bid.projectfeature
     *
     * @param projectfeature the value for bid.projectfeature
     *
     * @ET
     */
    public void setProjectfeature(String projectfeature) {
        this.projectfeature = projectfeature == null ? null : projectfeature.trim();
    }
    
    /**
     * This method:getBorrowerinterest
     * bid.borrowerinterest
     *
     * @return the value of bid.borrowerinterest
     *
     * @ET
     */
    public String getBorrowerinterest() {
        return borrowerinterest;
    }

    /**
     * This method:setBorrowerinterest
     *  bid.borrowerinterest
     *
     * @param borrowerinterest the value for bid.borrowerinterest
     *
     * @ET
     */
    public void setBorrowerinterest(String borrowerinterest) {
        this.borrowerinterest = borrowerinterest;
    }

	public String getIfvirtual() {
		return ifvirtual;
	}

	public void setIfvirtual(String ifvirtual) {
		this.ifvirtual = ifvirtual;
	}
    
    
}