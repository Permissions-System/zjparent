package com.zjgt.p2p.manage.excel;

import java.math.BigDecimal;

public class MemberModel {
    
	/**
     * 字段名称: 序号
     */
	private Integer num;
	
	/**
     * 字段名称: 邮箱
     */
    private String email;
	
    /**
     * 字段名称: 用户姓名
     */
    private String realname;
    
    /**
     * 字段名称: 手机号
     */
    private String mobile;

    /**
     * 字段名称: 状态
     */
    private String userstatus;

    /**
     * 字段名称: 注册时间
     */
    private String createDate;

    /**
     * 字段名称: 最后登录时间
     */
    private String loginDate;

    /**
     * 字段名称: 用户来源
     */
    private String regSource;

    /**
     * 字段名称: 账户总额
     */
    private BigDecimal totalAccount;

    /**
     * 字段名称: 提现总额
     */
    private BigDecimal withdrawTotal;

    /**
     * 字段名称: 收益总额
     */
    private BigDecimal yesterdayIncome;

    /**
     * 字段名称: 待收本金总额
     */
    private BigDecimal collectionPrincipal;

    /**
     * 字段名称: 待收利息总额
     */
    private BigDecimal collectionInterest;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getRegSource() {
		return regSource;
	}

	public void setRegSource(String regSource) {
		this.regSource = regSource;
	}

	public BigDecimal getTotalAccount() {
		return totalAccount;
	}

	public void setTotalAccount(BigDecimal totalAccount) {
		this.totalAccount = totalAccount;
	}

	public BigDecimal getWithdrawTotal() {
		return withdrawTotal;
	}

	public void setWithdrawTotal(BigDecimal withdrawTotal) {
		this.withdrawTotal = withdrawTotal;
	}

	public BigDecimal getYesterdayIncome() {
		return yesterdayIncome;
	}

	public void setYesterdayIncome(BigDecimal yesterdayIncome) {
		this.yesterdayIncome = yesterdayIncome;
	}

	public BigDecimal getCollectionPrincipal() {
		return collectionPrincipal;
	}

	public void setCollectionPrincipal(BigDecimal collectionPrincipal) {
		this.collectionPrincipal = collectionPrincipal;
	}

	public BigDecimal getCollectionInterest() {
		return collectionInterest;
	}

	public void setCollectionInterest(BigDecimal collectionInterest) {
		this.collectionInterest = collectionInterest;
	}
	
}