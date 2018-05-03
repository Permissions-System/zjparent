package com.zjgt.p2p.report.model;

import java.io.Serializable;


public class AfterVotingInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3794915787243234162L;
	
	/**
	 * 投资次数
	 */
	private String next;
	/**
	 * 投资金额
	 */
	private double sumAmt;
	/**
	 * 金额占比
	 */
	private String amtPercentage;
	
	/**
	 * 投资人数
	 */
	private double countNumber;
	
	/**
	 * 人数占比
	 */
	private String numberPercentage;
	
	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public double getSumAmt() {
		return sumAmt;
	}

	public void setSumAmt(double sumAmt) {
		this.sumAmt = sumAmt;
	}

	public double getCountNumber() {
		return countNumber;
	}

	public void setCountNumber(double countNumber) {
		this.countNumber = countNumber;
	}

	public String getAmtPercentage() {
		return amtPercentage;
	}

	public void setAmtPercentage(String amtPercentage) {
		this.amtPercentage = amtPercentage;
	}

	public String getNumberPercentage() {
		return numberPercentage;
	}

	public void setNumberPercentage(String numberPercentage) {
		this.numberPercentage = numberPercentage;
	}
	

}
