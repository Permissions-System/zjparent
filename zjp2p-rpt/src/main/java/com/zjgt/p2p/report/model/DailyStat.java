package com.zjgt.p2p.report.model;

import java.util.Date;

public class DailyStat {
	/**
     * 字段名称:  .
     * 字段定义: dailystat.id
     *
     * @ET
     */
    private Integer id;

    /**
     * 字段名称: 当前日期 .
     * 字段定义: dailystat.currentDate
     *
     * @ET
     */
    private Date currentdate;

    /**
     * 字段名称: 注册人数 .
     * 字段定义: dailystat.regcnt
     *
     * @ET
     */
    private Integer regcnt;

    /**
     * 字段名称: 登录人数 .
     * 字段定义: dailystat.logincnt
     *
     * @ET
     */
    private Integer logincnt;

    /**
     * 字段名称: 登录人次 .
     * 字段定义: dailystat.logintime
     *
     * @ET
     */
    private Integer logintime;

    /**
     * 字段名称: 老客户登录人数 .
     * 字段定义: dailystat.customersLogincnt
     *
     * @ET
     */
    private Integer customerslogincnt;

    /**
     * 字段名称: 老客户登录人次 .
     * 字段定义: dailystat.customersLogintime
     *
     * @ET
     */
    private Integer customerslogintime;

    /**
     * 字段名称: 开户人数 .
     * 字段定义: dailystat.openActNum
     *
     * @ET
     */
    private Integer openactnum;

    /**
     * 字段名称: 平台充值笔数 .
     * 字段定义: dailystat.platformRechargeNum
     *
     * @ET
     */
    private Integer platformrechargenum;

    /**
     * 字段名称: 平台充值人数 .
     * 字段定义: dailystat.platformRechargePerNum
     *
     * @ET
     */
    private Integer platformrechargepernum;

    /**
     * 字段名称: 平台充值金额 .
     * 字段定义: dailystat.platformRechargeAmount
     *
     * @ET
     */
    private Double platformrechargeamount;

    /**
     * 字段名称: 富友充值笔数 .
     * 字段定义: dailystat.fuyouRechargeNum
     *
     * @ET
     */
    private Integer fuyourechargenum;

    /**
     * 字段名称: 富友充值人数 .
     * 字段定义: dailystat.fuyouRechargePerNum
     *
     * @ET
     */
    private Integer fuyourechargepernum;

    /**
     * 字段名称: 富友充值金额 .
     * 字段定义: dailystat.fuyouRechargeAmount
     *
     * @ET
     */
    private Double fuyourechargeamount;

    /**
     * 字段名称: 投资笔数 .
     * 字段定义: dailystat.investNum
     *
     * @ET
     */
    private Integer investnum;

    /**
     * 字段名称: 投资人数 .
     * 字段定义: dailystat.investPerNum
     *
     * @ET
     */
    private Integer investpernum;

    /**
     * 字段名称: 投资金额 .
     * 字段定义: dailystat.investAmount
     *
     * @ET
     */
    private Double investamount;

    /**
     * 字段名称: 首次投资人数 .
     * 字段定义: dailystat.firstInvestPerNum
     *
     * @ET
     */
    private Integer firstinvestpernum;

    /**
     * 字段名称: 首次投资金额 .
     * 字段定义: dailystat.firstInvestAmount
     *
     * @ET
     */
    private Double firstinvestamount;

    /**
     * 字段名称: 平台提现笔数 .
     * 字段定义: dailystat.platformWithdrawNum
     *
     * @ET
     */
    private Integer platformwithdrawnum;

    /**
     * 字段名称: 平台提现人数 .
     * 字段定义: dailystat.platformWithdrawPerNumber
     *
     * @ET
     */
    private Integer platformwithdrawpernumber;

    /**
     * 字段名称: 平台提现金额 .
     * 字段定义: dailystat.platformWithdrawAmount
     *
     * @ET
     */
    private Double platformwithdrawamount;

    /**
     * 字段名称: 富友提现笔数 .
     * 字段定义: dailystat.fuyouWithdrawNum
     *
     * @ET
     */
    private Integer fuyouwithdrawnum;

