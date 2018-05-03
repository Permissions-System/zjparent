package com.zjgt.p2p.manage.excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: lendInfoModel 
 * @Description: TODO
 * @author: kaiyun
 * @date: 2016年5月31日 下午6:24:29
 */
public class LendInfoModel {
	
	private String username;//用户名
	private String mobile;//用户手机号
	private String temp1;//注册时间
	private String temp4;//投资项目
	private int dateline;//项目周期（月）
	private int incomecount;//项目周期（天）
	private Date lenddate;//投资时间
	private BigDecimal lendmoney;//投资金额
	
	public LendInfoModel()
	{
		super();
	}

	public LendInfoModel(String username, String mobile, String temp1,
			String temp4, int dateline, int incomecount, Date lenddate,
			BigDecimal lendmoney)
	{
		super();
		this.username = username;
		this.mobile = mobile;
		this.temp1 = temp1;
		this.temp4 = temp4;
		this.dateline = dateline;
		this.incomecount = incomecount;
		this.lenddate = lenddate;
		this.lendmoney = lendmoney;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getTemp1()
	{
		return temp1;
	}

	public void setTemp1(String temp1)
	{
		this.temp1 = temp1;
	}

	public String getTemp4()
	{
		return temp4;
	}

	public void setTemp4(String temp4)
	{
		this.temp4 = temp4;
	}

	public int getDateline()
	{
		return dateline;
	}

	public void setDateline(int dateline)
	{
		this.dateline = dateline;
	}

	public int getIncomecount()
	{
		return incomecount;
	}

	public void setIncomecount(int incomecount)
	{
		this.incomecount = incomecount;
	}

	public Date getLenddate()
	{
		return lenddate;
	}

	public void setLenddate(Date lenddate)
	{
		this.lenddate = lenddate;
	}

	public BigDecimal getLendmoney()
	{
		return lendmoney;
	}

	public void setLendmoney(BigDecimal lendmoney)
	{
		this.lendmoney = lendmoney;
	}
	
	
	

}
