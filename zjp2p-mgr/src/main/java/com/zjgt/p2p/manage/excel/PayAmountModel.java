package com.zjgt.p2p.manage.excel;

import java.math.BigDecimal;
import java.util.Date;

public class PayAmountModel {
    
	private Integer num;

    private String exptinterestdate;
	
    /**
     * 字段名称: 标的编号 .
     * 字段定义: bid.BidCode
     *
     * @ET
     */
    private String bidcode;
    
    /**
     * 字段名称: 标的分类名称(月存宝,月息宝,新手标)
 .
     * 字段定义: bid.bidclassname
     *
     * @ET
     */
    private String bidclassname;

    /**
     * 字段名称: 标的类型 .
     * 字段定义: bid.bidtype
     *
     * @ET
     */
    private String bidtype;

    /**
     * 字段名称: 借款人名称 .
     * 字段定义: bid.borrowername
     *
     * @ET
     */
    private String borrowername;
    
    /**
     * 字段名称: 年服务费 .
     * 字段定义: bid.yearservicefee
     *
     * @ET
     */
    private BigDecimal yearservicefee;

    /**
     * 字段名称: 发行费用 .
     * 字段定义: bid.pubfee
     *
     * @ET
     */
    private BigDecimal pubfee;
    
    /**
     * 字段名称: 风险管理费 .
     * 字段定义: bid.riskmgrfee
     *
     * @ET
     */
    private BigDecimal riskmgrfee;
    
    /**
     * 字段名称: 付款给借款人 0-未付 2-完成付款 .
     * 字段定义: bid.borrowstatus
     *
     * @ET
     */
    private String borrowstatus;
    
    private BigDecimal amount;
    
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getExptinterestdate() {
		return exptinterestdate;
	}

	public void setExptinterestdate(String exptinterestdate) {
		this.exptinterestdate = exptinterestdate;
	}

	public String getBidcode() {
		return bidcode;
	}

	public void setBidcode(String bidcode) {
		this.bidcode = bidcode;
	}

	public String getBidclassname() {
		return bidclassname;
	}

	public void setBidclassname(String bidclassname) {
		this.bidclassname = bidclassname;
	}

	public String getBidtype() {
		return bidtype;
	}

	public void setBidtype(String bidtype) {
		this.bidtype = bidtype;
	}

	public String getBorrowername() {
		return borrowername;
	}

	public void setBorrowername(String borrowername) {
		this.borrowername = borrowername;
	}

	public BigDecimal getYearservicefee() {
		return yearservicefee;
	}

	public void setYearservicefee(BigDecimal yearservicefee) {
		this.yearservicefee = yearservicefee;
	}

	public BigDecimal getPubfee() {
		return pubfee;
	}

	public void setPubfee(BigDecimal pubfee) {
		this.pubfee = pubfee;
	}

	public BigDecimal getRiskmgrfee() {
		return riskmgrfee;
	}

	public void setRiskmgrfee(BigDecimal riskmgrfee) {
		this.riskmgrfee = riskmgrfee;
	}

	public String getBorrowstatus() {
		return borrowstatus;
	}

	public void setBorrowstatus(String borrowstatus) {
		this.borrowstatus = borrowstatus;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public PayAmountModel(Integer num,String exptinterestdate, String bidcode,String bidclassname,String bidtype,String borrowername,BigDecimal yearservicefee,BigDecimal pubfee,BigDecimal riskmgrfee,String borrowstatus,BigDecimal amount){
		this.num = num;
		this.exptinterestdate = exptinterestdate;
		this.bidcode = bidcode;
		this.bidclassname = bidclassname;
		this.bidtype = bidtype;
		this.borrowername = borrowername;
		this.yearservicefee = yearservicefee;
		this.pubfee = pubfee;
		this.riskmgrfee = riskmgrfee;
		this.borrowstatus = borrowstatus;
		this.amount = amount;
	}
}