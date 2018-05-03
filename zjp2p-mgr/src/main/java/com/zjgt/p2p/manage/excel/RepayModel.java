package com.zjgt.p2p.manage.excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @FileName:RepayModel.java
 * @Function:TODO
 * @date:2015年3月2日 上午9:31:19
 * @author zhouyi
 * @since jdk1.7
 */
public class RepayModel {
 
    private Date repayDate;  
    private String bidtype;
    private BigDecimal amount;
    private BigDecimal income;
    private BigDecimal platIncome;
    
	public RepayModel() {
	}

	public RepayModel(Date repayDate, String bidtype, BigDecimal amount,
			BigDecimal income, BigDecimal platIncome) {
		super();
		this.repayDate = repayDate;
		this.bidtype = bidtype;
		this.amount = amount;
		this.income = income;
		this.platIncome = platIncome;
	}

	public Date getRepayDate() {
		return repayDate;
	}

	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
	}

	public String getBidtype() {
		return bidtype;
	}

	public void setBidtype(String bidtype) {
		this.bidtype = bidtype;
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

	public BigDecimal getPlatIncome() {
		return platIncome;
	}

	public void setPlatIncome(BigDecimal platIncome) {
		this.platIncome = platIncome;
	}

	
}