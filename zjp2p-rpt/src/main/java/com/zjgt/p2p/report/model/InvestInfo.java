package com.zjgt.p2p.report.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class InvestInfo {
	/**
     * 字段名称:  .
     * 字段定义: investinfo.id
     *
     * @ET
     */
    private Integer id;

    /**
     * 字段名称: 编号 .
     * 字段定义: investinfo.lendId
     *
     * @ET
     */
    private Integer lendid;

    /**
     * 字段名称: 富有账号 .
     * 字段定义: investinfo.fuyouAccount
     *
     * @ET
     */
    private String fuyouaccount;

    /**
     * 字段名称: 投资人 .
     * 字段定义: investinfo.userName
     *
     * @ET
     */
    private String username;

    /**
     * 字段名称: 推广渠道码 .
     * 字段定义: investinfo.PromoCode
     *
     * @ET
     */
    private String promocode;

    /**
     * 字段名称: 真实姓名 .
     * 字段定义: investinfo.realName
     *
     * @ET
     */
    private String realname;

    /**
     * 字段名称: 投资项目 .
     * 字段定义: investinfo.lendproject
     *
     * @ET
     */
    private String lendproject;

    /**
     * 字段名称: 投资本金(元) .
     * 字段定义: investinfo.lendMoney
     *
     * @ET
     */
    private BigDecimal lendmoney;

    /**
     * 字段名称: 实付金额（元） .
     * 字段定义: investinfo.realMoney
     *
     * @ET
     */
    private BigDecimal realmoney;

    /**
     * 字段名称: 抵扣金额（元） .
     * 字段定义: investinfo.deductMoney
     *
     * @ET
     */
    private BigDecimal deductmoney;

    /**
     * 字段名称: 收益金额（元） .
     * 字段定义: investinfo.expectMoney
     *
     * @ET
     */
    private BigDecimal expectmoney;

    /**
     * 字段名称: 应还款金额（元） .
     * 字段定义: investinfo.repayMoney
     *
     * @ET
     */
    private BigDecimal repaymoney;

    /**
     * 字段名称: 年利率 .
     * 字段定义: investinfo.yearRate
     *
     * @ET
     */
    private Double yearrate;

    /**
     * 字段名称: 期限（月） .
     * 字段定义: investinfo.timeLimit
     *
     * @ET
     */
    private Integer timelimit;

    /**
     * 字段名称: 投资日期 .
     * 字段定义: investinfo.lendDate
     *
     * @ET
     */
    private Date lenddate;

    /**
     * 字段名称: 还款日期 .
     * 字段定义: investinfo.repayDate
     *
     * @ET
     */
    private Date repaydate;

    /**
     * 字段名称: 资金到期日期 .
     * 字段定义: investinfo.expireDate
     *
     * @ET
     */
    private Date expiredate;

    /**
     * 字段名称: 注册日期 .
     * 字段定义: investinfo.regDate
     *
     * @ET
     */
    private Date regdate;

    /**
     * 字段名称: 上一次投资日期 .
     * 字段定义: investinfo.prevInvestDate
     *
     * @ET
     */
    private Date previnvestdate;

    /**
     * 字段名称: 累计投资次数 .
     * 字段定义: investinfo.sumInvestCnt
     *
     * @ET
     */
    private Integer suminvestcnt;

    /**
     * 字段名称: 地域 .
     * 字段定义: investinfo.area
     *
     * @ET
     */
    private String area;

    /**
     * 字段名称: 性别(0：男1女） .
     * 字段定义: investinfo.sex
     *
     * @ET
     */
    private String sex;

    /**
     * 字段名称: 年龄 .
     * 字段定义: investinfo.age
     *
     * @ET
     */
    private Integer age;

    /**
     * 字段名称: 创建时间 .
     * 字段定义: investinfo.createDate
     *
     * @ET
     */
    private Date createdate;

    /**
     * 字段名称:  .
     * 字段定义: investinfo.temp1
     *
     * @ET
     */
    private String temp1;

    /**
     * 字段名称:  .
     * 字段定义: investinfo.temp2
     *
     * @ET
     */
    private String temp2;

    /**
     * 字段名称:  .
     * 字段定义: investinfo.temp3
     *
     * @ET
     */
    private String temp3;

    /**
     * 字段名称:  .
     * 字段定义: investinfo.temp4
     *
     * @ET
     */
    private String temp4;
    
    private String repayBeginTime;//还款开始时间
    private String repayEndTime;//还款结束时间
    private String lendBeginTime;//投资开始时间
    private String lendEndTime;//投资结束时间

    /**
     * This method:getId
     * investinfo.id
     *
     * @return the value of investinfo.id
     *
     * @ET
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method:setId
     *  investinfo.id
     *
     * @param id the value for investinfo.id
     *
     * @ET
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method:getLendid
     * investinfo.lendId
     *
     * @return the value of investinfo.lendId
     *
     * @ET
     */
    public Integer getLendid() {
        return lendid;
    }

    /**
     * This method:setLendid
     *  investinfo.lendId
     *
     * @param lendid the value for investinfo.lendId
     *
     * @ET
     */
    public void setLendid(Integer lendid) {
        this.lendid = lendid;
    }

    /**
     * This method:getFuyouaccount
     * investinfo.fuyouAccount
     *
     * @return the value of investinfo.fuyouAccount
     *
     * @ET
     */
    public String getFuyouaccount() {
        return fuyouaccount;
    }

    /**
     * This method:setFuyouaccount
     *  investinfo.fuyouAccount
     *
     * @param fuyouaccount the value for investinfo.fuyouAccount
     *
     * @ET
     */
    public void setFuyouaccount(String fuyouaccount) {
        this.fuyouaccount = fuyouaccount == null ? null : fuyouaccount.trim();
    }

    /**
     * This method:getUsername
     * investinfo.userName
     *
     * @return the value of investinfo.userName
     *
     * @ET
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method:setUsername
     *  investinfo.userName
     *
     * @param username the value for investinfo.userName
     *
     * @ET
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method:getPromocode
     * investinfo.PromoCode
     *
     * @return the value of investinfo.PromoCode
     *
     * @ET
     */
    public String getPromocode() {
        return promocode;
    }

    /**
     * This method:setPromocode
     *  investinfo.PromoCode
     *
     * @param promocode the value for investinfo.PromoCode
     *
     * @ET
     */
    public void setPromocode(String promocode) {
        this.promocode = promocode == null ? null : promocode.trim();
    }

    /**
     * This method:getRealname
     * investinfo.realName
     *
     * @return the value of investinfo.realName
     *
     * @ET
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method:setRealname
     *  investinfo.realName
     *
     * @param realname the value for investinfo.realName
     *
     * @ET
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method:getLendproject
     * investinfo.lendproject
     *
     * @return the value of investinfo.lendproject
     *
     * @ET
     */
    public String getLendproject() {
        return lendproject;
    }

    /**
     * This method:setLendproject
     *  investinfo.lendproject
     *
     * @param lendproject the value for investinfo.lendproject
     *
     * @ET
     */
    public void setLendproject(String lendproject) {
        this.lendproject = lendproject == null ? null : lendproject.trim();
    }

    /**
     * This method:getLendmoney
     * investinfo.lendMoney
     *
     * @return the value of investinfo.lendMoney
     *
     * @ET
     */
    public BigDecimal getLendmoney() {
        return lendmoney;
    }

    /**
     * This method:setLendmoney
     *  investinfo.lendMoney
     *
     * @param lendmoney the value for investinfo.lendMoney
     *
     * @ET
     */
    public void setLendmoney(BigDecimal lendmoney) {
        this.lendmoney = lendmoney;
    }

    /**
     * This method:getRealmoney
     * investinfo.realMoney
     *
     * @return the value of investinfo.realMoney
     *
     * @ET
     */
    public BigDecimal getRealmoney() {
        return realmoney;
    }

    /**
     * This method:setRealmoney
     *  investinfo.realMoney
     *
     * @param realmoney the value for investinfo.realMoney
     *
     * @ET
     */
    public void setRealmoney(BigDecimal realmoney) {
        this.realmoney = realmoney;
    }

    /**
     * This method:getDeductmoney
     * investinfo.deductMoney
     *
     * @return the value of investinfo.deductMoney
     *
     * @ET
     */
    public BigDecimal getDeductmoney() {
        return deductmoney;
    }

    /**
     * This method:setDeductmoney
     *  investinfo.deductMoney
     *
     * @param deductmoney the value for investinfo.deductMoney
     *
     * @ET
     */
    public void setDeductmoney(BigDecimal deductmoney) {
        this.deductmoney = deductmoney;
    }

    /**
     * This method:getExpectmoney
     * investinfo.expectMoney
     *
     * @return the value of investinfo.expectMoney
     *
     * @ET
     */
    public BigDecimal getExpectmoney() {
        return expectmoney;
    }

    /**
     * This method:setExpectmoney
     *  investinfo.expectMoney
     *
     * @param expectmoney the value for investinfo.expectMoney
     *
     * @ET
     */
    public void setExpectmoney(BigDecimal expectmoney) {
        this.expectmoney = expectmoney;
    }

    /**
     * This method:getRepaymoney
     * investinfo.repayMoney
     *
     * @return the value of investinfo.repayMoney
     *
     * @ET
     */
    public BigDecimal getRepaymoney() {
        return repaymoney;
    }

    /**
     * This method:setRepaymoney
     *  investinfo.repayMoney
     *
     * @param repaymoney the value for investinfo.repayMoney
     *
     * @ET
     */
    public void setRepaymoney(BigDecimal repaymoney) {
        this.repaymoney = repaymoney;
    }

    /**
     * This method:getYearrate
     * investinfo.yearRate
     *
     * @return the value of investinfo.yearRate
     *
     * @ET
     */
    public Double getYearrate() {
        return yearrate;
    }

    /**
     * This method:setYearrate
     *  investinfo.yearRate
     *
     * @param yearrate the value for investinfo.yearRate
     *
     * @ET
     */
    public void setYearrate(Double yearrate) {
        this.yearrate = yearrate;
    }

    /**
     * This method:getTimelimit
     * investinfo.timeLimit
     *
     * @return the value of investinfo.timeLimit
     *
     * @ET
     */
    public Integer getTimelimit() {
        return timelimit;
    }

    /**
     * This method:setTimelimit
     *  investinfo.timeLimit
     *
     * @param timelimit the value for investinfo.timeLimit
     *
     * @ET
     */
    public void setTimelimit(Integer timelimit) {
        this.timelimit = timelimit;
    }

    /**
     * This method:getLenddate
     * investinfo.lendDate
     *
     * @return the value of investinfo.lendDate
     *
     * @ET
     */
    public Date getLenddate() {
        return lenddate;
    }

    /**
     * This method:setLenddate
     *  investinfo.lendDate
     *
     * @param lenddate the value for investinfo.lendDate
     *
     * @ET
     */
    public void setLenddate(Date lenddate) {
        this.lenddate = lenddate;
    }

    /**
     * This method:getRepaydate
     * investinfo.repayDate
     *
     * @return the value of investinfo.repayDate
     *
     * @ET
     */
    public Date getRepaydate() {
        return repaydate;
    }

    /**
     * This method:setRepaydate
     *  investinfo.repayDate
     *
     * @param repaydate the value for investinfo.repayDate
     *
     * @ET
     */
    public void setRepaydate(Date repaydate) {
        this.repaydate = repaydate;
    }

    /**
     * This method:getExpiredate
     * investinfo.expireDate
     *
     * @return the value of investinfo.expireDate
     *
     * @ET
     */
    public Date getExpiredate() {
        return expiredate;
    }

    /**
     * This method:setExpiredate
     *  investinfo.expireDate
     *
     * @param expiredate the value for investinfo.expireDate
     *
     * @ET
     */
    public void setExpiredate(Date expiredate) {
        this.expiredate = expiredate;
    }

    /**
     * This method:getRegdate
     * investinfo.regDate
     *
     * @return the value of investinfo.regDate
     *
     * @ET
     */
    public Date getRegdate() {
        return regdate;
    }

    /**
     * This method:setRegdate
     *  investinfo.regDate
     *
     * @param regdate the value for investinfo.regDate
     *
     * @ET
     */
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    /**
     * This method:getPrevinvestdate
     * investinfo.prevInvestDate
     *
     * @return the value of investinfo.prevInvestDate
     *
     * @ET
     */
    public Date getPrevinvestdate() {
        return previnvestdate;
    }

    /**
     * This method:setPrevinvestdate
     *  investinfo.prevInvestDate
     *
     * @param previnvestdate the value for investinfo.prevInvestDate
     *
     * @ET
     */
    public void setPrevinvestdate(Date previnvestdate) {
        this.previnvestdate = previnvestdate;
    }

    /**
     * This method:getSuminvestcnt
     * investinfo.sumInvestCnt
     *
     * @return the value of investinfo.sumInvestCnt
     *
     * @ET
     */
    public Integer getSuminvestcnt() {
        return suminvestcnt;
    }

    /**
     * This method:setSuminvestcnt
     *  investinfo.sumInvestCnt
     *
     * @param suminvestcnt the value for investinfo.sumInvestCnt
     *
     * @ET
     */
    public void setSuminvestcnt(Integer suminvestcnt) {
        this.suminvestcnt = suminvestcnt;
    }

    /**
     * This method:getArea
     * investinfo.area
     *
     * @return the value of investinfo.area
     *
     * @ET
     */
    public String getArea() {
        return area;
    }

    /**
     * This method:setArea
     *  investinfo.area
     *
     * @param area the value for investinfo.area
     *
     * @ET
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * This method:getSex
     * investinfo.sex
     *
     * @return the value of investinfo.sex
     *
     * @ET
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method:setSex
     *  investinfo.sex
     *
     * @param sex the value for investinfo.sex
     *
     * @ET
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method:getAge
     * investinfo.age
     *
     * @return the value of investinfo.age
     *
     * @ET
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method:setAge
     *  investinfo.age
     *
     * @param age the value for investinfo.age
     *
     * @ET
     */
    public void setAge(Integer age) {
        this.age = age;
    }

	public String getRepayBeginTime()
	{
		return repayBeginTime;
	}

	public void setRepayBeginTime(String repayBeginTime)
	{
		this.repayBeginTime = repayBeginTime;
	}

	public String getRepayEndTime()
	{
		return repayEndTime;
	}

	public void setRepayEndTime(String repayEndTime)
	{
		this.repayEndTime = repayEndTime;
	}

	public String getLendBeginTime()
	{
		return lendBeginTime;
	}

	public void setLendBeginTime(String lendBeginTime)
	{
		this.lendBeginTime = lendBeginTime;
	}

	public String getLendEndTime()
	{
		return lendEndTime;
	}

	public void setLendEndTime(String lendEndTime)
	{
		this.lendEndTime = lendEndTime;
	}

	public Date getCreatedate()
	{
		return createdate;
	}

	public void setCreatedate(Date createdate)
	{
		this.createdate = createdate;
	}

	public String getTemp1()
	{
		return temp1;
	}

	public void setTemp1(String temp1)
	{
		this.temp1 = temp1;
	}

	public String getTemp2()
	{
		return temp2;
	}

	public void setTemp2(String temp2)
	{
		this.temp2 = temp2;
	}

	public String getTemp3()
	{
		return temp3;
	}

	public void setTemp3(String temp3)
	{
		this.temp3 = temp3;
	}

	public String getTemp4()
	{
		return temp4;
	}

	public void setTemp4(String temp4)
	{
		this.temp4 = temp4;
	}

}