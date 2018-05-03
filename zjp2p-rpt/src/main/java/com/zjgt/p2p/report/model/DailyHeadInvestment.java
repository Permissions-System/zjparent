package com.zjgt.p2p.report.model;

public class DailyHeadInvestment {
	
	
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 首次投资金额
	 */
	private String lendmoney;
	/**
	 * 首次投资时间
	 */
	private String lenddate;
	/**
	 * 推荐人
	 */
	private String recommPerson;
	
	private String beginTime;
	private String endTime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLendmoney() {
		return lendmoney;
	}
	public void setLendmoney(String lendmoney) {
		this.lendmoney = lendmoney;
	}
	public String getLenddate() {
		return lenddate;
	}
	public void setLenddate(String lenddate) {
		this.lenddate = lenddate;
	}
	public String getRecommPerson() {
		return recommPerson;
	}
	public void setRecommPerson(String recommPerson) {
		this.recommPerson = recommPerson;
	}
	public String getBeginTime()
	{
		return beginTime;
	}
	public void setBeginTime(String beginTime)
	{
		this.beginTime = beginTime;
	}
	public String getEndTime()
	{
		return endTime;
	}
	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}

}