    /**
     * 字段名称: 富友提现金额 .
     * 字段定义: dailystat.fuyouWithdrawPerNumber
     *
     * @ET
     */
    private Integer fuyouwithdrawpernumber;

    /**
     * 字段名称: 富友提现金额 .
     * 字段定义: dailystat.fuyouWithdrawAmount
     *
     * @ET
     */
    private Double fuyouwithdrawamount;

    /**
     * 字段名称: 备注 .
     * 字段定义: dailystat.remark
     *
     * @ET
     */
    private String remark;

    /**
     * 字段名称: 创建时间 .
     * 字段定义: dailystat.createDate
     *
     * @ET
     */
    private Date createdate;

    /**
     * 字段名称:  .
     * 字段定义: dailystat.temp1
     *
     * @ET
     */
    private String temp1;

    /**
     * 字段名称:  .
     * 字段定义: dailystat.temp2
     *
     * @ET
     */
    private String temp2;

    /**
     * 字段名称:  .
     * 字段定义: dailystat.temp3
     *
     * @ET
     */
    private String temp3;

    /**
     * 字段名称:  .
     * 字段定义: dailystat.temp4
     *
     * @ET
     */
    private String temp4;
    
    private String yearStr;
    private String monthStr;
    private String beginTime;
    private String endTime;
    
    private String TimeName;
    private double avgAmt;
    
    
    private Double avgInvestpernum;
    private Double avgInvestnum;
    private int avgInves;
    
    
	public Double getAvgInvestpernum() {
		return avgInvestpernum;
	}

	public void setAvgInvestpernum(Double avgInvestpernum) {
		this.avgInvestpernum = avgInvestpernum;
	}

	public Double getAvgInvestnum() {
		return avgInvestnum;
	}

	public void setAvgInvestnum(Double avgInvestnum) {
		this.avgInvestnum = avgInvestnum;
	}

	public int getAvgInves() {
		return avgInves;
	}

	public void setAvgInves(int avgInves) {
		this.avgInves = avgInves;
	}

	public String getTimeName() {
		return TimeName;
	}

	public void setTimeName(String timeName) {
		TimeName = timeName;
	}

	public double getAvgAmt() {
		return avgAmt;
	}

	public void setAvgAmt(double avgAmt) {
		this.avgAmt = avgAmt;
	}

	public String getYearStr()
	{
		return yearStr;
	}

	public void setYearStr(String yearStr)
	{
		this.yearStr = yearStr;
	}

	public String getMonthStr()
	{
		return monthStr;
	}

