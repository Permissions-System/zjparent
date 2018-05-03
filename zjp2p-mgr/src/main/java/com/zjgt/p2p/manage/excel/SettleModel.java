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
public class SettleModel {

    private int count;  
    private String id;  
    private Date transtime;  
    private String transdesc;
    private String payerId; 
    private String payername;
    private BigDecimal paysubamount;
    private String payeeId;
    private String payeename;
    private BigDecimal payeesubamount;
    private String amount;
    private BigDecimal platavailamount;
    
	public SettleModel(int count, String id, Date transtime,String transdesc,
			String payerId, String payername, BigDecimal paysubamount,String payeeId,
			String payeename,BigDecimal payeesubamount, String amount, BigDecimal platavailamount) {
		super();
		this.count = count;
		this.id = id;
		this.transtime = transtime;
		if(transdesc==null){
			transdesc="";
		}
		this.transdesc = transdesc;
		this.payerId = payerId;
		if(payername==null){
			payername="";
		}
		this.payername = payername;
		this.paysubamount = paysubamount;
		this.payeeId = payeeId;
		if(payeename==null){
			payeename="";
		}
		this.payeename = payeename;
		this.payeesubamount = payeesubamount;
		this.amount = amount;
		this.platavailamount = platavailamount;
	}
	
	
	
	public BigDecimal getPaysubamount() {
		return paysubamount;
	}



	public void setPaysubamount(BigDecimal paysubamount) {
		this.paysubamount = paysubamount;
	}



	public BigDecimal getPayeesubamount() {
		return payeesubamount;
	}



	public void setPayeesubamount(BigDecimal payeesubamount) {
		this.payeesubamount = payeesubamount;
	}



	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTranstime() {
		return transtime;
	}
	public void setTranstime(Date transtime) {
		this.transtime = transtime;
	}
	public String getTransdesc() {
		if(transdesc==null){
			transdesc="";
		}
		return transdesc;
	}
	public void setTransdesc(String transdesc) {
		this.transdesc = transdesc;
	}
	public String getPayerId() {
		return payerId;
	}
	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}
	public String getPayername() {
		if(payername==null){
			payername="";
		}
		return payername;
	}
	public void setPayername(String payername) {
		this.payername = payername;
	}
	public String getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}
	public String getPayeename() {
		if(payeename==null){
			payeename="";
		}
		return payeename;
	}
	public void setPayeename(String payeename) {
		this.payeename = payeename;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public BigDecimal getPlatavailamount() {
		return platavailamount;
	}
	public void setPlatavailamount(BigDecimal platavailamount) {
		this.platavailamount = platavailamount;
	}
    
    
}