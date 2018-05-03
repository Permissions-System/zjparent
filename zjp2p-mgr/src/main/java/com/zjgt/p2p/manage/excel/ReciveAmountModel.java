package com.zjgt.p2p.manage.excel;

import java.math.BigDecimal;

public class ReciveAmountModel {
    
	private Integer num;

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
    
    private String exptinterestdate;
    
    private String exptlastacctdate;
    
    private BigDecimal amount;
    
    private BigDecimal income;
    
    private BigDecimal overduefee;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
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

	public String getExptinterestdate() {
		return exptinterestdate;
	}

	public void setExptinterestdate(String exptinterestdate) {
		this.exptinterestdate = exptinterestdate;
	}

	public String getExptlastacctdate() {
		return exptlastacctdate;
	}

	public void setExptlastacctdate(String exptlastacctdate) {
		this.exptlastacctdate = exptlastacctdate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public BigDecimal getOverduefee() {
		return overduefee;
	}

	public void setOverduefee(BigDecimal overduefee) {
		this.overduefee = overduefee;
	}

	public ReciveAmountModel(Integer num, String bidcode,String bidclassname,String bidtype,String borrowername,String exptinterestdate, String exptlastacctdate, BigDecimal amount,BigDecimal income,BigDecimal overduefee){
		this.num = num;
		this.bidcode = bidcode;
		this.bidclassname = bidclassname;
		this.bidtype = bidtype;
		this.borrowername = borrowername;
		this.exptinterestdate = exptinterestdate;
		this.exptlastacctdate = exptlastacctdate;
		this.amount = amount;
		this.income = income;
		this.overduefee = overduefee;
	}
}