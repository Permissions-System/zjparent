package com.zjgt.p2p.report.model;

import java.io.Serializable;

public class LoginUserStatistical implements Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = -1629543835276673699L;
	
	/**
	 * 登陆用户ID
	 */
	private String userId;
	/**
	 * 登陆用户名
	 */
	private String userName;
	/**
	 * 登陆时间
	 */
	private String loginDate;
	/**
	 * 注册时间
	 */
	private String registerDate;
	
	/**
	 * 注册至今登录次数
	 */
	private Integer logintime;
	/**
	 * 是否已经开户
	 */
	private Integer notOpenAct;
	/**
	 * 是否有过成功充值
	 */
	private Integer notRechargePeople;
	/**
	 * 是否有过成功投资
	 */
	private Integer notInvestmentPeople;
	/**
	 * 是否有过成功转让
	 */
	private Integer notTheTransfer;
	/**
	 * 是否有过成功提取
	 */
	private Integer notPlatformWithdrawPer;
	/**
	 * 是否投过体验标
	 */
	private Integer notExperience;
	/**
	 * 是否领取过中金币
	 */
	private Integer notZJB;
	
	/**
	 * 登录人数
	 */
	private Integer logincnt;
	/**
	 * 开户人数
	 */
	private Integer openNumber;
	/**
	 * 成功充值人数
	 */
	private Integer rechargePeopleNumber;
	/**
	 * 成功投资人数
	 */
	private Integer investmentPeopleNumber;
	/**
	 * 成功转让人数
	 */
	private Integer theTransferNumber;
	/**
	 * 成功提现人数
	 */
	private Integer platformWithdrawPerNumber;
	/**
	 * 投过体验标人数
	 */
	private Integer experienceNumber;
	/**
	 * 领过中金币人数
	 */
	private Integer zjbNumber;
	
	private String beginTime;
	private String endTime;
	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public Integer getLogintime() {
		return logintime;
	}
	public void setLogintime(Integer logintime) {
		this.logintime = logintime;
	}
	public Integer getNotOpenAct() {
		return notOpenAct;
	}
	public void setNotOpenAct(Integer notOpenAct) {
		this.notOpenAct = notOpenAct;
	}
	public Integer getNotRechargePeople() {
		return notRechargePeople;
	}
	public void setNotRechargePeople(Integer notRechargePeople) {
		this.notRechargePeople = notRechargePeople;
	}
	public Integer getNotInvestmentPeople() {
		return notInvestmentPeople;
	}
	public void setNotInvestmentPeople(Integer notInvestmentPeople) {
		this.notInvestmentPeople = notInvestmentPeople;
	}
	public Integer getNotTheTransfer() {
		return notTheTransfer;
	}
	public void setNotTheTransfer(Integer notTheTransfer) {
		this.notTheTransfer = notTheTransfer;
	}
	public Integer getNotPlatformWithdrawPer() {
		return notPlatformWithdrawPer;
	}
	public void setNotPlatformWithdrawPer(Integer notPlatformWithdrawPer) {
		this.notPlatformWithdrawPer = notPlatformWithdrawPer;
	}
	public Integer getNotExperience() {
		return notExperience;
	}
	public void setNotExperience(Integer notExperience) {
		this.notExperience = notExperience;
	}
	public Integer getNotZJB() {
		return notZJB;
	}
	public void setNotZJB(Integer notZJB) {
		this.notZJB = notZJB;
	}
	public Integer getLogincnt() {
		return logincnt;
	}
	public void setLogincnt(Integer logincnt) {
		this.logincnt = logincnt;
	}
	public Integer getOpenNumber() {
		return openNumber;
	}
	public void setOpenNumber(Integer openNumber) {
		this.openNumber = openNumber;
	}
	public Integer getRechargePeopleNumber() {
		return rechargePeopleNumber;
	}
	public void setRechargePeopleNumber(Integer rechargePeopleNumber) {
		this.rechargePeopleNumber = rechargePeopleNumber;
	}
	public Integer getInvestmentPeopleNumber() {
		return investmentPeopleNumber;
	}
	public void setInvestmentPeopleNumber(Integer investmentPeopleNumber) {
		this.investmentPeopleNumber = investmentPeopleNumber;
	}
	public Integer getTheTransferNumber() {
		return theTransferNumber;
	}
	public void setTheTransferNumber(Integer theTransferNumber) {
		this.theTransferNumber = theTransferNumber;
	}
	public Integer getPlatformWithdrawPerNumber() {
		return platformWithdrawPerNumber;
	}
	public void setPlatformWithdrawPerNumber(Integer platformWithdrawPerNumber) {
		this.platformWithdrawPerNumber = platformWithdrawPerNumber;
	}
	public Integer getExperienceNumber() {
		return experienceNumber;
	}
	public void setExperienceNumber(Integer experienceNumber) {
		this.experienceNumber = experienceNumber;
	}
	public Integer getZjbNumber() {
		return zjbNumber;
	}
	public void setZjbNumber(Integer zjbNumber) {
		this.zjbNumber = zjbNumber;
	}
	
	
}
