package com.zjgt.p2p.report.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CpsStat {
	/**
     * 字段名称: 编号 .
     * 字段定义: cpsstat.id
     *
     * @ET
     */
    private Integer id;

    /**
     * 字段名称: 日期 .
     * 字段定义: cpsstat.curDate
     *
     * @ET
     */
    private Date curdate;

    /**
     * 字段名称: 渠道编号 .
     * 字段定义: cpsstat.cpscode
     *
     * @ET
     */
    private String cpscode;

    /**
     * 字段名称: 渠道名称 .
     * 字段定义: cpsstat.cpsname
     *
     * @ET
     */
    private String cpsname;

    /**
     * 字段名称: 注册数 .
     * 字段定义: cpsstat.regcnt
     *
     * @ET
     */
    private Integer regcnt;

    /**
     * 字段名称: 开户数 .
     * 字段定义: cpsstat.openaccnt
     *
     * @ET
     */
    private Integer openaccnt;

    /**
     * 字段名称: 投资金额 .
     * 字段定义: cpsstat.investamount
     *
     * @ET
     */
    private Double investamount;

    /**
     * 字段名称: 投资人数 .
     * 字段定义: cpsstat.investcnt
     *
     * @ET
     */
    private Integer investcnt;

    /**
     * 字段名称: 人均投资额 .
     * 字段定义: cpsstat.avginvestamount
     *
     * @ET
     */
    private Double avginvestamount;

    /**
     * 字段名称: 投资转化率 .
     * 字段定义: cpsstat.investrate
     *
     * @ET
     */
    private BigDecimal investrate;

    /**
     * 字段名称: 备注 .
     * 字段定义: cpsstat.remark
     *
     * @ET
     */
    private String remark;

    /**
     * 字段名称: 创建时间 .
     * 字段定义: cpsstat.createDate
     *
     * @ET
     */
    private Date createdate;

    /**
     * 字段名称:  .
     * 字段定义: cpsstat.temp1
     *
     * @ET
     */
    private String temp1;

    /**
     * 字段名称:  .
     * 字段定义: cpsstat.temp2
     *
     * @ET
     */
    private String temp2;

    /**
     * 字段名称:  .
     * 字段定义: cpsstat.temp3
     *
     * @ET
     */
    private String temp3;

    /**
     * 字段名称:  .
     * 字段定义: cpsstat.temp4
     *
     * @ET
     */
    private String temp4;
    
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

	/**
     * This method:getId
     * cpsstat.id
     *
     * @return the value of cpsstat.id
     *
     * @ET
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method:setId
     *  cpsstat.id
     *
     * @param id the value for cpsstat.id
     *
     * @ET
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method:getCurdate
     * cpsstat.curDate
     *
     * @return the value of cpsstat.curDate
     *
     * @ET
     */
    public Date getCurdate() {
        return curdate;
    }

    /**
     * This method:setCurdate
     *  cpsstat.curDate
     *
     * @param curdate the value for cpsstat.curDate
     *
     * @ET
     */
    public void setCurdate(Date curdate) {
        this.curdate = curdate;
    }

    /**
     * This method:getCpscode
     * cpsstat.cpscode
     *
     * @return the value of cpsstat.cpscode
     *
     * @ET
     */
    public String getCpscode() {
        return cpscode;
    }

    /**
     * This method:setCpscode
     *  cpsstat.cpscode
     *
     * @param cpscode the value for cpsstat.cpscode
     *
     * @ET
     */
    public void setCpscode(String cpscode) {
        this.cpscode = cpscode == null ? null : cpscode.trim();
    }

    /**
     * This method:getCpsname
     * cpsstat.cpsname
     *
     * @return the value of cpsstat.cpsname
     *
     * @ET
     */
    public String getCpsname() {
        return cpsname;
    }

    /**
     * This method:setCpsname
     *  cpsstat.cpsname
     *
     * @param cpsname the value for cpsstat.cpsname
     *
     * @ET
     */
    public void setCpsname(String cpsname) {
        this.cpsname = cpsname == null ? null : cpsname.trim();
    }

    /**
     * This method:getRegcnt
     * cpsstat.regcnt
     *
     * @return the value of cpsstat.regcnt
     *
     * @ET
     */
    public Integer getRegcnt() {
        return regcnt;
    }

    /**
     * This method:setRegcnt
     *  cpsstat.regcnt
     *
     * @param regcnt the value for cpsstat.regcnt
     *
     * @ET
     */
    public void setRegcnt(Integer regcnt) {
        this.regcnt = regcnt;
    }

    /**
     * This method:getOpenaccnt
     * cpsstat.openaccnt
     *
     * @return the value of cpsstat.openaccnt
     *
     * @ET
     */
    public Integer getOpenaccnt() {
        return openaccnt;
    }

    /**
     * This method:setOpenaccnt
     *  cpsstat.openaccnt
     *
     * @param openaccnt the value for cpsstat.openaccnt
     *
     * @ET
     */
    public void setOpenaccnt(Integer openaccnt) {
        this.openaccnt = openaccnt;
    }

    /**
     * This method:getInvestamount
     * cpsstat.investamount
     *
     * @return the value of cpsstat.investamount
     *
     * @ET
     */
    public Double getInvestamount() {
        return investamount;
    }

    /**
     * This method:setInvestamount
     *  cpsstat.investamount
     *
     * @param investamount the value for cpsstat.investamount
     *
     * @ET
     */
    public void setInvestamount(Double investamount) {
        this.investamount = investamount;
    }

    /**
     * This method:getInvestcnt
     * cpsstat.investcnt
     *
     * @return the value of cpsstat.investcnt
     *
     * @ET
     */
    public Integer getInvestcnt() {
        return investcnt;
    }

    /**
     * This method:setInvestcnt
     *  cpsstat.investcnt
     *
     * @param investcnt the value for cpsstat.investcnt
     *
     * @ET
     */
    public void setInvestcnt(Integer investcnt) {
        this.investcnt = investcnt;
    }

    /**
     * This method:getAvginvestamount
     * cpsstat.avginvestamount
     *
     * @return the value of cpsstat.avginvestamount
     *
     * @ET
     */
    public Double getAvginvestamount() {
        return avginvestamount;
    }

    /**
     * This method:setAvginvestamount
     *  cpsstat.avginvestamount
     *
     * @param avginvestamount the value for cpsstat.avginvestamount
     *
     * @ET
     */
    public void setAvginvestamount(Double avginvestamount) {
        this.avginvestamount = avginvestamount;
    }

    /**
     * This method:getInvestrate
     * cpsstat.investrate
     *
     * @return the value of cpsstat.investrate
     *
     * @ET
     */
    public BigDecimal getInvestrate() {
        return investrate;
    }

    /**
     * This method:setInvestrate
     *  cpsstat.investrate
     *
     * @param investrate the value for cpsstat.investrate
     *
     * @ET
     */
    public void setInvestrate(BigDecimal investrate) {
        this.investrate = investrate;
    }

    /**
     * This method:getRemark
     * cpsstat.remark
     *
     * @return the value of cpsstat.remark
     *
     * @ET
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method:setRemark
     *  cpsstat.remark
     *
     * @param remark the value for cpsstat.remark
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