	public void setMonthStr(String monthStr)
	{
		this.monthStr = monthStr;
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

	/**
     * This method:getId
     * dailystat.id
     *
     * @return the value of dailystat.id
     *
     * @ET
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method:setId
     *  dailystat.id
     *
     * @param id the value for dailystat.id
     *
     * @ET
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method:getCurrentdate
     * dailystat.currentDate
     *
     * @return the value of dailystat.currentDate
     *
     * @ET
     */
    public Date getCurrentdate() {
        return currentdate;
    }

    /**
     * This method:setCurrentdate
     *  dailystat.currentDate
     *
     * @param currentdate the value for dailystat.currentDate
     *
     * @ET
     */
    public void setCurrentdate(Date currentdate) {
        this.currentdate = currentdate;
    }

    /**
     * This method:getRegcnt
     * dailystat.regcnt
     *
     * @return the value of dailystat.regcnt
     *
     * @ET
     */
    public Integer getRegcnt() {
        return regcnt;
    }

    /**
     * This method:setRegcnt
     *  dailystat.regcnt
     *
     * @param regcnt the value for dailystat.regcnt
     *
     * @ET
     */
    public void setRegcnt(Integer regcnt) {
        this.regcnt = regcnt;
    }

    /**
     * This method:getLogincnt
     * dailystat.logincnt
     *
     * @return the value of dailystat.logincnt
     *
     * @ET
     */
    public Integer getLogincnt() {
        return logincnt;
    }

    /**
     * This method:setLogincnt
     *  dailystat.logincnt
     *
     * @param logincnt the value for dailystat.logincnt
     *
     * @ET
     */
    public void setLogincnt(Integer logincnt) {
        this.logincnt = logincnt;
    }

    /**
     * This method:getLogintime
     * dailystat.logintime
     *
     * @return the value of dailystat.logintime
     *
     * @ET
     */
    public Integer getLogintime() {
        return logintime;
    }

    /**
     * This method:setLogintime
     *  dailystat.logintime
     *
     * @param logintime the value for dailystat.logintime
     *
     * @ET
     */
    public void setLogintime(Integer logintime) {
        this.logintime = logintime;
    }

    /**
     * This method:getCustomerslogincnt
     * dailystat.customersLogincnt
     *
     * @return the value of dailystat.customersLogincnt
     *
     * @ET
     */
    public Integer getCustomerslogincnt() {
        return customerslogincnt;
    }

    /**
     * This method:setCustomerslogincnt
     *  dailystat.customersLogincnt
     *
     * @param customerslogincnt the value for dailystat.customersLogincnt
     *
     * @ET
     */
    public void setCustomerslogincnt(Integer customerslogincnt) {
        this.customerslogincnt = customerslogincnt;
    }

    /**
     * This method:getCustomerslogintime
     * dailystat.customersLogintime
     *
     * @return the value of dailystat.customersLogintime
     *
     * @ET
     */
    public Integer getCustomerslogintime() {
        return customerslogintime;
    }

    /**
     * This method:setCustomerslogintime
     *  dailystat.customersLogintime
     *
     * @param customerslogintime the value for dailystat.customersLogintime
     *
     * @ET
     */
    public void setCustomerslogintime(Integer customerslogintime) {
        this.customerslogintime = customerslogintime;
    }

    /**
     * This method:getOpenactnum
     * dailystat.openActNum
     *
     * @return the value of dailystat.openActNum
     *
     * @ET
     */
    public Integer getOpenactnum() {
        return openactnum;
    }

    /**
     * This method:setOpenactnum
     *  dailystat.openActNum
     *
     * @param openactnum the value for dailystat.openActNum
     *
     * @ET
     */
    public void setOpenactnum(Integer openactnum) {
        this.openactnum = openactnum;
    }

    /**
     * This method:getPlatformrechargenum
     * dailystat.platformRechargeNum
     *
     * @return the value of dailystat.platformRechargeNum
     *
     * @ET
     */
    public Integer getPlatformrechargenum() {
        return platformrechargenum;
    }

    /**
     * This method:setPlatformrechargenum
     *  dailystat.platformRechargeNum
     *
     * @param platformrechargenum the value for dailystat.platformRechargeNum
     *
     * @ET
     */
    public void setPlatformrechargenum(Integer platformrechargenum) {
        this.platformrechargenum = platformrechargenum;
    }

    /**
     * This method:getPlatformrechargepernum
     * dailystat.platformRechargePerNum
     *
     * @return the value of dailystat.platformRechargePerNum
     *
     * @ET
     */
    public Integer getPlatformrechargepernum() {
        return platformrechargepernum;
    }

    /**
     * This method:setPlatformrechargepernum
     *  dailystat.platformRechargePerNum
     *
     * @param platformrechargepernum the value for dailystat.platformRechargePerNum
     *
     * @ET
     */
    public void setPlatformrechargepernum(Integer platformrechargepernum) {
        this.platformrechargepernum = platformrechargepernum;
    }

    /**
     * This method:getPlatformrechargeamount
     * dailystat.platformRechargeAmount
     *
     * @return the value of dailystat.platformRechargeAmount
     *
     * @ET
     */
    public Double getPlatformrechargeamount() {
        return platformrechargeamount;
    }

    /**
     * This method:setPlatformrechargeamount
     *  dailystat.platformRechargeAmount
     *
     * @param platformrechargeamount the value for dailystat.platformRechargeAmount
     *
     * @ET
     */
    public void setPlatformrechargeamount(Double platformrechargeamount) {
        this.platformrechargeamount = platformrechargeamount;
    }

    /**
     * This method:getFuyourechargenum
     * dailystat.fuyouRechargeNum
     *
     * @return the value of dailystat.fuyouRechargeNum
     *
     * @ET
     */
    public Integer getFuyourechargenum() {
        return fuyourechargenum;
    }

    /**
     * This method:setFuyourechargenum
     *  dailystat.fuyouRechargeNum
     *
     * @param fuyourechargenum the value for dailystat.fuyouRechargeNum
     *
     * @ET
     */
    public void setFuyourechargenum(Integer fuyourechargenum) {
        this.fuyourechargenum = fuyourechargenum;
    }

    /**
     * This method:getFuyourechargepernum
     * dailystat.fuyouRechargePerNum
     *
     * @return the value of dailystat.fuyouRechargePerNum
     *
     * @ET
     */
    public Integer getFuyourechargepernum() {
        return fuyourechargepernum;
    }

    /**
     * This method:setFuyourechargepernum
     *  dailystat.fuyouRechargePerNum
     *
     * @param fuyourechargepernum the value for dailystat.fuyouRechargePerNum
     *
     * @ET
     */
    public void setFuyourechargepernum(Integer fuyourechargepernum) {
        this.fuyourechargepernum = fuyourechargepernum;
    }

    /**
     * This method:getFuyourechargeamount
     * dailystat.fuyouRechargeAmount
     *
     * @return the value of dailystat.fuyouRechargeAmount
     *
     * @ET
     */
    public Double getFuyourechargeamount() {
        return fuyourechargeamount;
    }

    /**
     * This method:setFuyourechargeamount
     *  dailystat.fuyouRechargeAmount
     *
     * @param fuyourechargeamount the value for dailystat.fuyouRechargeAmount
     *
     * @ET
     */
    public void setFuyourechargeamount(Double fuyourechargeamount) {
        this.fuyourechargeamount = fuyourechargeamount;
    }

    /**
     * This method:getInvestnum
     * dailystat.investNum
     *
     * @return the value of dailystat.investNum
     *
     * @ET
     */
    public Integer getInvestnum() {
        return investnum;
    }

    /**
     * This method:setInvestnum
     *  dailystat.investNum
     *
     * @param investnum the value for dailystat.investNum
     *
     * @ET
     */
    public void setInvestnum(Integer investnum) {
        this.investnum = investnum;
    }

    /**
     * This method:getInvestpernum
     * dailystat.investPerNum
     *
     * @return the value of dailystat.investPerNum
     *
     * @ET
     */
    public Integer getInvestpernum() {
        return investpernum;
    }

    /**
     * This method:setInvestpernum
     *  dailystat.investPerNum
     *
     * @param investpernum the value for dailystat.investPerNum
     *
     * @ET
     */
    public void setInvestpernum(Integer investpernum) {
        this.investpernum = investpernum;
    }

    /**
     * This method:getInvestamount
     * dailystat.investAmount
     *
     * @return the value of dailystat.investAmount
     *
     * @ET
     */
    public Double getInvestamount() {
        return investamount;
    }

    /**
     * This method:setInvestamount
     *  dailystat.investAmount
     *
     * @param investamount the value for dailystat.investAmount
     *
     * @ET
     */
    public void setInvestamount(Double investamount) {
        this.investamount = investamount;
    }

    /**
     * This method:getFirstinvestpernum
     * dailystat.firstInvestPerNum
     *
     * @return the value of dailystat.firstInvestPerNum
     *
     * @ET
     */
    public Integer getFirstinvestpernum() {
        return firstinvestpernum;
    }

    /**
     * This method:setFirstinvestpernum
     *  dailystat.firstInvestPerNum
     *
     * @param firstinvestpernum the value for dailystat.firstInvestPerNum
     *
     * @ET
     */
    public void setFirstinvestpernum(Integer firstinvestpernum) {
        this.firstinvestpernum = firstinvestpernum;
    }

    /**
     * This method:getFirstinvestamount
     * dailystat.firstInvestAmount
     *
     * @return the value of dailystat.firstInvestAmount
     *
     * @ET
     */
    public Double getFirstinvestamount() {
        return firstinvestamount;
    }

    /**
     * This method:setFirstinvestamount
     *  dailystat.firstInvestAmount
     *
     * @param firstinvestamount the value for dailystat.firstInvestAmount
     *
     * @ET
     */
    public void setFirstinvestamount(Double firstinvestamount) {
        this.firstinvestamount = firstinvestamount;
    }

    /**
     * This method:getPlatformwithdrawnum
     * dailystat.platformWithdrawNum
     *
     * @return the value of dailystat.platformWithdrawNum
     *
     * @ET
     */
    public Integer getPlatformwithdrawnum() {
        return platformwithdrawnum;
    }

    /**
     * This method:setPlatformwithdrawnum
     *  dailystat.platformWithdrawNum
     *
     * @param platformwithdrawnum the value for dailystat.platformWithdrawNum
     *
     * @ET
     */
    public void setPlatformwithdrawnum(Integer platformwithdrawnum) {
        this.platformwithdrawnum = platformwithdrawnum;
    }

    /**
     * This method:getPlatformwithdrawpernumber
     * dailystat.platformWithdrawPerNumber
     *
     * @return the value of dailystat.platformWithdrawPerNumber
     *
     * @ET
     */
    public Integer getPlatformwithdrawpernumber() {
        return platformwithdrawpernumber;
    }

    /**
     * This method:setPlatformwithdrawpernumber
     *  dailystat.platformWithdrawPerNumber
     *
     * @param platformwithdrawpernumber the value for dailystat.platformWithdrawPerNumber
     *
     * @ET
     */
    public void setPlatformwithdrawpernumber(Integer platformwithdrawpernumber) {
        this.platformwithdrawpernumber = platformwithdrawpernumber;
    }

    /**
     * This method:getPlatformwithdrawamount
     * dailystat.platformWithdrawAmount
     *
     * @return the value of dailystat.platformWithdrawAmount
     *
     * @ET
     */
    public double getPlatformwithdrawamount() {
        return platformwithdrawamount;
    }

    /**
     * This method:setPlatformwithdrawamount
     *  dailystat.platformWithdrawAmount
     *
     * @param platformwithdrawamount the value for dailystat.platformWithdrawAmount
     *
     * @ET
     */
    public void setPlatformwithdrawamount(Double platformwithdrawamount) {
        this.platformwithdrawamount = platformwithdrawamount;
    }

    /**
     * This method:getFuyouwithdrawnum
     * dailystat.fuyouWithdrawNum
     *
     * @return the value of dailystat.fuyouWithdrawNum
     *
     * @ET
     */
    public Integer getFuyouwithdrawnum() {
        return fuyouwithdrawnum;
    }

    /**
     * This method:setFuyouwithdrawnum
     *  dailystat.fuyouWithdrawNum
     *
     * @param fuyouwithdrawnum the value for dailystat.fuyouWithdrawNum
     *
     * @ET
     */
    public void setFuyouwithdrawnum(Integer fuyouwithdrawnum) {
        this.fuyouwithdrawnum = fuyouwithdrawnum;
    }

    /**
     * This method:getFuyouwithdrawpernumber
     * dailystat.fuyouWithdrawPerNumber
     *
     * @return the value of dailystat.fuyouWithdrawPerNumber
     *
     * @ET
     */
    public Integer getFuyouwithdrawpernumber() {
        return fuyouwithdrawpernumber;
    }

    /**
     * This method:setFuyouwithdrawpernumber
     *  dailystat.fuyouWithdrawPerNumber
     *
     * @param fuyouwithdrawpernumber the value for dailystat.fuyouWithdrawPerNumber
     *
     * @ET
     */
    public void setFuyouwithdrawpernumber(Integer fuyouwithdrawpernumber) {
        this.fuyouwithdrawpernumber = fuyouwithdrawpernumber;
    }

    /**
     * This method:getFuyouwithdrawamount
     * dailystat.fuyouWithdrawAmount
     *
     * @return the value of dailystat.fuyouWithdrawAmount
     *
     * @ET
     */
    public Double getFuyouwithdrawamount() {
        return fuyouwithdrawamount;
    }

    /**
     * This method:setFuyouwithdrawamount
     *  dailystat.fuyouWithdrawAmount
     *
     * @param fuyouwithdrawamount the value for dailystat.fuyouWithdrawAmount
     *
     * @ET
     */
    public void setFuyouwithdrawamount(Double fuyouwithdrawamount) {
        this.fuyouwithdrawamount = fuyouwithdrawamount;
    }

    /**
     * This method:getRemark
     * dailystat.remark
     *
     * @return the value of dailystat.remark
     *
     * @ET
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method:setRemark
     *  dailystat.remark
     *
     * @param remark the value for dailystat.remark
     *
     * @ET
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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