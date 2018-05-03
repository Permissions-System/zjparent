package com.zjgt.p2p.manage.excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @FileName:SettleModel.java
 * @Function:TODO
 * @date:2015年3月2日 上午9:31:19
 * @author zhouyi
 * @since jdk1.7
 */
public class InvestOrderModel {
 
    private Date orderDate;  
    private String bidtype;
    private String membertype;
    private String investperiod;
    private BigDecimal amount;
    private BigDecimal bonusamount;
    private BigDecimal exptIncome;
    
	public InvestOrderModel() {
	}

	public InvestOrderModel(Date orderDate, String bidtype, String membertype,
			String investperiod, BigDecimal amount, BigDecimal bonusamount,
			BigDecimal exptIncome) {
		super();
		this.orderDate = orderDate;
		this.bidtype = bidtype;
		this.membertype = membertype;
		this.investperiod = investperiod;
		this.amount = amount;
		this.bonusamount = bonusamount;
		this.exptIncome = exptIncome;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getBidtype() {
		return bidtype;
	}

	public void setBidtype(String bidtype) {
		this.bidtype = bidtype;
	}

	public String getMembertype() {
		return membertype;
	}

	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}

	public String getInvestperiod() {
		return investperiod;
	}

	public void setInvestperiod(String investperiod) {
		this.investperiod = investperiod;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBonusamount() {
		return bonusamount;
	}

	public void setBonusamount(BigDecimal bonusamount) {
		this.bonusamount = bonusamount;
	}

	public BigDecimal getExptIncome() {
		return exptIncome;
	}

	public void setExptIncome(BigDecimal exptIncome) {
		this.exptIncome = exptIncome;
	}

	


}