package com.zjgt.p2p.manage.excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @FileName:RechargeModel.java
 * @Function:TODO
 * @date:2015年5月13日 下午7:12:16
 * @author zhouyi
 * @since jdk1.7
 */
public class RechargeModel {

    private Date rechargeDate;  
    private BigDecimal amount;
    private String fees;
    private BigDecimal availAmount;
    private String  thirdpay;
    private String transNo;
    private String realname;
    private String channel;
    
	public RechargeModel() {
		super();
	}


	public RechargeModel(Date rechargeDate, BigDecimal amount, String fees,
			BigDecimal availAmount, String thirdpay, String transNo,
			String realname, String channel) {
		super();
		this.rechargeDate = rechargeDate;
		this.amount = amount;
		this.fees = fees;
		this.availAmount = availAmount;
		this.thirdpay = thirdpay;
		this.transNo = transNo;
		this.realname = realname;
		this.channel = channel;
	}


	public Date getRechargeDate() {
		return rechargeDate;
	}

	public void setRechargeDate(Date rechargeDate) {
		this.rechargeDate = rechargeDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public BigDecimal getAvailAmount() {
		return availAmount;
	}

	public void setAvailAmount(BigDecimal availAmount) {
		this.availAmount = availAmount;
	}

	public String getThirdpay() {
		return thirdpay;
	}

	public void setThirdpay(String thirdpay) {
		this.thirdpay = thirdpay;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}


	public String getChannel() {
		return channel;
	}


	public void setChannel(String channel) {
		this.channel = channel;
	}


}
