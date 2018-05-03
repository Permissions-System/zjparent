// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) lnc 
// Source File Name:   InvestOrderAndBid.java

package com.zjgt.p2p.viewbean;

import java.math.BigDecimal;
import java.util.Date;

public class InvestOrderAndBid
{

            public InvestOrderAndBid()
            {
            }

            public String getBidtype()
            {
/*  65*/        return bidtype;
            }

            public void setBidtype(String bidtype)
            {
/*  68*/        this.bidtype = bidtype;
            }

            public Date getExptinterestdate()
            {
/*  71*/        return exptinterestdate;
            }

            public void setExptinterestdate(Date exptinterestdate)
            {
/*  74*/        this.exptinterestdate = exptinterestdate;
            }

            public Date getExptexpiredate()
            {
/*  77*/        return exptexpiredate;
            }

            public void setExptexpiredate(Date exptexpiredate)
            {
/*  80*/        this.exptexpiredate = exptexpiredate;
            }

            public BigDecimal getAnnualizedrate()
            {
/*  83*/        return annualizedrate;
            }

            public void setAnnualizedrate(BigDecimal annualizedrate)
            {
/*  86*/        this.annualizedrate = annualizedrate;
            }

            public String getBidtypeid()
            {
/*  90*/        return bidtypeid;
            }

            public void setBidtypeid(String bidtypeid)
            {
/*  93*/        this.bidtypeid = bidtypeid;
            }

            public BigDecimal getBidamount()
            {
/*  96*/        return bidamount;
            }

            public void setBidamount(BigDecimal bidamount)
            {
/*  99*/        this.bidamount = bidamount;
            }

            public BigDecimal getBidnum()
            {
/* 102*/        return bidnum;
            }

            public void setBidnum(BigDecimal bidnum)
            {
/* 105*/        this.bidnum = bidnum;
            }

            public String getOrderstatusdesc()
            {
/* 108*/        return orderstatusdesc;
            }

            public void setOrderstatusdesc(String orderstatusdesc)
            {
/* 111*/        this.orderstatusdesc = orderstatusdesc;
            }

            public BigDecimal getRedeemfee()
            {
/* 114*/        return redeemfee;
            }

            public void setRedeemfee(BigDecimal redeemfee)
            {
/* 117*/        this.redeemfee = redeemfee;
            }

            public long getBidid()
            {
/* 121*/        return bidid;
            }

            public void setBidid(long bidid)
            {
/* 124*/        this.bidid = bidid;
            }

            public long getInvestorderid()
            {
/* 127*/        return investorderid;
            }

            public void setInvestorderid(long investorderid)
            {
/* 130*/        this.investorderid = investorderid;
            }

            public String getInvestordercode()
            {
/* 133*/        return investordercode;
            }

            public void setInvestordercode(String investordercode)
            {
/* 136*/        this.investordercode = investordercode;
            }

            public Date getOrderdate()
            {
/* 139*/        return orderdate;
            }

            public void setOrderdate(Date orderdate)
            {
/* 142*/        this.orderdate = orderdate;
            }

            public Date getRaisebegindate()
            {
/* 145*/        return raisebegindate;
            }

            public void setRaisebegindate(Date raisebegindate)
            {
/* 148*/        this.raisebegindate = raisebegindate;
            }

            public Date getRaiseenddate()
            {
/* 151*/        return raiseenddate;
            }

            public void setRaiseenddate(Date raiseenddate)
            {
/* 154*/        this.raiseenddate = raiseenddate;
            }

            public String getBidclassname()
            {
/* 157*/        return bidclassname;
            }

            public void setBidclassname(String bidclassname)
            {
/* 160*/        this.bidclassname = bidclassname;
            }

            public int getTimeofinvest()
            {
/* 163*/        return timeofinvest;
            }

            public void setTimeofinvest(int timeofinvest)
            {
/* 166*/        this.timeofinvest = timeofinvest;
            }

            public BigDecimal getAmount()
            {
/* 169*/        return amount;
            }

            public void setAmount(BigDecimal amount)
            {
/* 172*/        this.amount = amount;
            }

            public BigDecimal getIncome()
            {
/* 175*/        return income;
            }

            public void setIncome(BigDecimal income)
            {
/* 178*/        this.income = income;
            }

            public int getOrderstatus()
            {
/* 181*/        return orderstatus;
            }

            public void setOrderstatus(int orderstatus)
            {
/* 184*/        this.orderstatus = orderstatus;
            }

            public int getTransStatus()
            {
/* 187*/        return transStatus;
            }

            public void setTransStatus(int transStatus)
            {
/* 190*/        this.transStatus = transStatus;
            }

            public String getBidcode()
            {
/* 193*/        return bidcode;
            }

            public void setBidcode(String bidcode)
            {
/* 196*/        this.bidcode = bidcode;
            }

            private long bidid;
            private String bidcode;
            private BigDecimal bidamount;
            private BigDecimal annualizedrate;
            private BigDecimal bidnum;
            private long investorderid;
            private String investordercode;
            private Date orderdate;
            private Date raisebegindate;
            private Date raiseenddate;
            private String bidclassname;
            private int timeofinvest;
            private BigDecimal amount;
            private BigDecimal income;
            private int orderstatus;
            private int transStatus;
            private BigDecimal redeemfee;
            private String orderstatusdesc;
            private String bidtypeid;
            private Date exptinterestdate;
            private Date exptexpiredate;
            private String bidtype;
}
